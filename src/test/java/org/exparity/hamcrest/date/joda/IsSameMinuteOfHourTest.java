package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.NOON;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.DateMatchers;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link DateMatchers} class
 *
 * @author Thomas Naskali
 */
public class IsSameMinuteOfHourTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the minute [0-9]+?\\s     but: the date has the minute [0-9]+";

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeSameMinuteOfHour() {
		assertThat(JAN_01_2015_NOON, JodaLocalDateTimeMatchers.sameMinuteOfHour(JAN_01_2015_NOON));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotSameMinuteOfHour() {
		assertThat(JAN_01_2015_NOON, JodaLocalDateTimeMatchers.sameMinuteOfHour(JAN_01_2015_NOON.plusMinutes(1)));
	}

	@Test
	public void isLocalDateTimeSameMinuteOfHourDifferentHour() {
		assertThat(JAN_01_2015_NOON, JodaLocalDateTimeMatchers.sameMinuteOfHour(JAN_01_2015_NOON.plusHours(1)));
	}

	// LocalTime Matchers
	@Test
	public void isLocalTimeSameMinuteOfHour() {
		assertThat(NOON, JodaLocalTimeMatchers.sameMinuteOfHour(NOON));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeNotSameMinuteOfHour() {
		assertThat(NOON, JodaLocalTimeMatchers.sameMinuteOfHour(NOON.plusMinutes(1)));
	}

	@Test
	public void isLocalTimeSameMinuteOfHourDifferentHour() {
		assertThat(NOON, JodaLocalTimeMatchers.sameMinuteOfHour(NOON.plusHours(1)));
	}

	// DateTime Matchers
	@Test
	public void isZonedDateTimeSameMinuteOfHour() {
		assertThat(JAN_01_2015_NOON_UTC, JodaDateTimeMatchers.sameMinuteOfHour(JAN_01_2015_NOON_UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotSameMinuteOfHour() {
		assertThat(JAN_01_2015_NOON_UTC, JodaDateTimeMatchers.sameMinuteOfHour(JAN_01_2015_NOON_UTC.plusMinutes(1)));
	}

	@Test
	public void isZonedDateTimeSameMinuteOfHourDifferentHour() {
		assertThat(JAN_01_2015_NOON_UTC, JodaDateTimeMatchers.sameMinuteOfHour(JAN_01_2015_NOON_UTC.plusHours(1)));
	}
}
