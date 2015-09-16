package org.exparity.hamcrest.date;

import static java.time.DayOfWeek.MONDAY;
import static java.time.Month.*;
import static org.exparity.hamcrest.date.ZonedDateTimeMatchers.*;
import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import org.exparity.hamcrest.date.testutils.ZoneIds;
import org.junit.Test;

/**
 * Unit Test for {@link LocalDateTimeMatchers}
 * 
 * @author Stewart Bissett
 */
public class ZonedDateTimeMatchersTest {

	// After / ZonedDateTime
	@Test
	public void canTestAfterWithEarlierZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, after(AUG_04_2015_11AM_UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithSameZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, after(AUG_04_2015_NOON_UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithLaterZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, after(AUG_04_2015_01PM_UTC));
	}

	// After / TimeZone
	@Test(expected = AssertionError.class)
	public void canTestAfterWithEarlierTimeZone() {
		assertThat(AUG_04_2015_NOON_UTC, after(AUG_04_2015_NOON_MINUS_1));
	}

	@Test
	public void canTestAfterWithLaterTimeZone() {
		assertThat(AUG_04_2015_NOON_UTC, after(AUG_04_2015_NOON_PLUS_1));
	}

	// After / LocalDateTime
	@Test
	public void canTestAfterWithEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, after(AUG_04_2015_1159, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, after(AUG_04_2015_NOON, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, after(AUG_04_2015_1201, ZoneIds.UTC));
	}

	// After / Date
	@Test
	public void canTestAfterWithEarlierDate() {
		assertThat(AUG_04_2015_NOON_UTC, after(AUG_04_2015_115959_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithSameDate() {
		assertThat(AUG_04_2015_NOON_UTC, after(AUG_04_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithLaterDate() {
		assertThat(AUG_04_2015_NOON_UTC, after(AUG_04_2015_120001_UTC_AS_DATE, ZoneIds.UTC));
	}

	// After / DayMonthYear
	@Test
	public void canTestAfterWithEarlierDMY() {
		assertThat(AUG_04_2015_NOON_UTC, after(2015, AUGUST, 4, 11, 59, 59, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithSameDMY() {
		assertThat(AUG_04_2015_NOON_UTC, after(2015, AUGUST, 4, 12, 0, 0, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithLaterDDMY() {
		assertThat(AUG_04_2015_NOON_UTC, after(2015, AUGUST, 4, 12, 0, 1, ZoneIds.UTC));
	}

	// Before / ZonedDateTime
	@Test(expected = AssertionError.class)
	public void canTestBeforeWithEarlierZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, before(AUG_04_2015_11AM_UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithSameZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, before(AUG_04_2015_NOON_UTC));
	}

	@Test
	public void canTestBeforeWithLaterZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, before(AUG_04_2015_01PM_UTC));
	}

	// Before / TimeZone
	@Test
	public void canTestBeforeWithEarlierTimeZone() {
		assertThat(AUG_04_2015_NOON_UTC, before(AUG_04_2015_NOON_MINUS_1));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithLaterTimeZone() {
		assertThat(AUG_04_2015_NOON_UTC, before(AUG_04_2015_NOON_PLUS_1));
	}

	// Before / LocalDateTime
	@Test(expected = AssertionError.class)
	public void canTestBeforeWithEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, before(AUG_04_2015_1159, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, before(AUG_04_2015_NOON, ZoneIds.UTC));
	}

	@Test
	public void canTestBeforeWithLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, before(AUG_04_2015_1201, ZoneIds.UTC));
	}

	// Before / Date
	@Test(expected = AssertionError.class)
	public void canTestBeforeWithEarlierDate() {
		assertThat(AUG_04_2015_NOON_UTC, before(AUG_04_2015_115959_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithSameDate() {
		assertThat(AUG_04_2015_NOON_UTC, before(AUG_04_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void canTestBeforeWithLaterDate() {
		assertThat(AUG_04_2015_NOON_UTC, before(AUG_04_2015_120001_UTC_AS_DATE, ZoneIds.UTC));
	}

	// Before / DayMonthYear
	@Test(expected = AssertionError.class)
	public void canTestBeforeWithEarlierDMY() {
		assertThat(AUG_04_2015_NOON_UTC, before(2015, AUGUST, 4, 11, 59, 59, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithSameDMY() {
		assertThat(AUG_04_2015_NOON_UTC, before(2015, AUGUST, 4, 12, 0, 0, ZoneIds.UTC));
	}

	@Test
	public void canTestBeforeWithLaterDDMY() {
		assertThat(AUG_04_2015_NOON_UTC, before(2015, AUGUST, 4, 12, 0, 1, ZoneIds.UTC));
	}

	// SameDay / ZonedDateTime
	@Test(expected = AssertionError.class)
	public void canTestSameDayWithEarlierZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameDay(AUG_03_2015_NOON_UTC));
	}

	@Test
	public void canTestSameDayWithSameZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameDay(AUG_04_2015_NOON_UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameWithLaterZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameDay(AUG_05_2015_NOON_UTC));
	}

	// SameDay / TimeZone
	@Test(expected = AssertionError.class)
	public void canTestSameDayWithEarlierTimeZone() {
		assertThat(AUG_04_2015_NOON_UTC, sameDay(AUG_03_2015_11PM_MINUS_1));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithLaterTimeZone() {
		assertThat(AUG_04_2015_NOON_UTC, sameDay(AUG_05_2015_01AM_PLUS_1));
	}

	// SameDay / LocalDateTime
	@Test(expected = AssertionError.class)
	public void canTestSameDayWithEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameDay(AUG_03_2015_NOON, ZoneIds.UTC));
	}

	@Test
	public void canTestSameDayWithSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameDay(AUG_04_2015_NOON, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameDay(AUG_05_2015_NOON, ZoneIds.UTC));
	}

	// Same Day / Date
	@Test(expected = AssertionError.class)
	public void canTestSameDayWithEarlierDate() {
		assertThat(AUG_04_2015_NOON_UTC, sameDay(AUG_03_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void canTestSameDayWithSameDate() {
		assertThat(AUG_04_2015_NOON_UTC, sameDay(AUG_04_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithLaterDate() {
		assertThat(AUG_04_2015_NOON_UTC, sameDay(AUG_05_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	// Same Day / DayMonthYear
	@Test(expected = AssertionError.class)
	public void canTestSameDayWithEarlierDMY() {
		assertThat(AUG_04_2015_NOON_UTC, sameDay(2015, AUGUST, 3, ZoneIds.UTC));
	}

	@Test
	public void canTestSameDayWithSameDMY() {
		assertThat(AUG_04_2015_NOON_UTC, sameDay(2015, AUGUST, 4, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithLaterDDMY() {
		assertThat(AUG_04_2015_NOON_UTC, sameDay(2015, AUGUST, 5, ZoneIds.UTC));
	}

	// SameInstant / ZonedDateTime
	@Test(expected = AssertionError.class)
	public void canTestSameInstantWithEarlierZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameInstant(AUG_04_2015_11AM_UTC));
	}

	@Test
	public void canTestSameInstantWithSameZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameInstant(AUG_04_2015_NOON_UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameInstantWithLaterZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameInstant(AUG_04_2015_01PM_UTC));
	}

	// SameInstant / TimeZone
	@Test(expected = AssertionError.class)
	public void canTestSameInstantWithEarlierTimeZone() {
		assertThat(AUG_04_2015_NOON_UTC, sameInstant(AUG_04_2015_NOON_MINUS_1));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameInstantWithLaterTimeZone() {
		assertThat(AUG_04_2015_NOON_UTC, sameInstant(AUG_04_2015_NOON_PLUS_1));
	}

	// SameInstant / LocalDateTime
	@Test(expected = AssertionError.class)
	public void canTestSameInstantWithEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameInstant(AUG_03_2015_NOON, ZoneIds.UTC));
	}

	@Test
	public void canTestSameInstantWithSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameInstant(AUG_04_2015_NOON, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameInstantWithLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameInstant(AUG_05_2015_NOON, ZoneIds.UTC));
	}

	// SameInstant / Date
	@Test(expected = AssertionError.class)
	public void canTestSameInstantWithEarlierDate() {
		assertThat(AUG_04_2015_NOON_UTC, sameInstant(AUG_03_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void canTestSameInstantWithSameDate() {
		assertThat(AUG_04_2015_NOON_UTC, sameInstant(AUG_04_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameInstantWithLaterDate() {
		assertThat(AUG_04_2015_NOON_UTC, sameInstant(AUG_05_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}
	
	// SameInstant / DayMonthYear
	@Test(expected = AssertionError.class)
	public void canTestSameInstantWithEarlierDMY() {
		assertThat(AUG_04_2015_NOON_UTC, sameInstant(2015, AUGUST, 4, 11, 59, 59, 0, ZoneIds.UTC));
	}

	@Test
	public void canTestSameInstantWithSameDMY() {
		assertThat(AUG_04_2015_NOON_UTC, sameInstant(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameInstantWithLaterDMY() {
		assertThat(AUG_04_2015_NOON_UTC, sameInstant(2015, AUGUST, 4, 12, 0, 1, 0, ZoneIds.UTC));
	}
	
	// SameOrBefore / ZonedDateTime
	@Test(expected = AssertionError.class)
	public void canTestSameOrBeforeWithEarlierZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrBefore(AUG_04_2015_11AM_UTC));
	}

	@Test
	public void canTestSameOrBeforeWithSameZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrBefore(AUG_04_2015_NOON_UTC));
	}

	@Test
	public void canTestSameOrBeforeWithLaterZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrBefore(AUG_04_2015_01PM_UTC));
	}

	// SameOrBefore / TimeZone
	@Test
	public void canTestSameOrBeforeWithEarlierTimeZone() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrBefore(AUG_04_2015_NOON_MINUS_1));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrBeforeWithLaterTimeZone() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrBefore(AUG_04_2015_NOON_PLUS_1));
	}

	// SameOrBefore / LocalDateTime
	@Test(expected = AssertionError.class)
	public void canTestSameOrBeforeWithEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrBefore(AUG_04_2015_1159, ZoneIds.UTC));
	}

	@Test
	public void canTestSameOrBeforeWithSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrBefore(AUG_04_2015_NOON, ZoneIds.UTC));
	}

	@Test
	public void canTestSameOrBeforeWithLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrBefore(AUG_04_2015_1201, ZoneIds.UTC));
	}

	// SameOrBefore / Date
	@Test(expected = AssertionError.class)
	public void canTestSameOrBeforeWithEarlierDate() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrBefore(AUG_04_2015_115959_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void canTestSameOrBeforeWithSameDate() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrBefore(AUG_04_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void canTestSameOrBeforeWithLaterDate() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrBefore(AUG_04_2015_120001_UTC_AS_DATE, ZoneIds.UTC));
	}

	// SameOrBefore / DayMonthYear
	@Test(expected = AssertionError.class)
	public void canTestSameOrBeforeWithEarlierDMY() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrBefore(2015, AUGUST, 3, 12, 0, 0, ZoneIds.UTC));
	}

	@Test
	public void canTestSameOrBeforeWithSameDMY() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrBefore(2015, AUGUST, 4, 12, 0, 0, ZoneIds.UTC));
	}

	@Test
	public void canTestSameOrBeforeWithLaterDDMY() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrBefore(2015, AUGUST, 5, 12, 0, 0, ZoneIds.UTC));
	}
	
	// SameOrAfter / ZonedDateTime
	@Test
	public void canTestSameOrAfterWithEarlierZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrAfter(AUG_04_2015_11AM_UTC));
	}

	@Test
	public void canTestSameOrAfterWithSameZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrAfter(AUG_04_2015_NOON_UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrAfterWithLaterZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrAfter(AUG_04_2015_01PM_UTC));
	}

	// SameOrAfter / TimeZone
	@Test(expected = AssertionError.class)
	public void canTestSameOrAfterWithEarlierTimeZone() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrAfter(AUG_04_2015_NOON_MINUS_1));
	}

	@Test
	public void canTestSameOrAfterWithLaterTimeZone() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrAfter(AUG_04_2015_NOON_PLUS_1));
	}

	// SameOrAfter / LocalDateTime
	@Test
	public void canTestSameOrAfterWithEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrAfter(AUG_04_2015_1159, ZoneIds.UTC));
	}

	@Test
	public void canTestSameOrAfterWithSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrAfter(AUG_04_2015_NOON, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrAfterWithLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrAfter(AUG_04_2015_1201, ZoneIds.UTC));
	}

	// SameOrAfter / Date
	@Test
	public void canTestSameOrAfterWithEarlierDate() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrAfter(AUG_04_2015_115959_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void canTestSameOrAfterWithSameDate() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrAfter(AUG_04_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrAfterWithLaterDate() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrAfter(AUG_04_2015_120001_UTC_AS_DATE, ZoneIds.UTC));
	}

	// SameOrAfter / DayMonthYear
	@Test
	public void canTestSameOrAfterWithEarlierDMY() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrAfter(2015, AUGUST, 4, 11, 59, 59, ZoneIds.UTC));
	}

	@Test
	public void canTestSameOrAfterWithSameDMY() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrAfter(2015, AUGUST, 4, 12, 0, 0, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrAfterWithLaterDDMY() {
		assertThat(AUG_04_2015_NOON_UTC, sameOrAfter(2015, AUGUST, 4, 12, 0, 1, ZoneIds.UTC));
	}

	@Test
	public void canTestSameMonthOfYearWithSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameMonthOfYear(AUG_04_2015_NOON, ZoneIds.UTC));
	}

	@Test
	public void canTestSameMonthOfYearWithDifferentLocalDateTimeSameMonth() {
		assertThat(AUG_04_2015_NOON_UTC, sameMonthOfYear(AUG_03_2015_NOON, ZoneIds.UTC));
	}

	@Test
	public void canTestSameMonthOfYearWithDifferentLocalDateTimeSameMonthDifferentYear() {
		assertThat(AUG_04_2015_NOON_UTC, sameMonthOfYear(AUG_04_2016_NOON, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameMonthOfYearWithDifferentLocalDateTimeMonth() {
		assertThat(AUG_04_2015_NOON_UTC, sameMonthOfYear(SEP_04_2015_NOON, ZoneIds.UTC));
	}

	@Test
	public void canTestSameMonthOfYearWithSameDate() {
		assertThat(AUG_04_2015_NOON_UTC, sameMonthOfYear(AUG_04_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void canTestSameMonthOfYearWithDifferentDateSameMonth() {
		assertThat(AUG_04_2015_NOON_UTC, sameMonthOfYear(AUG_05_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void canTestSameMonthOfYearWithDifferentDateSameMonthDifferentYear() {
		assertThat(AUG_04_2015_NOON_UTC, sameMonthOfYear(AUG_04_2016_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameMonthOfYearWithDifferentDateMonth() {
		assertThat(AUG_04_2015_NOON_UTC, sameMonthOfYear(SEP_04_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void canTestSameYearWithSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, sameYear(AUG_04_2015_NOON, ZoneIds.UTC));
	}

	@Test
	public void canTestSameYearWithDifferentLocalDateTimeSameYear() {
		assertThat(AUG_04_2015_NOON_UTC, sameYear(AUG_03_2015_NOON, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameYearWithDifferentLocalDateTimeDifferentYear() {
		assertThat(AUG_04_2015_NOON_UTC, sameYear(AUG_04_2016_NOON, ZoneIds.UTC));
	}

	@Test
	public void canTestSameYearWithSameDate() {
		assertThat(AUG_04_2015_NOON_UTC, sameYear(AUG_04_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void canTestSameYearWithDifferentDateSameYear() {
		assertThat(AUG_04_2015_NOON_UTC, sameYear(AUG_05_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameYearWithDifferentDateSameDifferentYear() {
		assertThat(AUG_04_2015_NOON_UTC, sameYear(AUG_04_2016_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void canTestWithinIntervalLocalDateTime() {
		assertThat(AUG_03_2015_NOON_UTC, within(1, ChronoUnit.DAYS, AUG_04_2015_NOON, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestWithinOutsideIntervalLocalDateTime() {
		assertThat(AUG_03_2015_NOON_UTC, within(1, ChronoUnit.DAYS, AUG_05_2015_NOON, ZoneIds.UTC));
	}

	@Test
	public void canTestWithinIntervalDate() {
		assertThat(AUG_03_2015_NOON_UTC, within(1, ChronoUnit.DAYS, AUG_04_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestWithinOutsideIntervalDate() {
		assertThat(AUG_03_2015_NOON_UTC, within(1, ChronoUnit.DAYS, AUG_05_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void canTestWithinIntervalDMY() {
		assertThat(AUG_03_2015_NOON_UTC, within(1, ChronoUnit.DAYS, 2015, AUGUST, 4, 12, 0, 0, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestWithinOutsideIntervalDMY() {
		assertThat(AUG_03_2015_NOON_UTC, within(1, ChronoUnit.DAYS, 2015, AUGUST, 5, 12, 0, 0, ZoneIds.UTC));
	}

	@Test
	public void canTestWithinTimeIntervalLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, within(1, ChronoUnit.SECONDS, AUG_04_2015_1201, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestWithinOutsideTimeIntervalLocalDateTime() {
		assertThat(AUG_04_2015_11AM_UTC, within(1, ChronoUnit.SECONDS, AUG_04_2015_1201, ZoneIds.UTC));
	}

	@Test
	public void canTestWithinTimeIntervalDate() {
		assertThat(AUG_04_2015_NOON_UTC, within(1, ChronoUnit.SECONDS, AUG_04_2015_120001_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestWithinOutsideTimeIntervalDate() {
		assertThat(AUG_04_2015_11AM_UTC, within(1, ChronoUnit.SECONDS, AUG_04_2015_120001_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void canTestWithinTimeIntervalDMY() {
		assertThat(AUG_04_2015_NOON_UTC, within(1, ChronoUnit.SECONDS, 2015, AUGUST, 4, 12, 0, 1, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestWithinOutsideTimeIntervalDMY() {
		assertThat(AUG_04_2015_NOON_UTC, within(1, ChronoUnit.SECONDS, 2015, AUGUST, 4, 12, 0, 2, ZoneIds.UTC));
	}

	@Test
	public void canTestIsYesterday() {
		assertThat(yesterday(), isYesterday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotYesterday() {
		assertThat(today(), isYesterday());
	}

	@Test
	public void canTestIsToday() {
		assertThat(today(), isToday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotToday() {
		assertThat(tomorrow(), isToday());
	}

	@Test
	public void canTestIsTomorrow() {
		assertThat(tomorrow(), isTomorrow());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotTomorrow() {
		assertThat(today(), isTomorrow());
	}

	@Test
	public void canTestIsDayOfWeek() {
		assertThat(AUG_03_2015_NOON_UTC, isDayOfWeek(MONDAY));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotDayOfWeek() {
		assertThat(AUG_04_2015_NOON_UTC, isDayOfWeek(DayOfWeek.MONDAY));
	}

	@Test
	public void canTestIsMonday() {
		assertThat(AUG_03_2015_NOON_UTC, isMonday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMonday() {
		assertThat(AUG_04_2015_NOON_UTC, isMonday());
	}

	@Test
	public void canTestIsTuesday() {
		assertThat(AUG_04_2015_NOON_UTC, isTuesday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotTuesday() {
		assertThat(AUG_05_2015_NOON_UTC, isTuesday());
	}

	@Test
	public void canTestIsWednesday() {
		assertThat(AUG_05_2015_NOON_UTC, isWednesday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWednesday() {
		assertThat(AUG_06_2015_NOON_UTC, isWednesday());
	}

	@Test
	public void canTestIsThursday() {
		assertThat(AUG_06_2015_NOON_UTC, isThursday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotThursday() {
		assertThat(AUG_07_2015_NOON_UTC, isThursday());
	}

	@Test
	public void canTestIsFriday() {
		assertThat(AUG_07_2015_NOON_UTC, isFriday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotFriday() {
		assertThat(AUG_08_2015_NOON_UTC, isFriday());
	}

	@Test
	public void canTestIsSaturday() {
		assertThat(AUG_08_2015_NOON_UTC, isSaturday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotSaturday() {
		assertThat(AUG_09_2015_NOON_UTC, isSaturday());
	}

	@Test
	public void canTestIsSunday() {
		assertThat(AUG_09_2015_NOON_UTC, isSunday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotSunday() {
		assertThat(AUG_03_2015_NOON_UTC, isSunday());
	}

	@Test
	public void canTestIsWeekday() {
		assertThat(AUG_03_2015_NOON_UTC, isWeekday());
		assertThat(AUG_04_2015_NOON_UTC, isWeekday());
		assertThat(AUG_05_2015_NOON_UTC, isWeekday());
		assertThat(AUG_06_2015_NOON_UTC, isWeekday());
		assertThat(AUG_07_2015_NOON_UTC, isWeekday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekdayOnSaturday() {
		assertThat(AUG_08_2015_NOON_UTC, isWeekday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekdayOnSunday() {
		assertThat(AUG_09_2015_NOON_UTC, isWeekday());
	}

	@Test
	public void canTestIsWeekend() {
		assertThat(AUG_08_2015_NOON_UTC, isWeekend());
		assertThat(AUG_09_2015_NOON_UTC, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekendOnMonday() {
		assertThat(AUG_03_2015_NOON_UTC, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekendOnTuesday() {
		assertThat(AUG_04_2015_NOON_UTC, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekendOnWednesday() {
		assertThat(AUG_05_2015_NOON_UTC, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekendOnThursday() {
		assertThat(AUG_06_2015_NOON_UTC, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekendOnFriday() {
		assertThat(AUG_07_2015_NOON_UTC, isWeekend());
	}

	@Test
	public void canTestIsFirstDayOfMonth() {
		assertThat(AUG_01_2015_NOON_UTC, isFirstDayOfMonth());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotFirstDayOfMonth() {
		assertThat(AUG_03_2015_NOON_UTC, isFirstDayOfMonth());
	}

	@Test
	public void canTestIsMinimum() {
		assertThat(AUG_01_2015_NOON_UTC, isMinimum(ChronoField.DAY_OF_MONTH));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMinimum() {
		assertThat(AUG_03_2015_NOON_UTC, isMinimum(ChronoField.DAY_OF_MONTH));
	}

	@Test
	public void canTestIsLastDayOfMonthAugust() {
		assertThat(AUG_31_2015_NOON_UTC, isLastDayOfMonth());
	}

	@Test
	public void canTestIsLastDayOfMonthSeptember() {
		assertThat(SEP_30_2015_NOON_UTC, isLastDayOfMonth());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotLastDayOfMonth() {
		assertThat(AUG_01_2015_NOON_UTC, isLastDayOfMonth());
	}

	@Test
	public void canTestIsMaximum() {
		assertThat(AUG_31_2015_NOON_UTC, isMaximum(ChronoField.DAY_OF_MONTH));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMaximum() {
		assertThat(AUG_01_2015_NOON_UTC, isMaximum(ChronoField.DAY_OF_MONTH));
	}

	@Test
	public void canTestIsMonth() {
		assertThat(AUG_04_2015_NOON_UTC, isMonth(AUGUST));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMonth() {
		assertThat(AUG_04_2015_NOON_UTC, isMonth(SEPTEMBER));
	}

	@Test
	public void canTestIsJanuary() {
		assertThat(JAN_01_2015_NOON_UTC, isJanuary());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotJanuary() {
		assertThat(AUG_04_2015_NOON_UTC, isJanuary());
	}

	@Test
	public void canTestIsFebruary() {
		assertThat(FEB_01_2015_NOON_UTC, isFebruary());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotFebruary() {
		assertThat(AUG_04_2015_NOON_UTC, isFebruary());
	}

	@Test
	public void canTestIsMarch() {
		assertThat(MAR_01_2015_NOON_UTC, isMarch());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMarch() {
		assertThat(AUG_04_2015_NOON_UTC, isMarch());
	}

	@Test
	public void canTestIsApril() {
		assertThat(APR_01_2015_NOON_UTC, isApril());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotApril() {
		assertThat(AUG_04_2015_NOON_UTC, isApril());
	}

	@Test
	public void canTestIsMay() {
		assertThat(MAY_01_2015_NOON_UTC, isMay());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMay() {
		assertThat(AUG_04_2015_NOON_UTC, isMay());
	}

	@Test
	public void canTestIsJune() {
		assertThat(JUN_01_2015_NOON_UTC, isJune());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotJune() {
		assertThat(AUG_04_2015_NOON_UTC, isJune());
	}

	@Test
	public void canTestIsJuly() {
		assertThat(JUL_01_2015_NOON_UTC, isJuly());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotJuly() {
		assertThat(AUG_04_2015_NOON_UTC, isJuly());
	}

	@Test
	public void canTestIsAugust() {
		assertThat(AUG_01_2015_NOON_UTC, isAugust());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotAugust() {
		assertThat(SEP_04_2015_NOON_UTC, isAugust());
	}

	@Test
	public void canTestIsSeptember() {
		assertThat(SEP_04_2015_NOON_UTC, isSeptember());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotSeptember() {
		assertThat(AUG_04_2015_NOON_UTC, isSeptember());
	}

	@Test
	public void canTestIsOctober() {
		assertThat(OCT_01_2015_NOON_UTC, isOctober());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotOctober() {
		assertThat(AUG_04_2015_NOON_UTC, isOctober());
	}

	@Test
	public void canTestIsNovember() {
		assertThat(NOV_01_2015_NOON_UTC, isNovember());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotNovember() {
		assertThat(AUG_04_2015_NOON_UTC, isNovember());
	}

	@Test
	public void canTestIsDecember() {
		assertThat(DEC_01_2015_NOON_UTC, isDecember());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotDecember() {
		assertThat(AUG_04_2015_NOON_UTC, isDecember());
	}

	@Test
	public void canTestIsLeapYear() {
		assertThat(AUG_04_2016_NOON_UTC, isLeapYear());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotLeapYear() {
		assertThat(AUG_04_2015_NOON_UTC, isLeapYear());
	}

	@Test
	public void canTestIsYear() {
		assertThat(AUG_04_2015_NOON_UTC, isYear(2015));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotYear() {
		assertThat(AUG_04_2015_NOON_UTC, isYear(2014));
	}

	@Test
	public void canTestIsDayOfMonth() {
		assertThat(AUG_04_2015_NOON_UTC, isDayOfMonth(4));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotDayOfMonth() {
		assertThat(AUG_04_2015_NOON_UTC, isDayOfMonth(5));
	}

	@Test
	public void canTestSameDayOfMonth() {
		assertThat(AUG_04_2015_NOON_UTC, sameDayOfMonth(AUG_04_2015_NOON, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameDayOfMonth() {
		assertThat(AUG_04_2015_NOON_UTC, sameDayOfMonth(AUG_05_2015_NOON, ZoneIds.UTC));
	}

	@Test
	public void canTestSameDayOfMonthAsDate() {
		assertThat(AUG_04_2015_NOON_UTC, sameDayOfMonth(AUG_04_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameDayOfMonthAsDate() {
		assertThat(AUG_04_2015_NOON_UTC, sameDayOfMonth(AUG_05_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void canTestIsHour() {
		assertThat(AUG_04_2015_NOON_UTC, isHour(12));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotHour() {
		assertThat(AUG_04_2015_NOON_UTC, isHour(13));
	}

	@Test
	public void canTestSameHourOfDay() {
		assertThat(AUG_04_2015_NOON_UTC, sameHourOfDay(AUG_04_2015_NOON, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameHourOfDay() {
		assertThat(AUG_04_2015_NOON_UTC, sameHourOfDay(AUG_04_2015_1159, ZoneIds.UTC));
	}

	@Test
	public void canTestSameHourOfDayAsDate() {
		assertThat(AUG_04_2015_NOON_UTC, sameHourOfDay(AUG_04_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameHourOfDayAsDate() {
		assertThat(AUG_04_2015_NOON_UTC, sameHourOfDay(AUG_04_2015_115959_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void canTestIsMinute() {
		assertThat(AUG_04_2015_11AM_UTC, isMinute(59));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMinute() {
		assertThat(AUG_04_2015_11AM_UTC, isMinute(58));
	}

	@Test
	public void canTestSameMinuteOfHour() {
		assertThat(AUG_04_2015_11AM_UTC, sameMinuteOfHour(AUG_04_2015_1159, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameMinuteOfHour() {
		assertThat(AUG_04_2015_11AM_UTC, sameMinuteOfHour(AUG_04_2015_NOON, ZoneIds.UTC));
	}

	@Test
	public void canTestSameMinuteOfHourAsDate() {
		assertThat(AUG_04_2015_11AM_UTC, sameMinuteOfHour(AUG_04_2015_115959_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameMinuteOfHourAsDate() {
		assertThat(AUG_04_2015_11AM_UTC, sameMinuteOfHour(AUG_04_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void canTestIsSecond() {
		assertThat(AUG_04_2015_11AM_UTC, isSecond(59));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotSecond() {
		assertThat(AUG_04_2015_11AM_UTC, isSecond(58));
	}

	@Test
	public void canTestSameSecondOfMinute() {
		assertThat(AUG_04_2015_11AM_UTC, sameSecondOfMinute(AUG_04_2015_1159, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameSecondOfMinute() {
		assertThat(AUG_04_2015_11AM_UTC, sameSecondOfMinute(AUG_04_2015_NOON, ZoneIds.UTC));
	}

	@Test
	public void canTestSameSecondOfMinuteAsDate() {
		assertThat(AUG_04_2015_11AM_UTC, sameSecondOfMinute(AUG_04_2015_115959_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameSecondOfMinuteAsDate() {
		assertThat(AUG_04_2015_11AM_UTC, sameSecondOfMinute(AUG_04_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	private ZonedDateTime yesterday() {
		return today().minusDays(1);
	}

	private ZonedDateTime today() {
		return ZonedDateTime.now();
	}

	private ZonedDateTime tomorrow() {
		return today().plusDays(1);
	}

}
