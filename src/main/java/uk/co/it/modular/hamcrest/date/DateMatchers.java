/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

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
	 * assertThat(myDate, after(2012, Months.MAY, 12));
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
	 * assertThat(myDate, after(2012, Months.MAY, 12, 23, 00, 01));
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
	 * assertThat(myDate, before(2012, Months.MAY, 12));
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
	 * assertThat(myDate, before(2012, Months.MAY, 12, 23, 00, 01));
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
	 * 
	 * @deprecated See {@link #sameDayOfWeek(Date)}
	 */
	@Deprecated
	public static Matcher<Date> sameWeekday(final Date date) {
		return IsSameDayOfWeek.sameDayOfWeek(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day of the week as the supplied day
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameDayOfTheWeek(Weekdays.MONDAY))
	 * </pre>
	 * 
	 * @param weekday
	 *            the reference weekday against which the examined date is checked
	 * 
	 * @deprecated See {@link #sameDayOfWeek(Weekdays)}
	 */
	@Deprecated
	public static Matcher<Date> sameWeekday(final Weekdays weekday) {
		return IsSameDayOfWeek.sameDayOfWeek(weekday);
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
	public static Matcher<Date> sameDayOfWeek(final Date date) {
		return IsSameDayOfWeek.sameDayOfWeek(date);
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
	public static Matcher<Date> sameDayOfWeek(final Weekdays weekday) {
		return IsSameDayOfWeek.sameDayOfWeek(weekday);
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

	public static Matcher<Date> sameHour(final int hour) {
		return IsSameHour.sameHour(hour);
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
	 * Creates a matcher that matches when the examined date is on the same instance as the reference date
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
	 *            the day of the month against which the examined date is checked
	 * @param hour
	 *            the hour of the day against which the examined date is checked
	 * @param minute
	 *            the minute of the hour against which the examined date is checked
	 * @param second
	 *            the second of the minute against which the examined date is checked
	 * @param milliseconds
	 *            the milliseconds of the second against which the examined date is checked
	 */
	public static Matcher<Date> sameInstant(final int year, final Months month, final int date, final int hour, final int minute, final int second, final int milliseconds) {
		return IsSameInstant.sameIntstance(year, month, date, hour, minute, second, milliseconds);
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
	 * Creates a matcher that matches when the examined date is on the reference minute
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameMinute(55))
	 * </pre>
	 * 
	 * @param minute
	 *            the reference minute against which the examined date is checked
	 */
	public static Matcher<Date> sameMinute(final int minute) {
		return IsSameMinute.sameMinute(minute);
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
	 * Creates a matcher that matches when the examined date is on the same month as the reference month
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
	public static Matcher<Date> sameMonth(final Months month) {
		return IsSameMonth.sameMonth(month);
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
	 * Creates a matcher that matches when the examined date is on the reference second
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
	public static Matcher<Date> sameSecond(final int second) {
		return IsSameSecond.sameSecond(second);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same millisecond as the reference date
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
	public static Matcher<Date> sameMillisecond(final Date date) {
		return IsSameMillisecond.sameMillisecond(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the reference second
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
	public static Matcher<Date> sameMillisecond(final int millisecond) {
		return IsSameMillisecond.sameMillisecond(millisecond);
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
	 * Creates a matcher that matches when the examined date is on the same year as the reference year
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
	public static Matcher<Date> within(final long period, final TimeUnit unit, final int year, final Months month, final int day) {
		return IsWithin.within(period, unit, year, month, day);
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
	public static Matcher<Date> within(final long period, final TimeUnit unit, final int year, final Months month, final int date, final int hour, final int minute,
			final int second, final int milliseconds) {
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
		return DayMatchers.isYesterday();
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
		return DayMatchers.isToday();
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
		return DayMatchers.isTomorrow();
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
	 * Creates a matcher that matches when the examined date is on the first day of the month
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isFirstDayOfMonth());
	 * </pre>
	 */
	public static Matcher<Date> isFirstDayOfMonth() {
		return DayMatchers.isFirstDayOfMonth();
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
	public static Matcher<Date> isLastDayOfMonth() {
		return DayMatchers.isLastDayOfMonth();
	}

}
