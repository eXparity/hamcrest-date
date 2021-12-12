package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.InstantMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.OffsetDateTimeMatchers;
import org.exparity.hamcrest.date.SqlDateMatchers;
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
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.sameYear(SEP_04_2015_NOON_UTC_AS_DATE));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotSameYear() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.sameYear(AUG_04_2016_NOON_UTC_AS_DATE));
	}

	@Test
	public void isDateSameYearAsSqlDate() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.sameYear(SEP_04_2015_AS_SQL));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotSameYearAsSqlDate() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.sameYear(AUG_04_2016_AS_SQL));
	}
	
	// java.sql.Date Matchers
	@Test
	public void isSqlDateSameYear() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.sameYear(AUG_04_2015_AS_SQL));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotSameYear() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.sameYear(AUG_04_2016_AS_SQL));
	}
	
	@Test
	public void isSqlDateSameYearAsDate() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.sameYear(AUG_04_2015_NOON_UTC_AS_DATE));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotSameYearAsDate() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.sameYear(AUG_04_2016_NOON_UTC_AS_DATE));
	}
	
	@Test
	public void isSqlDateSameYearUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameYear(AUG_04_2015_AS_SQL));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotSameYearUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameYear(AUG_04_2016_AS_SQL));
	}
	
	@Test
	public void isSqlDateSameYearAsDateUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameYear(AUG_04_2015_NOON_UTC_AS_DATE));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotSameYearAsDateUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameYear(AUG_04_2016_NOON_UTC_AS_DATE));
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
	
    // OffsetDateTime Matchers
    @Test
    public void isOffsetDateTimeSameYear() {
        OffsetDateTime date = OffsetDateTime.now(), other = date;
        assertThat(other, OffsetDateTimeMatchers.sameYear(date));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeNotSameYear() {
        OffsetDateTime date = OffsetDateTime.now(), other = date.plusYears(1);
        assertThat(other, OffsetDateTimeMatchers.sameYear(date));
    }

    // Instant Matchers
    @Test
    public void isInstantSameYear() {
        Instant date = Instant.now(), other = date;
        assertThat(other, InstantMatchers.sameYear(date));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantNotSameYear() {
        Instant date = Instant.now(), other = ZonedDateTime.ofInstant(date, ZoneId.systemDefault()).plusYears(1).toInstant();
        assertThat(other, InstantMatchers.sameYear(date));
    }
}
