package org.exparity.hamcrest.localdatetime;

import java.time.LocalDateTime;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is a leap year
 * 
 * @author Stewart Bissett
 */
public class IsLeapYear extends AbstractLocalDateTimeTimeMatcher {

	@Override
	protected boolean matchesSafely(final LocalDateTime actual, final Description mismatchDesc) {
		if (actual.toLocalDate().isLeapYear()) {
			return true;
		} else {
			mismatchDesc.appendText("a leap year");
			return false;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("a leap year");
	}
}