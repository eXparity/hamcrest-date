package org.exparity.hamcrest.localdate;

import java.time.LocalDate;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is after the reference date
 * 
 * @author Stewart Bissett
 */
public class IsBefore extends AbstractLocalDateMatcher {

	private final LocalDate expected;

	public IsBefore(final LocalDate expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(final LocalDate actual, final Description mismatchDesc) {
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