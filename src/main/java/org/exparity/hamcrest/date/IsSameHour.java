
package org.exparity.hamcrest.date;

import java.util.Calendar;
import java.util.Date;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/**
 * A matcher that tests that the examined date is on the same hour as the reference date
 * 
 * @author Stewart Bissett
 */
public class IsSameHour extends IsSameDatePart {

	public IsSameHour(final Date date) {
		super(date, Calendar.HOUR_OF_DAY, "hour", "k");
	}

	public IsSameHour(final int hour) {
		super(hour, String.valueOf(hour), Calendar.HOUR_OF_DAY, "hour", "k");
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same hour as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameHour(new Date()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> sameHour(final Date date) {
		return new IsSameHour(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same hour as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameHour(12));
	 * </pre>
	 * 
	 * @param hour
	 *            the reference hour against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> sameHour(final int hour) {
		return new IsSameHour(hour);
	}

}