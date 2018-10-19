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
import static org.exparity.hamcrest.date.testutils.JodaDates.JUN_14_2012;
import static org.exparity.hamcrest.date.testutils.JodaDates.JUN_15_2012;
import static org.exparity.hamcrest.date.testutils.JodaDates.JUN_15_2012_11AM_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.JUN_15_2012_11PM_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.JUN_16_2012;
import static org.exparity.hamcrest.date.testutils.JodaDates.NOON;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.CET;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.EST;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import org.joda.time.DateTimeConstants;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link JodaDateTimeMatchers} class
 *
 * @author Thomas Naskali
 */
public class IsAfterTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is after (?s:.)+?\\s     but: date is (?s:.)+";

	// LocalDate Matchers
	@Test
	public void isLocalDateAfterEarlierLocalDate() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.after(AUG_03_2015));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateAfterLaterLocalDate() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.after(AUG_05_2015));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateAfterSameLocalDate() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.after(AUG_04_2015));
	}

	@Test
	public void isLocalDateAfterEarlierDay() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.after(2015, DateTimeConstants.AUGUST, 3));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateAfterLaterDay() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.after(2015, DateTimeConstants.AUGUST, 5));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateAfterLaterSameDay() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.after(2015, DateTimeConstants.AUGUST, 4));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeAfterEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.after(AUG_04_2015_1159));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeAfterLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.after(AUG_04_2015_1201));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeAfterSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.after(AUG_04_2015_NOON));
	}

	@Test
	public void isLocalDateTimeAfterEarlierDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.after(2015, DateTimeConstants.AUGUST, 4, 11, 59, 0));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeAfterLaterDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.after(2015, DateTimeConstants.AUGUST, 4, 12, 0, 1));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeAfterLaterSameDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.after(2015, DateTimeConstants.AUGUST, 4, 12, 0, 0));
	}

	// DateTime Matchers
 	@Test
 	public void isDateAfterEarlierLocalDate() {
 		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.after(JUN_14_2012, UTC).atZone(UTC));
 	}

 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateAfterLaterLocalDate() {
 		assertThat(JUN_15_2012_11AM_UTC, JodaDateTimeMatchers.after(JUN_16_2012, UTC).atZone(UTC));
 	}

 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateAfterSameLocalDate() {
 		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.after(JUN_15_2012, UTC).atZone(UTC));
 	}

 	@Test
 	public void isDateAfterEarlierDateValues() {
 		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.after(2012, DateTimeConstants.JUNE, 14, UTC).atZone(UTC));
 	}

 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateAfterLaterDateValues() {
 		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.after(2012, DateTimeConstants.JUNE, 16, UTC).atZone(UTC));
 	}

 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateAfterSameDateValues() {
 		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.after(2012, DateTimeConstants.JUNE, 15, UTC).atZone(UTC));
 	}

	@Test
	public void isDateTimeAfterEarlierDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.after(AUG_04_2015_11AM_UTC).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeAfterLaterDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.after(AUG_04_2015_01PM_UTC).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeAfterSameDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.after(AUG_04_2015_NOON_UTC).atZone(UTC));
	}

	@Test
	public void isDateTimeAfterDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.after(AUG_04_2015_NOON_CET).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeAfterDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.after(AUG_04_2015_NOON_EST).atZone(UTC));
	}

	@Test
	public void isDateTimeAfterEarlierDateTimeWithFields() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.after(2015, DateTimeConstants.AUGUST, 4, 11, 59, 0, 0, UTC).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeAfterLaterDateTimeWithFields() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.after(2015, DateTimeConstants.AUGUST, 4, 12, 0, 1, 0, UTC).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeAfterLaterSameDateTimeWithFields() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.after(2015, DateTimeConstants.AUGUST, 4, 12, 0, 0, 0, UTC).atZone(UTC));
	}

	@Test
	public void isDateTimeAfterDateTimeEarlierZoneWithFields() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.after(2015, DateTimeConstants.AUGUST, 4, 12, 0, 0, 0, CET).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeAfterDateTimeLaterZoneWithFields() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.after(2015, DateTimeConstants.AUGUST, 4, 12, 0, 0, 0, EST).atZone(UTC));
	}

	// LocalTime Matchers
	@Test
	public void isLocalTimeAfterEarlierLocalTime() {
		assertThat(NOON, JodaLocalTimeMatchers.after(NOON.minusSeconds(1)));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeAfterSameLocalTime() {
		assertThat(NOON, JodaLocalTimeMatchers.after(NOON));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeAfterLaterLocalTime() {
		assertThat(NOON, JodaLocalTimeMatchers.after(NOON.plusSeconds(1)));
	}

	@Test
	public void isLocalTimeAfterEarlierTime() {
		assertThat(NOON, JodaLocalTimeMatchers.after(11, 59, 59));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeAfterSameTime() {
		assertThat(NOON, JodaLocalTimeMatchers.after(12, 0, 0));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeAfterLaterTime() {
		assertThat(NOON, JodaLocalTimeMatchers.after(12, 0, 1));
	}
}
