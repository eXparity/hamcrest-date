package org.exparity.hamcrest.date.core;

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is on the specified minute
 * 
 * @author Stewart Bissett
 */
public class IsMinute<T extends TemporalAccessor> extends TypeSafeDiagnosingMatcher<T> {

	private final int expected;

	public IsMinute(int expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(final T actual, Description mismatchDescription) {
		int actualMinute = actual.get(ChronoField.MINUTE_OF_HOUR);
		if (expected == actualMinute) {
			return true;
		} else {
			mismatchDescription.appendText("the date has the minute " + actualMinute);
			return false;
		}
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("the date has the minute " + expected);
	}
}