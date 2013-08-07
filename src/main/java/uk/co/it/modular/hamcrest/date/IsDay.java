
package uk.co.it.modular.hamcrest.date;

import java.util.Date;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import static uk.co.it.modular.hamcrest.date.IsSameDay.sameDay;
import static uk.co.it.modular.hamcrest.date.Moments.today;
import static uk.co.it.modular.hamcrest.date.Moments.tomorrow;
import static uk.co.it.modular.hamcrest.date.Moments.yesterday;

/**
 * A set of matchers for testing the day portion of a {@link Date}
 * 
 * @author Stewart Bissett
 */
public abstract class IsDay {

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
		return sameDay(yesterday());
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
		return sameDay(today());
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
		return sameDay(tomorrow());
	}

}