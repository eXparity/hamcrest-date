package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_03_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_07_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_07_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_07_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.SEP_04_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.SEP_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.SEP_04_2015_NOON_UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.Test;

/**
 * @author Thomas Naskali
 */
public class IsSameDayOfWeekTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is on a \\p{IsAlphabetic}+?\\s     but: the date is on a \\p{IsAlphabetic}+";

	// LocalDate Matchers
	@Test
	public void isLocalDateSameDayOfWeek() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.sameDayOfWeek(AUG_04_2015));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotSameDayOfWeek() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.sameDayOfWeek(AUG_03_2015));
	}

	@Test
	public void isLocalDateSameDayOfWeekDifferentMonth() {
		assertThat(AUG_07_2015, JodaLocalDateMatchers.sameDayOfWeek(SEP_04_2015));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeSameDayOfWeek() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameDayOfWeek(AUG_04_2015_NOON));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotSameDayOfWeek() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameDayOfWeek(AUG_01_2015_NOON));
	}

	@Test
	public void isLocalDateTimeSameDayOfWeekDifferentMonth() {
		assertThat(AUG_07_2015_NOON, JodaLocalDateTimeMatchers.sameDayOfWeek(SEP_04_2015_NOON));
	}

	// DateTime Matchers
	@Test
	public void isDateTimeSameDayOfWeek() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameDayOfWeek(AUG_04_2015_NOON_UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeNotSameDayOfWeek() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameDayOfWeek(AUG_01_2015_NOON_UTC));
	}

	@Test
	public void isDateTimeSameDayOfWeekDifferentMonth() {
		assertThat(AUG_07_2015_NOON_UTC, JodaDateTimeMatchers.sameDayOfWeek(SEP_04_2015_NOON_UTC));
	}
}
