package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.exparity.hamcrest.date.testutils.ZoneIds.UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.LocalTimeMatchers;
import org.exparity.hamcrest.date.OffsetDateTimeMatchers;
import org.exparity.hamcrest.date.SqlDateMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.exparity.hamcrest.date.testutils.ZoneIds;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link IsWithin} class
 *
 * @author Stewart Bissett
 */
public class IsWithinTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is within [0-9]+? [\\w ]+? of (?s:.)+?\\s     but: the date is (?s:.)+? and [0-9]+? [\\w ]+? different";

	// Date Matchers
	@Test
	public void isDateWithinSameDate() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, AUG_04_2015_NOON_UTC_AS_DATE).atZone(UTC));
	}

	@Test
	public void isDateWithinDateInsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, AUG_05_2015_NOON_UTC_AS_DATE).atZone(UTC));
	}

	@Test
	public void isDateWithinDateEqualLimit() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, AUG_06_2015_NOON_UTC_AS_DATE).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateWithinDateOutsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, AUG_07_2015_NOON_UTC_AS_DATE).atZone(UTC));
	}

	@Test
	public void isDateWithinSameSqlDate() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, AUG_04_2015_AS_SQL).atZone(UTC));
	}

	@Test
	public void isDateWithinSqlDateInsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, AUG_05_2015_AS_SQL).atZone(UTC));
	}

	@Test
	public void isDateWithinSqlDateEqualLimit() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, AUG_06_2015_AS_SQL).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateWithinSqlDateOutsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, AUG_07_2015_AS_SQL).atZone(UTC));
	}
	
	@Test
	public void isDateWithinSameLocalDate() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, AUG_04_2015).atZone(UTC));
	}

	@Test
	public void isDateWithinLocalDateInsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, AUG_05_2015).atZone(UTC));
	}

	@Test
	public void isDateWithinLocalDateEqualLimit() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, AUG_06_2015).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateWithinLocalDateOutsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, AUG_07_2015).atZone(UTC));
	}

	@Test
	public void isDateWithinSameDayMonthYear() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 4).atZone(UTC));
	}

	@Test
	public void isDateWithinDayMonthYearInsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 5).atZone(UTC));
	}

	@Test
	public void isDateWithinDayMonthYearEqualLimit() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 6).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateWithinDayMonthYearOutsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 7).atZone(UTC));
	}

	@Test
	public void isDateWithinSameDayMonthYearTime() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE,
				DateMatchers.within(2, ChronoUnit.MILLIS, 2015, Month.AUGUST, 4, 12, 0, 0, 0).atZone(UTC));
	}

	@Test
	public void isDateWithinDayMonthYearTimeInsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE,
				DateMatchers.within(2, ChronoUnit.MILLIS, 2015, Month.AUGUST, 4, 12, 0, 0, 1).atZone(UTC));
	}

	@Test
	public void isDateWithinDayMonthYearTimeEqualLimit() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE,
				DateMatchers.within(2, ChronoUnit.MILLIS, 2015, Month.AUGUST, 4, 12, 0, 0, 2).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateWithinDayMonthYearTimeOutsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE,
				DateMatchers.within(2, ChronoUnit.MILLIS, 2015, Month.AUGUST, 4, 12, 0, 0, 3).atZone(UTC));
	}

	// java.sql.Date Matchers
	@Test
	public void isSqlDateWithinSameSqlDate() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.within(2, ChronoUnit.DAYS, AUG_04_2015_AS_SQL).atZone(UTC));
	}

	@Test
	public void isSqlDateWithinSqlDateInsideLimit() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.within(2, ChronoUnit.DAYS, AUG_05_2015_AS_SQL).atZone(UTC));
	}

	@Test
	public void isSqlDateWithinSqlDateEqualLimit() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.within(2, ChronoUnit.DAYS, AUG_06_2015_AS_SQL).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateWithinSqlDateOutsideLimit() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.within(2, ChronoUnit.DAYS, AUG_07_2015_AS_SQL).atZone(UTC));
	}
	
	@Test
	public void isSqlDateWithinSameDate() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.within(2, ChronoUnit.DAYS, AUG_04_2015_NOON_UTC_AS_DATE).atZone(UTC));
	}

	@Test
	public void isSqlDateWithinDateInsideLimit() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.within(2, ChronoUnit.DAYS, AUG_05_2015_NOON_UTC_AS_DATE).atZone(UTC));
	}

	@Test
	public void isSqlDateWithinDateEqualLimit() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.within(2, ChronoUnit.DAYS, AUG_06_2015_NOON_UTC_AS_DATE).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateWithinDateOutsideLimit() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.within(2, ChronoUnit.DAYS, AUG_07_2015_NOON_UTC_AS_DATE).atZone(UTC));
	}

	@Test
	public void isSqlDateWithinSameLocalDate() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.within(2, ChronoUnit.DAYS, AUG_04_2015).atZone(UTC));
	}

	@Test
	public void isSqlDateWithinLocalDateInsideLimit() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.within(2, ChronoUnit.DAYS, AUG_05_2015).atZone(UTC));
	}

	@Test
	public void isSqlDateWithinLocalDateEqualLimit() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.within(2, ChronoUnit.DAYS, AUG_06_2015).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateWithinLocalDateOutsideLimit() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.within(2, ChronoUnit.DAYS, AUG_07_2015).atZone(UTC));
	}

	@Test
	public void isSqlDateWithinSameDayMonthYear() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 4).atZone(UTC));
	}

	@Test
	public void isSqlDateWithinDayMonthYearInsideLimit() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 5).atZone(UTC));
	}

	@Test
	public void isSqlDateWithinDayMonthYearEqualLimit() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 6).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateWithinDayMonthYearOutsideLimit() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 7).atZone(UTC));
	}
	
	@Test
	public void isSqlDateWithinSameDateUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.within(2, ChronoUnit.DAYS, AUG_04_2015_NOON_UTC_AS_DATE).atZone(UTC));
	}

	@Test
	public void isSqlDateWithinDateInsideLimitUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.within(2, ChronoUnit.DAYS, AUG_05_2015_NOON_UTC_AS_DATE).atZone(UTC));
	}

	@Test
	public void isSqlDateWithinDateEqualLimitUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.within(2, ChronoUnit.DAYS, AUG_06_2015_NOON_UTC_AS_DATE).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateWithinDateOutsideLimitUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.within(2, ChronoUnit.DAYS, AUG_07_2015_NOON_UTC_AS_DATE).atZone(UTC));
	}

	@Test
	public void isSqlDateWithinSameLocalDateUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.within(2, ChronoUnit.DAYS, AUG_04_2015).atZone(UTC));
	}

	@Test
	public void isSqlDateWithinLocalDateInsideLimitUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.within(2, ChronoUnit.DAYS, AUG_05_2015).atZone(UTC));
	}

	@Test
	public void isSqlDateWithinLocalDateEqualLimitUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.within(2, ChronoUnit.DAYS, AUG_06_2015).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateWithinLocalDateOutsideLimitUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.within(2, ChronoUnit.DAYS, AUG_07_2015).atZone(UTC));
	}

	@Test
	public void isSqlDateWithinSameDayMonthYearUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 4).atZone(UTC));
	}

	@Test
	public void isSqlDateWithinDayMonthYearInsideLimitUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 5).atZone(UTC));
	}

	@Test
	public void isSqlDateWithinDayMonthYearEqualLimitUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 6).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateWithinDayMonthYearOutsideLimitUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 7).atZone(UTC));
	}

	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isSqlDateWithinSameDayMonthYearTimeUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL,
				DateMatchers.within(2, ChronoUnit.MILLIS, 2015, Month.AUGUST, 4, 12, 0, 0, 0).atZone(UTC));
	}

	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isSqlDateWithinDayMonthYearTimeInsideLimitUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL,
				DateMatchers.within(2, ChronoUnit.MILLIS, 2015, Month.AUGUST, 4, 12, 0, 0, 1).atZone(UTC));
	}

	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isSqlDateWithinDayMonthYearTimeEqualLimitUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL,
				DateMatchers.within(2, ChronoUnit.MILLIS, 2015, Month.AUGUST, 4, 12, 0, 0, 2).atZone(UTC));
	}

	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isSqlDateWithinDayMonthYearTimeOutsideLimitUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL,
				DateMatchers.within(2, ChronoUnit.MILLIS, 2015, Month.AUGUST, 4, 12, 0, 0, 3).atZone(UTC));
	}
	
	// LocalDate Matchers
	@Test
	public void isLocalDateWithinSameLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.within(2, ChronoUnit.DAYS, AUG_04_2015));
	}

	@Test
	public void isLocalDateWithinLocalDateInsideLimit() {
		assertThat(AUG_04_2015, LocalDateMatchers.within(2, ChronoUnit.DAYS, AUG_05_2015));
	}

	@Test
	public void isLocalDateWithinLocalDateEqualLimit() {
		assertThat(AUG_04_2015, LocalDateMatchers.within(2, ChronoUnit.DAYS, AUG_06_2015));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateWithinLocalDateOutsideLimit() {
		assertThat(AUG_04_2015, LocalDateMatchers.within(2, ChronoUnit.DAYS, AUG_07_2015));
	}

	@Test
	public void isLocalDateWithinSameDayMonthYear() {
		assertThat(AUG_04_2015, LocalDateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 4));
	}

	@Test
	public void isLocalDateWithinDayMonthYearInsideLimit() {
		assertThat(AUG_04_2015, LocalDateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 5));
	}

	@Test
	public void isLocalDateWithinDayMonthYearEqualLimit() {
		assertThat(AUG_04_2015, LocalDateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 6));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateWithinDayMonthYearOutsideLimit() {
		assertThat(AUG_04_2015, LocalDateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 7));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeWithinSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.within(2, ChronoUnit.DAYS, AUG_04_2015_NOON));
	}

	@Test
	public void isLocalDateTimeWithinLocalDateTimeInsideLimit() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.within(2, ChronoUnit.DAYS, AUG_05_2015_NOON));
	}

	@Test
	public void isLocalDateTimeWithinLocalDateTimeEqualLimit() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.within(2, ChronoUnit.DAYS, AUG_06_2015_NOON));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeWithinLocalDateTimeOutsideLimit() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.within(2, ChronoUnit.DAYS, AUG_07_2015_NOON));
	}

	@Test
	public void isLocalDateTimeWithinSameDayMonthYear() {
		assertThat(AUG_04_2015_NOON,
				LocalDateTimeMatchers.within(2, ChronoUnit.NANOS, 2015, Month.AUGUST, 4, 12, 0, 0, 0));
	}

	@Test
	public void isLocalDateTimeWithinDayMonthYearInsideLimit() {
		assertThat(AUG_04_2015_NOON,
				LocalDateTimeMatchers.within(2, ChronoUnit.NANOS, 2015, Month.AUGUST, 4, 12, 0, 0, 1));
	}

	@Test
	public void isLocalDateTimeWithinDayMonthYearEqualLimit() {
		assertThat(AUG_04_2015_NOON,
				LocalDateTimeMatchers.within(2, ChronoUnit.NANOS, 2015, Month.AUGUST, 4, 12, 0, 0, 2));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeWithinDayMonthYearOutsideLimit() {
		assertThat(AUG_04_2015_NOON,
				LocalDateTimeMatchers.within(2, ChronoUnit.NANOS, 2015, Month.AUGUST, 4, 12, 0, 0, 3));
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeWithinSameZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.within(2, ChronoUnit.DAYS, AUG_04_2015_NOON_UTC));
	}

	@Test
	public void isZonedDateTimeWithinZonedDateTimeInsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.within(2, ChronoUnit.DAYS, AUG_05_2015_NOON_UTC));
	}

	@Test
	public void isZonedDateTimeWithinZonedDateTimeEqualLimit() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.within(2, ChronoUnit.DAYS, AUG_06_2015_NOON_UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeWithinZonedDateTimeOutsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.within(2, ChronoUnit.DAYS, AUG_07_2015_NOON_UTC));
	}

	@Test
	public void isZonedDateTimeWithinSameDayMonthYear() {
		assertThat(AUG_04_2015_NOON_UTC,
				ZonedDateTimeMatchers.within(2, ChronoUnit.NANOS, 2015, Month.AUGUST, 4, 12, 0, 0, 0, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeWithinDayMonthYearInsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC,
				ZonedDateTimeMatchers.within(2, ChronoUnit.NANOS, 2015, Month.AUGUST, 4, 12, 0, 0, 1, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeWithinDayMonthYearEqualLimit() {
		assertThat(AUG_04_2015_NOON_UTC,
				ZonedDateTimeMatchers.within(2, ChronoUnit.NANOS, 2015, Month.AUGUST, 4, 12, 0, 0, 2, ZoneIds.UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeWithinDayMonthYearOutsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC,
				ZonedDateTimeMatchers.within(2, ChronoUnit.NANOS, 2015, Month.AUGUST, 4, 12, 0, 0, 3, ZoneIds.UTC));
	}

	// LocalTime Matchers
	@Test
	public void isLocalTimeWithSameLocalTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.within(2, ChronoUnit.SECONDS, LocalTime.NOON));
	}

	@Test
	public void isLocalTimeWithSameLocalTimeInsideLimit() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.within(2, ChronoUnit.SECONDS, LocalTime.NOON.plusSeconds(1)));
	}

	@Test
	public void isLocalTimeWithSameLocalTimeEqualLimit() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.within(2, ChronoUnit.SECONDS, LocalTime.NOON.plusSeconds(2)));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeWithSameLocalTimeOutsideLimit() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.within(2, ChronoUnit.SECONDS, LocalTime.NOON.plusSeconds(3)));
	}

	@Test
	public void isLocalTimeWithSameTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.within(2, ChronoUnit.SECONDS, 12, 0, 0));
	}

	@Test
	public void isLocalTimeWithSameTimeInsideLimit() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.within(2, ChronoUnit.SECONDS, 12, 0, 1));
	}

	@Test
	public void isLocalTimeWithSameTimeEqualLimit() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.within(2, ChronoUnit.SECONDS, 12, 0, 2));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeWithSameTimeOutsideLimit() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.within(2, ChronoUnit.SECONDS, 12, 0, 3));
	}
	
    // OffsetDateTime Matchers
    @Test
    public void isOffsetDateTimeWithinSameOffsetDateTime() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.within(2, ChronoUnit.DAYS, AUG_04_2015_NOON_OFFSET_UTC));
    }

    @Test
    public void isOffsetDateTimeWithinOffsetDateTimeInsideLimit() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.within(2, ChronoUnit.DAYS, AUG_05_2015_NOON_OFFSET_UTC));
    }

    @Test
    public void isOffsetDateTimeWithinOffsetDateTimeEqualLimit() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.within(2, ChronoUnit.DAYS, AUG_06_2015_NOON_OFFSET_UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeWithinOffsetDateTimeOutsideLimit() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.within(2, ChronoUnit.DAYS, AUG_07_2015_NOON_OFFSET_UTC));
    }

    @Test
    public void isOffsetDateTimeWithinSameDayMonthYear() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC,
                OffsetDateTimeMatchers.within(2, ChronoUnit.NANOS, 2015, Month.AUGUST, 4, 12, 0, 0, 0, ZoneOffset.UTC));
    }

    @Test
    public void isOffsetDateTimeWithinDayMonthYearInsideLimit() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC,
                OffsetDateTimeMatchers.within(2, ChronoUnit.NANOS, 2015, Month.AUGUST, 4, 12, 0, 0, 1, ZoneOffset.UTC));
    }

    @Test
    public void isOffsetDateTimeWithinDayMonthYearEqualLimit() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC,
                OffsetDateTimeMatchers.within(2, ChronoUnit.NANOS, 2015, Month.AUGUST, 4, 12, 0, 0, 2, ZoneOffset.UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeWithinDayMonthYearOutsideLimit() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC,
                OffsetDateTimeMatchers.within(2, ChronoUnit.NANOS, 2015, Month.AUGUST, 4, 12, 0, 0, 3, ZoneOffset.UTC));
    }
	
}
