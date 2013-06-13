
package uk.co.it.modular.hamcrest.date;

import static org.hamcrest.Matchers.anyOf;
import static uk.co.it.modular.hamcrest.date.IsMinimumDatePart.minimumDatePart;
import static uk.co.it.modular.hamcrest.date.IsSameDay.sameDay;
import static uk.co.it.modular.hamcrest.date.IsSameWeekday.sameWeekday;
import java.util.Calendar;
import java.util.Date;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/**
 * A set of matchers for testing the day portion of a {@link Date}
 * 
 * @author Stewart Bissett
 */
public class DayMatchers {

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

	/**
	 * Creates a matcher that matches when the examined date is on a monday
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isMonday());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isMonday() {
		return sameWeekday(Weekdays.MONDAY);
	}

	/**
	 * Creates a matcher that matches when the examined date is on a tuesday
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isTuesday());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isTuesday() {
		return sameWeekday(Weekdays.TUESDAY);
	}

	/**
	 * Creates a matcher that matches when the examined date is on a wednesday
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isWednesday());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isWednesday() {
		return sameWeekday(Weekdays.WEDNESDAY);
	}

	/**
	 * Creates a matcher that matches when the examined date is on a thursday
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isThursday());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isThursday() {
		return sameWeekday(Weekdays.THURSDAY);
	}

	/**
	 * Creates a matcher that matches when the examined date is on a friday
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isFriday());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isFriday() {
		return sameWeekday(Weekdays.FRIDAY);
	}

	/**
	 * Creates a matcher that matches when the examined date is on a saturday
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isSaturday());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isSaturday() {
		return sameWeekday(Weekdays.SATURDAY);
	}

	/**
	 * Creates a matcher that matches when the examined date is on a sunday
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isSunday());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isSunday() {
		return sameWeekday(Weekdays.SUNDAY);
	}

	/**
	 * Creates a matcher that matches when the examined date is on a weekday
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isWeekday());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isWeekday() {
		return anyOf(isMonday(), isTuesday(), isWednesday(), isThursday(), isFriday());
	}

	/**
	 * Creates a matcher that matches when the examined date is on a weekend
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isWeekend());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isWeekend() {
		return anyOf(isSaturday(), isSunday());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the first day of the month
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isFirstDayOfMonth());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isFirstDayOfMonth() {
		return minimumDatePart(Calendar.DAY_OF_MONTH, "day of month");
	}

	/**
	 * Creates a matcher that matches when the examined date is on the first day of the month
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isFirstDayOfMonth());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isLastDayOfMonth() {
		return IsMaximumDatePart.maximumDatePart(Calendar.DAY_OF_MONTH, "day of month");
	}

}