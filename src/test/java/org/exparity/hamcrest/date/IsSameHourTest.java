/*
 * Copyright (c) Modular IT Limited.
 */

package org.exparity.hamcrest.date;

import org.exparity.hamcrest.date.testutils.Dates;
import org.junit.Test;
import static org.exparity.hamcrest.date.DateMatchers.sameHour;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

/**
 * Unit Tests for the {@link IsSameHour} class
 * 
 * @author Stewart Bissett
 */
public class IsSameHourTest {

	@Test
	public void canMatchTheSameHour() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, sameHour(Dates.JAN_2ND_2012_11_AM_GMT));
	}

	@Test
	public void canMatchTheSameHourAsInt() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, sameHour(11));
	}

	@Test
	public void canMatchDifferentHour() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, not(sameHour(Dates.JAN_1ST_2012_11_PM_GMT)));
	}

	@Test
	public void canDetectDifferentHourAsInt() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, not(sameHour(12)));
	}

}
