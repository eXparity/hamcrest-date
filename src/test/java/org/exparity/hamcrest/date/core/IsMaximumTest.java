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
public class IsMaximumTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the maximum value for [\\w ]+?\\s     but: date has the value [0-9]+? instead of [0-9]+?";

    // Date Matchers
    @Test
    public void isDateLastDayOfMonth() {
        assertThat(AUG_31_2015_NOON_UTC_AS_DATE, DateMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateNotLastDayOfMonth() {
        assertThat(AUG_01_2015_NOON_UTC_AS_DATE, DateMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    // java.sql.Date Matchers
    @Test
    public void isSqlDateLastDayOfMonth() {
        assertThat(AUG_31_2015_AS_SQL, SqlDateMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotLastDayOfMonth() {
        assertThat(AUG_01_2015_AS_SQL, SqlDateMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    @Test
    public void isSqlDateLastDayOfMonthUsingDateMatchers() {
        assertThat(AUG_31_2015_AS_SQL, DateMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotLastDayOfMonthUsingDateMatchers() {
        assertThat(AUG_01_2015_AS_SQL, DateMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }
    
    // LocalDate Matchers
    @Test
    public void isLocalDateLastDayOfMonth() {
        assertThat(AUG_31_2015, LocalDateMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNotLastDayOfMonth() {
        assertThat(AUG_01_2015, LocalDateMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    // LocalDateTime Matchers
    @Test
    public void isLocalDateTimeLastDayOfMonth() {
        assertThat(AUG_31_2015_NOON, LocalDateTimeMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotLastDayOfMonth() {
        assertThat(AUG_01_2015_NOON, LocalDateTimeMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    // ZonedDateTime Matchers
    @Test
    public void isZonedDateTimeLastDayOfMonth() {
        assertThat(AUG_31_2015_NOON_UTC, ZonedDateTimeMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotLastDayOfMonth() {
        assertThat(AUG_01_2015_NOON_UTC, ZonedDateTimeMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    // LocalTime Matchers
    @Test
    public void isLocalTimeLastHourOfDay() {
        assertThat(LocalTime.of(23, 0, 0), LocalTimeMatchers.isMaximum(ChronoField.HOUR_OF_DAY));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalTimeNotLastHourOfDay() {
        assertThat(LocalTime.of(22, 0, 0), LocalTimeMatchers.isMaximum(ChronoField.HOUR_OF_DAY));
    }
    
    // OffsetDateTime Matchers
    
    @Test
    public void isOffsetDateTimeLastDayOfMonth() {
        assertThat(AUG_31_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeNotLastDayOfMonth() {
        assertThat(AUG_01_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }
    
    // Instant Matchers
    
    @Test
    public void isInstantLastDayOfMonth() {
        assertThat(AUG_31_2015_NOON_INSTANT_UTC, InstantMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantNotLastDayOfMonth() {
        assertThat(AUG_01_2015_NOON_INSTANT_UTC, InstantMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }
}
