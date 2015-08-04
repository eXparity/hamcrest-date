package org.exparity.hamcrest.localdate;

import java.time.LocalDate;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is a leap year
 * 
 * @author Stewart Bissett
 */
public class IsLeapYear extends AbstractLocalDateMatcher {

	@Override
	protected boolean matchesSafely(final LocalDate actual, final Description mismatchDesc) {
		if (actual.isLeapYear()) {
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