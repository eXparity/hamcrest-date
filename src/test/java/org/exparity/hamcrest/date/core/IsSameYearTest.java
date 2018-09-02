package org.exparity.hamcrest.date.core;

import static java.util.Calendar.YEAR;
import static org.exparity.hamcrest.date.testutils.DateMatcherTestUtils.addDateField;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.testng.annotations.Test;

/**
 * @author Stewart Bissett
 */
public class IsSameYearTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the year [0-9]+?\\s     but: the date has the year [0-9]+";

	// Date Matchers
	@Test
	public void isDateSameYear() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, DateMatchers.sameYear(date));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotSameYear() {
		Date date = new Date(), other = addDateField(date, YEAR, 1);
		assertThat(other, DateMatchers.sameYear(date));
	}

	// LocalDate Matchers
	@Test
	public void isLocalDateSameYear() {
		LocalDate date = LocalDate.now(), other = date;
		assertThat(other, LocalDateMatchers.sameYear(date));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotSameYear() {
		LocalDate date = LocalDate.now(), other = date.plusYears(1);
		assertThat(other, LocalDateMatchers.sameYear(date));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeSameYear() {
		LocalDateTime date = LocalDateTime.now(), other = date;
		assertThat(other, LocalDateTimeMatchers.sameYear(date));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotSameYear() {
		LocalDateTime date = LocalDateTime.now(), other = date.plusYears(1);
		assertThat(other, LocalDateTimeMatchers.sameYear(date));
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeSameYear() {
		ZonedDateTime date = ZonedDateTime.now(), other = date;
		assertThat(other, ZonedDateTimeMatchers.sameYear(date));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotSameYear() {
		ZonedDateTime date = ZonedDateTime.now(), other = date.plusYears(1);
		assertThat(other, ZonedDateTimeMatchers.sameYear(date));
	}
}
