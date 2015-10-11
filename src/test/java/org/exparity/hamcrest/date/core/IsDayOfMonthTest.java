package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.junit.Test;

/**
 * @author <a href="mailto:stewart@modular-it.co.uk">Stewart Bissett</a>
 */
public class IsDayOfMonthTest {

	// LocalDate Matchers
	@Test
	public void isLocalDateFirstDayOfMonth() {
		assertThat(AUG_01_2015, LocalDateMatchers.isDayOfMonth(1));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotFirstDayOfMonth() {
		assertThat(AUG_31_2015, LocalDateMatchers.isDayOfMonth(1));
	}

	@Test
	public void isLocalDateLastDayOfMonth() {
		assertThat(AUG_31_2015, LocalDateMatchers.isDayOfMonth(31));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotLastDayOfMonth() {
		assertThat(AUG_01_2015, LocalDateMatchers.isDayOfMonth(31));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeFirstDayOfMonth() {
		assertThat(AUG_01_2015_NOON, LocalDateTimeMatchers.isDayOfMonth(1));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotFirstDayOfMonth() {
		assertThat(AUG_31_2015_NOON, LocalDateTimeMatchers.isDayOfMonth(1));
	}

	@Test
	public void isLocalDateTimeLastDayOfMonth() {
		assertThat(AUG_31_2015_NOON, LocalDateTimeMatchers.isDayOfMonth(31));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotLastDayOfMonth() {
		assertThat(AUG_01_2015_NOON, LocalDateTimeMatchers.isDayOfMonth(31));
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeFirstDayOfMonth() {
		assertThat(AUG_01_2015_NOON_UTC, ZonedDateTimeMatchers.isDayOfMonth(1));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotFirstDayOfMonth() {
		assertThat(AUG_31_2015_NOON_UTC, ZonedDateTimeMatchers.isDayOfMonth(1));
	}

	@Test
	public void isZonedDateTimeLastDayOfMonth() {
		assertThat(AUG_31_2015_NOON_UTC, ZonedDateTimeMatchers.isDayOfMonth(31));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotLastDayOfMonth() {
		assertThat(AUG_01_2015_NOON_UTC, ZonedDateTimeMatchers.isDayOfMonth(31));
	}

}
