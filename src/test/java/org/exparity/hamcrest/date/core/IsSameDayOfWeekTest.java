package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.testng.annotations.Test;

/**
 * @author Stewart Bissett
 */
public class IsSameDayOfWeekTest {

    private static final String ASSERTION_PATTERN = "\\s*Expected: the date is on a [A-Za-z]*\\s*but: the date is on a [A-Za-z]*";

	// Date Matchers
	@Test
	public void isDateSameDayOfWeek() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.sameDayOfWeek(AUG_04_2015_NOON_AS_DATE));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
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

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
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

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
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

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotSameDayOfWeek() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameDayOfWeek(AUG_01_2015_NOON_UTC));
	}

	@Test
	public void isZonedDateTimeSameDayOfWeekDifferentMonth() {
		assertThat(AUG_07_2015_NOON_UTC, ZonedDateTimeMatchers.sameDayOfWeek(SEP_04_2015_NOON_UTC));
	}
}
