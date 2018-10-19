package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_03_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_01PM_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_1159;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_11AM_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_1201;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_CET;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_EST;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_05_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.JUN_14_2012;
import static org.exparity.hamcrest.date.testutils.JodaDates.JUN_15_2012;
import static org.exparity.hamcrest.date.testutils.JodaDates.JUN_15_2012_11AM_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.JUN_15_2012_11PM_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.JUN_16_2012;
import static org.exparity.hamcrest.date.testutils.JodaDates.NOON;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.CET;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.EST;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import org.joda.time.DateTimeConstants;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link JodaDateTimeMatchers} class
 *
 * @author Thomas Naskali
 */
public class IsBeforeTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is before (?s:.)+?\\s     but: date is (?s:.)+";

    // LocalDate Matchers
    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateBeforeLaterLocalDate() {
        assertThat(AUG_04_2015, JodaLocalDateMatchers.before(AUG_03_2015));
    }

    @Test
    public void isLocalDateBeforeEarlierLocalDate() {
        assertThat(AUG_04_2015, JodaLocalDateMatchers.before(AUG_05_2015));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateBeforeLaterSameLocalDate() {
        assertThat(AUG_04_2015, JodaLocalDateMatchers.before(AUG_04_2015));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateBeforeLaterDay() {
        assertThat(AUG_04_2015, JodaLocalDateMatchers.before(2015, 8, 3));
    }

    @Test
    public void isLocalDateBeforeEarlierDay() {
        assertThat(AUG_04_2015, JodaLocalDateMatchers.before(2015, 8, 5));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateBeforeSameDay() {
        assertThat(AUG_04_2015, JodaLocalDateMatchers.before(2015, 8, 4));
    }

    // LocalDateTime Matchers
    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeBeforeLaterLocalDateTime() {
        assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.before(AUG_04_2015_1159));
    }

    @Test
    public void isLocalDateTimeBeforeEarlierLocalDateTime() {
        assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.before(AUG_04_2015_1201));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeBeforeLaterSameLocalDateTime() {
        assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.before(AUG_04_2015_NOON));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeBeforeLaterDateTime() {
        assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.before(2015, 8, 4, 11, 59, 0));
    }

    @Test
    public void isLocalDateTimeBeforeEarlierDateTime() {
        assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.before(2015, 8, 4, 12, 0, 1));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isLocalDateTimeBeforeSameDateTime() {
        assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.before(2015, DateTimeConstants.AUGUST, 4, 12, 0, 0));
    }

	// LocalTime Matchers
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeBeforeEarlierLocalTime() {
		assertThat(NOON, JodaLocalTimeMatchers.before(NOON.minusSeconds(1)));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeBeforeSameLocalTime() {
		assertThat(NOON, JodaLocalTimeMatchers.before(NOON));
	}

	@Test
	public void isLocalTimeBeforeLaterLocalTime() {
		assertThat(NOON, JodaLocalTimeMatchers.before(NOON.plusSeconds(1)));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeBeforeEarlierTime() {
		assertThat(NOON, JodaLocalTimeMatchers.before(11, 59, 59));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeBeforeSameTime() {
		assertThat(NOON, JodaLocalTimeMatchers.before(12, 0, 0));
	}

	@Test
	public void isLocalTimeBeforeLaterTime() {
		assertThat(NOON, JodaLocalTimeMatchers.before(12, 0, 1));
	}

    // DateTime Matchers
    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateTimeBeforeLaterDateTime() {
        assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.before(AUG_04_2015_11AM_UTC));
    }

    @Test
    public void isDateTimeBeforeEarlierDateTime() {
        assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.before(AUG_04_2015_01PM_UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateTimeBeforeLaterSameDateTime() {
        assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.before(AUG_04_2015_NOON_UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateTimeBeforeDateTimeEarlierZone() {
        assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.before(AUG_04_2015_NOON_CET));
    }

    @Test
    public void isDateTimeBeforeDateTimeLaterZone() {
        assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.before(AUG_04_2015_NOON_EST));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateTimeBeforeLaterDateTimeAsFields() {
        assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.before(2015, 8, 4, 11, 59, 0, 0, UTC));
    }

    @Test
    public void isDateTimeBeforeEarlierDateTimeAsFields() {
        assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.before(2015, 8, 4, 12, 0, 1, 0, UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateTimeBeforeSameDateTimeAsFields() {
        assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.before(2015, 8, 4, 12, 0, 0, 0, UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isDateTimeBeforeDateTimeAsFieldsEarlierZone() {
        assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.before(2015, 8, 4, 12, 0, 0, 0, CET));
    }

    @Test
    public void isDateTimeBeforeDateTimeAsFieldsLaterZone() {
        assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.before(2015, 8, 4, 12, 0, 0, 0, EST));
    }

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateBeforeLaterLocalDateWithDefaultTimeZone() {
 		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.before(JUN_14_2012).atZone(UTC));
 	}

 	@Test
 	public void isDateBeforeEarlierLocalDateWithDefaultTimeZone() {
 		assertThat(JUN_15_2012_11AM_UTC, JodaDateTimeMatchers.before(JUN_16_2012).atZone(UTC));
 	}

 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateBeforeLaterSameLocalDateWithDefaultTimeZone() {
 		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.before(JUN_15_2012).atZone(UTC));
 	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateBeforeLaterLocalDate() {
		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.before(JUN_14_2012, UTC).atZone(UTC));
	}

	@Test
	public void isDateBeforeEarlierLocalDate() {
		assertThat(JUN_15_2012_11AM_UTC, JodaDateTimeMatchers.before(JUN_16_2012, UTC).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateBeforeLaterSameLocalDate() {
		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.before(JUN_15_2012, UTC).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateBeforeLaterDeprecatedDateValuesWithDefaultTimeZone() {
 		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.before(2012, DateTimeConstants.JUNE, 14).atZone(UTC));
 	}

 	@Test
 	public void isDateBeforeEarlierDeprecatedDateValuesWithDefaultTimeZone() {
 		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.before(2012, DateTimeConstants.JUNE, 16).atZone(UTC));
 	}

 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateBeforeLaterSameDeprecatedDateValuesWithDefaultTimeZone() {
 		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.before(2012, DateTimeConstants.JUNE, 15).atZone(UTC));
 	}

 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateBeforeLaterDateValuesWithDefaultTimeZone() {
 		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.before(2012, DateTimeConstants.JUNE, 14).atZone(UTC));
 	}

 	@Test
 	public void isDateBeforeEarlierDateValuesWithDefaultTimeZone() {
 		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.before(2012, DateTimeConstants.JUNE, 16).atZone(UTC));
 	}

 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateBeforeLaterSameDateValuesWithDefaultTimeZone() {
 		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.before(2012, DateTimeConstants.JUNE, 15).atZone(UTC));
 	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateBeforeLaterDeprecatedDateValues() {
		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.before(2012, DateTimeConstants.JUNE, 14, UTC).atZone(UTC));
	}

	@Test
	public void isDateBeforeEarlierDeprecatedDateValues() {
		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.before(2012, DateTimeConstants.JUNE, 16, UTC).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateBeforeLaterSameDeprecatedDateValues() {
		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.before(2012, DateTimeConstants.JUNE, 15, UTC).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateBeforeLaterDateValues() {
		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.before(2012, DateTimeConstants.JUNE, 14, UTC).atZone(UTC));
	}

	@Test
	public void isDateBeforeEarlierDateValues() {
		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.before(2012, DateTimeConstants.JUNE, 16, UTC).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateBeforeLaterSameDateValues() {
		assertThat(JUN_15_2012_11PM_UTC, JodaDateTimeMatchers.before(2012, DateTimeConstants.JUNE, 15, UTC).atZone(UTC));
	}

}
