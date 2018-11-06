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
public class IsLastDayOfMonthTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is the last day of the month\\s     but: date is the [0-9]+? dayOfMonth instead of [0-9]+? dayOfMonth";

	// LocalDate Matchers
	@Test
	public void isLocalDateLastDayOfMonth() {
		assertThat(AUG_31_2015, JodaLocalDateMatchers.isLastDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotLastDayOfMonth() {
		assertThat(AUG_01_2015, JodaLocalDateMatchers.isLastDayOfMonth());
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeLastDayOfMonth() {
		assertThat(AUG_31_2015_NOON, JodaLocalDateTimeMatchers.isLastDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotLastDayOfMonth() {
		assertThat(AUG_01_2015_NOON, JodaLocalDateTimeMatchers.isLastDayOfMonth());
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeLastDayOfMonth() {
		assertThat(AUG_31_2015_NOON_UTC, JodaDateTimeMatchers.isLastDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotLastDayOfMonth() {
		assertThat(AUG_01_2015_NOON_UTC, JodaDateTimeMatchers.isLastDayOfMonth());
	}
}
