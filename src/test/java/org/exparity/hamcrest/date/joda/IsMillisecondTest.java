package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaTimeZones.UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.core.IsMillisecond;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link IsMillisecond} class
 *
 * @author Thomas Naskali
 */
public class IsMillisecondTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the millisecond [0-9]+?\\s     but: the date has the millisecond [0-9]+";

	// DateTime Matchers
	@Test
	public void isDateTimeMillisecond() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isMillisecond(0).atZone(UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeNotMillisecond() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isMillisecond(1).atZone(UTC));
	}

}
