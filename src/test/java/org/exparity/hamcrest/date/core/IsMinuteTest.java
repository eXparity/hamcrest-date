package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalTime;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.LocalTimeMatchers;
import org.exparity.hamcrest.date.OffsetDateTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link IsMinute} class
 *
 * @author Stewart Bissett
 */
@SuppressWarnings("deprecation")
public class IsMinuteTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the minute [0-9]+?\\s     but: the date has the minute [0-9]+";

	// Date Matchers
	@Test
	public void isDateMinute() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isMinute(0));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotMinute() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isMinute(1));
	}
	
	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isSqlDateMinute() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.isMinute(0));
	}

	@Test
	public void isDateSameMinute() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.sameMinute(0));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotSameMinute() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.sameMinute(1));
	}

	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isSqlDateSameMinute() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameMinute(0));
	}
	
	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeMinute() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isMinute(0));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotMinute() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isMinute(1));
	}

	// LocalTime Matchers
	@Test
	public void isLocalTimeMinute() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.isMinute(0));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeNotMinute() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.isMinute(1));
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeMinute() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isMinute(0));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotMinute() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isMinute(1));
	}

    // OffsetDateTime Matchers
    @Test
    public void isOffsetDateTimeMinute() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isMinute(0));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeNotMinute() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isMinute(1));
    }
}
