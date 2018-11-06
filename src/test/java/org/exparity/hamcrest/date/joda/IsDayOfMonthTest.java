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
public class IsDayOfMonthTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the day of month [0-9]+?\\s     but: the date has the day of month [0-9]+?";

	// LocalDate Matchers
	@Test
	public void isLocalDateFirstDayOfMonth() {
		assertThat(AUG_01_2015, JodaLocalDateMatchers.isDayOfMonth(1));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotFirstDayOfMonth() {
		assertThat(AUG_31_2015, JodaLocalDateMatchers.isDayOfMonth(1));
	}

	@Test
	public void isLocalDateLastDayOfMonth() {
		assertThat(AUG_31_2015, JodaLocalDateMatchers.isDayOfMonth(31));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotLastDayOfMonth() {
		assertThat(AUG_01_2015, JodaLocalDateMatchers.isDayOfMonth(31));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeFirstDayOfMonth() {
		assertThat(AUG_01_2015_NOON, JodaLocalDateTimeMatchers.isDayOfMonth(1));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotFirstDayOfMonth() {
		assertThat(AUG_31_2015_NOON, JodaLocalDateTimeMatchers.isDayOfMonth(1));
	}

	@Test
	public void isLocalDateTimeLastDayOfMonth() {
		assertThat(AUG_31_2015_NOON, JodaLocalDateTimeMatchers.isDayOfMonth(31));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotLastDayOfMonth() {
		assertThat(AUG_01_2015_NOON, JodaLocalDateTimeMatchers.isDayOfMonth(31));
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeFirstDayOfMonth() {
		assertThat(AUG_01_2015_NOON_UTC, JodaDateTimeMatchers.isDayOfMonth(1));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotFirstDayOfMonth() {
		assertThat(AUG_31_2015_NOON_UTC, JodaDateTimeMatchers.isDayOfMonth(1));
	}

	@Test
	public void isZonedDateTimeLastDayOfMonth() {
		assertThat(AUG_31_2015_NOON_UTC, JodaDateTimeMatchers.isDayOfMonth(31));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotLastDayOfMonth() {
		assertThat(AUG_01_2015_NOON_UTC, JodaDateTimeMatchers.isDayOfMonth(31));
	}

}
