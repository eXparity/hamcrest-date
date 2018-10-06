package org.exparity.hamcrest.date;

import static java.time.DayOfWeek.*;
import static java.time.Month.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

import org.exparity.hamcrest.date.core.*;
import org.exparity.hamcrest.date.core.format.DatePartFormatter;
import org.exparity.hamcrest.date.core.format.LocalDateFormatter;
import org.exparity.hamcrest.date.core.wrapper.FieldLocalDateWrapper;
import org.exparity.hamcrest.date.core.wrapper.LocalDateWrapper;
import org.hamcrest.Factory;

/**
 * Static factory for creating {@link org.hamcrest.Matcher} instances for comparing {@link LocalDate} instances
 *
 * @author Stewart Bissett
 */
public abstract class LocalDateMatchers {

    /**
     * Creates a matcher that matches when the examined date is after the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, LocalDateMatchers.after(LocalDate.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<LocalDate> after(final LocalDate date) {
        return new IsAfter<>(new LocalDateWrapper(date), new LocalDateFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is after the end of the reference year
     * <p/>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, LocalDateMatchers.after(2012, Month.MAY, 12));
     * </pre>
     *
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     */
    public static DateMatcher<LocalDate> after(final int year, final Month month, final int dayOfMonth) {
        return after(LocalDate.of(year, month, dayOfMonth));
    }

    /**
     * Creates a matcher that matches when the examined date is before the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, LocalDateMatchers.before(LocalDate.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<LocalDate> before(final LocalDate date) {
        return new IsBefore<>(new LocalDateWrapper(date), new LocalDateFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is before the end of the reference year
     * <p/>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myDate, LocalDateMatchers.before(2012, Month.MAY, 12));
     * </pre>
     *
     * @param year the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     */
    public static DateMatcher<LocalDate> before(final int year, final Month month, final int dayOfMonth) {
        return before(LocalDate.of(year, month, dayOfMonth));
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameDay(LocalDate.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<LocalDate> sameDay(final LocalDate date) {
        return new IsSameDay<>(new LocalDateWrapper(date), new LocalDateFormatter());
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isDay(2012, Month.JAN, 1))
     * </pre>
     *
     * @param dayOfMonth the reference day of the month against which the examined date is checked
     * @param month the reference month against which the examined date is checked
     * @param year the reference year against which the examined date is checked
     */
    public static DateMatcher<LocalDate> isDay(final int year, final Month month, final int dayOfMonth) {
        return sameDay(LocalDate.of(year, month, dayOfMonth));
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
    public static DateMatcher<LocalDate> sameOrBefore(final LocalDate date) {
        return new IsSameOrBefore<>(new LocalDateWrapper(date), new LocalDateFormatter());
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
     */
    @Factory
    public static DateMatcher<LocalDate> sameOrBefore(final int year, final Month month, final int day) {
        return sameOrBefore(LocalDate.of(year, month, day));
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
    public static DateMatcher<LocalDate> sameOrAfter(final LocalDate date) {
        return new IsSameOrAfter<>(new LocalDateWrapper(date), new LocalDateFormatter());
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
     */
    public static DateMatcher<LocalDate> sameOrAfter(final int year, final Month month, final int day) {
        return sameOrAfter(LocalDate.of(year, month, day));
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
    public static DateMatcher<LocalDate> sameMonthOfYear(final LocalDate date) {
        return isMonth(date.getMonth());
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
    public static DateMatcher<LocalDate> sameDayOfMonth(final LocalDate date) {
        return new IsDayOfMonth<>(
            new FieldLocalDateWrapper(date, ChronoField.DAY_OF_MONTH),
            (d, z) -> d.atStartOfDay(z).getDayOfMonth()
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
    public static DateMatcher<LocalDate> isDayOfMonth(final int dayOfMonth) {
        return new IsDayOfMonth<>(
            new FieldLocalDateWrapper(dayOfMonth, ChronoField.DAY_OF_MONTH),
            (d, z) -> d.atStartOfDay(z).getDayOfMonth()
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
    public static DateMatcher<LocalDate> sameYear(final LocalDate date) {
        return new IsYear<>(
            new FieldLocalDateWrapper(date, ChronoField.YEAR),
            (d, z) -> d.atStartOfDay(z).getYear()
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
    public static DateMatcher<LocalDate> isYear(final int year) {
        return new IsYear<>(
            new FieldLocalDateWrapper(year, ChronoField.YEAR),
            (d, z) -> d.atStartOfDay(z).getYear()
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
    public static DateMatcher<LocalDate> within(final long period, final ChronoUnit unit, final LocalDate date) {
        return new IsWithin<>(period, unit, new LocalDateWrapper(date), new LocalDateFormatter());
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
     */
    public static DateMatcher<LocalDate> within(final long period,
            final ChronoUnit unit,
            final int year,
            final Month month,
            final int dayofMonth) {
        return within(period, unit, LocalDate.of(year, month, dayofMonth));
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
    public static DateMatcher<LocalDate> isYesterday() {
        return sameDay(LocalDate.now().plusDays(-1));
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
    public static DateMatcher<LocalDate> isToday() {
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
    public static DateMatcher<LocalDate> isTomorrow() {
        return sameDay(LocalDate.now().plusDays(1));
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the week as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameDayOfWeek(LocalDate.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static DateMatcher<LocalDate> sameDayOfWeek(final LocalDate date) {
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
    public static DateMatcher<LocalDate> isDayOfWeek(final DayOfWeek dayOfWeek) {
        return new IsDayOfWeek<>(
            new FieldLocalDateWrapper(dayOfWeek.getValue(), ChronoField.DAY_OF_WEEK),
            (d, z) -> d.atStartOfDay(z).getDayOfWeek().getValue()
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
    public static DateMatcher<LocalDate> isDayOfWeek(final DayOfWeek... daysOfWeek) {
        return new AnyOf<>(
            Stream.of(daysOfWeek).map(LocalDateMatchers::isDayOfWeek),
            (d, z) -> "the date is on a " + d.atStartOfDay(z).getDayOfWeek().name().toLowerCase()
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
    public static DateMatcher<LocalDate> isMonday() {
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
    public static DateMatcher<LocalDate> isTuesday() {
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
    public static DateMatcher<LocalDate> isWednesday() {
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
    public static DateMatcher<LocalDate> isThursday() {
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
    public static DateMatcher<LocalDate> isFriday() {
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
    public static DateMatcher<LocalDate> isSaturday() {
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
    public static DateMatcher<LocalDate> isSunday() {
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
    public static DateMatcher<LocalDate> isWeekday() {
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
    public static DateMatcher<LocalDate> isWeekend() {
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
    public static DateMatcher<LocalDate> isFirstDayOfMonth() {
        return new IsMinimum<>(
            ChronoField.DAY_OF_MONTH,
            (d, z) -> d.atStartOfDay(z).get(ChronoField.DAY_OF_MONTH),
            (d, z) -> ChronoField.DAY_OF_MONTH.rangeRefinedBy(d.atStartOfDay(z)),
            new DatePartFormatter(),
            () -> "the date is the first day of the month"
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
    public static DateMatcher<LocalDate> isMinimum(final ChronoField field) {
        return new IsMinimum<>(
            field,
            (d, z) -> d.atStartOfDay(z).get(field),
            (d, z) -> field.rangeRefinedBy(d.atStartOfDay(z)),
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
    public static DateMatcher<LocalDate> isLastDayOfMonth() {
        return new IsMaximum<>(
            ChronoField.DAY_OF_MONTH,
            (d, z) -> d.atStartOfDay(z).get(ChronoField.DAY_OF_MONTH),
            (d, z) -> ChronoField.DAY_OF_MONTH.rangeRefinedBy(d.atStartOfDay(z)),
            new DatePartFormatter(),
            () -> "the date is the last day of the month"
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
    public static DateMatcher<LocalDate> isMaximum(final ChronoField field) {
        return new IsMaximum<>(
            field,
            (d, z) -> d.atStartOfDay(z).get(field),
            (d, z) -> field.rangeRefinedBy(d.atStartOfDay(z)),
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
    public static DateMatcher<LocalDate> isMonth(final Month month) {
        return new IsMonth<>(
            new FieldLocalDateWrapper(month.getValue(), ChronoField.MONTH_OF_YEAR),
            (d, z) -> d.atStartOfDay(z).getMonthValue()
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
    public static DateMatcher<LocalDate> isJanuary() {
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
    public static DateMatcher<LocalDate> isFebruary() {
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
    public static DateMatcher<LocalDate> isMarch() {
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
    public static DateMatcher<LocalDate> isApril() {
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
    public static DateMatcher<LocalDate> isMay() {
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
    public static DateMatcher<LocalDate> isJune() {
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
    public static DateMatcher<LocalDate> isJuly() {
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
    public static DateMatcher<LocalDate> isAugust() {
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
    public static DateMatcher<LocalDate> isSeptember() {
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
    public static DateMatcher<LocalDate> isOctober() {
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
    public static DateMatcher<LocalDate> isNovember() {
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
    public static DateMatcher<LocalDate> isDecember() {
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
    public static DateMatcher<LocalDate> isLeapYear() {
        return new IsLeapYear<>((d, z) -> d, new LocalDateFormatter());
    }
}
