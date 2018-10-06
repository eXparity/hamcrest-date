package org.exparity.hamcrest.date.core;

import java.time.ZoneId;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is after the reference date
 *
 * @author Stewart Bissett
 */
public class IsAfter<T> extends DateMatcher<T> {

	private final TemporalWrapper<T> expected;
	private final TemporalFormatter<T> describer;

	public IsAfter(final TemporalWrapper<T> expected, final TemporalFormatter<T> describer) {
		this.expected = expected;
		this.describer = describer;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		if (expected.isSame(actual) || expected.isAfter(actual)) {
			mismatchDescription.appendText("date is " + describer.describe(actual));
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date is after " + describer.describe(expected.unwrap()));
	}

	@Override
	public DateMatcher<T> atZone(ZoneId zone) {
		return new IsAfter<>(expected.withZone(zone), describer);
	}

}