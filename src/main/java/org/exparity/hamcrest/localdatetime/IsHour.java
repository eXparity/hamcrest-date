package org.exparity.hamcrest.localdatetime;

import java.time.LocalDateTime;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the specified hour
 * 
 * @author Stewart Bissett
 */
public class IsHour extends AbstractLocalDateTimeTimeMatcher {

	private final int expected;

	public IsHour(int expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(LocalDateTime actual, Description mismatchDescription) {
		if (expected == actual.getHour()) {
			return true;
		} else {
			mismatchDescription.appendText("the date has the hour " + actual.getHour());
			return false;
		}
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("the date has the hour " + expected);
	}
}