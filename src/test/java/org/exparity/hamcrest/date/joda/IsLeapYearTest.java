
package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2016;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2016_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2016_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2012_MIDN_CET;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.CET;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.UTC;
import static org.junit.Assert.assertThat;

import org.exparity.hamcrest.date.core.IsLeapYear;
import org.testng.annotations.Test;

/**
 * Unit test for {@link IsLeapYear}
 *
 * @author Thomas Naskali
 */
public class IsLeapYearTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: a leap year\\s     but: the date (?s:.)+? is not a leap year";

	// LocalDate Matchers
	@Test
	public void isLocalDateLeapYear() {
		assertThat(AUG_04_2016, JodaLocalDateMatchers.isLeapYear());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotLeapYear() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.isLeapYear());
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeLeapYear() {
		assertThat(AUG_04_2016_NOON, JodaLocalDateTimeMatchers.isLeapYear());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotLeapYear() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isLeapYear());
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeLeapYear() {
		assertThat(AUG_04_2016_NOON_UTC, JodaDateTimeMatchers.isLeapYear());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotLeapYear() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isLeapYear());
	}

	@Test
	public void isZonedDateLeapYearStartOfYearSameZone() {
		assertThat(JAN_01_2012_MIDN_CET, JodaDateTimeMatchers.isLeapYear().atZone(CET));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateNotLeapYearStartOfYearLaterZone() {
		assertThat(JAN_01_2012_MIDN_CET, JodaDateTimeMatchers.isLeapYear().atZone(UTC));
	}

}
