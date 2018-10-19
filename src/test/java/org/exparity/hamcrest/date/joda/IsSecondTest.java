package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.NOON;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.core.IsSecond;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link IsSecond} class
 *
 * @author Thomas Naskali
 */
public class IsSecondTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the second [0-9]+?\\s     but: the date has the second [0-9]+";

    // LocalDateTime Matchers
    @Test
    public void isLocalDateTimeSecond() {
        assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isSecond(0));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeNotSecond() {
        assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isSecond(1));
    }

    // LocalTime Matchers
    @Test
    public void isLocalTimeSecond() {
        assertThat(NOON, JodaLocalTimeMatchers.isSecond(0));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalimeNotSecond() {
        assertThat(NOON, JodaLocalTimeMatchers.isSecond(1));
    }

    // DateTime Matchers
    @Test
    public void isDateTimeSecond() {
        assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isSecond(0));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateTimeNotSecond() {
        assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isSecond(1));
    }

}
