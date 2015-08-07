package org.exparity.hamcrest.localdatetime;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the same month of the year
 * as the reference date
 * 
 * @author Stewart Bissett
 */
public class IsMonth extends AbstractLocalDateTimeTimeMatcher {

	private final Month expected;

	public IsMonth(Month expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(LocalDateTime actual, Description mismatchDescription) {
		if (expected.equals(actual.getMonth())) {
			return true;
		} else {
			mismatchDescription.appendText("the date is in " + describeMonth(actual.getMonth()));
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