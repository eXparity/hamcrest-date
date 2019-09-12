package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.SqlDateMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.testng.annotations.Test;

/**
 * @author Stewart Bissett
 */
public class IsFirstDayOfMonthTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is the first day of the month\\s     but: date is the [0-9]+? day of the month";

	// Date Matchers
	@Test
	public void isDateFirstDayOfMonth() {
		assertThat(AUG_01_2015_NOON_UTC_AS_DATE, DateMatchers.isFirstDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotFirstDayOfMonth() {
		assertThat(AUG_31_2015_NOON_UTC_AS_DATE, DateMatchers.isFirstDayOfMonth());
	}

	// java.sql.Date Matchers
	@Test
	public void isSqlDateFirstDayOfMonth() {
		assertThat(AUG_01_2015_AS_SQL, SqlDateMatchers.isFirstDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotFirstDayOfMonth() {
		assertThat(AUG_31_2015_AS_SQL, SqlDateMatchers.isFirstDayOfMonth());
	}

	// java.sql.Date Matchers
	@Test
	public void isSqlDateFirstDayOfMonthUsingDateMatchers() {
		assertThat(AUG_01_2015_AS_SQL, DateMatchers.isFirstDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotFirstDayOfMonthUsingDateMatchers() {
		assertThat(AUG_31_2015_AS_SQL, DateMatchers.isFirstDayOfMonth());
	}

	// LocalDate Matchers
	@Test
	public void isLocalDateFirstDayOfMonth() {
		assertThat(AUG_01_2015, LocalDateMatchers.isFirstDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotFirstDayOfMonth() {
		assertThat(AUG_31_2015, LocalDateMatchers.isFirstDayOfMonth());
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeFirstDayOfMonth() {
		assertThat(AUG_01_2015_NOON, LocalDateTimeMatchers.isFirstDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotFirstDayOfMonth() {
		assertThat(AUG_31_2015_NOON, LocalDateTimeMatchers.isFirstDayOfMonth());
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeFirstDayOfMonth() {
		assertThat(AUG_01_2015_NOON_UTC, ZonedDateTimeMatchers.isFirstDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotFirstDayOfMonth() {
		assertThat(AUG_31_2015_NOON_UTC, ZonedDateTimeMatchers.isFirstDayOfMonth());
	}
}
