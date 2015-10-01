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
	public void isDateBeforeDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(JUN_15_2012_11AM_AS_DATE));
	}

	@Test
	public void isDateNotBeforeDate() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.before(JUN_15_2012_11PM_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateBeforeSameDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(JUN_15_2012_11PM_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateBeforeSameDateDifferentTimeZone() {
		assertThat(JAN_01_2012_11AM_PST_AS_DATE, DateMatchers.before(JAN_01_2012_11AM_GMT_AS_DATE));
	}

	@Test
	public void isDateNotBeforeSameDateDifferentTimeZone() {
		assertThat(JAN_01_2012_11AM_GMT_AS_DATE, DateMatchers.before(JAN_01_2012_11AM_PST_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateBeforeLocalDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(JUN_14_2012));
	}

	@Test
	public void isDateNotBeforeLocalDate() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.before(JUN_16_2012));
	}

	@Test(expected = AssertionError.class)
	public void isDateBeforeSameLocalDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(JUN_15_2012));
	}

	@Test(expected = AssertionError.class)
	public void isDateBeforeDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(2012, Months.JUNE, 14));
	}

	@Test
	public void isDateNotBeforeDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(2012, Months.JUNE, 16));
	}

	@Test(expected = AssertionError.class)
	public void isDateBeforeSameDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(2012, Months.JUNE, 15));
	}

	@Test(expected = AssertionError.class)
	public void isDateBeforeDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(new DayMonthYear(14, Months.JUNE, 2012)));
	}

	@Test
	public void isDateNotBeforeDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(new DayMonthYear(16, Months.JUNE, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void isDateBeforeSameDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.before(new DayMonthYear(15, Months.JUNE, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void isDateBeforeDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.before(2012, Months.JUNE, 15, 10, 59, 59));
	}

	@Test
	public void isDateNotBeforeDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.before(2012, Months.JUNE, 15, 11, 00, 01));
	}

	@Test(expected = AssertionError.class)
	public void isDateBeforeSameDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.before(2012, Months.JUNE, 15, 11, 00, 00));
	}

	// LocalDate Matchers

	@Test(expected = AssertionError.class)
	public void isLocalDateBeforeLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.before(AUG_03_2015));
	}

	@Test
	public void isLocalDateNotBeforeLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.before(AUG_05_2015));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateBeforeSameLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.before(AUG_04_2015));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateBeforeDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.before(AUG_03_2015_AS_DATE));
	}

	@Test
	public void isLocalDateNotBeforeDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.before(AUG_05_2015_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateBeforeSameDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.before(AUG_04_2015_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateBeforeDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.before(2015, AUGUST, 3));
	}

	@Test
	public void isLocalDateNotBeforeDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.before(2015, AUGUST, 5));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotBeforeSameDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.before(2015, AUGUST, 4));
	}

	// LocalDateTime Matchers

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeBeforeLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(AUG_04_2015_1159));
	}

	@Test
	public void isLocalDateTimeNotBeforeLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(AUG_04_2015_1201));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeBeforeSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(AUG_04_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeBeforeDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(AUG_04_2015_1159_AS_DATE));
	}

	@Test
	public void isLocalDateTimeNotBeforeDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(AUG_04_2015_1201_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeBeforeSameDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(AUG_04_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeBeforeDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(2015, AUGUST, 4, 11, 59, 0));
	}

	@Test
	public void isLocalDateTimeNotBeforeDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(2015, AUGUST, 4, 12, 0, 1));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotBeforeSameDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.before(2015, AUGUST, 4, 12, 0, 0));
	}

	// ZonedDateTime Matchers

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeBeforeZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(AUG_04_2015_11AM_UTC));
	}

	@Test
	public void isZonedDateTimeNotBeforeZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(AUG_04_2015_01PM_UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeBeforeSameZonedDateTime() {
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
	public void isZonedDateTimeBeforeLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(AUG_04_2015_1159, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeNotBeforeLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(AUG_04_2015_1201, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeBeforeSameLocalDateTime() {
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
	public void isZonedDateTimeBeforeDate() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(AUG_04_2015_1159_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeNotBeforeDate() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(AUG_04_2015_1201_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeBeforeSameDate() {
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
	public void isZonedDateTimeBeforeDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(2015, AUGUST, 4, 11, 59, 0, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeNotBeforeDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(2015, AUGUST, 4, 12, 0, 1, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotBeforeSameDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(2015, AUGUST, 4, 12, 0, 0, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeBeforeDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(2015, AUGUST, 4, 12, 0, 0, ZoneIds.CET));
	}

	@Test
	public void isZonedDateTimeNotBeforeDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.before(2015, AUGUST, 4, 12, 0, 0, ZoneIds.EST));
	}

}
