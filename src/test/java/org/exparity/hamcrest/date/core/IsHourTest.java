package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_NOON_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_NOON_UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameHourOfDay} class
 *
 * @author Stewart Bissett
 */
public class IsHourTest {

	// Date Matchers
	@Test
	public void isDateHour() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isHour(12));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotHour() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isHour(11));
	}

	@Test
	public void isDateSameHour() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.sameHour(12));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotSameHour() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.sameHour(11));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeHour() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isHour(12));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotHour() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isHour(11));
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeHour() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isHour(12));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotHour() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isHour(11));
	}

}
