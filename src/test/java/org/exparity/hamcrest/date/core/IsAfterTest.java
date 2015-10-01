package org.exparity.hamcrest.date.core;

import static java.time.Month.AUGUST;
import static org.exparity.hamcrest.date.ZonedDateTimeMatchers.after;
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
public class IsAfterTest {

	// Date Matchers

	@Test
	public void isDateAfterDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(JUN_15_2012_11AM_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotAfterDate() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.after(JUN_15_2012_11PM_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateAfterSameDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(JUN_15_2012_11PM_AS_DATE));
	}

	@Test
	public void isDateAfterSameDateDifferentTimeZone() {
		assertThat(JAN_01_2012_11AM_PST_AS_DATE, DateMatchers.after(JAN_01_2012_11AM_GMT_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotAfterSameDateDifferentTimeZone() {
		assertThat(JAN_01_2012_11AM_GMT_AS_DATE, DateMatchers.after(JAN_01_2012_11AM_PST_AS_DATE));
	}

	@Test
	public void isDateAfterLocalDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(JUN_14_2012));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotAfterLocalDate() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.after(JUN_16_2012));
	}

	@Test(expected = AssertionError.class)
	public void isDateAfterSameLocalDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(JUN_15_2012));
	}

	@Test
	public void isDateAfterDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(2012, Months.JUNE, 14));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotAfterDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(2012, Months.JUNE, 16));
	}

	@Test(expected = AssertionError.class)
	public void isDateAfterSameDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(2012, Months.JUNE, 15));
	}

	@Test
	public void isDateAfterDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(new DayMonthYear(14, Months.JUNE, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotAfterDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(new DayMonthYear(16, Months.JUNE, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void isDateAfterSameDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(new DayMonthYear(15, Months.JUNE, 2012)));
	}

	@Test
	public void isDateAfterDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.after(2012, Months.JUNE, 15, 10, 59, 59));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotAfterDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.after(2012, Months.JUNE, 15, 11, 00, 01));
	}

	@Test(expected = AssertionError.class)
	public void isDateAfterSameDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.after(2012, Months.JUNE, 15, 11, 00, 00));
	}

	// LocalDate Matchers

	@Test
	public void isLocalDateAfterLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(AUG_03_2015));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotAfterLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(AUG_05_2015));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateAfterSameLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(AUG_04_2015));
	}

	@Test
	public void isLocalDateAfterDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(AUG_03_2015_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotAfterDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(AUG_05_2015_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateAfterSameDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(AUG_04_2015_AS_DATE));
	}

	@Test
	public void isLocalDateAfterDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(2015, AUGUST, 3));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotAfterDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(2015, AUGUST, 5));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotAfterSameDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(2015, AUGUST, 4));
	}

	// LocalDateTime Matchers

	@Test
	public void isLocalDateTimeAfterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(AUG_04_2015_1159));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotAfterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(AUG_04_2015_1201));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeAfterSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(AUG_04_2015_NOON));
	}

	@Test
	public void isLocalDateTimeAfterDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(AUG_04_2015_1159_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotAfterDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(AUG_04_2015_1201_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeAfterSameDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(AUG_04_2015_NOON_AS_DATE));
	}

	@Test
	public void isLocalDateTimeAfterDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(2015, AUGUST, 4, 11, 59, 0));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotAfterDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 1));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotAfterSameDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 0));
	}

	// ZonedDateTime Matchers

	@Test
	public void isZonedDateTimeAfterZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_11AM_UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotAfterZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_01PM_UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeAfterSameZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_NOON_UTC));
	}

	@Test
	public void isZonedDateTimeAfterZonedDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, after(AUG_04_2015_NOON_CET));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeAfterZonedDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, after(AUG_04_2015_NOON_EST));
	}

	@Test
	public void isZonedDateTimeAfterLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_1159, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotAfterLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_1201, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeAfterSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_NOON, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeAfterLocalDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, after(AUG_04_2015_NOON, ZoneIds.CET));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeAfterLocalDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, after(AUG_04_2015_NOON, ZoneIds.EST));
	}

	@Test
	public void isZonedDateTimeAfterDate() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_1159_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotAfterDate() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_1201_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeAfterSameDate() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeAfterDateEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_NOON_CET_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeAfterDateLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_NOON_EST_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeAfterDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(2015, AUGUST, 4, 11, 59, 0, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotAfterDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 1, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotAfterSameDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 0, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeAfterDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 0, ZoneIds.CET));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotAfterDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 0, ZoneIds.EST));
	}
}
