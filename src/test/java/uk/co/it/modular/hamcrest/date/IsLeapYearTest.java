/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import org.junit.Test;
import uk.co.it.modular.hamcrest.date.testutils.Dates;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static uk.co.it.modular.hamcrest.date.DateMatchers.isLeapYear;

/**
 * Unit test for {@link IsLeapYear}
 * 
 * @author Stewart Bissett
 */
public class IsLeapYearTest {

	@Test
	public void canMatch2012AsLeapYear() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, isLeapYear());
	}

	@Test
	public void canMatch2000AsLeapYear() {
		assertThat(Dates.JAN_1ST_2000_11_AM_GMT, isLeapYear());
	}

	@Test
	public void canMatch2013AsNotALeapYear() {
		assertThat(Dates.JAN_1ST_2013_11_AM_GMT, not(isLeapYear()));
	}

	@Test
	public void canMatch2100AsNotALeapYear() {
		assertThat(Dates.JAN_1ST_2100_11_AM_GMT, not(isLeapYear()));
	}
}
