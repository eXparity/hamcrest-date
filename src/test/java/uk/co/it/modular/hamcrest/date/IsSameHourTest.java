/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static uk.co.it.modular.hamcrest.date.DateMatchers.sameHour;

import org.exparity.hamcrest.date.IsSameHour;
import org.exparity.hamcrest.date.testutils.Dates;
import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameHour} class
 * 
 * @author Stewart Bissett
 */
public class IsSameHourTest {

	@Test
	public void canMatchTheSameHour() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, sameHour(Dates.JAN_2ND_2012_11_AM));
	}

	@Test
	public void canMatchTheSameHourAsInt() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, sameHour(11));
	}

	@Test
	public void canMatchDifferentHour() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, not(sameHour(Dates.JAN_1ST_2012_11_PM)));
	}

	@Test
	public void canDetectDifferentHourAsInt() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, not(sameHour(12)));
	}

}
