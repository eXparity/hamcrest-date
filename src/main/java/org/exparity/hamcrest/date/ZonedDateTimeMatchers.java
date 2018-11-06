package org.exparity.hamcrest.date;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import static java.time.Month.APRIL;
import static java.time.Month.AUGUST;
import static java.time.Month.DECEMBER;
import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;
import static java.time.Month.JULY;
import static java.time.Month.JUNE;
import static java.time.Month.MARCH;
import static java.time.Month.MAY;
import static java.time.Month.NOVEMBER;
import static java.time.Month.OCTOBER;
import static java.time.Month.SEPTEMBER;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

import org.exparity.hamcrest.date.core.AnyOfZonedTemporals;
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
import org.exparity.hamcrest.date.core.ZonedTemporalMatcher;
import org.exparity.hamcrest.date.core.format.DatePartFormatter;
import org.exparity.hamcrest.date.core.format.ZonedDateTimeFormatter;
import org.exparity.hamcrest.date.core.wrapper.FieldZonedDateTimeWrapper;
import org.exparity.hamcrest.date.core.wrapper.ZonedDateTimeWrapper;
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> after(final ZonedDateTime date) {
        return new IsAfter<>(new ZonedDateTimeWrapper(date), new ZonedDateTimeFormatter());
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> after(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneId zone) {
        return new IsAfter<>(
            new ZonedDateTimeWrapper(year, month, dayOfMonth, hour, minute, second, nanos, zone),
            new ZonedDateTimeFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is before the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, ZonedDateTimeMatchers.before(ZonedDateTime.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> before(final ZonedDateTime date) {
        return new IsBefore<>(new ZonedDateTimeWrapper(date), new ZonedDateTimeFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is before the end of the reference year
     * <p/>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, ZonedDateTimeMatchers.before(2012, Month.MAY, 12));
     * </pre>
     *
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     * @param nanos the nanoseconds of the second
     */
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> before(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneId zone) {
        return new IsBefore<>(new ZonedDateTimeWrapper(year, month, dayOfMonth, hour, minute, second, nanos, zone),
            new ZonedDateTimeFormatter());
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> sameDay(final ZonedDateTime date) {
        return new IsSameDay<>(new ZonedDateTimeWrapper(date, ChronoUnit.DAYS), new ZonedDateTimeFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameDay(2012, Month.JAN, 1, ZoneId.systemDefault()))
     * </pre>
     *
     * @param dayOfMonth the reference day of the month against which the examined date is checked
     * @param month the reference month against which the examined date is checked
     * @param year the reference year against which the examined date is checked
     * @param zone the reference time zone
     */
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isDay(final int year,
            final Month month,
            final int dayOfMonth,
            final ZoneId zone) {
        return new IsSameDay<>(new ZonedDateTimeWrapper(year, month, dayOfMonth, zone),
            new ZonedDateTimeFormatter());
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> sameInstant(final ZonedDateTime date) {
        return new IsSame<>(new ZonedDateTimeWrapper(date), new ZonedDateTimeFormatter());
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
     * @param zone the timezone
     */
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isInstant(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneId zone) {
        return new IsSame<>(
            new ZonedDateTimeWrapper(year, month, dayOfMonth, hour, minute, second, nanos, zone),
            new ZonedDateTimeFormatter());
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> sameOrBefore(final ZonedDateTime date) {
        return new IsSameOrBefore<>(new ZonedDateTimeWrapper(date), new ZonedDateTimeFormatter());
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
     * @param zone the time zone of the date to check against
     */
    @Factory
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> sameOrBefore(final int year,
            final Month month,
            final int day,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneId zone) {
        return new IsSameOrBefore<>(
            new ZonedDateTimeWrapper(year, month, day, hour, minute, second, nanos, zone),
            new ZonedDateTimeFormatter());
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> sameOrAfter(final ZonedDateTime date) {
        return new IsSameOrAfter<>(new ZonedDateTimeWrapper(date), new ZonedDateTimeFormatter());
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
     * @param zone the time zone of the date to check against
     */
    @Factory
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> sameOrAfter(final int year,
            final Month month,
            final int day,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneId zone) {
        return new IsSameOrAfter<>(
            new ZonedDateTimeWrapper(year, month, day, hour, minute, second, nanos, zone),
            new ZonedDateTimeFormatter());
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> sameMonthOfYear(final ZonedDateTime date) {
        return new IsMonth<>(
            new FieldZonedDateTimeWrapper(date, ChronoField.MONTH_OF_YEAR),
            (d, z) -> ZonedDateTime.ofInstant(d.toInstant(), z).get(ChronoField.MONTH_OF_YEAR),
            ZoneId.systemDefault()
        );
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> sameDayOfMonth(final ZonedDateTime date) {
        return new IsDayOfMonth<>(
            new FieldZonedDateTimeWrapper(date, ChronoField.DAY_OF_MONTH),
            (d, z) -> ZonedDateTime.ofInstant(d.toInstant(), z).get(ChronoField.DAY_OF_MONTH),
            ZoneId.systemDefault()
        );
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isDayOfMonth(final int dayOfMonth) {
        return new IsDayOfMonth<>(
            new FieldZonedDateTimeWrapper(dayOfMonth, ChronoField.DAY_OF_MONTH),
            (d, z) -> ZonedDateTime.ofInstant(d.toInstant(), z).get(ChronoField.DAY_OF_MONTH),
            ZoneId.systemDefault()
        );
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> sameYear(final ZonedDateTime date) {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isYear(final int year) {
        return new IsYear<>(
            new FieldZonedDateTimeWrapper(year, ChronoField.YEAR),
            (d, z) -> ZonedDateTime.ofInstant(d.toInstant(), z).get(ChronoField.YEAR),
            ZoneId.systemDefault()
        );
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> within(final long period, final ChronoUnit unit, final ZonedDateTime date) {
        return new IsWithin<>(period, unit, new ZonedDateTimeWrapper(date), new ZonedDateTimeFormatter());
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
     * @param zone the time zone of the reference date
     */
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> within(final long period,
            final ChronoUnit unit,
            final int year,
            final Month month,
            final int dayofMonth,
            final int hour,
            final int minute,
            final int second,
            final int nanos,
            final ZoneId zone) {
        return new IsWithin<>(period,
            unit,
            new ZonedDateTimeWrapper(year, month, dayofMonth, hour, minute, second, nanos, zone),
            new ZonedDateTimeFormatter());
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isYesterday() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isToday() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isTomorrow() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> sameDayOfWeek(final ZonedDateTime date) {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isDayOfWeek(final DayOfWeek dayOfWeek) {
        return new IsDayOfWeek<>(
            new FieldZonedDateTimeWrapper(dayOfWeek.getValue(), ChronoField.DAY_OF_WEEK),
            (d, z) -> ZonedDateTime.ofInstant(d.toInstant(), z).get(ChronoField.DAY_OF_WEEK),
            ZoneId.systemDefault()
        );
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isDayOfWeek(final DayOfWeek... daysOfWeek) {
        return new AnyOfZonedTemporals<>(
            Stream.of(daysOfWeek).map(ZonedDateTimeMatchers::isDayOfWeek),
            (d, z) -> "the date is on a " + d.withZoneSameInstant(z).getDayOfWeek().name().toLowerCase(),
            ZoneId.systemDefault()
        );
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isMonday() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isTuesday() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isWednesday() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isThursday() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isFriday() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isSaturday() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isSunday() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isWeekday() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isWeekend() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isFirstDayOfMonth() {
        return new IsMinimum<>(ChronoField.DAY_OF_MONTH,
            (d, z) -> d.withZoneSameInstant(z).get(ChronoField.DAY_OF_MONTH),
            (d, z) -> ChronoField.DAY_OF_MONTH.rangeRefinedBy(d.withZoneSameInstant(z)).getMinimum(),
            new DatePartFormatter(),
            () -> "the date is the first day of the month",
            ZoneId.systemDefault());
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isMinimum(final ChronoField field) {
        return new IsMinimum<>(
            field,
            (d, z) -> d.withZoneSameInstant(z).get(field),
            (d, z) -> field.rangeRefinedBy(d.withZoneSameInstant(z)).getMinimum(),
            new DatePartFormatter(),
            ZoneId.systemDefault()
        );
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isLastDayOfMonth() {
        return new IsMaximum<>(
            ChronoField.DAY_OF_MONTH,
            (d, z) -> d.withZoneSameInstant(z).get(ChronoField.DAY_OF_MONTH),
            (d, z) -> ChronoField.DAY_OF_MONTH.rangeRefinedBy(d.withZoneSameInstant(z)).getMaximum(),
            new DatePartFormatter(),
            () -> "the date is the last day of the month",
            ZoneId.systemDefault()
        );
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isMaximum(final ChronoField field) {
        return new IsMaximum<>(
            field,
            (d, z) -> d.withZoneSameInstant(z).get(field),
            (d, z) -> field.rangeRefinedBy(d.withZoneSameInstant(z)).getMaximum(),
            new DatePartFormatter(),
            ZoneId.systemDefault()
        );
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isMonth(final Month month) {
        return new IsMonth<>(
            new FieldZonedDateTimeWrapper(month.getValue(), ChronoField.MONTH_OF_YEAR),
            (d, z) -> ZonedDateTime.ofInstant(d.toInstant(), z).get(ChronoField.MONTH_OF_YEAR),
            ZoneId.systemDefault()
        );
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isJanuary() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isFebruary() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isMarch() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isApril() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isMay() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isJune() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isJuly() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isAugust() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isSeptember() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isOctober() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isNovember() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isDecember() {
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isLeapYear() {
        return new IsLeapYear<>(
            (d, z) -> d.withZoneSameInstant(z).toLocalDate().isLeapYear(),
            new ZonedDateTimeFormatter(),
            ZoneId.systemDefault()
        );
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isHour(final int hour) {
        return new IsHour<>(
            new FieldZonedDateTimeWrapper(hour, ChronoField.HOUR_OF_DAY),
            (d, z) -> ZonedDateTime.ofInstant(d.toInstant(), z).get(ChronoField.HOUR_OF_DAY),
            ZoneId.systemDefault()
        );
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> sameHourOfDay(final ZonedDateTime date) {
        return new IsHour<>(
            new FieldZonedDateTimeWrapper(date, ChronoField.HOUR_OF_DAY),
            (d, z) -> ZonedDateTime.ofInstant(d.toInstant(), z).get(ChronoField.HOUR_OF_DAY),
            ZoneId.systemDefault()
        );
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isMinute(final int minute) {
        return new IsMinute<>(
            new FieldZonedDateTimeWrapper(minute, ChronoField.MINUTE_OF_HOUR),
            (d, z) -> ZonedDateTime.ofInstant(d.toInstant(), z).get(ChronoField.MINUTE_OF_HOUR),
            ZoneId.systemDefault()
        );
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> sameMinuteOfHour(final ZonedDateTime date) {
        return new IsMinute<>(
            new FieldZonedDateTimeWrapper(date, ChronoField.MINUTE_OF_HOUR),
            (d, z) -> ZonedDateTime.ofInstant(d.toInstant(), z).get(ChronoField.MINUTE_OF_HOUR),
            ZoneId.systemDefault()
        );
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> isSecond(final int second) {
        return new IsSecond<>(
            new FieldZonedDateTimeWrapper(second, ChronoField.SECOND_OF_MINUTE),
            (d, z) -> ZonedDateTime.ofInstant(d.toInstant(), z).get(ChronoField.SECOND_OF_MINUTE),
            ZoneId.systemDefault()
        );
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
    public static ZonedTemporalMatcher<ZonedDateTime, ZoneId> sameSecondOfMinute(final ZonedDateTime date) {
        return new IsSecond<>(
            new FieldZonedDateTimeWrapper(date, ChronoField.SECOND_OF_MINUTE),
            (d, z) -> ZonedDateTime.ofInstant(d.toInstant(), z).get(ChronoField.SECOND_OF_MINUTE),
            ZoneId.systemDefault()
        );
    }
}
