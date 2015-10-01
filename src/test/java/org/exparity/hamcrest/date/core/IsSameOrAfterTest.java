package org.exparity.hamcrest.date.core;

import static java.time.Month.AUGUST;
import static org.exparity.hamcrest.date.ZonedDateTimeMatchers.sameOrAfter;
import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.DayMonthYear;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.Months;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.exparity.hamcrest.date.testutils.ZoneIds;
import org.junit.Test;

/**
 * Unit Tests for the {@link DateMatchers} class
 *
 * @author Stewart Bissett
 */
public class IsSameOrAfterTest {

	// Date Matchers

	@Test
	public void isDateSameOrAfterDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter(JUN_15_2012_11AM_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotSameOrAfterDate() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrAfter(JUN_15_2012_11PM_AS_DATE));
	}

	@Test
	public void isDateSameOrAfterSameDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter(JUN_15_2012_11PM_AS_DATE));
	}

	@Test
	public void isDateSameOrAfterSameDateEarlierZone() {
		assertThat(JAN_01_2012_11AM_PST_AS_DATE, DateMatchers.sameOrAfter(JAN_01_2012_11AM_GMT_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameOrAfterSameDateLaterZone() {
		assertThat(JAN_01_2012_11AM_GMT_AS_DATE, DateMatchers.sameOrAfter(JAN_01_2012_11AM_PST_AS_DATE));
	}

	@Test
	public void isDateSameOrAfterLocalDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter(JUN_14_2012));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotSameOrAfterLocalDate() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrAfter(JUN_16_2012));
	}

	@Test
	public void isDateSameOrAfterSameLocalDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter(JUN_15_2012));
	}

	@Test
	public void isDateSameOrAfterDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter(2012, Months.JUNE, 14));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotSameOrAfterDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter(2012, Months.JUNE, 16));
	}

	@Test
	public void isDateSameOrAfterSameDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter(2012, Months.JUNE, 15));
	}

	@Test
	public void isDateSameOrAfterDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter(new DayMonthYear(14, Months.JUNE, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotSameOrAfterDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter(new DayMonthYear(16, Months.JUNE, 2012)));
	}

	@Test
	public void isDateSameOrAfterSameDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter(new DayMonthYear(15, Months.JUNE, 2012)));
	}

	@Test
	public void isDateSameOrAfterDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrAfter(2012, Months.JUNE, 15, 10, 59, 59));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotSameOrAfterDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrAfter(2012, Months.JUNE, 15, 11, 00, 01));
	}

	@Test
	public void isDateSameOrAfterSameDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrAfter(2012, Months.JUNE, 15, 11, 00, 00));
	}

	// LocalDate Matchers

	@Test
	public void isLocalDateSameOrAfterLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrAfter(AUG_03_2015));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotSameOrAfterLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrAfter(AUG_05_2015));
	}

	@Test
	public void isLocalDateSameOrAfterSameLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrAfter(AUG_04_2015));
	}

	@Test
	public void isLocalDateSameOrAfterDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrAfter(AUG_03_2015_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotSameOrAfterDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrAfter(AUG_05_2015_AS_DATE));
	}

	@Test
	public void isLocalDateSameOrAfterSameDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrAfter(AUG_04_2015_AS_DATE));
	}

	@Test
	public void isLocalDateSameOrAfterDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrAfter(2015, AUGUST, 3));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotSameOrAfterDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrAfter(2015, AUGUST, 5));
	}

	@Test
	public void isLocalDateNotSameOrAfterSameDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrAfter(2015, AUGUST, 4));
	}

	// LocalDateTime Matchers

	@Test
	public void isLocalDateTimeSameOrAfterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrAfter(AUG_04_2015_1159));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotSameOrAfterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrAfter(AUG_04_2015_1201));
	}

	@Test
	public void isLocalDateTimeSameOrAfterSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrAfter(AUG_04_2015_NOON));
	}

	@Test
	public void isLocalDateTimeSameOrAfterDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrAfter(AUG_04_2015_1159_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotSameOrAfterDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrAfter(AUG_04_2015_1201_AS_DATE));
	}

	@Test
	public void isLocalDateTimeSameOrAfterSameDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrAfter(AUG_04_2015_NOON_AS_DATE));
	}

	@Test
	public void isLocalDateTimeSameOrAfterDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 11, 59, 0));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotSameOrAfterDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 12, 0, 1));
	}

	@Test
	public void isLocalDateTimeNotSameOrAfterSameDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 12, 0, 0));
	}

	// ZonedDateTime Matchers

	@Test
	public void isZonedDateTimeSameOrAfterZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(AUG_04_2015_11AM_UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotSameOrAfterZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(AUG_04_2015_01PM_UTC));
	}

	@Test
	public void isZonedDateTimeSameOrAfterSameZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(AUG_04_2015_NOON_UTC));
	}

	@Test
	public void isZonedDateTimeSameOrAfterZonedDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrAfter(AUG_04_2015_NOON_CET));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameOrAfterZonedDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrAfter(AUG_04_2015_NOON_EST));
	}

	@Test
	public void isZonedDateTimeSameOrAfterLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(AUG_04_2015_1159, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotSameOrAfterLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(AUG_04_2015_1201, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameOrAfterSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(AUG_04_2015_NOON, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameOrAfterLocalDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrAfter(AUG_04_2015_NOON, ZoneIds.CET));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameOrAfterLocalDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrAfter(AUG_04_2015_NOON, ZoneIds.EST));
	}

	@Test
	public void isZonedDateTimeSameOrAfterDate() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(AUG_04_2015_1159_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotSameOrAfterDate() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(AUG_04_2015_1201_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameOrAfterSameDate() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(AUG_04_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameOrAfterDateEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(AUG_04_2015_NOON_CET_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameOrAfterDateLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(AUG_04_2015_NOON_EST_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameOrAfterDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 11, 59, 0, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotSameOrAfterDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 12, 0, 1, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeNotSameOrAfterSameDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 12, 0, 0, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameOrAfterDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 12, 0, 0, ZoneIds.CET));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotSameOrAfterDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 12, 0, 0, ZoneIds.EST));
	}
}
