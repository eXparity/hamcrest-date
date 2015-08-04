package org.exparity.hamcrest.localdate;

import java.time.LocalDate;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is the same instant as the
 * reference date
 * 
 * @author Stewart Bissett
 */
public class IsSame extends AbstractLocalDateMatcher {

	private final LocalDate expected;

	public IsSame(final LocalDate expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(final LocalDate actual, final Description mismatchDesc) {
		if (expected.equals(actual)) {
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