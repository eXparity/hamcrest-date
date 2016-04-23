package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.LocalTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.exparity.hamcrest.date.testutils.ZoneIds;
import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameYear} class
 *
 * @author Stewart Bissett
 */
public class IsWithinTest {

	// Date Matchers
	@Test
	public void isDateWithinSameDate() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, AUG_04_2015_NOON_AS_DATE));
	}

	@Test
	public void isDateWithinDateInsideLimit() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, AUG_05_2015_NOON_AS_DATE));
	}

	@Test
	public void isDateWithinDateEqualLimit() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, AUG_06_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateWithinDateOutsideLimit() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, AUG_07_2015_NOON_AS_DATE));
	}

	@Test
	public void isDateWithinSameLocalDate() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, AUG_04_2015));
	}

	@Test
	public void isDateWithinLocalDateInsideLimit() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, AUG_05_2015));
	}

	@Test
	public void isDateWithinLocalDateEqualLimit() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, AUG_06_2015));
	}

	@Test(expected = AssertionError.class)
	public void isDateWithinLocalDateOutsideLimit() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, AUG_07_2015));
	}

	@Test
	public void isDateWithinSameDayMonthYear() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 4));
	}

	@Test
	public void isDateWithinDayMonthYearInsideLimit() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 5));
	}

	@Test
	public void isDateWithinDayMonthYearEqualLimit() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 6));
	}

	@Test(expected = AssertionError.class)
	public void isDateWithinDayMonthYearOutsideLimit() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 7));
	}

	@Test
	public void isDateWithinSameDayMonthYearTime() {
		assertThat(AUG_04_2015_NOON_AS_DATE,
				DateMatchers.within(2, ChronoUnit.MILLIS, 2015, Month.AUGUST, 4, 12, 0, 0, 0));
	}

	@Test
	public void isDateWithinDayMonthYearTimeInsideLimit() {
		assertThat(AUG_04_2015_NOON_AS_DATE,
				DateMatchers.within(2, ChronoUnit.MILLIS, 2015, Month.AUGUST, 4, 12, 0, 0, 1));
	}

	@Test
	public void isDateWithinDayMonthYearTimeEqualLimit() {
		assertThat(AUG_04_2015_NOON_AS_DATE,
				DateMatchers.within(2, ChronoUnit.MILLIS, 2015, Month.AUGUST, 4, 12, 0, 0, 2));
	}

	@Test(expected = AssertionError.class)
	public void isDateWithinDayMonthYearTimeOutsideLimit() {
		assertThat(AUG_04_2015_NOON_AS_DATE,
				DateMatchers.within(2, ChronoUnit.MILLIS, 2015, Month.AUGUST, 4, 12, 0, 0, 3));
	}

	// LocalDate Matchers
	@Test
	public void isLocalDateWithinSameLocalDate() {
		assertThat(AUG_04_2015, LocalDateMatchers.within(2, ChronoUnit.DAYS, AUG_04_2015));
	}

	@Test
	public void isLocalDateWithinLocalDateInsideLimit() {
		assertThat(AUG_04_2015, LocalDateMatchers.within(2, ChronoUnit.DAYS, AUG_05_2015));
	}

	@Test
	public void isLocalDateWithinLocalDateEqualLimit() {
		assertThat(AUG_04_2015, LocalDateMatchers.within(2, ChronoUnit.DAYS, AUG_06_2015));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateWithinLocalDateOutsideLimit() {
		assertThat(AUG_04_2015, LocalDateMatchers.within(2, ChronoUnit.DAYS, AUG_07_2015));
	}

	@Test
	public void isLocalDateWithinSameDayMonthYear() {
		assertThat(AUG_04_2015, LocalDateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 4));
	}

	@Test
	public void isLocalDateWithinDayMonthYearInsideLimit() {
		assertThat(AUG_04_2015, LocalDateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 5));
	}

	@Test
	public void isLocalDateWithinDayMonthYearEqualLimit() {
		assertThat(AUG_04_2015, LocalDateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 6));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateWithinDayMonthYearOutsideLimit() {
		assertThat(AUG_04_2015, LocalDateMatchers.within(2, ChronoUnit.DAYS, 2015, Month.AUGUST, 7));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeWithinSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.within(2, ChronoUnit.DAYS, AUG_04_2015_NOON));
	}

	@Test
	public void isLocalDateTimeWithinLocalDateTimeInsideLimit() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.within(2, ChronoUnit.DAYS, AUG_05_2015_NOON));
	}

	@Test
	public void isLocalDateTimeWithinLocalDateTimeEqualLimit() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.within(2, ChronoUnit.DAYS, AUG_06_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeWithinLocalDateTimeOutsideLimit() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.within(2, ChronoUnit.DAYS, AUG_07_2015_NOON));
	}

	@Test
	public void isLocalDateTimeWithinSameDayMonthYear() {
		assertThat(AUG_04_2015_NOON,
				LocalDateTimeMatchers.within(2, ChronoUnit.NANOS, 2015, Month.AUGUST, 4, 12, 0, 0, 0));
	}

	@Test
	public void isLocalDateTimeWithinDayMonthYearInsideLimit() {
		assertThat(AUG_04_2015_NOON,
				LocalDateTimeMatchers.within(2, ChronoUnit.NANOS, 2015, Month.AUGUST, 4, 12, 0, 0, 1));
	}

	@Test
	public void isLocalDateTimeWithinDayMonthYearEqualLimit() {
		assertThat(AUG_04_2015_NOON,
				LocalDateTimeMatchers.within(2, ChronoUnit.NANOS, 2015, Month.AUGUST, 4, 12, 0, 0, 2));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeWithinDayMonthYearOutsideLimit() {
		assertThat(AUG_04_2015_NOON,
				LocalDateTimeMatchers.within(2, ChronoUnit.NANOS, 2015, Month.AUGUST, 4, 12, 0, 0, 3));
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeWithinSameZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.within(2, ChronoUnit.DAYS, AUG_04_2015_NOON_UTC));
	}

	@Test
	public void isZonedDateTimeWithinZonedDateTimeInsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.within(2, ChronoUnit.DAYS, AUG_05_2015_NOON_UTC));
	}

	@Test
	public void isZonedDateTimeWithinZonedDateTimeEqualLimit() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.within(2, ChronoUnit.DAYS, AUG_06_2015_NOON_UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeWithinZonedDateTimeOutsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.within(2, ChronoUnit.DAYS, AUG_07_2015_NOON_UTC));
	}

	@Test
	public void isZonedDateTimeWithinSameDayMonthYear() {
		assertThat(AUG_04_2015_NOON_UTC,
				ZonedDateTimeMatchers.within(2, ChronoUnit.NANOS, 2015, Month.AUGUST, 4, 12, 0, 0, 0, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeWithinDayMonthYearInsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC,
				ZonedDateTimeMatchers.within(2, ChronoUnit.NANOS, 2015, Month.AUGUST, 4, 12, 0, 0, 1, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeWithinDayMonthYearEqualLimit() {
		assertThat(AUG_04_2015_NOON_UTC,
				ZonedDateTimeMatchers.within(2, ChronoUnit.NANOS, 2015, Month.AUGUST, 4, 12, 0, 0, 2, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeWithinDayMonthYearOutsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC,
				ZonedDateTimeMatchers.within(2, ChronoUnit.NANOS, 2015, Month.AUGUST, 4, 12, 0, 0, 3, ZoneIds.UTC));
	}

	// LocalTime Matchers
	@Test
	public void isLocalTimeWithSameLocalTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.within(2, ChronoUnit.SECONDS, LocalTime.NOON));
	}

	@Test
	public void isLocalTimeWithSameLocalTimeInsideLimit() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.within(2, ChronoUnit.SECONDS, LocalTime.NOON.plusSeconds(1)));
	}

	@Test
	public void isLocalTimeWithSameLocalTimeEqualLimit() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.within(2, ChronoUnit.SECONDS, LocalTime.NOON.plusSeconds(2)));
	}

	@Test(expected = AssertionError.class)
	public void isLocalTimeWithSameLocalTimeOutsideLimit() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.within(2, ChronoUnit.SECONDS, LocalTime.NOON.plusSeconds(3)));
	}

	@Test
	public void isLocalTimeWithSameTime() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.within(2, ChronoUnit.SECONDS, 12, 0, 0));
	}

	@Test
	public void isLocalTimeWithSameTimeInsideLimit() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.within(2, ChronoUnit.SECONDS, 12, 0, 1));
	}

	@Test
	public void isLocalTimeWithSameTimeEqualLimit() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.within(2, ChronoUnit.SECONDS, 12, 0, 2));
	}

	@Test(expected = AssertionError.class)
	public void isLocalTimeWithSameTimeOutsideLimit() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.within(2, ChronoUnit.SECONDS, 12, 0, 3));
	}
}
