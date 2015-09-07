package org.exparity.hamcrest.localdatetime;

import java.time.LocalDateTime;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the specified second
 * 
 * @author Stewart Bissett
 */
public class IsSecond extends AbstractLocalDateTimeTimeMatcher {

	private final int expected;

	public IsSecond(int expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(LocalDateTime actual, Description mismatchDescription) {
		if (expected == actual.getSecond()) {
			return true;
		} else {
			mismatchDescription.appendText("the date has the second " + actual.getSecond());
			return false;
		}
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("the date has the second " + expected);
	}
}