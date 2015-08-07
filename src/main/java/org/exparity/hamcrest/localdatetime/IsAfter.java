package org.exparity.hamcrest.localdatetime;

import java.time.LocalDateTime;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is after the reference date
 * 
 * @author Stewart Bissett
 */
public class IsAfter extends AbstractLocalDateTimeTimeMatcher {

	private final LocalDateTime expected;

	public IsAfter(final LocalDateTime expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(final LocalDateTime actual, final Description mismatchDesc) {
		if (actual.isAfter(expected)) {
			return true;
		} else {
			mismatchDesc.appendText("date is ").appendValue(formatDate(actual));
			return false;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the date is after ").appendValue(formatDate(expected));
	}
}