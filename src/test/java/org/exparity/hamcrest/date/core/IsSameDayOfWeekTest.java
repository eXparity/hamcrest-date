package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.junit.Test;

/**
 * @author Stewart Bissett
 */
public class IsSameDayOfWeekTest {

	// Date Matchers
	@Test
	public void isDateSameDayOfWeek() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.sameDayOfWeek(AUG_04_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotSameDayOfWeek() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.sameDayOfWeek(AUG_01_2015_NOON_AS_DATE));
	}

	@Test
	public void isDateSameDayOfWeekDifferentMonth() {
		assertThat(AUG_07_2015_NOON_AS_DATE, DateMatchers.sameDayOfWeek(SEP_04_2015_NOON_AS_DATE));
	}

	// LocalDate Matchers
	@Test
	public void isLocalDateSameDayOfWeek() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameDayOfWeek(AUG_04_2015));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotSameDayOfWeek() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameDayOfWeek(AUG_03_2015));
	}

	@Test
	public void isLocalDateSameDayOfWeekDifferentMonth() {
		assertThat(AUG_07_2015, LocalDateMatchers.sameDayOfWeek(SEP_04_2015));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeSameDayOfWeek() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameDayOfWeek(AUG_04_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotSameDayOfWeek() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameDayOfWeek(AUG_01_2015_NOON));
	}

	@Test
	public void isLocalDateTimeSameDayOfWeekDifferentMonth() {
		assertThat(AUG_07_2015_NOON, LocalDateTimeMatchers.sameDayOfWeek(SEP_04_2015_NOON));
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeSameDayOfWeek() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDayOfWeek(AUG_04_2015_NOON_UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotSameDayOfWeek() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDayOfWeek(AUG_01_2015_NOON_UTC));
	}

	@Test
	public void isZonedDateTimeSameDayOfWeekDifferentMonth() {
		assertThat(AUG_07_2015_NOON_UTC, ZonedDateTimeMatchers.sameDayOfWeek(SEP_04_2015_NOON_UTC));
	}
}
