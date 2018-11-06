package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2012_MIDN;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2012_MIDN_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.MIDN;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.DateMatchers;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link DateMatchers} class
 *
 * @author Thomas Naskali
 */
public class IsSameSecondOfMinuteTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the second [0-9]+?\\s     but: the date has the second [0-9]+";

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeSameSecondOfMinute() {
		assertThat(JAN_01_2012_MIDN, JodaLocalDateTimeMatchers.sameSecondOfMinute(JAN_01_2012_MIDN));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotSameSecondOfMinute() {
		assertThat(JAN_01_2012_MIDN, JodaLocalDateTimeMatchers.sameSecondOfMinute(JAN_01_2012_MIDN.plusSeconds(1)));
	}

	@Test
	public void isLocalDateTimeSameSecondOfMinuteDifferentMinute() {
		assertThat(JAN_01_2012_MIDN, JodaLocalDateTimeMatchers.sameSecondOfMinute(JAN_01_2012_MIDN.plusMinutes(1)));
	}

	// LocalTime Matchers
	@Test
	public void isLocalTimeSameSecondOfMinute() {
		assertThat(MIDN, JodaLocalTimeMatchers.sameSecondOfMinute(MIDN));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeNotSameSecondOfMinute() {
		assertThat(MIDN, JodaLocalTimeMatchers.sameSecondOfMinute(MIDN.plusSeconds(1)));
	}

	@Test
	public void isLocalTimeSameSecondOfMinuteDifferentMinute() {
		assertThat(MIDN, JodaLocalTimeMatchers.sameSecondOfMinute(MIDN.plusMinutes(1)));
	}

	// DateTime Matchers
	@Test
	public void isDateTimeSameSecondOfMinute() {
		assertThat(JAN_01_2012_MIDN_UTC, JodaDateTimeMatchers.sameSecondOfMinute(JAN_01_2012_MIDN_UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeNotSameSecondOfMinute() {
		assertThat(JAN_01_2012_MIDN_UTC, JodaDateTimeMatchers.sameSecondOfMinute(JAN_01_2012_MIDN_UTC.plusSeconds(1)));
	}

	@Test
	public void isDateTimeSameSecondOfMinuteDifferentMinute() {
		assertThat(JAN_01_2012_MIDN_UTC, JodaDateTimeMatchers.sameSecondOfMinute(JAN_01_2012_MIDN_UTC.plusMinutes(1)));
	}
}
