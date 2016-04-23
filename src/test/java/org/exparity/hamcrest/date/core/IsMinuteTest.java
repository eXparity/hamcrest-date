package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_NOON_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_NOON_UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalTime;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.LocalTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameMinuteOfDay} class
 *
 * @author Stewart Bissett
 */
public class IsMinuteTest {

	// Date Matchers
	@Test
	public void isDateMinute() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isMinute(0));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotMinute() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isMinute(1));
	}

	@Test
	public void isDateSameMinute() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.sameMinute(0));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotSameMinute() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.sameMinute(1));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeMinute() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isMinute(0));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotMinute() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isMinute(1));
	}

	// LocalTime Matchers
	@Test
	public void isLocalTimeMinute() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.isMinute(0));
	}

	@Test(expected = AssertionError.class)
	public void isLocalTimeNotMinute() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.isMinute(1));
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeMinute() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isMinute(0));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotMinute() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isMinute(1));
	}

}
