package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_01_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_31_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_31_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_31_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.MIDN;
import static org.hamcrest.MatcherAssert.assertThat;

import org.joda.time.DateTimeFieldType;
import org.joda.time.LocalTime;
import org.testng.annotations.Test;

/**
 * @author Thomas Naskali
 */
public class IsMinimumTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is the minimum value for [\\w ]+?\\s     but: date is the [0-9]+? [\\w ]+? instead of [0-9]+? [\\w ]+?";

    // LocalDate Matchers
    @Test
    public void isLocalDateFirstDayOfMonth() {
        assertThat(AUG_01_2015, JodaLocalDateMatchers.isMinimum(DateTimeFieldType.dayOfMonth()));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateNotFirstDayOfMonth() {
        assertThat(AUG_31_2015, JodaLocalDateMatchers.isMinimum(DateTimeFieldType.dayOfMonth()));
    }

    // LocalDateTime Matchers
    @Test
    public void isLocalDateTimeFirstDayOfMonth() {
        assertThat(AUG_01_2015_NOON, JodaLocalDateTimeMatchers.isMinimum(DateTimeFieldType.dayOfMonth()));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotFirstDayOfMonth() {
        assertThat(AUG_31_2015_NOON, JodaLocalDateTimeMatchers.isMinimum(DateTimeFieldType.dayOfMonth()));
    }

    // LocalTime Matchers
    @Test
    public void isLocalTimeFirstHourOfDay() {
        assertThat(MIDN, JodaLocalTimeMatchers.isMinimum(DateTimeFieldType.hourOfDay()));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalTimeNotFirstHourOfDay() {
        assertThat(new LocalTime(1, 0), JodaLocalTimeMatchers.isMinimum(DateTimeFieldType.hourOfDay()));
    }

    // DateTime Matchers
    @Test
    public void isZonedDateTimeFirstDayOfMonth() {
        assertThat(AUG_01_2015_NOON_UTC, JodaDateTimeMatchers.isMinimum(DateTimeFieldType.dayOfMonth()));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isZonedDateTimeNotFirstDayOfMonth() {
        assertThat(AUG_31_2015_NOON_UTC, JodaDateTimeMatchers.isMinimum(DateTimeFieldType.dayOfMonth()));
    }
}
