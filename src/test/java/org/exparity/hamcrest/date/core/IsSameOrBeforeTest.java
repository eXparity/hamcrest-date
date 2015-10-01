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
	public void isDateSameOrBeforeDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrBefore(JUN_15_2012_11AM_AS_DATE));
	}

	@Test
	public void isDateNotSameOrBeforeDate() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrBefore(JUN_15_2012_11PM_AS_DATE));
	}

	@Test
	public void isDateSameOrBeforeSameDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrBefore(JUN_15_2012_11PM_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameOrBeforeSameDateDifferentTimeZone() {
		assertThat(JAN_01_2012_11AM_PST_AS_DATE, DateMatchers.sameOrBefore(JAN_01_2012_11AM_GMT_AS_DATE));
	}

	@Test
	public void isDateNotSameOrBeforeSameDateDifferentTimeZone() {
		assertThat(JAN_01_2012_11AM_GMT_AS_DATE, DateMatchers.sameOrBefore(JAN_01_2012_11AM_PST_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameOrBeforeLocalDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrBefore(JUN_14_2012));
	}

	@Test
	public void isDateNotSameOrBeforeLocalDate() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrBefore(JUN_16_2012));
	}

	@Test
	public void isDateSameOrBeforeSameLocalDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrBefore(JUN_15_2012));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameOrBeforeDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrBefore(2012, Months.JUNE, 14));
	}

	@Test
	public void isDateNotSameOrBeforeDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrBefore(2012, Months.JUNE, 16));
	}

	@Test
	public void isDateSameOrBeforeSameDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrBefore(2012, Months.JUNE, 15));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameOrBeforeDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrBefore(new DayMonthYear(14, Months.JUNE, 2012)));
	}

	@Test
	public void isDateNotSameOrBeforeDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrBefore(new DayMonthYear(16, Months.JUNE, 2012)));
	}

	@Test
	public void isDateSameOrBeforeSameDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrBefore(new DayMonthYear(15, Months.JUNE, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameOrBeforeDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrBefore(2012, Months.JUNE, 15, 10, 59, 59));
	}

	@Test
	public void isDateNotSameOrBeforeDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrBefore(2012, Months.JUNE, 15, 11, 00, 01));
	}

	@Test
	public void isDateSameOrBeforeSameDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrBefore(2012, Months.JUNE, 15, 11, 00, 00));
	}

	// LocalDate Matchers

	@Test(expected = AssertionError.class)
	public void isLocalDateSameOrBeforeLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrBefore(AUG_03_2015));
	}

	@Test
	public void isLocalDateNotSameOrBeforeLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrBefore(AUG_05_2015));
	}

	@Test
	public void isLocalDateSameOrBeforeSameLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrBefore(AUG_04_2015));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateSameOrBeforeDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrBefore(AUG_03_2015_AS_DATE));
	}

	@Test
	public void isLocalDateNotSameOrBeforeDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrBefore(AUG_05_2015_AS_DATE));
	}

	@Test
	public void isLocalDateSameOrBeforeSameDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrBefore(AUG_04_2015_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateSameOrBeforeDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrBefore(2015, AUGUST, 3));
	}

	@Test
	public void isLocalDateNotSameOrBeforeDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrBefore(2015, AUGUST, 5));
	}

	@Test
	public void isLocalDateNotSameOrBeforeSameDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrBefore(2015, AUGUST, 4));
	}

	// LocalDateTime Matchers

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeSameOrBeforeLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrBefore(AUG_04_2015_1159));
	}

	@Test
	public void isLocalDateTimeNotSameOrBeforeLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrBefore(AUG_04_2015_1201));
	}

	@Test
	public void isLocalDateTimeSameOrBeforeSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrBefore(AUG_04_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeSameOrBeforeDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrBefore(AUG_04_2015_1159_AS_DATE));
	}

	@Test
	public void isLocalDateTimeNotSameOrBeforeDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrBefore(AUG_04_2015_1201_AS_DATE));
	}

	@Test
	public void isLocalDateTimeSameOrBeforeSameDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrBefore(AUG_04_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeSameOrBeforeDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 11, 59, 0));
	}

	@Test
	public void isLocalDateTimeNotSameOrBeforeDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 12, 0, 1));
	}

	@Test
	public void isLocalDateTimeNotSameOrBeforeSameDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 12, 0, 0));
	}

	// ZonedDateTime Matchers

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameOrBeforeZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(AUG_04_2015_11AM_UTC));
	}

	@Test
	public void isZonedDateTimeNotSameOrBeforeZonedDateTime() {
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
	public void isZonedDateTimeSameOrBeforeZonedDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrBefore(AUG_04_2015_NOON_EST));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameOrBeforeLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(AUG_04_2015_1159, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeNotSameOrBeforeLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(AUG_04_2015_1201, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameOrBeforeSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(AUG_04_2015_NOON, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameOrBeforeLocalDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrBefore(AUG_04_2015_NOON, ZoneIds.CET));
	}

	@Test
	public void isZonedDateTimeSameOrBeforeLocalDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrBefore(AUG_04_2015_NOON, ZoneIds.EST));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameOrBeforeDate() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(AUG_04_2015_1159_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeNotSameOrBeforeDate() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(AUG_04_2015_1201_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameOrBeforeSameDate() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(AUG_04_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameOrBeforeDateEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(AUG_04_2015_NOON_CET_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameOrBeforeDateLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(AUG_04_2015_NOON_EST_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameOrBeforeDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 11, 59, 0, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeNotSameOrBeforeDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 12, 0, 1, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeNotSameOrBeforeSameDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 12, 0, 0, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameOrBeforeDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 12, 0, 0, ZoneIds.CET));
	}

	@Test
	public void isZonedDateTimeNotSameOrBeforeDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 12, 0, 0, ZoneIds.EST));
	}

}
