package org.exparity.hamcrest.date.core;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is the same instant as the
 * reference date
 * 
 * @author Stewart Bissett
 */
public class IsSame<T extends Comparable<? super T>> extends TypeSafeDiagnosingMatcher<T> {

	private final T expected;

	public IsSame(final T expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
		if (expected.compareTo(actual) == 0) {
			return true;
		} else {
			mismatchDesc.appendText("date is " + actual.toString());
			return false;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the same date as " + expected.toString());
	}
}