package org.exparity.hamcrest.date;

import static java.time.DayOfWeek.*;
import static java.time.Month.*;
import static org.exparity.hamcrest.date.core.TemporalConverters.*;
import static org.exparity.hamcrest.date.core.TemporalFunctions.OFFSETDATETIME;
import static org.exparity.hamcrest.date.core.TemporalProviders.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.OffsetDateTime;
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
 * Static factory for creating {@link org.hamcrest.Matcher} instances for comparing {@link OffsetDateTime} instances
 *
 * @author Stewart Bissett
 */
public final class OffsetDateTimeMatchers {

    private OffsetDateTimeMatchers(){}
    /**
     * <p>
     * Creates a matcher that matches when the examined date is after the reference date
     * </p>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, after(OffsetDateTime.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<OffsetDateTime> after(final OffsetDateTime date) {
        return new IsAfter<>(OFFSETDATETIME_AS_OFFSETDATETIME, offsetDateTime(date), OFFSETDATETIME);
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is after the end of the reference year
     * </p>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, after(2012, Month.MAY, 12));
     * </pre>
     *
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     * @param nanos the nanos of the second
     */
    public static TemporalMatcher<OffsetDateTime> after(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneOffset tz) {
        return after(OffsetDateTime.of(year, month.getValue(), dayOfMonth, hour, minute, second, nanos, tz));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is before the reference date
     * </p>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, before(OffsetDateTime.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<OffsetDateTime> before(final OffsetDateTime date) {
        return new IsBefore<>(OFFSETDATETIME_AS_OFFSETDATETIME, offsetDateTime(date), OFFSETDATETIME);
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is before the end of the reference year
     * </p>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, before(2012, Month.MAY, 12));
     * </pre>
     *
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     * @param nanos the nanos of the second
     */
    public static TemporalMatcher<OffsetDateTime> before(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneOffset tz) {
        return before(OffsetDateTime.of(year, month.getValue(), dayOfMonth, hour, minute, second, nanos, tz));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameDay(OffsetDateTime.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<OffsetDateTime> sameDay(final OffsetDateTime date) {
        return new IsSameDay<>(OFFSETDATETIME_AS_LOCALDATE, localDate(date));
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
    public static TemporalMatcher<OffsetDateTime> isDay(LocalDate date) {
        return new IsSameDay<>(OFFSETDATETIME_AS_LOCALDATE, localDate(date));
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
    public static TemporalMatcher<OffsetDateTime> isDay(final int year, final Month month, final int dayOfMonth) {
        return isDay(LocalDate.of(year, month, dayOfMonth));
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
    public static TemporalMatcher<OffsetDateTime> isDay(final int year, final Month month, final int dayOfMonth, final ZoneId zone) {
        return isDay(LocalDate.of(year, month, dayOfMonth)).atZone(zone);
    }
    
    /**
     * <p>
     * Creates a matcher that matches when the examined date is at the same instant as the reference date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameInstant(OffsetDateTime.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<OffsetDateTime> sameInstant(final OffsetDateTime date) {
        return new IsSame<>(OFFSETDATETIME_AS_OFFSETDATETIME, offsetDateTime(date), OFFSETDATETIME);
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
     * @param tz the timezone
     */
    public static TemporalMatcher<OffsetDateTime> isInstant(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneOffset tz) {
        return sameInstant(OffsetDateTime.of(year, month.getValue(), dayOfMonth, hour, minute, second, nanos, tz));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is at the same instant or before the reference date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrBefore(OffsetDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<OffsetDateTime> sameOrBefore(final OffsetDateTime date) {
        return new IsSameOrBefore<>(OFFSETDATETIME_AS_OFFSETDATETIME, offsetDateTime(date), OFFSETDATETIME);
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is on the same day or before the start of the reference
     * date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrBefore(2012, Months.MAY, 12, 11, 59, 59, ZoneId.systemDefault()));
     * </pre>
     *
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param day the day of the month against which the examined date is checked
     * @param hour the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     * @param nanos the nanosecond of the second
     * @param tz the time zone of the date to check against
     */
    public static TemporalMatcher<OffsetDateTime> sameOrBefore(final int year,
            final Month month,
            final int day,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneOffset tz) {
        return sameOrBefore(OffsetDateTime.of(year, month.getValue(), day, hour, minute, second, nanos, tz));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is at the same instant or after the reference date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrAfter(OffsetDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<OffsetDateTime> sameOrAfter(final OffsetDateTime date) {
        return new IsSameOrAfter<>(OFFSETDATETIME_AS_OFFSETDATETIME, offsetDateTime(date), OFFSETDATETIME);
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is on the same day or before the start of the reference
     * date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrAfter(2012, Months.MAY, 12, 11, 59, 59, ZoneId.systemDefault()));
     * </pre>
     *
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param day the day of the month against which the examined date is checked
     * @param hour the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     * @param nanos the nanosecond of the second
     * @param tz the time zone of the date to check against
     */
    public static TemporalMatcher<OffsetDateTime> sameOrAfter(final int year,
            final Month month,
            final int day,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneOffset tz) {
        return sameOrAfter(OffsetDateTime.of(year, month.getValue(), day, hour, minute, second, nanos, tz));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is on the same month as the reference date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameMonth(OffsetDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<OffsetDateTime> sameMonthOfYear(final OffsetDateTime date) {
        return new IsMonth<>(OFFSETDATETIME_AS_MONTH, month(date));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is on the same day of the month as the reference date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameDayOfMonth(OffsetDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<OffsetDateTime> sameDayOfMonth(final OffsetDateTime date) {
        return new IsDayOfMonth<>(OFFSETDATETIME_AS_DAYOFMONTH, dayOfMonth(date));
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
    public static TemporalMatcher<OffsetDateTime> isDayOfMonth(final int dayOfMonth) {
        return new IsDayOfMonth<>(OFFSETDATETIME_AS_DAYOFMONTH, dayOfMonth(dayOfMonth));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is on the same year as the reference date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameYear(OffsetDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<OffsetDateTime> sameYear(final OffsetDateTime date) {
        return isYear(date.getYear());
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
    public static TemporalMatcher<OffsetDateTime> isYear(final int year) {
        return new IsYear<>(OFFSETDATETIME_AS_YEAR, year(year));
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
    public static TemporalMatcher<OffsetDateTime> within(final long period,
            final ChronoUnit unit,
            final OffsetDateTime date) {
        return new IsWithin<>(Interval.of(period, unit),
                OFFSETDATETIME_AS_OFFSETDATETIME,
                offsetDateTime(date),
                OFFSETDATETIME);
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
     * @param tz the time zone of the reference date
     */
    public static TemporalMatcher<OffsetDateTime> within(final long period,
            final ChronoUnit unit,
            final int year,
            final Month month,
            final int dayofMonth,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneOffset tz) {
        return within(period,
                unit,
                OffsetDateTime.of(year, month.getValue(), dayofMonth, hour, minute, second, nanos, tz));
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
    public static TemporalMatcher<OffsetDateTime> isYesterday() {
        return sameDay(OffsetDateTime.now().plusDays(-1));
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
    public static TemporalMatcher<OffsetDateTime> isToday() {
        return sameDay(OffsetDateTime.now());
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
    public static TemporalMatcher<OffsetDateTime> isTomorrow() {
        return sameDay(OffsetDateTime.now().plusDays(1));
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
    public static TemporalMatcher<OffsetDateTime> sameDayOfWeek(final OffsetDateTime date) {
        return isDayOfWeek(DayOfWeek.from(date));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is on the same day of the week as the supplied day
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isMonday());
     * </pre>
     */
    public static TemporalMatcher<OffsetDateTime> isDayOfWeek(final DayOfWeek dayOfWeek) {
        return new IsDayOfWeek<>(OFFSETDATETIME_AS_DAYOFWEEK, daysOfWeek(dayOfWeek));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is on the same day of the week as any of the supplied days
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isMonday());
     * </pre>
     */
    public static TemporalMatcher<OffsetDateTime> isDayOfWeek(final DayOfWeek... daysOfWeek) {
        return new IsDayOfWeek<>(OFFSETDATETIME_AS_DAYOFWEEK, daysOfWeek(daysOfWeek));
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
    public static TemporalMatcher<OffsetDateTime> isMonday() {
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
    public static TemporalMatcher<OffsetDateTime> isTuesday() {
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
    public static TemporalMatcher<OffsetDateTime> isWednesday() {
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
    public static TemporalMatcher<OffsetDateTime> isThursday() {
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
    public static TemporalMatcher<OffsetDateTime> isFriday() {
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
    public static TemporalMatcher<OffsetDateTime> isSaturday() {
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
    public static TemporalMatcher<OffsetDateTime> isSunday() {
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
    public static TemporalMatcher<OffsetDateTime> isWeekday() {
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
    public static TemporalMatcher<OffsetDateTime> isWeekend() {
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
    public static TemporalMatcher<OffsetDateTime> isFirstDayOfMonth() {
        return new IsFirstDayOfMonth<>(OFFSETDATETIME_AS_OFFSETDATETIME);
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
    public static TemporalMatcher<OffsetDateTime> isMinimum(final ChronoField field) {
        return new IsMinimum<>(OFFSETDATETIME_AS_OFFSETDATETIME, field);
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
    public static TemporalMatcher<OffsetDateTime> isLastDayOfMonth() {
        return new IsLastDayOfMonth<>(OFFSETDATETIME_AS_OFFSETDATETIME);
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
    public static TemporalMatcher<OffsetDateTime> isMaximum(final ChronoField field) {
        return new IsMaximum<>(OFFSETDATETIME_AS_OFFSETDATETIME, field);
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
    public static TemporalMatcher<OffsetDateTime> isMonth(final Month month) {
        return new IsMonth<>(OFFSETDATETIME_AS_MONTH, month(month));
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
    public static TemporalMatcher<OffsetDateTime> isJanuary() {
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
    public static TemporalMatcher<OffsetDateTime> isFebruary() {
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
    public static TemporalMatcher<OffsetDateTime> isMarch() {
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
    public static TemporalMatcher<OffsetDateTime> isApril() {
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
    public static TemporalMatcher<OffsetDateTime> isMay() {
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
    public static TemporalMatcher<OffsetDateTime> isJune() {
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
    public static TemporalMatcher<OffsetDateTime> isJuly() {
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
    public static TemporalMatcher<OffsetDateTime> isAugust() {
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
    public static TemporalMatcher<OffsetDateTime> isSeptember() {
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
    public static TemporalMatcher<OffsetDateTime> isOctober() {
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
    public static TemporalMatcher<OffsetDateTime> isNovember() {
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
    public static TemporalMatcher<OffsetDateTime> isDecember() {
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
    public static TemporalMatcher<OffsetDateTime> isLeapYear() {
        return new IsLeapYear<>(OFFSETDATETIME_AS_YEAR);
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
    public static TemporalMatcher<OffsetDateTime> isHour(final int hour) {
        return new IsHour<>(OFFSETDATETIME_AS_HOUR, hour(hour));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is on the same hour as the reference date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameHourOfDay(OffsetDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<OffsetDateTime> sameHourOfDay(final OffsetDateTime date) {
        return new IsHour<>(OFFSETDATETIME_AS_HOUR, hour(date));
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
    public static TemporalMatcher<OffsetDateTime> isMinute(final int minute) {
        return new IsMinute<>(OFFSETDATETIME_AS_MINUTE, minute(minute));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is on the same minute as the reference date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameMinuteOfHour(OffsetDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<OffsetDateTime> sameMinuteOfHour(final OffsetDateTime date) {
        return new IsMinute<>(OFFSETDATETIME_AS_MINUTE, minute(date));
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
    public static TemporalMatcher<OffsetDateTime> isSecond(final int second) {
        return new IsSecond<>(OFFSETDATETIME_AS_SECOND, second(second));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is on the same second as the reference date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameSecondOfMinute(OffsetDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<OffsetDateTime> sameSecondOfMinute(final OffsetDateTime date) {
        return new IsSecond<>(OFFSETDATETIME_AS_SECOND, second(date));
    }
}
