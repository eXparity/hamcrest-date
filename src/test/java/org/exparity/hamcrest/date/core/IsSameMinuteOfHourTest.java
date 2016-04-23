package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.DateMatcherTestUtils.addDateField;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.LocalTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.junit.Test;

/**
 * Unit Tests for the {@link DateMatchers} class
 *
 * @author Stewart Bissett
 */
public class IsSameMinuteOfHourTest {

	// Date Matchers
	@Test
	public void isDateSameHour() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, DateMatchers.sameMinute(date));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotSameMinute() {
		Date date = new Date(), other = addDateField(date, Calendar.MINUTE, 1);
		assertThat(other, DateMatchers.sameMinute(date));
	}

	@Test
	public void isDateSameMonthDifferentHour() {
		Date date = new Date(), other = addDateField(date, Calendar.HOUR, 1);
		assertThat(other, DateMatchers.sameMinute(date));
	}

	@Test
	public void isDateSameMinuteOfHour() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, DateMatchers.sameMinuteOfHour(date));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotSameMinuteOfHour() {
		Date date = new Date(), other = addDateField(date, Calendar.MINUTE, 1);
		assertThat(other, DateMatchers.sameMinuteOfHour(date));
	}

	@Test
	public void isDateSameMinuteOfHourDifferentHour() {
		Date date = new Date(), other = addDateField(date, Calendar.HOUR, 1);
		assertThat(other, DateMatchers.sameMinuteOfHour(date));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeSameMinuteOfHour() {
		LocalDateTime date = LocalDateTime.now(), other = date;
		assertThat(other, LocalDateTimeMatchers.sameMinuteOfHour(date));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotSameMinuteOfHour() {
		LocalDateTime date = LocalDateTime.now(), other = date.plusMinutes(1);
		assertThat(other, LocalDateTimeMatchers.sameMinuteOfHour(date));
	}

	@Test
	public void isLocalDateTimeSameMinuteOfHourDifferentHour() {
		LocalDateTime date = LocalDateTime.now(), other = date.plusHours(1);
		assertThat(other, LocalDateTimeMatchers.sameMinuteOfHour(date));
	}

	// LocalTime Matchers
	@Test
	public void isLocalTimeSameMinuteOfHour() {
		LocalTime date = LocalTime.now(), other = date;
		assertThat(other, LocalTimeMatchers.sameMinuteOfHour(date));
	}

	@Test(expected = AssertionError.class)
	public void isLocalTimeNotSameMinuteOfHour() {
		LocalTime date = LocalTime.now(), other = date.plusMinutes(1);
		assertThat(other, LocalTimeMatchers.sameMinuteOfHour(date));
	}

	@Test
	public void isLocalTimeSameMinuteOfHourDifferentHour() {
		LocalTime date = LocalTime.now(), other = date.plusHours(1);
		assertThat(other, LocalTimeMatchers.sameMinuteOfHour(date));
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeSameMinuteOfHour() {
		ZonedDateTime date = ZonedDateTime.now(), other = date;
		assertThat(other, ZonedDateTimeMatchers.sameMinuteOfHour(date));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotSameMinuteOfHour() {
		ZonedDateTime date = ZonedDateTime.now(), other = date.plusMinutes(1);
		assertThat(other, ZonedDateTimeMatchers.sameMinuteOfHour(date));
	}

	@Test
	public void isZonedDateTimeSameMinuteOfHourDifferentHour() {
		ZonedDateTime date = ZonedDateTime.now(), other = date.plusHours(1);
		assertThat(other, ZonedDateTimeMatchers.sameMinuteOfHour(date));
	}
}
