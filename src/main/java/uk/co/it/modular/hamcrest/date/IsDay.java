
package uk.co.it.modular.hamcrest.date;

import static uk.co.it.modular.hamcrest.date.IsSameDay.sameDay;
import java.util.Calendar;
import java.util.Date;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/**
 * A set of matchers for testing the day portion of a {@link Date}
 * 
 * @author Stewart Bissett
 */
public class IsDay {

	/**
	 * Creates a matcher that matches when the examined date is yesterday
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isToday());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isYesterday() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -1);
		return sameDay(cal.getTime());
	}

	/**
	 * Creates a matcher that matches when the examined date is today
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isToday());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isToday() {
		return sameDay(new Date());
	}

	/**
	 * Creates a matcher that matches when the examined date is tomorrow
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isTomorrow());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isTomorrow() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, +1);
		return sameDay(cal.getTime());
	}

}