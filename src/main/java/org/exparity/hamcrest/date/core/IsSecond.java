package org.exparity.hamcrest.date.core;

import java.time.temporal.ChronoField;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is on the specified second
 *
 * @author Stewart Bissett
 */
public class IsSecond<T> extends TypeSafeDiagnosingMatcher<T> {

	private final int expected;
	private final TemporalAdapter<T> accessor;

	public IsSecond(final int expected, final TemporalAdapter<T> accessor) {
		this.expected = expected;
		this.accessor = accessor;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		int actualSecond = accessor.asTemporal(actual).get(ChronoField.SECOND_OF_MINUTE);
		if (expected == actualSecond) {
			return true;
		} else {
			mismatchDescription.appendText("the date has the second " + actualSecond);
			return false;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date has the second " + expected);
	}
}