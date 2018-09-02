package org.exparity.hamcrest.date.core;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.Weekdays;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.testng.annotations.Test;

/**
 * @author Stewart Bissett
 */
@SuppressWarnings("deprecation")
public class IsDayOfWeekTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is on a \\p{IsAlphabetic}+?\\s     but: the date is on a \\p{IsAlphabetic}+";

    private static final String ASSERTION_PATTERN_ANYOF = "\\sExpected: \\(the date is on a \\p{IsAlphabetic}+?( or the date is on a \\p{IsAlphabetic}+?)+?\\)\\s     but: the date is on a \\p{IsAlphabetic}+";

    // Date Matchers
    @Test
    public void isDateWeekdays() {
        assertThat(JAN_01_2012_11AM_UTC_AS_DATE, DateMatchers.isDayOfWeek(Weekdays.SUNDAY));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateNotWeekdays() {
        assertThat(JAN_01_2012_11AM_UTC_AS_DATE, DateMatchers.isDayOfWeek(Weekdays.SATURDAY));
    }

    @Test
    public void isDateDayOfWeek() {
        assertThat(JAN_01_2012_11AM_UTC_AS_DATE, DateMatchers.isDayOfWeek(SUNDAY));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateNotDayOfWeek() {
        assertThat(JAN_01_2012_11AM_UTC_AS_DATE, DateMatchers.isDayOfWeek(SATURDAY));
    }

    @Test
    public void isDateSaturday() {
        assertThat(JAN_07_2012_11AM_UTC_AS_DATE, DateMatchers.isSaturday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateNotSaturday() {
        assertThat(JAN_01_2012_11AM_UTC_AS_DATE, DateMatchers.isSaturday());
    }

    @Test
    public void isDateSunday() {
        assertThat(JAN_01_2012_11AM_UTC_AS_DATE, DateMatchers.isSunday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateNotSunday() {
        assertThat(JAN_02_2012_11AM_UTC_AS_DATE, DateMatchers.isSunday());
    }

    @Test
    public void isDateWeekend() {
        assertThat(JAN_01_2012_11AM_UTC_AS_DATE, DateMatchers.isWeekend());
        assertThat(JAN_07_2012_11AM_UTC_AS_DATE, DateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isDateMondayIsNotWeekend() {
        assertThat(JAN_02_2012_11AM_UTC_AS_DATE, DateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isDateTuesdayIsNotWeekend() {
        assertThat(JAN_03_2012_11AM_UTC_AS_DATE, DateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isDateWednesdayIsNotWeekend() {
        assertThat(JAN_04_2012_11AM_UTC_AS_DATE, DateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isDateThursdayIsNotWeekend() {
        assertThat(JAN_05_2012_11AM_UTC_AS_DATE, DateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isDateFridayIsNotWeekend() {
        assertThat(JAN_06_2012_11AM_UTC_AS_DATE, DateMatchers.isWeekend());
    }

    @Test
    public void isDateWeekday() {
        assertThat(JAN_02_2012_11AM_UTC_AS_DATE, DateMatchers.isWeekday());
        assertThat(JAN_03_2012_11AM_UTC_AS_DATE, DateMatchers.isWeekday());
        assertThat(JAN_04_2012_11AM_UTC_AS_DATE, DateMatchers.isWeekday());
        assertThat(JAN_05_2012_11AM_UTC_AS_DATE, DateMatchers.isWeekday());
        assertThat(JAN_06_2012_11AM_UTC_AS_DATE, DateMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isDateSaturdayIsNotWeekday() {
        assertThat(JAN_07_2012_11AM_UTC_AS_DATE, DateMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isDateSundayIsNotWeekday() {
        assertThat(JAN_01_2012_11AM_UTC_AS_DATE, DateMatchers.isWeekday());
    }

    @Test
    public void isDateMonday() {
        assertThat(JAN_02_2012_11AM_UTC_AS_DATE, DateMatchers.isMonday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateNotMonday() {
        assertThat(JAN_03_2012_11AM_UTC_AS_DATE, DateMatchers.isMonday());
    }

    @Test
    public void isDateTuesday() {
        assertThat(JAN_03_2012_11AM_UTC_AS_DATE, DateMatchers.isTuesday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateNotTuesday() {
        assertThat(JAN_04_2012_11AM_UTC_AS_DATE, DateMatchers.isTuesday());
    }

    @Test
    public void isDateWednesday() {
        assertThat(JAN_04_2012_11AM_UTC_AS_DATE, DateMatchers.isWednesday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateNotWednesday() {
        assertThat(JAN_05_2012_11AM_UTC_AS_DATE, DateMatchers.isWednesday());
    }

    @Test
    public void isDateThursday() {
        assertThat(JAN_05_2012_11AM_UTC_AS_DATE, DateMatchers.isThursday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateNotThursday() {
        assertThat(JAN_06_2012_11AM_UTC_AS_DATE, DateMatchers.isThursday());
    }

    @Test
    public void isDateFriday() {
        assertThat(JAN_06_2012_11AM_UTC_AS_DATE, DateMatchers.isFriday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateNotFriday() {
        assertThat(JAN_07_2012_11AM_UTC_AS_DATE, DateMatchers.isFriday());
    }

    // Local Date Matchers
    @Test
    public void isLocalDateDayOfWeek() {
        assertThat(AUG_03_2015, LocalDateMatchers.isDayOfWeek(MONDAY));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNotDayOfWeek() {
        assertThat(AUG_04_2015, LocalDateMatchers.isDayOfWeek(MONDAY));
    }

    @Test
    public void isLocalDateMonday() {
        assertThat(AUG_03_2015, LocalDateMatchers.isMonday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNotMonday() {
        assertThat(AUG_04_2015, LocalDateMatchers.isMonday());
    }

    @Test
    public void isLocalDateTuesday() {
        assertThat(AUG_04_2015, LocalDateMatchers.isTuesday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNotTuesday() {
        assertThat(AUG_05_2015, LocalDateMatchers.isTuesday());
    }

    @Test
    public void isLocalDateWednesday() {
        assertThat(AUG_05_2015, LocalDateMatchers.isWednesday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNotWednesday() {
        assertThat(AUG_06_2015, LocalDateMatchers.isWednesday());
    }

    @Test
    public void isLocalDateThursday() {
        assertThat(AUG_06_2015, LocalDateMatchers.isThursday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNotThursday() {
        assertThat(AUG_07_2015, LocalDateMatchers.isThursday());
    }

    @Test
    public void isLocalDateFriday() {
        assertThat(AUG_07_2015, LocalDateMatchers.isFriday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNotFriday() {
        assertThat(AUG_08_2015, LocalDateMatchers.isFriday());
    }

    @Test
    public void isLocalDateSaturday() {
        assertThat(AUG_08_2015, LocalDateMatchers.isSaturday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNotSaturday() {
        assertThat(AUG_09_2015, LocalDateMatchers.isSaturday());
    }

    @Test
    public void isLocalDateSunday() {
        assertThat(AUG_09_2015, LocalDateMatchers.isSunday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNotSunday() {
        assertThat(AUG_03_2015, LocalDateMatchers.isSunday());
    }

    @Test
    public void isLocalDateWeekday() {
        assertThat(AUG_03_2015, LocalDateMatchers.isWeekday());
        assertThat(AUG_04_2015, LocalDateMatchers.isWeekday());
        assertThat(AUG_05_2015, LocalDateMatchers.isWeekday());
        assertThat(AUG_06_2015, LocalDateMatchers.isWeekday());
        assertThat(AUG_07_2015, LocalDateMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateNotWeekdayOnSaturday() {
        assertThat(AUG_08_2015, LocalDateMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateNotWeekdayOnSunday() {
        assertThat(AUG_09_2015, LocalDateMatchers.isWeekday());
    }

    @Test
    public void isLocalDateWeekend() {
        assertThat(AUG_08_2015, LocalDateMatchers.isWeekend());
        assertThat(AUG_09_2015, LocalDateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateNotWeekendOnMonday() {
        assertThat(AUG_03_2015, LocalDateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateNotWeekendOnTuesday() {
        assertThat(AUG_04_2015, LocalDateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateNotWeekendOnWednesday() {
        assertThat(AUG_05_2015, LocalDateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateNotWeekendOnThursday() {
        assertThat(AUG_06_2015, LocalDateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateNotWeekendOnFriday() {
        assertThat(AUG_07_2015, LocalDateMatchers.isWeekend());
    }

    // LocalDateTime Matchers
    @Test
    public void isLocalDateTimeDayOfWeek() {
        assertThat(AUG_03_2015_NOON, LocalDateTimeMatchers.isDayOfWeek(MONDAY));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotDayOfWeek() {
        assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isDayOfWeek(MONDAY));
    }

    @Test
    public void isLocalDateTimeMonday() {
        assertThat(AUG_03_2015_NOON, LocalDateTimeMatchers.isMonday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotMonday() {
        assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isMonday());
    }

    @Test
    public void isLocalDateTimeTuesday() {
        assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isTuesday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotTuesday() {
        assertThat(AUG_05_2015_NOON, LocalDateTimeMatchers.isTuesday());
    }

    @Test
    public void isLocalDateTimeWednesday() {
        assertThat(AUG_05_2015_NOON, LocalDateTimeMatchers.isWednesday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotWednesday() {
        assertThat(AUG_06_2015_NOON, LocalDateTimeMatchers.isWednesday());
    }

    @Test
    public void isLocalDateTimeThursday() {
        assertThat(AUG_06_2015_NOON, LocalDateTimeMatchers.isThursday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotThursday() {
        assertThat(AUG_07_2015_NOON, LocalDateTimeMatchers.isThursday());
    }

    @Test
    public void isLocalDateTimeFriday() {
        assertThat(AUG_07_2015_NOON, LocalDateTimeMatchers.isFriday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotFriday() {
        assertThat(AUG_08_2015_NOON, LocalDateTimeMatchers.isFriday());
    }

    @Test
    public void isLocalDateTimeSaturday() {
        assertThat(AUG_08_2015_NOON, LocalDateTimeMatchers.isSaturday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotSaturday() {
        assertThat(AUG_09_2015_NOON, LocalDateTimeMatchers.isSaturday());
    }

    @Test
    public void isLocalDateTimeSunday() {
        assertThat(AUG_09_2015_NOON, LocalDateTimeMatchers.isSunday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotSunday() {
        assertThat(AUG_03_2015_NOON, LocalDateTimeMatchers.isSunday());
    }

    @Test
    public void isLocalDateTimeWeekday() {
        assertThat(AUG_03_2015_NOON, LocalDateTimeMatchers.isWeekday());
        assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isWeekday());
        assertThat(AUG_05_2015_NOON, LocalDateTimeMatchers.isWeekday());
        assertThat(AUG_06_2015_NOON, LocalDateTimeMatchers.isWeekday());
        assertThat(AUG_07_2015_NOON, LocalDateTimeMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateTimeNotWeekdayOnSaturday() {
        assertThat(AUG_08_2015_NOON, LocalDateTimeMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateTimeNotWeekdayOnSunday() {
        assertThat(AUG_09_2015_NOON, LocalDateTimeMatchers.isWeekday());
    }

    @Test
    public void isLocalDateTimeWeekend() {
        assertThat(AUG_08_2015_NOON, LocalDateTimeMatchers.isWeekend());
        assertThat(AUG_09_2015_NOON, LocalDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateTimeNotWeekendOnMonday() {
        assertThat(AUG_03_2015_NOON, LocalDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateTimeNotWeekendOnTuesday() {
        assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateTimeNotWeekendOnWednesday() {
        assertThat(AUG_05_2015_NOON, LocalDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateTimeNotWeekendOnThursday() {
        assertThat(AUG_06_2015_NOON, LocalDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isLocalDateTimeNotWeekendOnFriday() {
        assertThat(AUG_07_2015_NOON, LocalDateTimeMatchers.isWeekend());
    }

    // ZonedDateTime Matchers
    @Test
    public void isZonedDateTimeDayOfWeek() {
        assertThat(AUG_03_2015_NOON_UTC, ZonedDateTimeMatchers.isDayOfWeek(MONDAY));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotDayOfWeek() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isDayOfWeek(MONDAY));
    }

    @Test
    public void isZonedDateTimeMonday() {
        assertThat(AUG_03_2015_NOON_UTC, ZonedDateTimeMatchers.isMonday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotMonday() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isMonday());
    }

    @Test
    public void isZonedDateTimeTuesday() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isTuesday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotTuesday() {
        assertThat(AUG_05_2015_NOON_UTC, ZonedDateTimeMatchers.isTuesday());
    }

    @Test
    public void isZonedDateTimeWednesday() {
        assertThat(AUG_05_2015_NOON_UTC, ZonedDateTimeMatchers.isWednesday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotWednesday() {
        assertThat(AUG_06_2015_NOON_UTC, ZonedDateTimeMatchers.isWednesday());
    }

    @Test
    public void isZonedDateTimeThursday() {
        assertThat(AUG_06_2015_NOON_UTC, ZonedDateTimeMatchers.isThursday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotThursday() {
        assertThat(AUG_07_2015_NOON_UTC, ZonedDateTimeMatchers.isThursday());
    }

    @Test
    public void isZonedDateTimeFriday() {
        assertThat(AUG_07_2015_NOON_UTC, ZonedDateTimeMatchers.isFriday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotFriday() {
        assertThat(AUG_08_2015_NOON_UTC, ZonedDateTimeMatchers.isFriday());
    }

    @Test
    public void isZonedDateTimeSaturday() {
        assertThat(AUG_08_2015_NOON_UTC, ZonedDateTimeMatchers.isSaturday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotSaturday() {
        assertThat(AUG_09_2015_NOON_UTC, ZonedDateTimeMatchers.isSaturday());
    }

    @Test
    public void isZonedDateTimeSunday() {
        assertThat(AUG_09_2015_NOON_UTC, ZonedDateTimeMatchers.isSunday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotSunday() {
        assertThat(AUG_03_2015_NOON_UTC, ZonedDateTimeMatchers.isSunday());
    }

    @Test
    public void isZonedDateTimeWeekday() {
        assertThat(AUG_03_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekday());
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekday());
        assertThat(AUG_05_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekday());
        assertThat(AUG_06_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekday());
        assertThat(AUG_07_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isZonedDateTimeNotWeekdayOnSaturday() {
        assertThat(AUG_08_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isZonedDateTimeNotWeekdayOnSunday() {
        assertThat(AUG_09_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekday());
    }

    @Test
    public void isZonedDateTimeWeekend() {
        assertThat(AUG_08_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekend());
        assertThat(AUG_09_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isZonedDateTimeNotWeekendOnMonday() {
        assertThat(AUG_03_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isZonedDateTimeNotWeekendOnTuesday() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isZonedDateTimeNotWeekendOnWednesday() {
        assertThat(AUG_05_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isZonedDateTimeNotWeekendOnThursday() {
        assertThat(AUG_06_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_ANYOF)
    public void isZonedDateTimeNotWeekendOnFriday() {
        assertThat(AUG_07_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekend());
    }
}
