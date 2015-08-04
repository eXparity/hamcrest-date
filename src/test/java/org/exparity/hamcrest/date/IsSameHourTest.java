package org.exparity.hamcrest.date;

import org.exparity.hamcrest.date.testutils.Dates;
import org.junit.Test;
import static org.exparity.hamcrest.date.DateMatchers.sameHourOfDay;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

/**
 * Unit Tests for the {@link IsSameHourOfDay} class
 * 
 * @author Stewart Bissett
 */
public class IsSameHourTest {

	@Test
	public void canMatchTheSameHour() {
		assertThat(Dates.JAN_1ST_2012_11_AM, sameHourOfDay(Dates.JAN_2ND_2012_11_AM));
	}

	@Test
	public void canMatchTheSameHourAsInt() {
		assertThat(Dates.JAN_1ST_2012_11_AM, sameHourOfDay(11));
	}

	@Test
	public void canMatchDifferentHour() {
		assertThat(Dates.JAN_1ST_2012_11_AM, not(sameHourOfDay(Dates.JAN_1ST_2012_11_PM)));
	}

	@Test
	public void canDetectDifferentHourAsInt() {
		assertThat(Dates.JAN_1ST_2012_11_AM, not(sameHourOfDay(12)));
	}

}
