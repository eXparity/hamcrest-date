package org.exparity.hamcrest.date;

import static org.exparity.hamcrest.date.DateMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

import org.exparity.hamcrest.date.testutils.Dates;
import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameHourOfDay} class
 *
 * @author Stewart Bissett
 */
public class IsSameHourTest {

	@Test
	public void canMatchTheSameHour() {
		assertThat(Dates.JAN_01_2012_11AM_AS_DATE, sameHourOfDay(Dates.JAN_02_2012_11AM_AS_DATE));
	}

	@Test
	public void canMatchTheSameHourAsInt() {
		assertThat(Dates.JAN_01_2012_11AM_AS_DATE, isHour(11));
	}

	@Test
	public void canMatchDifferentHour() {
		assertThat(Dates.JAN_01_2012_11AM_AS_DATE, not(sameHourOfDay(Dates.JAN_01_2012_11PM_AS_DATE)));
	}

	@Test
	public void canDetectDifferentHourAsInt() {
		assertThat(Dates.JAN_01_2012_11AM_AS_DATE, not(isHour(12)));
	}

}
