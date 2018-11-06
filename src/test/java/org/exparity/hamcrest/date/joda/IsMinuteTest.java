package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_03_2015_11PM;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_03_2015_11PM_EST;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.MIDN;
import static org.exparity.hamcrest.date.testutils.JodaDates.NOON;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.core.IsMinute;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link IsMinute} class
 *
 * @author Thomas Naskali
 */
public class IsMinuteTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the minute [0-9]+?\\s     but: the date has the minute [0-9]+";

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeMinute() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isMinute(0));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotMinute() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isMinute(1));
	}

	@Test
 	public void isLocalDateTimeSameMinuteOfHour() {
 		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameMinuteOfHour(AUG_03_2015_11PM));
 	}

 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isLocalDateTimeNotSameMinuteOfHour() {
 		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameMinuteOfHour(AUG_04_2015_NOON.withMinuteOfHour(1)));
 	}

	// LocalTime Matchers
	@Test
	public void isLocalTimeMinute() {
		assertThat(NOON, JodaLocalTimeMatchers.isMinute(0));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeNotMinute() {
		assertThat(NOON, JodaLocalTimeMatchers.isMinute(1));
	}

	@Test
 	public void isLocalTimeSameMinuteOfHour() {
 		assertThat(NOON, JodaLocalTimeMatchers.sameMinuteOfHour(MIDN));
 	}

 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isLocalTimeNotSameMinuteOfHour() {
 		assertThat(NOON, JodaLocalTimeMatchers.sameMinuteOfHour(NOON.withMinuteOfHour(1)));
 	}

	// DateTime Matchers
	@Test
	public void isDateTimeMinute() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isMinute(0));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeNotMinute() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isMinute(1));
	}

	@Test
 	public void isDateTimeSameMinute() {
 		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameMinuteOfHour(AUG_03_2015_11PM_EST));
 	}

 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateTimeNotSameMinute() {
 		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameMinuteOfHour(AUG_04_2015_NOON_UTC.withMinuteOfHour(1)));
 	}

}
