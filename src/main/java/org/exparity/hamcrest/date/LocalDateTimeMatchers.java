package org.exparity.hamcrest.date;

import static java.time.DayOfWeek.*;
import static java.time.Month.*;
import static java.util.Arrays.asList;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.Date;

import org.exparity.hamcrest.date.core.IsAfter;
import org.exparity.hamcrest.date.core.IsBefore;
import org.exparity.hamcrest.date.core.IsDayOfMonth;
import org.exparity.hamcrest.date.core.IsDayOfWeek;
import org.exparity.hamcrest.date.core.IsHour;
import org.exparity.hamcrest.date.core.IsLeapYear;
import org.exparity.hamcrest.date.core.IsMaximum;
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
import org.exparity.hamcrest.date.core.format.LocalDateTimeFormatter;
import org.exparity.hamcrest.date.core.wrapper.LocalDateTimeWrapper;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/**
 * Static factory for creating {@link org.hamcrest.Matcher} instances for
 * comparing {@link LocalDateTime} instances
 *
 * @author Stewart Bissett
 */
public abstract class LocalDateTimeMatchers {

	/**
	 * Creates a matcher that matches when the examined date is after the
	 * reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * MatcherAssert.assertThat(myDate, LocalDateTimeMatchers.after(LocalDateTime.now()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<LocalDateTime> after(final Date date) {
		return new IsAfter<LocalDateTime>(new LocalDateTimeWrapper(date), new LocalDateTimeFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is after the
	 * reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * MatcherAssert.assertThat(myDate, LocalDateTimeMatchers.after(LocalDateTime.now()));
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<LocalDateTime> after(final LocalDateTime date) {
		return new IsAfter<LocalDateTime>(new LocalDateTimeWrapper(date), new LocalDateTimeFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is after the end of
	 * the reference year
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * MatcherAssert.assertThat(myDate, LocalDateTimeMatchers.after(2012, Month.MAY, 12));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param dayOfMonth the day of the month against which the examined date is
	 *            checked
	 * @param hour the hour of the day
	 * @param minute the minute of the hour
	 * @param second the second of the minute
	 */
	public static Matcher<LocalDateTime> after(final int year,
	        final Month month,
	        final int dayOfMonth,
	        final int hour,
	        final int minute,
	        final int second) {
		return new IsAfter<LocalDateTime>(
		        new LocalDateTimeWrapper(year, month, dayOfMonth, hour, minute, second),
		            new LocalDateTimeFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is before the
	 * reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * MatcherAssert.assertThat(myDate, LocalDateTimeMatchers.before(LocalDateTime.now()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<LocalDateTime> before(final Date date) {
		return new IsBefore<LocalDateTime>(new LocalDateTimeWrapper(date), new LocalDateTimeFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is before the
	 * reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * MatcherAssert.assertThat(myDate, LocalDateTimeMatchers.before(LocalDateTime.now()));
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<LocalDateTime> before(final LocalDateTime date) {
		return new IsBefore<LocalDateTime>(new LocalDateTimeWrapper(date), new LocalDateTimeFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is before the end
	 * of the reference year
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * MatcherAssert.assertThat(myDate, LocalDateTimeMatchers.before(2012, Month.MAY, 12));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param dayOfMonth the day of the month against which the examined date is
	 *            checked
	 * @param hour the hour of the day
	 * @param minute the minute of the hour
	 * @param second the second of the minute
	 */
	public static Matcher<LocalDateTime> before(final int year,
	        final Month month,
	        final int dayOfMonth,
	        final int hour,
	        final int minute,
	        final int second) {
		return new IsBefore<LocalDateTime>(
		        new LocalDateTimeWrapper(year, month, dayOfMonth, hour, minute, second),
		            new LocalDateTimeFormatter());
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
	public static Matcher<LocalDateTime> sameDay(final Date date) {
		return new IsSameDay<LocalDateTime>(new LocalDateTimeWrapper(date), new LocalDateTimeFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * of the year as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameDay(LocalDateTime.now()));
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<LocalDateTime> sameDay(final LocalDateTime date) {
		return new IsSameDay<LocalDateTime>(new LocalDateTimeWrapper(date), new LocalDateTimeFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * of the year as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameDay(2012, Month.JAN, 1))
	 * </pre>
	 *
	 * @param dayOfMonth the reference day of the month against which the
	 *            examined date is checked
	 * @param month the reference month against which the examined date is
	 *            checked
	 * @param year the reference year against which the examined date is checked
	 */
	public static Matcher<LocalDateTime> sameDay(final int year, final Month month, final int dayOfMonth) {
		return new IsSameDay<LocalDateTime>(
		        new LocalDateTimeWrapper(year, month, dayOfMonth),
		            new LocalDateTimeFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * instant of the year as the reference date down to the millisecond
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameInstant(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<LocalDateTime> sameInstant(final Date date) {
		return new IsSame<LocalDateTime>(new LocalDateTimeWrapper(date), new LocalDateTimeFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is at the same
	 * instant as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameInstant(LocalDateTime.now()));
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<LocalDateTime> sameInstant(final LocalDateTime date) {
		return new IsSame<LocalDateTime>(new LocalDateTimeWrapper(date), new LocalDateTimeFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is at the same
	 * specified instance down to the second
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameInstant(2012, Month.JAN, 1, 3, 15, 0))
	 * </pre>
	 *
	 * @param dayOfMonth the reference day of the month against which the
	 *            examined date is checked
	 * @param month the reference month against which the examined date is
	 *            checked
	 * @param year the reference year against which the examined date is checked
	 * @param hour the hour of the day
	 * @param minute the minute of the hour
	 * @param second the second of the minute
	 * @param nanos the nanosecond of the second
	 */
	public static Matcher<LocalDateTime> sameInstant(final int year,
	        final Month month,
	        final int dayOfMonth,
	        final int hour,
	        final int minute,
	        final int second) {
		return new IsSame<LocalDateTime>(
		        new LocalDateTimeWrapper(year, month, dayOfMonth, hour, minute, second),
		            new LocalDateTimeFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is at the same
	 * instant or before the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isSameOrBefore(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<LocalDateTime> sameOrBefore(final LocalDateTime date) {
		return new IsSameOrBefore<LocalDateTime>(new LocalDateTimeWrapper(date), new LocalDateTimeFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is at the same
	 * instant or before the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isSameOrBefore(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<LocalDateTime> sameOrBefore(final Date date) {
		return new IsSameOrBefore<LocalDateTime>(new LocalDateTimeWrapper(date), new LocalDateTimeFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * or before the start of the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isSameOrBefore(2012, Months.MAY, 12));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param day the day of the month against which the examined date is
	 *            checked
	 * @param hour the hour of the day
	 * @param minute the minute of the hour
	 * @param second the second of the minute
	 */
	@Factory
	public static Matcher<LocalDateTime> sameOrBefore(final int year,
	        final Month month,
	        final int day,
	        final int hour,
	        final int minute,
	        final int second) {
		return new IsSameOrBefore<LocalDateTime>(
		        new LocalDateTimeWrapper(year, month, day, hour, minute, second),
		            new LocalDateTimeFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is at the same
	 * instant or after the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isSameOrAfter(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<LocalDateTime> sameOrAfter(final Date date) {
		return new IsSameOrAfter<LocalDateTime>(new LocalDateTimeWrapper(date), new LocalDateTimeFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is at the same
	 * instant or after the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isSameOrAfter(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<LocalDateTime> sameOrAfter(final LocalDateTime date) {
		return new IsSameOrAfter<LocalDateTime>(new LocalDateTimeWrapper(date), new LocalDateTimeFormatter());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same day
	 * or after the start of the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isSameOrAfter(2012, Months.MAY, 12));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param day the day of the month against which the examined date is
	 *            checked
	 * @param hour the hour of the day
	 * @param minute the minute of the hour
	 * @param second the second of the minute
	 */
	public static Matcher<LocalDateTime> sameOrAfter(final int year,
	        final Month month,
	        final int day,
	        final int hour,
	        final int minute,
	        final int second) {
		return sameOrAfter(LocalDateTime.of(year, month, day, hour, minute, second));
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
	public static Matcher<LocalDateTime> sameMonthOfYear(final Date date) {
		return sameMonthOfYear(toLocalDateTime(date));
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
	public static Matcher<LocalDateTime> sameMonthOfYear(final LocalDateTime date) {
		return isMonth(date.getMonth());
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
	public static Matcher<LocalDateTime> sameDayOfMonth(final Date date) {
		return sameDayOfMonth(toLocalDateTime(date));
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
	public static Matcher<LocalDateTime> sameDayOfMonth(final LocalDateTime date) {
		return isDayOfMonth(date.getDayOfMonth());
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
	public static Matcher<LocalDateTime> isDayOfMonth(final int dayOfMonth) {
		return new IsDayOfMonth<LocalDateTime>(dayOfMonth, t -> t);
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
	public static Matcher<LocalDateTime> sameYear(final Date date) {
		return isYear(toLocalDateTime(date).getYear());
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
	public static Matcher<LocalDateTime> sameYear(final LocalDateTime date) {
		return isYear(date.getYear());
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
	public static Matcher<LocalDateTime> isYear(final int year) {
		return new IsYear<LocalDateTime>(year, t -> t);
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
	public static Matcher<LocalDateTime> within(final long period, final ChronoUnit unit, final Date date) {
		return new IsWithin<LocalDateTime>(period, unit, new LocalDateTimeWrapper(date), new LocalDateTimeFormatter());
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
	 */
	public static Matcher<LocalDateTime> within(final long period, final ChronoUnit unit, final LocalDateTime date) {
		return new IsWithin<LocalDateTime>(period, unit, new LocalDateTimeWrapper(date), new LocalDateTimeFormatter());
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
	 * @param dayofMonth the day of the month against which the examined date is
	 *            checked
	 * @param hour
	 * @param hour the hour of the day
	 * @param minute the minute of the hour
	 * @param second the second of the minute
	 * @param hour the hour of the day
	 * @param minute the minute of the hour
	 * @param second the second of the minute
	 */
	public static Matcher<LocalDateTime> within(final long period,
	        final ChronoUnit unit,
	        final int year,
	        final Month month,
	        final int dayofMonth,
	        final int hour,
	        final int minute,
	        final int second) {
		return new IsWithin<LocalDateTime>(
		        period,
		            unit,
		            new LocalDateTimeWrapper(year, month, dayofMonth, hour, minute, second),
		            new LocalDateTimeFormatter());
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
	public static Matcher<LocalDateTime> isYesterday() {
		return sameDay(LocalDateTime.now().minusDays(1));
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
	public static Matcher<LocalDateTime> isToday() {
		return sameDay(LocalDateTime.now());
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
	public static Matcher<LocalDateTime> isTomorrow() {
		return sameDay(LocalDateTime.now().plusDays(1));
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
	public static Matcher<LocalDateTime> isDayOfWeek(final DayOfWeek... dayOfWeek) {
		return new IsDayOfWeek<LocalDateTime>(asList(dayOfWeek), t -> t);
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
	public static Matcher<LocalDateTime> isMonday() {
		return isDayOfWeek(MONDAY);
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
	public static Matcher<LocalDateTime> isTuesday() {
		return isDayOfWeek(TUESDAY);
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
	public static Matcher<LocalDateTime> isWednesday() {
		return isDayOfWeek(WEDNESDAY);
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
	public static Matcher<LocalDateTime> isThursday() {
		return isDayOfWeek(THURSDAY);
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
	public static Matcher<LocalDateTime> isFriday() {
		return isDayOfWeek(FRIDAY);
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
	public static Matcher<LocalDateTime> isSaturday() {
		return isDayOfWeek(SATURDAY);
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
	public static Matcher<LocalDateTime> isSunday() {
		return isDayOfWeek(SUNDAY);
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
	public static Matcher<LocalDateTime> isWeekday() {
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
	public static Matcher<LocalDateTime> isWeekend() {
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
	public static Matcher<LocalDateTime> isFirstDayOfMonth() {
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
	public static Matcher<LocalDateTime> isMinimum(final TemporalField field) {
		return new IsMinimum<LocalDateTime>(field, t -> t);
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
	public static Matcher<LocalDateTime> isLastDayOfMonth() {
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
	public static Matcher<LocalDateTime> isMaximum(final TemporalField field) {
		return new IsMaximum<LocalDateTime>(field, t -> t);
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
	public static Matcher<LocalDateTime> isMonth(final Month month) {
		return new IsMonth<LocalDateTime>(month, t -> t);
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
	public static Matcher<LocalDateTime> isJanuary() {
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
	public static Matcher<LocalDateTime> isFebruary() {
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
	public static Matcher<LocalDateTime> isMarch() {
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
	public static Matcher<LocalDateTime> isApril() {
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
	public static Matcher<LocalDateTime> isMay() {
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
	public static Matcher<LocalDateTime> isJune() {
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
	public static Matcher<LocalDateTime> isJuly() {
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
	public static Matcher<LocalDateTime> isAugust() {
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
	public static Matcher<LocalDateTime> isSeptember() {
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
	public static Matcher<LocalDateTime> isOctober() {
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
	public static Matcher<LocalDateTime> isNovember() {
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
	public static Matcher<LocalDateTime> isDecember() {
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
	public static Matcher<LocalDateTime> isLeapYear() {
		return new IsLeapYear<LocalDateTime>(t -> t);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the expected
	 * hour (0-23)
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isHour(12));
	 * </pre>
	 *
	 * @param hour the hour of the day (0-23)
	 */
	public static Matcher<LocalDateTime> isHour(final int hour) {
		return new IsHour<LocalDateTime>(hour, t -> t);
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
	public static Matcher<LocalDateTime> sameHourOfDay(final Date date) {
		return sameHourOfDay(toLocalDateTime(date));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same hour
	 * as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameHourOfDay(LocalDateTime.now()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<LocalDateTime> sameHourOfDay(final LocalDateTime date) {
		return isHour(date.getHour());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the expected
	 * minute (0-59)
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isMinute(12));
	 * </pre>
	 *
	 * @param Minute the minute of the day (0-59)
	 */
	public static Matcher<LocalDateTime> isMinute(final int minute) {
		return new IsMinute<LocalDateTime>(minute, t -> t);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * Minute as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameMinuteOfHour(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<LocalDateTime> sameMinuteOfHour(final Date date) {
		return sameMinuteOfHour(toLocalDateTime(date));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * minute as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameMinuteOfHour(LocalDateTime.now()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<LocalDateTime> sameMinuteOfHour(final LocalDateTime date) {
		return isMinute(date.getMinute());
	}

	/**
	 * Creates a matcher that matches when the examined date is on the expected
	 * second (0-59)
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isSecond(12));
	 * </pre>
	 *
	 * @param Second the second of the day (0-59)
	 */
	public static Matcher<LocalDateTime> isSecond(final int Second) {
		return new IsSecond<LocalDateTime>(Second, t -> t);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * Second as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameSecondOfMinute(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<LocalDateTime> sameSecondOfMinute(final Date date) {
		return sameSecondOfMinute(toLocalDateTime(date));
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same
	 * second as the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameSecondOfMinute(LocalDateTime.now()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static Matcher<LocalDateTime> sameSecondOfMinute(final LocalDateTime date) {
		return isSecond(date.getSecond());
	}

	private static LocalDateTime toLocalDateTime(final Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

}
