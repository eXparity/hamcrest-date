package org.exparity.hamcrest.localdatetime;

import java.time.LocalDateTime;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is before or the same instant as
 * the reference date
 * 
 * @author Stewart Bissett
 */
public class IsSameOrAfter extends AbstractLocalDateTimeTimeMatcher {

	private final LocalDateTime expected;

	public IsSameOrAfter(LocalDateTime expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(LocalDateTime actual, Description mismatchDescription) {
		if (actual.isBefore(expected)) {
			mismatchDescription.appendText("date is ").appendValue(formatDate(actual));
			return false;
		} else {
			return true;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the date is on same day or after ").appendValue(formatDate(expected));
	}

}