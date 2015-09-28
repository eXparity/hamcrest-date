package org.exparity.hamcrest.date.core;

import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is on the same month of the year
 * as the reference date
 * 
 * @author Stewart Bissett
 */
public class IsMonth<T> extends TypeSafeDiagnosingMatcher<T> {

	private final Month expectedMonth;
	private final TemporalFieldWrapper<T> accessor;

	public IsMonth(final Month month, final TemporalFieldWrapper<T> accessor) {
		this.expectedMonth = month;
		this.accessor = accessor;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		Month actualMonth = Month.of(accessor.get(actual, ChronoField.MONTH_OF_YEAR));
		if (expectedMonth.equals(actualMonth)) {
			return true;
		} else {
			mismatchDescription.appendText("the date is in " + describeMonth(actualMonth));
			return false;
		}
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("the date is in the month of " + describeMonth(expectedMonth));
	}

	private String describeMonth(Month m) {
		return m.getDisplayName(TextStyle.FULL, Locale.getDefault());
	}

}