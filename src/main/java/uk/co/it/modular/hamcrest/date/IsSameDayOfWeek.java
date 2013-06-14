
package uk.co.it.modular.hamcrest.date;

import java.util.Calendar;
import java.util.Date;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import static org.hamcrest.Matchers.anyOf;

/**
 * A matcher that tests that the examined date is on the same day of the week as the reference date
 * 
 * @author Stewart Bissett
 */
public class IsSameDayOfWeek extends IsSameDatePart {

	public IsSameDayOfWeek(final Date date) {
		super(date, Calendar.DAY_OF_WEEK, "day of the week", "EEEE");
	}

	public IsSameDayOfWeek(final Weekdays weekday) {
		super(weekday.getAsCalendarConstant(), weekday.describe(), Calendar.DAY_OF_WEEK, "day of the week", "EEEE");
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day of the week as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameDayOfTheWeek(new Date()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> sameDayOfWeek(final Date date) {
		return new IsSameDayOfWeek(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day of the week as the supplied day
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameDayOfTheWeek(new Date()))
	 * </pre>
	 * 
	 * @param weekday
	 *            the reference weekday against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> sameDayOfWeek(final Weekdays weekday) {
		return new IsSameDayOfWeek(weekday);
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
		return sameDayOfWeek(Weekdays.MONDAY);
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
		return sameDayOfWeek(Weekdays.TUESDAY);
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
		return sameDayOfWeek(Weekdays.THURSDAY);
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
		return sameDayOfWeek(Weekdays.WEDNESDAY);
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
		return sameDayOfWeek(Weekdays.FRIDAY);
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
		return sameDayOfWeek(Weekdays.SATURDAY);
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
		return sameDayOfWeek(Weekdays.SUNDAY);
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

}