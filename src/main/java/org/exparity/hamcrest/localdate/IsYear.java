package org.exparity.hamcrest.localdate;

import java.time.LocalDate;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the same year as the
 * reference date
 * 
 * @author Stewart Bissett
 */
public class IsYear extends AbstractLocalDateMatcher {

	private final int expected;

	public IsYear(final int expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(LocalDate actual, Description mismatchDescription) {
		if (expected == actual.getYear()) {
			return true;
		} else {
			mismatchDescription.appendText("the date has year " + actual.getYear());
			return false;
		}
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("the date is in the year " + expected);
	}
}