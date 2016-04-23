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
public class IsSameSecondOfMinuteTest {

	// Date Matchers
	@Test
	public void isDateSameHour() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, DateMatchers.sameSecond(date));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotSameMinute() {
		Date date = new Date(), other = addDateField(date, Calendar.SECOND, 1);
		assertThat(other, DateMatchers.sameSecond(date));
	}

	@Test
	public void isDateSameSecondDifferentMinute() {
		Date date = new Date(), other = addDateField(date, Calendar.MINUTE, 1);
		assertThat(other, DateMatchers.sameSecond(date));
	}

	@Test
	public void isDateSameSecondOfMinute() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, DateMatchers.sameSecondOfMinute(date));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotSameSecondOfMinute() {
		Date date = new Date(), other = addDateField(date, Calendar.SECOND, 1);
		assertThat(other, DateMatchers.sameSecondOfMinute(date));
	}

	@Test
	public void isDateSameSecondOfMinuteDifferentMinute() {
		Date date = new Date(), other = addDateField(date, Calendar.MINUTE, 1);
		assertThat(other, DateMatchers.sameSecondOfMinute(date));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeSameSecondOfMinute() {
		LocalDateTime date = LocalDateTime.now(), other = date;
		assertThat(other, LocalDateTimeMatchers.sameSecondOfMinute(date));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotSameSecondOfMinute() {
		LocalDateTime date = LocalDateTime.now(), other = date.plusSeconds(1);
		assertThat(other, LocalDateTimeMatchers.sameSecondOfMinute(date));
	}

	@Test
	public void isLocalDateTimeSameSecondOfMinuteDifferentMinute() {
		LocalDateTime date = LocalDateTime.now(), other = date.plusMinutes(1);
		assertThat(other, LocalDateTimeMatchers.sameSecondOfMinute(date));
	}

	// LocalTime Matchers
	@Test
	public void isLocalTimeSameSecondOfMinute() {
		LocalTime date = LocalTime.now(), other = date;
		assertThat(other, LocalTimeMatchers.sameSecondOfMinute(date));
	}

	@Test(expected = AssertionError.class)
	public void isLocalTimeNotSameSecondOfMinute() {
		LocalTime date = LocalTime.now(), other = date.plusSeconds(1);
		assertThat(other, LocalTimeMatchers.sameSecondOfMinute(date));
	}

	@Test
	public void isLocalTimeSameSecondOfMinuteDifferentMinute() {
		LocalTime date = LocalTime.now(), other = date.plusMinutes(1);
		assertThat(other, LocalTimeMatchers.sameSecondOfMinute(date));
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeSameSecondOfMinute() {
		ZonedDateTime date = ZonedDateTime.now(), other = date;
		assertThat(other, ZonedDateTimeMatchers.sameSecondOfMinute(date));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotSameSecondOfMinute() {
		ZonedDateTime date = ZonedDateTime.now(), other = date.plusSeconds(1);
		assertThat(other, ZonedDateTimeMatchers.sameSecondOfMinute(date));
	}

	@Test
	public void isZonedDateTimeSameSecondOfMinuteDifferentMinute() {
		ZonedDateTime date = ZonedDateTime.now(), other = date.plusMinutes(1);
		assertThat(other, ZonedDateTimeMatchers.sameSecondOfMinute(date));
	}
}
