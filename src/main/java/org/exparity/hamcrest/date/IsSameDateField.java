
package org.exparity.hamcrest.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A base matcher that tests that the examined date has the same date part as the reference date.
 * 
 * @author Stewart Bissett
 */
abstract class IsSameDateField extends TypeSafeDiagnosingMatcher<Date> {

	private final int datePart;
	private final int expected;
	private final String datePartLabel;
	private final String dateFormat;
	private final String expectedValueDescription;

	public IsSameDateField(final int expectedValue, final String expectedValueDescription, final int datePart, final String label, final String format) {
		this.datePart = datePart;
		this.expected = expectedValue;
		this.expectedValueDescription = expectedValueDescription;
		this.datePartLabel = label;
		this.dateFormat = format;
	}

	public IsSameDateField(final Date date, final int datePart, final String datePartLabel, final String format) {
		this(extractDatePart(date, datePart), format(date, format), datePart, datePartLabel, format);
	}

	@Override
	protected boolean matchesSafely(final Date actual, final Description mismatchDesc) {
		int actualDatePart = extractDatePart(actual, datePart);
		if (expected != actualDatePart) {
			mismatchDesc.appendText(datePartLabel).appendText(" is ").appendValue(format(actual, dateFormat));
			return false;
		} else {
			return true;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("a ").appendText(datePartLabel).appendText(" of ").appendValue(expectedValueDescription);
	}

	private static int extractDatePart(final Date date, final int part) {
		return convertDateToCalendar(date).get(part);
	}

	private static Calendar convertDateToCalendar(final Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	private static String format(final Date date, final String pattern) {
		return new SimpleDateFormat(pattern).format(date);
	}
}