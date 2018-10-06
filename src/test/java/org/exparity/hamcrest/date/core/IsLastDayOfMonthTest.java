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
public class IsLastDayOfMonthTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is the last day of the month\\s     but: date is the [0-9]+? day of month instead of [0-9]+? day of month";

	// Date Matchers
	@Test
	public void isDateLastDayOfMonth() {
		assertThat(AUG_31_2015_NOON_UTC_AS_DATE, DateMatchers.isLastDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotLastDayOfMonth() {
		assertThat(AUG_01_2015_NOON_UTC_AS_DATE, DateMatchers.isLastDayOfMonth());
	}

	// LocalDate Matchers
	@Test
	public void isLocalDateLastDayOfMonth() {
		assertThat(AUG_31_2015, LocalDateMatchers.isLastDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotLastDayOfMonth() {
		assertThat(AUG_01_2015, LocalDateMatchers.isLastDayOfMonth());
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeLastDayOfMonth() {
		assertThat(AUG_31_2015_NOON, LocalDateTimeMatchers.isLastDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotLastDayOfMonth() {
		assertThat(AUG_01_2015_NOON, LocalDateTimeMatchers.isLastDayOfMonth());
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeLastDayOfMonth() {
		assertThat(AUG_31_2015_NOON_UTC, ZonedDateTimeMatchers.isLastDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotLastDayOfMonth() {
		assertThat(AUG_01_2015_NOON_UTC, ZonedDateTimeMatchers.isLastDayOfMonth());
	}
}
