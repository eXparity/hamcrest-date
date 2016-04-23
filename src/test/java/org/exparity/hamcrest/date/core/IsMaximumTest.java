package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.LocalTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.junit.Test;

/**
 * @author <a href="mailto:stewart@modular-it.co.uk">Stewart Bissett</a>
 */
public class IsMaximumTest {

	// Date Matchers
	@Test
	public void isDateLastDayOfMonth() {
		assertThat(AUG_31_2015_NOON_AS_DATE, DateMatchers.isLastDayOfMonth());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotLastDayOfMonth() {
		assertThat(AUG_01_2015_NOON_AS_DATE, DateMatchers.isLastDayOfMonth());
	}

	// LocalDate Matchers
	@Test
	public void isLocalDateLastDayOfMonth() {
		assertThat(AUG_31_2015, LocalDateMatchers.isLastDayOfMonth());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotLastDayOfMonth() {
		assertThat(AUG_01_2015, LocalDateMatchers.isLastDayOfMonth());
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeLastDayOfMonth() {
		assertThat(AUG_31_2015_NOON, LocalDateTimeMatchers.isLastDayOfMonth());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotLastDayOfMonth() {
		assertThat(AUG_01_2015_NOON, LocalDateTimeMatchers.isLastDayOfMonth());
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeLastDayOfMonth() {
		assertThat(AUG_31_2015_NOON_UTC, ZonedDateTimeMatchers.isLastDayOfMonth());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotLastDayOfMonth() {
		assertThat(AUG_01_2015_NOON_UTC, ZonedDateTimeMatchers.isLastDayOfMonth());
	}

	// LocalTime Matchers
	@Test
	public void isLocalTimeLastHourOfDay() {
		assertThat(LocalTime.of(23, 0, 0), LocalTimeMatchers.isMaximum(ChronoField.HOUR_OF_DAY));
	}

	@Test(expected = AssertionError.class)
	public void isLocalTimeNotLastHourOfDay() {
		assertThat(LocalTime.of(23, 0, 0), LocalTimeMatchers.isMaximum(ChronoField.HOUR_OF_DAY));
	}
}
