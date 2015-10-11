package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.DateMatcherTestUtils.addDateField;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

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
	public void isDateSameHour() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, DateMatchers.sameHour(date));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotSameHour() {
		Date date = new Date(), other = addDateField(date, Calendar.HOUR, 1);
		assertThat(other, DateMatchers.sameHour(date));
	}

	@Test
	public void isDateSameMonthDifferentDay() {
		Date date = new Date(), other = addDateField(date, Calendar.DAY_OF_WEEK, 1);
		assertThat(other, DateMatchers.sameHour(date));
	}

	@Test
	public void isDateSameHourOfDay() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, DateMatchers.sameHourOfDay(date));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotSameHourOfDay() {
		Date date = new Date(), other = addDateField(date, Calendar.HOUR, 1);
		assertThat(other, DateMatchers.sameHourOfDay(date));
	}

	@Test
	public void isDateSameHourOfDayDifferentDay() {
		Date date = new Date(), other = addDateField(date, Calendar.DAY_OF_WEEK, 1);
		assertThat(other, DateMatchers.sameHourOfDay(date));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeSameHourOfDay() {
		LocalDateTime date = LocalDateTime.now(), other = date;
		assertThat(other, LocalDateTimeMatchers.sameHourOfDay(date));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotSameHourOfDay() {
		LocalDateTime date = LocalDateTime.now(), other = date.plusHours(1);
		assertThat(other, LocalDateTimeMatchers.sameHourOfDay(date));
	}

	@Test
	public void isLocalDateTimeSameHourOfDayDifferentDay() {
		LocalDateTime date = LocalDateTime.now(), other = date.plusDays(1);
		assertThat(other, LocalDateTimeMatchers.sameHourOfDay(date));
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeSameHourOfDay() {
		ZonedDateTime date = ZonedDateTime.now(), other = date;
		assertThat(other, ZonedDateTimeMatchers.sameHourOfDay(date));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotSameHourOfDay() {
		ZonedDateTime date = ZonedDateTime.now(), other = date.plusHours(1);
		assertThat(other, ZonedDateTimeMatchers.sameHourOfDay(date));
	}

	@Test
	public void isZonedDateTimeSameHourOfDayDifferentDay() {
		ZonedDateTime date = ZonedDateTime.now(), other = date.plusDays(1);
		assertThat(other, ZonedDateTimeMatchers.sameHourOfDay(date));
	}
}
