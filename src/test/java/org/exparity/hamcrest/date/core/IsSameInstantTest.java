package org.exparity.hamcrest.date.core;

import static java.time.Month.AUGUST;
import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.exparity.hamcrest.date.testutils.ZoneIds;
import org.junit.Test;

/**
 * Unit Tests for the {@link DateMatchers} class
 *
 * @author Stewart Bissett
 */
public class IsSameInstantTest {

	// Date Matchers

	@Test(expected = AssertionError.class)
	public void isDateSameInstantEarlierDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameInstant(JUN_15_2012_11AM_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameInstantLaterDate() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameInstant(JUN_15_2012_11PM_AS_DATE));
	}

	@Test
	public void isDateSameInstantSameDate() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameInstant(JUN_15_2012_11PM_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameInstantEarlierEpochTime() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameInstant(JUN_15_2012_11PM_AS_DATE.getTime() + 1));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameInstantLaterEpochTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameInstant(JUN_15_2012_11PM_AS_DATE.getTime() + 1));
	}

	@Test
	public void isDateSameInstantSameEpochTime() {
		assertThat(JUN_15_2012_11PM_AS_DATE, DateMatchers.sameInstant(JUN_15_2012_11PM_AS_DATE.getTime()));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameInstantSameDateDifferentTimeZone() {
		assertThat(JAN_01_2012_11AM_PST_AS_DATE, DateMatchers.sameInstant(JAN_01_2012_11AM_GMT_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameInstantLaterSameDateDifferentTimeZone() {
		assertThat(JAN_01_2012_11AM_GMT_AS_DATE, DateMatchers.sameInstant(JAN_01_2012_11AM_PST_AS_DATE));
	}

	// LocalDateTime Matchers

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeSameInstantEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameInstant(AUG_04_2015_1159));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeSameInstantLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameInstant(AUG_04_2015_1201));
	}

	@Test
	public void isLocalDateTimeSameInstantSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameInstant(AUG_04_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeSameInstantEarlierDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameInstant(AUG_04_2015_1159_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeSameInstantLaterDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameInstant(AUG_04_2015_1201_AS_DATE));
	}

	@Test
	public void isLocalDateTimeSameInstantSameDate() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameInstant(AUG_04_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeSameInstantEarlierDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameInstant(2015, AUGUST, 4, 11, 59, 0));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeSameInstantLaterDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameInstant(2015, AUGUST, 4, 12, 0, 1));
	}

	@Test
	public void isLocalDateTimeSameInstantLaterSameDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameInstant(2015, AUGUST, 4, 12, 0, 0));
	}

	// ZonedDateTime Matchers

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameInstantEarlierZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(AUG_04_2015_11AM_UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameInstantLaterZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(AUG_04_2015_01PM_UTC));
	}

	@Test
	public void isZonedDateTimeSameInstantSameZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(AUG_04_2015_NOON_UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameInstantZonedDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(AUG_04_2015_NOON_CET));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameInstantZonedDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(AUG_04_2015_NOON_EST));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameInstantEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(AUG_04_2015_1159, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameInstantLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(AUG_04_2015_1201, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameInstantSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(AUG_04_2015_NOON, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameInstantLocalDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(AUG_04_2015_NOON, ZoneIds.CET));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameInstantLocalDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(AUG_04_2015_NOON, ZoneIds.EST));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameInstantEarlierDate() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(AUG_04_2015_1159_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameInstantLaterDate() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(AUG_04_2015_1201_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameInstantSameDate() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(AUG_04_2015_NOON_UTC_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameInstantDateEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(AUG_04_2015_NOON_CET_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameInstantDateLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(AUG_04_2015_NOON_EST_AS_DATE, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameInstantEarlierDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(2015, AUGUST, 4, 11, 59, 0, 0, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameInstantLaterDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(2015, AUGUST, 4, 12, 0, 1, 0, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameInstantLaterSameDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameInstantDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.CET));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameInstantDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.EST));
	}
}
