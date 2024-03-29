package org.exparity.hamcrest.date.core;

import static java.time.Month.AUGUST;
import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.exparity.hamcrest.date.testutils.ZoneIds.UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalTime;
import java.time.Month;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.DayMonthYear;
import org.exparity.hamcrest.date.InstantMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.LocalTimeMatchers;
import org.exparity.hamcrest.date.Months;
import org.exparity.hamcrest.date.OffsetDateTimeMatchers;
import org.exparity.hamcrest.date.SqlDateMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.exparity.hamcrest.date.testutils.ZoneIds;
import org.exparity.hamcrest.date.testutils.ZoneOffsets;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link DateMatchers} class
 *
 * @author Stewart Bissett
 */
@SuppressWarnings("deprecation")
public class IsAfterTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is after (?s:.)+?\\s     but: date is (?s:.)+";

    // Date Matchers

    @Test
    public void isDateAfterEarlierDate() {
        assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.after(JUN_15_2012_11AM_UTC_AS_DATE).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateAfterLaterDate() {
        assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.after(JUN_15_2012_11PM_UTC_AS_DATE).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateAfterSameDate() {
        assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.after(JUN_15_2012_11PM_UTC_AS_DATE).atZone(UTC));
    }

    @Test
    public void isDateAfterSameDateDifferentTimeZone() {
        assertThat(JAN_01_2012_11AM_PST_AS_DATE, DateMatchers.after(JAN_01_2012_11AM_GMT_AS_DATE).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateAfterLaterSameDateDifferentTimeZone() {
        assertThat(JAN_01_2012_11AM_GMT_AS_DATE, DateMatchers.after(JAN_01_2012_11AM_PST_AS_DATE).atZone(UTC));
    }

    @Test
    public void isDateAfterEarlierLocalDate() {
        assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.after(JUN_14_2012).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateAfterLaterLocalDate() {
        assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.after(JUN_16_2012).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateAfterSameLocalDate() {
        assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.after(JUN_15_2012).atZone(UTC));
    }

    @Test
    public void isDateAfterEarlierDeprecatedDateValues() {
        assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.after(2012, Months.JUNE, 14).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateAfterLaterDeprecatedDateValues() {
        assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.after(2012, Months.JUNE, 16).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateAfterSameDeprecatedDateValues() {
        assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.after(2012, Months.JUNE, 15).atZone(UTC));
    }

    @Test
    public void isDateAfterEarlierDateValues() {
        assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.after(2012, Month.JUNE, 14).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateAfterLaterDateValues() {
        assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.after(2012, Month.JUNE, 16).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateAfterSameDateValues() {
        assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.after(2012, Month.JUNE, 15).atZone(UTC));
    }

    @Test
    public void isDateAfterEarlierDayMonthYear() {
        assertThat(JUN_15_2012_11PM_UTC_AS_DATE,
                DateMatchers.after(new DayMonthYear(14, Months.JUNE, 2012)).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateAfterLaterDayMonthYear() {
        assertThat(JUN_15_2012_11PM_UTC_AS_DATE,
                DateMatchers.after(new DayMonthYear(16, Months.JUNE, 2012)).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateAfterSameDayMonthYear() {
        assertThat(JUN_15_2012_11PM_UTC_AS_DATE,
                DateMatchers.after(new DayMonthYear(15, Months.JUNE, 2012)).atZone(UTC));
    }

    @Test
    public void isDateAfterEarlierDateTime() {
        assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.after(2012, Months.JUNE, 15, 10, 59, 59).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateAfterLaterDateTime() {
        assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.after(2012, Months.JUNE, 15, 11, 0, 1).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateAfterSameDateTime() {
        assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.after(2012, Months.JUNE, 15, 11, 0, 0).atZone(UTC));
    }

    @Test
    public void isSqlDateAfterEarlierDate() {
        assertThat(AUG_04_2015_AS_SQL, DateMatchers.after(AUG_03_2015_NOON_UTC_AS_DATE));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateAfterLaterDate() {
        assertThat(AUG_04_2015_AS_SQL, DateMatchers.after(AUG_05_2015_NOON_UTC_AS_DATE));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateAfterSameDate() {
        assertThat(AUG_04_2015_AS_SQL, DateMatchers.after(AUG_04_2015_NOON_UTC_AS_DATE));
    }

    // java.sql.Date Matchers

    @Test
    public void isSqlDateAfterEarlierSqlDate() {
        assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.after(AUG_03_2015_AS_SQL));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateAfterLaterSqlDate() {
        assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.after(AUG_05_2015_AS_SQL));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateAfterSameSqlDate() {
        assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.after(AUG_04_2015_AS_SQL));
    }

    @Test
    public void isSqlDateAfterEarlierJavaDate() {
        assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.after(AUG_03_2015_NOON_UTC_AS_DATE));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateAfterLaterJavaDate() {
        assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.after(AUG_05_2015_NOON_UTC_AS_DATE));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateAfterSameJavaDate() {
        assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.after(AUG_04_2015_NOON_UTC_AS_DATE));
    }

    @Test
    public void isSqlDateAfterEarlierLocalDate() {
        assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.after(AUG_03_2015));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateAfterLaterLocalDate() {
        assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.after(AUG_05_2015));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateAfterSameLocalDate() {
        assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.after(AUG_04_2015));
    }

    @Test
    public void isSqlDateAfterEarlierDay() {
        assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.after(2015, AUGUST, 3));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateAfterLaterDay() {
        assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.after(2015, AUGUST, 5));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateAfterLaterSameDay() {
        assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.after(2015, AUGUST, 4));
    }

    // LocalDate Matchers

    @Test
    public void isLocalDateAfterEarlierLocalDate() {
        assertThat(AUG_04_2015, LocalDateMatchers.after(AUG_03_2015));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateAfterLaterLocalDate() {
        assertThat(AUG_04_2015, LocalDateMatchers.after(AUG_05_2015));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateAfterSameLocalDate() {
        assertThat(AUG_04_2015, LocalDateMatchers.after(AUG_04_2015));
    }

    @Test
    public void isLocalDateAfterEarlierDay() {
        assertThat(AUG_04_2015, LocalDateMatchers.after(2015, AUGUST, 3));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateAfterLaterDay() {
        assertThat(AUG_04_2015, LocalDateMatchers.after(2015, AUGUST, 5));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateAfterLaterSameDay() {
        assertThat(AUG_04_2015, LocalDateMatchers.after(2015, AUGUST, 4));
    }

    // LocalDateTime Matchers

    @Test
    public void isLocalDateTimeAfterEarlierLocalDateTime() {
        assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(AUG_04_2015_1159));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeAfterLaterLocalDateTime() {
        assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(AUG_04_2015_1201));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeAfterSameLocalDateTime() {
        assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(AUG_04_2015_NOON));
    }

    @Test
    public void isLocalDateTimeAfterEarlierDateTime() {
        assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(2015, AUGUST, 4, 11, 59, 0));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeAfterLaterDateTime() {
        assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 1));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeAfterLaterSameDateTime() {
        assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 0));
    }

    // ZonedDateTime Matchers

    @Test
    public void isZonedDateTimeAfterEarlierZonedDateTime() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_11AM_UTC).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeAfterLaterZonedDateTime() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_01PM_UTC).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeAfterSameZonedDateTime() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_NOON_UTC).atZone(UTC));
    }

    @Test
    public void isZonedDateTimeAfterZonedDateTimeEarlierZone() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_NOON_CET).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeAfterZonedDateTimeLaterZone() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_NOON_EST).atZone(UTC));
    }

    @Test
    public void isZonedDateTimeAfterEarlierDateTime() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(2015, AUGUST, 4, 11, 59, 0, 0, UTC).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeAfterLaterDateTime() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 1, 0, UTC).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeAfterLaterSameDateTime() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 0, 0, UTC).atZone(UTC));
    }

    @Test
    public void isZonedDateTimeAfterDateTimeEarlierZone() {
        assertThat(AUG_04_2015_NOON_UTC,
                ZonedDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.CET).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeAfterDateTimeLaterZone() {
        assertThat(AUG_04_2015_NOON_UTC,
                ZonedDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.EST).atZone(UTC));
    }

    // LocalTime Matchers

    @Test
    public void isLocalTimeAfterEarlierLocalTime() {
        assertThat(LocalTime.NOON, LocalTimeMatchers.after(LocalTime.NOON.minusSeconds(1)));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalTimeAfterSameLocalTime() {
        assertThat(LocalTime.NOON, LocalTimeMatchers.after(LocalTime.NOON));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalTimeAfterLaterLocalTime() {
        assertThat(LocalTime.NOON, LocalTimeMatchers.after(LocalTime.NOON.plusSeconds(1)));
    }

    @Test
    public void isLocalTimeAfterEarlierTime() {
        assertThat(LocalTime.NOON, LocalTimeMatchers.after(11, 59, 59));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalTimeAfterSameTime() {
        assertThat(LocalTime.NOON, LocalTimeMatchers.after(12, 0, 0));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalTimeAfterLaterTime() {
        assertThat(LocalTime.NOON, LocalTimeMatchers.after(12, 0, 1));
    }

    // OffsetDateTime Matchers

    @Test
    public void isOffsetDateTimeAfterEarlierOffsetDateTime() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.after(AUG_04_2015_11AM_OFFSET_UTC).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeAfterLaterOffsetDateTime() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.after(AUG_04_2015_01PM_OFFSET_UTC).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeAfterSameOffsetDateTime() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.after(AUG_04_2015_NOON_OFFSET_UTC).atZone(UTC));
    }

    @Test
    public void isOffsetDateTimeAfterOffsetDateTimePositiveOffset() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.after(AUG_04_2015_NOON_OFFSET_CET).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeAfterOffsetDateTimeNegativeOffset() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.after(AUG_04_2015_NOON_OFFSET_EST).atZone(UTC));
    }

    @Test
    public void isOffsetDateTimeAfterEarlierDateTime() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.after(2015, AUGUST, 4, 11, 59, 0, 0, ZoneOffsets.UTC).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeAfterLaterDateTime() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 1, 0, ZoneOffsets.UTC).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeAfterLaterSameDateTime() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 0, 0, ZoneOffsets.UTC).atZone(UTC));
    }

    @Test
    public void isOffsetDateTimeAfterDateTimePositiveOffset() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC,
                OffsetDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 0, 0, ZoneOffsets.CET).atOffset(ZoneOffsets.UTC));
    }
    
    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeAfterDateTimeEquivalentOffset() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC,
                OffsetDateTimeMatchers.after(2015, AUGUST, 4, 7, 0, 0, 0, ZoneOffsets.EST));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeAfterDateTimeNegativeOffset() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC,
                OffsetDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 0, 0, ZoneOffsets.EST).atOffset(ZoneOffsets.UTC));
    }
    
    // Instant Matchers

    @Test
    public void isInstantAfterEarlierInstant() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.after(AUG_04_2015_11AM_INSTANT_UTC).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantAfterLaterInstant() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.after(AUG_04_2015_01PM_INSTANT_UTC).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantAfterSameInstant() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.after(AUG_04_2015_NOON_INSTANT_UTC).atZone(UTC));
    }

    @Test
    public void isInstantAfterInstantPositiveOffset() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.after(AUG_04_2015_NOON_INSTANT_CET).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantAfterInstantNegativeOffset() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.after(AUG_04_2015_NOON_INSTANT_EST).atZone(UTC));
    }

    @Test
    public void isInstantAfterEarlierDateTime() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.after(2015, AUGUST, 4, 11, 59, 0, 0, ZoneOffsets.UTC).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantAfterLaterDateTime() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.after(2015, AUGUST, 4, 12, 0, 1, 0, ZoneOffsets.UTC).atZone(UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantAfterLaterSameDateTime() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.after(2015, AUGUST, 4, 12, 0, 0, 0, ZoneOffsets.UTC).atZone(UTC));
    }

    @Test
    public void isInstantAfterDateTimePositiveOffset() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC,
                InstantMatchers.after(2015, AUGUST, 4, 12, 0, 0, 0, ZoneOffsets.CET).atOffset(ZoneOffsets.UTC));
    }
    
    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantAfterDateTimeEquivalentOffset() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC,
                InstantMatchers.after(2015, AUGUST, 4, 7, 0, 0, 0, ZoneOffsets.EST));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantAfterDateTimeNegativeOffset() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC,
                InstantMatchers.after(2015, AUGUST, 4, 12, 0, 0, 0, ZoneOffsets.EST).atOffset(ZoneOffsets.UTC));
    }
}
