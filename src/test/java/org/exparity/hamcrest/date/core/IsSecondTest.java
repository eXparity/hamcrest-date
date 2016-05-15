package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_NOON_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_NOON_UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalTime;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.LocalTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link IsSameSecondOfDay} class
 *
 * @author Stewart Bissett
 */
@SuppressWarnings("deprecation")
public class IsSecondTest {

    private static final String ASSERTION_PATTERN = "\\s*Expected: the date has the second [0-9]*\\s*but: the date has the second [0-9]*";

    // Date Matchers
    @Test
    public void isDateSecond() {
        assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isSecond(0));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateNotSecond() {
        assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isSecond(1));
    }

    @Test
    public void isDateSameSecond() {
        assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.sameSecond(0));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateNotSameSecond() {
        assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.sameSecond(1));
    }

    // LocalDateTime Matchers
    @Test
    public void isLocalDateTimeSecond() {
        assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isSecond(0));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotSecond() {
        assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isSecond(1));
    }

    // LocalTime Matchers
    @Test
    public void isLocalTimeSecond() {
        assertThat(LocalTime.NOON, LocalTimeMatchers.isSecond(0));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalimeNotSecond() {
        assertThat(LocalTime.NOON, LocalTimeMatchers.isSecond(1));
    }

    // ZonedDateTime Matchers
    @Test
    public void isZonedDateTimeSecond() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isSecond(0));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotSecond() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isSecond(1));
    }

}
