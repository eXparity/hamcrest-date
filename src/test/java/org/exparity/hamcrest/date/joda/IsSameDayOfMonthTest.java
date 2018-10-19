package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_01_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.SEP_04_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.SEP_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.SEP_04_2015_NOON_UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.Test;

/**
 * @author Thomas Naskali
 */
public class IsSameDayOfMonthTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the day of month [0-9]+?\\s     but: the date has the day of month [0-9]+?";

	// LocalDate Matchers
	@Test
	public void isLocalDateSameDayOfMonth() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.sameDayOfMonth(AUG_04_2015));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotSameDayOfMonth() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.sameDayOfMonth(AUG_01_2015));
	}

	@Test
	public void isLocalDateSameDayOfMonthDifferentMonth() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.sameDayOfMonth(SEP_04_2015));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeSameDayOfMonth() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameDayOfMonth(AUG_04_2015_NOON));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotSameDayOfMonth() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameDayOfMonth(AUG_01_2015_NOON));
	}

	@Test
	public void isLocalDateTimeSameDayOfMonthDifferentMonth() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameDayOfMonth(SEP_04_2015_NOON));
	}

	// DateTime Matchers
	@Test
	public void isDateTimeSameDayOfMonth() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameDayOfMonth(AUG_04_2015_NOON_UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeNotSameDayOfMonth() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameDayOfMonth(AUG_01_2015_NOON_UTC));
	}

	@Test
	public void isDateTimeSameDayOfMonthDifferentMonth() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameDayOfMonth(SEP_04_2015_NOON_UTC));
	}
}
