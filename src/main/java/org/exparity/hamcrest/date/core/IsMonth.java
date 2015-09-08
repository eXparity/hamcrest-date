package org.exparity.hamcrest.date.core;

import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.util.Locale;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is on the same month of the year
 * as the reference date
 * 
 * @author Stewart Bissett
 */
public class IsMonth<T extends Temporal> extends TypeSafeDiagnosingMatcher<T> {

	private final Month expected;

	public IsMonth(final Month expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(final T actual, Description mismatchDescription) {
		Month actualMonth = Month.of(actual.get(ChronoField.MONTH_OF_YEAR));
		if (expected.equals(actualMonth)) {
			return true;
		} else {
			mismatchDescription.appendText("the date is in " + describeMonth(actualMonth));
			return false;
		}
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("the date is in month " + describeMonth(expected));
	}

	private String describeMonth(Month m) {
		return m.getDisplayName(TextStyle.FULL, Locale.getDefault());
	}

}