package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.FEB_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.FEB_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2012_11AM_PST;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2012_MIDN_CET;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.NOON;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.CET;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.DateMatchers;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link DateMatchers} class
 *
 * @author Thomas Naskali
 */
public class IsSameHourOfDayTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the hour [0-9]+?\\s     but: the date has the hour [0-9]+";

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeSameLocalDate() {
		assertThat(JAN_01_2015_NOON, JodaLocalDateTimeMatchers.sameHourOfDay(JAN_01_2015_NOON));
	}

	@Test
	public void isLocalDateTimeSameHourOfDay() {
		assertThat(JAN_01_2015_NOON, JodaLocalDateTimeMatchers.sameHourOfDay(FEB_01_2015_NOON));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotSameHourOfDay() {
		assertThat(JAN_01_2015_NOON, JodaLocalDateTimeMatchers.sameHourOfDay(JAN_01_2015_NOON.plusHours(1)));
	}

	@Test
	public void isLocalDateTimeSameHourOfDayDifferentDay() {
		assertThat(JAN_01_2015_NOON, JodaLocalDateTimeMatchers.sameHourOfDay(JAN_01_2015_NOON.plusDays(1)));
	}

	// LocalTime Matchers
	@Test
	public void isLocalTimeSameHourOfDay() {
		assertThat(NOON, JodaLocalTimeMatchers.sameHourOfDay(NOON));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeNotSameHourOfDay() {
		assertThat(NOON, JodaLocalTimeMatchers.sameHourOfDay(NOON.plusHours(1)));
	}

	// DateTime Matchers
	@Test
	public void isDateTimeSameHourOfDay() {
		assertThat(JAN_01_2015_NOON_UTC, JodaDateTimeMatchers.sameHourOfDay(FEB_01_2015_NOON_UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeNotSameHourOfDay() {
		assertThat(JAN_01_2015_NOON_UTC, JodaDateTimeMatchers.sameHourOfDay(JAN_01_2015_NOON_UTC.plusHours(1)));
	}

	@Test
	public void isDateTimeSameHourOfDayDifferentDay() {
		assertThat(JAN_01_2015_NOON_UTC, JodaDateTimeMatchers.sameHourOfDay(JAN_01_2015_NOON_UTC.plusDays(1)));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateTimeSameHourOfDayMidnightLocallyDifferentTimeZoneLowerOffsetPerspective() {
 		assertThat(JAN_01_2012_11AM_PST, JodaDateTimeMatchers.sameHourOfDay(JAN_01_2012_MIDN_CET).atZone(UTC));
 	}

 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateTimeSameHourOfDayMidnightLocallyDifferentTimeZoneHigherOffsetPerspective() {
 		assertThat(JAN_01_2012_11AM_PST, JodaDateTimeMatchers.sameHourOfDay(JAN_01_2012_MIDN_CET).atZone(CET));
 	}

}
