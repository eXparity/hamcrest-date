package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.InstantMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.LocalTimeMatchers;
import org.exparity.hamcrest.date.OffsetDateTimeMatchers;
import org.exparity.hamcrest.date.SqlDateMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.testng.annotations.Test;

/**
 * @author Stewart Bissett
 */
public class IsMinimumTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the minimum value for [\\w ]+?\\s     but: date has the value [0-9]+? instead of [0-9]+?";

    // Date Matchers
    @Test
    public void isDateFirstDayOfMonth() {
        assertThat(AUG_01_2015_NOON_UTC_AS_DATE, DateMatchers.isMinimum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateNotFirstDayOfMonth() {
        assertThat(AUG_31_2015_NOON_UTC_AS_DATE, DateMatchers.isMinimum(ChronoField.DAY_OF_MONTH));
    }

    // java.sql.Date Matchers
    @Test
    public void isSqlDateFirstDayOfMonth() {
        assertThat(AUG_01_2015_AS_SQL, SqlDateMatchers.isMinimum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotFirstDayOfMonth() {
        assertThat(AUG_31_2015_AS_SQL, SqlDateMatchers.isMinimum(ChronoField.DAY_OF_MONTH));
    }
    
    @Test
    public void isSqlDateFirstDayOfMonthUsingDateMatchers() {
        assertThat(AUG_01_2015_AS_SQL, DateMatchers.isMinimum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotFirstDayOfMonthUsingDateMatchers() {
        assertThat(AUG_31_2015_AS_SQL, DateMatchers.isMinimum(ChronoField.DAY_OF_MONTH));
    }
    
    // LocalDate Matchers
    @Test
    public void isLocalDateFirstDayOfMonth() {
        assertThat(AUG_01_2015, LocalDateMatchers.isMinimum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNotFirstDayOfMonth() {
        assertThat(AUG_31_2015, LocalDateMatchers.isMinimum(ChronoField.DAY_OF_MONTH));
    }

    // LocalDateTime Matchers
    @Test
    public void isLocalDateTimeFirstDayOfMonth() {
        assertThat(AUG_01_2015_NOON, LocalDateTimeMatchers.isMinimum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotFirstDayOfMonth() {
        assertThat(AUG_31_2015_NOON, LocalDateTimeMatchers.isMinimum(ChronoField.DAY_OF_MONTH));
    }

    // ZonedDateTime Matchers
    @Test
    public void isZonedDateTimeFirstDayOfMonth() {
        assertThat(AUG_01_2015_NOON_UTC, ZonedDateTimeMatchers.isMinimum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotFirstDayOfMonth() {
        assertThat(AUG_31_2015_NOON_UTC, ZonedDateTimeMatchers.isMinimum(ChronoField.DAY_OF_MONTH));
    }

    // LocalTime Matchers
    @Test
    public void isLocalTimeFirstHourOfDay() {
        assertThat(LocalTime.of(0, 0, 0), LocalTimeMatchers.isMinimum(ChronoField.HOUR_OF_DAY));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalTimeNotFirstHourOfDay() {
        assertThat(LocalTime.of(1, 0, 0), LocalTimeMatchers.isMinimum(ChronoField.HOUR_OF_DAY));
    }

    // OffsetDateTime Matchers
    @Test
    public void isOffsetDateTimeFirstDayOfMonth() {
        assertThat(AUG_01_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isMinimum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeNotFirstDayOfMonth() {
        assertThat(AUG_31_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isMinimum(ChronoField.DAY_OF_MONTH));
    }
    
    // Instant Matchers
    
    @Test
    public void isInstantFirstDayOfMonth() {
        assertThat(AUG_01_2015_NOON_INSTANT_UTC, InstantMatchers.isMinimum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantNotFirstDayOfMonth() {
        assertThat(AUG_31_2015_NOON_INSTANT_UTC, InstantMatchers.isMinimum(ChronoField.DAY_OF_MONTH));
    }
}
