package org.exparity.hamcrest.date.core;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is the same instant as the
 * reference date
 * 
 * @author Stewart Bissett
 */
public class IsSameInstant extends TypeSafeDiagnosingMatcher<LocalDateTime> {

	private final LocalDateTime expected;
	private final ChronoUnit granularity;

	public IsSameInstant(final LocalDateTime expected, final ChronoUnit granularity) {
		this.expected = expected.truncatedTo(granularity);
		this.granularity = granularity;
	}

	@Override
	protected boolean matchesSafely(final LocalDateTime actual, final Description mismatchDesc) {
		LocalDateTime adjusted = actual.truncatedTo(granularity);
		if (expected.equals(adjusted)) {
			return true;
		} else {
			mismatchDesc.appendText("date is ").appendValue(adjusted.toString());
			return false;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the same date as ").appendValue(expected.toString());
	}
}