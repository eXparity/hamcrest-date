
package uk.co.it.modular.hamcrest.date;

import java.util.Calendar;
import java.util.Date;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/**
 * A matcher that tests that the examined date is on the same day of the year as the reference date
 * 
 * @author Stewart Bissett
 */
public class IsSameDay extends IsSameDatePart {

	public IsSameDay(final Date date) {
		super(date, Calendar.DAY_OF_YEAR, "day of the year", "d MMMMM yyyy");
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day of the year as the reference date in the default timezone
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameDayOfTheYear(new Date()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> sameDay(final Date date) {
		return new IsSameDay(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameDayOfTheYear(2012, Month.JAN, 1))
	 * </pre>
	 * 
	 * @param day
	 *            the reference day of the month against which the examined date is checked
	 * @param month
	 *            the reference month against which the examined date is checked
	 * @param year
	 *            the reference year against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> sameDay(final int year, final Months month, final int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month.calendarConstant(), day, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return sameDay(calendar.getTime());
	}
}