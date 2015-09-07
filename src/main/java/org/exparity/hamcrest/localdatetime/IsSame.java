package org.exparity.hamcrest.localdatetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is the same instant as the
 * reference date
 * 
 * @author Stewart Bissett
 */
public class IsSame extends AbstractLocalDateTimeTimeMatcher {

	private final LocalDateTime expected;
	private final ChronoUnit truncatedTo;

	public IsSame(final LocalDateTime expected) {
		this.expected = expected;
		this.truncatedTo = ChronoUnit.NANOS;
	}
	
	public IsSame(final Date expected) {
		this.expected = expected.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		this.truncatedTo = ChronoUnit.MILLIS;
	}


	@Override
	protected boolean matchesSafely(final LocalDateTime actual, final Description mismatchDesc) {
		LocalDateTime adjusted = actual.truncatedTo(truncatedTo);
		if (expected.equals(adjusted)) {
			return true;
		} else {
			mismatchDesc.appendText("date is ").appendValue(formatDate(adjusted));
			return false;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the same date as ").appendValue(formatDate(expected));
	}
}