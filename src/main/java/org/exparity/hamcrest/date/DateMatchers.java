package org.exparity.hamcrest.date;

import static java.time.DayOfWeek.*;
import static java.time.Month.*;
import static org.exparity.hamcrest.date.core.TemporalConverters.*;
import static org.exparity.hamcrest.date.core.TemporalFunctions.INSTANT;
import static org.exparity.hamcrest.date.core.TemporalFunctions.LOCALDATE;
import static org.exparity.hamcrest.date.core.TemporalFunctions.LOCALDATETIME;
import static org.exparity.hamcrest.date.core.TemporalFunctions.SQLDATE;
import static org.exparity.hamcrest.date.core.TemporalFunctions.JAVADATE;
import static org.exparity.hamcrest.date.core.TemporalProviders.*;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.exparity.hamcrest.date.core.TemporalMatcher;
import org.exparity.hamcrest.date.core.IsAfter;
import org.exparity.hamcrest.date.core.IsBefore;
import org.exparity.hamcrest.date.core.IsDayOfMonth;
import org.exparity.hamcrest.date.core.IsDayOfWeek;
import org.exparity.hamcrest.date.core.IsFirstDayOfMonth;
import org.exparity.hamcrest.date.core.IsHour;
import org.exparity.hamcrest.date.core.IsLastDayOfMonth;
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
import org.exparity.hamcrest.date.core.TemporalConversionException;
import org.exparity.hamcrest.date.core.function.DateFunction;
import org.exparity.hamcrest.date.core.types.Interval;

/**
 * Static factory for creating {@link org.hamcrest.Matcher} instances for comparing dates
 *
 * @author Stewart Bissett
 */
public abstract class DateMatchers {
	
	public static final String UNSUPPORTED_SQL_DATE_UNIT = "java.sql.Date does not support time-based comparisons. Prefer SqlDateMatchers for java.sql.Date appropriate matchers";
	
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
    public static TemporalMatcher<Date> after(final Date date) {
		return new IsAfter<>(JAVADATE_AS_JAVADATE, javaDate(date), new DateFunction());
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
    public static TemporalMatcher<Date> after(final java.sql.Date date) {
        return new IsAfter<>(JAVADATE_AS_SQLDATE, sqlDate(date), SQLDATE);
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
    public static TemporalMatcher<Date> after(final DayMonthYear date) {
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
    public static TemporalMatcher<Date> after(final LocalDate date) {
        return new IsAfter<>(JAVADATE_AS_LOCALDATE, localDate(date), LOCALDATE);
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
    public static TemporalMatcher<Date> after(final LocalDateTime date) {
        return new IsAfter<>(JAVADATE_AS_LOCALDATETIME, localDateTime(date), LOCALDATETIME);
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
    public static TemporalMatcher<Date> after(final Instant date) {
        return new IsAfter<>(JAVADATE_AS_INSTANT, instant(date), INSTANT);
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
    public static TemporalMatcher<Date> after(final int year, final Months month, final int day) {
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
    public static TemporalMatcher<Date> after(final int year, final Month month, final int day) {
        return after(LocalDate.of(year, month, day));
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
    public static TemporalMatcher<Date> after(final int year,
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
    public static TemporalMatcher<Date> after(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second) {
    	return after(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second));
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
    public static TemporalMatcher<Date> before(final Date date) {
		return new IsBefore<>(JAVADATE_AS_JAVADATE, javaDate(date), new DateFunction());
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
    public static TemporalMatcher<Date> before(final java.sql.Date date) {
        return new IsBefore<>(JAVADATE_AS_SQLDATE, sqlDate(date), SQLDATE);
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
    public static TemporalMatcher<Date> before(final DayMonthYear date) {
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
    public static TemporalMatcher<Date> before(final LocalDate date) {
        return new IsBefore<>(JAVADATE_AS_LOCALDATE, localDate(date), LOCALDATE);
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
    public static TemporalMatcher<Date> before(final LocalDateTime date) {
        return new IsBefore<>(JAVADATE_AS_LOCALDATETIME, localDateTime(date), LOCALDATETIME);
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
    public static TemporalMatcher<Date> before(final Instant date) {
        return new IsBefore<>(JAVADATE_AS_INSTANT, instant(date), INSTANT);
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
    public static TemporalMatcher<Date> before(final int year, final Months month, final int day) {
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
    public static TemporalMatcher<Date> before(final int year, final Month month, final int day) {
        return before(LocalDate.of(year, month, day));
    }

    /**
     * Creates a matcher that matches when the examined date is before the end of the reference year
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
    public static TemporalMatcher<Date> before(final int year,
            final Months month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second) {
        return before(year, month.month(), dayOfMonth, hour, minute, second);
    }

    /**
     * Creates a matcher that matches when the examined date is before the end of the reference year
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
    public static TemporalMatcher<Date> before(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second) {
    	return before(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second));
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
    public static TemporalMatcher<Date> sameDayOfWeek(final Date date) {
        return isDayOfWeek(toDayOfWeek(date, ZoneId.systemDefault()));
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
    public static TemporalMatcher<Date> sameDayOfWeek(final java.sql.Date date) {
        return isDayOfWeek(date.toLocalDate().getDayOfWeek());
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
    public static TemporalMatcher<Date> isDayOfWeek(final Weekdays dayOfWeek) {
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
    public static TemporalMatcher<Date> isDayOfWeek(final DayOfWeek dayOfWeek) {
        return new IsDayOfWeek<>(JAVADATE_AS_DAYOFWEEK, daysOfWeek(dayOfWeek));
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
    public static TemporalMatcher<Date> isDayOfWeek(final DayOfWeek... daysOfWeek) {
        return new IsDayOfWeek<>(JAVADATE_AS_DAYOFWEEK, daysOfWeek(daysOfWeek));
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
    public static TemporalMatcher<Date> sameDayOfMonth(final Date date) {
        return new IsDayOfMonth<>(JAVADATE_AS_DAYOFMONTH, dayOfMonth(date));
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
    public static TemporalMatcher<Date> isDayOfMonth(final int dayOfMonth) {
        return new IsDayOfMonth<>(JAVADATE_AS_DAYOFMONTH, dayOfMonth(dayOfMonth));
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
    public static TemporalMatcher<Date> sameDay(final Date date) {
        return new IsSameDay<>(JAVADATE_AS_LOCALDATE, localDate(date));
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
    public static TemporalMatcher<Date> sameDay(final java.sql.Date date) {
        return new IsSameDay<>(JAVADATE_AS_LOCALDATE, localDate(date));
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
    public static TemporalMatcher<Date> sameDay(final DayMonthYear date) {
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
    public static TemporalMatcher<Date> sameDay(final LocalDate date) {
        return new IsSameDay<>(JAVADATE_AS_LOCALDATE, localDate(date));
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
    public static TemporalMatcher<Date> sameDay(final int year, final Months month, final int day) {
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
    public static TemporalMatcher<Date> isDay(final int year, final Month month, final int dayOfMonth) {
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
    public static TemporalMatcher<Date> sameHour(final Date date) {
        return sameHourOfDay(date);
    }
    
	/**
	 * @deprecated java.sql.Date does not support time-based comparisons. Prefer {@link SqlDateMatchers} for
	 * java.sql.Date appropriate matchers
	 * @param date the reference date against which the examined date is checked
	 * @throws TemporalConversionException
	 */
	@Deprecated
    public static TemporalMatcher<Date> sameHour(final java.sql.Date date) {
    	throw new TemporalConversionException(UNSUPPORTED_SQL_DATE_UNIT);
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
    public static TemporalMatcher<Date> sameHourOfDay(final Date date) {
        return new IsHour<>(JAVADATE_AS_HOUR, hour(date));
    }

	/**
	 * @deprecated java.sql.Date does not support time-based comparisons. Prefer {@link SqlDateMatchers} for
	 * java.sql.Date appropriate matchers
	 * @param date the reference date against which the examined date is checked
	 * @throws TemporalConversionException
	 */
    public static TemporalMatcher<Date> sameHourOfDay(final java.sql.Date date) {
    	throw new TemporalConversionException(UNSUPPORTED_SQL_DATE_UNIT);
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
    public static TemporalMatcher<Date> sameHour(final int hour) {
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
    public static TemporalMatcher<Date> isHour(final int hour) {
        return new IsHour<>(JAVADATE_AS_HOUR, hour(hour));
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
    public static TemporalMatcher<Date> sameInstant(final Date date) {
        return new IsSame<>(JAVADATE_AS_INSTANT, instant(date), INSTANT);
    }

	/**
	 * @deprecated java.sql.Date does not support time-based comparisons. Prefer {@link SqlDateMatchers} for
	 * java.sql.Date appropriate matchers
	 * @param date the reference date against which the examined date is checked
	 * @throws TemporalConversionException
	 */
	@Deprecated
    public static TemporalMatcher<Date> sameInstant(final java.sql.Date date) {
    	throw new TemporalConversionException(UNSUPPORTED_SQL_DATE_UNIT);
    }

    /**
     * Creates a matcher that matches when the examined date is on the same UTC instant as the reference Instant
     * supplied
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameInstant(Instant.now()))
     * </pre>
     *
     * @param timestamp the time as milliseconds since the Unix epoch time
     */
    public static TemporalMatcher<Date> sameInstant(final Instant instant) {
        return new IsSame<>(JAVADATE_AS_INSTANT, instant(instant), INSTANT);
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
    public static TemporalMatcher<Date> sameInstant(final long timestamp) {
        return sameInstant(Instant.ofEpochMilli(timestamp));
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
    public static TemporalMatcher<Date> sameInstant(final int year,
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
    public static TemporalMatcher<Date> isInstant(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int milliseconds) {
        return new IsSame<>(JAVADATE_AS_LOCALDATETIME,
                localDateTime(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, milliseconds * 1000000)),
                LOCALDATETIME);
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
    public static TemporalMatcher<Date> sameOrBefore(final Date date) {
        return new IsSameOrBefore<>(JAVADATE_AS_JAVADATE, javaDate(date), JAVADATE);
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
    public static TemporalMatcher<Date> sameOrBefore(final java.sql.Date date) {
        return new IsSameOrBefore<>(JAVADATE_AS_SQLDATE, sqlDate(date), SQLDATE);
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
    public static TemporalMatcher<Date> sameOrBefore(final LocalDate date) {
        return new IsSameOrBefore<>(JAVADATE_AS_LOCALDATE, localDate(date), LOCALDATE);
    }

    /**
     * Creates a matcher that matches when the examined date is at the same instant or before the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrBefore(LocalDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<Date> sameOrBefore(final LocalDateTime date) {
        return new IsSameOrBefore<>(JAVADATE_AS_LOCALDATETIME, localDateTime(date), LOCALDATETIME);
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
    public static TemporalMatcher<Date> sameOrBefore(final DayMonthYear date) {
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
    public static TemporalMatcher<Date> sameOrBefore(final int year, final Months month, final int dayOfMonth) {
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
    public static TemporalMatcher<Date> sameOrBefore(final int year, final Month month, final int dayOfMonth) {
        return sameOrBefore(LocalDate.of(year, month, dayOfMonth));
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
    public static TemporalMatcher<Date> sameOrBefore(final int year,
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
    public static TemporalMatcher<Date> sameOrBefore(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second) {
        return sameOrBefore(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second));
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
    public static TemporalMatcher<Date> sameOrAfter(final Date date) {
        return new IsSameOrAfter<>(JAVADATE_AS_JAVADATE, javaDate(date), JAVADATE);
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
    public static TemporalMatcher<Date> sameOrAfter(final java.sql.Date date) {
        return new IsSameOrAfter<>(JAVADATE_AS_SQLDATE, sqlDate(date), SQLDATE);
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
    public static TemporalMatcher<Date> sameOrAfter(final LocalDate date) {
        return new IsSameOrAfter<>(JAVADATE_AS_LOCALDATE, localDate(date), LOCALDATE);
    }

    /**
     * F Creates a matcher that matches when the examined date is at the same instant or after the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, sameOrAfter(LocalDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<Date> sameOrAfter(final LocalDateTime date) {
        return new IsSameOrAfter<>(JAVADATE_AS_LOCALDATETIME, localDateTime(date), LOCALDATETIME);
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
    public static TemporalMatcher<Date> sameOrAfter(final DayMonthYear date) {
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
    public static TemporalMatcher<Date> sameOrAfter(final int year, final Months month, final int dayOfMonth) {
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
    public static TemporalMatcher<Date> sameOrAfter(final int year, final Month month, final int dayOfMonth) {
        return sameOrAfter(LocalDate.of(year, month, dayOfMonth));
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
    public static TemporalMatcher<Date> sameOrAfter(final int year,
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
    public static TemporalMatcher<Date> sameOrAfter(final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second) {
        return sameOrAfter(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second));
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
    public static TemporalMatcher<Date> sameMinute(final Date date) {
        return sameMinuteOfHour(date);
    }

	/**
	 * @deprecated java.sql.Date does not support time-based comparisons. Prefer {@link SqlDateMatchers} for
	 * java.sql.Date appropriate matchers
	 * @param date the reference date against which the examined date is checked
	 * @throws TemporalConversionException
	 */
	@Deprecated
    public static TemporalMatcher<Date> sameMinute(final java.sql.Date date) {
    	throw new TemporalConversionException(UNSUPPORTED_SQL_DATE_UNIT);
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
    public static TemporalMatcher<Date> sameMinuteOfHour(final Date date) {
        return new IsMinute<>(JAVADATE_AS_MINUTE, minute(date));
    }

	/**
	 * @deprecated java.sql.Date does not support time-based comparisons. Prefer {@link SqlDateMatchers} for
	 * java.sql.Date appropriate matchers
	 * @param date the reference date against which the examined date is checked
	 * @throws TemporalConversionException
	 */
	@Deprecated
    public static TemporalMatcher<Date> sameMinuteOfHour(final java.sql.Date date) {
    	throw new TemporalConversionException(UNSUPPORTED_SQL_DATE_UNIT);
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
    public static TemporalMatcher<Date> sameMinute(final int minute) {
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
    public static TemporalMatcher<Date> isMinute(final int minute) {
        return new IsMinute<>(JAVADATE_AS_MINUTE, minute(minute));
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
    public static TemporalMatcher<Date> sameMonth(final Date date) {
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
    public static TemporalMatcher<Date> sameMonth(final java.sql.Date date) {
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
    public static TemporalMatcher<Date> sameMonthOfYear(final Date date) {
        return new IsMonth<>(JAVADATE_AS_MONTH, month(date));
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
    public static TemporalMatcher<Date> sameMonthOfYear(final java.sql.Date date) {
        return new IsMonth<>(JAVADATE_AS_MONTH, month(date));
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
    public static TemporalMatcher<Date> sameMonth(final Months month) {
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
    public static TemporalMatcher<Date> sameMonthOfYear(final Months month) {
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
    public static TemporalMatcher<Date> sameSecond(final Date date) {
        return sameSecondOfMinute(date);
    }

	/**
	 * @deprecated java.sql.Date does not support time-based comparisons. Prefer {@link SqlDateMatchers} for
	 * java.sql.Date appropriate matchers
	 * @param date the reference date against which the examined date is checked
	 * @throws TemporalConversionException
	 */
	@Deprecated
	public static TemporalMatcher<Date> sameSecond(final java.sql.Date date) {
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
    public static TemporalMatcher<Date> sameSecondOfMinute(final Date date) {
        return new IsSecond<>(JAVADATE_AS_SECOND, second(date));
    }

	/**
	 * @deprecated java.sql.Date does not support time-based comparisons. Prefer {@link SqlDateMatchers} for
	 * java.sql.Date appropriate matchers
	 * @param date the reference date against which the examined date is checked
	 * @throws TemporalConversionException
	 */
	@Deprecated
    public static TemporalMatcher<Date> sameSecondOfMinute(final java.sql.Date date) {
    	throw new TemporalConversionException(UNSUPPORTED_SQL_DATE_UNIT);
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
    public static TemporalMatcher<Date> sameSecond(final int second) {
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
    public static TemporalMatcher<Date> isSecond(final int second) {
        return new IsSecond<>(JAVADATE_AS_SECOND, second(second));
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
    public static TemporalMatcher<Date> sameMillisecond(final Date date) {
        return sameMillisecondOfSecond(date);
    }

	/**
	 * @deprecated java.sql.Date does not support time-based comparisons. Prefer {@link SqlDateMatchers} for
	 * java.sql.Date appropriate matchers
	 * @param date the reference date against which the examined date is checked
	 * @throws TemporalConversionException
	 */
	@Deprecated
    public static TemporalMatcher<Date> sameMillisecond(final java.sql.Date date) {
    	throw new TemporalConversionException(UNSUPPORTED_SQL_DATE_UNIT);
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
    public static TemporalMatcher<Date> sameMillisecondOfSecond(final Date date) {
        return new IsMillisecond<>(JAVADATE_AS_MILLISECOND, millisecondOfMinute(date));
    }

	/**
	 * @deprecated java.sql.Date does not support time-based comparisons. Prefer {@link SqlDateMatchers} for
	 * java.sql.Date appropriate matchers
	 * @param date the reference date against which the examined date is checked
	 * @throws TemporalConversionException
	 */
	@Deprecated
    public static TemporalMatcher<Date> sameMillisecondOfSecond(final java.sql.Date date) {
    	throw new TemporalConversionException(UNSUPPORTED_SQL_DATE_UNIT);
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
    public static TemporalMatcher<Date> sameMillisecond(final int millisecond) {
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
    public static TemporalMatcher<Date> isMillisecond(final int millisecond) {
        return new IsMillisecond<>(JAVADATE_AS_MILLISECOND, millisecondOfMinute(millisecond));
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
    public static TemporalMatcher<Date> sameYear(final Date date) {
        return new IsYear<>(JAVADATE_AS_YEAR, year(date));
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
    public static TemporalMatcher<Date> sameYear(final java.sql.Date date) {
        return new IsYear<>(JAVADATE_AS_YEAR, year(date));
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
    public static TemporalMatcher<Date> isYear(final int year) {
        return new IsYear<>(JAVADATE_AS_YEAR, year(year));
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
    public static TemporalMatcher<Date> within(final long period, final TimeUnit unit, final Date date) {
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
    public static TemporalMatcher<Date> within(final long period, final ChronoUnit unit, final Date date) {
        return new IsWithin<>(Interval.of(period, unit), JAVADATE_AS_JAVADATE, javaDate(date), JAVADATE);
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
    public static TemporalMatcher<Date> within(final long period, final TimeUnit unit, final java.sql.Date date) {
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
    public static TemporalMatcher<Date> within(final long period, final ChronoUnit unit, final java.sql.Date date) {
        return new IsWithin<>(Interval.of(period, unit), JAVADATE_AS_SQLDATE, sqlDate(date), SQLDATE);
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
    public static TemporalMatcher<Date> within(final long period, final ChronoUnit unit, final LocalDate date) {
        return new IsWithin<>(Interval.of(period, unit), JAVADATE_AS_LOCALDATE, localDate(date), LOCALDATE);
    }

    /**
     * Creates a matcher that matches when the examined date is within a defined period the reference date
     * <p/>
     * For example:
     *
     * <pre>
     * assertThat(myDate, within(10, ChronoUnit.DAYS, LocalDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static TemporalMatcher<Date> within(final long period, final ChronoUnit unit, final LocalDateTime date) {
        return new IsWithin<>(Interval.of(period, unit), JAVADATE_AS_LOCALDATETIME, localDateTime(date), LOCALDATETIME);
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
    public static TemporalMatcher<Date> within(final long period, final TimeUnit unit, final DayMonthYear date) {
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
    public static TemporalMatcher<Date> within(final long period,
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
    public static TemporalMatcher<Date> within(final long period,
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
    public static TemporalMatcher<Date> within(final long period,
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
    public static TemporalMatcher<Date> within(final long period,
            final ChronoUnit unit,
            final int year,
            final Month month,
            final int dayOfMonth,
            final int hour,
            final int minute,
            final int second,
            final int milliseconds) {
        return within(period, unit, LocalDateTime.of(year, month, dayOfMonth, hour, minute, second,  milliseconds*1000000));
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
    public static TemporalMatcher<Date> isYesterday() {
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
    public static TemporalMatcher<Date> isToday() {
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
    public static TemporalMatcher<Date> isTomorrow() {
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
    public static TemporalMatcher<Date> isMonday() {
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
    public static TemporalMatcher<Date> isTuesday() {
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
    public static TemporalMatcher<Date> isWednesday() {
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
    public static TemporalMatcher<Date> isThursday() {
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
    public static TemporalMatcher<Date> isFriday() {
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
    public static TemporalMatcher<Date> isSaturday() {
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
    public static TemporalMatcher<Date> isSunday() {
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
    public static TemporalMatcher<Date> isWeekday() {
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
    public static TemporalMatcher<Date> isWeekend() {
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
    public static TemporalMatcher<Date> isFirstDayOfMonth() {
        return new IsFirstDayOfMonth<>(JAVADATE_AS_TEMPORAL);
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
    public static TemporalMatcher<Date> isMinimum(final ChronoField field) {
        return new IsMinimum<>(JAVADATE_AS_TEMPORAL, field);
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
    public static TemporalMatcher<Date> isLastDayOfMonth() {
        return new IsLastDayOfMonth<>(JAVADATE_AS_TEMPORAL);
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
    public static TemporalMatcher<Date> isMaximum(final ChronoField field) {
        return new IsMaximum<>(JAVADATE_AS_TEMPORAL, field);
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
    public static TemporalMatcher<Date> isMonth(final Month month) {
        return new IsMonth<>(JAVADATE_AS_MONTH, month(month));
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
    public static TemporalMatcher<Date> isJanuary() {
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
    public static TemporalMatcher<Date> isFebruary() {
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
    public static TemporalMatcher<Date> isMarch() {
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
    public static TemporalMatcher<Date> isApril() {
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
    public static TemporalMatcher<Date> isMay() {
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
    public static TemporalMatcher<Date> isJune() {
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
    public static TemporalMatcher<Date> isJuly() {
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
    public static TemporalMatcher<Date> isAugust() {
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
    public static TemporalMatcher<Date> isSeptember() {
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
    public static TemporalMatcher<Date> isOctober() {
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
    public static TemporalMatcher<Date> isNovember() {
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
    public static TemporalMatcher<Date> isDecember() {
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
    public static TemporalMatcher<Date> isLeapYear() {
        return new IsLeapYear<>(JAVADATE_AS_YEAR);
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
    
	private static DayOfWeek toDayOfWeek(Date date, ZoneId zone) {
		if ( date instanceof java.sql.Date) {
			return ((java.sql.Date) date).toLocalDate().getDayOfWeek();
		} else {
			return date.toInstant().atZone(zone).getDayOfWeek();
		}
	}
}
