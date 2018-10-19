package org.exparity.hamcrest.date.joda;

import java.util.stream.IntStream;

import org.exparity.hamcrest.date.core.AnyOfTemporals;
import org.exparity.hamcrest.date.core.IsAfter;
import org.exparity.hamcrest.date.core.IsBefore;
import org.exparity.hamcrest.date.core.IsDayOfMonth;
import org.exparity.hamcrest.date.core.IsDayOfWeek;
import org.exparity.hamcrest.date.core.IsLeapYear;
import org.exparity.hamcrest.date.core.IsMaximum;
import org.exparity.hamcrest.date.core.IsMinimum;
import org.exparity.hamcrest.date.core.IsMonth;
import org.exparity.hamcrest.date.core.IsSameDay;
import org.exparity.hamcrest.date.core.IsSameOrAfter;
import org.exparity.hamcrest.date.core.IsSameOrBefore;
import org.exparity.hamcrest.date.core.IsWithin;
import org.exparity.hamcrest.date.core.IsYear;
import org.exparity.hamcrest.date.joda.format.JodaDatePartFormatter;
import org.exparity.hamcrest.date.joda.format.JodaLocalDateFormatter;
import org.exparity.hamcrest.date.joda.wrapper.FieldJodaLocalDateWrapper;
import org.exparity.hamcrest.date.joda.wrapper.JodaLocalDateWrapper;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalDate;

/**
 * Static factory for creating {@link org.hamcrest.Matcher} instances for comparing Joda {@link LocalDate} instances
 *
 * @author Thomas Naskali
 */
public class JodaLocalDateMatchers {

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
  public static Matcher<LocalDate> after(final LocalDate date) {
      return new IsAfter<>(new JodaLocalDateWrapper(date), new JodaLocalDateFormatter());
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
  public static Matcher<LocalDate> after(final int year, final int month, final int dayOfMonth) {
      return after(new LocalDate(year, month, dayOfMonth));
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
  public static Matcher<LocalDate> before(final LocalDate date) {
      return new IsBefore<>(new JodaLocalDateWrapper(date), new JodaLocalDateFormatter());
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
  public static Matcher<LocalDate> before(final int year, final int month, final int dayOfMonth) {
      return before(new LocalDate(year, month, dayOfMonth));
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
  public static Matcher<LocalDate> sameDay(final LocalDate date) {
      return new IsSameDay<>(new JodaLocalDateWrapper(date), new JodaLocalDateFormatter());
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
  public static Matcher<LocalDate> isDay(final int year, final int month, final int dayOfMonth) {
      return sameDay(new LocalDate(year, month, dayOfMonth));
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
  public static Matcher<LocalDate> sameOrBefore(final LocalDate date) {
      return new IsSameOrBefore<>(new JodaLocalDateWrapper(date), new JodaLocalDateFormatter());
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
  public static Matcher<LocalDate> sameOrBefore(final int year, final int month, final int day) {
      return sameOrBefore(new LocalDate(year, month, day));
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
  public static Matcher<LocalDate> sameOrAfter(final LocalDate date) {
      return new IsSameOrAfter<>(new JodaLocalDateWrapper(date), new JodaLocalDateFormatter());
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
  public static Matcher<LocalDate> sameOrAfter(final int year, final int month, final int day) {
      return sameOrAfter(new LocalDate(year, month, day));
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
  public static Matcher<LocalDate> sameMonthOfYear(final LocalDate date) {
      return isMonth(date.getMonthOfYear());
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
  public static Matcher<LocalDate> sameDayOfMonth(final LocalDate date) {
      return new IsDayOfMonth<>(
          new FieldJodaLocalDateWrapper(date, DateTimeFieldType.dayOfMonth()),
          (d, ignored) -> d.getDayOfMonth(),
          (Void) null
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
  public static Matcher<LocalDate> isDayOfMonth(final int dayOfMonth) {
      return new IsDayOfMonth<>(
          new FieldJodaLocalDateWrapper(dayOfMonth, DateTimeFieldType.dayOfMonth()),
          (d, z) -> d.getDayOfMonth(),
          (Void) null
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
  public static Matcher<LocalDate> sameYear(final LocalDate date) {
      return new IsYear<>(
          new FieldJodaLocalDateWrapper(date, DateTimeFieldType.year()),
          (d, z) -> d.getYear(),
          (Void) null
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
  public static Matcher<LocalDate> isYear(final int year) {
      return new IsYear<>(
          new FieldJodaLocalDateWrapper(year, DateTimeFieldType.year()),
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
  public static Matcher<LocalDate> within(final long period, final DurationFieldType unit, final LocalDate date) {
      return new IsWithin<>(period, unit, new JodaLocalDateWrapper(date), new JodaLocalDateFormatter());
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
  public static Matcher<LocalDate> within(final long period,
          final DurationFieldType unit,
          final int year,
          final int month,
          final int dayofMonth) {
      return within(period, unit, new LocalDate(year, month, dayofMonth));
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
  public static Matcher<LocalDate> isYesterday() {
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
  public static Matcher<LocalDate> isToday() {
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
  public static Matcher<LocalDate> isTomorrow() {
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
  public static Matcher<LocalDate> sameDayOfWeek(final LocalDate date) {
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
  public static Matcher<LocalDate> isDayOfWeek(final int dayOfWeek) {
      return new IsDayOfWeek<>(
          new FieldJodaLocalDateWrapper(dayOfWeek, DateTimeFieldType.dayOfWeek()),
          (d, ignored) -> d.getDayOfWeek(),
          (Void) null
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
  public static Matcher<LocalDate> isDayOfWeek(final int... daysOfWeek) {
      return new AnyOfTemporals<>(
          IntStream.of(daysOfWeek).mapToObj(JodaLocalDateMatchers::isDayOfWeek),
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
  public static Matcher<LocalDate> isMonday() {
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
  public static Matcher<LocalDate> isTuesday() {
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
  public static Matcher<LocalDate> isWednesday() {
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
  public static Matcher<LocalDate> isThursday() {
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
  public static Matcher<LocalDate> isFriday() {
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
  public static Matcher<LocalDate> isSaturday() {
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
  public static Matcher<LocalDate> isSunday() {
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
  public static Matcher<LocalDate> isWeekday() {
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
  public static Matcher<LocalDate> isWeekend() {
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
  public static Matcher<LocalDate> isFirstDayOfMonth() {
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
  public static Matcher<LocalDate> isMinimum(final DateTimeFieldType field) {
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
  public static Matcher<LocalDate> isLastDayOfMonth() {
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
  public static Matcher<LocalDate> isMaximum(final DateTimeFieldType field) {
      return new IsMaximum<>(
          field,
          (d, ignored) -> d.get(field),
          (d, ignored) -> field.getField(d.getChronology()).getMaximumValue(),
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
  public static Matcher<LocalDate> isMonth(final int month) {
      return new IsMonth<>(
          new FieldJodaLocalDateWrapper(month, DateTimeFieldType.monthOfYear()),
          (d, ignored) -> d.getMonthOfYear(),
          (Void) null
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
  public static Matcher<LocalDate> isJanuary() {
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
  public static Matcher<LocalDate> isFebruary() {
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
  public static Matcher<LocalDate> isMarch() {
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
  public static Matcher<LocalDate> isApril() {
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
  public static Matcher<LocalDate> isMay() {
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
  public static Matcher<LocalDate> isJune() {
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
  public static Matcher<LocalDate> isJuly() {
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
  public static Matcher<LocalDate> isAugust() {
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
  public static Matcher<LocalDate> isSeptember() {
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
  public static Matcher<LocalDate> isOctober() {
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
  public static Matcher<LocalDate> isNovember() {
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
  public static Matcher<LocalDate> isDecember() {
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
  public static Matcher<LocalDate> isLeapYear() {
    return new IsLeapYear<>((d, ignored) -> d.year().isLeap(), new JodaLocalDateFormatter(), null);
  }

}
