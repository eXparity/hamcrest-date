package org.exparity.hamcrest.date.core;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is after the reference date
 * 
 * @author Stewart Bissett
 */
public class IsAfter<T extends Comparable<? super T>> extends TypeSafeDiagnosingMatcher<T> {

	private final T expected;

	public IsAfter(final T expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
		if (actual.compareTo(expected) > 0) {
			return true;
		} else {
			mismatchDesc.appendText("date is ").appendValue(actual.toString());
			return false;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the date is after ").appendValue(expected.toString());
	}
}