package org.exparity.hamcrest.date.core;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is within a defined period of the
 * reference date
 *
 * @author Stewart Bissett
 */
public class IsWithin<T, U, Z> extends ZonedTemporalMatcher<T, Z> {

	private final long period;
	private final U unit;
	private final TemporalWrapper<T, U, Z> expected;
	private final TemporalFormatter<T> describer;

	public IsWithin(final long period, final U unit, final TemporalWrapper<T, U, Z> expected, final TemporalFormatter<T> describer) {
		this.period = period;
		this.unit = unit;
		this.expected = expected;
		this.describer = describer;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
		long actualDuration = this.expected.difference(actual, this.unit);
		if (actualDuration > this.period) {
			mismatchDesc.appendText("the date is " + this.describer.describe(actual)
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
		description.appendText("the date is within " + this.period + " " + describeUnit() + " of " + this.describer.describe(this.expected.unwrap()));
	}

	private String describeUnit() {
		return this.unit.toString().toLowerCase();
	}

	@Override
	public ZonedTemporalMatcher<T, Z> atZone(Z zone) {
		return new IsWithin<>(period, unit, expected.withZone(zone), describer);
	}

}