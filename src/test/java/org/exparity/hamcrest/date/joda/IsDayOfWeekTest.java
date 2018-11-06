package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_03_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_03_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_03_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_05_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_05_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_05_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_06_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_06_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_06_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_07_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_07_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_07_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_08_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_08_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_08_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_09_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_09_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_09_2015_NOON_UTC;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.joda.time.DateTimeConstants.MONDAY;

import org.testng.annotations.Test;

/**
 * @author Thomas Naskali
 */
@SuppressWarnings("deprecation")
public class IsDayOfWeekTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is on a \\p{IsAlphabetic}+?\\s     but: the date is on a \\p{IsAlphabetic}+";

    private static final String ASSERTION_PATTERN_ANYOF = "\\sExpected: \\(the date is on a \\p{IsAlphabetic}+?( or the date is on a \\p{IsAlphabetic}+?)+?\\)\\s     but: the date is on a \\p{IsAlphabetic}+";

    // Local Date Matchers
    @Test
    public void isLocalDateDayOfWeek() {
        assertThat(AUG_03_2015, JodaLocalDateMatchers.isDayOfWeek(MONDAY));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNotDayOfWeek() {
        assertThat(AUG_04_2015, JodaLocalDateMatchers.isDayOfWeek(MONDAY));
    }

    @Test
    public void isLocalDateMonday() {
        assertThat(AUG_03_2015, JodaLocalDateMatchers.isMonday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNotMonday() {
        assertThat(AUG_04_2015, JodaLocalDateMatchers.isMonday());
    }

    @Test
    public void isLocalDateTuesday() {
        assertThat(AUG_04_2015, JodaLocalDateMatchers.isTuesday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNotTuesday() {
        assertThat(AUG_05_2015, JodaLocalDateMatchers.isTuesday());
    }

    @Test
    public void isLocalDateWednesday() {
        assertThat(AUG_05_2015, JodaLocalDateMatchers.isWednesday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNotWednesday() {
        assertThat(AUG_06_2015, JodaLocalDateMatchers.isWednesday());
    }

    @Test
    public void isLocalDateThursday() {
        assertThat(AUG_06_2015, JodaLocalDateMatchers.isThursday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNotThursday() {
        assertThat(AUG_07_2015, JodaLocalDateMatchers.isThursday());
    }

    @Test
    public void isLocalDateFriday() {
        assertThat(AUG_07_2015, JodaLocalDateMatchers.isFriday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNotFriday() {
        assertThat(AUG_08_2015, JodaLocalDateMatchers.isFriday());
    }

    @Test
    public void isLocalDateSaturday() {
        assertThat(AUG_08_2015, JodaLocalDateMatchers.isSaturday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNotSaturday() {
        assertThat(AUG_09_2015, JodaLocalDateMatchers.isSaturday());
    }

    @Test
    public void isLocalDateSunday() {
        assertThat(AUG_09_2015, JodaLocalDateMatchers.isSunday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNotSunday() {
        assertThat(AUG_03_2015, JodaLocalDateMatchers.isSunday());
    }

    @Test
    public void isLocalDateWeekday() {
        assertThat(AUG_03_2015, JodaLocalDateMatchers.isWeekday());
        assertThat(AUG_04_2015, JodaLocalDateMatchers.isWeekday());
        assertThat(AUG_05_2015, JodaLocalDateMatchers.isWeekday());
        assertThat(AUG_06_2015, JodaLocalDateMatchers.isWeekday());
        assertThat(AUG_07_2015, JodaLocalDateMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateNotWeekdayOnSaturday() {
        assertThat(AUG_08_2015, JodaLocalDateMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateNotWeekdayOnSunday() {
        assertThat(AUG_09_2015, JodaLocalDateMatchers.isWeekday());
    }

    @Test
    public void isLocalDateWeekend() {
        assertThat(AUG_08_2015, JodaLocalDateMatchers.isWeekend());
        assertThat(AUG_09_2015, JodaLocalDateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateNotWeekendOnMonday() {
        assertThat(AUG_03_2015, JodaLocalDateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateNotWeekendOnTuesday() {
        assertThat(AUG_04_2015, JodaLocalDateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateNotWeekendOnWednesday() {
        assertThat(AUG_05_2015, JodaLocalDateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateNotWeekendOnThursday() {
        assertThat(AUG_06_2015, JodaLocalDateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateNotWeekendOnFriday() {
        assertThat(AUG_07_2015, JodaLocalDateMatchers.isWeekend());
    }

    // LocalDateTime Matchers
    @Test
    public void isLocalDateTimeDayOfWeek() {
        assertThat(AUG_03_2015_NOON, JodaLocalDateTimeMatchers.isDayOfWeek(MONDAY));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotDayOfWeek() {
        assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isDayOfWeek(MONDAY));
    }

    @Test
    public void isLocalDateTimeMonday() {
        assertThat(AUG_03_2015_NOON, JodaLocalDateTimeMatchers.isMonday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotMonday() {
        assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isMonday());
    }

    @Test
    public void isLocalDateTimeTuesday() {
        assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isTuesday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotTuesday() {
        assertThat(AUG_05_2015_NOON, JodaLocalDateTimeMatchers.isTuesday());
    }

    @Test
    public void isLocalDateTimeWednesday() {
        assertThat(AUG_05_2015_NOON, JodaLocalDateTimeMatchers.isWednesday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotWednesday() {
        assertThat(AUG_06_2015_NOON, JodaLocalDateTimeMatchers.isWednesday());
    }

    @Test
    public void isLocalDateTimeThursday() {
        assertThat(AUG_06_2015_NOON, JodaLocalDateTimeMatchers.isThursday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotThursday() {
        assertThat(AUG_07_2015_NOON, JodaLocalDateTimeMatchers.isThursday());
    }

    @Test
    public void isLocalDateTimeFriday() {
        assertThat(AUG_07_2015_NOON, JodaLocalDateTimeMatchers.isFriday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotFriday() {
        assertThat(AUG_08_2015_NOON, JodaLocalDateTimeMatchers.isFriday());
    }

    @Test
    public void isLocalDateTimeSaturday() {
        assertThat(AUG_08_2015_NOON, JodaLocalDateTimeMatchers.isSaturday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotSaturday() {
        assertThat(AUG_09_2015_NOON, JodaLocalDateTimeMatchers.isSaturday());
    }

    @Test
    public void isLocalDateTimeSunday() {
        assertThat(AUG_09_2015_NOON, JodaLocalDateTimeMatchers.isSunday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotSunday() {
        assertThat(AUG_03_2015_NOON, JodaLocalDateTimeMatchers.isSunday());
    }

    @Test
    public void isLocalDateTimeWeekday() {
        assertThat(AUG_03_2015_NOON, JodaLocalDateTimeMatchers.isWeekday());
        assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isWeekday());
        assertThat(AUG_05_2015_NOON, JodaLocalDateTimeMatchers.isWeekday());
        assertThat(AUG_06_2015_NOON, JodaLocalDateTimeMatchers.isWeekday());
        assertThat(AUG_07_2015_NOON, JodaLocalDateTimeMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateTimeNotWeekdayOnSaturday() {
        assertThat(AUG_08_2015_NOON, JodaLocalDateTimeMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateTimeNotWeekdayOnSunday() {
        assertThat(AUG_09_2015_NOON, JodaLocalDateTimeMatchers.isWeekday());
    }

    @Test
    public void isLocalDateTimeWeekend() {
        assertThat(AUG_08_2015_NOON, JodaLocalDateTimeMatchers.isWeekend());
        assertThat(AUG_09_2015_NOON, JodaLocalDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateTimeNotWeekendOnMonday() {
        assertThat(AUG_03_2015_NOON, JodaLocalDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateTimeNotWeekendOnTuesday() {
        assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateTimeNotWeekendOnWednesday() {
        assertThat(AUG_05_2015_NOON, JodaLocalDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateTimeNotWeekendOnThursday() {
        assertThat(AUG_06_2015_NOON, JodaLocalDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateTimeNotWeekendOnFriday() {
        assertThat(AUG_07_2015_NOON, JodaLocalDateTimeMatchers.isWeekend());
    }

    // ZonedDateTime Matchers
    @Test
    public void isZonedDateTimeDayOfWeek() {
        assertThat(AUG_03_2015_NOON_UTC, JodaDateTimeMatchers.isDayOfWeek(MONDAY));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotDayOfWeek() {
        assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isDayOfWeek(MONDAY));
    }

    @Test
    public void isZonedDateTimeMonday() {
        assertThat(AUG_03_2015_NOON_UTC, JodaDateTimeMatchers.isMonday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotMonday() {
        assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isMonday());
    }

    @Test
    public void isZonedDateTimeTuesday() {
        assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isTuesday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotTuesday() {
        assertThat(AUG_05_2015_NOON_UTC, JodaDateTimeMatchers.isTuesday());
    }

    @Test
    public void isZonedDateTimeWednesday() {
        assertThat(AUG_05_2015_NOON_UTC, JodaDateTimeMatchers.isWednesday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotWednesday() {
        assertThat(AUG_06_2015_NOON_UTC, JodaDateTimeMatchers.isWednesday());
    }

    @Test
    public void isZonedDateTimeThursday() {
        assertThat(AUG_06_2015_NOON_UTC, JodaDateTimeMatchers.isThursday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotThursday() {
        assertThat(AUG_07_2015_NOON_UTC, JodaDateTimeMatchers.isThursday());
    }

    @Test
    public void isZonedDateTimeFriday() {
        assertThat(AUG_07_2015_NOON_UTC, JodaDateTimeMatchers.isFriday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotFriday() {
        assertThat(AUG_08_2015_NOON_UTC, JodaDateTimeMatchers.isFriday());
    }

    @Test
    public void isZonedDateTimeSaturday() {
        assertThat(AUG_08_2015_NOON_UTC, JodaDateTimeMatchers.isSaturday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotSaturday() {
        assertThat(AUG_09_2015_NOON_UTC, JodaDateTimeMatchers.isSaturday());
    }

    @Test
    public void isZonedDateTimeSunday() {
        assertThat(AUG_09_2015_NOON_UTC, JodaDateTimeMatchers.isSunday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotSunday() {
        assertThat(AUG_03_2015_NOON_UTC, JodaDateTimeMatchers.isSunday());
    }

    @Test
    public void isZonedDateTimeWeekday() {
        assertThat(AUG_03_2015_NOON_UTC, JodaDateTimeMatchers.isWeekday());
        assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isWeekday());
        assertThat(AUG_05_2015_NOON_UTC, JodaDateTimeMatchers.isWeekday());
        assertThat(AUG_06_2015_NOON_UTC, JodaDateTimeMatchers.isWeekday());
        assertThat(AUG_07_2015_NOON_UTC, JodaDateTimeMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isZonedDateTimeNotWeekdayOnSaturday() {
        assertThat(AUG_08_2015_NOON_UTC, JodaDateTimeMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isZonedDateTimeNotWeekdayOnSunday() {
        assertThat(AUG_09_2015_NOON_UTC, JodaDateTimeMatchers.isWeekday());
    }

    @Test
    public void isZonedDateTimeWeekend() {
        assertThat(AUG_08_2015_NOON_UTC, JodaDateTimeMatchers.isWeekend());
        assertThat(AUG_09_2015_NOON_UTC, JodaDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isZonedDateTimeNotWeekendOnMonday() {
        assertThat(AUG_03_2015_NOON_UTC, JodaDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isZonedDateTimeNotWeekendOnTuesday() {
        assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isZonedDateTimeNotWeekendOnWednesday() {
        assertThat(AUG_05_2015_NOON_UTC, JodaDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isZonedDateTimeNotWeekendOnThursday() {
        assertThat(AUG_06_2015_NOON_UTC, JodaDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isZonedDateTimeNotWeekendOnFriday() {
        assertThat(AUG_07_2015_NOON_UTC, JodaDateTimeMatchers.isWeekend());
    }
}
