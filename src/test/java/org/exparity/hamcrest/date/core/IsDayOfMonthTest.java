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
public class IsDayOfMonthTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the day of month [0-9]+?\\s     but: the date has the day of month [0-9]+?";

	// Date Matchers
	@Test
	public void isDateFirstDayOfMonth() {
		assertThat(AUG_01_2015_NOON_UTC_AS_DATE, DateMatchers.isDayOfMonth(1));
	}
	
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotFirstDayOfMonth() {
		assertThat(AUG_31_2015_NOON_UTC_AS_DATE, DateMatchers.isDayOfMonth(1));
	}

	@Test
	public void isDateLastDayOfMonth() {
		assertThat(AUG_31_2015_NOON_UTC_AS_DATE, DateMatchers.isDayOfMonth(31));
	}
	
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotLastDayOfMonth() {
		assertThat(AUG_01_2015_NOON_UTC_AS_DATE, DateMatchers.isDayOfMonth(31));
	}

	// java.sql.Date Matchers
	@Test
	public void isSqlDateFirstDayOfMonth() {
		assertThat(AUG_01_2015_AS_SQL, SqlDateMatchers.isDayOfMonth(1));
	}
	
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotFirstDayOfMonth() {
		assertThat(AUG_31_2015_AS_SQL, SqlDateMatchers.isDayOfMonth(1));
	}

	@Test
	public void isSqlDateLastDayOfMonth() {
		assertThat(AUG_31_2015_AS_SQL, SqlDateMatchers.isDayOfMonth(31));
	}
	
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotLastDayOfMonth() {
		assertThat(AUG_01_2015_AS_SQL, SqlDateMatchers.isDayOfMonth(31));
	}

	@Test
	public void isSqlDateFirstDayOfMonthUsingDateMatcher() {
		assertThat(AUG_01_2015_AS_SQL, DateMatchers.isDayOfMonth(1));
	}
	
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotFirstDayOfMonthUsingDateMatcher() {
		assertThat(AUG_31_2015_AS_SQL, DateMatchers.isDayOfMonth(1));
	}

	@Test
	public void isSqlDateLastDayOfMonthUsingDateMatcher() {
		assertThat(AUG_31_2015_AS_SQL, DateMatchers.isDayOfMonth(31));
	}
	
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isSqlDateNotLastDayOfMonthUsingDateMatcher() {
		assertThat(AUG_01_2015_AS_SQL, DateMatchers.isDayOfMonth(31));
	}
	
	// LocalDate Matchers
	@Test
	public void isLocalDateFirstDayOfMonth() {
		assertThat(AUG_01_2015, LocalDateMatchers.isDayOfMonth(1));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotFirstDayOfMonth() {
		assertThat(AUG_31_2015, LocalDateMatchers.isDayOfMonth(1));
	}

	@Test
	public void isLocalDateLastDayOfMonth() {
		assertThat(AUG_31_2015, LocalDateMatchers.isDayOfMonth(31));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotLastDayOfMonth() {
		assertThat(AUG_01_2015, LocalDateMatchers.isDayOfMonth(31));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeFirstDayOfMonth() {
		assertThat(AUG_01_2015_NOON, LocalDateTimeMatchers.isDayOfMonth(1));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotFirstDayOfMonth() {
		assertThat(AUG_31_2015_NOON, LocalDateTimeMatchers.isDayOfMonth(1));
	}

	@Test
	public void isLocalDateTimeLastDayOfMonth() {
		assertThat(AUG_31_2015_NOON, LocalDateTimeMatchers.isDayOfMonth(31));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotLastDayOfMonth() {
		assertThat(AUG_01_2015_NOON, LocalDateTimeMatchers.isDayOfMonth(31));
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeFirstDayOfMonth() {
		assertThat(AUG_01_2015_NOON_UTC, ZonedDateTimeMatchers.isDayOfMonth(1));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotFirstDayOfMonth() {
		assertThat(AUG_31_2015_NOON_UTC, ZonedDateTimeMatchers.isDayOfMonth(1));
	}

	@Test
	public void isZonedDateTimeLastDayOfMonth() {
		assertThat(AUG_31_2015_NOON_UTC, ZonedDateTimeMatchers.isDayOfMonth(31));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotLastDayOfMonth() {
		assertThat(AUG_01_2015_NOON_UTC, ZonedDateTimeMatchers.isDayOfMonth(31));
	}

    // OffsetDateTime Matchers
    @Test
    public void isOffsetDateTimeFirstDayOfMonth() {
        assertThat(AUG_01_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isDayOfMonth(1));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeNotFirstDayOfMonth() {
        assertThat(AUG_31_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isDayOfMonth(1));
    }

    @Test
    public void isOffsetDateTimeLastDayOfMonth() {
        assertThat(AUG_31_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isDayOfMonth(31));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeNotLastDayOfMonth() {
        assertThat(AUG_01_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isDayOfMonth(31));
    }

    // Instant Matchers
    @Test
    public void isInstantFirstDayOfMonth() {
        assertThat(AUG_01_2015_NOON_INSTANT_UTC, InstantMatchers.isDayOfMonth(1));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantNotFirstDayOfMonth() {
        assertThat(AUG_31_2015_NOON_INSTANT_UTC, InstantMatchers.isDayOfMonth(1));
    }

    @Test
    public void isInstantLastDayOfMonth() {
        assertThat(AUG_31_2015_NOON_INSTANT_UTC, InstantMatchers.isDayOfMonth(31));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantNotLastDayOfMonth() {
        assertThat(AUG_01_2015_NOON_INSTANT_UTC, InstantMatchers.isDayOfMonth(31));
    }

}
