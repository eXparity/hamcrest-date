package org.exparity.hamcrest.date.core;

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is on the specified second
 * 
 * @author Stewart Bissett
 */
public class IsSecond<T extends TemporalAccessor> extends TypeSafeDiagnosingMatcher<T> {

	private final int expected;

	public IsSecond(int expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(final T actual, Description mismatchDescription) {
		int actualSecond = actual.get(ChronoField.SECOND_OF_MINUTE);
		if (expected == actualSecond) {
			return true;
		} else {
			mismatchDescription.appendText("the date has the second " + actualSecond);
			return false;
		}
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("the date has the second " + expected);
	}
}