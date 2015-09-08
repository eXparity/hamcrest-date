package org.exparity.hamcrest.date.core;

import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is on the same year as the
 * reference date
 * 
 * @author Stewart Bissett
 */
public class IsYear<T extends Temporal> extends TypeSafeDiagnosingMatcher<T> {

	private final int expected;

	public IsYear(final int expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(final T actual, Description mismatchDescription) {
		int actualYear = actual.get(ChronoField.YEAR);
		if (expected == actualYear) {
			return true;
		} else {
			mismatchDescription.appendText("the date has year " + actualYear);
			return false;
		}
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("the date is in the year " + expected);
	}
}