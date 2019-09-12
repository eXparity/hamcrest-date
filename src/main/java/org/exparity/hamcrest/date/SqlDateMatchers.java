package org.exparity.hamcrest.date;

import static java.time.DayOfWeek.*;
import static java.time.Month.*;
import static org.exparity.hamcrest.date.core.TemporalConverters.*;
import static org.exparity.hamcrest.date.core.TemporalFunctions.LOCALDATE;
import static org.exparity.hamcrest.date.core.TemporalFunctions.SQLDATE;
import static org.exparity.hamcrest.date.core.TemporalProviders.*;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import org.exparity.hamcrest.date.core.DateMatcher;
import org.exparity.hamcrest.date.core.IsAfter;
import org.exparity.hamcrest.date.core.IsBefore;
import org.exparity.hamcrest.date.core.IsDayOfMonth;
import org.exparity.hamcrest.date.core.IsDayOfWeek;
import org.exparity.hamcrest.date.core.IsFirstDayOfMonth;
import org.exparity.hamcrest.date.core.IsLastDayOfMonth;
import org.exparity.hamcrest.date.core.IsLeapYear;
import org.exparity.hamcrest.date.core.IsMaximum;
import org.exparity.hamcrest.date.core.IsMinimum;
import org.exparity.hamcrest.date.core.IsMonth;
import org.exparity.hamcrest.date.core.IsSameDay;
import org.exparity.hamcrest.date.core.IsSameOrAfter;
import org.exparity.hamcrest.date.core.IsSameOrBefore;
import org.exparity.hamcrest.date.core.IsWithin;
import org.exparity.hamcrest.date.core.IsYear;
import org.exparity.hamcrest.date.core.types.Interval;

/**
 * Static factory for creating {@link org.hamcrest.Matcher} instances for comparing dates
 *
 * @author Stewart Bissett
 */
public abstract class SqlDateMatchers {

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
	public static DateMatcher<java.sql.Date> after(final Date date) {
		return new IsAfter<>(SQLDATE_AS_SQLDATE, sqlDate(date), SQLDATE);
	}

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
	public static DateMatcher<java.sql.Date> after(final java.util.Date date) {
		return new IsAfter<>(SQLDATE_AS_SQLDATE, sqlDate(date), SQLDATE);
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
	public static DateMatcher<java.sql.Date> after(final DayMonthYear date) {
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
	public static DateMatcher<java.sql.Date> after(final LocalDate date) {
		return new IsAfter<>(SQLDATE_AS_LOCALDATE, localDate(date), LOCALDATE);
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
	public static DateMatcher<java.sql.Date> after(final int year, final Months month, final int day) {
		return after(year, month.month(), day);
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
	public static DateMatcher<java.sql.Date> after(final int year, final Month month, final int day) {
		return after(LocalDate.of(year, month, day));
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
	public static DateMatcher<java.sql.Date> before(final Date date) {
		return new IsBefore<>(SQLDATE_AS_SQLDATE, sqlDate(date), SQLDATE);
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
	public static DateMatcher<java.sql.Date> before(final java.util.Date date) {
		return new IsBefore<>(SQLDATE_AS_SQLDATE, sqlDate(date), SQLDATE);
	}

	/**
	 * Creates a matcher that matches when the examined date is before the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, before(Moments.today()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 * @deprecated Use {@link #before(LocalDate)}
	 */
	@Deprecated
	public static DateMatcher<java.sql.Date> before(final DayMonthYear date) {
		return before(date.toLocalDate());
	}

	/**
	 * Creates a matcher that matches when the examined date is before the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, before(Moments.today()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static DateMatcher<java.sql.Date> before(final LocalDate date) {
		return new IsBefore<>(SQLDATE_AS_LOCALDATE, localDate(date), LOCALDATE);
	}

	/**
	 * Creates a matcher that matches when the examined date is before the end of the reference year
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, before(2012, Months.MAY, 12));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param day the day of the month against which the examined date is checked
	 * @deprecated Use {@link #before(int, Month, int)}
	 */
	@Deprecated
	public static DateMatcher<java.sql.Date> before(final int year, final Months month, final int day) {
		return before(year, month.month(), day);
	}

	/**
	 * Creates a matcher that matches when the examined date is before the end of the reference year
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, before(2012, Months.MAY, 12));
	 * </pre>
	 *
	 * @param year the year against which the examined date is checked
	 * @param month the month against which the examined date is checked
	 * @param day the day of the month against which the examined date is checked
	 */
	public static DateMatcher<java.sql.Date> before(final int year, final Month month, final int day) {
		return before(LocalDate.of(year, month, day));
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
	public static DateMatcher<java.sql.Date> sameDayOfWeek(final Date date) {
		return isDayOfWeek(toDayOfWeek(date));
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
	public static DateMatcher<java.sql.Date> sameDayOfWeek(final java.util.Date date) {
		return isDayOfWeek(toDayOfWeek(date, ZoneId.systemDefault()));
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
	public static DateMatcher<java.sql.Date> isDayOfWeek(final Weekdays dayOfWeek) {
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
	public static DateMatcher<java.sql.Date> isDayOfWeek(final DayOfWeek dayOfWeek) {
		return new IsDayOfWeek<>(SQLDATE_AS_DAYOFWEEK, daysOfWeek(dayOfWeek));
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
	public static DateMatcher<java.sql.Date> isDayOfWeek(final DayOfWeek... daysOfWeek) {
		return new IsDayOfWeek<>(SQLDATE_AS_DAYOFWEEK, daysOfWeek(daysOfWeek));
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
	public static DateMatcher<java.sql.Date> sameDayOfMonth(final Date date) {
		return new IsDayOfMonth<>(SQLDATE_AS_DAYOFMONTH, dayOfMonth(date));
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
	public static DateMatcher<java.sql.Date> sameDayOfMonth(final java.util.Date date) {
		return new IsDayOfMonth<>(SQLDATE_AS_DAYOFMONTH, dayOfMonth(date));
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
	public static DateMatcher<java.sql.Date> isDayOfMonth(final int dayOfMonth) {
		return new IsDayOfMonth<>(SQLDATE_AS_DAYOFMONTH, dayOfMonth(dayOfMonth));
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
	public static DateMatcher<java.sql.Date> sameDay(final java.sql.Date date) {
		return new IsSameDay<>(SQLDATE_AS_LOCALDATE, localDate(date));
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
	public static DateMatcher<java.sql.Date> sameDay(final DayMonthYear date) {
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
	public static DateMatcher<java.sql.Date> sameDay(final LocalDate date) {
		return new IsSameDay<>(SQLDATE_AS_LOCALDATE, localDate(date));
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
	public static DateMatcher<java.sql.Date> sameDay(final int year, final Months month, final int day) {
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
	public static DateMatcher<java.sql.Date> isDay(final int year, final Month month, final int dayOfMonth) {
		return sameDay(LocalDate.of(year, month, dayOfMonth));
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
	public static DateMatcher<java.sql.Date> sameOrBefore(final Date date) {
		return new IsSameOrBefore<>(SQLDATE_AS_SQLDATE, sqlDate(date), SQLDATE);
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
	public static DateMatcher<java.sql.Date> sameOrBefore(final java.util.Date date) {
		return new IsSameOrBefore<>(SQLDATE_AS_SQLDATE, sqlDate(date), SQLDATE);
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
	public static DateMatcher<java.sql.Date> sameOrBefore(final LocalDate date) {
		return new IsSameOrBefore<>(SQLDATE_AS_LOCALDATE, localDate(date), LOCALDATE);
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
	public static DateMatcher<java.sql.Date> sameOrBefore(final DayMonthYear date) {
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
	public static DateMatcher<java.sql.Date> sameOrBefore(final int year, final Months month, final int dayOfMonth) {
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
	public static DateMatcher<java.sql.Date> sameOrBefore(final int year, final Month month, final int dayOfMonth) {
		return sameOrBefore(LocalDate.of(year, month, dayOfMonth));
	}

	/**
	 * Creates a matcher that matches when the examined date is at the same instant or after the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameOrAfter(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static DateMatcher<java.sql.Date> sameOrAfter(final Date date) {
		return new IsSameOrAfter<>(SQLDATE_AS_SQLDATE, sqlDate(date), SQLDATE);
	}

	/**
	 * Creates a matcher that matches when the examined date is at the same instant or after the reference date
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, sameOrAfter(new Date()))
	 * </pre>
	 *
	 * @param date the reference date against which the examined date is checked
	 */
	public static DateMatcher<java.sql.Date> sameOrAfter(final java.util.Date date) {
		return new IsSameOrAfter<>(SQLDATE_AS_SQLDATE, sqlDate(date), SQLDATE);
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
	public static DateMatcher<java.sql.Date> sameOrAfter(final LocalDate date) {
		return new IsSameOrAfter<>(SQLDATE_AS_LOCALDATE, localDate(date), LOCALDATE);
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
	public static DateMatcher<java.sql.Date> sameOrAfter(final DayMonthYear date) {
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
	public static DateMatcher<java.sql.Date> sameOrAfter(final int year, final Months month, final int dayOfMonth) {
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
	public static DateMatcher<java.sql.Date> sameOrAfter(final int year, final Month month, final int dayOfMonth) {
		return sameOrAfter(LocalDate.of(year, month, dayOfMonth));
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
	public static DateMatcher<java.sql.Date> sameMonth(final Date date) {
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
	 * @deprecated Use {@link #sameMonthOfYear(Date)} instead
	 */
	@Deprecated
	public static DateMatcher<java.sql.Date> sameMonth(final java.util.Date date) {
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
	public static DateMatcher<java.sql.Date> sameMonthOfYear(final Date date) {
		return isMonth(SQLDATE_AS_MONTH.apply(date, ZoneId.systemDefault()));
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
	public static DateMatcher<java.sql.Date> sameMonthOfYear(final java.util.Date date) {
		return isMonth(toMonth(date, ZoneId.systemDefault()));
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
	public static DateMatcher<java.sql.Date> sameMonth(final Months month) {
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
	public static DateMatcher<java.sql.Date> sameMonthOfYear(final Months month) {
		return isMonth(month.month());
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
	public static DateMatcher<java.sql.Date> sameYear(final Date date) {
        return new IsYear<>(SQLDATE_AS_YEAR, year(date));
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
	public static DateMatcher<java.sql.Date> sameYear(final java.util.Date date) {
        return new IsYear<>(SQLDATE_AS_YEAR, year(date));
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
	public static DateMatcher<java.sql.Date> isYear(final int year) {
        return new IsYear<>(SQLDATE_AS_YEAR, year(year));
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
	public static DateMatcher<java.sql.Date> within(final long period, final TimeUnit unit, final Date date) {
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
	 * @deprecated Use {@link #within(long, ChronoUnit, Date)}
	 */
	@Deprecated
	public static DateMatcher<java.sql.Date> within(final long period, final TimeUnit unit, final java.util.Date date) {
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
	public static DateMatcher<java.sql.Date> within(final long period, final ChronoUnit unit, final Date date) {
		return new IsWithin<>(Interval.of(period, unit), SQLDATE_AS_SQLDATE, sqlDate(date), SQLDATE);
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
	public static DateMatcher<java.sql.Date> within(final long period,
	        final ChronoUnit unit,
	        final java.util.Date date) {
		return new IsWithin<>(Interval.of(period, unit), SQLDATE_AS_SQLDATE, sqlDate(date), SQLDATE);
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
	public static DateMatcher<java.sql.Date> within(final long period, final ChronoUnit unit, final LocalDate date) {
		return new IsWithin<>(Interval.of(period, unit), SQLDATE_AS_LOCALDATE, localDate(date), LOCALDATE);
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
	public static DateMatcher<java.sql.Date> within(final long period, final TimeUnit unit, final DayMonthYear date) {
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
	public static DateMatcher<java.sql.Date> within(final long period,
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
	public static DateMatcher<java.sql.Date> within(final long period,
	        final ChronoUnit unit,
	        final int year,
	        final Month month,
	        final int dayOfMonth) {
		return within(period, unit, LocalDate.of(year, month, dayOfMonth));
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
	public static DateMatcher<java.sql.Date> isYesterday() {
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
	public static DateMatcher<java.sql.Date> isToday() {
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
	public static DateMatcher<java.sql.Date> isTomorrow() {
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
	public static DateMatcher<java.sql.Date> isMonday() {
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
	public static DateMatcher<java.sql.Date> isTuesday() {
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
	public static DateMatcher<java.sql.Date> isWednesday() {
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
	public static DateMatcher<java.sql.Date> isThursday() {
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
	public static DateMatcher<java.sql.Date> isFriday() {
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
	public static DateMatcher<java.sql.Date> isSaturday() {
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
	public static DateMatcher<java.sql.Date> isSunday() {
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
	public static DateMatcher<java.sql.Date> isWeekday() {
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
	public static DateMatcher<java.sql.Date> isWeekend() {
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
	public static DateMatcher<java.sql.Date> isFirstDayOfMonth() {
        return new IsFirstDayOfMonth<>(SQLDATE_AS_LOCALDATE);
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
	public static DateMatcher<java.sql.Date> isMinimum(final ChronoField field) {
		return new IsMinimum<>(SQLDATE_AS_LOCALDATE, field);
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
	public static DateMatcher<java.sql.Date> isLastDayOfMonth() {
        return new IsLastDayOfMonth<>(SQLDATE_AS_LOCALDATE);
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
	public static DateMatcher<java.sql.Date> isMaximum(final ChronoField field) {
		return new IsMaximum<>(SQLDATE_AS_LOCALDATE, field);
	}

	/**
	 * Creates a matcher that matches when the examined date is in the expected month
	 * <p/>
	 * For example:
	 *
	 * <pre>
	 * assertThat(myDate, isMonth(Month.AUGUST));
	 * </pre>
	 * 
	 * O
	 */
	public static DateMatcher<java.sql.Date> isMonth(final Month month) {
		return new IsMonth<>(SQLDATE_AS_MONTH, month(month));
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
	public static DateMatcher<java.sql.Date> isJanuary() {
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
	public static DateMatcher<java.sql.Date> isFebruary() {
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
	public static DateMatcher<java.sql.Date> isMarch() {
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
	public static DateMatcher<java.sql.Date> isApril() {
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
	public static DateMatcher<java.sql.Date> isMay() {
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
	public static DateMatcher<java.sql.Date> isJune() {
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
	public static DateMatcher<java.sql.Date> isJuly() {
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
	public static DateMatcher<java.sql.Date> isAugust() {
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
	public static DateMatcher<java.sql.Date> isSeptember() {
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
	public static DateMatcher<java.sql.Date> isOctober() {
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
	public static DateMatcher<java.sql.Date> isNovember() {
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
	public static DateMatcher<java.sql.Date> isDecember() {
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
	public static DateMatcher<Date> isLeapYear() {
		return new IsLeapYear<>(SQLDATE_AS_YEAR);
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

	private static DayOfWeek toDayOfWeek(Date date) {
		return date.toLocalDate().getDayOfWeek();
	}

	private static DayOfWeek toDayOfWeek(java.util.Date date, ZoneId zone) {
		return date.toInstant().atZone(zone).getDayOfWeek();
	}

	private static Month toMonth(final java.util.Date date, ZoneId zone) {
		return date.toInstant().atZone(zone).getMonth();
	}

}
