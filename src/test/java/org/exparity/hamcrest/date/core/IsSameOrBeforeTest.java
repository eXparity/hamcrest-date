package org.exparity.hamcrest.date.core;

import static java.time.Month.AUGUST;
import static org.exparity.hamcrest.date.ZonedDateTimeMatchers.sameOrBefore;
import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.exparity.hamcrest.date.testutils.ZoneIds.UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalTime;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.DayMonthYear;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.LocalTimeMatchers;
import org.exparity.hamcrest.date.Months;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.exparity.hamcrest.date.testutils.ZoneIds;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link DateMatchers} class
 *
 * @author Stewart Bissett
 */
@SuppressWarnings("deprecation")
public class IsSameOrBeforeTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is on the same date or before (?s:.)+?\\s     but: the date is (?s:.)+";

	// Date Matchers

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameOrBeforeLaterTimeOnSameDay() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameOrBefore(JUN_15_2012_11AM_UTC_AS_DATE).atZone(UTC));
	}

	@Test
	public void isDateSameOrBeforeDate() {
		assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.sameOrBefore(JUN_15_2012_11PM_UTC_AS_DATE).atZone(UTC));
	}

	@Test
	public void isDateSameOrBeforeSameDate() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameOrBefore(JUN_15_2012_11PM_UTC_AS_DATE).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameOrBeforeDateLaterTimeZone() {
		assertThat(JAN_01_2012_11AM_PST_AS_DATE, DateMatchers.sameOrBefore(JAN_01_2012_11AM_GMT_AS_DATE).atZone(UTC));
	}

	@Test
	public void isDateSameOrBeforeDateEarlierTimeZone() {
		assertThat(JAN_01_2012_11AM_GMT_AS_DATE, DateMatchers.sameOrBefore(JAN_01_2012_11AM_PST_AS_DATE).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameOrBeforeLaterLocalDate() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameOrBefore(JUN_14_2012).atZone(UTC));
	}

	@Test
	public void isDateSameOrBeforeLocalDate() {
		assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.sameOrBefore(JUN_16_2012).atZone(UTC));
	}

	@Test
	public void isDateSameOrBeforeSameLocalDate() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameOrBefore(JUN_15_2012).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameOrBeforeLaterDay() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameOrBefore(2012, Months.JUNE, 14).atZone(UTC));
	}

	@Test
	public void isDateSameOrBeforeDay() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameOrBefore(2012, Months.JUNE, 16).atZone(UTC));
	}

	@Test
	public void isDateSameOrBeforeSameDay() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameOrBefore(2012, Months.JUNE, 15).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameOrBeforeLaterDayMonthYear() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameOrBefore(new DayMonthYear(14, Months.JUNE, 2012)).atZone(UTC));
	}

	@Test
	public void isDateSameOrBeforeDayMonthYear() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameOrBefore(new DayMonthYear(16, Months.JUNE, 2012)).atZone(UTC));
	}

	@Test
	public void isDateSameOrBeforeSameDayMonthYear() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameOrBefore(new DayMonthYear(15, Months.JUNE, 2012)).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameOrBeforeLaterDateTime() {
		assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.sameOrBefore(2012, Months.JUNE, 15, 10, 59, 59).atZone(UTC));
	}

	@Test
	public void isDateSameOrBeforeDateTime() {
		assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.sameOrBefore(2012, Months.JUNE, 15, 11, 0, 1).atZone(UTC));
	}

	@Test
	public void isDateSameOrBeforeSameDateTime() {
		assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.sameOrBefore(2012, Months.JUNE, 15, 11, 0, 0).atZone(UTC));
	}

	// java.sql.Date Matchers

	@Test
	public void isSqlDateSameOrBeforeLaterDate() {
		assertThat(JUN_15_2012_AS_SQL, DateMatchers.sameOrBefore(JUN_16_2012_11PM_UTC_AS_DATE).atZone(UTC));
	}

	@Test
	public void isSqlDateSameOrBeforeDate() {
		assertThat(JUN_15_2012_AS_SQL, DateMatchers.sameOrBefore(JUN_15_2012_11PM_UTC_AS_DATE).atZone(UTC));
	}

	@Test
	public void isSqlDateSameOrBeforeSameDate() {
		assertThat(JUN_15_2012_AS_SQL, DateMatchers.sameOrBefore(JUN_15_2012_11PM_UTC_AS_DATE).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateSameOrBeforeLaterLocalDate() {
		assertThat(JUN_15_2012_AS_SQL, DateMatchers.sameOrBefore(JUN_14_2012).atZone(UTC));
	}

	@Test
	public void isSqlDateSameOrBeforeLocalDate() {
		assertThat(JUN_15_2012_AS_SQL, DateMatchers.sameOrBefore(JUN_16_2012).atZone(UTC));
	}

	@Test
	public void isSqlDateSameOrBeforeSameLocalDate() {
		assertThat(JUN_15_2012_AS_SQL, DateMatchers.sameOrBefore(JUN_15_2012).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateSameOrBeforeLaterDay() {
		assertThat(JUN_15_2012_AS_SQL, DateMatchers.sameOrBefore(2012, Months.JUNE, 14).atZone(UTC));
	}

	@Test
	public void isSqlDateSameOrBeforeDay() {
		assertThat(JUN_15_2012_AS_SQL, DateMatchers.sameOrBefore(2012, Months.JUNE, 16).atZone(UTC));
	}

	@Test
	public void isSqlDateSameOrBeforeSameDay() {
		assertThat(JUN_15_2012_AS_SQL, DateMatchers.sameOrBefore(2012, Months.JUNE, 15).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateSameOrBeforeLaterDayMonthYear() {
		assertThat(JUN_15_2012_AS_SQL, DateMatchers.sameOrBefore(new DayMonthYear(14, Months.JUNE, 2012)).atZone(UTC));
	}

	@Test
	public void isSqlDateSameOrBeforeDayMonthYear() {
		assertThat(JUN_15_2012_AS_SQL, DateMatchers.sameOrBefore(new DayMonthYear(16, Months.JUNE, 2012)).atZone(UTC));
	}

	@Test
	public void isSqlDateSameOrBeforeSameDayMonthYear() {
		assertThat(JUN_15_2012_AS_SQL, DateMatchers.sameOrBefore(new DayMonthYear(15, Months.JUNE, 2012)).atZone(UTC));
	}

	@Test
	public void isSqlDateSameOrBeforeLaterDateTimeOnSameDay() {
		assertThat(JUN_15_2012_AS_SQL, DateMatchers.sameOrBefore(2012, Months.JUNE, 15, 10, 59, 59).atZone(UTC));
	}

	@Test
	public void isSqlDateSameOrBeforeDateTime() {
		assertThat(JUN_15_2012_AS_SQL, DateMatchers.sameOrBefore(2012, Months.JUNE, 15, 11, 0, 1).atZone(UTC));
	}

	@Test
	public void isSqlDateSameOrBeforeSameDateTime() {
		assertThat(JUN_15_2012_AS_SQL, DateMatchers.sameOrBefore(2012, Months.JUNE, 15, 11, 0, 0).atZone(UTC));
	}
	
	// LocalDate Matchers

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateSameOrBeforeLaterLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrBefore(AUG_03_2015));
	}

	@Test
	public void isLocalDateSameOrBeforeLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrBefore(AUG_05_2015));
	}

	@Test
	public void isLocalDateSameOrBeforeSameLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrBefore(AUG_04_2015));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateSameOrBeforeLaterDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrBefore(2015, AUGUST, 3));
	}

	@Test
	public void isLocalDateSameOrBeforeDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrBefore(2015, AUGUST, 5));
	}

	@Test
	public void isLocalDateSameOrBeforeSameDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrBefore(2015, AUGUST, 4));
	}

	// LocalDateTime Matchers

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameOrBeforeLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrBefore(AUG_04_2015_1159));
	}

	@Test
	public void isLocalDateTimeSameOrBeforeLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrBefore(AUG_04_2015_1201));
	}

	@Test
	public void isLocalDateTimeSameOrBeforeSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrBefore(AUG_04_2015_NOON));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameOrBeforeLaterDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 11, 59, 0));
	}

	@Test
	public void isLocalDateTimeSameOrBeforeDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 12, 0, 1));
	}

	@Test
	public void isLocalDateTimeSameOrBeforeSameDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 12, 0, 0));
	}

	// ZonedDateTime Matchers

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeSameOrBeforeLaterZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(AUG_04_2015_11AM_UTC));
	}

	@Test
	public void isZonedDateTimeSameOrBeforeZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(AUG_04_2015_01PM_UTC));
	}

	@Test
	public void isZonedDateTimeSameOrBeforeSameZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(AUG_04_2015_NOON_UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeSameOrBeforeZonedDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrBefore(AUG_04_2015_NOON_CET));
	}

	@Test
	public void isZonedDateTimeSameOrBeforeLaterZonedDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrBefore(AUG_04_2015_NOON_EST));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeSameOrBeforeLaterDateTime() {
		assertThat(AUG_04_2015_NOON_UTC,
				ZonedDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 11, 59, 0, 0, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameOrBeforeDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 12, 0, 1, 0, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameOrBeforeSameDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeSameOrBeforeDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.CET));
	}

	@Test
	public void isZonedDateTimeSameOrBeforeDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.EST));
	}

	// LocalTime Matchers

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeSameOrBeforeEarlierLocalTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.sameOrBefore(LocalTime.NOON.minusSeconds(1)));
	}

	@Test
	public void isLocalTimeSameOrBeforeSameLocalTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.sameOrBefore(LocalTime.NOON));
	}

	@Test
	public void isLocalTimeSameOrBeforeLaterLocalTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.sameOrBefore(LocalTime.NOON.plusSeconds(1)));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeSameOrBeforeEarlierTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.sameOrBefore(11, 59, 59));
	}

	@Test
	public void isLocalTimeSameOrBeforeSameTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.sameOrBefore(12, 0, 0));
	}

	@Test
	public void isLocalTimeSameOrBeforeLaterTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.sameOrBefore(12, 0, 1));
	}
}
