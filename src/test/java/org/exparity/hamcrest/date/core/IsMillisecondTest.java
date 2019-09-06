package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.DateMatchers;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link IsMillisecond} class
 *
 * @author Stewart Bissett
 */
@SuppressWarnings("deprecation")
public class IsMillisecondTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the millisecond [0-9]+?\\s     but: the date has the millisecond [0-9]+";

	// Date Matchers
	@Test
	public void isDateMillisecond() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isMillisecond(0));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotMillisecond() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isMillisecond(1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = DateMatchers.UNSUPPORTED_SQL_DATE_UNIT)
	public void isSqlDateMillisecond() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.isMillisecond(0));
	}

	@Test
	public void isDateSameMillisecond() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.sameMillisecond(0));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotSameMillisecond() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.sameMillisecond(1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = DateMatchers.UNSUPPORTED_SQL_DATE_UNIT)
	public void isSqlDateSameMillisecond() {
		assertThat(AUG_04_2015_AS_SQL, DateMatchers.sameMillisecond(0));
	}
}
