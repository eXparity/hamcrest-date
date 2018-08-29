package org.exparity.hamcrest.date.core;

import static java.time.Month.AUGUST;
import static org.exparity.hamcrest.date.ZonedDateTimeMatchers.before;
import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalTime;
import java.time.Month;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.DayMonthYear;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.LocalTimeMatchers;
import org.exparity.hamcrest.date.Months;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.exparity.hamcrest.date.testutils.ZoneIds;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link DateMatchers} class
 *
 * @author Stewart Bissett
 */
@SuppressWarnings("deprecation")
public class IsBeforeTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is before (?s:.)+?\\s     but: date is (?s:.)+";

    // Date Matchers

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateBeforeLaterDate() {
        assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(JUN_15_2012_11AM_AS_DATE));
    }

    @Test
    public void isDateBeforeEarlierDate() {
        assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.before(JUN_15_2012_11PM_AS_DATE));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateBeforeLaterSameDate() {
        assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(JUN_15_2012_11PM_AS_DATE));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateBeforeLaterSameDateDifferentTimeZone() {
        assertThat(JAN_01_2012_11AM_PST_AS_DATE, DateMatchers.before(JAN_01_2012_11AM_GMT_AS_DATE));
    }

    @Test
    public void isDateBeforeSameDateDifferentTimeZone() {
        assertThat(JAN_01_2012_11AM_GMT_AS_DATE, DateMatchers.before(JAN_01_2012_11AM_PST_AS_DATE));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateBeforeLaterLocalDate() {
        assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(JUN_14_2012));
    }

    @Test
    public void isDateBeforeEarlierLocalDate() {
        assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.before(JUN_16_2012));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateBeforeLaterSameLocalDate() {
        assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(JUN_15_2012));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateBeforeLaterDeprecatedDateValues() {
        assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(2012, Months.JUNE, 14));
    }

    @Test
    public void isDateBeforeEarlierDeprecatedDateValues() {
        assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(2012, Months.JUNE, 16));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateBeforeLaterSameDeprecatedDateValues() {
        assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(2012, Months.JUNE, 15));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateBeforeLaterDateValues() {
        assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(2012, Month.JUNE, 14));
    }

    @Test
    public void isDateBeforeEarlierDateValues() {
        assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(2012, Month.JUNE, 16));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateBeforeLaterSameDateValues() {
        assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(2012, Month.JUNE, 15));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateBeforeLaterDayMonthYear() {
        assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(new DayMonthYear(14, Months.JUNE, 2012)));
    }

    @Test
    public void isDateBeforeEarlierDayMonthYear() {
        assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(new DayMonthYear(16, Months.JUNE, 2012)));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateBeforeLaterSameDayMonthYear() {
        assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(new DayMonthYear(15, Months.JUNE, 2012)));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateBeforeLaterDateTime() {
        assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.before(2012, Months.JUNE, 15, 10, 59, 59));
    }

    @Test
    public void isDateBeforeEarlierDateTime() {
        assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.before(2012, Months.JUNE, 15, 11, 00, 01));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateBeforeLaterSameDateTime() {
        assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.before(2012, Months.JUNE, 15, 11, 00, 00));
    }

    // LocalDate Matchers

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateBeforeLaterLocalDate() {
        assertThat(AUG_04_2015, LocalDateMatchers.before(AUG_03_2015));
    }

    @Test
    public void isLocalDateBeforeEarlierLocalDate() {
        assertThat(AUG_04_2015, LocalDateMatchers.before(AUG_05_2015));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateBeforeLaterSameLocalDate() {
        assertThat(AUG_04_2015, LocalDateMatchers.before(AUG_04_2015));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateBeforeLaterDay() {
        assertThat(AUG_04_2015, LocalDateMatchers.before(2015, AUGUST, 3));
    }

    @Test
    public void isLocalDateBeforeEarlierDay() {
        assertThat(AUG_04_2015, LocalDateMatchers.before(2015, AUGUST, 5));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateBeforeSameDay() {
        assertThat(AUG_04_2015, LocalDateMatchers.before(2015, AUGUST, 4));
    }

    // LocalDateTime Matchers

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeBeforeLaterLocalDateTime() {
        assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(AUG_04_2015_1159));
    }

    @Test
    public void isLocalDateTimeBeforeEarlierLocalDateTime() {
        assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(AUG_04_2015_1201));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeBeforeLaterSameLocalDateTime() {
        assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(AUG_04_2015_NOON));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeBeforeLaterDateTime() {
        assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(2015, AUGUST, 4, 11, 59, 0));
    }

    @Test
    public void isLocalDateTimeBeforeEarlierDateTime() {
        assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(2015, AUGUST, 4, 12, 0, 1));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeBeforeSameDateTime() {
        assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(2015, AUGUST, 4, 12, 0, 0));
    }

    // ZonedDateTime Matchers

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeBeforeLaterZonedDateTime() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(AUG_04_2015_11AM_UTC));
    }

    @Test
    public void isZonedDateTimeBeforeEarlierZonedDateTime() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(AUG_04_2015_01PM_UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeBeforeLaterSameZonedDateTime() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(AUG_04_2015_NOON_UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeBeforeZonedDateTimeEarlierZone() {
        assertThat(AUG_04_2015_NOON_UTC, before(AUG_04_2015_NOON_CET));
    }

    @Test
    public void isZonedDateTimeBeforeZonedDateTimeLaterZone() {
        assertThat(AUG_04_2015_NOON_UTC, before(AUG_04_2015_NOON_EST));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeBeforeLaterDateTime() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(2015, AUGUST, 4, 11, 59, 0, 0, ZoneIds.UTC));
    }

    @Test
    public void isZonedDateTimeBeforeEarlierDateTime() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(2015, AUGUST, 4, 12, 0, 1, 0, ZoneIds.UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeBeforeSameDateTime() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeBeforeDateTimeEarlierZone() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.CET));
    }

    @Test
    public void isZonedDateTimeBeforeDateTimeLaterZone() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.EST));
    }

    // LocalTime Matchers

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalTimeBeforeEarlierLocalTime() {
        assertThat(LocalTime.NOON, LocalTimeMatchers.before(LocalTime.NOON.minusSeconds(1)));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalTimeBeforeSameLocalTime() {
        assertThat(LocalTime.NOON, LocalTimeMatchers.before(LocalTime.NOON));
    }

    @Test
    public void isLocalTimeBeforeLaterLocalTime() {
        assertThat(LocalTime.NOON, LocalTimeMatchers.before(LocalTime.NOON.plusSeconds(1)));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalTimeBeforeEarlierTime() {
        assertThat(LocalTime.NOON, LocalTimeMatchers.before(11, 59, 59));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalTimeBeforeSameTime() {
        assertThat(LocalTime.NOON, LocalTimeMatchers.before(12, 0, 0));
    }

    @Test
    public void isLocalTimeBeforeLaterTime() {
        assertThat(LocalTime.NOON, LocalTimeMatchers.before(12, 0, 1));
    }
}
