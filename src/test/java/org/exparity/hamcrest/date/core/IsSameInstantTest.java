
package org.exparity.hamcrest.date.core;

import static java.time.Month.AUGUST;
import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.exparity.hamcrest.date.testutils.ZoneIds.UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.Month;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.InstantMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.Months;
import org.exparity.hamcrest.date.OffsetDateTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.exparity.hamcrest.date.testutils.ZoneIds;
import org.exparity.hamcrest.date.testutils.ZoneOffsets;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link DateMatchers} class
 *
 * @author Stewart Bissett
 */
@SuppressWarnings("deprecation")
public class IsSameInstantTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the same date as (?s:.)+?\\s     but: the date is (?s:.)+";

	// Date Matchers

    @Test(expectedExceptions = AssertionError.class, 
            expectedExceptionsMessageRegExp = "\\sExpected: the same date as 2012-06-15T11:00:00Z?\\s     but: the date is 2012-06-15T23:00:00Z")
	public void isDateSameInstantEarlierDate() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameInstant(JUN_15_2012_11AM_UTC_AS_DATE).atZone(UTC));
	}

    @Test(expectedExceptions = AssertionError.class, 
            expectedExceptionsMessageRegExp = "\\sExpected: the same date as 2012-06-15T23:00:00Z?\\s     but: the date is 2012-06-15T11:00:00Z")
	public void isDateSameInstantLaterDate() {
		assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.sameInstant(JUN_15_2012_11PM_UTC_AS_DATE).atZone(UTC));
	}

    @Test
    public void isDateSameInstantSameDate() {
        assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameInstant(JUN_15_2012_11PM_UTC_AS_DATE).atZone(UTC));
    }
    
	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameInstantSameDateDifferentTimeZone() {
		assertThat(JAN_01_2012_11AM_PST_AS_DATE, DateMatchers.sameInstant(JAN_01_2012_11AM_GMT_AS_DATE).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameInstantLaterSameDateDifferentTimeZone() {
		assertThat(JAN_01_2012_11AM_GMT_AS_DATE, DateMatchers.sameInstant(JAN_01_2012_11AM_PST_AS_DATE).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameInstantEarlierEpochTime() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameInstant(JUN_15_2012_11PM_UTC_AS_DATE.getTime() + 1).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameInstantLaterEpochTime() {
		assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.sameInstant(JUN_15_2012_11PM_UTC_AS_DATE.getTime() + 1).atZone(UTC));
	}

	@Test
	public void isDateSameInstantSameEpochTime() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameInstant(JUN_15_2012_11PM_UTC_AS_DATE.getTime()).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameInstantEarlierDateValue() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.isInstant(2012, Month.JUNE, 15, 23, 0, 0, 1).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameInstantLaterDateValue() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.isInstant(2012, Month.JUNE, 15, 22, 59, 59, 59).atZone(UTC));
	}

	@Test
	public void isDateSameInstantSameDateValue() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.isInstant(2012, Month.JUNE, 15, 23, 0, 0, 0).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameInstantEarlierDeprecatedDateValue() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameInstant(2012, Months.JUNE, 15, 23, 0, 0, 1).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateSameInstantLaterDeprecatedDateValue() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameInstant(2012, Months.JUNE, 15, 22, 59, 59, 59).atZone(UTC));
	}

	@Test
	public void isDateSameInstantSameDeprecatedDateValue() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameInstant(2012, Months.JUNE, 15, 23, 0, 0, 0).atZone(UTC));
	}

	// java.sql.Date Matchers
	
	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isDateSameInstantEarlierSqlDate() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameInstant(JUN_14_2012_AS_SQL).atZone(UTC));
	}

	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isDateSameInstantLaterSqlDate() {
		assertThat(JUN_15_2012_11AM_UTC_AS_DATE, DateMatchers.sameInstant(JUN_16_2012_AS_SQL).atZone(UTC));
	}

	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isDateSameInstantSameSqlDate() {
		assertThat(JUN_15_2012_11PM_UTC_AS_DATE, DateMatchers.sameInstant(JUN_15_2012_AS_SQL).atZone(UTC));
	}
	
    @Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
    public void isSqlDateSameInstantLaterDate() {
        assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameInstant(AUG_05_2015_NOON_UTC_AS_DATE).atZone(UTC));
    }

    @Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
    public void isSqlDateSameInstantEarlierDate() {
        assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameInstant(AUG_03_2015_NOON_UTC_AS_DATE).atZone(UTC));
    }

    @Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
    public void isSqlDateSameInstantSameDate() {
        assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameInstant(AUG_04_2015_NOON_UTC_AS_DATE).atZone(UTC));
    }
	
	// LocalDateTime Matchers

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameInstantEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameInstant(AUG_04_2015_1159));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameInstantLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameInstant(AUG_04_2015_1201));
	}

	@Test
	public void isLocalDateTimeSameInstantSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.sameInstant(AUG_04_2015_NOON));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameInstantEarlierDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isInstant(2015, AUGUST, 4, 11, 59, 0, 0));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeSameInstantLaterDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isInstant(2015, AUGUST, 4, 12, 0, 1, 0));
	}

	@Test
	public void isLocalDateTimeSameInstantLaterSameDateTime() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isInstant(2015, AUGUST, 4, 12, 0, 0, 0));
	}

	// ZonedDateTime Matchers

    @Test(expectedExceptions = AssertionError.class, 
            expectedExceptionsMessageRegExp = "\\sExpected: the same date as Tue, 04 Aug 2015 11:59:00.000 (am|AM) \\+0000?\\s     but: the date is Tue, 04 Aug 2015 12:00:00.000 (pm|PM) \\+0000")
	public void isZonedDateTimeSameInstantEarlierZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(AUG_04_2015_11AM_UTC));
	}

    @Test(expectedExceptions = AssertionError.class, 
            expectedExceptionsMessageRegExp = "\\sExpected: the same date as Tue, 04 Aug 2015 12:01:00.000 (pm|PM) \\+0000?\\s     but: the date is Tue, 04 Aug 2015 12:00:00.000 (pm|PM) \\+0000")
	public void isZonedDateTimeSameInstantLaterZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(AUG_04_2015_01PM_UTC));
	}

	@Test
	public void isZonedDateTimeSameInstantSameZonedDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(AUG_04_2015_NOON_UTC));
	}
	
    @Test(expectedExceptions = AssertionError.class, 
            expectedExceptionsMessageRegExp = "\\sExpected: the same date as Tue, 04 Aug 2015 12:00:00.000 (pm|PM) \\+0100?\\s     but: the date is Tue, 04 Aug 2015 12:00:00.000 (pm|PM) \\+0000")
	public void isZonedDateTimeSameInstantZonedDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(AUG_04_2015_NOON_CET));
	}

    @Test(expectedExceptions = AssertionError.class, 
            expectedExceptionsMessageRegExp = "\\sExpected: the same date as Tue, 04 Aug 2015 12:00:00.000 (pm|PM) -0500?\\s     but: the date is Tue, 04 Aug 2015 12:00:00.000 (pm|PM) \\+0000")
	public void isZonedDateTimeSameInstantZonedDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameInstant(AUG_04_2015_NOON_EST));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeSameInstantEarlierDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isInstant(2015, AUGUST, 4, 11, 59, 0, 0, ZoneIds.UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeSameInstantLaterDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isInstant(2015, AUGUST, 4, 12, 0, 1, 0, ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeSameInstantLaterSameDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isInstant(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeSameInstantDateTimeEarlierZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isInstant(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.CET));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeSameInstantDateTimeLaterZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isInstant(2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.EST));
	}
	
    // OffsetDateTime Matchers

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeSameInstantEarlierOffsetDateTime() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.sameInstant(AUG_04_2015_11AM_OFFSET_UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeSameInstantLaterOffsetDateTime() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.sameInstant(AUG_04_2015_01PM_OFFSET_UTC));
    }

    @Test
    public void isOffsetDateTimeSameInstantSameOffsetDateTime() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.sameInstant(AUG_04_2015_NOON_OFFSET_UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeSameInstantOffsetDateTimeEarlierZone() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.sameInstant(AUG_04_2015_NOON_OFFSET_CET));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeSameInstantOffsetDateTimeLaterZone() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.sameInstant(AUG_04_2015_NOON_OFFSET_EST));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeSameInstantEarlierDateTime() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isInstant(2015, AUGUST, 4, 11, 59, 0, 0, ZoneOffsets.UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeSameInstantLaterDateTime() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isInstant(2015, AUGUST, 4, 12, 0, 1, 0, ZoneOffsets.UTC));
    }

    @Test
    public void isOffsetDateTimeSameInstantLaterSameDateTime() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isInstant(2015, AUGUST, 4, 12, 0, 0, 0, ZoneOffsets.UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeSameInstantDateTimeEarlierZone() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isInstant(2015, AUGUST, 4, 12, 0, 0, 0, ZoneOffsets.CET));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeSameInstantDateTimeLaterZone() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isInstant(2015, AUGUST, 4, 12, 0, 0, 0, ZoneOffsets.EST));
    }

    // Instant Matchers

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantSameInstantEarlierInstant() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.sameInstant(AUG_04_2015_11AM_INSTANT_UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantSameInstantLaterInstant() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.sameInstant(AUG_04_2015_01PM_INSTANT_UTC));
    }

    @Test
    public void isInstantSameInstantSameInstant() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.sameInstant(AUG_04_2015_NOON_INSTANT_UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantSameInstantInstantEarlierZone() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.sameInstant(AUG_04_2015_NOON_INSTANT_CET));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantSameInstantInstantLaterZone() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.sameInstant(AUG_04_2015_NOON_INSTANT_EST));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantSameInstantEarlierDateTime() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.isInstant(2015, AUGUST, 4, 11, 59, 0, 0, ZoneOffsets.UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantSameInstantLaterDateTime() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.isInstant(2015, AUGUST, 4, 12, 0, 1, 0, ZoneOffsets.UTC));
    }

    @Test
    public void isInstantSameInstantLaterSameDateTime() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.isInstant(2015, AUGUST, 4, 12, 0, 0, 0, ZoneOffsets.UTC));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantSameInstantDateTimeEarlierZone() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.isInstant(2015, AUGUST, 4, 12, 0, 0, 0, ZoneOffsets.CET));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantSameInstantDateTimeLaterZone() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.isInstant(2015, AUGUST, 4, 12, 0, 0, 0, ZoneOffsets.EST));
    }

}
