
package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2016;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2016_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2016_NOON_UTC;
import static org.junit.Assert.assertThat;

import org.exparity.hamcrest.date.core.IsYear;
import org.testng.annotations.Test;

/**
 * Unit test for {@link IsYear}
 *
 * @author Thomas Naskali
 */
public class IsYearTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the year [0-9]+?\\s     but: the date has the year [0-9]+";

	// LocalDate Matchers
	@Test
	public void isLocalDateYear() {
		assertThat(AUG_04_2016, JodaLocalDateMatchers.isYear(2016));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotYear() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.isYear(2016));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeYear() {
		assertThat(AUG_04_2016_NOON, JodaLocalDateTimeMatchers.isYear(2016));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotYear() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isYear(2016));
	}

	// DateTime Matchers
	@Test
	public void isDateTimeYear() {
		assertThat(AUG_04_2016_NOON_UTC, JodaDateTimeMatchers.isYear(2016));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeNotYear() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isYear(2016));
	}

}
