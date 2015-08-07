package org.exparity.hamcrest.localdatetime;

import java.time.LocalDateTime;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is after the reference date
 * 
 * @author Stewart Bissett
 */
public class IsBefore extends AbstractLocalDateTimeTimeMatcher {

	private final LocalDateTime expected;

	public IsBefore(final LocalDateTime expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(final LocalDateTime actual, final Description mismatchDesc) {
		if (actual.isBefore(expected)) {
			return true;
		} else {
			mismatchDesc.appendText("date is ").appendValue(formatDate(actual));
			return false;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the date is before ").appendValue(formatDate(expected));
	}
}