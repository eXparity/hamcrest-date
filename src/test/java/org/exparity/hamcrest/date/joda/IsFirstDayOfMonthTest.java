package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_01_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_31_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_31_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_31_2015_NOON_UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.Test;

/**
 * @author Thomas Naskali
 */
public class IsFirstDayOfMonthTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is the first day of the month\\s     but: date is the [0-9]+? dayOfMonth instead of [0-9]+? dayOfMonth";

	// LocalDate Matchers
	@Test
	public void isLocalDateFirstDayOfMonth() {
		assertThat(AUG_01_2015, JodaLocalDateMatchers.isFirstDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotFirstDayOfMonth() {
		assertThat(AUG_31_2015, JodaLocalDateMatchers.isFirstDayOfMonth());
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeFirstDayOfMonth() {
		assertThat(AUG_01_2015_NOON, JodaLocalDateTimeMatchers.isFirstDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotFirstDayOfMonth() {
		assertThat(AUG_31_2015_NOON, JodaLocalDateTimeMatchers.isFirstDayOfMonth());
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeFirstDayOfMonth() {
		assertThat(AUG_01_2015_NOON_UTC, JodaDateTimeMatchers.isFirstDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotFirstDayOfMonth() {
		assertThat(AUG_31_2015_NOON_UTC, JodaDateTimeMatchers.isFirstDayOfMonth());
	}
}
