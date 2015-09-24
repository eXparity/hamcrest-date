package org.exparity.hamcrest.date.core;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is before the reference date
 * 
 * @author Stewart Bissett
 */
public class IsBefore<T> extends TypeSafeDiagnosingMatcher<T> {

	private final TemporalWrapper<T> expected;
	private final TemporalFormatter<T> describer;

	public IsBefore(final TemporalWrapper<T> expected, final TemporalFormatter<T> describer) {
		this.expected = expected;
		this.describer = describer;
	}

	@Override
	protected boolean matchesSafely(T actual, Description mismatchDescription) {
		if (expected.isSame(actual) || expected.isBefore(actual)) {
			mismatchDescription.appendText("date is " + describer.describe(actual));
			return false;
		} else {
			return true;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the date is after " + describer.describe(expected.unwrap()));
	}
}