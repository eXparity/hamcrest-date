package org.exparity.hamcrest.date;

import static java.time.DayOfWeek.*;
import static java.time.Month.*;
import static java.time.ZoneId.systemDefault;
import static java.util.Arrays.asList;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.exparity.hamcrest.date.core.IsAfter;
import org.exparity.hamcrest.date.core.IsBefore;
import org.exparity.hamcrest.date.core.IsDayOfMonth;
import org.exparity.hamcrest.date.core.IsDayOfWeek;
import org.exparity.hamcrest.date.core.IsHour;
import org.exparity.hamcrest.date.core.IsLeapYear;
import org.exparity.hamcrest.date.core.IsMaximum;
import org.exparity.hamcrest.date.core.IsMillisecond;
import org.exparity.hamcrest.date.core.IsMinimum;
import org.exparity.hamcrest.date.core.IsMinute;
import org.exparity.hamcrest.date.core.IsMonth;
import org.exparity.hamcrest.date.core.IsSame;
import org.exparity.hamcrest.date.core.IsSameDay;
import org.exparity.hamcrest.date.core.IsSameOrAfter;
import org.exparity.hamcrest.date.core.IsSameOrBefore;
import org.exparity.hamcrest.date.core.IsSecond;
import org.exparity.hamcrest.date.core.IsWithin;
import org.exparity.hamcrest.date.core.IsYear;
import org.exparity.hamcrest.date.core.format.DateFormatter;
import org.exparity.hamcrest.date.core.wrapper.DateWrapper;
import org.hamcrest.Matcher;

/**
 * Static factory for creating {@link org.hamcrest.Matcher} instances for
 * comparing dates
 *
 * @author Stewart Bissett
 */
public abstract class DateMatchers {

	/**
	 * Creates a matcher that matches when the examined date is after the
	 * reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, after(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<Date> after(final Date date) {
		return new IsAfter<Date>(new DateWrapper(date), new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is after the
	 * reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, after(Moments.today()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 * @deprecated Use {@link #after(LocalDate)}
	 */
	@Deprecated
	public static Matcher<Date> after(final DayMonthYear date) {
		return after(date.toLocalDate());
	}

	/**
	 * Creates a matcher that matches when the examined date is after the
	 * reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, after(Moments.today()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<Date> after(final LocalDate date) {
		return new IsAfter<Date>(new DateWrapper(date), new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is after the end of
	 * the reference year
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, after(2012, Months.MAY, 12));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param day the day of the month against which the examined date is
	 *            checked
	 * @deprecated Use {@link #after(int, Month, int)}
	 */
	@Deprecated
	public static Matcher<Date> after(final int year, final Months month, final int day) {
		return new IsAfter<Date>(new DateWrapper(year, month.month(), day), new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is after the end of
	 * the reference year
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, after(2012, Months.MAY, 12));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param day the day of the month against which the examined date is
	 *            checked
	 */
	public static Matcher<Date> after(final int year, final Month month, final int day) {
		return new IsAfter<Date>(new DateWrapper(year, month, day), new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is after the end of
	 * the reference year
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, after(2012, Months.MAY, 12, 23, 00, 01));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param day the day of the month against which the examined date is
	 *            checked
	 * @param hour the hour of the day against which the examined date is
	 *            checked
	 * @param minute the minute of the hour against which the examined date is
	 *            checked
	 * @param second the second of the minute against which the examined date is
	 *            checked
	 * @deprecated Use {@link #after(int, Month, int, int, int, int)}
	 */
	@Deprecated
	public static Matcher<Date> after(final int year,
	        final Months month,
	        final int dayOfMonth,
	        final int hour,
	        final int minute,
	        final int second) {
		return after(year, month.month(), dayOfMonth, hour, minute, second);
	}

	/**
	 * Creates a matcher that matches when the examined date is after the end of
	 * the reference year
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, after(2012, Months.MAY, 12, 23, 00, 01));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param day the day of the month against which the examined date is
	 *            checked
	 * @param hour the hour of the day against which the examined date is
	 *            checked
	 * @param minute the minute of the hour against which the examined date is
	 *            checked
	 * @param second the second of the minute against which the examined date is
	 *            checked
	 */
	public static Matcher<Date> after(final int year,
	        final Month month,
	        final int dayOfMonth,
	        final int hour,
	        final int minute,
	        final int second) {
		return new IsAfter<Date>(new DateWrapper(year, month, dayOfMonth, hour, minute, second), new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is before the
	 * reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, before(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<Date> before(final Date date) {
		return new IsBefore<Date>(new DateWrapper(date), new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is before the
	 * reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, before(LocalDate.now()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<Date> before(final LocalDate date) {
		return new IsBefore<Date>(new DateWrapper(date), new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is before the
	 * reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, before(Moments.today()));
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 * @deprecated Use {@link #before(LocalDate)}
	 */
	@Deprecated
	public static Matcher<Date> before(final DayMonthYear date) {
		return before(date.toLocalDate());
	}

	/**
	 * Creates a matcher that matches when the examined date is before the start
	 * of reference day
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, before(2012, Months.MAY, 12));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param dayOfMonth the day of the month against which the examined date is
	 *            checked
	 * @deprecated Use {@link #before(int, Month, int)}
	 */
	@Deprecated
	public static Matcher<Date> before(final int year, final Months month, final int dayOfMonth) {
		return new IsBefore<Date>(new DateWrapper(year, month.month(), dayOfMonth), new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is before the start
	 * of reference day
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, before(2012, Months.MAY, 12));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param dayOfMonth the day of the month against which the examined date is
	 *            checked
	 */
	public static Matcher<Date> before(final int year, final Month month, final int dayOfMonth) {
		return new IsBefore<Date>(new DateWrapper(year, month, dayOfMonth), new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is before the start
	 * of the reference date and time
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, before(2012, Months.MAY, 12, 23, 00, 01));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param day the day of the month against which the examined date is
	 *            checked
	 * @param hour the hour of the day against which the examined date is
	 *            checked
	 * @param minute the minute of the hour against which the examined date is
	 *            checked
	 * @param second the second of the minute against which the examined date is
	 *            checked
	 * @deprecated Use {@link #before(int, Month, int, int, int, int)}
	 */
	@Deprecated
	public static Matcher<Date> before(final int year,
	        final Months month,
	        final int dayOfMonth,
	        final int hour,
	        final int minute,
	        final int second) {
		return before(year, month.month(), dayOfMonth, hour, minute, second);
	}

	/**
	 * Creates a matcher that matches when the examined date is before the start
	 * of the reference date and time
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, before(2012, Months.MAY, 12, 23, 00, 01));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param day the day of the month against which the examined date is
	 *            checked
	 * @param hour the hour of the day against which the examined date is
	 *            checked
	 * @param minute the minute of the hour against which the examined date is
	 *            checked
	 * @param second the second of the minute against which the examined date is
	 *            checked
	 */
	public static Matcher<Date> before(final int year,
	        final Month month,
	        final int dayOfMonth,
	        final int hour,
	        final int minute,
	        final int second) {
		return new IsBefore<Date>(new DateWrapper(year, month, dayOfMonth, hour, minute, second), new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * of the week as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameWeekday(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameDayOfWeek(final Date date) {
		return isDayOfWeek(DayOfWeek.from(date.toInstant().atZone(ZoneId.systemDefault())));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * of the week as the supplied day
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isDayOfWeek(Weekdays.MONDAY))
	 * </pre>
	 *
	 * @param weekday the reference weekday against which the examined date is
	 *            checked
	 * @deprecated Use {@link #isDayOfWeek(DayOfWeek...)}
	 */
	@Deprecated
	public static Matcher<Date> isDayOfWeek(final Weekdays dayOfWeek) {
		return new IsDayOfWeek<Date>(asList(dayOfWeek.getAsDayOfWeek()), DateMatchers::dateToZoneDateTime);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * of the week as the supplied day
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isDayOfWeek(DayOfWeek.MONDAY))
	 * </pre>
	 *
	 * @param weekday the reference weekday against which the examined date is
	 *            checked
	 */
	public static Matcher<Date> isDayOfWeek(final DayOfWeek... daysOfWeek) {
		return new IsDayOfWeek<Date>(Arrays.asList(daysOfWeek), DateMatchers::dateToZoneDateTime);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * of the month as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameDayOfMonth(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameDayOfMonth(final Date date) {
		return isDayOfMonth(extractField(date, ChronoField.DAY_OF_MONTH));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the expected
	 * day of the month
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isDayOfMonth(4))
	 * </pre>
	 *
	 * @param date the expected day of the month
	 */
	public static Matcher<Date> isDayOfMonth(final int dayOfMonth) {
		return new IsDayOfMonth<Date>(dayOfMonth, DateMatchers::dateToZoneDateTime);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * of the year as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameDay(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameDay(final Date date) {
		return new IsSameDay<Date>(new DateWrapper(date), new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * of the year as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameDay(Moments.today()));
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 * @deprecated Use {@link #sameDay(LocalDate)}
	 */
	@Deprecated
	public static Matcher<Date> sameDay(final DayMonthYear date) {
		return sameDay(date.toLocalDate());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * of the year as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameDay(Moments.today()));
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameDay(final LocalDate date) {
		return new IsSameDay<Date>(new DateWrapper(date), new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * of the year as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameDayOfTheYear(2012, Month.JAN, 1))
	 * </pre>
	 *
	 * @param day the reference day of the month against which the examined date
	 *            is checked
	 * @param month the reference month against which the examined date is
	 *            checked
	 * @param year the reference year against which the examined date is checked
	 * @deprecated Use {@link #isDay(int, Month, int)}
	 */
	@Deprecated
	public static Matcher<Date> sameDay(final int year, final Months month, final int day) {
		return isDay(year, month.month(), day);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * of the year as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameDayOfTheYear(2012, Month.JAN, 1))
	 * </pre>
	 *
	 * @param dayOfMonth the reference day of the month against which the
	 *            examined date is checked
	 * @param month the reference month against which the examined date is
	 *            checked
	 * @param year the reference year against which the examined date is checked
	 */
	public static Matcher<Date> isDay(final int year, final Month month, final int dayOfMonth) {
		return sameDay(LocalDate.of(year, month, dayOfMonth));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same hour
	 * as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameHour(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 * @deprecated Use {@link #sameHourOfDay(Date)} instead
	 */
	@Deprecated
	public static Matcher<Date> sameHour(final Date date) {
		return sameHourOfDay(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same hour
	 * as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameHourOfDay(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameHourOfDay(final Date date) {
		return isHour(extractField(date, ChronoField.HOUR_OF_DAY));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same hour
	 * as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameHour(12));
	 * </pre>
	 *
	 * @param hour the reference hour against which the examined date is checked
	 * @deprecated Use {@link #isHour(int)} instead
	 */

	@Deprecated
	public static Matcher<Date> sameHour(final int hour) {
		return isHour(hour);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same hour
	 * as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameHour(12));
	 * </pre>
	 *
	 * @param hour the reference hour against which the examined date is checked
	 */

	public static Matcher<Date> isHour(final int hour) {
		return new IsHour<Date>(hour, DateMatchers::dateToZoneDateTime);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * instant as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameInstant(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameInstant(final Date date) {
		return new IsSame<Date>(new DateWrapper(date), new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same UTC
	 * instant as the reference UTC epoch time supplied
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameInstant(1325415600000L))
	 * </pre>
	 *
	 * @param timestamp the time as milliseconds since the Unix epoch time
	 */
	public static Matcher<Date> sameInstant(final long timestamp) {
		return new IsSame<Date>(new DateWrapper(new Date(timestamp)), new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * instance as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameInstant(2012, Months.MAY, 12, 23, 00, 01, 123));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param day the day of the month against which the examined date is
	 *            checked
	 * @param hour the hour of the day against which the examined date is
	 *            checked
	 * @param minute the minute of the hour against which the examined date is
	 *            checked
	 * @param second the second of the minute against which the examined date is
	 *            checked
	 * @param milliseconds the milliseconds of the second against which the
	 *            examined date is checked
	 * @deprecated Use {@link #isInstant(int, Month, int, int, int, int, int)}
	 */
	@Deprecated
	public static Matcher<Date> sameInstant(final int year,
	        final Months month,
	        final int dayOfMonth,
	        final int hour,
	        final int minute,
	        final int second,
	        final int milliseconds) {
		return isInstant(year, month.month(), dayOfMonth, hour, minute, second, milliseconds);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * instance as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameInstant(2012, Months.MAY, 12, 23, 00, 01, 123));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param day the day of the month against which the examined date is
	 *            checked
	 * @param hour the hour of the day against which the examined date is
	 *            checked
	 * @param minute the minute of the hour against which the examined date is
	 *            checked
	 * @param second the second of the minute against which the examined date is
	 *            checked
	 * @param milliseconds the milliseconds of the second against which the
	 *            examined date is checked
	 */
	public static Matcher<Date> isInstant(final int year,
	        final Month month,
	        final int dayOfMonth,
	        final int hour,
	        final int minute,
	        final int second,
	        final int milliseconds) {
		return new IsSame<Date>(
		        new DateWrapper(year, month, dayOfMonth, hour, minute, second, milliseconds),
		            new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is at the same
	 * instant or before the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameOrBefore(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameOrBefore(final Date date) {
		return new IsSameOrBefore<Date>(new DateWrapper(date), new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is at the same
	 * instant or before the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameOrBefore(LocalDate.now()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameOrBefore(final LocalDate date) {
		return new IsSameOrBefore<Date>(new DateWrapper(date), new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is at the same date
	 * or before the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameOrBefore(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 * @deprecated Use {@link #sameOrBefore(LocalDate)}
	 */
	@Deprecated
	public static Matcher<Date> sameOrBefore(final DayMonthYear date) {
		return sameOrBefore(date.toLocalDate());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * or before the start of the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameOrBefore(2012, Months.MAY, 12));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param dayOfMonth the day of the month against which the examined date is
	 *            checked
	 * @deprecated Use {@link #sameOrBefore(int, Month, int)}
	 */
	@Deprecated
	public static Matcher<Date> sameOrBefore(final int year, final Months month, final int dayOfMonth) {
		return sameOrBefore(year, month.month(), dayOfMonth);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * or before the start of the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameOrBefore(2012, Months.MAY, 12));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param dayOfMonth the day of the month against which the examined date is
	 *            checked
	 */
	public static Matcher<Date> sameOrBefore(final int year, final Month month, final int dayOfMonth) {
		return new IsSameOrBefore<Date>(new DateWrapper(LocalDate.of(year, month, dayOfMonth)), new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * second or before the start of the reference date and time
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameOrBefore(2012, Months.MAY, 12, 23, 00, 01));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param dayOfMonth the day of the month against which the examined date is
	 *            checked
	 * @param hour the hour of the day against which the examined date is
	 *            checked
	 * @param minute the minute of the hour against which the examined date is
	 *            checked
	 * @param second the second of the minute against which the examined date is
	 *            checked
	 * @deprecated See {@link #sameOrBefore(int, Month, int, int, int, int)}
	 */
	@Deprecated
	public static Matcher<Date> sameOrBefore(final int year,
	        final Months month,
	        final int dayOfMonth,
	        final int hour,
	        final int minute,
	        final int second) {
		return sameOrBefore(year, month.month(), dayOfMonth, hour, minute, second);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * second or before the start of the reference date and time
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameOrBefore(2012, Months.MAY, 12, 23, 00, 01));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param dayOfMonth the day of the month against which the examined date is
	 *            checked
	 * @param hour the hour of the day against which the examined date is
	 *            checked
	 * @param minute the minute of the hour against which the examined date is
	 *            checked
	 * @param second the second of the minute against which the examined date is
	 *            checked
	 */

	public static Matcher<Date> sameOrBefore(final int year,
	        final Month month,
	        final int dayOfMonth,
	        final int hour,
	        final int minute,
	        final int second) {
		return new IsSameOrBefore<Date>(
		        new DateWrapper(year, month, dayOfMonth, hour, minute, second),
		            new DateFormatter());
	}

	/**
	 * F Creates a matcher that matches when the examined date is at the same
	 * instant or after the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameOrAfter(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameOrAfter(final Date date) {
		return new IsSameOrAfter<Date>(new DateWrapper(date), new DateFormatter());
	}

	/**
	 * F Creates a matcher that matches when the examined date is at the same
	 * instant or after the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameOrAfter(LocalDate.now()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameOrAfter(final LocalDate date) {
		return new IsSameOrAfter<Date>(new DateWrapper(date), new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is at the same
	 * instant or after the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameOrAfter(Moments.today()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 * @deprecated Use {@link #sameOrAfter(LocalDate)}
	 */
	@Deprecated
	public static Matcher<Date> sameOrAfter(final DayMonthYear date) {
		return sameOrAfter(date.toLocalDate());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * or after the start of the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameOrAfter(2012, Months.MAY, 12));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param dayOfMonth the day of the month against which the examined date is
	 *            checked
	 * @deprecated Use {@link #sameOrAfter(int, Month, int)
	 */
	@Deprecated
	public static Matcher<Date> sameOrAfter(final int year, final Months month, final int dayOfMonth) {
		return sameOrAfter(year, month.month(), dayOfMonth);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * or after the start of the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameOrAfter(2012, Months.MAY, 12));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param dayOfMonth the day of the month against which the examined date is
	 *            checked
	 */
	public static Matcher<Date> sameOrAfter(final int year, final Month month, final int dayOfMonth) {
		return new IsSameOrAfter<Date>(new DateWrapper(year, month, dayOfMonth), new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * second or after the start of the reference date and time
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameOrAfter(2012, Months.MAY, 12, 23, 00, 01));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param day the day of the month against which the examined date is
	 *            checked
	 * @param hour the hour of the day against which the examined date is
	 *            checked
	 * @param minute the minute of the hour against which the examined date is
	 *            checked
	 * @param second the second of the minute against which the examined date is
	 *            checked
	 * @deprecated Use {@link #sameOrAfter(int, Month, int, int, int, int)}
	 */
	@Deprecated
	public static Matcher<Date> sameOrAfter(final int year,
	        final Months month,
	        final int dayOfMonth,
	        final int hour,
	        final int minute,
	        final int second) {
		return sameOrAfter(year, month.month(), dayOfMonth, hour, minute, second);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * second or after the start of the reference date and time
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameOrAfter(2012, Months.MAY, 12, 23, 00, 01));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param day the day of the month against which the examined date is
	 *            checked
	 * @param hour the hour of the day against which the examined date is
	 *            checked
	 * @param minute the minute of the hour against which the examined date is
	 *            checked
	 * @param second the second of the minute against which the examined date is
	 *            checked
	 */

	public static Matcher<Date> sameOrAfter(final int year,
	        final Month month,
	        final int dayOfMonth,
	        final int hour,
	        final int minute,
	        final int second) {
		return new IsSameOrAfter<Date>(
		        new DateWrapper(year, month, dayOfMonth, hour, minute, second),
		            new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * minute as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameMinute(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 * @deprecated Use {@link #sameMinuteOfHour(Date)} instead
	 */
	@Deprecated
	public static Matcher<Date> sameMinute(final Date date) {
		return sameMinuteOfHour(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * minute as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameMinute(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameMinuteOfHour(final Date date) {
		return isMinute(extractField(date, ChronoField.MINUTE_OF_HOUR));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the reference
	 * minute
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameMinute(55))
	 * </pre>
	 *
	 * @param minute the reference minute against which the examined date is
	 *            checked
	 * @deprecated Use {@link #isMinute(int)} instead
	 */
	@Deprecated
	public static Matcher<Date> sameMinute(final int minute) {
		return isMinute(minute);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the reference
	 * minute
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameMinute(55))
	 * </pre>
	 *
	 * @param minute the reference minute against which the examined date is
	 *            checked
	 */
	public static Matcher<Date> isMinute(final int minute) {
		return new IsMinute<Date>(minute, DateMatchers::dateToZoneDateTime);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * month as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameMonth(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 * @deprecated Use {@link #sameMonthOfYear(Date)} instead
	 */
	@Deprecated
	public static Matcher<Date> sameMonth(final Date date) {
		return sameMonthOfYear(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * month as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameMonth(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameMonthOfYear(final Date date) {
		return isMonth(Month.of(date.toInstant().atZone(ZoneId.systemDefault()).get(ChronoField.MONTH_OF_YEAR)));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * month as the reference month
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameMonth(Months.DECEMBER))
	 * </pre>
	 *
	 * @param month the reference month against which the examined date is
	 *            checked
	 * @deprecated Use {@link #sameMonthOfYear(Months)} instead
	 */
	@Deprecated
	public static Matcher<Date> sameMonth(final Months month) {
		return sameMonthOfYear(month);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * month as the reference month
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameMonth(Months.DECEMBER))
	 * </pre>
	 *
	 * @param month the reference month against which the examined date is
	 *            checked
	 * @deprecated Use {@link #isMonth(Month)}
	 */
	@Deprecated
	public static Matcher<Date> sameMonthOfYear(final Months month) {
		return isMonth(month.month());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * second as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameSecond(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 * @deprecated Use {@link #sameSecondOfMinute(Date)} instead
	 */
	@Deprecated
	public static Matcher<Date> sameSecond(final Date date) {
		return sameSecondOfMinute(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * second as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameSecond(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameSecondOfMinute(final Date date) {
		return isSecond(extractField(date, ChronoField.SECOND_OF_MINUTE));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the reference
	 * second
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameSecond(33))
	 * </pre>
	 *
	 * @param second the reference date against which the examined date is
	 *            checked
	 * @deprecated Use {@link #isSecond(int)} instead
	 */
	@Deprecated
	public static Matcher<Date> sameSecond(final int second) {
		return isSecond(second);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the reference
	 * second
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameSecond(33))
	 * </pre>
	 *
	 * @param second the reference date against which the examined date is
	 *            checked
	 */
	public static Matcher<Date> isSecond(final int second) {
		return new IsSecond<Date>(second, DateMatchers::dateToZoneDateTime);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * millisecond as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameMillisecond(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 * @deprecated Use {@link #sameMillisecondOfSecond(Date)} instead
	 */
	@Deprecated
	public static Matcher<Date> sameMillisecond(final Date date) {
		return sameMillisecondOfSecond(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * millisecond as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameMillisecond(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameMillisecondOfSecond(final Date date) {
		return isMillisecond(extractField(date, ChronoField.MILLI_OF_SECOND));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the reference
	 * second
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameMillisecond(123))
	 * </pre>
	 *
	 * @param millisecond the millisecond against which the examined date is
	 *            checked
	 * @deprecated Use {@link #isMillisecond(int)} instead
	 */
	@Deprecated
	public static Matcher<Date> sameMillisecond(final int millisecond) {
		return isMillisecond(millisecond);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the reference
	 * second
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameMillisecond(123))
	 * </pre>
	 *
	 * @param millisecond the millisecond against which the examined date is
	 *            checked
	 */
	public static Matcher<Date> isMillisecond(final int millisecond) {
		return new IsMillisecond<Date>(millisecond, DateMatchers::dateToZoneDateTime);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same year
	 * as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameYear(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameYear(final Date date) {
		return isYear(extractField(date, ChronoField.YEAR));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same year
	 * as the reference year
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameYear(2013))
	 * </pre>
	 *
	 * @param year the reference year against which the examined date is checked
	 */
	public static Matcher<Date> isYear(final int year) {
		return new IsYear<Date>(year, DateMatchers::dateToZoneDateTime);
	}

	/**
	 * Creates a matcher that matches when the examined date is within a defined
	 * period the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, within(10, TimeUnit.MINUTES, new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 * @deprecated Use {@link #within(long, ChronoUnit, Date)}
	 */
	@Deprecated
	public static Matcher<Date> within(final long period, final TimeUnit unit, final Date date) {
		return within(period, convertUnit(unit), date);
	}

	/**
	 * Creates a matcher that matches when the examined date is within a defined
	 * period the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, within(10, TimeUnit.MINUTES, new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<Date> within(final long period, final ChronoUnit unit, final Date date) {
		return new IsWithin<Date>(period, unit, new DateWrapper(date), new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is within a defined
	 * period the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, within(10, ChronoUnit.DAYS, LocalDate.now()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<Date> within(final long period, final ChronoUnit unit, final LocalDate date) {
		return new IsWithin<Date>(period, unit, new DateWrapper(date), new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is within a defined
	 * period the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, within(10, TimeUnit.DAYS, Moments.today()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 * @deprecated Use {@link #within(long, ChronoUnit, LocalDate)}
	 */
	@Deprecated
	public static Matcher<Date> within(final long period, final TimeUnit unit, final DayMonthYear date) {
		return within(period, convertUnit(unit), date.toLocalDate());
	}

	/**
	 * Creates a matcher that matches when the examined date is within a given
	 * period of the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, within(5, TimeUnit.DAYS, 2012, Months.MAY, 12));
	 * </pre>
	 *
	 * @param period the timeunit interval the examined date should be with
	 * @param unit the timeunit to define the length of the period
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param dayOfMonth the day of the month against which the examined date is
	 *            checked
	 * @deprecated Use {@link #within(long, ChronoUnit, int, Month, int)}
	 */
	@Deprecated
	public static Matcher<Date> within(final long period,
	        final TimeUnit unit,
	        final int year,
	        final Months month,
	        final int dayOfMonth) {
		return within(period, convertUnit(unit), year, month.month(), dayOfMonth);
	}

	/**
	 * Creates a matcher that matches when the examined date is within a given
	 * period of the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, within(5, TimeUnit.DAYS, 2012, Months.MAY, 12));
	 * </pre>
	 *
	 * @param period the timeunit interval the examined date should be with
	 * @param unit the timeunit to define the length of the period
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param dayOfMonth the day of the month against which the examined date is
	 *            checked
	 */
	public static Matcher<Date> within(final long period,
	        final ChronoUnit unit,
	        final int year,
	        final Month month,
	        final int dayOfMonth) {
		return within(period, unit, LocalDate.of(year, month, dayOfMonth));
	}

	/**
	 * Creates a matcher that matches when the examined date is within a given
	 * period of the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, within(1, TimeUnit.MINUTES, 2012, Months.MAY, 12, 23, 00, 01));
	 * </pre>
	 *
	 * @param period the timeunit interval the examined date should be with
	 * @param unit the timeunit to define the length of the period
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param day the day of the month against which the examined date is
	 *            checked
	 * @param hour the hour of the day against which the examined date is
	 *            checked
	 * @param minute the minute of the hour against which the examined date is
	 *            checked
	 * @param second the second of the minute against which the examined date is
	 *            checked
	 * @param second the millisecond of the second against which the examined
	 *            date is checked
	 * @deprecated Use
	 *             {@link #within(long, ChronoUnit, int, Month, int, int, int, int, int)}
	 */
	@Deprecated
	public static Matcher<Date> within(final long period,
	        final TimeUnit unit,
	        final int year,
	        final Months month,
	        final int dayOfMonth,
	        final int hour,
	        final int minute,
	        final int second,
	        final int milliseconds) {
		return within(period, convertUnit(unit), year, month.month(), dayOfMonth, hour, minute, second, milliseconds);
	}

	/**
	 * Creates a matcher that matches when the examined date is within a given
	 * period of the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, within(1, TimeUnit.MINUTES, 2012, Months.MAY, 12, 23, 00, 01));
	 * </pre>
	 *
	 * @param period the timeunit interval the examined date should be with
	 * @param unit the timeunit to define the length of the period
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param day the day of the month against which the examined date is
	 *            checked
	 * @param hour the hour of the day against which the examined date is
	 *            checked
	 * @param minute the minute of the hour against which the examined date is
	 *            checked
	 * @param second the second of the minute against which the examined date is
	 *            checked
	 * @param second the millisecond of the second against which the examined
	 *            date is checked
	 */
	public static Matcher<Date> within(final long period,
	        final ChronoUnit unit,
	        final int year,
	        final Month month,
	        final int dayOfMonth,
	        final int hour,
	        final int minute,
	        final int second,
	        final int milliseconds) {
		return new IsWithin<Date>(
		        period,
		            unit,
		            new DateWrapper(year, month, dayOfMonth, hour, minute, second, milliseconds),
		            new DateFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is yesterday
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isToday());
	 * </pre>
	 */
	public static Matcher<Date> isYesterday() {
		return sameDay(LocalDate.now().minusDays(1));
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
	public static Matcher<Date> isToday() {
		return sameDay(LocalDate.now());
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
	public static Matcher<Date> isTomorrow() {
		return sameDay(LocalDate.now().plusDays(1));
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
	public static Matcher<Date> isMonday() {
		return new IsDayOfWeek<Date>(DayOfWeek.MONDAY, DateMatchers::dateToZoneDateTime);
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
	public static Matcher<Date> isTuesday() {
		return new IsDayOfWeek<Date>(DayOfWeek.TUESDAY, DateMatchers::dateToZoneDateTime);
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
	public static Matcher<Date> isWednesday() {
		return new IsDayOfWeek<Date>(DayOfWeek.WEDNESDAY, DateMatchers::dateToZoneDateTime);
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
	public static Matcher<Date> isThursday() {
		return new IsDayOfWeek<Date>(DayOfWeek.THURSDAY, DateMatchers::dateToZoneDateTime);
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
	public static Matcher<Date> isFriday() {
		return new IsDayOfWeek<Date>(DayOfWeek.FRIDAY, DateMatchers::dateToZoneDateTime);
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
	public static Matcher<Date> isSaturday() {
		return new IsDayOfWeek<Date>(DayOfWeek.SATURDAY, DateMatchers::dateToZoneDateTime);
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
	public static Matcher<Date> isSunday() {
		return new IsDayOfWeek<Date>(DayOfWeek.SUNDAY, DateMatchers::dateToZoneDateTime);
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
	public static Matcher<Date> isWeekday() {
		return isDayOfWeek(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY);
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
	public static Matcher<Date> isWeekend() {
		return isDayOfWeek(SATURDAY, SUNDAY);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the first day
	 * of the month
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isFirstDayOfMonth());
	 * </pre>
	 */
	public static Matcher<Date> isFirstDayOfMonth() {
		return isMinimum(ChronoField.DAY_OF_MONTH);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the maximum
	 * value of the given date part in its period
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isMaximumDayOfMonth(ChronoField.DAY_OF_MONTH));
	 * </pre>
	 *
	 * @param field the temporal field to check
	 */
	public static Matcher<Date> isMinimum(final TemporalField field) {
		return new IsMinimum<Date>(field, DateMatchers::dateToZoneDateTime);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the first day
	 * of the month
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isFirstDayOfMonth());
	 * </pre>
	 */
	public static Matcher<Date> isLastDayOfMonth() {
		return isMaximum(ChronoField.DAY_OF_MONTH);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the maximum
	 * value of the given date part in its period
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isMaximum(ChronoField.DAY_OF_MONTH));
	 * </pre>
	 *
	 * @param field the temporal field to check
	 */
	public static Matcher<Date> isMaximum(final TemporalField field) {
		return new IsMaximum<Date>(field, DateMatchers::dateToZoneDateTime);
	}

	/**
	 * Creates a matcher that matches when the examined date is in the expected
	 * month
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isMonth(Month.AUGUST));
	 * </pre>
	 */
	public static Matcher<Date> isMonth(final Month month) {
		return new IsMonth<Date>(month, DateMatchers::dateToZoneDateTime);
	}

	/**
	 * Creates a matcher that matches when the examined date is in January
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isJanuary());
	 * </pre>
	 */
	public static Matcher<Date> isJanuary() {
		return isMonth(JANUARY);
	}

	/**
	 * Creates a matcher that matches when the examined date is in February
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isFebruary());
	 * </pre>
	 */
	public static Matcher<Date> isFebruary() {
		return isMonth(FEBRUARY);
	}

	/**
	 * Creates a matcher that matches when the examined date is in March
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isMarch());
	 * </pre>
	 */
	public static Matcher<Date> isMarch() {
		return isMonth(MARCH);
	}

	/**
	 * Creates a matcher that matches when the examined date is in April
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isApril());
	 * </pre>
	 */
	public static Matcher<Date> isApril() {
		return isMonth(APRIL);
	}

	/**
	 * Creates a matcher that matches when the examined date is in May
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isMay());
	 * </pre>
	 */
	public static Matcher<Date> isMay() {
		return isMonth(MAY);
	}

	/**
	 * Creates a matcher that matches when the examined date is in June
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isJune());
	 * </pre>
	 */
	public static Matcher<Date> isJune() {
		return isMonth(JUNE);
	}

	/**
	 * Creates a matcher that matches when the examined date is in July
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isJuly());
	 * </pre>
	 */
	public static Matcher<Date> isJuly() {
		return isMonth(JULY);
	}

	/**
	 * Creates a matcher that matches when the examined date is in August
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isAugust());
	 * </pre>
	 */
	public static Matcher<Date> isAugust() {
		return isMonth(AUGUST);
	}

	/**
	 * Creates a matcher that matches when the examined date is in September
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isSeptember());
	 * </pre>
	 */
	public static Matcher<Date> isSeptember() {
		return isMonth(SEPTEMBER);
	}

	/**
	 * Creates a matcher that matches when the examined date is in October
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isOctober());
	 * </pre>
	 */
	public static Matcher<Date> isOctober() {
		return isMonth(OCTOBER);
	}

	/**
	 * Creates a matcher that matches when the examined date is in November
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isNovember());
	 * </pre>
	 */
	public static Matcher<Date> isNovember() {
		return isMonth(NOVEMBER);
	}

	/**
	 * Creates a matcher that matches when the examined date is in December
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isDecember());
	 * </pre>
	 */
	public static Matcher<Date> isDecember() {
		return isMonth(DECEMBER);
	}

	/**
	 * Creates a matcher that matches when the examined date is a leap year
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isLeapYear());
	 * </pre>
	 */
	public static Matcher<Date> isLeapYear() {
		return new IsLeapYear<Date>(DateMatchers::dateToZoneDateTime);
	}

	private static ChronoUnit convertUnit(final TimeUnit unit) {
		switch (unit) {
		case DAYS:
			return ChronoUnit.DAYS;
		case HOURS:
			return ChronoUnit.HOURS;
		case MICROSECONDS:
			return ChronoUnit.MICROS;
		case MILLISECONDS:
			return ChronoUnit.MILLIS;
		case MINUTES:
			return ChronoUnit.MINUTES;
		case NANOSECONDS:
			return ChronoUnit.NANOS;
		case SECONDS:
			return ChronoUnit.SECONDS;
		default:
			throw new IllegalArgumentException("Unknown TimeUnit '" + unit + "'");
		}
	}

	private static int extractField(final Date date, final ChronoField field) {
		return dateToZoneDateTime(date).get(field);
	}

	private static Temporal dateToZoneDateTime(final Date date) {
		return date.toInstant().atZone(systemDefault());
	}

}
