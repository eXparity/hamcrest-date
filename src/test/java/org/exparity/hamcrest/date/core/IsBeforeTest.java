package org.exparity.hamcrest.date.core;

import static java.time.Month.AUGUST;
import static org.exparity.hamcrest.date.ZonedDateTimeMatchers.before;
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
public class IsBeforeTest {

	// Date Matchers

	@Test(expected = AssertionError.class)
	public void isDateBeforeLaterDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(JUN_15_2012_11AM_AS_DATE));
	}

	@Test
	public void isDateBeforeEarlierDate() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.before(JUN_15_2012_11PM_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateBeforeLaterSameDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(JUN_15_2012_11PM_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateBeforeLaterSameDateDifferentTimeZone() {
		assertThat(JAN_01_2012_11AM_PST_AS_DATE, DateMatchers.before(JAN_01_2012_11AM_GMT_AS_DATE));
	}

	@Test
	public void isDateBeforeSameDateDifferentTimeZone() {
		assertThat(JAN_01_2012_11AM_GMT_AS_DATE, DateMatchers.before(JAN_01_2012_11AM_PST_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateBeforeLaterLocalDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(JUN_14_2012));
	}

	@Test
	public void isDateBeforeEarlierLocalDate() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.before(JUN_16_2012));
	}

	@Test(expected = AssertionError.class)
	public void isDateBeforeLaterSameLocalDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(JUN_15_2012));
	}

	@Test(expected = AssertionError.class)
	public void isDateBeforeLaterDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(2012, Months.JUNE, 14));
	}

	@Test
	public void isDateBeforeEarlierDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(2012, Months.JUNE, 16));
	}

	@Test(expected = AssertionError.class)
	public void isDateBeforeLaterSameDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(2012, Months.JUNE, 15));
	}

	@Test(expected = AssertionError.class)
	public void isDateBeforeLaterDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(new DayMonthYear(14, Months.JUNE, 2012)));
	}

	@Test
	public void isDateBeforeEarlierDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(new DayMonthYear(16, Months.JUNE, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void isDateBeforeLaterSameDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(new DayMonthYear(15, Months.JUNE, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void isDateBeforeLaterDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.before(2012, Months.JUNE, 15, 10, 59, 59));
	}

	@Test
	public void isDateBeforeEarlierDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.before(2012, Months.JUNE, 15, 11, 00, 01));
	}

	@Test(expected = AssertionError.class)
	public void isDateBeforeLaterSameDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.before(2012, Months.JUNE, 15, 11, 00, 00));
	}

	// LocalDate Matchers

	@Test(expected = AssertionError.class)
	public void isLocalDateBeforeLaterLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.before(AUG_03_2015));
	}

	@Test
	public void isLocalDateBeforeEarlierLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.before(AUG_05_2015));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateBeforeLaterSameLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.before(AUG_04_2015));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateBeforeLaterDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.before(AUG_03_2015_AS_DATE));
	}

	@Test
	public void isLocalDateBeforeEarlierDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.before(AUG_05_2015_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateBeforeLaterSameDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.before(AUG_04_2015_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateBeforeLaterDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.before(2015, AUGUST, 3));
	}

	@Test
	public void isLocalDateBeforeEarlierDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.before(2015, AUGUST, 5));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateBeforeSameDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.before(2015, AUGUST, 4));
	}

	// LocalDateTime Matchers

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeBeforeLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(AUG_04_2015_1159));
	}

	@Test
	public void isLocalDateTimeBeforeEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(AUG_04_2015_1201));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeBeforeLaterSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(AUG_04_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeBeforeLaterDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(AUG_04_2015_1159_AS_DATE));
	}

	@Test
	public void isLocalDateTimeBeforeEarlierDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(AUG_04_2015_1201_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeBeforeLaterSameDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(AUG_04_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeBeforeLaterDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(2015, AUGUST, 4, 11, 59, 0));
	}

	@Test
	public void isLocalDateTimeBeforeEarlierDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(2015, AUGUST, 4, 12, 0, 1));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeBeforeSameDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(2015, AUGUST, 4, 12, 0, 0));
	}

	// ZonedDateTime Matchers

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeBeforeLaterZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(AUG_04_2015_11AM_UTC));
	}

	@Test
	public void isZonedDateTimeBeforeEarlierZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(AUG_04_2015_01PM_UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeBeforeLaterSameZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(AUG_04_2015_NOON_UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeBeforeZonedDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, before(AUG_04_2015_NOON_CET));
	}

	@Test
	public void isZonedDateTimeBeforeZonedDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, before(AUG_04_2015_NOON_EST));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeBeforeLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(AUG_04_2015_1159, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeBeforeEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(AUG_04_2015_1201, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeBeforeLaterSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(AUG_04_2015_NOON, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeBeforeLocalDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, before(AUG_04_2015_NOON, ZoneIds.CET));
	}

	@Test
	public void isZonedDateTimeBeforeLocalDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, before(AUG_04_2015_NOON, ZoneIds.EST));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeBeforeLaterDate() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(AUG_04_2015_1159_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeBeforeEarlierDate() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(AUG_04_2015_1201_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeBeforeLaterSameDate() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(AUG_04_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeBeforeDateEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(AUG_04_2015_NOON_CET_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeBeforeDateLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(AUG_04_2015_NOON_EST_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeBeforeLaterDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(2015, AUGUST, 4, 11, 59, 0, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeBeforeEarlierDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(2015, AUGUST, 4, 12, 0, 1, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeBeforeSameDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(2015, AUGUST, 4, 12, 0, 0, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeBeforeDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(2015, AUGUST, 4, 12, 0, 0, ZoneIds.CET));
	}

	@Test
	public void isZonedDateTimeBeforeDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(2015, AUGUST, 4, 12, 0, 0, ZoneIds.EST));
	}

}
