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
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link DateMatchers} class
 *
 * @author Stewart Bissett
 */
@SuppressWarnings("deprecation")
public class IsSameMinuteOfHourTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the minute [0-9]+?\\s     but: the date has the minute [0-9]+";

	// Date Matchers
	@Test
	public void isDateSameMinute() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, DateMatchers.sameMinute(date));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotSameMinute() {
		Date date = new Date(), other = addDateField(date, Calendar.MINUTE, 1);
		assertThat(other, DateMatchers.sameMinute(date));
	}

	@Test
	public void isDateSameMonthDifferentHour() {
		Date date = new Date(), other = addDateField(date, Calendar.HOUR, 1);
		assertThat(other, DateMatchers.sameMinute(date));
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = DateMatchers.UNSUPPORTED_SQL_DATE_UNIT)
	public void isSqlDateSameMinute() {
		Date date = new Date(), other = new java.sql.Date(date.getTime());
		assertThat(other, DateMatchers.sameMinute(date));
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = DateMatchers.UNSUPPORTED_SQL_DATE_UNIT)
	public void isDateSameMinuteSqlDate() {
		Date date = new Date();
		java.sql.Date other = new java.sql.Date(date.getTime());
		assertThat(other, DateMatchers.sameMinute(date));
	}
	
	@Test
	public void isDateSameMinuteOfHour() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, DateMatchers.sameMinuteOfHour(date));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotSameMinuteOfHour() {
		Date date = new Date(), other = addDateField(date, Calendar.MINUTE, 1);
		assertThat(other, DateMatchers.sameMinuteOfHour(date));
	}

	@Test
	public void isDateSameMinuteOfHourDifferentHour() {
		Date date = new Date(), other = addDateField(date, Calendar.HOUR, 1);
		assertThat(other, DateMatchers.sameMinuteOfHour(date));
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = DateMatchers.UNSUPPORTED_SQL_DATE_UNIT)
	public void isSqlDateSameMinuteOfHour() {
		Date date = new Date(), other = new java.sql.Date(date.getTime());
		assertThat(other, DateMatchers.sameMinuteOfHour(date));
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = DateMatchers.UNSUPPORTED_SQL_DATE_UNIT)
	public void isSameMinuteOfHourSqlDate() {
		Date date = new Date();
		java.sql.Date other = new java.sql.Date(date.getTime());
		assertThat(other, DateMatchers.sameMinuteOfHour(date));
	}
	
	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeSameMinuteOfHour() {
		LocalDateTime date = LocalDateTime.now(), other = date;
		assertThat(other, LocalDateTimeMatchers.sameMinuteOfHour(date));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
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

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
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

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
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
