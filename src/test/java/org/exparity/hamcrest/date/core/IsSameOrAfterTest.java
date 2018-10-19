package org.exparity.hamcrest.date.core;

import static java.time.Month.AUGUST;
import static org.exparity.hamcrest.date.ZonedDateTimeMatchers.sameOrAfter;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_03_2015;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_01PM_UTC;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_1159;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_11AM_UTC;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_1201;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_NOON_CET;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_NOON_EST;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_05_2015;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_01_2012_11AM_GMT_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_01_2012_11AM_PST_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.JUN_14_2012;
import static org.exparity.hamcrest.date.testutils.Dates.JUN_15_2012;
import static org.exparity.hamcrest.date.testutils.Dates.JUN_15_2012_11AM_UTC_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.JUN_15_2012_11PM_UTC_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.JUN_16_2012;
import static org.exparity.hamcrest.date.testutils.ZoneIds.UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalTime;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.DayMonthYear;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.LocalTimeMatchers;
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
public class IsSameOrAfterTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is on the same date or after (?s:.)+?\\s     but: the date is (?s:.)+";

	// Date Matchers

	@Test
	public void isDateSameOrAfterEarlierDate() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameOrAfter(JUN_15_2012_11AM_UTC_AS_DATE).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameOrAfterLaterDate() {
		assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.sameOrAfter(JUN_15_2012_11PM_UTC_AS_DATE).atZone(UTC));
	}

	@Test
	public void isDateSameOrAfterSameDate() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameOrAfter(JUN_15_2012_11PM_UTC_AS_DATE).atZone(UTC));
	}

	@Test
	public void isDateSameOrAfterSameDateEarlierZone() {
		assertThat(JAN_01_2012_11AM_PST_AS_DATE, DateMatchers.sameOrAfter(JAN_01_2012_11AM_GMT_AS_DATE).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameOrAfterSameDateLaterZone() {
		assertThat(JAN_01_2012_11AM_GMT_AS_DATE, DateMatchers.sameOrAfter(JAN_01_2012_11AM_PST_AS_DATE).atZone(UTC));
	}

	@Test
	public void isDateSameOrAfterEarlierLocalDate() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameOrAfter(JUN_14_2012).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameOrAfterLaterLocalDate() {
		assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.sameOrAfter(JUN_16_2012).atZone(UTC));
	}

	@Test
	public void isDateSameOrAfterSameLocalDate() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameOrAfter(JUN_15_2012).atZone(UTC));
	}

	@Test
	public void isDateSameOrAfterEarlierDay() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameOrAfter(2012, Months.JUNE, 14).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameOrAfterLaterDay() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameOrAfter(2012, Months.JUNE, 16).atZone(UTC));
	}

	@Test
	public void isDateSameOrAfterSameDay() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameOrAfter(2012, Months.JUNE, 15).atZone(UTC));
	}

	@Test
	public void isDateSameOrAfterEarlierDayMonthYear() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameOrAfter(new DayMonthYear(14, Months.JUNE, 2012)).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameOrAfterLaterDayMonthYear() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameOrAfter(new DayMonthYear(16, Months.JUNE, 2012)).atZone(UTC));
	}

	@Test
	public void isDateSameOrAfterSameDayMonthYear() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameOrAfter(new DayMonthYear(15, Months.JUNE, 2012)).atZone(UTC));
	}

	@Test
	public void isDateSameOrAfterEarlierDateTime() {
		assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.sameOrAfter(2012, Months.JUNE, 15, 10, 59, 59).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameOrAfterLaterDateTime() {
		assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.sameOrAfter(2012, Months.JUNE, 15, 11, 0, 1).atZone(UTC));
	}

	@Test
	public void isDateSameOrAfterSameDateTime() {
		assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.sameOrAfter(2012, Months.JUNE, 15, 11, 0, 0).atZone(UTC));
	}

	// LocalDate Matchers

	@Test
	public void isLocalDateSameOrAfterEarlierLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameOrAfter(AUG_03_2015));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
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

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
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

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
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

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
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

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
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

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeSameOrAfterZonedDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrAfter(AUG_04_2015_NOON_EST));
	}

	@Test
	public void isZonedDateTimeSameOrAfterEarlierDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 11, 59, 0, 0, ZoneIds.UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
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

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeSameOrAfterDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.EST));
	}

	// LocalTime Matchers

	@Test
	public void isLocalTimeSameOrAfterEarlierLocalTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.sameOrAfter(LocalTime.NOON.minusSeconds(1)));
	}

	@Test
	public void isLocalTimeSameOrAfterrSameLocalTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.sameOrAfter(LocalTime.NOON));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeSameOrAfterLaterLocalTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.sameOrAfter(LocalTime.NOON.plusSeconds(1)));
	}

	@Test
	public void isLocalTimeSameOrAfterEarlierTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.sameOrAfter(11, 59, 59));
	}

	@Test
	public void isLocalTimeSameOrAfterSameTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.sameOrAfter(12, 0, 0));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeSameOrAfterLaterTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.sameOrAfter(12, 0, 1));
	}
}
