package org.exparity.hamcrest.date.core;

import static org.exparity.dates.en.FluentDateTime.JUN;
import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.exparity.hamcrest.date.testutils.TimeZones.UTC_AS_TZ;
import static org.exparity.hamcrest.date.testutils.ZoneIds.UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.junit.Test;

/**
 * Unit Tests for the {@link DateMatchers} class
 *
 * @author Stewart Bissett
 */
public class IsSameHourOfDayTest {

	// Date Matchers

	@Test
	public void isDateSameHourOfDaySameDateSameHour() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameHourOfDay(JUN(15, 2012).at(11)));
	}

	@Test(expected = AssertionError.class)
	public void isDateSameHourOfDaySameDateDifferentHour() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameHourOfDay(JUN(15, 2012).at(10)));
	}

	@Test
	public void isDateSameHourOfDayDifferentDateSameHour() {
		assertThat(JUN_15_2012_11AM_AS_DATE, DateMatchers.sameHourOfDay(JUN(14, 2012).at(11)));
	}

	// LocalDateTime Matchers

	@Test
	public void isLocalDateTimeSameHourOfDaySameDateSameHour() {
		assertThat(JUN_15_2012_NOON, LocalDateTimeMatchers.sameHourOfDay(JUN(15, 2012).at(12)));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeSameHourOfDaySameDateDifferentHour() {
		assertThat(JUN_15_2012_NOON, LocalDateTimeMatchers.sameHourOfDay(JUN(15, 2012).at(11)));
	}

	@Test
	public void isLocalDateTimeSameHourOfDayDifferentDateSameHour() {
		assertThat(JUN_15_2012_NOON, LocalDateTimeMatchers.sameHourOfDay(JUN(14, 2012).at(12)));
	}

	@Test
	public void isLocalDateTimeSameHourOfDaySameLocalDateTimeSameHour() {
		assertThat(JUN_15_2012_NOON, LocalDateTimeMatchers.sameHourOfDay(JUN_15_2012_NOON));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeSameHourOfDaySameLocalDateTimeDifferentHour() {
		assertThat(JUN_15_2012_NOON, LocalDateTimeMatchers.sameHourOfDay(JUN_15_2012_11AM));
	}

	@Test
	public void isLocalDateTimeSameHourOfDayDifferentLocalDateTimeSameHour() {
		assertThat(JUN_15_2012_NOON, LocalDateTimeMatchers.sameHourOfDay(JUN_14_2012_NOON));
	}

	// ZonedDateTime Matchers

	@Test
	public void isZonedDateTimeSameHourOfDaySameDateSameHour() {
		assertThat(JUN_15_2012_NOON_UTC, ZonedDateTimeMatchers.sameHourOfDay(JUN(15, 2012).at(12, UTC_AS_TZ), UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameHourOfDaySameDateDifferentHour() {
		assertThat(JUN_15_2012_NOON_UTC, ZonedDateTimeMatchers.sameHourOfDay(JUN(15, 2012).at(11, UTC_AS_TZ), UTC));
	}

	@Test
	public void isZonedDateTimeSameHourOfDayDifferentDateSameHour() {
		assertThat(JUN_15_2012_NOON_UTC, ZonedDateTimeMatchers.sameHourOfDay(JUN(14, 2012).at(12, UTC_AS_TZ), UTC));
	}

	@Test
	public void isZonedDateTimeSameHourOfDaySameZonedDateTimeSameHour() {
		assertThat(JUN_15_2012_NOON_UTC, ZonedDateTimeMatchers.sameHourOfDay(JUN_15_2012_NOON_UTC));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeSameHourOfDaySameZonedDateTimeDifferentHour() {
		assertThat(JUN_15_2012_NOON_UTC, ZonedDateTimeMatchers.sameHourOfDay(JUN_15_2012_11AM_UTC));
	}

	@Test
	public void isZonedDateTimeSameHourOfDayDifferentZonedDateTimeSameHour() {
		assertThat(JUN_15_2012_NOON_UTC, ZonedDateTimeMatchers.sameHourOfDay(JUN_14_2012_NOON_UTC));
	}

}
