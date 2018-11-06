package org.exparity.hamcrest.date.core;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is before the reference date
 *
 * @author Stewart Bissett
 */
public class IsBefore<T, U, Z> extends ZonedTemporalMatcher<T, Z> {

	private final TemporalWrapper<T, U, Z> expected;
	private final TemporalFormatter<T> describer;

	public IsBefore(final TemporalWrapper<T, U, Z> expected, final TemporalFormatter<T> describer) {
		this.expected = expected;
		this.describer = describer;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		if (expected.isSame(actual) || expected.isBefore(actual)) {
			mismatchDescription.appendText("date is " + describer.describe(actual));
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date is before " + describer.describe(expected.unwrap()));
	}

	@Override
	public ZonedTemporalMatcher<T, Z> atZone(Z zone) {
		return new IsBefore<>(expected.withZone(zone), describer);
	}

}