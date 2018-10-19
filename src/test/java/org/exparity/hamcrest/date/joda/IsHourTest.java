package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.NOON;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.CET;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.EST;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.core.IsHour;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link IsHour} class
 *
 * @author Thomas Naskali
 */
@SuppressWarnings("deprecation")
public class IsHourTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the hour [0-9]+?\\s     but: the date has the hour [0-9]+";

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeHour() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isHour(12));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotHour() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isHour(11));
	}

	// LocalTime Matchers
	@Test
	public void isLocalTimeHour() {
		assertThat(NOON, JodaLocalTimeMatchers.isHour(12));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeNotHour() {
		assertThat(NOON, JodaLocalTimeMatchers.isHour(11));
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeHour() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isHour(12).atZone(UTC));
	}

	@Test
	public void isZonedDateTimeHourOtherZone() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isHour(8).atZone(EST));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotHourOtherZone() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isHour(12).atZone(CET));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotHour() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isHour(11).atZone(UTC));
	}

}
