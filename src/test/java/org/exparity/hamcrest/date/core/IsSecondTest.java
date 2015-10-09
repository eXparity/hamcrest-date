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
 * Unit Tests for the {@link IsSameSecondOfDay} class
 *
 * @author Stewart Bissett
 */
public class IsSecondTest {

	// Date Matchers
	@Test
	public void isDateSecond() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isSecond(0));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotSecond() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isSecond(1));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeSecond() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isSecond(0));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotSecond() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isSecond(1));
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeSecond() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isSecond(0));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotSecond() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isSecond(1));
	}

}
