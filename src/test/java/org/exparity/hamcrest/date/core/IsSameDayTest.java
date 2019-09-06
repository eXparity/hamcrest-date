package org.exparity.hamcrest.date.core;

import static java.time.Month.AUGUST;
import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.exparity.hamcrest.date.testutils.ZoneIds.UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.DayMonthYear;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
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
public class IsSameDayTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the same day as (?s:.)+?\\s     but: the day is (?s:.)+";

	// Date Matchers

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameDayEarlierDate() {
		assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.sameDay(JUN_01_2012_11AM_UTC_AS_DATE).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameDayLaterDate() {
		assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.sameDay(JUN_01_2012_11AM_UTC_AS_DATE).atZone(UTC));
	}

	@Test
	public void isDateSameDaySameDate() {
		assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.sameDay(JUN_15_2012_11AM_UTC_AS_DATE).atZone(UTC));
	}

	@Test
	public void isDateSameDaySameDateDifferentTimeZone() {
		assertThat(JAN_01_2012_11AM_PST_AS_DATE, DateMatchers.sameDay(JAN_01_2012_11AM_GMT_AS_DATE).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameDayMidnightLocallyDifferentTimeZoneLowerOffsetPerspective() {
		assertThat(JAN_01_2012_MIDNIGHT_GMT_AS_DATE, DateMatchers.sameDay(JAN_01_2012_MIDNIGHT_CET_AS_DATE).atZone(ZoneIds.GMT));
	}

	@Test
	public void isDateSameDayMidnightLocallyDifferentTimeZoneHigherOffsetPerspective() {
		assertThat(JAN_01_2012_MIDNIGHT_GMT_AS_DATE, DateMatchers.sameDay(JAN_01_2012_MIDNIGHT_CET_AS_DATE).atZone(ZoneIds.CET));
	}

	@Test
	public void isDateSameDayLaterSameDateDifferentTimeZone() {
		assertThat(JAN_01_2012_11AM_GMT_AS_DATE, DateMatchers.sameDay(JAN_01_2012_11AM_PST_AS_DATE).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameDayEarlierLocalDate() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameDay(JUN_14_2012).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameDayLaterLocalDate() {
		assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.sameDay(JUN_16_2012).atZone(UTC));
	}

	@Test
	public void isDateSameDaySameLocalDate() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameDay(JUN_15_2012).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameDayEarlierDay() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameDay(2012, Months.JUNE, 14).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameDayLaterDay() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameDay(2012, Months.JUNE, 16).atZone(UTC));
	}

	@Test
	public void isDateSameDaySameDay() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameDay(2012, Months.JUNE, 15).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameDayEarlierDayMonthYear() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameDay(new DayMonthYear(14, Months.JUNE, 2012)).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameDayLaterDayMonthYear() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameDay(new DayMonthYear(16, Months.JUNE, 2012)).atZone(UTC));
	}

	@Test
	public void isDateSameDaySameDayMonthYear() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameDay(new DayMonthYear(15, Months.JUNE, 2012)).atZone(UTC));
	}

	// java.sql.Date Matchers

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateSameDayEarlierLocalDate() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameDay(AUG_03_2015_NOON_UTC_AS_DATE));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateSameDayLaterLocalDate() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameDay(AUG_05_2015_NOON_UTC_AS_DATE));
	}

	@Test
	public void isSqlDateSameDaySameLocalDate() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameDay(AUG_04_2015_NOON_UTC_AS_DATE));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateSameDayEarlierDay() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.isDay(2015, AUGUST, 3));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateSameDayLaterDay() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.isDay(2015, AUGUST, 5));
	}

	@Test
	public void isSqlDateSameDaySameDay() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.isDay(2015, AUGUST, 4));
	}
	
	// LocalDate Matchers

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateSameDayEarlierLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameDay(AUG_03_2015));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateSameDayLaterLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameDay(AUG_05_2015));
	}

	@Test
	public void isLocalDateSameDaySameLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameDay(AUG_04_2015));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateSameDayEarlierDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.isDay(2015, AUGUST, 3));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateSameDayLaterDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.isDay(2015, AUGUST, 5));
	}

	@Test
	public void isLocalDateSameDaySameDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.isDay(2015, AUGUST, 4));
	}

	// LocalDateTime Matchers

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameDayEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameDay(AUG_03_2015_NOON));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameDayLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameDay(AUG_05_2015_NOON));
	}

	@Test
	public void isLocalDateTimeSameDaySameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameDay(AUG_04_2015_NOON));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameDayEarlierDay() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isDay(2015, AUGUST, 3));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameDayLaterDay() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isDay(2015, AUGUST, 5));
	}

	@Test
	public void isLocalDateTimeSameDayLaterSameDay() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isDay(2015, AUGUST, 4));
	}

	// ZonedDateTime Matchers
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeSameDayEarlierZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDay(AUG_03_2015_NOON_UTC).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeSameDayLaterZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDay(AUG_05_2015_NOON_UTC).atZone(UTC));
	}

	@Test
	public void isZonedDateTimeSameDaySameZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDay(AUG_04_2015_NOON_UTC).atZone(UTC));
	}

	@Test
	public void isZonedDateTimeSameDayZonedDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDay(AUG_04_2015_NOON_CET).atZone(UTC));
	}

	@Test
	public void isZonedDateTimeSameDayZonedDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDay(AUG_04_2015_NOON_EST).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeSameDayEarlierDay() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isDay(2015, AUGUST, 3, UTC).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeSameDayLaterDay() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isDay(2015, AUGUST, 5, UTC).atZone(UTC));
	}

	@Test
	public void isZonedDateTimeSameDayLaterSameDay() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isDay(2015, AUGUST, 4, UTC).atZone(UTC));
	}

}
