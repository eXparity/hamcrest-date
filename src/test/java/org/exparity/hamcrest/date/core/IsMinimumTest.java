package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.LocalTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.junit.Test;

/**
 * @author <a href="mailto:stewart@modular-it.co.uk">Stewart Bissett</a>
 */
public class IsMinimumTest {

	// Date Matchers
	@Test
	public void isDateFirstDayOfMonth() {
		assertThat(AUG_01_2015_NOON_AS_DATE, DateMatchers.isFirstDayOfMonth());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotFirstDayOfMonth() {
		assertThat(AUG_31_2015_NOON_AS_DATE, DateMatchers.isFirstDayOfMonth());
	}

	// LocalDate Matchers
	@Test
	public void isLocalDateFirstDayOfMonth() {
		assertThat(AUG_01_2015, LocalDateMatchers.isFirstDayOfMonth());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotFirstDayOfMonth() {
		assertThat(AUG_31_2015, LocalDateMatchers.isFirstDayOfMonth());
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeFirstDayOfMonth() {
		assertThat(AUG_01_2015_NOON, LocalDateTimeMatchers.isFirstDayOfMonth());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotFirstDayOfMonth() {
		assertThat(AUG_31_2015_NOON, LocalDateTimeMatchers.isFirstDayOfMonth());
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeFirstDayOfMonth() {
		assertThat(AUG_01_2015_NOON_UTC, ZonedDateTimeMatchers.isFirstDayOfMonth());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotFirstDayOfMonth() {
		assertThat(AUG_31_2015_NOON_UTC, ZonedDateTimeMatchers.isFirstDayOfMonth());
	}

	// LocalTime Matchers
	@Test
	public void isLocalTimeFirstHourOfDay() {
		assertThat(LocalTime.of(0, 0, 0), LocalTimeMatchers.isMinimum(ChronoField.HOUR_OF_DAY));
	}

	@Test(expected = AssertionError.class)
	public void isLocalTimeNotFirstHourOfDay() {
		assertThat(LocalTime.of(1, 0, 0), LocalTimeMatchers.isMinimum(ChronoField.HOUR_OF_DAY));
	}
}
