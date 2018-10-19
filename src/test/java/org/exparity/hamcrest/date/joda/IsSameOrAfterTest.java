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
public class IsSameOrAfterTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is on the same date or after (?s:.)+?\\s     but: the date is (?s:.)+";

	// LocalDate Matchers
	@Test
	public void isLocalDateSameOrAfterEarlierLocalDate() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.sameOrAfter(AUG_03_2015));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateSameOrAfterLaterLocalDate() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.sameOrAfter(AUG_05_2015));
	}

	@Test
	public void isLocalDateSameOrAfterSameLocalDate() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.sameOrAfter(AUG_04_2015));
	}

	@Test
	public void isLocalDateSameOrAfterEarlierDay() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.sameOrAfter(2015, AUGUST, 3));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateSameOrAfterLaterDay() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.sameOrAfter(2015, AUGUST, 5));
	}

	@Test
	public void isLocalDateSameOrAfterSameDay() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.sameOrAfter(2015, AUGUST, 4));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeSameOrAfterEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameOrAfter(AUG_04_2015_1159));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameOrAfterLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameOrAfter(AUG_04_2015_1201));
	}

	@Test
	public void isLocalDateTimeSameOrAfterSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameOrAfter(AUG_04_2015_NOON));
	}

	@Test
	public void isLocalDateTimeSameOrAfterEarlierDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 11, 59, 0));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameOrAfterLaterDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 12, 0, 1));
	}

	@Test
	public void isLocalDateTimeSameOrAfterSameDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 12, 0, 0));
	}

	// LocalTime Matchers
 	@Test
 	public void isLocalTimeSameOrAfterEarlierLocalTime() {
 		assertThat(NOON, JodaLocalTimeMatchers.sameOrAfter(NOON.minusSeconds(1)));
 	}

 	@Test
 	public void isLocalTimeSameOrAfterrSameLocalTime() {
 		assertThat(NOON, JodaLocalTimeMatchers.sameOrAfter(NOON));
 	}

 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isLocalTimeSameOrAfterLaterLocalTime() {
 		assertThat(NOON, JodaLocalTimeMatchers.sameOrAfter(NOON.plusSeconds(1)));
 	}

 	@Test
 	public void isLocalTimeSameOrAfterEarlierTime() {
 		assertThat(NOON, JodaLocalTimeMatchers.sameOrAfter(11, 59, 59));
 	}

 	@Test
 	public void isLocalTimeSameOrAfterSameTime() {
 		assertThat(NOON, JodaLocalTimeMatchers.sameOrAfter(12, 0, 0));
 	}

 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isLocalTimeSameOrAfterLaterTime() {
 		assertThat(NOON, JodaLocalTimeMatchers.sameOrAfter(12, 0, 1));
 	}

	// DateTime Matchers
	@Test
	public void isDateTimeSameOrAfterEarlierDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameOrAfter(AUG_04_2015_11AM_UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeSameOrAfterLaterDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameOrAfter(AUG_04_2015_01PM_UTC));
	}

	@Test
	public void isDateTimeSameOrAfterSameDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameOrAfter(AUG_04_2015_NOON_UTC));
	}

	@Test
	public void isDateTimeSameOrAfterDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameOrAfter(AUG_04_2015_NOON_CET));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeSameOrAfterDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameOrAfter(AUG_04_2015_NOON_EST));
	}

	@Test
	public void isDateTimeSameOrAfterEarlierDateTimeAsFields() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 11, 59, 0, 0, UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeSameOrAfterLaterDateTimeAsFields() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 12, 0, 1, 0, UTC));
	}

	@Test
	public void isDateTimeSameOrAfterSameDateTimeAsFields() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 12, 0, 0, 0, UTC));
	}

	@Test
	public void isDateTimeSameOrAfterDateTimeEarlierZoneAsFields() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 12, 0, 0, 0, CET));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeSameOrAfterDateTimeLaterZoneAsFields() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameOrAfter(2015, AUGUST, 4, 12, 0, 0, 0, EST));
	}

}
