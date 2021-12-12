
package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.junit.Assert.assertThat;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.InstantMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.OffsetDateTimeMatchers;
import org.exparity.hamcrest.date.SqlDateMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.exparity.hamcrest.date.testutils.ZoneIds;
import org.testng.annotations.Test;

/**
 * Unit test for {@link IsLeapYear}
 *
 * @author Stewart Bisett
 */
public class IsLeapYearTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: a leap year\\s     but: the year (?s:.)+? is not a leap year";

	// Date Matchers
	@Test
	public void isDateLeapYear() {
		assertThat(AUG_04_2016_MIDNIGHT_UTC_AS_DATE, DateMatchers.isLeapYear());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotLeapYear() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isLeapYear());
	}

	@Test
	public void isDateLeapYearStartOfYearSameZone() {
		assertThat(JAN_01_2012_MIDNIGHT_CET_AS_DATE, DateMatchers.isLeapYear().atZone(ZoneIds.CET));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotLeapYearStartOfYearLaterZone() {
		assertThat(JAN_01_2012_MIDNIGHT_CET_AS_DATE, DateMatchers.isLeapYear().atZone(ZoneIds.UTC));
	}

	// java.sql.Date Matchers
	@Test
	public void isSqlDateLeapYear() {
		assertThat(AUG_04_2016_AS_SQL, SqlDateMatchers.isLeapYear());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotLeapYear() {
		assertThat(AUG_04_2015_AS_SQL, SqlDateMatchers.isLeapYear());
	}

	@Test
	public void isSqlDateLeapYearUsingDateMatchers() {
		assertThat(AUG_04_2016_AS_SQL, DateMatchers.isLeapYear());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotLeapYearUsingDateMatchers() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.isLeapYear());
	}
	
	// LocalDate Matchers
	@Test
	public void isLocalDateLeapYear() {
		assertThat(AUG_04_2016, LocalDateMatchers.isLeapYear());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotLeapYear() {
		assertThat(AUG_04_2015, LocalDateMatchers.isLeapYear());
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeLeapYear() {
		assertThat(AUG_04_2016_NOON, LocalDateTimeMatchers.isLeapYear());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotLeapYear() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isLeapYear());
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeLeapYear() {
		assertThat(AUG_04_2016_NOON_UTC, ZonedDateTimeMatchers.isLeapYear());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotLeapYear() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isLeapYear());
	}

	@Test
	public void isZonedDateTimeLeapYearStartOfYearSameZone() {
		assertThat(JAN_01_2012_MIDNIGHT_CET, ZonedDateTimeMatchers.isLeapYear().atZone(ZoneIds.CET));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotLeapYearStartOfYearLaterZone() {
		assertThat(JAN_01_2012_MIDNIGHT_CET, ZonedDateTimeMatchers.isLeapYear().atZone(ZoneIds.UTC));
	}

    // OffsetDateTime Matchers
	
    @Test
    public void isOffsetDateTimeLeapYear() {
        assertThat(AUG_04_2016_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isLeapYear());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeNotLeapYear() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isLeapYear());
    }

    @Test
    public void isOffsetDateTimeLeapYearStartOfYearSameZone() {
        assertThat(JAN_01_2012_MIDNIGHT_OFFSET_CET, OffsetDateTimeMatchers.isLeapYear().atZone(ZoneIds.CET));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeNotLeapYearStartOfYearLaterZone() {
        assertThat(JAN_01_2012_MIDNIGHT_OFFSET_CET, OffsetDateTimeMatchers.isLeapYear().atZone(ZoneIds.UTC));
    }
    
    // Instant Matchers
    
    @Test
    public void isInstantLeapYear() {
        assertThat(AUG_04_2016_NOON_INSTANT_UTC, InstantMatchers.isLeapYear());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantNotLeapYear() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.isLeapYear());
    }

    @Test
    public void isInstantLeapYearStartOfYearSameZone() {
        assertThat(JAN_01_2012_MIDNIGHT_INSTANT_CET, InstantMatchers.isLeapYear().atZone(ZoneIds.CET));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantNotLeapYearStartOfYearLaterZone() {
        assertThat(JAN_01_2012_MIDNIGHT_INSTANT_CET, InstantMatchers.isLeapYear().atZone(ZoneIds.UTC));
    }
}
