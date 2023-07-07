package org.exparity.hamcrest.date;

import static java.time.DayOfWeek.*;
import static java.time.Month.*;
import static org.exparity.hamcrest.date.core.TemporalConverters.*;
import static org.exparity.hamcrest.date.core.TemporalFunctions.INSTANT;
import static org.exparity.hamcrest.date.core.TemporalProviders.*;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

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
import org.exparity.hamcrest.date.core.TemporalConverters;
import org.exparity.hamcrest.date.core.TemporalMatcher;
import org.exparity.hamcrest.date.core.types.Interval;


/**
 * Static factory for creating {@link org.hamcrest.Matcher} instances for comparing {@link ZonedDateTime} instances
 *
 * @author Stewart Bissett
 */
public final class InstantMatchers {

    private InstantMatchers(){}
    /**
     * <p>
     * Creates a matcher that matches when the examined date is after the reference date
     * </p>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, after(Instant.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<Instant> after(final Instant date) {
        return new IsAfter<>(INSTANT_AS_INSTANT, instant(date), INSTANT);
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
    public static TemporalMatcher<Instant> after(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneId tz) {
        return after(ZonedDateTime.of(year, month.getValue(), dayOfMonth, hour, minute, second, nanos, tz).toInstant());
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is before the reference date
     * </p>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, before(Instant.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<Instant> before(final Instant date) {
        return new IsBefore<>(INSTANT_AS_INSTANT, instant(date), INSTANT);
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
    public static TemporalMatcher<Instant> before(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneId tz) {
        return before(ZonedDateTime.of(year, month.getValue(), dayOfMonth, hour, minute, second, nanos, tz).toInstant());
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameDay(Instant.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<Instant> sameDay(final Instant date) {
        return new IsSameDay<>(INSTANT_AS_LOCALDATE, localDate(date));
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
    public static TemporalMatcher<Instant> isDay(LocalDate date) {
        return new IsSameDay<>(INSTANT_AS_LOCALDATE, localDate(date));
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
    public static TemporalMatcher<Instant> isDay(final int year, final Month month, final int dayOfMonth) {
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
    public static TemporalMatcher<Instant> isDay(final int year, final Month month, final int dayOfMonth, final ZoneId zone) {
        return isDay(LocalDate.of(year, month, dayOfMonth)).atZone(zone);
    }
    
    /**
     * <p>
     * Creates a matcher that matches when the examined date is at the same instant as the reference date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameInstant(Instant.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<Instant> sameInstant(final Instant date) {
        return new IsSame<>(INSTANT_AS_INSTANT, instant(date), INSTANT);
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
    public static TemporalMatcher<Instant> isInstant(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneId tz) {
        return sameInstant(ZonedDateTime.of(year, month.getValue(), dayOfMonth, hour, minute, second, nanos, tz).toInstant());
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is at the same instant or before the reference date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrBefore(Instant.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<Instant> sameOrBefore(final Instant date) {
        return new IsSameOrBefore<>(INSTANT_AS_INSTANT, instant(date), INSTANT);
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
    public static TemporalMatcher<Instant> sameOrBefore(final int year,
            final Month month,
            final int day,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneId tz) {
        return sameOrBefore(ZonedDateTime.of(year, month.getValue(), day, hour, minute, second, nanos, tz).toInstant());
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is at the same instant or after the reference date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrAfter(Instant.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<Instant> sameOrAfter(final Instant date) {
        return new IsSameOrAfter<>(INSTANT_AS_INSTANT, instant(date), INSTANT);
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
    public static TemporalMatcher<Instant> sameOrAfter(final int year,
            final Month month,
            final int day,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneId tz) {
        return sameOrAfter(ZonedDateTime.of(year, month.getValue(), day, hour, minute, second, nanos, tz).toInstant());
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is on the same month as the reference date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameMonth(Instant.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<Instant> sameMonthOfYear(final Instant date) {
        return new IsMonth<>(INSTANT_AS_MONTH, month(date));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is on the same day of the month as the reference date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameDayOfMonth(Instant.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<Instant> sameDayOfMonth(final Instant date) {
        return new IsDayOfMonth<>(INSTANT_AS_DAYOFMONTH, dayOfMonth(date));
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
    public static TemporalMatcher<Instant> isDayOfMonth(final int dayOfMonth) {
        return new IsDayOfMonth<>(INSTANT_AS_DAYOFMONTH, dayOfMonth(dayOfMonth));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is on the same year as the reference date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameYear(Instant.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<Instant> sameYear(final Instant date) {
        return new IsYear<>(INSTANT_AS_YEAR, year(date));
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
    public static TemporalMatcher<Instant> isYear(final int year) {
        return new IsYear<>(INSTANT_AS_YEAR, year(year));
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
    public static TemporalMatcher<Instant> within(final long period,
            final ChronoUnit unit,
            final Instant date) {
        return new IsWithin<>(Interval.of(period, unit),
                INSTANT_AS_INSTANT,
                instant(date),
                INSTANT);
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
    public static TemporalMatcher<Instant> within(final long period,
            final ChronoUnit unit,
            final int year,
            final Month month,
            final int dayofMonth,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneId tz) {
        return within(period,
                unit,
                ZonedDateTime.of(year, month.getValue(), dayofMonth, hour, minute, second, nanos, tz).toInstant());
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
    public static TemporalMatcher<Instant> isYesterday() {
        return sameDay(Instant.now().plus(-1, ChronoUnit.DAYS));
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
    public static TemporalMatcher<Instant> isToday() {
        return sameDay(Instant.now());
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
    public static TemporalMatcher<Instant> isTomorrow() {
        return sameDay(Instant.now().plus(1, ChronoUnit.DAYS));
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
    public static TemporalMatcher<Instant> sameDayOfWeek(final Instant date) {
        return isDayOfWeek(TemporalConverters.INSTANT_AS_DAYOFWEEK.apply(date, Optional.empty()));
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
    public static TemporalMatcher<Instant> isDayOfWeek(final DayOfWeek dayOfWeek) {
        return new IsDayOfWeek<>(INSTANT_AS_DAYOFWEEK, daysOfWeek(dayOfWeek));
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
    public static TemporalMatcher<Instant> isDayOfWeek(final DayOfWeek... daysOfWeek) {
        return new IsDayOfWeek<>(INSTANT_AS_DAYOFWEEK, daysOfWeek(daysOfWeek));
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
    public static TemporalMatcher<Instant> isMonday() {
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
    public static TemporalMatcher<Instant> isTuesday() {
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
    public static TemporalMatcher<Instant> isWednesday() {
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
    public static TemporalMatcher<Instant> isThursday() {
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
    public static TemporalMatcher<Instant> isFriday() {
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
    public static TemporalMatcher<Instant> isSaturday() {
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
    public static TemporalMatcher<Instant> isSunday() {
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
    public static TemporalMatcher<Instant> isWeekday() {
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
    public static TemporalMatcher<Instant> isWeekend() {
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
    public static TemporalMatcher<Instant> isFirstDayOfMonth() {
        return new IsFirstDayOfMonth<>(INSTANT_AS_ZONEDDATETIME);
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
    public static TemporalMatcher<Instant> isMinimum(final ChronoField field) {
        return new IsMinimum<>(INSTANT_AS_ZONEDDATETIME, field);
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
    public static TemporalMatcher<Instant> isLastDayOfMonth() {
        return new IsLastDayOfMonth<>(INSTANT_AS_ZONEDDATETIME);
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
    public static TemporalMatcher<Instant> isMaximum(final ChronoField field) {
        return new IsMaximum<>(INSTANT_AS_ZONEDDATETIME, field);
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
    public static TemporalMatcher<Instant> isMonth(final Month month) {
        return new IsMonth<>(INSTANT_AS_MONTH, month(month));
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
    public static TemporalMatcher<Instant> isJanuary() {
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
    public static TemporalMatcher<Instant> isFebruary() {
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
    public static TemporalMatcher<Instant> isMarch() {
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
    public static TemporalMatcher<Instant> isApril() {
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
    public static TemporalMatcher<Instant> isMay() {
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
    public static TemporalMatcher<Instant> isJune() {
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
    public static TemporalMatcher<Instant> isJuly() {
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
    public static TemporalMatcher<Instant> isAugust() {
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
    public static TemporalMatcher<Instant> isSeptember() {
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
    public static TemporalMatcher<Instant> isOctober() {
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
    public static TemporalMatcher<Instant> isNovember() {
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
    public static TemporalMatcher<Instant> isDecember() {
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
    public static TemporalMatcher<Instant> isLeapYear() {
        return new IsLeapYear<>(INSTANT_AS_YEAR);
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
    public static TemporalMatcher<Instant> isHour(final int hour) {
        return new IsHour<>(INSTANT_AS_HOUR, hour(hour));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is on the same hour as the reference date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameHourOfDay(Instant.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<Instant> sameHourOfDay(final Instant date) {
        return new IsHour<>(INSTANT_AS_HOUR, hour(date));
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
    public static TemporalMatcher<Instant> isMinute(final int minute) {
        return new IsMinute<>(INSTANT_AS_MINUTE, minute(minute));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is on the same minute as the reference date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameMinuteOfHour(Instant.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<Instant> sameMinuteOfHour(final Instant date) {
        return new IsMinute<>(INSTANT_AS_MINUTE, minute(date));
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
    public static TemporalMatcher<Instant> isSecond(final int second) {
        return new IsSecond<>(INSTANT_AS_SECOND, second(second));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is on the same second as the reference date
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameSecondOfMinute(Instant.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<Instant> sameSecondOfMinute(final Instant date) {
        return new IsSecond<>(INSTANT_AS_SECOND, second(date));
    }
}
