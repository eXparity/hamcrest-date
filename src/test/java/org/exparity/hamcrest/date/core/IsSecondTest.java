package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalTime;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.InstantMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.LocalTimeMatchers;
import org.exparity.hamcrest.date.OffsetDateTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link IsSecond} class
 *
 * @author Stewart Bissett
 */
@SuppressWarnings("deprecation")
public class IsSecondTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the second [0-9]+?\\s     but: the date has the second [0-9]+";

    // Date Matchers
    @Test
    public void isDateSecond() {
        assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isSecond(0));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateNotSecond() {
        assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isSecond(1));
    }

	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
    public void isSqlDateSecond() {
        assertThat(AUG_04_2015_AS_SQL, DateMatchers.isSecond(0));
    }
    
    @Test
    public void isDateSameSecond() {
        assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.sameSecond(0));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateNotSameSecond() {
        assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.sameSecond(1));
    }

	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
    public void isSqlDateSameSecond() {
        assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameSecond(0));
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

    // OffsetDateTime Matchers
    @Test
    public void isOffsetDateTimeSecond() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isSecond(0));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeNotSecond() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isSecond(1));
    }

    // Instant Matchers
    @Test
    public void isInstantSecond() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.isSecond(0));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantNotSecond() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.isSecond(1));
    }

}
