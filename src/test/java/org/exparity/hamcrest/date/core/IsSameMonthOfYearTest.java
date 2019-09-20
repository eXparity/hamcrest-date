package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.OffsetDateTimeMatchers;
import org.exparity.hamcrest.date.SqlDateMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.testng.annotations.Test;

/**
 * @author Stewart Bissett
 */
@SuppressWarnings("deprecation")
public class IsSameMonthOfYearTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the month [A-Z][a-z]+?\\s     but: the date has the month [A-Z][a-z]+?";

	// Date Matchers
	@Test
	public void isDateSameMonth() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.sameMonth(AUG_04_2015_NOON_UTC_AS_DATE));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotSameMonth() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.sameMonth(SEP_04_2015_NOON_UTC_AS_DATE));
	}

	@Test
	public void isDateSameMonthDifferentYear() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.sameMonth(AUG_04_2016_NOON_UTC_AS_DATE));
	}

	@Test
	public void isDateSameMonthOfYear() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.sameMonthOfYear(AUG_04_2015_NOON_UTC_AS_DATE));
	}
	
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotSameMonthOfYear() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.sameMonthOfYear(SEP_04_2015_NOON_UTC_AS_DATE));
	}

	@Test
	public void isDateSameMonthOfYearDifferentYear() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.sameMonthOfYear(AUG_04_2015_NOON_UTC_AS_DATE));
	}
	
	// java.sql.Date Matchers
	@Test
	public void isSqlDateSameMonth() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.sameMonth(AUG_04_2015_AS_SQL));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotSameMonth() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.sameMonth(SEP_04_2015_AS_SQL));
	}

	@Test
	public void isSqlDateSameMonthDifferentYear() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.sameMonth(AUG_04_2016_AS_SQL));
	}

	@Test
	public void isSqlDateSameMonthAsDate() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.sameMonth(AUG_04_2015_NOON_UTC_AS_DATE));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotSameMonthAsDate() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.sameMonth(SEP_04_2015_NOON_UTC_AS_DATE));
	}

	@Test
	public void isSqlDateSameMonthDifferentYearAsDate() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.sameMonth(AUG_04_2016_NOON_UTC_AS_DATE));
	}
	
	@Test
	public void isSqlDateSameMonthOfYear() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.sameMonthOfYear(AUG_04_2015_AS_SQL));
	}
	
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotSameMonthOfYear() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.sameMonthOfYear(SEP_04_2015_AS_SQL));
	}

	@Test
	public void isSqlDateSameMonthOfYearDifferentYear() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.sameMonthOfYear(AUG_04_2015_AS_SQL));
	}

	@Test
	public void isSqlDateSameMonthOfYearAsDate() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.sameMonthOfYear(AUG_04_2015_NOON_UTC_AS_DATE));
	}
	
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotSameMonthOfYearAsDate() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.sameMonthOfYear(SEP_04_2015_NOON_UTC_AS_DATE));
	}

	@Test
	public void isSqlDateSameMonthOfYearDifferentYearAsDate() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.sameMonthOfYear(AUG_04_2015_NOON_UTC_AS_DATE));
	}

	@Test
	public void isSqlDateSameMonthUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameMonth(AUG_04_2015_AS_SQL));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotSameMonthUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameMonth(SEP_04_2015_AS_SQL));
	}

	@Test
	public void isSqlDateSameMonthDifferentYearUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameMonth(AUG_04_2016_AS_SQL));
	}

	@Test
	public void isSqlDateSameMonthAsDateUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameMonth(AUG_04_2015_NOON_UTC_AS_DATE));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotSameMonthAsDateUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameMonth(SEP_04_2015_NOON_UTC_AS_DATE));
	}

	@Test
	public void isSqlDateSameMonthDifferentYearAsDateUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameMonth(AUG_04_2016_NOON_UTC_AS_DATE));
	}
	
	@Test
	public void isSqlDateSameMonthOfYearUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameMonthOfYear(AUG_04_2015_AS_SQL));
	}
	
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotSameMonthOfYearUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameMonthOfYear(SEP_04_2015_AS_SQL));
	}

	@Test
	public void isSqlDateSameMonthOfYearDifferentYearUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameMonthOfYear(AUG_04_2015_AS_SQL));
	}

	@Test
	public void isSqlDateSameMonthOfYearAsDateUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameMonthOfYear(AUG_04_2015_NOON_UTC_AS_DATE));
	}
	
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotSameMonthOfYearAsDateUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameMonthOfYear(SEP_04_2015_NOON_UTC_AS_DATE));
	}

	@Test
	public void isSqlDateSameMonthOfYearDifferentYearAsDateUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameMonthOfYear(AUG_04_2015_NOON_UTC_AS_DATE));
	}
	
	// LocalDate Matchers
	@Test
	public void isLocalDateSameMonthOfYear() {
		LocalDate date = LocalDate.now(), other = date;
		assertThat(other, LocalDateMatchers.sameMonthOfYear(date));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotSameMonthOfYear() {
		LocalDate date = LocalDate.now(), other = date.plusMonths(1);
		assertThat(other, LocalDateMatchers.sameMonthOfYear(date));
	}

	@Test
	public void isLocalDateSameMonthOfYearDifferentYear() {
		LocalDate date = LocalDate.now(), other = date.plusYears(1);
		assertThat(other, LocalDateMatchers.sameMonthOfYear(date));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeSameMonthOfYear() {
		LocalDateTime date = LocalDateTime.now(), other = date;
		assertThat(other, LocalDateTimeMatchers.sameMonthOfYear(date));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotSameMonthOfYear() {
		LocalDateTime date = LocalDateTime.now(), other = date.plusMonths(1);
		assertThat(other, LocalDateTimeMatchers.sameMonthOfYear(date));
	}

	@Test
	public void isLocalDateTimeSameMonthOfYearDifferentYear() {
		LocalDateTime date = LocalDateTime.now(), other = date.plusYears(1);
		assertThat(other, LocalDateTimeMatchers.sameMonthOfYear(date));
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeSameMonthOfYear() {
		ZonedDateTime date = ZonedDateTime.now(), other = date;
		assertThat(other, ZonedDateTimeMatchers.sameMonthOfYear(date));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotSameMonthOfYear() {
		ZonedDateTime date = ZonedDateTime.now(), other = date.plusMonths(1);
		assertThat(other, ZonedDateTimeMatchers.sameMonthOfYear(date));
	}

	@Test
	public void isZonedDateTimeSameMonthOfYearDifferentYear() {
		ZonedDateTime date = ZonedDateTime.now(), other = date.plusYears(1);
		assertThat(other, ZonedDateTimeMatchers.sameMonthOfYear(date));
	}

    // OffsetDateTime Matchers
    @Test
    public void isOffsetDateTimeSameMonthOfYear() {
        OffsetDateTime date = OffsetDateTime.now(), other = date;
        assertThat(other, OffsetDateTimeMatchers.sameMonthOfYear(date));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeNotSameMonthOfYear() {
        OffsetDateTime date = OffsetDateTime.now(), other = date.plusMonths(1);
        assertThat(other, OffsetDateTimeMatchers.sameMonthOfYear(date));
    }

    @Test
    public void isOffsetDateTimeSameMonthOfYearDifferentYear() {
        OffsetDateTime date = OffsetDateTime.now(), other = date.plusYears(1);
        assertThat(other, OffsetDateTimeMatchers.sameMonthOfYear(date));
    }
	
}
