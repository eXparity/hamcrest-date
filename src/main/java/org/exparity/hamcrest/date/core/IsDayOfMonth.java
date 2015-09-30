package org.exparity.hamcrest.date.core;

import java.time.temporal.ChronoField;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is on the specified hour
 *
 * @author Stewart Bissett
 */
public class IsDayOfMonth<T> extends TypeSafeDiagnosingMatcher<T> {

	private final int expected;
	private final TemporalAdapter<T> adapter;

	public IsDayOfMonth(final int expected, final TemporalAdapter<T> adapter) {
		this.expected = expected;
		this.adapter = adapter;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		int actualValue = adapter.asTemporal(actual).get(ChronoField.DAY_OF_MONTH);
		if (expected == actualValue) {
			return true;
		} else {
			mismatchDescription.appendText("the date has the day of the month " + actualValue);
			return false;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date has the day of the month " + expected);
	}
}