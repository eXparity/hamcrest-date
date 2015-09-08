package org.exparity.hamcrest.localdate;

import java.time.LocalDate;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the specified hour
 * 
 * @author Stewart Bissett
 */
public class IsDayOfMonth extends AbstractLocalDateMatcher {

	private final int expected;

	public IsDayOfMonth(int expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(final LocalDate actual, Description mismatchDescription) {
		if (expected == actual.getDayOfMonth()) {
			return true;
		} else {
			mismatchDescription.appendText("the date has the day of the month " + actual.getDayOfMonth());
			return false;
		}
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("the date has the day of the month " + expected);
	}
}