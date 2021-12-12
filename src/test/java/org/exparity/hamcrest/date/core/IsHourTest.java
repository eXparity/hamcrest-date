package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.exparity.hamcrest.date.testutils.ZoneIds.UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalTime;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.InstantMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.LocalTimeMatchers;
import org.exparity.hamcrest.date.OffsetDateTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.exparity.hamcrest.date.testutils.ZoneIds;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link IsHour} class
 *
 * @author Stewart Bissett
 */
@SuppressWarnings("deprecation")
public class IsHourTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the hour [0-9]+?\\s     but: the date has the hour [0-9]+";

	// Date Matchers
	@Test
	public void isDateHour() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isHour(12).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotHour() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isHour(11).atZone(UTC));
	}

	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isSqlDateHour() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.isHour(12).atZone(UTC));
	}
	
	@Test
	public void isDateSameHour() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.sameHour(12).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotSameHour() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.sameHour(11).atZone(UTC));
	}

	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isSqlDateSameHour() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameHour(12).atZone(UTC));
	}
	
	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeHour() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isHour(12));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotHour() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isHour(11));
	}

	// LocalTime Matchers
	@Test
	public void isLocalTimeHour() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.isHour(12));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalTimeNotHour() {
		assertThat(LocalTime.NOON, LocalTimeMatchers.isHour(11));
	}

	// ZonedDateTime Matchers
	
	@Test
	public void isZonedDateTimeHour() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isHour(12).atZone(ZoneIds.UTC));
	}

	@Test
	public void isZonedDateTimeHourOtherZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isHour(7).atZone(ZoneIds.EST));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotHourOtherZone() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isHour(12).atZone(ZoneIds.CET));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotHour() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isHour(11).atZone(ZoneIds.UTC));
	}

    // OffsetDateTime Matchers
    
    @Test
    public void isOffsetDateTimeHour() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isHour(12).atZone(ZoneIds.UTC));
    }

    @Test
    public void isOffsetDateTimeHourOtherZone() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isHour(7).atZone(ZoneIds.EST));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeNotHourOtherZone() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isHour(12).atZone(ZoneIds.CET));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isOffsetDateTimeNotHour() {
        assertThat(AUG_04_2015_NOON_OFFSET_UTC, OffsetDateTimeMatchers.isHour(11).atZone(ZoneIds.UTC));
    }
	
    // Instant Matchers
    
    @Test
    public void isInstantHour() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.isHour(12).atZone(ZoneIds.UTC));
    }

    @Test
    public void isInstantHourOtherZone() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.isHour(7).atZone(ZoneIds.EST));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantNotHourOtherZone() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.isHour(12).atZone(ZoneIds.CET));
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
    public void isInstantNotHour() {
        assertThat(AUG_04_2015_NOON_INSTANT_UTC, InstantMatchers.isHour(11).atZone(ZoneIds.UTC));
    }
}
