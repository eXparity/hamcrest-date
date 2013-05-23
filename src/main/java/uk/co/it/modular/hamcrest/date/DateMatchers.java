/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.hamcrest.Matcher;

/**
 * Static factory for creating {@link org.hamcrest.Matcher} instances for comparing dates
 * 
 * @author Stewart Bissett
 */
public abstract class DateMatchers {

	/**
	 * Creates a matcher that matches when the examined date is after the reference date
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
		return IsAfter.after(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is after the end of the reference year
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, after(2012, Month.MAY, 12));
	 * </pre>
	 * 
	 * @param year
	 *            the year against which the examined date is checked
	 * @param month
	 *            the month against which the examined date is checked
	 * @param day
	 *            the day of the month against which the examined date is checked
	 */
	public static Matcher<Date> after(final int year, final Months month, final int day) {
		return IsAfter.after(year, month, day);
	}

	/**
	 * Creates a matcher that matches when the examined date is after the end of the reference year
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, after(2012, Month.MAY, 12, 23, 00, 01));
	 * </pre>
	 * 
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
	 */
	public static Matcher<Date> after(final int year, final Months month, final int date, final int hour, final int minute, final int second) {
		return IsAfter.after(year, month, date, hour, minute, second);
	}

	/**
	 * Creates a matcher that matches when the examined date is before the reference date
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
		return IsBefore.before(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is before the start of reference day
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, before(2012, Month.MAY, 12));
	 * </pre>
	 * 
	 * @param year
	 *            the year against which the examined date is checked
	 * @param month
	 *            the month against which the examined date is checked
	 * @param day
	 *            the day of the month against which the examined date is checked
	 */
	public static Matcher<Date> before(final int year, final Months month, final int day) {
		return IsBefore.before(year, month, day);
	}

	/**
	 * Creates a matcher that matches when the examined date is before the start of the reference date and time
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, before(2012, Month.MAY, 12, 23, 00, 01));
	 * </pre>
	 * 
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
	 */
	public static Matcher<Date> before(final int year, final Months month, final int date, final int hour, final int minute, final int second) {
		return IsBefore.before(year, month, date, hour, minute, second);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day of the month as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameDayOfTheMonth(new Date()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @deprecated See {@link #sameDatePart(Date, int)}
	 */
	@Deprecated
	public static Matcher<Date> sameDayOfTheMonth(final Date date) {
		return sameDatePart(date, Calendar.DAY_OF_MONTH);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day of the month as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameDayOfTheMonth(new Date()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	public static Matcher<Date> sameDatePart(final Date date, final int datePart) {
		return IsSameDatePart.sameDatePart(date, datePart);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day of the week as the reference date
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
	public static Matcher<Date> sameWeekday(final Date date) {
		return IsSameWeekday.sameWeekday(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
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
	public static Matcher<Date> sameDay(final int year, final Months month, final int day) {
		return IsSameDay.sameDay(year, month, day);
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
	public static Matcher<Date> sameHour(final Date date) {
		return IsSameHour.sameHour(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same instant as the reference date
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
	 * Creates a matcher that matches when the examined date is on the same UTC instant as the reference UTC epoch time supplied
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
	 * Creates a matcher that matches when the examined date is on the same minute as the reference date
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
	public static Matcher<Date> sameMinute(final Date date) {
		return IsSameMinute.sameMinute(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same month as the reference date
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
	public static Matcher<Date> sameMonth(final Date date) {
		return IsSameMonth.sameMonth(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same second as the reference date
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
	public static Matcher<Date> sameSecond(final Date date) {
		return IsSameSecond.sameSecond(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same year as the reference date
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
	 * Creates a matcher that matches when the examined date is within a defined period the reference date
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

}
