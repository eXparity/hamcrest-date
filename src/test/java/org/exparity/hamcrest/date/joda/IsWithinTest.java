package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_05_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_05_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_05_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_06_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_06_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_06_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_07_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_07_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_07_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.NOON;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.UTC;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.joda.time.DateTimeConstants.AUGUST;

import org.exparity.hamcrest.date.core.IsWithin;
import org.joda.time.DurationFieldType;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link IsWithin} class
 *
 * @author Thomas Naskali
 */
public class IsWithinTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date is within [0-9]+? [\\w ]+? of (?s:.)+?\\s     but: the date is (?s:.)+? and [0-9]+? [\\w ]+? different";

	// LocalDate Matchers
	@Test
	public void isLocalDateWithinSameLocalDate() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.within(2, DurationFieldType.days(), AUG_04_2015));
	}

	@Test
	public void isLocalDateWithinLocalDateInsideLimit() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.within(2, DurationFieldType.days(), AUG_05_2015));
	}

	@Test
	public void isLocalDateWithinLocalDateEqualLimit() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.within(2, DurationFieldType.days(), AUG_06_2015));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateWithinLocalDateOutsideLimit() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.within(2, DurationFieldType.days(), AUG_07_2015));
	}

	@Test
	public void isLocalDateWithinSameDayMonthYear() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.within(2, DurationFieldType.days(), 2015, AUGUST, 4));
	}

	@Test
	public void isLocalDateWithinDayMonthYearInsideLimit() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.within(2, DurationFieldType.days(), 2015, AUGUST, 5));
	}

	@Test
	public void isLocalDateWithinDayMonthYearEqualLimit() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.within(2, DurationFieldType.days(), 2015, AUGUST, 6));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateWithinDayMonthYearOutsideLimit() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.within(2, DurationFieldType.days(), 2015, AUGUST, 7));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeWithinSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.within(2, DurationFieldType.days(), AUG_04_2015_NOON));
	}

	@Test
	public void isLocalDateTimeWithinLocalDateTimeInsideLimit() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.within(2, DurationFieldType.days(), AUG_05_2015_NOON));
	}

	@Test
	public void isLocalDateTimeWithinLocalDateTimeEqualLimit() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.within(2, DurationFieldType.days(), AUG_06_2015_NOON));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeWithinLocalDateTimeOutsideLimit() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.within(2, DurationFieldType.days(), AUG_07_2015_NOON));
	}

	@Test
	public void isLocalDateTimeWithinSameDayMonthYear() {
		assertThat(AUG_04_2015_NOON,
				JodaLocalDateTimeMatchers.within(2, DurationFieldType.millis(), 2015, AUGUST, 4, 12, 0, 0, 0));
	}

	@Test
	public void isLocalDateTimeWithinDayMonthYearInsideLimit() {
		assertThat(AUG_04_2015_NOON,
				JodaLocalDateTimeMatchers.within(2, DurationFieldType.millis(), 2015, AUGUST, 4, 12, 0, 0, 1));
	}

	@Test
	public void isLocalDateTimeWithinDayMonthYearEqualLimit() {
		assertThat(AUG_04_2015_NOON,
				JodaLocalDateTimeMatchers.within(2, DurationFieldType.millis(), 2015, AUGUST, 4, 12, 0, 0, 2));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeWithinDayMonthYearOutsideLimit() {
		assertThat(AUG_04_2015_NOON,
				JodaLocalDateTimeMatchers.within(2, DurationFieldType.millis(), 2015, AUGUST, 4, 12, 0, 0, 3));
	}

  // LocalTime Matchers
 	@Test
 	public void isLocalTimeWithSameLocalTime() {
 		assertThat(NOON, JodaLocalTimeMatchers.within(2, DurationFieldType.seconds(), NOON));
 	}

 	@Test
 	public void isLocalTimeWithSameLocalTimeInsideLimit() {
 		assertThat(NOON, JodaLocalTimeMatchers.within(2, DurationFieldType.seconds(), NOON.plusSeconds(1)));
 	}

 	@Test
 	public void isLocalTimeWithSameLocalTimeEqualLimit() {
 		assertThat(NOON, JodaLocalTimeMatchers.within(2, DurationFieldType.seconds(), NOON.plusSeconds(2)));
 	}

 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isLocalTimeWithSameLocalTimeOutsideLimit() {
 		assertThat(NOON, JodaLocalTimeMatchers.within(2, DurationFieldType.seconds(), NOON.plusSeconds(3)));
 	}

 	@Test
 	public void isLocalTimeWithSameTime() {
 		assertThat(NOON, JodaLocalTimeMatchers.within(2, DurationFieldType.seconds(), 12, 0, 0));
 	}

 	@Test
 	public void isLocalTimeWithSameTimeInsideLimit() {
 		assertThat(NOON, JodaLocalTimeMatchers.within(2, DurationFieldType.seconds(), 12, 0, 1));
 	}

 	@Test
 	public void isLocalTimeWithSameTimeEqualLimit() {
 		assertThat(NOON, JodaLocalTimeMatchers.within(2, DurationFieldType.seconds(), 12, 0, 2));
 	}

 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isLocalTimeWithSameTimeOutsideLimit() {
 		assertThat(NOON, JodaLocalTimeMatchers.within(2, DurationFieldType.seconds(), 12, 0, 3));
 	}

	// DateTime Matchers
	@Test
	public void isDateTimeWithinSameDateTime() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.within(2, DurationFieldType.days(), AUG_04_2015_NOON_UTC));
	}

	@Test
	public void isDateTimeWithinDateTimeInsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.within(2, DurationFieldType.days(), AUG_05_2015_NOON_UTC));
	}

	@Test
	public void isDateTimeWithinDateTimeEqualLimit() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.within(2, DurationFieldType.days(), AUG_06_2015_NOON_UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeWithinDateTimeOutsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.within(2, DurationFieldType.days(), AUG_07_2015_NOON_UTC));
	}

	@Test
	public void isDateTimeWithinSameDayMonthYear() {
		assertThat(AUG_04_2015_NOON_UTC,
				JodaDateTimeMatchers.within(2, DurationFieldType.millis(), 2015, AUGUST, 4, 12, 0, 0, 0, UTC));
	}

	@Test
	public void isDateTimeWithinDayMonthYearInsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC,
				JodaDateTimeMatchers.within(2, DurationFieldType.millis(), 2015, AUGUST, 4, 12, 0, 0, 1, UTC));
	}

	@Test
	public void isDateTimeWithinDayMonthYearEqualLimit() {
		assertThat(AUG_04_2015_NOON_UTC,
				JodaDateTimeMatchers.within(2, DurationFieldType.millis(), 2015, AUGUST, 4, 12, 0, 0, 2, UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeWithinDayMonthYearOutsideLimit() {
		assertThat(AUG_04_2015_NOON_UTC,
				JodaDateTimeMatchers.within(2, DurationFieldType.millis(), 2015, AUGUST, 4, 12, 0, 0, 3, UTC));
	}
}
