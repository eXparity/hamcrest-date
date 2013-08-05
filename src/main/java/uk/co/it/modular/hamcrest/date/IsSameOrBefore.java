
package uk.co.it.modular.hamcrest.date;

import java.util.Date;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import static org.hamcrest.Matchers.anyOf;
import static uk.co.it.modular.hamcrest.date.IsBefore.before;
import static uk.co.it.modular.hamcrest.date.IsSameDay.sameDay;
import static uk.co.it.modular.hamcrest.date.IsSameInstant.sameInstant;

/**
 * A matcher that tests that the examined date is before or at the same instant as the reference date
 * 
 * @author Stewart Bissett
 */
public class IsSameOrBefore {

	/**
	 * Creates a matcher that matches when the examined date is at the same instant or before the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isSameOrBefore(new Date()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> isSameOrBefore(final Date date) {
		return anyOf(sameInstant(date), before(date));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day or before the start of the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isSameOrBefore(2012, Months.MAY, 12));
	 * </pre>
	 * 
	 * @param year
	 *            the year against which the examined date is checked
	 * @param month
	 *            the month against which the examined date is checked
	 * @param day
	 *            the day of the month against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> isSameOrBefore(final int year, final Months month, final int day) {
		return anyOf(sameDay(year, month, day), before(year, month, day));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same second or before the start of the reference date and time
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isSameOrBefore(2012, Months.MAY, 12, 23, 00, 01));
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
	 */
	@Factory
	public static Matcher<Date> isSameOrBefore(final int year, final Months month, final int date, final int hour, final int minute, final int second) {
		return anyOf(sameInstant(year, month, date, hour, minute, second, 0), before(year, month, date, hour, minute, second));
	}

}