package org.exparity.hamcrest.date.joda;

import java.util.stream.IntStream;

import org.exparity.hamcrest.date.core.AnyOfZonedTemporals;
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
import org.exparity.hamcrest.date.core.ZonedTemporalMatcher;
import org.exparity.hamcrest.date.joda.format.JodaDatePartFormatter;
import org.exparity.hamcrest.date.joda.format.JodaDateTimeFormatter;
import org.exparity.hamcrest.date.joda.wrapper.FieldJodaDateTimeWrapper;
import org.exparity.hamcrest.date.joda.wrapper.JodaDateTimeWrapper;
import org.hamcrest.Factory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalDate;

/**
 * Static factory for creating {@link org.hamcrest.Matcher} instances for comparing Joda {@link DateTime} instances
 *
 * @author Thomas Naskali
 */
public abstract class JodaDateTimeMatchers {

    /**
     * Creates a matcher that matches when the examined date is after the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, after(DateTime.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> after(final DateTime date) {
        return new IsAfter<>(new JodaDateTimeWrapper(date), new JodaDateTimeFormatter());
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
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> after(final int year,
            final int month,
            final int dayOfMonth,
            final DateTimeZone zone) {
        return after(new LocalDate(year, month, dayOfMonth), zone);
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
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> after(final int year,
            final int month,
            final int dayOfMonth) {
        return after(new LocalDate(year, month, dayOfMonth));
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
     * @param date the date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> after(final LocalDate date,
            final DateTimeZone zone) {
        return new IsAfter<>(
            new JodaDateTimeWrapper(date, zone),
            new JodaDateTimeFormatter()
        );
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
     * @param date the date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> after(final LocalDate date) {
        return new IsAfter<>(
            new JodaDateTimeWrapper(date),
            new JodaDateTimeFormatter()
        );
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
     * @param millis the millis of the second
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> after(final int year,
            final int month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int millis,
            final DateTimeZone zone) {
        return new IsAfter<>(
            new JodaDateTimeWrapper(year, month, dayOfMonth, hour, minute, second, millis, zone),
            new JodaDateTimeFormatter()
        );
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
     * @param millis the millis of the second
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> after(
            final int year,
            final int month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int millis) {
        return new IsAfter<>(
            new JodaDateTimeWrapper(year, month, dayOfMonth, hour, minute, second, millis),
            new JodaDateTimeFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is before the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, DateTimeMatchers.before(DateTime.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> before(final DateTime date) {
        return new IsBefore<>(new JodaDateTimeWrapper(date), new JodaDateTimeFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is before the end of the reference year
     * <p/>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, DateTimeMatchers.before(2012, Month.MAY, 12));
     * </pre>
     *
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     * @param millis the milliseconds of the second
     * @param zone the time zone
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> before(final int year,
            final int month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int millis,
            final DateTimeZone zone) {
        return new IsBefore<>(
            new JodaDateTimeWrapper(year, month, dayOfMonth, hour, minute, second, millis, zone),
            new JodaDateTimeFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is before the end of the reference year
     * <p/>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, DateTimeMatchers.before(2012, Month.MAY, 12));
     * </pre>
     *
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     * @param millis the milliseconds of the second
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> before(final int year,
            final int month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int millis) {
        return new IsBefore<>(
            new JodaDateTimeWrapper(year, month, dayOfMonth, hour, minute, second, millis),
            new JodaDateTimeFormatter()
        );    }

    /**
     * Creates a matcher that matches when the examined date is before the end of the reference day of the year
     * <p/>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, DateTimeMatchers.before(2012, Month.MAY, 12));
     * </pre>
     *
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param zone the time zone
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> before(final int year,
            final int month,
            final int dayOfMonth,
            final DateTimeZone zone) {
        return new IsBefore<>(
            new JodaDateTimeWrapper(year, month, dayOfMonth, zone),
            new JodaDateTimeFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is before the end of the reference day of the year
     * <p/>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, DateTimeMatchers.before(2012, Month.MAY, 12));
     * </pre>
     *
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> before(final int year,
            final int month,
            final int dayOfMonth) {
        return new IsBefore<>(
            new JodaDateTimeWrapper(year, month, dayOfMonth),
            new JodaDateTimeFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is before the date
     * <p/>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, DateTimeMatchers.before(2012, Month.MAY, 12));
     * </pre>
     *
     * @param date the date against which the examined date is checked
     * @param zone the time zone
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> before(final LocalDate date,
            final DateTimeZone zone) {
        return new IsBefore<>(
            new JodaDateTimeWrapper(date, zone),
            new JodaDateTimeFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is before the date
     * <p/>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, DateTimeMatchers.before(2012, Month.MAY, 12));
     * </pre>
     *
     * @param date the date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> before(final LocalDate date) {
        return new IsBefore<>(
            new JodaDateTimeWrapper(date),
            new JodaDateTimeFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameDay(DateTime.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> sameDay(final DateTime date) {
        return new IsSameDay<>(
            new JodaDateTimeWrapper(date, DateTimeFieldType.dayOfMonth()),
            new JodaDateTimeFormatter()
        );
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
     * @param zone the reference time zone
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isDay(
            final int year,
            final int month,
            final int dayOfMonth,
            final DateTimeZone zone) {
        return new IsSameDay<>(
            new JodaDateTimeWrapper(year, month, dayOfMonth, zone),
            new JodaDateTimeFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is at the same instant as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameInstant(DateTime.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> sameInstant(final DateTime date) {
        return new IsSame<>(new JodaDateTimeWrapper(date), new JodaDateTimeFormatter());
    }

    /**
      * Creates a matcher that matches when the examined date is at the same instant as the reference date
      * <p/>
      * For example:
      *
      * <pre>
      * assertThat(myDate, sameInstant(DateTime.now()));
      * </pre>
      *
      * @param epochMillis the instant in epoch millis against which the examined date is checked
      */
     public static ZonedTemporalMatcher<DateTime, DateTimeZone> sameInstant(final long epochMillis) {
         return sameInstant(new DateTime(epochMillis));
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
     * @param millis the millisecond of the second
     * @param zone the timezone
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isInstant(final int year,
            final int month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int millis,
            final DateTimeZone zone) {
        return new IsSame<>(
            new JodaDateTimeWrapper(year, month, dayOfMonth, hour, minute, second, millis, zone),
            new JodaDateTimeFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is at the same instant or before the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrBefore(DateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> sameOrBefore(final DateTime date) {
        return new IsSameOrBefore<>(new JodaDateTimeWrapper(date), new JodaDateTimeFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day or before the start of the reference
     * date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrBefore(2012, Months.MAY, 12, 11, 59, 59, DateTimeZone.getDefault()));
     * </pre>
     *
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param day the day of the month against which the examined date is checked
     * @param hour the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     * @param millis the millisecond of the second
     * @param zone the time zone of the date to check against
     */
    @Factory
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> sameOrBefore(final int year,
            final int month,
            final int day,
            final int hour,
            final int minute,
            final int second,
            final int millis,
            final DateTimeZone zone) {
        return new IsSameOrBefore<>(
            new JodaDateTimeWrapper(year, month, day, hour, minute, second, millis, zone),
            new JodaDateTimeFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is at the same instant or after the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrAfter(DateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> sameOrAfter(final DateTime date) {
        return new IsSameOrAfter<>(new JodaDateTimeWrapper(date), new JodaDateTimeFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day or before the start of the reference
     * date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrAfter(2012, Months.MAY, 12, 11, 59, 59, DateTimeZone.getDefault()));
     * </pre>
     *
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param day the day of the month against which the examined date is checked
     * @param hour the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     * @param millis the millisecond of the second
     * @param zone the time zone of the date to check against
     */
    @Factory
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> sameOrAfter(final int year,
            final int month,
            final int day,
            final int hour,
            final int minute,
            final int second,
            final int millis,
            final DateTimeZone zone) {
        return new IsSameOrAfter<>(
            new JodaDateTimeWrapper(year, month, day, hour, minute, second, millis, zone),
            new JodaDateTimeFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is on the same month as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameMonth(DateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> sameMonthOfYear(final DateTime date) {
        return new IsMonth<>(
            new FieldJodaDateTimeWrapper(date, DateTimeFieldType.monthOfYear()),
            (d, z) -> d.withZone(z).get(DateTimeFieldType.monthOfYear()),
            DateTimeZone.getDefault()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the month as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameDayOfMonth(DateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> sameDayOfMonth(final DateTime date) {
        return new IsDayOfMonth<>(
            new FieldJodaDateTimeWrapper(date, DateTimeFieldType.dayOfMonth()),
            (d, z) -> d.withZone(z).get(DateTimeFieldType.dayOfMonth()),
            DateTimeZone.getDefault()
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isDayOfMonth(final int dayOfMonth) {
        return new IsDayOfMonth<>(
            new FieldJodaDateTimeWrapper(dayOfMonth, DateTimeFieldType.dayOfMonth()),
            (d, z) -> d.withZone(z).get(DateTimeFieldType.dayOfMonth()),
            DateTimeZone.getDefault()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same year as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameYear(DateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> sameYear(final DateTime date) {
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isYear(final int year) {
        return new IsYear<>(
            new FieldJodaDateTimeWrapper(year, DateTimeFieldType.year()),
            (d, z) -> d.withZone(z).get(DateTimeFieldType.year()),
            DateTimeZone.getDefault()
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> within(final long period, final DurationFieldType unit, final DateTime date) {
        return new IsWithin<>(period, unit, new JodaDateTimeWrapper(date), new JodaDateTimeFormatter());
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
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     * @param millis the milliseconds of the second
     * @param zone the time zone of the reference date
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> within(final long period,
            final DurationFieldType unit,
            final int year,
            final int month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int millis,
            final DateTimeZone zone) {
        return new IsWithin<>(period,
            unit,
            new JodaDateTimeWrapper(year, month, dayOfMonth, hour, minute, second, millis, zone),
            new JodaDateTimeFormatter());
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isYesterday() {
        return sameDay(DateTime.now().plusDays(-1));
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isToday() {
        return sameDay(DateTime.now());
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isTomorrow() {
        return sameDay(DateTime.now().plusDays(1));
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> sameDayOfWeek(final DateTime date) {
        return isDayOfWeek(date.getDayOfWeek());
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isDayOfWeek(final int dayOfWeek) {
        return new IsDayOfWeek<>(
            new FieldJodaDateTimeWrapper(dayOfWeek, DateTimeFieldType.dayOfWeek()),
            (d, z) -> d.withZone(z).get(DateTimeFieldType.dayOfWeek()),
            DateTimeZone.getDefault()
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isDayOfWeek(final int... daysOfWeek) {
        return new AnyOfZonedTemporals<>(
            IntStream.of(daysOfWeek).mapToObj(JodaDateTimeMatchers::isDayOfWeek),
            (d, z) -> "the date is on a " + DateTimeFieldType.dayOfWeek().getField(d.withZone(z).getChronology()).getName().toLowerCase(),
            DateTimeZone.getDefault()
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isMonday() {
        return isDayOfWeek(DateTimeConstants.MONDAY);
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isTuesday() {
        return isDayOfWeek(DateTimeConstants.TUESDAY);
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isWednesday() {
        return isDayOfWeek(DateTimeConstants.WEDNESDAY);
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isThursday() {
        return isDayOfWeek(DateTimeConstants.THURSDAY);
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isFriday() {
        return isDayOfWeek(DateTimeConstants.FRIDAY);
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isSaturday() {
        return isDayOfWeek(DateTimeConstants.SATURDAY);
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isSunday() {
        return isDayOfWeek(DateTimeConstants.SUNDAY);
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isWeekday() {
        return isDayOfWeek(DateTimeConstants.MONDAY, DateTimeConstants.TUESDAY, DateTimeConstants.WEDNESDAY, DateTimeConstants.THURSDAY, DateTimeConstants.FRIDAY);
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isWeekend() {
        return isDayOfWeek(DateTimeConstants.SATURDAY, DateTimeConstants.SUNDAY);
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isFirstDayOfMonth() {
        return new IsMinimum<>(DateTimeFieldType.dayOfMonth(),
            (d, z) -> d.withZone(z).get(DateTimeFieldType.dayOfMonth()),
            (d, z) -> DateTimeFieldType.dayOfMonth().getField(d.withZone(z).getChronology()).getMinimumValue(),
            new JodaDatePartFormatter(),
            () -> "the date is the first day of the month",
            DateTimeZone.getDefault());
    }

    /**
     * Creates a matcher that matches when the examined date is on the maximum value of the given date part in its
     * period
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isMaximumDayOfMonth(DateTimeFieldType.dayOfMonth()));
     * </pre>
     *
     * @param field the temporal field to check
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isMinimum(final DateTimeFieldType field) {
        return new IsMinimum<>(
            field,
            (d, z) -> d.withZone(z).get(field),
            (d, z) -> field.getField(d.withZone(z).getChronology()).getMinimumValue(),
            new JodaDatePartFormatter(),
            DateTimeZone.getDefault()
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isLastDayOfMonth() {
        return new IsMaximum<>(
            DateTimeFieldType.dayOfMonth(),
            (d, z) -> d.withZone(z).get(DateTimeFieldType.dayOfMonth()),
            (d, z) -> DateTimeFieldType.dayOfMonth().getField(d.withZone(z).getChronology()).getMaximumValue(),
            new JodaDatePartFormatter(),
            () -> "the date is the last day of the month",
            DateTimeZone.getDefault()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the maximum value of the given date part in its
     * period
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isMaximum(DateTimeFieldType.dayOfMonth()));
     * </pre>
     *
     * @param field the temporal field to check
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isMaximum(final DateTimeFieldType field) {
        return new IsMaximum<>(
            field,
            (d, z) -> d.withZone(z).get(field),
            (d, z) -> field.getField(d.withZone(z).getChronology()).getMaximumValue(),
            new JodaDatePartFormatter(),
            DateTimeZone.getDefault()
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isMonth(final int month) {
        return new IsMonth<>(
            new FieldJodaDateTimeWrapper(month, DateTimeFieldType.monthOfYear()),
            (d, z) -> d.withZone(z).get(DateTimeFieldType.monthOfYear()),
            DateTimeZone.getDefault()
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isJanuary() {
        return isMonth(DateTimeConstants.JANUARY);
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isFebruary() {
        return isMonth(DateTimeConstants.FEBRUARY);
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isMarch() {
        return isMonth(DateTimeConstants.MARCH);
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isApril() {
        return isMonth(DateTimeConstants.APRIL);
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isMay() {
        return isMonth(DateTimeConstants.MAY);
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isJune() {
        return isMonth(DateTimeConstants.JUNE);
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isJuly() {
        return isMonth(DateTimeConstants.JULY);
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isAugust() {
        return isMonth(DateTimeConstants.AUGUST);
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isSeptember() {
        return isMonth(DateTimeConstants.SEPTEMBER);
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isOctober() {
        return isMonth(DateTimeConstants.OCTOBER);
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isNovember() {
        return isMonth(DateTimeConstants.NOVEMBER);
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isDecember() {
        return isMonth(DateTimeConstants.DECEMBER);
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isLeapYear() {
        return new IsLeapYear<>(
            (d, z) -> d.withZone(z).year().isLeap(),
            new JodaDateTimeFormatter(),
            DateTimeZone.getDefault()
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isHour(final int hour) {
        return new IsHour<>(
            new FieldJodaDateTimeWrapper(hour, DateTimeFieldType.hourOfDay()),
            (d, z) -> d.withZone(z).get(DateTimeFieldType.hourOfDay()),
            DateTimeZone.getDefault()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same hour as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameHourOfDay(DateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> sameHourOfDay(final DateTime date) {
        return new IsHour<>(
            new FieldJodaDateTimeWrapper(date, DateTimeFieldType.hourOfDay()),
            (d, z) -> d.withZone(z).get(DateTimeFieldType.hourOfDay()),
            DateTimeZone.getDefault()
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isMinute(final int minute) {
        return new IsMinute<>(
            new FieldJodaDateTimeWrapper(minute, DateTimeFieldType.minuteOfHour()),
            (d, z) -> d.withZone(z).get(DateTimeFieldType.minuteOfHour()),
            DateTimeZone.getDefault()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same minute as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameMinuteOfHour(DateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> sameMinuteOfHour(final DateTime date) {
        return new IsMinute<>(
            new FieldJodaDateTimeWrapper(date, DateTimeFieldType.minuteOfHour()),
            (d, z) -> d.withZone(z).get(DateTimeFieldType.minuteOfHour()),
            DateTimeZone.getDefault()
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
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isSecond(final int second) {
        return new IsSecond<>(
            new FieldJodaDateTimeWrapper(second, DateTimeFieldType.secondOfMinute()),
            (d, z) -> d.withZone(z).get(DateTimeFieldType.secondOfMinute()),
            DateTimeZone.getDefault()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same second as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameSecondOfMinute(DateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> sameSecondOfMinute(final DateTime date) {
        return new IsSecond<>(
            new FieldJodaDateTimeWrapper(date, DateTimeFieldType.secondOfMinute()),
            (d, z) -> d.withZone(z).get(DateTimeFieldType.secondOfMinute()),
            DateTimeZone.getDefault()
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
     * @param millis the millisecond of the second (0-999)
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> isMillisecond(final int millis) {
        return new IsMillisecond<>(
            new FieldJodaDateTimeWrapper(millis, DateTimeFieldType.millisOfSecond()),
            (d, z) -> d.withZone(z).get(DateTimeFieldType.millisOfSecond()),
            DateTimeZone.getDefault()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same second as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameSecondOfMinute(DateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<DateTime, DateTimeZone> sameMillisecondOfSecond(final DateTime date) {
        return new IsMillisecond<>(
            new FieldJodaDateTimeWrapper(date, DateTimeFieldType.millisOfSecond()),
            (d, z) -> d.withZone(z).get(DateTimeFieldType.millisOfSecond()),
            DateTimeZone.getDefault()
        );
    }
}
