package org.exparity.hamcrest.date.core;

import static java.time.Month.AUGUST;
import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalTime;
import java.time.Month;

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
public class IsAfterTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is after (?s:.)+?\\s     but: date is (?s:.)+";

	// Date Matchers

	@Test
	public void isDateAfterEarlierDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(JUN_15_2012_11AM_AS_DATE));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateAfterLaterDate() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.after(JUN_15_2012_11PM_AS_DATE));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateAfterSameDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(JUN_15_2012_11PM_AS_DATE));
	}

	@Test
	public void isDateAfterSameDateDifferentTimeZone() {
		assertThat(JAN_01_2012_11AM_PST_AS_DATE, DateMatchers.after(JAN_01_2012_11AM_GMT_AS_DATE));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateAfterLaterSameDateDifferentTimeZone() {
		assertThat(JAN_01_2012_11AM_GMT_AS_DATE, DateMatchers.after(JAN_01_2012_11AM_PST_AS_DATE));
	}

	@Test
	public void isDateAfterEarlierLocalDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(JUN_14_2012));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateAfterLaterLocalDate() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.after(JUN_16_2012));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateAfterSameLocalDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(JUN_15_2012));
	}

	@Test
	public void isDateAfterEarlierDeprecatedDateValues() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(2012, Months.JUNE, 14));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateAfterLaterDeprecatedDateValues() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(2012, Months.JUNE, 16));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateAfterSameDeprecatedDateValues() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(2012, Months.JUNE, 15));
	}

	@Test
	public void isDateAfterEarlierDateValues() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(2012, Month.JUNE, 14));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateAfterLaterDateValues() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(2012, Month.JUNE, 16));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateAfterSameDateValues() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(2012, Month.JUNE, 15));
	}

	@Test
	public void isDateAfterEarlierDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(new DayMonthYear(14, Months.JUNE, 2012)));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateAfterLaterDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(new DayMonthYear(16, Months.JUNE, 2012)));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateAfterSameDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.after(new DayMonthYear(15, Months.JUNE, 2012)));
	}

	@Test
	public void isDateAfterEarlierDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.after(2012, Months.JUNE, 15, 10, 59, 59));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateAfterLaterDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.after(2012, Months.JUNE, 15, 11, 00, 01));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateAfterSameDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.after(2012, Months.JUNE, 15, 11, 00, 00));
	}

	// LocalDate Matchers

	@Test
	public void isLocalDateAfterEarlierLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(AUG_03_2015));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateAfterLaterLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(AUG_05_2015));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateAfterSameLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(AUG_04_2015));
	}

	@Test
	public void isLocalDateAfterEarlierDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(2015, AUGUST, 3));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateAfterLaterDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(2015, AUGUST, 5));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateAfterLaterSameDay() {
		assertThat(AUG_04_2015, LocalDateMatchers.after(2015, AUGUST, 4));
	}

	// LocalDateTime Matchers

	@Test
	public void isLocalDateTimeAfterEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(AUG_04_2015_1159));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeAfterLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(AUG_04_2015_1201));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeAfterSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(AUG_04_2015_NOON));
	}

	@Test
	public void isLocalDateTimeAfterEarlierDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(2015, AUGUST, 4, 11, 59, 0));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeAfterLaterDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 1));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeAfterLaterSameDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 0));
	}

	// ZonedDateTime Matchers

	@Test
	public void isZonedDateTimeAfterEarlierZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_11AM_UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeAfterLaterZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_01PM_UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeAfterSameZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_NOON_UTC));
	}

	@Test
	public void isZonedDateTimeAfterZonedDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_NOON_CET));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeAfterZonedDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(AUG_04_2015_NOON_EST));
	}

	@Test
	public void isZonedDateTimeAfterEarlierDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(2015, AUGUST, 4, 11, 59, 0, 0, ZoneIds.UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeAfterLaterDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 1, 0, ZoneIds.UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeAfterLaterSameDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeAfterDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.CET));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeAfterDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.after(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.EST));
	}

	// LocalTime Matchers

	@Test
	public void isLocalTimeAfterEarlierLocalTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.after(LocalTime.NOON.minusSeconds(1)));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeAfterSameLocalTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.after(LocalTime.NOON));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeAfterLaterLocalTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.after(LocalTime.NOON.plusSeconds(1)));
	}

	@Test
	public void isLocalTimeAfterEarlierTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.after(11, 59, 59));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeAfterSameTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.after(12, 0, 0));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeAfterLaterTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.after(12, 0, 1));
	}
}
