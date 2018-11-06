package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.AUG_01_2015;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_01_2015_NOON_UTC_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_31_2015;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_31_2015_NOON;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_31_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_31_2015_NOON_UTC_AS_DATE;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.LocalTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.testng.annotations.Test;

/**
 * @author Stewart Bissett
 */
public class IsMaximumTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is the maximum value for [\\w ]+?\\s     but: date is the [0-9]+? [\\w ]+? instead of [0-9]+? [\\w ]+";

    // Date Matchers
    @Test
    public void isDateLastDayOfMonth() {
        assertThat(AUG_31_2015_NOON_UTC_AS_DATE, DateMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateNotLastDayOfMonth() {
        assertThat(AUG_01_2015_NOON_UTC_AS_DATE, DateMatchers.isMaximum(ChronoField.DAY_OF_MONTH));
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
}
