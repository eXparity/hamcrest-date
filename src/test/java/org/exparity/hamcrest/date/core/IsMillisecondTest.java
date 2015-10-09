package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_NOON_AS_DATE;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.DateMatchers;
import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameMillisecondOfDay} class
 *
 * @author Stewart Bissett
 */
public class IsMillisecondTest {

	// Date Matchers
	@Test
	public void isDateMillisecond() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isMillisecond(0));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotMillisecond() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isMillisecond(1));
	}
}
