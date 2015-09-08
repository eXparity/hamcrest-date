package org.exparity.hamcrest.date.core;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is within a defined period of the
 * reference date
 * 
 * @author Stewart Bissett
 */
public class IsWithin<T extends Temporal> extends TypeSafeDiagnosingMatcher<T> {

	private final long period;
	private final ChronoUnit unit;
	private final T expected;

	public IsWithin(final long period, final ChronoUnit unit, final T expected) {
		this.period = period;
		this.unit = unit;
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
		long actualDuration = Math.abs(expected.until(actual, unit));
		if (actualDuration > period) {
			mismatchDesc.appendText("date is " + expected.toString()
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
		description.appendText("the date is within " + period + " " + describeUnit() + " of " + expected.toString());
	}

	private String describeUnit() {
		return unit.toString().toLowerCase();
	}

}