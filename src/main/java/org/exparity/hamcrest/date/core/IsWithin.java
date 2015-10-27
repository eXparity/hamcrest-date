package org.exparity.hamcrest.date.core;

import java.time.temporal.ChronoUnit;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is within a defined period of the
 * reference date
 *
 * @author Stewart Bissett
 */
public class IsWithin<T> extends TypeSafeDiagnosingMatcher<T> {

	private final long period;
	private final ChronoUnit unit;
	private final TemporalWrapper<T> expected;
	private final TemporalFormatter<T> describer;

	public IsWithin(final long period, final ChronoUnit unit, final TemporalWrapper<T> expected, final TemporalFormatter<T> describer) {
		this.period = period;
		this.unit = unit;
		this.expected = expected;
		this.describer = describer;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
		long actualDuration = expected.difference(actual, unit);
		if (actualDuration > period) {
			mismatchDesc.appendText("date is " + describer.describe(actual)
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

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date is within " + period + " " + describeUnit() + " of " + describer.describe(expected.unwrap()));
	}

	private String describeUnit() {
		return unit.toString().toLowerCase();
	}

}