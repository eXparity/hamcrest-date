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
	public void isDateSameOrAfterEarlierDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter(JUN_15_2012_11AM_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameOrAfterLaterDate() {
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
	public void isDateSameOrAfterEarlierLocalDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter(JUN_14_2012));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameOrAfterLaterLocalDate() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrAfter(JUN_16_2012));
	}

	@Test
	public void isDateSameOrAfterSameLocalDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter(JUN_15_2012));
	}

	@Test
	public void isDateSameOrAfterEarlierDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter(2012, Months.JUNE, 14));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameOrAfterLaterDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter(2012, Months.JUNE, 16));
	}

	@Test
	public void isDateSameOrAfterSameDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter(2012, Months.JUNE, 15));
	}

	@Test
	public void isDateSameOrAfterEarlierDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter(new DayMonthYear(14, Months.JUNE, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameOrAfterLaterDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter(new DayMonthYear(16, Months.JUNE, 2012)));
	}

	@Test
	public void isDateSameOrAfterSameDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter(new DayMonthYear(15, Months.JUNE, 2012)));
	}

	@Test
	public void isDateSameOrAfterEarlierDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrAfter(2012, Months.JUNE, 15, 10, 59, 59));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameOrAfterLaterDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrAfter(2012, Months.JUNE, 15, 11, 00, 01));
	}

	@Test
	public void isDateSameOrAfterSameDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrAfter(2012, Months.JUNE, 15, 11, 00, 00));
	}

	// LocalDate Matchers

	@Test
	public void isLocalDateSameOrAfterEarlierLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrAfter(AUG_03_2015));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateSameOrAfterLaterLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrAfter(AUG_05_2015));
	}

	@Test
	public void isLocalDateSameOrAfterSameLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrAfter(AUG_04_2015));
	}

	@Test
	public void isLocalDateSameOrAfterEarlierDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrAfter(2015, AUGUST, 3));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateSameOrAfterLaterDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrAfter(2015, AUGUST, 5));
	}

	@Test
	public void isLocalDateSameOrAfterSameDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrAfter(2015, AUGUST, 4));
	}

	// LocalDateTime Matchers

	@Test
	public void isLocalDateTimeSameOrAfterEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrAfter(AUG_04_2015_1159));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeSameOrAfterLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrAfter(AUG_04_2015_1201));
	}

	@Test
	public void isLocalDateTimeSameOrAfterSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrAfter(AUG_04_2015_NOON));
	}

	@Test
	public void isLocalDateTimeSameOrAfterEarlierDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 11, 59, 0));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeSameOrAfterLaterDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 12, 0, 1));
	}

	@Test
	public void isLocalDateTimeSameOrAfterSameDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 12, 0, 0));
	}

	// ZonedDateTime Matchers

	@Test
	public void isZonedDateTimeSameOrAfterEarlierZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(AUG_04_2015_11AM_UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameOrAfterLaterZonedDateTime() {
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
	public void isZonedDateTimeSameOrAfterEarlierDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 11, 59, 0, 0, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameOrAfterLaterDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 12, 0, 1, 0, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameOrAfterSameDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameOrAfterDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.CET));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameOrAfterDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.EST));
	}
}
