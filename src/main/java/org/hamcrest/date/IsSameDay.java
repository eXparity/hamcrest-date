
package org.hamcrest.date;

import java.util.Calendar;
import java.util.Date;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/**
 * A matcher that tests that the examined date is on the same day of the year as the reference date
 * 
 * @author Stewart Bissett
 */
public class IsSameDay extends AbstractDatePartMatcher {

	public IsSameDay(final Date date) {
		super(date, Calendar.DAY_OF_YEAR, "day of the year");
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameDayOfTheYear(new Date()))
	 * </pre>
	 * 
	 * @param date the reference date against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> sameDay(final Date date) {
		return new IsSameDay(date);
	}

}