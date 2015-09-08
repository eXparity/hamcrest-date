package org.exparity.hamcrest.date.core;

import java.time.LocalDate;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is before or the same instant as
 * the reference date
 * 
 * @author Stewart Bissett
 */
public class IsSameOrAfter<T extends Comparable<? super T>> extends TypeSafeDiagnosingMatcher<T> {

	private final T expected;

	public IsSameOrAfter(T expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(T actual, Description mismatchDescription) {
		if (actual.compareTo(expected) < 0) {
			mismatchDescription.appendText("date is ").appendValue(actual.toString());
			return false;
		} else {
			return true;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the date is on same day or after ").appendValue(expected.toString());
	}

}