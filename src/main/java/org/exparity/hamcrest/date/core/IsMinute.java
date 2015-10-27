package org.exparity.hamcrest.date.core;

import java.time.temporal.ChronoField;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is on the specified minute
 *
 * @author Stewart Bissett
 */
public class IsMinute<T> extends TypeSafeDiagnosingMatcher<T> {

	private final int expected;
	private final TemporalAdapter<T> accessor;

	public IsMinute(final int expected, final TemporalAdapter<T> accessor) {
		this.expected = expected;
		this.accessor = accessor;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		int actualMinute = accessor.asTemporal(actual).get(ChronoField.MINUTE_OF_HOUR);
		if (expected != actualMinute) {
			mismatchDescription.appendText("the date has the minute " + actualMinute);
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date has the minute " + expected);
	}
}