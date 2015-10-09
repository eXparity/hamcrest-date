
package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.junit.Assert.assertThat;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.exparity.hamcrest.date.core.IsLeapYear;
import org.junit.Test;

/**
 * Unit test for {@link IsLeapYear}
 *
 * @author Stewart Bissett
 */
public class IsLeapYearTest {

	// Date Matchers
	@Test
	public void isDateLeapYear() {
		assertThat(AUG_04_2016_AS_DATE, DateMatchers.isLeapYear());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotLeapYear() {
		assertThat(AUG_04_2015_AS_DATE, DateMatchers.isLeapYear());
	}

	// LocalDate Matchers
	@Test
	public void isLocalDateLeapYear() {
		assertThat(AUG_04_2016, LocalDateMatchers.isLeapYear());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotLeapYear() {
		assertThat(AUG_04_2015, LocalDateMatchers.isLeapYear());
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeLeapYear() {
		assertThat(AUG_04_2016_NOON, LocalDateTimeMatchers.isLeapYear());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotLeapYear() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isLeapYear());
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeLeapYear() {
		assertThat(AUG_04_2016_NOON_UTC, ZonedDateTimeMatchers.isLeapYear());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotLeapYear() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isLeapYear());
	}

}
