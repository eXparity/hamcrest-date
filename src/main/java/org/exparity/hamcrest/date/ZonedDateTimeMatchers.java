package org.exparity.hamcrest.date;

import static java.time.DayOfWeek.*;
import static java.time.Month.*;
import static org.exparity.hamcrest.date.core.TemporalConverters.*;
import static org.exparity.hamcrest.date.core.TemporalFunctions.ZONEDDATETIME;
import static org.exparity.hamcrest.date.core.TemporalProviders.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import org.exparity.hamcrest.date.core.DateMatcher;
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
import org.hamcrest.Factory;

/**
 * Static factory for creating {@link org.hamcrest.Matcher} instances for comparing {@link ZonedDateTime} instances
 *
 * @author Stewart Bissett
 */
public abstract class ZonedDateTimeMatchers {

    /**
     * Creates a matcher that matches when the examined date is after the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, after(ZonedDateTime.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<ZonedDateTime> after(final ZonedDateTime date) {
        return new IsAfter<>(ZONEDDATETIME_AS_ZONEDDATETIME, zonedDateTime(date), ZONEDDATETIME);
    }

    /**
     * Creates a matcher that matches when the examined date is after the end of the reference year
     * <p/>
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
    public static DateMatcher<ZonedDateTime> after(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneId tz) {
        return after(ZonedDateTime.of(year, month.getValue(), dayOfMonth, hour, minute, second, nanos, tz));
    }

    /**
     * Creates a matcher that matches when the examined date is before the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, before(ZonedDateTime.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<ZonedDateTime> before(final ZonedDateTime date) {
        return new IsBefore<>(ZONEDDATETIME_AS_ZONEDDATETIME, zonedDateTime(date), ZONEDDATETIME);
    }

    /**
     * Creates a matcher that matches when the examined date is before the end of the reference year
     * <p/>
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
    public static DateMatcher<ZonedDateTime> before(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneId tz) {
        return before(ZonedDateTime.of(year, month.getValue(), dayOfMonth, hour, minute, second, nanos, tz));
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameDay(ZonedDateTime.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<ZonedDateTime> sameDay(final ZonedDateTime date) {
        return new IsSameDay<>(ZONEDDATETIME_AS_LOCALDATE, localDate(date));
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameDay(LocalDate.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<ZonedDateTime> isDay(LocalDate date) {
        return new IsSameDay<>(ZONEDDATETIME_AS_LOCALDATE, localDate(date));
    }
    
    /**
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
     * <p/>
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
    public static DateMatcher<ZonedDateTime> isDay(final int year, final Month month, final int dayOfMonth) {
        return isDay(LocalDate.of(year, month, dayOfMonth));
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
     * <p/>
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
    public static DateMatcher<ZonedDateTime> isDay(final int year, final Month month, final int dayOfMonth, final ZoneId zone) {
        return isDay(LocalDate.of(year, month, dayOfMonth)).atZone(zone);
    }
    
    /**
     * Creates a matcher that matches when the examined date is at the same instant as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameInstant(ZonedDateTime.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<ZonedDateTime> sameInstant(final ZonedDateTime date) {
        return new IsSame<>(ZONEDDATETIME_AS_ZONEDDATETIME, zonedDateTime(date), ZONEDDATETIME);
    }

    /**
     * Creates a matcher that matches when the examined date is at the same specified instance down to the second
     * <p/>
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
    public static DateMatcher<ZonedDateTime> isInstant(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneId tz) {
        return sameInstant(ZonedDateTime.of(year, month.getValue(), dayOfMonth, hour, minute, second, nanos, tz));
    }

    /**
     * Creates a matcher that matches when the examined date is at the same instant or before the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrBefore(ZonedDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<ZonedDateTime> sameOrBefore(final ZonedDateTime date) {
        return new IsSameOrBefore<>(ZONEDDATETIME_AS_ZONEDDATETIME, zonedDateTime(date), ZONEDDATETIME);
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day or before the start of the reference
     * date
     * <p/>
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
    @Factory
    public static DateMatcher<ZonedDateTime> sameOrBefore(final int year,
            final Month month,
            final int day,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneId tz) {
        return sameOrBefore(ZonedDateTime.of(year, month.getValue(), day, hour, minute, second, nanos, tz));
    }

    /**
     * Creates a matcher that matches when the examined date is at the same instant or after the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrAfter(ZonedDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<ZonedDateTime> sameOrAfter(final ZonedDateTime date) {
        return new IsSameOrAfter<>(ZONEDDATETIME_AS_ZONEDDATETIME, zonedDateTime(date), ZONEDDATETIME);
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day or before the start of the reference
     * date
     * <p/>
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
    @Factory
    public static DateMatcher<ZonedDateTime> sameOrAfter(final int year,
            final Month month,
            final int day,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneId tz) {
        return sameOrAfter(ZonedDateTime.of(year, month.getValue(), day, hour, minute, second, nanos, tz));
    }

    /**
     * Creates a matcher that matches when the examined date is on the same month as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameMonth(ZonedDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<ZonedDateTime> sameMonthOfYear(final ZonedDateTime date) {
        return new IsMonth<>(ZONEDDATETIME_AS_MONTH, month(date));
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the month as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameDayOfMonth(ZonedDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<ZonedDateTime> sameDayOfMonth(final ZonedDateTime date) {
        return new IsDayOfMonth<>(ZONEDDATETIME_AS_DAYOFMONTH, dayOfMonth(date));
    }

    /**
     * Creates a matcher that matches when the examined date is on the expected day of the month
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isDayOfMonth(4))
     * </pre>
     *
     * @param dayOfMonth the expected day of the month
     */
    public static DateMatcher<ZonedDateTime> isDayOfMonth(final int dayOfMonth) {
        return new IsDayOfMonth<>(ZONEDDATETIME_AS_DAYOFMONTH, dayOfMonth(dayOfMonth));
    }

    /**
     * Creates a matcher that matches when the examined date is on the same year as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameYear(ZonedDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<ZonedDateTime> sameYear(final ZonedDateTime date) {
        return isYear(date.getYear());
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
     * @param year the reference year against which the examined date is checked
     */
    public static DateMatcher<ZonedDateTime> isYear(final int year) {
        return new IsYear<>(ZONEDDATETIME_AS_YEAR, year(year));
    }

    /**
     * Creates a matcher that matches when the examined date is within a defined period the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, within(10, TimeUnit.DAYS, Moments.today()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<ZonedDateTime> within(final long period,
            final ChronoUnit unit,
            final ZonedDateTime date) {
        return new IsWithin<>(Interval.of(period, unit),
                ZONEDDATETIME_AS_ZONEDDATETIME,
                zonedDateTime(date),
                ZONEDDATETIME);
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
    public static DateMatcher<ZonedDateTime> within(final long period,
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
                ZonedDateTime.of(year, month.getValue(), dayofMonth, hour, minute, second, nanos, tz));
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
    public static DateMatcher<ZonedDateTime> isYesterday() {
        return sameDay(ZonedDateTime.now().plusDays(-1));
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
    public static DateMatcher<ZonedDateTime> isToday() {
        return sameDay(ZonedDateTime.now());
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
    public static DateMatcher<ZonedDateTime> isTomorrow() {
        return sameDay(ZonedDateTime.now().plusDays(1));
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the week as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameDayOfWeek(LocalDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<ZonedDateTime> sameDayOfWeek(final ZonedDateTime date) {
        return isDayOfWeek(DayOfWeek.from(date));
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the week as the supplied day
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isMonday());
     * </pre>
     */
    public static DateMatcher<ZonedDateTime> isDayOfWeek(final DayOfWeek dayOfWeek) {
        return new IsDayOfWeek<>(ZONEDDATETIME_AS_DAYOFWEEK, daysOfWeek(dayOfWeek));
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the week as any of the supplied days
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isMonday());
     * </pre>
     */
    public static DateMatcher<ZonedDateTime> isDayOfWeek(final DayOfWeek... daysOfWeek) {
        return new IsDayOfWeek<>(ZONEDDATETIME_AS_DAYOFWEEK, daysOfWeek(daysOfWeek));
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
    public static DateMatcher<ZonedDateTime> isMonday() {
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
    public static DateMatcher<ZonedDateTime> isTuesday() {
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
    public static DateMatcher<ZonedDateTime> isWednesday() {
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
    public static DateMatcher<ZonedDateTime> isThursday() {
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
    public static DateMatcher<ZonedDateTime> isFriday() {
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
    public static DateMatcher<ZonedDateTime> isSaturday() {
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
    public static DateMatcher<ZonedDateTime> isSunday() {
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
    public static DateMatcher<ZonedDateTime> isWeekday() {
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
    public static DateMatcher<ZonedDateTime> isWeekend() {
        return isDayOfWeek(SATURDAY, SUNDAY);
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
    public static DateMatcher<ZonedDateTime> isFirstDayOfMonth() {
        return new IsFirstDayOfMonth<>(ZONEDDATETIME_AS_ZONEDDATETIME);
    }

    /**
     * Creates a matcher that matches when the examined date is on the maximum value of the given date part in its
     * period
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isMaximumDayOfMonth(ChronoField.DAY_OF_MONTH));
     * </pre>
     *
     * @param field the temporal field to check
     */
    public static DateMatcher<ZonedDateTime> isMinimum(final ChronoField field) {
        return new IsMinimum<>(ZONEDDATETIME_AS_ZONEDDATETIME, field);
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
    public static DateMatcher<ZonedDateTime> isLastDayOfMonth() {
        return new IsLastDayOfMonth<>(ZONEDDATETIME_AS_ZONEDDATETIME);
    }

    /**
     * Creates a matcher that matches when the examined date is on the maximum value of the given date part in its
     * period
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isMaximum(ChronoField.DAY_OF_MONTH));
     * </pre>
     *
     * @param field the temporal field to check
     */
    public static DateMatcher<ZonedDateTime> isMaximum(final ChronoField field) {
        return new IsMaximum<>(ZONEDDATETIME_AS_ZONEDDATETIME, field);
    }

    /**
     * Creates a matcher that matches when the examined date is in the expected month
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isMonth(Month.AUGUST));
     * </pre>
     */
    public static DateMatcher<ZonedDateTime> isMonth(final Month month) {
        return new IsMonth<>(ZONEDDATETIME_AS_MONTH, month(month));
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
    public static DateMatcher<ZonedDateTime> isJanuary() {
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
    public static DateMatcher<ZonedDateTime> isFebruary() {
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
    public static DateMatcher<ZonedDateTime> isMarch() {
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
    public static DateMatcher<ZonedDateTime> isApril() {
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
    public static DateMatcher<ZonedDateTime> isMay() {
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
    public static DateMatcher<ZonedDateTime> isJune() {
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
    public static DateMatcher<ZonedDateTime> isJuly() {
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
    public static DateMatcher<ZonedDateTime> isAugust() {
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
    public static DateMatcher<ZonedDateTime> isSeptember() {
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
    public static DateMatcher<ZonedDateTime> isOctober() {
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
    public static DateMatcher<ZonedDateTime> isNovember() {
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
    public static DateMatcher<ZonedDateTime> isDecember() {
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
    public static DateMatcher<ZonedDateTime> isLeapYear() {
        return new IsLeapYear<>(ZONEDDATETIME_AS_YEAR);
    }

    /**
     * Creates a matcher that matches when the examined date is on the expected hour (0-23)
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isHour(12));
     * </pre>
     *
     * @param hour the hour of the day (0-23)
     */
    public static DateMatcher<ZonedDateTime> isHour(final int hour) {
        return new IsHour<>(ZONEDDATETIME_AS_HOUR, hour(hour));
    }

    /**
     * Creates a matcher that matches when the examined date is on the same hour as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameHourOfDay(ZonedDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<ZonedDateTime> sameHourOfDay(final ZonedDateTime date) {
        return new IsHour<>(ZONEDDATETIME_AS_HOUR, hour(date));
    }

    /**
     * Creates a matcher that matches when the examined date is on the expected minute (0-59)
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isMinute(12));
     * </pre>
     *
     * @param minute the minute of the day (0-59)
     */
    public static DateMatcher<ZonedDateTime> isMinute(final int minute) {
        return new IsMinute<>(ZONEDDATETIME_AS_MINUTE, minute(minute));
    }

    /**
     * Creates a matcher that matches when the examined date is on the same minute as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameMinuteOfHour(ZonedDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<ZonedDateTime> sameMinuteOfHour(final ZonedDateTime date) {
        return new IsMinute<>(ZONEDDATETIME_AS_MINUTE, minute(date));
    }

    /**
     * Creates a matcher that matches when the examined date is on the expected second (0-59)
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isSecond(12));
     * </pre>
     *
     * @param second the second of the day (0-59)
     */
    public static DateMatcher<ZonedDateTime> isSecond(final int second) {
        return new IsSecond<>(ZONEDDATETIME_AS_SECOND, second(second));
    }

    /**
     * Creates a matcher that matches when the examined date is on the same second as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameSecondOfMinute(ZonedDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<ZonedDateTime> sameSecondOfMinute(final ZonedDateTime date) {
        return new IsSecond<>(ZONEDDATETIME_AS_SECOND, second(date));
    }
}
