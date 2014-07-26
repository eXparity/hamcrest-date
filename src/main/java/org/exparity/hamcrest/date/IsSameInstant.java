
package org.exparity.hamcrest.date;

import static java.util.Calendar.getInstance;
import static org.exparity.hamcrest.date.DateFormatter.*;
import java.util.Calendar;
import java.util.Date;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is the same instant down to the millisecond as the reference date
 * 
 * @author Stewart Bissett
 */
public class IsSameInstant extends TypeSafeDiagnosingMatcher<Date> {

	private final Date expected;

	public IsSameInstant(final Date expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(final Date actual, final Description mismatchDesc) {
		if (expected.getTime() != actual.getTime()) {
			mismatchDesc.appendText("date is ").appendValue(formatDateWithMillis(actual));
			return false;
		} else {
			return true;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the same date as ").appendValue(formatDateWithMillis(expected));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same instant as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameInstant(new Date()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> sameInstant(final Date date) {
		return new IsSameInstant(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same UTC instant as the reference UTC epoch time supplied
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameInstant(1325415600000L))
	 * </pre>
	 * 
	 * @param timestamp
	 *            the time as milliseconds since the Unix epoch time
	 */
	@Factory
	public static Matcher<Date> sameInstant(final long timestamp) {
		return new IsSameInstant(new Date(timestamp));
	}

	/**
	 * @deprecated See {@link #sameInstance(int, Months, int, int, int, int, int)}
	 */
	@Deprecated
	public static Matcher<Date> sameIntstance(final int year, final Months month, final int date, final int hour, final int minute, final int second, final int milliseconds) {
		return sameInstant(year, month, date, hour, minute, second, milliseconds);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same instance as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameInstance(2012, Months.MAY, 12, 23, 00, 01, 123));
	 * </pre>
	 * 
	 * @param year
	 *            the year against which the examined date is checked
	 * @param month
	 *            the month against which the examined date is checked
	 * @param day
	 *            the day of the month against which the examined date is checked
	 * @param hour
	 *            the hour of the day against which the examined date is checked
	 * @param minute
	 *            the minute of the hour against which the examined date is checked
	 * @param second
	 *            the second of the minute against which the examined date is checked
	 * @param milliseconds
	 *            the milliseconds of the second against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> sameInstant(final int year, final Months month, final int date, final int hour, final int minute, final int second, final int milliseconds) {
		Calendar calendar = getInstance();
		calendar.set(year, month.calendarConstant(), date, hour, minute, second);
		calendar.set(Calendar.MILLISECOND, milliseconds);
		return new IsSameInstant(calendar.getTime());
	}

}