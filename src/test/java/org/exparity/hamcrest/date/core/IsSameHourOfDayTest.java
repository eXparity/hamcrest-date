package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.DateMatcherTestUtils.addDateField;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_01_2012_MIDNIGHT_CET_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_01_2012_MIDNIGHT_GMT_AS_DATE;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.InstantMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.LocalTimeMatchers;
import org.exparity.hamcrest.date.OffsetDateTimeMatchers;
import org.exparity.hamcrest.date.testutils.ZoneIds;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link DateMatchers} class
 *
 * @author Stewart Bissett
 */
@SuppressWarnings("deprecation")
public class IsSameHourOfDayTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the hour [0-9]+?\\s     but: the date has the hour [0-9]+";

	// Date Matchers
	@Test
	public void isDateSameHour() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, DateMatchers.sameHour(date));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotSameHour() {
		Date date = new Date(), other = addDateField(date, Calendar.HOUR, 1);
		assertThat(other, DateMatchers.sameHour(date));
	}

	@Test
	public void isDateSameMonthDifferentDay() {
		Date date = new Date(), other = addDateField(date, Calendar.DAY_OF_WEEK, 1);
		assertThat(other, DateMatchers.sameHour(date));
	}

	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isSqlDateSameHour() {
		Date date = new Date(), other = new java.sql.Date(date.getTime());
		assertThat(other, DateMatchers.sameHour(date));
	}

	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isDateSameHourSqlDate() {
		Date date = new Date();
		java.sql.Date other = new java.sql.Date(date.getTime());
		assertThat(date, DateMatchers.sameHour(other));
	}
	
	@Test
	public void isDateSameHourOfDay() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, DateMatchers.sameHourOfDay(date));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotSameHourOfDay() {
		Date date = new Date(), other = addDateField(date, Calendar.HOUR, 1);
		assertThat(other, DateMatchers.sameHourOfDay(date));
	}

	@Test
	public void isDateSameHourOfDayDifferentDay() {
		Date date = new Date(), other = addDateField(date, Calendar.DAY_OF_WEEK, 1);
		assertThat(other, DateMatchers.sameHourOfDay(date));
	}
	
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameHourOfDayMidnightLocallyDifferentTimeZoneLowerOffsetPerspective() {
		assertThat(JAN_01_2012_MIDNIGHT_GMT_AS_DATE, DateMatchers.sameHourOfDay(JAN_01_2012_MIDNIGHT_CET_AS_DATE).atZone(ZoneIds.GMT));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameHourOfDayMidnightLocallyDifferentTimeZoneHigherOffsetPerspective() {
		assertThat(JAN_01_2012_MIDNIGHT_GMT_AS_DATE, DateMatchers.sameHourOfDay(JAN_01_2012_MIDNIGHT_CET_AS_DATE).atZone(ZoneIds.CET));
	}

	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isDateSameHourOfDaySqlDate() {
		Date date = new Date();
		java.sql.Date other = new java.sql.Date(date.getTime());
		assertThat(date, DateMatchers.sameHourOfDay(other));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeSameHourOfDay() {
		LocalDateTime date = LocalDateTime.now(), other = date;
		assertThat(other, LocalDateTimeMatchers.sameHourOfDay(date));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotSameHourOfDay() {
		LocalDateTime date = LocalDateTime.now(), other = date.plusHours(1);
		assertThat(other, LocalDateTimeMatchers.sameHourOfDay(date));
	}

	@Test
	public void isLocalDateTimeSameHourOfDayDifferentDay() {
		LocalDateTime date = LocalDateTime.now(), other = date.plusDays(1);
		assertThat(other, LocalDateTimeMatchers.sameHourOfDay(date));
	}

	// LocalTime Matchers
	@Test
	public void isLocalTimeSameHourOfDay() {
		LocalTime date = LocalTime.now(), other = date;
		assertThat(other, LocalTimeMatchers.sameHourOfDay(date));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeNotSameHourOfDay() {
		LocalTime date = LocalTime.now(), other = date.plusHours(1);
		assertThat(other, LocalTimeMatchers.sameHourOfDay(date));
	}

	// OffsetDateTime Matchers
	@Test
	public void isOffsetDateTimeSameHourOfDay() {
		OffsetDateTime date = OffsetDateTime.now(), other = date;
		assertThat(other, OffsetDateTimeMatchers.sameHourOfDay(date));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isOffsetDateTimeNotSameHourOfDay() {
		OffsetDateTime date = OffsetDateTime.now(), other = date.plusHours(1);
		assertThat(other, OffsetDateTimeMatchers.sameHourOfDay(date));
	}

	@Test
	public void isOffsetDateTimeSameHourOfDayDifferentDay() {
		OffsetDateTime date = OffsetDateTime.now(), other = date.plusDays(1);
		assertThat(other, OffsetDateTimeMatchers.sameHourOfDay(date));
	}
	
    // Instant Matchers
    @Test
    public void isInstantSameHourOfDay() {
        Instant date = Instant.now(), other = date;
        assertThat(other, InstantMatchers.sameHourOfDay(date));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantNotSameHourOfDay() {
        Instant date = Instant.now(), other = date.plus(1, ChronoUnit.HOURS);
        assertThat(other, InstantMatchers.sameHourOfDay(date));
    }

    @Test
    public void isInstantSameHourOfDayDifferentDay() {
        Instant date = Instant.now(), other = date.plus(1, ChronoUnit.DAYS);
        assertThat(other, InstantMatchers.sameHourOfDay(date));
    }
}
