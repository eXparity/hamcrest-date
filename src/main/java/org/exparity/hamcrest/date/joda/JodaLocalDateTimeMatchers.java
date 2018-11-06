package org.exparity.hamcrest.date.joda;

import java.util.stream.IntStream;

import org.exparity.hamcrest.date.core.AnyOfTemporals;
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
import org.exparity.hamcrest.date.joda.format.JodaDatePartFormatter;
import org.exparity.hamcrest.date.joda.format.JodaLocalDateTimeFormatter;
import org.exparity.hamcrest.date.joda.wrapper.FieldJodaLocalDateTimeWrapper;
import org.exparity.hamcrest.date.joda.wrapper.JodaLocalDateTimeWrapper;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalDateTime;

/**
 * Static factory for creating {@link org.hamcrest.Matcher} instances for comparing Joda {@link LocalDateTime} instances
 *
 * @author Thomas Naskali
 */
public abstract class JodaLocalDateTimeMatchers {

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
    public static Matcher<LocalDateTime> after(final LocalDateTime date) {
        return new IsAfter<>(new JodaLocalDateTimeWrapper(date), new JodaLocalDateTimeFormatter());
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
    public static Matcher<LocalDateTime> after(final int year,
            final int month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second) {
        return new IsAfter<>(
          	new JodaLocalDateTimeWrapper(year, month, dayOfMonth, hour, minute, second),
            new JodaLocalDateTimeFormatter());
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
    public static Matcher<LocalDateTime> before(final LocalDateTime date) {
        return new IsBefore<>(new JodaLocalDateTimeWrapper(date), new JodaLocalDateTimeFormatter());
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
    public static Matcher<LocalDateTime> before(final int year,
            final int month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second) {
        return new IsBefore<>(
            new JodaLocalDateTimeWrapper(year, month, dayOfMonth, hour, minute, second),
            new JodaLocalDateTimeFormatter()
        );
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
    public static Matcher<LocalDateTime> sameDay(final LocalDateTime date) {
        return new IsSameDay<>(
            new JodaLocalDateTimeWrapper(date, DateTimeFieldType.dayOfMonth()),
            new JodaLocalDateTimeFormatter()
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
    public static Matcher<LocalDateTime> isDay(final int year, final int month, final int dayOfMonth) {
        return new IsSameDay<>(
            new JodaLocalDateTimeWrapper(year, month, dayOfMonth),
            new JodaLocalDateTimeFormatter()
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
    public static Matcher<LocalDateTime> sameInstant(final LocalDateTime date) {
        return new IsSame<>(new JodaLocalDateTimeWrapper(date), new JodaLocalDateTimeFormatter());
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
    public static Matcher<LocalDateTime> isInstant(final int year,
            final int month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int nanos) {
        return new IsSame<>(new JodaLocalDateTimeWrapper(year, month, dayOfMonth, hour, minute, second, nanos),
            new JodaLocalDateTimeFormatter());
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
    public static Matcher<LocalDateTime> sameOrBefore(final LocalDateTime date) {
        return new IsSameOrBefore<>(new JodaLocalDateTimeWrapper(date), new JodaLocalDateTimeFormatter());
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
    public static Matcher<LocalDateTime> sameOrBefore(final int year,
            final int month,
            final int day,
            final int hour,
            final int minute,
            final int second) {
        return new IsSameOrBefore<>(new JodaLocalDateTimeWrapper(year, month, day, hour, minute, second),
            new JodaLocalDateTimeFormatter());
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
    public static Matcher<LocalDateTime> sameOrAfter(final LocalDateTime date) {
        return new IsSameOrAfter<>(new JodaLocalDateTimeWrapper(date), new JodaLocalDateTimeFormatter());
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
    public static Matcher<LocalDateTime> sameOrAfter(final int year,
            final int month,
            final int day,
            final int hour,
            final int minute,
            final int second) {
        return sameOrAfter(new LocalDateTime(year, month, day, hour, minute, second));
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
    public static Matcher<LocalDateTime> sameMonthOfYear(final LocalDateTime date) {
        return new IsMonth<>(
            new FieldJodaLocalDateTimeWrapper(date, DateTimeFieldType.monthOfYear()),
            (d, z) -> d.getMonthOfYear(),
		  	null
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
    public static Matcher<LocalDateTime> sameDayOfMonth(final LocalDateTime date) {
        return new IsDayOfMonth<>(
            new FieldJodaLocalDateTimeWrapper(date, DateTimeFieldType.dayOfMonth()),
            (d, z) -> d.getDayOfMonth(),
		  	null
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
    public static Matcher<LocalDateTime> isDayOfMonth(final int dayOfMonth) {
        return new IsDayOfMonth<>(
            new FieldJodaLocalDateTimeWrapper(dayOfMonth, DateTimeFieldType.dayOfMonth()),
            (d, z) -> d.getDayOfMonth(),
		  	null
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
    public static Matcher<LocalDateTime> sameYear(final LocalDateTime date) {
        return new IsYear<>(
            new FieldJodaLocalDateTimeWrapper(date, DateTimeFieldType.year()),
            (d, z) -> d.getYear(),
		  	null
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
    public static Matcher<LocalDateTime> isYear(final int year) {
        return new IsYear<>(
            new FieldJodaLocalDateTimeWrapper(year, DateTimeFieldType.year()),
            (d, z) -> d.getYear(),
		  	null
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
    public static Matcher<LocalDateTime> within(final long period, final DurationFieldType unit, final LocalDateTime date) {
        return new IsWithin<>(period, unit, new JodaLocalDateTimeWrapper(date), new JodaLocalDateTimeFormatter());
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
    public static Matcher<LocalDateTime> within(final long period,
            final DurationFieldType unit,
            final int year,
            final int month,
            final int dayofMonth,
            final int hour,
            final int minute,
            final int second,
            final int nanos) {
        return new IsWithin<>(period, unit,
            new JodaLocalDateTimeWrapper(year, month, dayofMonth, hour, minute, second, nanos),
            new JodaLocalDateTimeFormatter());
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
    public static Matcher<LocalDateTime> sameDayOfWeek(final LocalDateTime date) {
        return isDayOfWeek(date.getDayOfWeek());
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
    public static Matcher<LocalDateTime> isDayOfWeek(final int dayOfWeek) {
        return new IsDayOfWeek<>(
            new FieldJodaLocalDateTimeWrapper(dayOfWeek, DateTimeFieldType.dayOfWeek()),
            (d, z) -> d.getDayOfWeek(),
		  	null
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
    public static Matcher<LocalDateTime> isDayOfWeek(final int... daysOfWeek) {
	  	return new AnyOfTemporals<>(
       		IntStream.of(daysOfWeek).mapToObj(JodaLocalDateTimeMatchers::isDayOfWeek),
       		(d) -> "the date is on a " + DateTimeFieldType.dayOfWeek().getField(d.getChronology()).getName().toLowerCase()
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
    public static Matcher<LocalDateTime> isMonday() {
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
    public static Matcher<LocalDateTime> isTuesday() {
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
    public static Matcher<LocalDateTime> isWednesday() {
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
    public static Matcher<LocalDateTime> isThursday() {
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
    public static Matcher<LocalDateTime> isFriday() {
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
    public static Matcher<LocalDateTime> isSaturday() {
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
    public static Matcher<LocalDateTime> isSunday() {
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
    public static Matcher<LocalDateTime> isWeekday() {
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
    public static Matcher<LocalDateTime> isWeekend() {
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
    public static Matcher<LocalDateTime> isFirstDayOfMonth() {
        return new IsMinimum<>(
            DateTimeFieldType.dayOfMonth(),
            (d, z) -> d.get(DateTimeFieldType.dayOfMonth()),
            (d, z) -> DateTimeFieldType.dayOfMonth().getField(d.getChronology()).getMinimumValue(),
            new JodaDatePartFormatter(),
            () -> "the date is the first day of the month",
		  	null
		);
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
    public static Matcher<LocalDateTime> isMinimum(final DateTimeFieldType field) {
        return new IsMinimum<>(
            field,
            (d, z) -> d.get(field),
            (d, z) -> field.getField(d.getChronology()).getMinimumValue(),
            new JodaDatePartFormatter(),
		  	null
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
    public static Matcher<LocalDateTime> isLastDayOfMonth() {
        return new IsMaximum<>(
            DateTimeFieldType.dayOfMonth(),
            (d, z) -> d.get(DateTimeFieldType.dayOfMonth()),
            (d, z) -> DateTimeFieldType.dayOfMonth().getField(d.getChronology()).getMaximumValue(),
            new JodaDatePartFormatter(),
            () -> "the date is the last day of the month",
		  	null
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
    public static Matcher<LocalDateTime> isMaximum(final DateTimeFieldType field) {
        return new IsMaximum<>(
            field,
            (d, z) -> d.get(field),
            (d, z) -> field.getField(d.getChronology()).getMaximumValue(),
            new JodaDatePartFormatter(),
		  	null
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
    public static Matcher<LocalDateTime> isMonth(final int month) {
        return new IsMonth<>(
            new FieldJodaLocalDateTimeWrapper(month, DateTimeFieldType.monthOfYear()),
            (d, z) -> d.getMonthOfYear(),
		  	null
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
    public static Matcher<LocalDateTime> isJanuary() {
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
    public static Matcher<LocalDateTime> isFebruary() {
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
    public static Matcher<LocalDateTime> isMarch() {
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
    public static Matcher<LocalDateTime> isApril() {
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
    public static Matcher<LocalDateTime> isMay() {
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
    public static Matcher<LocalDateTime> isJune() {
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
    public static Matcher<LocalDateTime> isJuly() {
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
    public static Matcher<LocalDateTime> isAugust() {
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
    public static Matcher<LocalDateTime> isSeptember() {
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
    public static Matcher<LocalDateTime> isOctober() {
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
    public static Matcher<LocalDateTime> isNovember() {
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
    public static Matcher<LocalDateTime> isDecember() {
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
    public static Matcher<LocalDateTime> isLeapYear() {
        return new IsLeapYear<>((d, ignored) -> d.year().isLeap(), new JodaLocalDateTimeFormatter(), null);
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
    public static Matcher<LocalDateTime> isHour(final int hour) {
        return new IsHour<>(
            new FieldJodaLocalDateTimeWrapper(hour, DateTimeFieldType.hourOfDay()),
            (d, z) -> d.getHourOfDay(),
		  	null
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
    public static Matcher<LocalDateTime> sameHourOfDay(final LocalDateTime date) {
        return new IsHour<>(
            new FieldJodaLocalDateTimeWrapper(date, DateTimeFieldType.hourOfDay()),
            (d, z) -> d.getHourOfDay(),
		  	null
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
    public static Matcher<LocalDateTime> isMinute(final int minute) {
        return new IsMinute<>(
            new FieldJodaLocalDateTimeWrapper(minute, DateTimeFieldType.minuteOfHour()),
            (d, ignored) -> d.getMinuteOfHour(),
		  	null
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
    public static Matcher<LocalDateTime> sameMinuteOfHour(final LocalDateTime date) {
        return new IsMinute<>(
            new FieldJodaLocalDateTimeWrapper(date, DateTimeFieldType.minuteOfHour()),
            (d, ignored) -> d.getMinuteOfHour(),
		  	null
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
    public static Matcher<LocalDateTime> isSecond(final int second) {
        return new IsSecond<>(
            new FieldJodaLocalDateTimeWrapper(second, DateTimeFieldType.secondOfMinute()),
            (d, ignored) -> d.getSecondOfMinute(),
		  	(Void) null
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
    public static Matcher<LocalDateTime> sameSecondOfMinute(final LocalDateTime date) {
        return new IsSecond<>(
            new FieldJodaLocalDateTimeWrapper(date, DateTimeFieldType.secondOfMinute()),
            (d, ignored) -> d.getSecondOfMinute(),
		  	(Void) null
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the expected millisecond
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isMillisecond(12));
     * </pre>
     *
     * @param millis the millisecond of the day (0-999)
     */
    public static Matcher<LocalDateTime> isMillisecond(final int millis) {
        return new IsMillisecond<>(
            new FieldJodaLocalDateTimeWrapper(millis, DateTimeFieldType.millisOfSecond()),
            (d, ignored) -> d.getMillisOfSecond(),
		  	(Void) null
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same millisecond as the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameSecondOfMinute(LocalDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<LocalDateTime> sameMillisecondOfSecond(final LocalDateTime date) {
        return new IsMillisecond<>(
            new FieldJodaLocalDateTimeWrapper(date, DateTimeFieldType.millisOfSecond()),
            (d, ignored) -> d.getMillisOfSecond(),
		  	(Void) null
        );
    }
}
