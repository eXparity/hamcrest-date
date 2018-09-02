package org.exparity.hamcrest.date;

import static java.time.DayOfWeek.*;
import static java.time.Month.*;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

import org.exparity.hamcrest.date.core.*;
import org.exparity.hamcrest.date.core.format.DatePartFormatter;
import org.exparity.hamcrest.date.core.format.LocalDateTimeFormatter;
import org.exparity.hamcrest.date.core.wrapper.FieldLocalDateTimeWrapper;
import org.exparity.hamcrest.date.core.wrapper.LocalDateTimeWrapper;
import org.hamcrest.Factory;

/**
 * Static factory for creating {@link org.hamcrest.Matcher} instances for comparing {@link LocalDateTime} instances
 *
 * @author Stewart Bissett
 */
public abstract class LocalDateTimeMatchers {

    /**
     * Creates a matcher that matches when the examined date is after the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, LocalDateTimeMatchers.after(LocalDateTime.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<LocalDateTime> after(final LocalDateTime date) {
        return new IsAfter<>(new LocalDateTimeWrapper(date), new LocalDateTimeFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is after the end of the reference year
     * <p/>
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
    public static DateMatcher<LocalDateTime> after(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second) {
        return new IsAfter<>(new LocalDateTimeWrapper(year, month, dayOfMonth, hour, minute, second),
            new LocalDateTimeFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is before the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, LocalDateTimeMatchers.before(LocalDateTime.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<LocalDateTime> before(final LocalDateTime date) {
        return new IsBefore<>(new LocalDateTimeWrapper(date), new LocalDateTimeFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is before the end of the reference year
     * <p/>
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
    public static DateMatcher<LocalDateTime> before(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second) {
        return new IsBefore<>(new LocalDateTimeWrapper(year, month, dayOfMonth, hour, minute, second),
            new LocalDateTimeFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameDay(LocalDateTime.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<LocalDateTime> sameDay(final LocalDateTime date) {
        return new IsSameDay<>(
            new LocalDateTimeWrapper(date),
            new LocalDateTimeFormatter()
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
     */
    public static DateMatcher<LocalDateTime> isDay(final int year, final Month month, final int dayOfMonth) {
        return new IsSameDay<>(
            new LocalDateTimeWrapper(year, month, dayOfMonth),
            new LocalDateTimeFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is at the same instant as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameInstant(LocalDateTime.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<LocalDateTime> sameInstant(final LocalDateTime date) {
        return new IsSame<>(new LocalDateTimeWrapper(date), new LocalDateTimeFormatter());
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
     */
    public static DateMatcher<LocalDateTime> isInstant(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int nanos) {
        return new IsSame<>(new LocalDateTimeWrapper(year, month, dayOfMonth, hour, minute, second, nanos),
            new LocalDateTimeFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is at the same instant or before the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isSameOrBefore(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<LocalDateTime> sameOrBefore(final LocalDateTime date) {
        return new IsSameOrBefore<>(new LocalDateTimeWrapper(date), new LocalDateTimeFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day or before the start of the reference
     * date
     * <p/>
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
    @Factory
    public static DateMatcher<LocalDateTime> sameOrBefore(final int year,
            final Month month,
            final int day,
            final int hour,
            final int minute,
            final int second) {
        return new IsSameOrBefore<>(new LocalDateTimeWrapper(year, month, day, hour, minute, second),
            new LocalDateTimeFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is at the same instant or after the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isSameOrAfter(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<LocalDateTime> sameOrAfter(final LocalDateTime date) {
        return new IsSameOrAfter<>(new LocalDateTimeWrapper(date), new LocalDateTimeFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day or after the start of the reference date
     * <p/>
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
    public static DateMatcher<LocalDateTime> sameOrAfter(final int year,
            final Month month,
            final int day,
            final int hour,
            final int minute,
            final int second) {
        return sameOrAfter(LocalDateTime.of(year, month, day, hour, minute, second));
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
    public static DateMatcher<LocalDateTime> sameMonthOfYear(final LocalDateTime date) {
        return new IsMonth<>(
            new FieldLocalDateTimeWrapper(date, ChronoField.MONTH_OF_YEAR),
            (d, z) -> ZonedDateTime.of(d, z).getMonthValue()
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
    public static DateMatcher<LocalDateTime> sameDayOfMonth(final LocalDateTime date) {
        return new IsDayOfMonth<>(
            new FieldLocalDateTimeWrapper(date, ChronoField.DAY_OF_MONTH),
            (d, z) -> ZonedDateTime.of(d, z).getDayOfMonth()
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
    public static DateMatcher<LocalDateTime> isDayOfMonth(final int dayOfMonth) {
        return new IsDayOfMonth<>(
            new FieldLocalDateTimeWrapper(dayOfMonth, ChronoField.DAY_OF_MONTH),
            (d, z) -> ZonedDateTime.of(d, z).getDayOfMonth()
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
    public static DateMatcher<LocalDateTime> sameYear(final LocalDateTime date) {
        return new IsYear<>(
            new FieldLocalDateTimeWrapper(date, ChronoField.YEAR),
            (d, z) -> ZonedDateTime.of(d ,z).getYear()
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
    public static DateMatcher<LocalDateTime> isYear(final int year) {
        return new IsYear<>(
            new FieldLocalDateTimeWrapper(year, ChronoField.YEAR),
            (d, z) -> ZonedDateTime.of(d ,z).getYear()
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
    public static DateMatcher<LocalDateTime> within(final long period, final ChronoUnit unit, final LocalDateTime date) {
        return new IsWithin<>(period, unit, new LocalDateTimeWrapper(date), new LocalDateTimeFormatter());
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
     */
    public static DateMatcher<LocalDateTime> within(final long period,
            final ChronoUnit unit,
            final int year,
            final Month month,
            final int dayofMonth,
            final int hour,
            final int minute,
            final int second,
            final int nanos) {
        return new IsWithin<>(period, unit,
            new LocalDateTimeWrapper(year, month, dayofMonth, hour, minute, second, nanos),
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
    public static DateMatcher<LocalDateTime> isYesterday() {
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
    public static DateMatcher<LocalDateTime> isToday() {
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
    public static DateMatcher<LocalDateTime> isTomorrow() {
        return sameDay(LocalDateTime.now(ZoneId.systemDefault()).plusDays(1));
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
    public static DateMatcher<LocalDateTime> sameDayOfWeek(final LocalDateTime date) {
        return isDayOfWeek(DayOfWeek.from(date));
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
    public static DateMatcher<LocalDateTime> isDayOfWeek(final DayOfWeek dayOfWeek) {
        return new IsDayOfWeek<>(
            new FieldLocalDateTimeWrapper(dayOfWeek.getValue(), ChronoField.DAY_OF_WEEK),
            (d, z) -> ZonedDateTime.of(d, z).getDayOfWeek().getValue()
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
    public static DateMatcher<LocalDateTime> isDayOfWeek(final DayOfWeek... daysOfWeek) {
        return new AnyOf<>(
            Stream.of(daysOfWeek).map(LocalDateTimeMatchers::isDayOfWeek),
            (d, z) -> "the date is on a " + d.atZone(z).getDayOfWeek().name().toLowerCase()
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
    public static DateMatcher<LocalDateTime> isMonday() {
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
    public static DateMatcher<LocalDateTime> isTuesday() {
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
    public static DateMatcher<LocalDateTime> isWednesday() {
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
    public static DateMatcher<LocalDateTime> isThursday() {
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
    public static DateMatcher<LocalDateTime> isFriday() {
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
    public static DateMatcher<LocalDateTime> isSaturday() {
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
    public static DateMatcher<LocalDateTime> isSunday() {
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
    public static DateMatcher<LocalDateTime> isWeekday() {
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
    public static DateMatcher<LocalDateTime> isWeekend() {
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
    public static DateMatcher<LocalDateTime> isFirstDayOfMonth() {
        return new IsMinimum<>(
            ChronoField.DAY_OF_MONTH,
            (d, z) -> d.atZone(z).get(ChronoField.DAY_OF_MONTH),
            (d, z) -> ChronoField.DAY_OF_MONTH.rangeRefinedBy(d.atZone(z)),
            new DatePartFormatter(),
            () -> "the date is the first day of the month");
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
    public static DateMatcher<LocalDateTime> isMinimum(final ChronoField field) {
        return new IsMinimum<>(
            field,
            (d, z) -> d.atZone(z).get(field),
            (d, z) -> field.rangeRefinedBy(d.atZone(z)),
            new DatePartFormatter()
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
    public static DateMatcher<LocalDateTime> isLastDayOfMonth() {
        return new IsMaximum<>(
            ChronoField.DAY_OF_MONTH,
            (d, z) -> d.atZone(z).get(ChronoField.DAY_OF_MONTH),
            (d, z) -> ChronoField.DAY_OF_MONTH.rangeRefinedBy(d.atZone(z)),
            new DatePartFormatter(),
            () -> "the date is the last day of the month");
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
    public static DateMatcher<LocalDateTime> isMaximum(final ChronoField field) {
        return new IsMaximum<>(
            field,
            (d, z) -> d.atZone(z).get(field),
            (d, z) -> field.rangeRefinedBy(d.atZone(z)),
            new DatePartFormatter()
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
    public static DateMatcher<LocalDateTime> isMonth(final Month month) {
        return new IsMonth<>(
            new FieldLocalDateTimeWrapper(month.getValue(), ChronoField.MONTH_OF_YEAR),
            (d, z) -> ZonedDateTime.of(d, z).getMonthValue()
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
    public static DateMatcher<LocalDateTime> isJanuary() {
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
    public static DateMatcher<LocalDateTime> isFebruary() {
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
    public static DateMatcher<LocalDateTime> isMarch() {
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
    public static DateMatcher<LocalDateTime> isApril() {
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
    public static DateMatcher<LocalDateTime> isMay() {
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
    public static DateMatcher<LocalDateTime> isJune() {
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
    public static DateMatcher<LocalDateTime> isJuly() {
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
    public static DateMatcher<LocalDateTime> isAugust() {
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
    public static DateMatcher<LocalDateTime> isSeptember() {
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
    public static DateMatcher<LocalDateTime> isOctober() {
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
    public static DateMatcher<LocalDateTime> isNovember() {
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
    public static DateMatcher<LocalDateTime> isDecember() {
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
    public static DateMatcher<LocalDateTime> isLeapYear() {
        return new IsLeapYear<>((d, z) -> d, new LocalDateTimeFormatter());
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
    public static DateMatcher<LocalDateTime> isHour(final int hour) {
        return new IsHour<>(
            new FieldLocalDateTimeWrapper(hour, ChronoField.HOUR_OF_DAY),
            (d, z) -> ZonedDateTime.of(d, z).getHour()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same hour as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameHourOfDay(LocalDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<LocalDateTime> sameHourOfDay(final LocalDateTime date) {
        return new IsHour<>(
            new FieldLocalDateTimeWrapper(date, ChronoField.HOUR_OF_DAY),
            (d, z) -> ZonedDateTime.of(d, z).getHour()
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
    public static DateMatcher<LocalDateTime> isMinute(final int minute) {
        return new IsMinute<>(
            new FieldLocalDateTimeWrapper(minute, ChronoField.MINUTE_OF_HOUR),
            (d, z) -> ZonedDateTime.of(d, z).getMinute()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same minute as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameMinuteOfHour(LocalDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<LocalDateTime> sameMinuteOfHour(final LocalDateTime date) {
        return new IsMinute<>(
            new FieldLocalDateTimeWrapper(date, ChronoField.MINUTE_OF_HOUR),
            (d, z) -> ZonedDateTime.of(d, z).getMinute()
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
    public static DateMatcher<LocalDateTime> isSecond(final int second) {
        return new IsSecond<>(
            new FieldLocalDateTimeWrapper(second, ChronoField.SECOND_OF_MINUTE),
            (d, z) -> ZonedDateTime.of(d, z).getSecond()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same second as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameSecondOfMinute(LocalDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<LocalDateTime> sameSecondOfMinute(final LocalDateTime date) {
        return new IsSecond<>(
            new FieldLocalDateTimeWrapper(date, ChronoField.SECOND_OF_MINUTE),
            (d, z) -> ZonedDateTime.of(d, z).getSecond()
        );
    }
}
