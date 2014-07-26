
package org.exparity.hamcrest.date;

import java.util.Date;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import static org.exparity.hamcrest.date.IsAfter.after;
import static org.exparity.hamcrest.date.IsSameDay.sameDay;
import static org.exparity.hamcrest.date.IsSameInstant.sameInstant;
import static org.hamcrest.Matchers.anyOf;

/**
 * A matcher that tests that the examined date is after or at the same instant as the reference date
 * 
 * @author Stewart Bissett
 */
public abstract class IsSameOrAfter {

	/**
	 * Creates a matcher that matches when the examined date is at the same instant or after the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isSameOrAfter(new Date()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> sameOrAfter(final Date date) {
		return anyOf(sameInstant(date), after(date));
	}

	/**
	 * Creates a matcher that matches when the examined date is at the same instant or after the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isSameOrAfter(Moments.today()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> sameOrAfter(final DayMonthYear date) {
		return anyOf(sameDay(date), after(date));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day or after the start of the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isSameOrAfter(2012, Months.MAY, 12));
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
	public static Matcher<Date> sameOrAfter(final int year, final Months month, final int day) {
		return anyOf(sameDay(year, month, day), after(year, month, day));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same second or after the start of the reference date and time
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isSameOrAfter(2012, Months.MAY, 12, 23, 00, 01));
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
	public static Matcher<Date> sameOrAfter(final int year, final Months month, final int date, final int hour, final int minute, final int second) {
		return anyOf(sameInstant(year, month, date, hour, minute, second, 0), after(year, month, date, hour, minute, second));
	}

}