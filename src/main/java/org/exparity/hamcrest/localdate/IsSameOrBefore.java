package org.exparity.hamcrest.localdate;

import java.time.LocalDate;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is before or the same instant as
 * the reference date
 * 
 * @author Stewart Bissett
 */
public class IsSameOrBefore extends AbstractLocalDateMatcher {

	private final LocalDate expected;

	public IsSameOrBefore(LocalDate expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(LocalDate actual, Description mismatchDescription) {
		if (actual.isAfter(expected)) {
			mismatchDescription.appendText("date is ").appendValue(formatDate(actual));
			return false;
		} else {
			return true;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the date is on same day or  before ").appendValue(formatDate(expected));
	}

}