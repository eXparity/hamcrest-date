package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_NOON_UTC_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.ZoneIds.UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalTime;
import java.time.ZoneId;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.LocalTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.exparity.hamcrest.date.testutils.ZoneIds;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link IsHour} class
 *
 * @author Stewart Bissett
 */
@SuppressWarnings("deprecation")
public class IsHourTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the hour [0-9]+?\\s     but: the date has the hour [0-9]+";

	// Date Matchers
	@Test
	public void isDateHour() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isHour(12).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotHour() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isHour(11).atZone(UTC));
	}

	@Test
	public void isDateSameHour() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.sameHour(12).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotSameHour() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.sameHour(11).atZone(UTC));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeHour() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isHour(12));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotHour() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isHour(11));
	}

	// LocalTime Matchers
	@Test
	public void isLocalTimeHour() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.isHour(12));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeNotHour() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.isHour(11));
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeHour() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isHour(12).atZone(ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeHourOtherZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isHour(8).atZone(ZoneIds.EST));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotHourOtherZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isHour(12).atZone(ZoneIds.CET));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotHour() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isHour(11).atZone(ZoneIds.UTC));
	}

}
