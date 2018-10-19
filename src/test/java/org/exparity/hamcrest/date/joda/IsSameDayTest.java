package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_03_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_03_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_03_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_CET;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_EST;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_05_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_05_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_05_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2012_11AM_PST;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2012_11AM_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2012_MIDN_CET;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2012_MIDN_UTC;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.CET;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.UTC;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.joda.time.DateTimeConstants.AUGUST;

import org.exparity.hamcrest.date.DateMatchers;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link DateMatchers} class
 *
 * @author Thomas Naskali
 */
public class IsSameDayTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the same day as (?s:.)+?\\s     but: the day is (?s:.)+";

	// LocalDate Matchers
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateSameDayEarlierLocalDate() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.sameDay(AUG_03_2015));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateSameDayLaterLocalDate() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.sameDay(AUG_05_2015));
	}

	@Test
	public void isLocalDateSameDaySameLocalDate() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.sameDay(AUG_04_2015));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateSameDayEarlierDay() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.isDay(2015, AUGUST, 3));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateSameDayLaterDay() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.isDay(2015, AUGUST, 5));
	}

	@Test
	public void isLocalDateSameDayLaterSameDay() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.isDay(2015, AUGUST, 4));
	}

	// LocalDateTime Matchers
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameDayEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameDay(AUG_03_2015_NOON));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameDayLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameDay(AUG_05_2015_NOON));
	}

	@Test
	public void isLocalDateTimeSameDaySameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameDay(AUG_04_2015_NOON));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameDayEarlierDay() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isDay(2015, AUGUST, 3));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameDayLaterDay() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isDay(2015, AUGUST, 5));
	}

	@Test
	public void isLocalDateTimeSameDayLaterSameDay() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isDay(2015, AUGUST, 4));
	}

	// DateTime Matchers
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeSameDayEarlierDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameDay(AUG_03_2015_NOON_UTC).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeSameDayLaterDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameDay(AUG_05_2015_NOON_UTC).atZone(UTC));
	}

	@Test
	public void isDateTimeSameDaySameDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameDay(AUG_04_2015_NOON_UTC).atZone(UTC));
	}

	@Test
	public void isDateTimeSameDayDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameDay(AUG_04_2015_NOON_CET).atZone(UTC));
	}

	@Test
	public void isDateTimeSameDayDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameDay(AUG_04_2015_NOON_EST).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeSameDayEarlierDay() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isDay(2015, AUGUST, 3, UTC).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeSameDayLaterDay() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isDay(2015, AUGUST, 5, UTC).atZone(UTC));
	}

	@Test
	public void isDateTimeSameDayLaterSameDay() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isDay(2015, AUGUST, 4, UTC).atZone(UTC));
	}
    
 	@Test
 	public void isDateTimeSameDaySameDateTimeDifferentTimeZone() {
 		assertThat(JAN_01_2012_11AM_PST, JodaDateTimeMatchers.sameDay(JAN_01_2012_11AM_UTC).atZone(UTC));
 	}
 
 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateTimeSameDaySameDateMidnightDifferentTimeZoneLowerOffsetPerspective() {
 		assertThat(JAN_01_2012_MIDN_UTC, JodaDateTimeMatchers.sameDay(JAN_01_2012_MIDN_CET).atZone(UTC));
 	}
 
 	@Test
 	public void isDateSameDayMidnightLocallyDifferentTimeZoneHigherOffsetPerspective() {
 		assertThat(JAN_01_2012_MIDN_UTC, JodaDateTimeMatchers.sameDay(JAN_01_2012_MIDN_CET).atZone(CET));
 	}
 
 	@Test
 	public void isDateSameDayLaterSameDateDifferentTimeZone() {
 		assertThat(JAN_01_2012_11AM_UTC, JodaDateTimeMatchers.sameDay(JAN_01_2012_11AM_PST).atZone(UTC));
 	}


}
