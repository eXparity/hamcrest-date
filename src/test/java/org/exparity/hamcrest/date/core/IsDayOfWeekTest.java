package org.exparity.hamcrest.date.core;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.SqlDateMatchers;
import org.exparity.hamcrest.date.Weekdays;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.testng.annotations.Test;

/**
 * @author Stewart Bissett
 */
@SuppressWarnings("deprecation")
public class IsDayOfWeekTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is on a [A-Z][a-z]+?\\s     but: the date is on a [A-Z][a-z]+";
    private static final String ASSERTION_PATTERN_MULTIPLE_DAYS = "\\sExpected: the date is on a [A-Za-z, ]+?\\s     but: the date is on a [A-Z][a-z]+";

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

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isDateMondayIsNotWeekend() {
        assertThat(JAN_02_2012_11AM_UTC_AS_DATE, DateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isDateTuesdayIsNotWeekend() {
        assertThat(JAN_03_2012_11AM_UTC_AS_DATE, DateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isDateWednesdayIsNotWeekend() {
        assertThat(JAN_04_2012_11AM_UTC_AS_DATE, DateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isDateThursdayIsNotWeekend() {
        assertThat(JAN_05_2012_11AM_UTC_AS_DATE, DateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
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

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isDateSaturdayIsNotWeekday() {
        assertThat(JAN_07_2012_11AM_UTC_AS_DATE, DateMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
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
    
    // java.sql.Date Matchers
    @Test
    public void isSqlDateWeekdays() {
        assertThat(JAN_01_2012_AS_SQL, SqlDateMatchers.isDayOfWeek(Weekdays.SUNDAY));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotWeekdays() {
        assertThat(JAN_01_2012_AS_SQL, SqlDateMatchers.isDayOfWeek(Weekdays.SATURDAY));
    }

    @Test
    public void isSqlDateDayOfWeek() {
        assertThat(JAN_01_2012_AS_SQL, SqlDateMatchers.isDayOfWeek(SUNDAY));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotDayOfWeek() {
        assertThat(JAN_01_2012_AS_SQL, SqlDateMatchers.isDayOfWeek(SATURDAY));
    }

    @Test
    public void isSqlDateSaturday() {
        assertThat(JAN_07_2012_AS_SQL, SqlDateMatchers.isSaturday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotSaturday() {
        assertThat(JAN_01_2012_AS_SQL, SqlDateMatchers.isSaturday());
    }

    @Test
    public void isSqlDateSunday() {
        assertThat(JAN_01_2012_AS_SQL, SqlDateMatchers.isSunday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotSunday() {
        assertThat(JAN_02_2012_AS_SQL, SqlDateMatchers.isSunday());
    }

    @Test
    public void isSqlDateWeekend() {
        assertThat(JAN_01_2012_AS_SQL, SqlDateMatchers.isWeekend());
        assertThat(JAN_07_2012_AS_SQL, SqlDateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isSqlDateMondayIsNotWeekend() {
        assertThat(JAN_02_2012_AS_SQL, SqlDateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isSqlDateTuesdayIsNotWeekend() {
        assertThat(JAN_03_2012_AS_SQL, SqlDateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isSqlDateWednesdayIsNotWeekend() {
        assertThat(JAN_04_2012_AS_SQL, SqlDateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isSqlDateThursdayIsNotWeekend() {
        assertThat(JAN_05_2012_AS_SQL, SqlDateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isSqlDateFridayIsNotWeekend() {
        assertThat(JAN_06_2012_AS_SQL, SqlDateMatchers.isWeekend());
    }

    @Test
    public void isSqlDateWeekday() {
        assertThat(JAN_02_2012_AS_SQL, SqlDateMatchers.isWeekday());
        assertThat(JAN_03_2012_AS_SQL, SqlDateMatchers.isWeekday());
        assertThat(JAN_04_2012_AS_SQL, SqlDateMatchers.isWeekday());
        assertThat(JAN_05_2012_AS_SQL, SqlDateMatchers.isWeekday());
        assertThat(JAN_06_2012_AS_SQL, SqlDateMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isSqlDateSaturdayIsNotWeekday() {
        assertThat(JAN_07_2012_AS_SQL, SqlDateMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isSqlDateSundayIsNotWeekday() {
        assertThat(JAN_01_2012_AS_SQL, SqlDateMatchers.isWeekday());
    }

    @Test
    public void isSqlDateMonday() {
        assertThat(JAN_02_2012_AS_SQL, SqlDateMatchers.isMonday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotMonday() {
        assertThat(JAN_03_2012_AS_SQL, SqlDateMatchers.isMonday());
    }

    @Test
    public void isSqlDateTuesday() {
        assertThat(JAN_03_2012_AS_SQL, SqlDateMatchers.isTuesday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotTuesday() {
        assertThat(JAN_04_2012_AS_SQL, SqlDateMatchers.isTuesday());
    }

    @Test
    public void isSqlDateWednesday() {
        assertThat(JAN_04_2012_AS_SQL, SqlDateMatchers.isWednesday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotWednesday() {
        assertThat(JAN_05_2012_AS_SQL, SqlDateMatchers.isWednesday());
    }

    @Test
    public void isSqlDateThursday() {
        assertThat(JAN_05_2012_AS_SQL, SqlDateMatchers.isThursday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotThursday() {
        assertThat(JAN_06_2012_AS_SQL, SqlDateMatchers.isThursday());
    }

    @Test
    public void isSqlDateFriday() {
        assertThat(JAN_06_2012_AS_SQL, SqlDateMatchers.isFriday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotFriday() {
        assertThat(JAN_07_2012_AS_SQL, SqlDateMatchers.isFriday());
    }

    @Test
    public void isSqlDateWeekdaysUsingDateMatchers() {
        assertThat(JAN_01_2012_AS_SQL, DateMatchers.isDayOfWeek(Weekdays.SUNDAY));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotWeekdaysUsingDateMatchers() {
        assertThat(JAN_01_2012_AS_SQL, DateMatchers.isDayOfWeek(Weekdays.SATURDAY));
    }

    @Test
    public void isSqlDateDayOfWeekUsingDateMatchers() {
        assertThat(JAN_01_2012_AS_SQL, DateMatchers.isDayOfWeek(SUNDAY));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotDayOfWeekUsingDateMatchers() {
        assertThat(JAN_01_2012_AS_SQL, DateMatchers.isDayOfWeek(SATURDAY));
    }

    @Test
    public void isSqlDateSaturdayUsingDateMatchers() {
        assertThat(JAN_07_2012_AS_SQL, DateMatchers.isSaturday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotSaturdayUsingDateMatchers() {
        assertThat(JAN_01_2012_AS_SQL, DateMatchers.isSaturday());
    }

    @Test
    public void isSqlDateSundayUsingDateMatchers() {
        assertThat(JAN_01_2012_AS_SQL, DateMatchers.isSunday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotSundayUsingDateMatchers() {
        assertThat(JAN_02_2012_AS_SQL, DateMatchers.isSunday());
    }

    @Test
    public void isSqlDateWeekendUsingDateMatchers() {
        assertThat(JAN_01_2012_AS_SQL, DateMatchers.isWeekend());
        assertThat(JAN_07_2012_AS_SQL, DateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isSqlDateMondayIsNotWeekendUsingDateMatchers() {
        assertThat(JAN_02_2012_AS_SQL, DateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isSqlDateTuesdayIsNotWeekendUsingDateMatchers() {
        assertThat(JAN_03_2012_AS_SQL, DateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isSqlDateWednesdayIsNotWeekendUsingDateMatchers() {
        assertThat(JAN_04_2012_AS_SQL, DateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isSqlDateThursdayIsNotWeekendUsingDateMatchers() {
        assertThat(JAN_05_2012_AS_SQL, DateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isSqlDateFridayIsNotWeekendUsingDateMatchers() {
        assertThat(JAN_06_2012_AS_SQL, DateMatchers.isWeekend());
    }

    @Test
    public void isSqlDateWeekdayUsingDateMatchers() {
        assertThat(JAN_02_2012_AS_SQL, DateMatchers.isWeekday());
        assertThat(JAN_03_2012_AS_SQL, DateMatchers.isWeekday());
        assertThat(JAN_04_2012_AS_SQL, DateMatchers.isWeekday());
        assertThat(JAN_05_2012_AS_SQL, DateMatchers.isWeekday());
        assertThat(JAN_06_2012_AS_SQL, DateMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isSqlDateSaturdayIsNotWeekdayUsingDateMatchers() {
        assertThat(JAN_07_2012_AS_SQL, DateMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isSqlDateSundayIsNotWeekdayUsingDateMatchers() {
        assertThat(JAN_01_2012_AS_SQL, DateMatchers.isWeekday());
    }

    @Test
    public void isSqlDateMondayUsingDateMatchers() {
        assertThat(JAN_02_2012_AS_SQL, DateMatchers.isMonday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotMondayUsingDateMatchers() {
        assertThat(JAN_03_2012_AS_SQL, DateMatchers.isMonday());
    }

    @Test
    public void isSqlDateTuesdayUsingDateMatchers() {
        assertThat(JAN_03_2012_AS_SQL, DateMatchers.isTuesday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotTuesdayUsingDateMatchers() {
        assertThat(JAN_04_2012_AS_SQL, DateMatchers.isTuesday());
    }

    @Test
    public void isSqlDateWednesdayUsingDateMatchers() {
        assertThat(JAN_04_2012_AS_SQL, DateMatchers.isWednesday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotWednesdayUsingDateMatchers() {
        assertThat(JAN_05_2012_AS_SQL, DateMatchers.isWednesday());
    }

    @Test
    public void isSqlDateThursdayUsingDateMatchers() {
        assertThat(JAN_05_2012_AS_SQL, DateMatchers.isThursday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotThursdayUsingDateMatchers() {
        assertThat(JAN_06_2012_AS_SQL, DateMatchers.isThursday());
    }

    @Test
    public void isSqlDateFridayUsingDateMatchers() {
        assertThat(JAN_06_2012_AS_SQL, DateMatchers.isFriday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isSqlDateNotFridayUsingDateMatchers() {
        assertThat(JAN_07_2012_AS_SQL, DateMatchers.isFriday());
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

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isLocalDateNotWeekdayOnSaturday() {
        assertThat(AUG_08_2015, LocalDateMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isLocalDateNotWeekdayOnSunday() {
        assertThat(AUG_09_2015, LocalDateMatchers.isWeekday());
    }

    @Test
    public void isLocalDateWeekend() {
        assertThat(AUG_08_2015, LocalDateMatchers.isWeekend());
        assertThat(AUG_09_2015, LocalDateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isLocalDateNotWeekendOnMonday() {
        assertThat(AUG_03_2015, LocalDateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isLocalDateNotWeekendOnTuesday() {
        assertThat(AUG_04_2015, LocalDateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isLocalDateNotWeekendOnWednesday() {
        assertThat(AUG_05_2015, LocalDateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isLocalDateNotWeekendOnThursday() {
        assertThat(AUG_06_2015, LocalDateMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
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

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isLocalDateTimeNotWeekdayOnSaturday() {
        assertThat(AUG_08_2015_NOON, LocalDateTimeMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isLocalDateTimeNotWeekdayOnSunday() {
        assertThat(AUG_09_2015_NOON, LocalDateTimeMatchers.isWeekday());
    }

    @Test
    public void isLocalDateTimeWeekend() {
        assertThat(AUG_08_2015_NOON, LocalDateTimeMatchers.isWeekend());
        assertThat(AUG_09_2015_NOON, LocalDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isLocalDateTimeNotWeekendOnMonday() {
        assertThat(AUG_03_2015_NOON, LocalDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isLocalDateTimeNotWeekendOnTuesday() {
        assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isLocalDateTimeNotWeekendOnWednesday() {
        assertThat(AUG_05_2015_NOON, LocalDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isLocalDateTimeNotWeekendOnThursday() {
        assertThat(AUG_06_2015_NOON, LocalDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
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

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isZonedDateTimeNotWeekdayOnSaturday() {
        assertThat(AUG_08_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekday());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isZonedDateTimeNotWeekdayOnSunday() {
        assertThat(AUG_09_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekday());
    }

    @Test
    public void isZonedDateTimeWeekend() {
        assertThat(AUG_08_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekend());
        assertThat(AUG_09_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isZonedDateTimeNotWeekendOnMonday() {
        assertThat(AUG_03_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isZonedDateTimeNotWeekendOnTuesday() {
        assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isZonedDateTimeNotWeekendOnWednesday() {
        assertThat(AUG_05_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isZonedDateTimeNotWeekendOnThursday() {
        assertThat(AUG_06_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekend());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN_MULTIPLE_DAYS)
    public void isZonedDateTimeNotWeekendOnFriday() {
        assertThat(AUG_07_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekend());
    }
}
