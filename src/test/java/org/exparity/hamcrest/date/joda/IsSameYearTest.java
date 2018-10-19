package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2012;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2012_MIDN;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2012_MIDN_UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.Test;

/**
 * @author Thomas Naskali
 */
public class IsSameYearTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the year [0-9]+?\\s     but: the date has the year [0-9]+";

	// LocalDate Matchers
	@Test
	public void isLocalDateSameYear() {
		assertThat(JAN_01_2012, JodaLocalDateMatchers.sameYear(JAN_01_2012));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotSameYear() {
		assertThat(JAN_01_2012, JodaLocalDateMatchers.sameYear(JAN_01_2012.plusYears(1)));
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeSameYear() {
		assertThat(JAN_01_2012_MIDN, JodaLocalDateTimeMatchers.sameYear(JAN_01_2012_MIDN));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotSameYear() {
		assertThat(JAN_01_2012_MIDN, JodaLocalDateTimeMatchers.sameYear(JAN_01_2012_MIDN.plusYears(1)));
	}

	// DateTime Matchers
	@Test
	public void isDateTimeSameYear() {
		assertThat(JAN_01_2012_MIDN_UTC, JodaDateTimeMatchers.sameYear(JAN_01_2012_MIDN_UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeNotSameYear() {
		assertThat(JAN_01_2012_MIDN_UTC, JodaDateTimeMatchers.sameYear(JAN_01_2012_MIDN_UTC.plusYears(1)));
	}
}
