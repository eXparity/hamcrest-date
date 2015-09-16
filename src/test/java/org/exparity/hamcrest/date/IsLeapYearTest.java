
package org.exparity.hamcrest.date;

import org.exparity.hamcrest.date.testutils.Dates;
import org.junit.Test;
import static org.exparity.hamcrest.date.DateMatchers.isLeapYear;
import static org.junit.Assert.assertThat;

/**
 * Unit test for {@link IsLeapYear}
 * 
 * @author Stewart Bissett
 */
public class IsLeapYearTest {

	@Test
	public void canMatch2012AsLeapYear() {
		assertThat(Dates.JAN_1_2012_11AM_UTC_AS_DATE, isLeapYear());
	}

	@Test
	public void canMatch2000AsLeapYear() {
		assertThat(Dates.JAN_1_2000_11AM_UTC_AS_DATE, isLeapYear());
	}

	@Test(expected = AssertionError.class)
	public void canMatch2013AsNotALeapYear() {
		assertThat(Dates.JAN_1ST_2013_11_AM, isLeapYear());
	}

	@Test(expected = AssertionError.class)
	public void canMatch2100AsNotALeapYear() {
		assertThat(Dates.JAN_1ST_2100_11_AM, isLeapYear());
	}
}
