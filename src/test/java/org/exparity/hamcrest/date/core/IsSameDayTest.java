package org.exparity.hamcrest.date.core;

import static java.time.Month.AUGUST;
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
public class IsSameDayTest {

	// Date Matchers

	@Test(expected = AssertionError.class)
	public void isDateSameDayEarlierDate() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameDay(JUN_01_2012_11AM_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameDayLaterDate() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameDay(JUN_01_2012_11AM_AS_DATE));
	}

	@Test
	public void isDateSameDaySameDate() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameDay(JUN_15_2012_11AM_AS_DATE));
	}

	@Test
	public void isDateSameDaySameDateDifferentTimeZone() {
		assertThat(JAN_01_2012_11AM_PST_AS_DATE, DateMatchers.sameDay(JAN_01_2012_11AM_GMT_AS_DATE));
	}

	@Test
	public void isDateSameDayLaterSameDateDifferentTimeZone() {
		assertThat(JAN_01_2012_11AM_GMT_AS_DATE, DateMatchers.sameDay(JAN_01_2012_11AM_PST_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameDayEarlierLocalDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameDay(JUN_14_2012));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameDayLaterLocalDate() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameDay(JUN_16_2012));
	}

	@Test
	public void isDateSameDaySameLocalDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameDay(JUN_15_2012));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameDayEarlierDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameDay(2012, Months.JUNE, 14));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameDayLaterDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameDay(2012, Months.JUNE, 16));
	}

	@Test
	public void isDateSameDaySameDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameDay(2012, Months.JUNE, 15));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameDayEarlierDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameDay(new DayMonthYear(14, Months.JUNE, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameDayLaterDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameDay(new DayMonthYear(16, Months.JUNE, 2012)));
	}

	@Test
	public void isDateSameDaySameDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameDay(new DayMonthYear(15, Months.JUNE, 2012)));
	}

	// LocalDate Matchers

	@Test(expected = AssertionError.class)
	public void isLocalDateSameDayEarlierLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameDay(AUG_03_2015));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateSameDayLaterLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameDay(AUG_05_2015));
	}

	@Test
	public void isLocalDateSameDaySameLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameDay(AUG_04_2015));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateSameDayEarlierDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameDay(AUG_03_2015_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateSameDayLaterDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameDay(AUG_05_2015_AS_DATE));
	}

	@Test
	public void isLocalDateSameDaySameDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameDay(AUG_04_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateSameDayEarlierDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameDay(2015, AUGUST, 3));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateSameDayLaterDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameDay(2015, AUGUST, 5));
	}

	@Test
	public void isLocalDateSameDayLaterSameDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameDay(2015, AUGUST, 4));
	}

	// LocalDateTime Matchers

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeSameDayEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameDay(AUG_03_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeSameDayLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameDay(AUG_05_2015_NOON));
	}

	@Test
	public void isLocalDateTimeSameDaySameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameDay(AUG_04_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeSameDayEarlierDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameDay(AUG_03_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeSameDayLaterDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameDay(AUG_05_2015_NOON_AS_DATE));
	}

	@Test
	public void isLocalDateTimeSameDaySameDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameDay(AUG_04_2015_NOON_AS_DATE));
	}

	// ZonedDateTime Matchers
	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameDayEarlierZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDay(AUG_03_2015_NOON_UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameDayLaterZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDay(AUG_05_2015_NOON_UTC));
	}

	@Test
	public void isZonedDateTimeSameDaySameZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDay(AUG_04_2015_NOON_UTC));
	}

	@Test
	public void isZonedDateTimeSameDayZonedDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDay(AUG_04_2015_NOON_CET));
	}

	@Test
	public void isZonedDateTimeSameDayZonedDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDay(AUG_04_2015_NOON_EST));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameDayEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDay(AUG_03_2015_NOON, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameDayLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDay(AUG_05_2015_NOON, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameDaySameLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDay(AUG_04_2015_NOON, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameDayLocalDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDay(AUG_04_2015_NOON, ZoneIds.CET));
	}

	@Test
	public void isZonedDateTimeSameDayLocalDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDay(AUG_04_2015_NOON, ZoneIds.EST));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameDayEarlierDate() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDay(AUG_03_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameDayLaterDate() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDay(AUG_05_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameDaySameDate() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDay(AUG_04_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameDayDateEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDay(AUG_04_2015_NOON_CET_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameDayDateLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDay(AUG_04_2015_NOON_EST_AS_DATE, ZoneIds.UTC));
	}
}
