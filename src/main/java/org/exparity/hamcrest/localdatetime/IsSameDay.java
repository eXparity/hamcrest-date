package org.exparity.hamcrest.localdatetime;

import java.time.LocalDateTime;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is the same date as the reference
 * date
 * 
 * @author Stewart Bissett
 */
public class IsSameDay extends AbstractLocalDateTimeTimeMatcher {

	private final LocalDateTime expected;

	public IsSameDay(final LocalDateTime expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(final LocalDateTime actual, final Description mismatchDesc) {
		if (expected.toLocalDate().equals(actual.toLocalDate())) {
			return true;
		} else {
			mismatchDesc.appendText("date is ").appendValue(formatDate(actual));
			return false;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the same date as ").appendValue(formatDate(expected));
	}
}