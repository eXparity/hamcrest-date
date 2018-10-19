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
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

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
import org.exparity.hamcrest.date.core.format.DateFormatter;
import org.exparity.hamcrest.date.core.format.DatePartFormatter;
import org.exparity.hamcrest.date.core.wrapper.DateWrapper;
import org.exparity.hamcrest.date.core.wrapper.FieldDateWrapper;

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
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> after(final Date date) {
        return new IsAfter<>(new DateWrapper(date), new DateFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is after the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, after(Moments.today()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     * @deprecated Use {@link #after(LocalDate)}
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> after(final DayMonthYear date) {
        return after(date.toLocalDate());
    }

    /**
     * Creates a matcher that matches when the examined date is after the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, after(Moments.today()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> after(final LocalDate date) {
        return new IsAfter<>(new DateWrapper(date), new DateFormatter());
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
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param day the day of the month against which the examined date is checked
     * @deprecated Use {@link #after(int, Month, int)}
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> after(final int year, final Months month, final int day) {
        return new IsAfter<>(new DateWrapper(year, month.month(), day), new DateFormatter());
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
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param day the day of the month against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> after(final int year, final Month month, final int day) {
        return new IsAfter<>(new DateWrapper(year, month, day), new DateFormatter());
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
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour the hour of the day against which the examined date is checked
     * @param minute the minute of the hour against which the examined date is checked
     * @param second the second of the minute against which the examined date is checked
     * @deprecated Use {@link #after(int, Month, int, int, int, int)}
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> after(final int year,
            final Months month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second) {
        return after(year, month.month(), dayOfMonth, hour, minute, second);
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
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour the hour of the day against which the examined date is checked
     * @param minute the minute of the hour against which the examined date is checked
     * @param second the second of the minute against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> after(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second) {
        return new IsAfter<>(
            new DateWrapper(year, month, dayOfMonth, hour, minute, second),
            new DateFormatter()
        );
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
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> before(final Date date) {
        return new IsBefore<>(
            new DateWrapper(date),
            new DateFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is before the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, before(LocalDate.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> before(final LocalDate date) {
        return new IsBefore<>(new DateWrapper(date), new DateFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is before the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, before(Moments.today()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     * @deprecated Use {@link #before(LocalDate)}
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> before(final DayMonthYear date) {
        return before(date.toLocalDate());
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
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @deprecated Use {@link #before(int, Month, int)}
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> before(final int year, final Months month, final int dayOfMonth) {
        return new IsBefore<>(new DateWrapper(year, month.month(), dayOfMonth), new DateFormatter());
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
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> before(final int year, final Month month, final int dayOfMonth) {
        return new IsBefore<>(new DateWrapper(year, month, dayOfMonth), new DateFormatter());
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
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour the hour of the day against which the examined date is checked
     * @param minute the minute of the hour against which the examined date is checked
     * @param second the second of the minute against which the examined date is checked
     * @deprecated Use {@link #before(int, Month, int, int, int, int)}
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> before(final int year,
            final Months month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second) {
        return before(year, month.month(), dayOfMonth, hour, minute, second);
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
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour the hour of the day against which the examined date is checked
     * @param minute the minute of the hour against which the examined date is checked
     * @param second the second of the minute against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> before(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second) {
        return new IsBefore<>(new DateWrapper(year, month, dayOfMonth, hour, minute, second), new DateFormatter());
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
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> sameDayOfWeek(final Date date) {
        return isDayOfWeek(DayOfWeek.from(date.toInstant().atZone(ZoneId.systemDefault())));
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the week as the supplied day
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isDayOfWeek(Weekdays.MONDAY))
     * </pre>
     *
     * @param dayOfWeek the reference weekday against which the examined date is checked
     * @deprecated Use {@link #isDayOfWeek(DayOfWeek...)}
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> isDayOfWeek(final Weekdays dayOfWeek) {
        return isDayOfWeek(dayOfWeek.getAsDayOfWeek());
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the week as the supplied day
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isDayOfWeek(DayOfWeek.MONDAY))
     * </pre>
     *
     * @param dayOfWeek the reference weekday against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> isDayOfWeek(final DayOfWeek dayOfWeek) {
        return new IsDayOfWeek<>(
            new FieldDateWrapper(dayOfWeek.getValue(), ChronoField.DAY_OF_WEEK),
            (d, z) -> d.toInstant().atZone(z).get(ChronoField.DAY_OF_WEEK),
            ZoneId.systemDefault()
      );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the week as any of the supplied days
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isDayOfWeek(DayOfWeek.MONDAY, DayOfWeek.TUESDAY))
     * </pre>
     *
     * @param daysOfWeek the reference weekdays against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> isDayOfWeek(final DayOfWeek... daysOfWeek) {
        return new AnyOfZonedTemporals<>(
            Stream.of(daysOfWeek).map(DateMatchers::isDayOfWeek),
            (d, z) -> "the date is on a " + d.toInstant().atZone(z).getDayOfWeek().name().toLowerCase(),
            ZoneId.systemDefault()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the month as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameDayOfMonth(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> sameDayOfMonth(final Date date) {
        return new IsDayOfMonth<>(
            new FieldDateWrapper(date, ChronoField.DAY_OF_MONTH),
            (d, z) -> d.toInstant().atZone(z).get(ChronoField.DAY_OF_MONTH),
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
    public static ZonedTemporalMatcher<Date, ZoneId> isDayOfMonth(final int dayOfMonth) {
        return new IsDayOfMonth<>(
            new FieldDateWrapper(dayOfMonth, ChronoField.DAY_OF_MONTH),
            (d, z) -> d.toInstant().atZone(z).get(ChronoField.DAY_OF_MONTH),
            ZoneId.systemDefault()
        );
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
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> sameDay(final Date date) {
        return new IsSameDay<>(new DateWrapper(date, ChronoUnit.DAYS), new DateFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameDay(Moments.today()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     * @deprecated Use {@link #sameDay(LocalDate)}
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> sameDay(final DayMonthYear date) {
        return sameDay(date.toLocalDate());
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameDay(Moments.today()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> sameDay(final LocalDate date) {
        return new IsSameDay<>(new DateWrapper(date), new DateFormatter());
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
     * @param day the reference day of the month against which the examined date is checked
     * @param month the reference month against which the examined date is checked
     * @param year the reference year against which the examined date is checked
     * @deprecated Use {@link #isDay(int, Month, int)}
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> sameDay(final int year, final Months month, final int day) {
        return isDay(year, month.month(), day);
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
     * @param dayOfMonth the reference day of the month against which the examined date is checked
     * @param month the reference month against which the examined date is checked
     * @param year the reference year against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> isDay(final int year, final Month month, final int dayOfMonth) {
        return sameDay(LocalDate.of(year, month, dayOfMonth));
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
     * @param date the reference date against which the examined date is checked
     * @deprecated Use {@link #sameHourOfDay(Date)} instead
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> sameHour(final Date date) {
        return sameHourOfDay(date);
    }

    /**
     * Creates a matcher that matches when the examined date is on the same hour as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameHourOfDay(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> sameHourOfDay(final Date date) {
        return new IsHour<>(
            new FieldDateWrapper(date, ChronoField.HOUR_OF_DAY),
            (d, z) -> d.toInstant().atZone(z).get(ChronoField.HOUR_OF_DAY),
            ZoneId.systemDefault()
        );
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
     * @param hour the reference hour against which the examined date is checked
     * @deprecated Use {@link #isHour(int)} instead
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> sameHour(final int hour) {
        return isHour(hour);
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
     * @param hour the reference hour against which the examined date is checked
     */

    public static ZonedTemporalMatcher<Date, ZoneId> isHour(final int hour) {
        return new IsHour<>(
            new FieldDateWrapper(hour, ChronoField.HOUR_OF_DAY),
            (d, z) -> d.toInstant().atZone(z).get(ChronoField.HOUR_OF_DAY),
            ZoneId.systemDefault()
        );
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
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> sameInstant(final Date date) {
        return new IsSame<>(new DateWrapper(date), new DateFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is on the same UTC instant as the reference UTC epoch time
     * supplied
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameInstant(1325415600000L))
     * </pre>
     *
     * @param timestamp the time as milliseconds since the Unix epoch time
     */
    public static ZonedTemporalMatcher<Date, ZoneId> sameInstant(final long timestamp) {
        return new IsSame<>(new DateWrapper(new Date(timestamp)), new DateFormatter());
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
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour the hour of the day against which the examined date is checked
     * @param minute the minute of the hour against which the examined date is checked
     * @param second the second of the minute against which the examined date is checked
     * @param milliseconds the milliseconds of the second against which the examined date is checked
     * @deprecated Use {@link #isInstant(int, Month, int, int, int, int, int)}
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> sameInstant(final int year,
            final Months month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int milliseconds) {
        return isInstant(year, month.month(), dayOfMonth, hour, minute, second, milliseconds);
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
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour the hour of the day against which the examined date is checked
     * @param minute the minute of the hour against which the examined date is checked
     * @param second the second of the minute against which the examined date is checked
     * @param milliseconds the milliseconds of the second against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> isInstant(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int milliseconds) {
        return new IsSame<>(
            new DateWrapper(year, month, dayOfMonth, hour, minute, second, milliseconds),
            new DateFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is at the same instant or before the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrBefore(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> sameOrBefore(final Date date) {
        return new IsSameOrBefore<>(new DateWrapper(date), new DateFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is at the same instant or before the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrBefore(LocalDate.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> sameOrBefore(final LocalDate date) {
        return new IsSameOrBefore<>(new DateWrapper(date), new DateFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is at the same date or before the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrBefore(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     * @deprecated Use {@link #sameOrBefore(LocalDate)}
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> sameOrBefore(final DayMonthYear date) {
        return sameOrBefore(date.toLocalDate());
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day or before the start of the reference
     * date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrBefore(2012, Months.MAY, 12));
     * </pre>
     *
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @deprecated Use {@link #sameOrBefore(int, Month, int)}
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> sameOrBefore(final int year, final Months month, final int dayOfMonth) {
        return sameOrBefore(year, month.month(), dayOfMonth);
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day or before the start of the reference
     * date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrBefore(2012, Months.MAY, 12));
     * </pre>
     *
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> sameOrBefore(final int year, final Month month, final int dayOfMonth) {
        return new IsSameOrBefore<>(new DateWrapper(LocalDate.of(year, month, dayOfMonth)), new DateFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is on the same second or before the start of the reference
     * date and time
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrBefore(2012, Months.MAY, 12, 23, 00, 01));
     * </pre>
     *
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour the hour of the day against which the examined date is checked
     * @param minute the minute of the hour against which the examined date is checked
     * @param second the second of the minute against which the examined date is checked
     * @deprecated See {@link #sameOrBefore(int, Month, int, int, int, int)}
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> sameOrBefore(final int year,
            final Months month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second) {
        return sameOrBefore(year, month.month(), dayOfMonth, hour, minute, second);
    }

    /**
     * Creates a matcher that matches when the examined date is on the same second or before the start of the reference
     * date and time
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrBefore(2012, Months.MAY, 12, 23, 00, 01));
     * </pre>
     *
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour the hour of the day against which the examined date is checked
     * @param minute the minute of the hour against which the examined date is checked
     * @param second the second of the minute against which the examined date is checked
     */

    public static ZonedTemporalMatcher<Date, ZoneId> sameOrBefore(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second) {
        return new IsSameOrBefore<>(
            new DateWrapper(year, month, dayOfMonth, hour, minute, second),
            new DateFormatter()
        );
    }

    /**
     * F Creates a matcher that matches when the examined date is at the same instant or after the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrAfter(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> sameOrAfter(final Date date) {
        return new IsSameOrAfter<>(new DateWrapper(date), new DateFormatter());
    }

    /**
     * F Creates a matcher that matches when the examined date is at the same instant or after the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrAfter(LocalDate.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> sameOrAfter(final LocalDate date) {
        return new IsSameOrAfter<>(new DateWrapper(date), new DateFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is at the same instant or after the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrAfter(Moments.today()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     * @deprecated Use {@link #sameOrAfter(LocalDate)}
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> sameOrAfter(final DayMonthYear date) {
        return sameOrAfter(date.toLocalDate());
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day or after the start of the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrAfter(2012, Months.MAY, 12));
     * </pre>
     *
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @deprecated Use {@link #sameOrAfter(int, Month, int)
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> sameOrAfter(final int year, final Months month, final int dayOfMonth) {
        return sameOrAfter(year, month.month(), dayOfMonth);
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day or after the start of the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrAfter(2012, Months.MAY, 12));
     * </pre>
     *
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> sameOrAfter(final int year, final Month month, final int dayOfMonth) {
        return new IsSameOrAfter<>(
            new DateWrapper(year, month, dayOfMonth),
            new DateFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same second or after the start of the reference
     * date and time
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrAfter(2012, Months.MAY, 12, 23, 00, 01));
     * </pre>
     *
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour the hour of the day against which the examined date is checked
     * @param minute the minute of the hour against which the examined date is checked
     * @param second the second of the minute against which the examined date is checked
     * @deprecated Use {@link #sameOrAfter(int, Month, int, int, int, int)}
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> sameOrAfter(final int year,
            final Months month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second) {
        return sameOrAfter(year, month.month(), dayOfMonth, hour, minute, second);
    }

    /**
     * Creates a matcher that matches when the examined date is on the same second or after the start of the reference
     * date and time
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrAfter(2012, Months.MAY, 12, 23, 00, 01));
     * </pre>
     *
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour the hour of the day against which the examined date is checked
     * @param minute the minute of the hour against which the examined date is checked
     * @param second the second of the minute against which the examined date is checked
     */

    public static ZonedTemporalMatcher<Date, ZoneId> sameOrAfter(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second) {
        return new IsSameOrAfter<>(
            new DateWrapper(year, month, dayOfMonth, hour, minute, second),
            new DateFormatter()
        );
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
     * @param date the reference date against which the examined date is checked
     * @deprecated Use {@link #sameMinuteOfHour(Date)} instead
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> sameMinute(final Date date) {
        return sameMinuteOfHour(date);
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
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> sameMinuteOfHour(final Date date) {
        return new IsMinute<>(
            new FieldDateWrapper(date, ChronoField.MINUTE_OF_HOUR),
            (d, z) -> d.toInstant().atZone(z).get(ChronoField.MINUTE_OF_HOUR),
            ZoneId.systemDefault()
        );
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
     * @param minute the reference minute against which the examined date is checked
     * @deprecated Use {@link #isMinute(int)} instead
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> sameMinute(final int minute) {
        return isMinute(minute);
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
     * @param minute the reference minute against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> isMinute(final int minute) {
        return new IsMinute<>(
            new FieldDateWrapper(minute, ChronoField.MINUTE_OF_HOUR),
            (d, z) -> d.toInstant().atZone(z).get(ChronoField.MINUTE_OF_HOUR),
            ZoneId.systemDefault()
        );
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
     * @param date the reference date against which the examined date is checked
     * @deprecated Use {@link #sameMonthOfYear(Date)} instead
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> sameMonth(final Date date) {
        return sameMonthOfYear(date);
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
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> sameMonthOfYear(final Date date) {
        return isMonth(Month.of(date.toInstant().atZone(ZoneId.systemDefault()).get(ChronoField.MONTH_OF_YEAR)));
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
     * @param month the reference month against which the examined date is checked
     * @deprecated Use {@link #sameMonthOfYear(Months)} instead
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> sameMonth(final Months month) {
        return sameMonthOfYear(month);
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
     * @param month the reference month against which the examined date is checked
     * @deprecated Use {@link #isMonth(Month)}
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> sameMonthOfYear(final Months month) {
        return isMonth(month.month());
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
     * @param date the reference date against which the examined date is checked
     * @deprecated Use {@link #sameSecondOfMinute(Date)} instead
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> sameSecond(final Date date) {
        return sameSecondOfMinute(date);
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
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> sameSecondOfMinute(final Date date) {
        return new IsSecond<>(
            new FieldDateWrapper(date, ChronoField.SECOND_OF_MINUTE),
            (d, z) -> d.toInstant().atZone(z).get(ChronoField.SECOND_OF_MINUTE),
            ZoneId.systemDefault()
        );
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
     * @param second the reference date against which the examined date is checked
     * @deprecated Use {@link #isSecond(int)} instead
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> sameSecond(final int second) {
        return isSecond(second);
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
     * @param second the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> isSecond(final int second) {
        return new IsSecond<>(
            new FieldDateWrapper(second, ChronoField.SECOND_OF_MINUTE),
            (d, z) -> d.toInstant().atZone(z).get(ChronoField.SECOND_OF_MINUTE),
            ZoneId.systemDefault()
        );
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
     * @param date the reference date against which the examined date is checked
     * @deprecated Use {@link #sameMillisecondOfSecond(Date)} instead
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> sameMillisecond(final Date date) {
        return sameMillisecondOfSecond(date);
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
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> sameMillisecondOfSecond(final Date date) {
        return new IsMillisecond<>(
            new FieldDateWrapper(date, ChronoField.MILLI_OF_SECOND),
            (d, z) -> d.toInstant().atZone(z).get(ChronoField.MILLI_OF_SECOND),
            ZoneId.systemDefault()
        );
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
     * @param millisecond the millisecond against which the examined date is checked
     * @deprecated Use {@link #isMillisecond(int)} instead
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> sameMillisecond(final int millisecond) {
        return isMillisecond(millisecond);
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
     * @param millisecond the millisecond against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> isMillisecond(final int millisecond) {
        return new IsMillisecond<>(
            new FieldDateWrapper(millisecond, ChronoField.MILLI_OF_SECOND),
            (d, z) -> d.toInstant().atZone(z).get(ChronoField.MILLI_OF_SECOND),
            ZoneId.systemDefault()
        );
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
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> sameYear(final Date date) {
        return new IsYear<>(
            new FieldDateWrapper(date, ChronoField.YEAR),
            (d, z) -> d.toInstant().atZone(z).get(ChronoField.YEAR),
            ZoneId.systemDefault()
        );
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
    public static ZonedTemporalMatcher<Date, ZoneId> isYear(final int year) {
        return new IsYear<>(
            new FieldDateWrapper(year, ChronoField.YEAR),
            (d, z) -> d.toInstant().atZone(z).get(ChronoField.YEAR),
            ZoneId.systemDefault()
        );
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
     * @param date the reference date against which the examined date is checked
     * @deprecated Use {@link #within(long, ChronoUnit, Date)}
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> within(final long period, final TimeUnit unit, final Date date) {
        return within(period, convertUnit(unit), date);
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
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> within(final long period, final ChronoUnit unit, final Date date) {
        return new IsWithin<>(period, unit, new DateWrapper(date), new DateFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is within a defined period the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, within(10, ChronoUnit.DAYS, LocalDate.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> within(final long period, final ChronoUnit unit, final LocalDate date) {
        return new IsWithin<>(period, unit, new DateWrapper(date), new DateFormatter());
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
     * @deprecated Use {@link #within(long, ChronoUnit, LocalDate)}
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> within(final long period, final TimeUnit unit, final DayMonthYear date) {
        return within(period, convertUnit(unit), date.toLocalDate());
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
     * @deprecated Use {@link #within(long, ChronoUnit, int, Month, int)}
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> within(final long period,
            final TimeUnit unit,
            final int year,
            final Months month,
            final int dayOfMonth) {
        return within(period, convertUnit(unit), year, month.month(), dayOfMonth);
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
     */
    public static ZonedTemporalMatcher<Date, ZoneId> within(final long period,
            final ChronoUnit unit,
            final int year,
            final Month month,
            final int dayOfMonth) {
        return within(period, unit, LocalDate.of(year, month, dayOfMonth));
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
     * @param period the timeunit interval the examined date should be with
     * @param unit the timeunit to define the length of the period
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour the hour of the day against which the examined date is checked
     * @param minute the minute of the hour against which the examined date is checked
     * @param second the second of the minute against which the examined date is checked
     * @param milliseconds the millisecond of the second against which the examined date is checked
     * @deprecated Use {@link #within(long, ChronoUnit, int, Month, int, int, int, int, int)}
     */
    @Deprecated
    public static ZonedTemporalMatcher<Date, ZoneId> within(final long period,
            final TimeUnit unit,
            final int year,
            final Months month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int milliseconds) {
        return within(period, convertUnit(unit), year, month.month(), dayOfMonth, hour, minute, second, milliseconds);
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
     * @param period the timeunit interval the examined date should be with
     * @param unit the timeunit to define the length of the period
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour the hour of the day against which the examined date is checked
     * @param minute the minute of the hour against which the examined date is checked
     * @param second the second of the minute against which the examined date is checked
     * @param milliseconds the millisecond of the second against which the examined date is checked
     */
    public static ZonedTemporalMatcher<Date, ZoneId> within(final long period,
            final ChronoUnit unit,
            final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int milliseconds) {
        return new IsWithin<>(period,
            unit,
            new DateWrapper(year, month, dayOfMonth, hour, minute, second, milliseconds),
            new DateFormatter());
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
    public static ZonedTemporalMatcher<Date, ZoneId> isYesterday() {
        return sameDay(LocalDate.now().minusDays(1));
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
    public static ZonedTemporalMatcher<Date, ZoneId> isToday() {
        return sameDay(LocalDate.now());
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
    public static ZonedTemporalMatcher<Date, ZoneId> isTomorrow() {
        return sameDay(LocalDate.now().plusDays(1));
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
    public static ZonedTemporalMatcher<Date, ZoneId> isMonday() {
        return isDayOfWeek(DayOfWeek.MONDAY);
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
    public static ZonedTemporalMatcher<Date, ZoneId> isTuesday() {
        return isDayOfWeek(DayOfWeek.TUESDAY);
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
    public static ZonedTemporalMatcher<Date, ZoneId> isWednesday() {
        return isDayOfWeek(DayOfWeek.WEDNESDAY);
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
    public static ZonedTemporalMatcher<Date, ZoneId> isThursday() {
        return isDayOfWeek(DayOfWeek.THURSDAY);
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
    public static ZonedTemporalMatcher<Date, ZoneId> isFriday() {
        return isDayOfWeek(DayOfWeek.FRIDAY);
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
    public static ZonedTemporalMatcher<Date, ZoneId> isSaturday() {
        return isDayOfWeek(DayOfWeek.SATURDAY);
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
    public static ZonedTemporalMatcher<Date, ZoneId> isSunday() {
        return isDayOfWeek(DayOfWeek.SUNDAY);
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
    public static ZonedTemporalMatcher<Date, ZoneId> isWeekday() {
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
    public static ZonedTemporalMatcher<Date, ZoneId> isWeekend() {
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
    public static ZonedTemporalMatcher<Date, ZoneId> isFirstDayOfMonth() {
        return new IsMinimum<>(
            ChronoField.DAY_OF_MONTH,
            (d, z) -> d.toInstant().atZone(z).get(ChronoField.DAY_OF_MONTH),
            (d, z) -> ChronoField.DAY_OF_MONTH.rangeRefinedBy(d.toInstant().atZone(z)).getMinimum(),
            new DatePartFormatter(),
            () -> "the date is the first day of the month",
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
     * assertThat(myDate, isMaximumDayOfMonth(ChronoField.DAY_OF_MONTH));
     * </pre>
     *
     * @param field the temporal field to check
     */
    public static ZonedTemporalMatcher<Date, ZoneId> isMinimum(final ChronoField field) {
        return new IsMinimum<>(
            field,
            (d, z) -> d.toInstant().atZone(z).get(field),
            (d, z) -> field.rangeRefinedBy(d.toInstant().atZone(z)).getMinimum(),
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
    public static ZonedTemporalMatcher<Date, ZoneId> isLastDayOfMonth() {
        return new IsMaximum<>(
            ChronoField.DAY_OF_MONTH,
            (d, z) -> d.toInstant().atZone(z).get(ChronoField.DAY_OF_MONTH),
            (d, z) -> ChronoField.DAY_OF_MONTH.rangeRefinedBy(d.toInstant().atZone(z)).getMaximum(),
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
    public static ZonedTemporalMatcher<Date, ZoneId> isMaximum(final ChronoField field) {
        return new IsMaximum<>(
            field,
            (d, z) -> d.toInstant().atZone(z).get(field),
            (d, z) -> field.rangeRefinedBy(d.toInstant().atZone(z)).getMaximum(),
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
    public static ZonedTemporalMatcher<Date, ZoneId> isMonth(final Month month) {
        return new IsMonth<>(
            new FieldDateWrapper(month.getValue(), ChronoField.MONTH_OF_YEAR),
            (d, z) -> d.toInstant().atZone(z).get(ChronoField.MONTH_OF_YEAR),
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
    public static ZonedTemporalMatcher<Date, ZoneId> isJanuary() {
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
    public static ZonedTemporalMatcher<Date, ZoneId> isFebruary() {
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
    public static ZonedTemporalMatcher<Date, ZoneId> isMarch() {
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
    public static ZonedTemporalMatcher<Date, ZoneId> isApril() {
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
    public static ZonedTemporalMatcher<Date, ZoneId> isMay() {
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
    public static ZonedTemporalMatcher<Date, ZoneId> isJune() {
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
    public static ZonedTemporalMatcher<Date, ZoneId> isJuly() {
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
    public static ZonedTemporalMatcher<Date, ZoneId> isAugust() {
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
    public static ZonedTemporalMatcher<Date, ZoneId> isSeptember() {
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
    public static ZonedTemporalMatcher<Date, ZoneId> isOctober() {
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
    public static ZonedTemporalMatcher<Date, ZoneId> isNovember() {
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
    public static ZonedTemporalMatcher<Date, ZoneId> isDecember() {
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
    public static ZonedTemporalMatcher<Date, ZoneId> isLeapYear() {
        return new IsLeapYear<>((d, z) -> d.toInstant().atZone(z).toLocalDate().isLeapYear(), new DateFormatter(), ZoneId.systemDefault());
    }

    private static ChronoUnit convertUnit(final TimeUnit unit) {
        switch (unit) {
        case DAYS:
            return ChronoUnit.DAYS;
        case HOURS:
            return ChronoUnit.HOURS;
        case MICROSECONDS:
            return ChronoUnit.MICROS;
        case MILLISECONDS:
            return ChronoUnit.MILLIS;
        case MINUTES:
            return ChronoUnit.MINUTES;
        case NANOSECONDS:
            return ChronoUnit.NANOS;
        case SECONDS:
            return ChronoUnit.SECONDS;
        default:
            throw new IllegalArgumentException("Unknown TimeUnit '" + unit + "'");
        }
    }


}
