package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2015_NOON_UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.Test;

/**
 * @author Thomas Naskali
 */
public class IsSameMonthOfYearTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the month [0-9]+?\\s     but: the date has the month [0-9]+?";

	// LocalDate Matchers
	@Test
	public void isLocalDateSameMonthOfYear() {
		assertThat(JAN_01_2015, JodaLocalDateMatchers.sameMonthOfYear(JAN_01_2015));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotSameMonthOfYear() {
		assertThat(JAN_01_2015, JodaLocalDateMatchers.sameMonthOfYear(JAN_01_2015.plusMonths(1)));
	}

	@Test
	public void isLocalDateSameMonthOfYearDifferentYear() {
		assertThat(JAN_01_2015, JodaLocalDateMatchers.sameMonthOfYear(JAN_01_2015.plusYears(1)));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeSameMonthOfYear() {
		assertThat(JAN_01_2015_NOON, JodaLocalDateTimeMatchers.sameMonthOfYear(JAN_01_2015_NOON));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotSameMonthOfYear() {
		assertThat(JAN_01_2015_NOON, JodaLocalDateTimeMatchers.sameMonthOfYear(JAN_01_2015_NOON.plusMonths(1)));
	}

	@Test
	public void isLocalDateTimeSameMonthOfYearDifferentYear() {
		assertThat(JAN_01_2015_NOON, JodaLocalDateTimeMatchers.sameMonthOfYear(JAN_01_2015_NOON.plusYears(1)));
	}

	// DateTime Matchers
	@Test
	public void isZonedDateTimeSameMonthOfYear() {
		assertThat(JAN_01_2015_NOON_UTC, JodaDateTimeMatchers.sameMonthOfYear(JAN_01_2015_NOON_UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotSameMonthOfYear() {
		assertThat(JAN_01_2015_NOON_UTC, JodaDateTimeMatchers.sameMonthOfYear(JAN_01_2015_NOON_UTC.plusMonths(1)));
	}

	@Test
	public void isZonedDateTimeSameMonthOfYearDifferentYear() {
		assertThat(JAN_01_2015_NOON_UTC, JodaDateTimeMatchers.sameMonthOfYear(JAN_01_2015_NOON_UTC.plusYears(1)));
	}
}
