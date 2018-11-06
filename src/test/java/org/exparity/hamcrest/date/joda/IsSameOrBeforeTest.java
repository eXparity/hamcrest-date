package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_03_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_01PM_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_1159;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_11AM_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_1201;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_CET;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_EST;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_05_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.NOON;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.CET;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.EST;
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
public class IsSameOrBeforeTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is on the same date or before (?s:.)+?\\s     but: the date is (?s:.)+";

	// LocalDate Matchers
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateSameOrBeforeLaterLocalDate() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.sameOrBefore(AUG_03_2015));
	}

	@Test
	public void isLocalDateSameOrBeforeLocalDate() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.sameOrBefore(AUG_05_2015));
	}

	@Test
	public void isLocalDateSameOrBeforeSameLocalDate() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.sameOrBefore(AUG_04_2015));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateSameOrBeforeLaterDay() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.sameOrBefore(2015, AUGUST, 3));
	}

	@Test
	public void isLocalDateSameOrBeforeDay() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.sameOrBefore(2015, AUGUST, 5));
	}

	@Test
	public void isLocalDateSameOrBeforeSameDay() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.sameOrBefore(2015, AUGUST, 4));
	}

	// LocalDateTime Matchers
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameOrBeforeLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameOrBefore(AUG_04_2015_1159));
	}

	@Test
	public void isLocalDateTimeSameOrBeforeLocalDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameOrBefore(AUG_04_2015_1201));
	}

	@Test
	public void isLocalDateTimeSameOrBeforeSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameOrBefore(AUG_04_2015_NOON));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameOrBeforeLaterDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 11, 59, 0));
	}

	@Test
	public void isLocalDateTimeSameOrBeforeDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 12, 0, 1));
	}

	@Test
	public void isLocalDateTimeSameOrBeforeSameDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 12, 0, 0));
	}

	// LocalTime Matchers
 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isLocalTimeSameOrBeforeEarlierLocalTime() {
 		assertThat(NOON, JodaLocalTimeMatchers.sameOrBefore(NOON.minusSeconds(1)));
 	}
 
 	@Test
 	public void isLocalTimeSameOrBeforeSameLocalTime() {
 		assertThat(NOON, JodaLocalTimeMatchers.sameOrBefore(NOON));
 	}
 
 	@Test
 	public void isLocalTimeSameOrBeforeLaterLocalTime() {
 		assertThat(NOON, JodaLocalTimeMatchers.sameOrBefore(NOON.plusSeconds(1)));
 	}
 
 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isLocalTimeSameOrBeforeEarlierTime() {
 		assertThat(NOON, JodaLocalTimeMatchers.sameOrBefore(11, 59, 59));
 	}
 
 	@Test
 	public void isLocalTimeSameOrBeforeSameTime() {
 		assertThat(NOON, JodaLocalTimeMatchers.sameOrBefore(12, 0, 0));
 	}
 
 	@Test
 	public void isLocalTimeSameOrBeforeLaterTime() {
 		assertThat(NOON, JodaLocalTimeMatchers.sameOrBefore(12, 0, 1));
 	}

	// DateTime Matchers
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeSameOrBeforeLaterDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameOrBefore(AUG_04_2015_11AM_UTC));
	}

	@Test
	public void isDateTimeSameOrBeforeDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameOrBefore(AUG_04_2015_01PM_UTC));
	}

	@Test
	public void isDateTimeSameOrBeforeSameDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameOrBefore(AUG_04_2015_NOON_UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeSameOrBeforeDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameOrBefore(AUG_04_2015_NOON_CET));
	}

	@Test
	public void isDateTimeSameOrBeforeLaterDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameOrBefore(AUG_04_2015_NOON_EST));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeSameOrBeforeLaterDateTimeAsFields() {
		assertThat(AUG_04_2015_NOON_UTC,
				JodaDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 11, 59, 0, 0, UTC));
	}

	@Test
	public void isDateTimeSameOrBeforeDateTimeAsFields() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 12, 0, 1, 0, UTC));
	}

	@Test
	public void isDateTimeSameOrBeforeSameDateTimeAsFields() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 12, 0, 0, 0, UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeSameOrBeforeDateTimeEarlierZoneAsFields() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 12, 0, 0, 0, CET));
	}

	@Test
	public void isDateTimeSameOrBeforeDateTimeLaterZoneAsFields() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameOrBefore(2015, AUGUST, 4, 12, 0, 0, 0, EST));
	}
}
