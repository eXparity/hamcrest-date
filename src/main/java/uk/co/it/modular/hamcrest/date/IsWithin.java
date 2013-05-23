
package uk.co.it.modular.hamcrest.date;

import static java.util.Calendar.getInstance;
import static uk.co.it.modular.hamcrest.date.DateFormatter.formatDateWithMillis;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is within a defined period of the reference date
 * 
 * @author Stewart Bissett
 */
public class IsWithin extends TypeSafeDiagnosingMatcher<Date> {

	private final long period;
	private final TimeUnit unit;
	private final Date expected;
	private final long expectedDifferenceInMillis;

	public IsWithin(final long period, final TimeUnit unit, final Date expected) {
		this.period = period;
		this.unit = unit;
		this.expected = expected;
		this.expectedDifferenceInMillis = unit.toMillis(period);
	}

	@Override
	protected boolean matchesSafely(final Date actual, final Description mismatchDesc) {
		long differenceInMillis = Math.abs(expected.getTime() - actual.getTime());
		if (differenceInMillis > expectedDifferenceInMillis) {
			mismatchDesc.appendText("date is ").appendValue(formatDateWithMillis(actual));
			return false;
		} else {
			return true;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the date is within " + period + " " + abbreviatedUnit(unit) + " of ").appendValue(formatDateWithMillis(expected));
	}

	private String abbreviatedUnit(final TimeUnit unit) {
		switch (unit) {
			case MICROSECONDS:
				return "µs";
			case MILLISECONDS:
				return "ms";
			case MINUTES:
				return "mins";
			case NANOSECONDS:
				return "ns";
			case SECONDS:
				return "secs";
			case DAYS:
			case HOURS:
			default:
				return unit.name().toLowerCase();
		}
	}

	/**
	 * Creates a matcher that matches when the examined date is within a given period of the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, within(10, TimeUnit.MINUTES, new Date()))
	 * </pre>
	 * 
	 * @param period
	 *            the timeunit interval the examined date should be with
	 * @param unit
	 *            the timeunit to define the length of the period
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> within(final long period, final TimeUnit unit, final Date date) {
		return new IsWithin(period, unit, date);
	}

	/**
	 * Creates a matcher that matches when the examined date is within a given period of the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, within(5, TimeUnit.DAYS, 2012, Months.MAY, 12));
	 * </pre>
	 * 
	 * @param period
	 *            the timeunit interval the examined date should be with
	 * @param unit
	 *            the timeunit to define the length of the period
	 * @param year
	 *            the year against which the examined date is checked
	 * @param month
	 *            the month against which the examined date is checked
	 * @param day
	 *            the day of the month against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> within(final long period, final TimeUnit unit, final int year, final Months month, final int day) {
		return within(period, unit, year, month, day, 0, 0, 0, 0);
	}

	/**
	 * Creates a matcher that matches when the examined date is within a given period of the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, within(1, TimeUnit.MINUTES, 2012, Months.MAY, 12, 23, 00, 01));
	 * </pre>
	 * 
	 * @param period
	 *            the timeunit interval the examined date should be with
	 * @param unit
	 *            the timeunit to define the length of the period
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
	 * @param second
	 *            the millisecond of the second against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> within(final long period, final TimeUnit unit, final int year, final Months month, final int date, final int hour, final int minute,
			final int second, final int milliseconds) {
		Calendar calendar = getInstance();
		calendar.set(year, month.getAsCalendarConstant(), date, hour, minute, second);
		calendar.set(Calendar.MILLISECOND, milliseconds);
		return new IsWithin(period, unit, calendar.getTime());
	}

}