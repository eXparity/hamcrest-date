package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

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
public class IsLastDayOfMonthTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is the last day of the month\\s     but: date is the [0-9]+? day of the month";

	// Date Matchers
	@Test
	public void isDateLastDayOfMonth() {
		assertThat(AUG_31_2015_NOON_UTC_AS_DATE, DateMatchers.isLastDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotLastDayOfMonth() {
		assertThat(AUG_01_2015_NOON_UTC_AS_DATE, DateMatchers.isLastDayOfMonth());
	}

	// java.sql.Date Matchers
	public void isSqlDateLastDayOfMonth() {
		assertThat(AUG_31_2015_AS_SQL, SqlDateMatchers.isLastDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotLastDayOfMonth() {
		assertThat(AUG_01_2015_AS_SQL, SqlDateMatchers.isLastDayOfMonth());
	}

	public void isSqlDateLastDayOfMonthUsingDateMatchers() {
		assertThat(AUG_31_2015_AS_SQL, DateMatchers.isLastDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotLastDayOfMonthUsingDateMatchers() {
		assertThat(AUG_01_2015_AS_SQL, DateMatchers.isLastDayOfMonth());
	}
	
	// LocalDate Matchers
	@Test
	public void isLocalDateLastDayOfMonth() {
		assertThat(AUG_31_2015, LocalDateMatchers.isLastDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotLastDayOfMonth() {
		assertThat(AUG_01_2015, LocalDateMatchers.isLastDayOfMonth());
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeLastDayOfMonth() {
		assertThat(AUG_31_2015_NOON, LocalDateTimeMatchers.isLastDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotLastDayOfMonth() {
		assertThat(AUG_01_2015_NOON, LocalDateTimeMatchers.isLastDayOfMonth());
	}

	// ZonedDateTime Matchers
	
	@Test
	public void isZonedDateTimeLastDayOfMonth() {
		assertThat(AUG_31_2015_NOON_UTC, ZonedDateTimeMatchers.isLastDayOfMonth());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotLastDayOfMonth() {
		assertThat(AUG_01_2015_NOON_UTC, ZonedDateTimeMatchers.isLastDayOfMonth());
	}
	
    // OffsetDateTime Matchers
    
    @Test
    public void isOffsetDateTimeLastDayOfMonth() {
        assertThat(AUG_31_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isLastDayOfMonth());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeNotLastDayOfMonth() {
        assertThat(AUG_01_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isLastDayOfMonth());
    }
    
    // Instant Matchers
    
    @Test
    public void isInstantLastDayOfMonth() {
        assertThat(AUG_31_2015_NOON_INSTANT_UTC, InstantMatchers.isLastDayOfMonth());
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantNotLastDayOfMonth() {
        assertThat(AUG_01_2015_NOON_INSTANT_UTC, InstantMatchers.isLastDayOfMonth());
    }
}
