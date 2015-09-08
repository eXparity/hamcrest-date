package org.exparity.hamcrest.date.core;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is on the specified hour
 * 
 * @author Stewart Bissett
 */
public class IsDayOfMonth<T extends TemporalAccessor> extends TypeSafeDiagnosingMatcher<T> {

	private final int expected;

	public IsDayOfMonth(int expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(final T actual, Description mismatchDescription) {
		int actualValue = actual.get(ChronoField.DAY_OF_MONTH);
		if (expected == actualValue) {
			return true;
		} else {
			mismatchDescription.appendText("the date has the day of the month " + actualValue);
			return false;
		}
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("the date has the day of the month " + expected);
	}
}