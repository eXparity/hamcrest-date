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
public class IsSameDayOfMonthTest {

	// Date Matchers
	@Test
	public void isDateSameDayOfMonth() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.sameDayOfMonth(AUG_04_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotSameDayOfMonth() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.sameDayOfMonth(AUG_01_2015_NOON_AS_DATE));
	}

	@Test
	public void isDateSameDayOfMonthDifferentMonth() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.sameDayOfMonth(SEP_04_2015_NOON_AS_DATE));
	}

	// LocalDate Matchers
	@Test
	public void isLocalDateSameDayOfMonth() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameDayOfMonth(AUG_04_2015));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotSameDayOfMonth() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameDayOfMonth(AUG_01_2015));
	}

	@Test
	public void isLocalDateSameDayOfMonthDifferentMonth() {
		assertThat(AUG_04_2015, LocalDateMatchers.sameDayOfMonth(SEP_04_2015));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeSameDayOfMonth() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameDayOfMonth(AUG_04_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotSameDayOfMonth() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameDayOfMonth(AUG_01_2015_NOON));
	}

	@Test
	public void isLocalDateTimeSameDayOfMonthDifferentMonth() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameDayOfMonth(SEP_04_2015_NOON));
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeSameDayOfMonth() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDayOfMonth(AUG_04_2015_NOON_UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotSameDayOfMonth() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDayOfMonth(AUG_01_2015_NOON_UTC));
	}

	@Test
	public void isZonedDateTimeSameDayOfMonthDifferentMonth() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDayOfMonth(SEP_04_2015_NOON_UTC));
	}
}
