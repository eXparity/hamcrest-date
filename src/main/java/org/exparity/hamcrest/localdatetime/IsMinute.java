package org.exparity.hamcrest.localdatetime;

import java.time.LocalDateTime;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the specified minute
 * 
 * @author Stewart Bissett
 */
public class IsMinute extends AbstractLocalDateTimeTimeMatcher {

	private final int expected;

	public IsMinute(int expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(LocalDateTime actual, Description mismatchDescription) {
		if (expected == actual.getMinute()) {
			return true;
		} else {
			mismatchDescription.appendText("the date has the minute " + actual.getMinute());
			return false;
		}
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("the date has the minute " + expected);
	}
}