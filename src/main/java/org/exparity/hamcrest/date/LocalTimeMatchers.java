package org.exparity.hamcrest.date;

import static org.exparity.hamcrest.date.core.TemporalConverters.LOCALTIME_AS_HOUR;
import static org.exparity.hamcrest.date.core.TemporalConverters.LOCALTIME_AS_LOCALTIME;
import static org.exparity.hamcrest.date.core.TemporalConverters.LOCALTIME_AS_MINUTE;
import static org.exparity.hamcrest.date.core.TemporalConverters.LOCALTIME_AS_SECOND;
import static org.exparity.hamcrest.date.core.TemporalFunctions.LOCALTIME;
import static org.exparity.hamcrest.date.core.TemporalProviders.hour;
import static org.exparity.hamcrest.date.core.TemporalProviders.localTime;
import static org.exparity.hamcrest.date.core.TemporalProviders.minute;
import static org.exparity.hamcrest.date.core.TemporalProviders.second;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import org.exparity.hamcrest.date.core.IsAfter;
import org.exparity.hamcrest.date.core.IsBefore;
import org.exparity.hamcrest.date.core.IsHour;
import org.exparity.hamcrest.date.core.IsMaximum;
import org.exparity.hamcrest.date.core.IsMinimum;
import org.exparity.hamcrest.date.core.IsMinute;
import org.exparity.hamcrest.date.core.IsSameOrAfter;
import org.exparity.hamcrest.date.core.IsSameOrBefore;
import org.exparity.hamcrest.date.core.IsSecond;
import org.exparity.hamcrest.date.core.IsWithin;
import org.exparity.hamcrest.date.core.types.Interval;
import org.hamcrest.Matcher;

/**
 * Static factory for creating {@link org.hamcrest.Matcher} instances for comparing {@link LocalTime} instances
 *
 * @author Stewart Bissett
 */
public final class LocalTimeMatchers {

    private LocalTimeMatchers(){}

    /**
     * <p>
     * Creates a matcher that matches when the examined time is after the reference time
     * </p>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myTime, LocalTimeMatchers.after(LocalTime.now()));
     * </pre>
     *
     * @param time the reference time against which the examined time is checked
     */
    public static Matcher<LocalTime> after(final LocalTime time) {
        return new IsAfter<>(LOCALTIME_AS_LOCALTIME, localTime(time), LOCALTIME);
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined time is after the end of the reference year
     * </p>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myTime, LocalTimeMatchers.after(23,59,59);
     * </pre>
     *
     * @param hour the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     */
    public static Matcher<LocalTime> after(final int hour, final int minute, final int second) {
    	return after(LocalTime.of(hour, minute, second));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined time is before the reference time
     * </p>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myTime, LocalTimeMatchers.before(LocalTime.now()));
     * </pre>
     *
     * @param time the reference time against which the examined time is checked
     */
    public static Matcher<LocalTime> before(final LocalTime time) {
        return new IsBefore<>(LOCALTIME_AS_LOCALTIME, localTime(time), LOCALTIME);
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined time is before the end of the reference year
     * </p>
     * For example:
     *
     * <pre>
     * MatcherAssert.assertThat(myTime, LocalTimeMatchers.before(23,59,59);
     * </pre>
     *
     * @param hour the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     */
    public static Matcher<LocalTime> before(final int hour, final int minute, final int second) {
    	return before(LocalTime.of(hour, minute, second));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined time is at the same instant or before the reference time
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myTime, isSameOrBefore(LocalTime.now()))
     * </pre>
     *
     * @param time the reference time against which the examined time is checked
     */
    public static Matcher<LocalTime> sameOrBefore(final LocalTime time) {
        return new IsSameOrBefore<>(LOCALTIME_AS_LOCALTIME, localTime(time), LOCALTIME);
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined time is on the same day or before the start of the reference
     * time
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myTime, isSameOrBefore(23, 59, 59));
     * </pre>
     *
     * @param hour the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     */
    public static Matcher<LocalTime> sameOrBefore(final int hour, final int minute, final int second) {
    	return sameOrBefore(LocalTime.of(hour, minute, second));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined time is at the same instant or after the reference time
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myTime, isSameOrAfter(LocalTime.now()))
     * </pre>
     *
     * @param time the reference time against which the examined time is checked
     */
    public static Matcher<LocalTime> sameOrAfter(final LocalTime time) {
        return new IsSameOrAfter<>(LOCALTIME_AS_LOCALTIME, localTime(time), LOCALTIME);
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined time is on the same day or after the start of the reference time
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myTime, isSameOrAfter(23, 59, 59));
     * </pre>
     *
     * @param hour the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     */
    public static Matcher<LocalTime> sameOrAfter(final int hour, final int minute, final int second) {
        return sameOrAfter(LocalTime.of(hour, minute, second));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined time is within a defined period the reference time
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myTime, within(10, TimeUnit.SECONDS, LocalTime.NOON))
     * </pre>
     *
     * @param time the reference time against which the examined time is checked
     */
    public static Matcher<LocalTime> within(final long period, final ChronoUnit unit, final LocalTime time) {
        return new IsWithin<>(Interval.of(period, unit), LOCALTIME_AS_LOCALTIME, localTime(time), LOCALTIME);
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined time is within a given period of the reference time
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myTime, within(10, TimeUnit.SECONDS, 23, 59, 59));
     * </pre>
     *
     * @param period the timeunit interval the examined time should be with
     * @param unit the timeunit to define the length of the period
     * @param hour the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     */
    public static Matcher<LocalTime> within(final long period,
            final ChronoUnit unit,
            final int hour,
            final int minute,
            final int second) {
    	return within(period, unit, LocalTime.of(hour, minute, second));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is on the maximum value of the given date part in its
     * period
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isMaximumDayOfMonth(ChronoField.DAY_OF_MONTH));
     * </pre>
     *
     * @param field the temporal field to check
     */
    public static Matcher<LocalTime> isMinimum(final ChronoField field) {
        return new IsMinimum<>(LOCALTIME_AS_LOCALTIME, field);
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined date is on the maximum value of the given date part in its
     * period
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myDate, isMaximum(ChronoField.DAY_OF_MONTH));
     * </pre>
     *
     * @param field the temporal field to check
     */
    public static Matcher<LocalTime> isMaximum(final ChronoField field) {
        return new IsMaximum<>(LOCALTIME_AS_LOCALTIME, field);
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined time is on the expected hour (0-23)
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myTime, isHour(12));
     * </pre>
     *
     * @param hour the hour of the day (0-23)
     */
    public static Matcher<LocalTime> isHour(final int hour) {
        return new IsHour<>(LOCALTIME_AS_HOUR, hour(hour));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined time is on the same hour as the reference time
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myTime, sameHourOfDay(LocalTime.now()))
     * </pre>
     *
     * @param time the reference time against which the examined time is checked
     */
    public static Matcher<LocalTime> sameHourOfDay(final LocalTime time) {
        return new IsHour<>(LOCALTIME_AS_HOUR, hour(time));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined time is on the expected minute (0-59)
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myTime, isMinute(12));
     * </pre>
     *
     * @param minute the minute of the day (0-59)
     */
    public static Matcher<LocalTime> isMinute(final int minute) {
        return new IsMinute<>(LOCALTIME_AS_MINUTE, minute(minute));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined time is on the same minute as the reference time
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myTime, sameMinuteOfHour(LocalTime.now()))
     * </pre>
     *
     * @param time the reference time against which the examined time is checked
     */
    public static Matcher<LocalTime> sameMinuteOfHour(final LocalTime time) {
        return new IsMinute<>(LOCALTIME_AS_MINUTE, minute(time));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined time is on the expected second (0-59)
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myTime, isSecond(12));
     * </pre>
     *
     * @param second the second of the day (0-59)
     */
    public static Matcher<LocalTime> isSecond(final int second) {
        return new IsSecond<>(LOCALTIME_AS_SECOND, second(second));
    }

    /**
     * <p>
     * Creates a matcher that matches when the examined time is on the same second as the reference time
     * </p>
     * For example:
     *
     * <pre>
     * assertThat(myTime, sameSecondOfMinute(LocalTime.now()))
     * </pre>
     *
     * @param time the reference time against which the examined time is checked
     */
    public static Matcher<LocalTime> sameSecondOfMinute(final LocalTime time) {
        return new IsSecond<>(LOCALTIME_AS_SECOND, second(time));
    }
}
