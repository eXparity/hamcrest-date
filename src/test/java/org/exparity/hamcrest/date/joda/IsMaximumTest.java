package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_01_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_31_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_31_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_31_2015_NOON_UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import org.joda.time.DateTimeFieldType;
import org.joda.time.LocalTime;
import org.testng.annotations.Test;

/**
 * @author Thomas Naskali
 */
public class IsMaximumTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is the maximum value for [\\w ]+?\\s     but: date is the [0-9]+? [\\w ]+? instead of [0-9]+? [\\w ]+";

    // LocalDate Matchers
    @Test
    public void isLocalDateLastDayOfMonth() {
        assertThat(AUG_31_2015, JodaLocalDateMatchers.isMaximum(DateTimeFieldType.dayOfMonth()));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNotLastDayOfMonth() {
        assertThat(AUG_01_2015, JodaLocalDateMatchers.isMaximum(DateTimeFieldType.dayOfMonth()));
    }

    // LocalDateTime Matchers
    @Test
    public void isLocalDateTimeLastDayOfMonth() {
        assertThat(AUG_31_2015_NOON, JodaLocalDateTimeMatchers.isMaximum(DateTimeFieldType.dayOfMonth()));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotLastDayOfMonth() {
        assertThat(AUG_01_2015_NOON, JodaLocalDateTimeMatchers.isMaximum(DateTimeFieldType.dayOfMonth()));
    }

    // ZonedDateTime Matchers
    @Test
    public void isZonedDateTimeLastDayOfMonth() {
        assertThat(AUG_31_2015_NOON_UTC, JodaDateTimeMatchers.isMaximum(DateTimeFieldType.dayOfMonth()));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotLastDayOfMonth() {
        assertThat(AUG_01_2015_NOON_UTC, JodaDateTimeMatchers.isMaximum(DateTimeFieldType.dayOfMonth()));
    }

    // LocalTime Matchers
    @Test
    public void isLocalTimeLastHourOfDay() {
        assertThat(new LocalTime(23, 0), JodaLocalTimeMatchers.isMaximum(DateTimeFieldType.hourOfDay()));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalTimeNotLastHourOfDay() {
        assertThat(new LocalTime(22, 0), JodaLocalTimeMatchers.isMaximum(DateTimeFieldType.hourOfDay()));
    }
}
