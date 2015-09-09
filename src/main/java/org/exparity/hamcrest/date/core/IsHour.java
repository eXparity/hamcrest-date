package org.exparity.hamcrest.date.core;

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is on the specified hour
 * 
 * @author Stewart Bissett
 */
public class IsHour<T extends TemporalAccessor> extends TypeSafeDiagnosingMatcher<T> {

	private final int expected;

	public IsHour(int expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(final T actual, Description mismatchDescription) {
		int actualHour = actual.get(ChronoField.HOUR_OF_DAY);
		if (expected == actualHour) {
			return true;
		} else {
			mismatchDescription.appendText("the date has the hour " + actualHour);
			return false;
		}
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("the date has the hour " + expected);
	}
}