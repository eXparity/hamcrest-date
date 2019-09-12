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
public class IsSameSecondOfMinuteTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the second [0-9]+?\\s     but: the date has the second [0-9]+";

	// Date Matchers
	@Test
	public void isDateSameSecond() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, DateMatchers.sameSecond(date));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotSameMinute() {
		Date date = new Date(), other = addDateField(date, Calendar.SECOND, 1);
		assertThat(other, DateMatchers.sameSecond(date));
	}

	@Test
	public void isDateSameSecondDifferentMinute() {
		Date date = new Date(), other = addDateField(date, Calendar.MINUTE, 1);
		assertThat(other, DateMatchers.sameSecond(date));
	}

	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isSqlDateSameSecond() {
		Date date = new Date(), other = new java.sql.Date(date.getTime());
		assertThat(other, DateMatchers.sameSecond(date));
	}

	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isDateSameSecondSqlDate() {
		Date date = new Date();
		java.sql.Date other = new java.sql.Date(date.getTime());
		assertThat(date, DateMatchers.sameSecond(other));
	}
	
	@Test
	public void isDateSameSecondOfMinute() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, DateMatchers.sameSecondOfMinute(date));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotSameSecondOfMinute() {
		Date date = new Date(), other = addDateField(date, Calendar.SECOND, 1);
		assertThat(other, DateMatchers.sameSecondOfMinute(date));
	}

	@Test
	public void isDateSameSecondOfMinuteDifferentMinute() {
		Date date = new Date(), other = addDateField(date, Calendar.MINUTE, 1);
		assertThat(other, DateMatchers.sameSecondOfMinute(date));
	}

	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isSqlDateSameSecondOfMinute() {
		Date date = new Date(), other = new java.sql.Date(date.getTime());
		assertThat(other, DateMatchers.sameSecondOfMinute(date));
	}

	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isDateSameSecondOfMinuteSqlDate() {
		Date date = new Date();
		java.sql.Date other = new java.sql.Date(date.getTime());
		assertThat(date, DateMatchers.sameSecondOfMinute(other));
	}
	
	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeSameSecondOfMinute() {
		LocalDateTime date = LocalDateTime.now(), other = date;
		assertThat(other, LocalDateTimeMatchers.sameSecondOfMinute(date));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
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

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
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

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
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
