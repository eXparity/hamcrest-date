package org.exparity.hamcrest.localdate;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is within a defined period of the
 * reference date
 * 
 * @author Stewart Bissett
 */
public class IsWithin extends AbstractLocalDateMatcher {

	private final long period;
	private final ChronoUnit unit;
	private final LocalDate expected;

	public IsWithin(final long period, final ChronoUnit unit, final LocalDate expected) {
		this.period = period;
		this.unit = unit;
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(final LocalDate actual, final Description mismatchDesc) {
		if (unit.isTimeBased()) {
			return matchesDurationSafely(actual, mismatchDesc);
		} else {
			return matchesPeriodSafely(actual, mismatchDesc);
		}
	}

	private boolean matchesPeriodSafely(final LocalDate actual, final Description mismatchDesc) {
		long actualPeriod = Math.abs(Period.between(expected, actual).get(unit));
		if (actualPeriod > period) {
			mismatchDesc.appendText("date is " + formatDate(actual)
					+ " and "
					+ actualPeriod
					+ " "
					+ describeUnit()
					+ " different");
			return false;
		} else {
			return true;
		}
	}

	private boolean matchesDurationSafely(final LocalDate actual, final Description mismatchDesc) {
		long actualDuration = Math.abs(Duration.between(expected.atStartOfDay(), actual.atStartOfDay()).get(unit));
		if (actualDuration > period) {
			mismatchDesc.appendText("date is " + formatDate(actual)
					+ " and "
					+ actualDuration
					+ " "
					+ describeUnit()
					+ " different");
			return false;
		} else {
			return true;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the date is within " + period + " " + describeUnit() + " of " + formatDate(expected));
	}

	private String describeUnit() {
		return unit.toString().toLowerCase();
	}

}