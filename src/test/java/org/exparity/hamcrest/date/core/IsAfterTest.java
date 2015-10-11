package org.exparity.hamcrest.date.core;

import static java.time.Month.AUGUST;
import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.Month;

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
	public void isDateAfterEarlierDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(JUN_15_2012_11AM_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateAfterLaterDate() {
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
	public void isDateAfterLaterSameDateDifferentTimeZone() {
		assertThat(JAN_01_2012_11AM_GMT_AS_DATE, DateMatchers.after(JAN_01_2012_11AM_PST_AS_DATE));
	}

	@Test
	public void isDateAfterEarlierLocalDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(JUN_14_2012));
	}

	@Test(expected = AssertionError.class)
	public void isDateAfterLaterLocalDate() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.after(JUN_16_2012));
	}

	@Test(expected = AssertionError.class)
	public void isDateAfterSameLocalDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(JUN_15_2012));
	}

	@Test
	public void isDateAfterEarlierDeprecatedDateValues() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(2012, Months.JUNE, 14));
	}

	@Test(expected = AssertionError.class)
	public void isDateAfterLaterDeprecatedDateValues() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(2012, Months.JUNE, 16));
	}

	@Test(expected = AssertionError.class)
	public void isDateAfterSameDeprecatedDateValues() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(2012, Months.JUNE, 15));
	}

	@Test
	public void isDateAfterEarlierDateValues() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(2012, Month.JUNE, 14));
	}

	@Test(expected = AssertionError.class)
	public void isDateAfterLaterDateValues() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(2012, Month.JUNE, 16));
	}

	@Test(expected = AssertionError.class)
	public void isDateAfterSameDateValues() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(2012, Month.JUNE, 15));
	}

	@Test
	public void isDateAfterEarlierDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(new DayMonthYear(14, Months.JUNE, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void isDateAfterLaterDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(new DayMonthYear(16, Months.JUNE, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void isDateAfterSameDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(new DayMonthYear(15, Months.JUNE, 2012)));
	}

	@Test
	public void isDateAfterEarlierDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.after(2012, Months.JUNE, 15, 10, 59, 59));
	}

	@Test(expected = AssertionError.class)
	public void isDateAfterLaterDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.after(2012, Months.JUNE, 15, 11, 00, 01));
	}

	@Test(expected = AssertionError.class)
	public void isDateAfterSameDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.after(2012, Months.JUNE, 15, 11, 00, 00));
	}

	// LocalDate Matchers

	@Test
	public void isLocalDateAfterEarlierLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(AUG_03_2015));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateAfterLaterLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(AUG_05_2015));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateAfterSameLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(AUG_04_2015));
	}

	@Test
	public void isLocalDateAfterEarlierDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(AUG_03_2015_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateAfterLaterDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(AUG_05_2015_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateAfterSameDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(AUG_04_2015_NOON_AS_DATE));
	}

	@Test
	public void isLocalDateAfterEarlierDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(2015, AUGUST, 3));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateAfterLaterDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(2015, AUGUST, 5));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateAfterLaterSameDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(2015, AUGUST, 4));
	}

	// LocalDateTime Matchers

	@Test
	public void isLocalDateTimeAfterEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(AUG_04_2015_1159));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeAfterLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(AUG_04_2015_1201));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeAfterSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(AUG_04_2015_NOON));
	}

	@Test
	public void isLocalDateTimeAfterEarlierDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(AUG_04_2015_1159_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeAfterLaterDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(AUG_04_2015_1201_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeAfterSameDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(AUG_04_2015_NOON_AS_DATE));
	}

	@Test
	public void isLocalDateTimeAfterEarlierDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(2015, AUGUST, 4, 11, 59, 0));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeAfterLaterDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 1));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeAfterLaterSameDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 0));
	}

	// ZonedDateTime Matchers

	@Test
	public void isZonedDateTimeAfterEarlierZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_11AM_UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeAfterLaterZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_01PM_UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeAfterSameZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_NOON_UTC));
	}

	@Test
	public void isZonedDateTimeAfterZonedDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_NOON_CET));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeAfterZonedDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_NOON_EST));
	}

	@Test
	public void isZonedDateTimeAfterEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_1159, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeAfterLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_1201, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeAfterSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_NOON, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeAfterLocalDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_NOON, ZoneIds.CET));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeAfterLocalDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_NOON, ZoneIds.EST));
	}

	@Test
	public void isZonedDateTimeAfterEarlierDate() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_1159_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeAfterLaterDate() {
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
	public void isZonedDateTimeAfterEarlierDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(2015, AUGUST, 4, 11, 59, 0, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeAfterLaterDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 1, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeAfterLaterSameDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 0, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeAfterDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 0, ZoneIds.CET));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeAfterDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 0, ZoneIds.EST));
	}
}
