package org.exparity.hamcrest.date.core;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is a leap year
 *
 * @author Stewart Bissett
 */
public class IsLeapYear<T, Z> extends ZonedTemporalMatcher<T, Z> {

	private final LeapYearAdapter<T, Z> adapter;
	private final TemporalFormatter<T> formatter;
	private final Z zone;

	public IsLeapYear(final LeapYearAdapter<T, Z> adapter, final TemporalFormatter<T> formatter, final Z zone) {
		this.adapter = adapter;
		this.formatter = formatter;
		this.zone = zone;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
		if (!this.adapter.isLeapYear(actual, zone)) {
			mismatchDesc.appendText("the date " + this.formatter.describe(actual) + " is not a leap year");
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("a leap year");
	}

	@Override
	public ZonedTemporalMatcher<T, Z> atZone(Z zone) {
		return new IsLeapYear<>(adapter, formatter, zone);
	}

}