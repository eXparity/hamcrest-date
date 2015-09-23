package org.exparity.hamcrest.date;

import static java.util.Calendar.getInstance;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.exparity.hamcrest.date.core.DateFormatter;
import org.exparity.hamcrest.date.core.DateWrapper;
import org.exparity.hamcrest.date.core.IsAfter;
import org.exparity.hamcrest.date.core.IsSameOrAfter;
import org.exparity.hamcrest.date.core.IsSameOrBefore;
import org.hamcrest.Factory;
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> after(final Date date) {
		return new IsAfter<Date>(date);
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> after(final DayMonthYear date) {
		return after(date.getYear(), date.getMonth(), date.getDay());
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
	 * @param year
	 *            the year against which the examined date is checked
	 * @param month
	 *            the month against which the examined date is checked
	 * @param day
	 *            the day of the month against which the examined date is
	 *            checked
	 */
	public static Matcher<Date> after(final int year, final Months month, final int day) {
		return after(year, month, day, 23, 59, 59);
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
	 * @param year
	 *            the year against which the examined date is checked
	 * @param month
	 *            the month against which the examined date is checked
	 * @param day
	 *            the day of the month against which the examined date is
	 *            checked
	 * @param hour
	 *            the hour of the day against which the examined date is checked
	 * @param minute
	 *            the minute of the hour against which the examined date is
	 *            checked
	 * @param second
	 *            the second of the minute against which the examined date is
	 *            checked
	 */
	public static Matcher<Date> after(final int year,
			final Months month,
			final int date,
			final int hour,
			final int minute,
			final int second) {
		return after(toDate(year, month, date, hour, minute, second, 999));
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> before(final Date date) {
		return new org.exparity.hamcrest.date.core.IsBefore<Date>(date);
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> before(final DayMonthYear date) {
		return before(date.getYear(), date.getMonth(), date.getDay());
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
	 * @param year
	 *            the year against which the examined date is checked
	 * @param month
	 *            the month against which the examined date is checked
	 * @param day
	 *            the day of the month against which the examined date is
	 *            checked
	 */
	public static Matcher<Date> before(final int year, final Months month, final int day) {
		return before(year, month, day, 0, 0, 0);
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
	 * @param year
	 *            the year against which the examined date is checked
	 * @param month
	 *            the month against which the examined date is checked
	 * @param day
	 *            the day of the month against which the examined date is
	 *            checked
	 * @param hour
	 *            the hour of the day against which the examined date is checked
	 * @param minute
	 *            the minute of the hour against which the examined date is
	 *            checked
	 * @param second
	 *            the second of the minute against which the examined date is
	 *            checked
	 */
	public static Matcher<Date> before(final int year,
			final Months month,
			final int date,
			final int hour,
			final int minute,
			final int second) {
		return before(toDate(year, month, date, hour, minute, second, 0));
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameDayOfWeek(final Date date) {
		return IsSameDayOfWeek.sameDayOfWeek(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * of the week as the supplied day
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameDayOfTheWeek(new Date()))
	 * </pre>
	 * 
	 * @param weekday
	 *            the reference weekday against which the examined date is
	 *            checked
	 */
	public static Matcher<Date> sameDayOfWeek(final Weekdays weekday) {
		return IsSameDayOfWeek.sameDayOfWeek(weekday);
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameDay(final Date date) {
		return IsSameDay.sameDay(date);
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameDay(final DayMonthYear date) {
		return IsSameDay.sameDay(date);
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
	 * @param day
	 *            the reference day of the month against which the examined date
	 *            is checked
	 * @param month
	 *            the reference month against which the examined date is checked
	 * @param year
	 *            the reference year against which the examined date is checked
	 */
	public static Matcher<Date> sameDay(final int year, final Months month, final int day) {
		return IsSameDay.sameDay(year, month, day);
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @deprecated Use {@link #sameHourOfDay(Date)} instead
	 */
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameHourOfDay(final Date date) {
		return IsSameHourOfDay.sameHour(date);
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
	 * @param hour
	 *            the reference hour against which the examined date is checked
	 * @deprecated Use {@link #sameHourOfDay(int)} instead
	 */

	public static Matcher<Date> sameHour(final int hour) {
		return sameHourOfDay(hour);
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
	 * @param hour
	 *            the reference hour against which the examined date is checked
	 */

	public static Matcher<Date> sameHourOfDay(final int hour) {
		return IsSameHourOfDay.sameHourOfDay(hour);
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameInstant(final Date date) {
		return IsSameInstant.sameInstant(date);
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
	 * @param timestamp
	 *            the time as milliseconds since the Unix epoch time
	 */
	public static Matcher<Date> sameInstant(final long timestamp) {
		return IsSameInstant.sameInstant(timestamp);
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
	 * @param year
	 *            the year against which the examined date is checked
	 * @param month
	 *            the month against which the examined date is checked
	 * @param day
	 *            the day of the month against which the examined date is
	 *            checked
	 * @param hour
	 *            the hour of the day against which the examined date is checked
	 * @param minute
	 *            the minute of the hour against which the examined date is
	 *            checked
	 * @param second
	 *            the second of the minute against which the examined date is
	 *            checked
	 * @param milliseconds
	 *            the milliseconds of the second against which the examined date
	 *            is checked
	 */
	public static Matcher<Date> sameInstant(final int year,
			final Months month,
			final int date,
			final int hour,
			final int minute,
			final int second,
			final int milliseconds) {
		return IsSameInstant.sameInstant(year, month, date, hour, minute, second, milliseconds);
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameOrBefore(final Date date) {
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameOrBefore(final DayMonthYear date) {
		return sameOrBefore(date.getYear(), date.getMonth(), date.getDay());
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
	 * @param year
	 *            the year against which the examined date is checked
	 * @param month
	 *            the month against which the examined date is checked
	 * @param dayOfMonth
	 *            the day of the month against which the examined date is
	 *            checked
	 */
	@Factory
	public static Matcher<Date> sameOrBefore(final int year, final Months month, final int dayOfMonth) {
		return new IsSameOrBefore<Date>(new DateWrapper(LocalDate.of(year, month.month(), dayOfMonth)), new DateFormatter());
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
	 * @param year
	 *            the year against which the examined date is checked
	 * @param month
	 *            the month against which the examined date is checked
	 * @param dayOfMonth
	 *            the day of the month against which the examined date is
	 *            checked
	 * @param hour
	 *            the hour of the day against which the examined date is checked
	 * @param minute
	 *            the minute of the hour against which the examined date is
	 *            checked
	 * @param second
	 *            the second of the minute against which the examined date is
	 *            checked
	 */
	@Factory
	public static Matcher<Date> sameOrBefore(final int year,
			final Months month,
			final int dayOfMonth,
			final int hour,
			final int minute,
			final int second) {
		return new IsSameOrBefore<Date>(new DateWrapper(LocalDate.of(year, month.month(), dayOfMonth), LocalTime.of(hour, minute, second)), new DateFormatter());
	}

	/**F
	 * Creates a matcher that matches when the examined date is at the same
	 * instant or after the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameOrAfter(new Date()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameOrAfter(final Date date) {
		return new IsSameOrAfter<Date>(date);
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameOrAfter(final DayMonthYear date) {
		return sameOrAfter(date.getYear(), date.getMonth(), date.getDay());
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
	 * @param year
	 *            the year against which the examined date is checked
	 * @param month
	 *            the month against which the examined date is checked
	 * @param day
	 *            the day of the month against which the examined date is
	 *            checked
	 */
	public static Matcher<Date> sameOrAfter(final int year, final Months month, final int day) {
		return sameOrAfter(year, month, day, 0, 0, 0);
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
	 * @param year
	 *            the year against which the examined date is checked
	 * @param month
	 *            the month against which the examined date is checked
	 * @param day
	 *            the day of the month against which the examined date is
	 *            checked
	 * @param hour
	 *            the hour of the day against which the examined date is checked
	 * @param minute
	 *            the minute of the hour against which the examined date is
	 *            checked
	 * @param second
	 *            the second of the minute against which the examined date is
	 *            checked
	 */
	@Factory
	public static Matcher<Date> sameOrAfter(final int year,
			final Months month,
			final int date,
			final int hour,
			final int minute,
			final int second) {
		return sameOrAfter(toDate(year, month, date, hour, minute, second, 0));
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @deprecated Use {@link #sameMinuteOfHour(Date)} instead
	 */
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameMinuteOfHour(final Date date) {
		return IsSameMinuteOfHour.sameMinuteOfHour(date);
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
	 * @param minute
	 *            the reference minute against which the examined date is
	 *            checked
	 * @deprecated Use {@link #sameMinuteOfHour(int)} instead
	 */
	public static Matcher<Date> sameMinute(final int minute) {
		return sameMinuteOfHour(minute);
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
	 * @param minute
	 *            the reference minute against which the examined date is
	 *            checked
	 */
	public static Matcher<Date> sameMinuteOfHour(final int minute) {
		return IsSameMinuteOfHour.sameMinuteOfHour(minute);
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @deprecated Use {@link #sameMonthOfYear(Date)} instead
	 */
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameMonthOfYear(final Date date) {
		return IsSameMonthOfYear.sameMonthOfYear(date);
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
	 * @param month
	 *            the reference month against which the examined date is checked
	 * @deprecated Use {@link #sameMonthOfYear(Months)} instead
	 */
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
	 * @param month
	 *            the reference month against which the examined date is checked
	 */
	public static Matcher<Date> sameMonthOfYear(final Months month) {
		return IsSameMonthOfYear.sameMonthOfYear(month);
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @deprecated Use {@link #sameSecondOfMinute(Date)} instead
	 */
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameSecondOfMinute(final Date date) {
		return IsSameSecondOfMinute.sameSecondOfMinute(date);
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
	 * @param second
	 *            the reference date against which the examined date is checked
	 * @deprecated Use {@link #sameSecondOfMinute(int)} instead
	 */
	public static Matcher<Date> sameSecond(final int second) {
		return sameSecondOfMinute(second);
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
	 * @param second
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameSecondOfMinute(final int second) {
		return IsSameSecondOfMinute.sameSecondOfMinute(second);
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @deprecated Use {@link #sameMillisecondOfSecond(Date)} instead
	 */
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameMillisecondOfSecond(final Date date) {
		return IsSameMillisecondOfSecond.sameMillisecondOfSecond(date);
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
	 * @param millisecond
	 *            the millisecond against which the examined date is checked
	 * @deprecated Use {@link #sameMillisecondOfSecond(int)} instead
	 */
	public static Matcher<Date> sameMillisecond(final int millisecond) {
		return sameMillisecondOfSecond(millisecond);
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
	 * @param millisecond
	 *            the millisecond against which the examined date is checked
	 */
	public static Matcher<Date> sameMillisecondOfSecond(final int millisecond) {
		return IsSameMillisecondOfSecond.sameMillisecondOfSecond(millisecond);
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameYear(final Date date) {
		return IsSameYear.sameYear(date);
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
	 * @param year
	 *            the reference year against which the examined date is checked
	 */
	public static Matcher<Date> sameYear(final int year) {
		return IsSameYear.sameYear(year);
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> within(final long period, final TimeUnit unit, final Date date) {
		return IsWithin.within(period, unit, date);
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
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> within(final long period, final TimeUnit unit, final DayMonthYear date) {
		return IsWithin.within(period, unit, date);
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
	 * @param period
	 *            the timeunit interval the examined date should be with
	 * @param unit
	 *            the timeunit to define the length of the period
	 * @param year
	 *            the year against which the examined date is checked
	 * @param month
	 *            the month against which the examined date is checked
	 * @param day
	 *            the day of the month against which the examined date is
	 *            checked
	 */
	public static Matcher<Date> within(final long period,
			final TimeUnit unit,
			final int year,
			final Months month,
			final int day) {
		return IsWithin.within(period, unit, year, month, day);
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
	 * @param period
	 *            the timeunit interval the examined date should be with
	 * @param unit
	 *            the timeunit to define the length of the period
	 * @param year
	 *            the year against which the examined date is checked
	 * @param month
	 *            the month against which the examined date is checked
	 * @param day
	 *            the day of the month against which the examined date is
	 *            checked
	 * @param hour
	 *            the hour of the day against which the examined date is checked
	 * @param minute
	 *            the minute of the hour against which the examined date is
	 *            checked
	 * @param second
	 *            the second of the minute against which the examined date is
	 *            checked
	 * @param second
	 *            the millisecond of the second against which the examined date
	 *            is checked
	 */
	public static Matcher<Date> within(final long period,
			final TimeUnit unit,
			final int year,
			final Months month,
			final int date,
			final int hour,
			final int minute,
			final int second,
			final int milliseconds) {
		return IsWithin.within(period, unit, year, month, date, hour, minute, second, milliseconds);
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
		return IsDay.isYesterday();
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
		return IsDay.isToday();
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
		return IsDay.isTomorrow();
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
		return IsSameDayOfWeek.isMonday();
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
		return IsSameDayOfWeek.isTuesday();
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
		return IsSameDayOfWeek.isWednesday();
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
		return IsSameDayOfWeek.isThursday();
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
		return IsSameDayOfWeek.isFriday();
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
		return IsSameDayOfWeek.isSaturday();
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
		return IsSameDayOfWeek.isSunday();
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
		return IsSameDayOfWeek.isWeekday();
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
		return IsSameDayOfWeek.isWeekend();
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
		return IsDayOfMonth.isFirstDayOfMonth();
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
		return IsDayOfMonth.isLastDayOfMonth();
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
		return IsSameMonthOfYear.isJanuary();
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
		return IsSameMonthOfYear.isFebruary();
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
		return IsSameMonthOfYear.isMarch();
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
		return IsSameMonthOfYear.isApril();
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
		return IsSameMonthOfYear.isMay();
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
		return IsSameMonthOfYear.isJune();
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
		return IsSameMonthOfYear.isJuly();
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
		return IsSameMonthOfYear.isAugust();
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
		return IsSameMonthOfYear.isSeptember();
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
		return IsSameMonthOfYear.isOctober();
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
		return IsSameMonthOfYear.isNovember();
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
		return IsSameMonthOfYear.isDecember();
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
		return IsLeapYear.isLeapYear();
	}

	private static Date toDate(final int year,
			final Months month,
			final int date,
			final int hour,
			final int minute,
			final int second,
			int millis) {
		Calendar calendar = getInstance();
		calendar.set(year, month.calendarConstant(), date, hour, minute, second);
		calendar.set(Calendar.MILLISECOND, millis);
		return calendar.getTime();
	}

	private static Date truncateDate(Date d, ChronoUnit truncateTo) {
		return new Date(d.toInstant().truncatedTo(truncateTo).toEpochMilli());
	}

}
