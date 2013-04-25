
package uk.co.it.modular.hamcrest.date;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * Base class matching parts of a Date as defined by the constants on {@link Calendar} e.g {@link Calendar#YEAR}
 * 
 * @author Stewart Bissett
 */
abstract class AbstractDatePartMatcher extends TypeSafeDiagnosingMatcher<Date> {

	private final Date expectedDate;
	private final TimeZone tz;
	private final int datePart;
	private final int expected;
	private final String datePartLabel;

	public AbstractDatePartMatcher(final Date date, final TimeZone tz, final int datePart, final String datePartLabel) {
		this.expectedDate = date;
		this.tz = tz;
		this.datePart = datePart;
		this.datePartLabel = datePartLabel;
		this.expected = extractDatePart(date, tz, datePart);
	}

	@Deprecated
	public AbstractDatePartMatcher(final Date date, final int datePart, final String datePartLabel) {
		this(date, TimeZone.getDefault(), datePart, datePartLabel);
	}

	@Override
	protected boolean matchesSafely(final Date actual, final Description mismatchDesc) {
		int actualDatePart = extractDatePart(actual, tz, datePart);
		if (expected != actualDatePart) {
			mismatchDesc.appendText(datePartLabel).appendText(" is ").appendValue(describeDate(actual));
			return false;
		} else {
			return true;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the same ").appendText(datePartLabel).appendText(" as ").appendValue(describeDate(expectedDate));
	}

	private String describeDate(final Date date) {
		return date.toString();
	}

	private int extractDatePart(final Date date, final TimeZone tz, final int part) {
		return convertDateToCalendar(date, tz).get(part);
	}

	private Calendar convertDateToCalendar(final Date date, final TimeZone tz) {
		Calendar calendar = Calendar.getInstance(tz);
		calendar.setTime(date);
		return calendar;
	}

}