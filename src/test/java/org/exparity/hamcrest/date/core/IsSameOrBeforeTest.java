package org.exparity.hamcrest.date.core;

import static java.time.Month.AUGUST;
import static org.exparity.hamcrest.date.ZonedDateTimeMatchers.sameOrBefore;
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
public class IsSameOrBeforeTest {

	// Date Matchers

	@Test(expected = AssertionError.class)
	public void isDateSameOrBeforeLaterDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrBefore(JUN_15_2012_11AM_AS_DATE));
	}

	@Test
	public void isDateSameOrBeforeDate() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrBefore(JUN_15_2012_11PM_AS_DATE));
	}

	@Test
	public void isDateSameOrBeforeSameDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrBefore(JUN_15_2012_11PM_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameOrBeforeDateLaterTimeZone() {
		assertThat(JAN_01_2012_11AM_PST_AS_DATE, DateMatchers.sameOrBefore(JAN_01_2012_11AM_GMT_AS_DATE));
	}

	@Test
	public void isDateSameOrBeforeDateEarlierTimeZone() {
		assertThat(JAN_01_2012_11AM_GMT_AS_DATE, DateMatchers.sameOrBefore(JAN_01_2012_11AM_PST_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameOrBeforeLaterLocalDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrBefore(JUN_14_2012));
	}

	@Test
	public void isDateSameOrBeforeLocalDate() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrBefore(JUN_16_2012));
	}

	@Test
	public void isDateSameOrBeforeSameLocalDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrBefore(JUN_15_2012));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameOrBeforeLaterDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrBefore(2012, Months.JUNE, 14));
	}

	@Test
	public void isDateSameOrBeforeDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrBefore(2012, Months.JUNE, 16));
	}

	@Test
	public void isDateSameOrBeforeSameDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrBefore(2012, Months.JUNE, 15));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameOrBeforeLaterDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrBefore(new DayMonthYear(14, Months.JUNE, 2012)));
	}

	@Test
	public void isDateSameOrBeforeDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrBefore(new DayMonthYear(16, Months.JUNE, 2012)));
	}

	@Test
	public void isDateSameOrBeforeSameDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrBefore(new DayMonthYear(15, Months.JUNE, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameOrBeforeLaterDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrBefore(2012, Months.JUNE, 15, 10, 59, 59));
	}

	@Test
	public void isDateSameOrBeforeDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrBefore(2012, Months.JUNE, 15, 11, 00, 01));
	}

	@Test
	public void isDateSameOrBeforeSameDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrBefore(2012, Months.JUNE, 15, 11, 00, 00));
	}

	// LocalDate Matchers

	@Test(expected = AssertionError.class)
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

	@Test(expected = AssertionError.class)
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

	@Test(expected = AssertionError.class)
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

	@Test(expected = AssertionError.class)
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

	@Test(expected = AssertionError.class)
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

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameOrBeforeZonedDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrBefore(AUG_04_2015_NOON_CET));
	}

	@Test
	public void isZonedDateTimeSameOrBeforeLaterZonedDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrBefore(AUG_04_2015_NOON_EST));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameOrBeforeLaterDateTime() {
		assertThat(
		        AUG_04_2015_NOON_UTC,
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

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameOrBeforeDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.CET));
	}

	@Test
	public void isZonedDateTimeSameOrBeforeDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.EST));
	}

}
