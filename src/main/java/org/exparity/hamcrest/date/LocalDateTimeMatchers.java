package org.exparity.hamcrest.date;

import static java.time.DayOfWeek.*;
import static java.time.Month.*;
import static org.exparity.hamcrest.date.core.TemporalConverters.*;
import static org.exparity.hamcrest.date.core.TemporalFunctions.LOCALDATETIME;
import static org.exparity.hamcrest.date.core.TemporalProviders.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import org.exparity.hamcrest.date.core.TemporalMatcher;
import org.exparity.hamcrest.date.core.IsAfter;
import org.exparity.hamcrest.date.core.IsBefore;
import org.exparity.hamcrest.date.core.IsDayOfMonth;
import org.exparity.hamcrest.date.core.IsDayOfWeek;
import org.exparity.hamcrest.date.core.IsFirstDayOfMonth;
import org.exparity.hamcrest.date.core.IsHour;
import org.exparity.hamcrest.date.core.IsLastDayOfMonth;
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
import org.exparity.hamcrest.date.core.types.Interval;

/**
 * Static factory for creating {@link org.hamcrest.Matcher} instances for comparing {@link LocalDateTime} instances
 *
 * @author Stewart Bissett
 */
public final class LocalDateTimeMatchers {


	private LocalDateTimeMatchers(){}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is after the reference date
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * MatcherAssert.assertThat(myDate, LocalDateTimeMatchers.after(LocalDateTime.now()));
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static TemporalMatcher<LocalDateTime> after(final LocalDateTime date) {
		return new IsAfter<>(LOCALDATETIME_AS_LOCALDATETIME, localDateTime(date), LOCALDATETIME);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is after the end of the reference year
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * MatcherAssert.assertThat(myDate, LocalDateTimeMatchers.after(2012, Month.MAY, 12));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param dayOfMonth the day of the month against which the examined date is checked
	 * @param hour the hour of the day
	 * @param minute the minute of the hour
	 * @param second the second of the minute
	 */
	public static TemporalMatcher<LocalDateTime> after(final int year,
	        final Month month,
	        final int dayOfMonth,
	        final int hour,
	        final int minute,
	        final int second) {
		return after(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is before the reference date
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * MatcherAssert.assertThat(myDate, LocalDateTimeMatchers.before(LocalDateTime.now()));
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static TemporalMatcher<LocalDateTime> before(final LocalDateTime date) {
		return new IsBefore<>(LOCALDATETIME_AS_LOCALDATETIME, localDateTime(date), LOCALDATETIME);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is before the end of the reference year
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * MatcherAssert.assertThat(myDate, LocalDateTimeMatchers.before(2012, Month.MAY, 12));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param dayOfMonth the day of the month against which the examined date is checked
	 * @param hour the hour of the day
	 * @param minute the minute of the hour
	 * @param second the second of the minute
	 */
	public static TemporalMatcher<LocalDateTime> before(final int year,
	        final Month month,
	        final int dayOfMonth,
	        final int hour,
	        final int minute,
	        final int second) {
		return before(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameDay(LocalDateTime.now()));
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static TemporalMatcher<LocalDateTime> sameDay(final LocalDateTime date) {
		return new IsSameDay<>(LOCALDATETIME_AS_LOCALDATE, localDate(date));
	}

    /**
     * <p>
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameDay(LocalDate.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<LocalDateTime> isDay(LocalDate date) {
        return new IsSameDay<>(LOCALDATETIME_AS_LOCALDATE, localDate(date));
    }
	
	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameDay(2012, Month.JAN, 1))
	 * </pre>
	 *
	 * @param dayOfMonth the reference day of the month against which the examined date is checked
	 * @param month the reference month against which the examined date is checked
	 * @param year the reference year against which the examined date is checked
	 */
	public static TemporalMatcher<LocalDateTime> isDay(final int year, final Month month, final int dayOfMonth) {
	    return isDay(LocalDate.of(year, month, dayOfMonth));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is at the same instant as the reference date
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameInstant(LocalDateTime.now()));
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static TemporalMatcher<LocalDateTime> sameInstant(final LocalDateTime date) {
		return new IsSame<>(LOCALDATETIME_AS_LOCALDATETIME, localDateTime(date), LOCALDATETIME);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is at the same specified instance down to the second
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameInstant(2012, Month.JAN, 1, 3, 15, 0))
	 * </pre>
	 *
	 * @param dayOfMonth the reference day of the month against which the examined date is checked
	 * @param month the reference month against which the examined date is checked
	 * @param year the reference year against which the examined date is checked
	 * @param hour the hour of the day
	 * @param minute the minute of the hour
	 * @param second the second of the minute
	 * @param nanos the nanosecond of the second
	 */
	public static TemporalMatcher<LocalDateTime> isInstant(final int year,
	        final Month month,
	        final int dayOfMonth,
	        final int hour,
	        final int minute,
	        final int second,
	        final int nanos) {
		return sameInstant(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, nanos));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is at the same instant or before the reference date
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isSameOrBefore(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static TemporalMatcher<LocalDateTime> sameOrBefore(final LocalDateTime date) {
		return new IsSameOrBefore<>(LOCALDATETIME_AS_LOCALDATETIME, localDateTime(date), LOCALDATETIME);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on the same day or before the start of the reference
	 * date
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isSameOrBefore(2012, Months.MAY, 12));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param day the day of the month against which the examined date is checked
	 * @param hour the hour of the day
	 * @param minute the minute of the hour
	 * @param second the second of the minute
	 */
	public static TemporalMatcher<LocalDateTime> sameOrBefore(final int year,
	        final Month month,
	        final int day,
	        final int hour,
	        final int minute,
	        final int second) {
		return sameOrBefore(LocalDateTime.of(year, month, day, hour, minute, second));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is at the same instant or after the reference date
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isSameOrAfter(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static TemporalMatcher<LocalDateTime> sameOrAfter(final LocalDateTime date) {
		return new IsSameOrAfter<>(LOCALDATETIME_AS_LOCALDATETIME, localDateTime(date), LOCALDATETIME);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on the same day or after the start of the reference date
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isSameOrAfter(2012, Months.MAY, 12));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param day the day of the month against which the examined date is checked
	 * @param hour the hour of the day
	 * @param minute the minute of the hour
	 * @param second the second of the minute
	 */
	public static TemporalMatcher<LocalDateTime> sameOrAfter(final int year,
	        final Month month,
	        final int day,
	        final int hour,
	        final int minute,
	        final int second) {
		return sameOrAfter(LocalDateTime.of(year, month, day, hour, minute, second));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on the same month as the reference date
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameMonth(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static TemporalMatcher<LocalDateTime> sameMonthOfYear(final LocalDateTime date) {
		return new IsMonth<>(LOCALDATETIME_AS_MONTH, month(date));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on the same day of the month as the reference date
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameDayOfMonth(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static TemporalMatcher<LocalDateTime> sameDayOfMonth(final LocalDateTime date) {
		return new IsDayOfMonth<>(LOCALDATETIME_AS_DAYOFMONTH, dayOfMonth(date));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on the expected day of the month
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isDayOfMonth(4))
	 * </pre>
	 *
	 * @param dayOfMonth the expected day of the month
	 */
	public static TemporalMatcher<LocalDateTime> isDayOfMonth(final int dayOfMonth) {
		return new IsDayOfMonth<>(LOCALDATETIME_AS_DAYOFMONTH, dayOfMonth(dayOfMonth));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on the same year as the reference date
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameYear(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static TemporalMatcher<LocalDateTime> sameYear(final LocalDateTime date) {
		return new IsYear<>(LOCALDATETIME_AS_YEAR, year(date));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on the same year as the reference year
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameYear(2013))
	 * </pre>
	 *
	 * @param year the reference year against which the examined date is checked
	 */
	public static TemporalMatcher<LocalDateTime> isYear(final int year) {
		return new IsYear<>(LOCALDATETIME_AS_YEAR, year(year));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is within a defined period the reference date
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, within(10, TimeUnit.DAYS, Moments.today()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static TemporalMatcher<LocalDateTime> within(final long period,
	        final ChronoUnit unit,
	        final LocalDateTime date) {
		return new IsWithin<>(Interval.of(period, unit), LOCALDATETIME_AS_LOCALDATETIME, localDateTime(date), LOCALDATETIME);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is within a given period of the reference date
	 * </p>
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
	 * @param dayofMonth the day of the month against which the examined date is checked
	 * @param hour the hour of the day
	 * @param minute the minute of the hour
	 * @param second the second of the minute
	 * @param nanos the nanoseconds of the second
	 */
	public static TemporalMatcher<LocalDateTime> within(final long period,
	        final ChronoUnit unit,
	        final int year,
	        final Month month,
	        final int dayofMonth,
	        final int hour,
	        final int minute,
	        final int second,
	        final int nanos) {
		return within(period, unit, LocalDateTime.of(year, month, dayofMonth, hour, minute, second, nanos));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is yesterday
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isToday());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isYesterday() {
		return sameDay(LocalDateTime.now().minusDays(1));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is today
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isToday());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isToday() {
		return sameDay(LocalDateTime.now());
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is tomorrow
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isTomorrow());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isTomorrow() {
		return sameDay(LocalDateTime.now(ZoneId.systemDefault()).plusDays(1));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on the same day of the week as the reference date
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameDayOfWeek(LocalDateTime.now()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static TemporalMatcher<LocalDateTime> sameDayOfWeek(final LocalDateTime date) {
		return isDayOfWeek(DayOfWeek.from(date));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on a monday
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isMonday());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isDayOfWeek(final DayOfWeek dayOfWeek) {
		return new IsDayOfWeek<>(LOCALDATETIME_AS_DAYOFWEEK, daysOfWeek(dayOfWeek));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on a monday
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isMonday());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isDayOfWeek(final DayOfWeek... daysOfWeek) {
		return new IsDayOfWeek<>(LOCALDATETIME_AS_DAYOFWEEK, daysOfWeek(daysOfWeek));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on a monday
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isMonday());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isMonday() {
		return isDayOfWeek(MONDAY);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on a tuesday
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isTuesday());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isTuesday() {
		return isDayOfWeek(TUESDAY);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on a wednesday
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isWednesday());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isWednesday() {
		return isDayOfWeek(WEDNESDAY);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on a thursday
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isThursday());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isThursday() {
		return isDayOfWeek(THURSDAY);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on a friday
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isFriday());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isFriday() {
		return isDayOfWeek(FRIDAY);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on a saturday
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isSaturday());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isSaturday() {
		return isDayOfWeek(SATURDAY);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on a sunday
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isSunday());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isSunday() {
		return isDayOfWeek(SUNDAY);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on a weekday
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isWeekday());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isWeekday() {
		return isDayOfWeek(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on a weekend
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isWeekend());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isWeekend() {
		return isDayOfWeek(SATURDAY, SUNDAY);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on the first day of the month
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isFirstDayOfMonth());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isFirstDayOfMonth() {
		return new IsFirstDayOfMonth<>(LOCALDATETIME_AS_LOCALDATETIME);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on the maximum value of the given date part in its
	 * period
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isMaximumDayOfMonth(ChronoField.DAY_OF_MONTH));
	 * </pre>
	 *
	 * @param field the temporal field to check
	 */
	public static TemporalMatcher<LocalDateTime> isMinimum(final ChronoField field) {
		return new IsMinimum<>(LOCALDATETIME_AS_LOCALDATETIME, field);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on the first day of the month
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isFirstDayOfMonth());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isLastDayOfMonth() {
		return new IsLastDayOfMonth<>(LOCALDATETIME_AS_LOCALDATETIME);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on the maximum value of the given date part in its
	 * period
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isMaximum(ChronoField.DAY_OF_MONTH));
	 * </pre>
	 *
	 * @param field the temporal field to check
	 */
	public static TemporalMatcher<LocalDateTime> isMaximum(final ChronoField field) {
		return new IsMaximum<>(LOCALDATETIME_AS_LOCALDATETIME, field);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is in the expected month
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isMonth(Month.AUGUST));
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isMonth(final Month month) {
		return new IsMonth<>(LOCALDATETIME_AS_MONTH, month(month));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is in January
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isJanuary());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isJanuary() {
		return isMonth(JANUARY);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is in February
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isFebruary());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isFebruary() {
		return isMonth(FEBRUARY);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is in March
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isMarch());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isMarch() {
		return isMonth(MARCH);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is in April
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isApril());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isApril() {
		return isMonth(APRIL);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is in May
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isMay());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isMay() {
		return isMonth(MAY);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is in June
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isJune());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isJune() {
		return isMonth(JUNE);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is in July
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isJuly());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isJuly() {
		return isMonth(JULY);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is in August
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isAugust());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isAugust() {
		return isMonth(AUGUST);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is in September
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isSeptember());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isSeptember() {
		return isMonth(SEPTEMBER);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is in October
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isOctober());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isOctober() {
		return isMonth(OCTOBER);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is in November
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isNovember());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isNovember() {
		return isMonth(NOVEMBER);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is in December
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isDecember());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isDecember() {
		return isMonth(DECEMBER);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is a leap year
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isLeapYear());
	 * </pre>
	 */
	public static TemporalMatcher<LocalDateTime> isLeapYear() {
		return new IsLeapYear<>(LOCALDATETIME_AS_YEAR);
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on the expected hour (0-23)
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isHour(12));
	 * </pre>
	 *
	 * @param hour the hour of the day (0-23)
	 */
	public static TemporalMatcher<LocalDateTime> isHour(final int hour) {
		return new IsHour<>(LOCALDATETIME_AS_HOUR, hour(hour));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on the same hour as the reference date
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameHourOfDay(LocalDateTime.now()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static TemporalMatcher<LocalDateTime> sameHourOfDay(final LocalDateTime date) {
		return new IsHour<>(LOCALDATETIME_AS_HOUR, hour(date));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on the expected minute (0-59)
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isMinute(12));
	 * </pre>
	 *
	 * @param minute the minute of the day (0-59)
	 */
	public static TemporalMatcher<LocalDateTime> isMinute(final int minute) {
		return new IsMinute<>(LOCALDATETIME_AS_MINUTE, minute(minute));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on the same minute as the reference date
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameMinuteOfHour(LocalDateTime.now()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static TemporalMatcher<LocalDateTime> sameMinuteOfHour(final LocalDateTime date) {
		return new IsMinute<>(LOCALDATETIME_AS_MINUTE, minute(date));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on the expected second (0-59)
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isSecond(12));
	 * </pre>
	 *
	 * @param second the second of the day (0-59)
	 */
	public static TemporalMatcher<LocalDateTime> isSecond(final int second) {
		return new IsSecond<>(LOCALDATETIME_AS_SECOND, second(second));
	}

	/**
	 * <p>
     * Creates a matcher that matches when the examined date is on the same second as the reference date
	 * </p>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameSecondOfMinute(LocalDateTime.now()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static TemporalMatcher<LocalDateTime> sameSecondOfMinute(final LocalDateTime date) {
		return new IsSecond<>(LOCALDATETIME_AS_SECOND, second(date));
	}
}
