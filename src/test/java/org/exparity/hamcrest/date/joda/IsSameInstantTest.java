package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_1159;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_1201;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2012_11AM_PST;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2012_11AM_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.JUN_15_2012_11AM_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.JUN_15_2012_11PM_UTC;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.CET;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.EST;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.UTC;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.joda.time.DateTimeConstants.AUGUST;

import org.exparity.hamcrest.date.DateMatchers;
import org.joda.time.DateTimeConstants;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link DateMatchers} class
 *
 * @author Thomas Naskali
 */
public class IsSameInstantTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the same date as (?s:.)+?\\s     but: the date is (?s:.)+";

	// LocalDateTime Matchers
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameInstantEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameInstant(AUG_04_2015_1159));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameInstantLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameInstant(AUG_04_2015_1201));
	}

	@Test
	public void isLocalDateTimeSameInstantSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameInstant(AUG_04_2015_NOON));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameInstantEarlierDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isInstant(2015, AUGUST, 4, 11, 59, 0, 0));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameInstantLaterDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isInstant(2015, AUGUST, 4, 12, 0, 1, 0));
	}

	@Test
	public void isLocalDateTimeSameInstantLaterSameDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isInstant(2015, AUGUST, 4, 12, 0, 0, 0));
	}

	// DateTime Matchers
	@Test
 	public void isDateTimeSameInstantSameDateTime() {
 		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameInstant(AUG_04_2015_NOON_UTC));
 	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateSameInstantEarlierDate() {
 		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.sameInstant(JUN_15_2012_11AM_UTC).atZone(UTC));
 	}
 
 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateSameInstantLaterDate() {
 		assertThat(JUN_15_2012_11AM_UTC, JodaDateTimeMatchers.sameInstant(JUN_15_2012_11PM_UTC).atZone(UTC));
 	}
 
 	@Test
 	public void isDateSameInstantSameDate() {
 		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.sameInstant(JUN_15_2012_11PM_UTC).atZone(UTC));
 	}
 
 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateSameInstantSameDateDifferentTimeZone() {
 		assertThat(JAN_01_2012_11AM_PST, JodaDateTimeMatchers.sameInstant(JAN_01_2012_11AM_UTC).atZone(UTC));
 	}
 
 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateSameInstantLaterSameDateDifferentTimeZone() {
 		assertThat(JAN_01_2012_11AM_UTC, JodaDateTimeMatchers.sameInstant(JAN_01_2012_11AM_PST).atZone(UTC));
 	}

 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateSameInstantEarlierEpochTime() {
 		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.sameInstant(JUN_15_2012_11PM_UTC.toInstant().toDate().getTime() + 1).atZone(UTC));
 	}

 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateSameInstantLaterEpochTime() {
 		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.sameInstant(JUN_15_2012_11PM_UTC.toInstant().toDate().getTime() - 1).atZone(UTC));
 	}
 
 	@Test
 	public void isDateSameInstantSameEpochTime() {
 		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.sameInstant(JUN_15_2012_11PM_UTC.toInstant().toDate().getTime()).atZone(UTC));
 	}
 
 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateSameInstantEarlierDateValue() {
 		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.isInstant(2012, DateTimeConstants.JUNE, 15, 23, 0, 0, 1, UTC));
 	}
 
 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateSameInstantLaterDateValue() {
 		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.isInstant(2012, DateTimeConstants.JUNE, 15, 22, 59, 59, 59, UTC));
 	}
 
 	@Test
 	public void isDateSameInstantSameDateValue() {
 		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.isInstant(2012, DateTimeConstants.JUNE, 15, 23, 0, 0, 0, UTC));
 	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeSameInstantEarlierDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isInstant(2015, AUGUST, 4, 11, 59, 0, 0, UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeSameInstantLaterDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isInstant(2015, AUGUST, 4, 12, 0, 1, 0, UTC));
	}

	@Test
	public void isDateTimeSameInstantLaterSameDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isInstant(2015, AUGUST, 4, 12, 0, 0, 0, UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeSameInstantDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isInstant(2015, AUGUST, 4, 12, 0, 0, 0, CET));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeSameInstantDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isInstant(2015, AUGUST, 4, 12, 0, 0, 0, EST));
	}
}
