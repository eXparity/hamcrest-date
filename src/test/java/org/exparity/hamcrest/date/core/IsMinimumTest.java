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
public class IsMinimumTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is the minimum value for [\\w ]+?\\s     but: date is the [0-9]+? [\\w ]+? instead of [0-9]+? [\\w ]+?";

    // Date Matchers
    @Test
    public void isDateFirstDayOfMonth() {
        assertThat(AUG_01_2015_NOON_UTC_AS_DATE, DateMatchers.isMinimum(ChronoField.DAY_OF_MONTH));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateNotFirstDayOfMonth() {
        assertThat(AUG_31_2015_NOON_UTC_AS_DATE, DateMatchers.isMinimum(ChronoField.DAY_OF_MONTH));
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
}
