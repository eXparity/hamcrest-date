/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static uk.co.it.modular.hamcrest.date.DateMatchers.sameDay;
import static uk.co.it.modular.hamcrest.date.Month.JANUARY;
import static uk.co.it.modular.hamcrest.date.testutils.DateMatcherTestUtils.*;
import org.junit.Test;
import uk.co.it.modular.hamcrest.date.testutils.Dates;
import uk.co.it.modular.hamcrest.date.testutils.TimeZones;

/**
 * Unit Tests for the {@link IsSameDay} class
 * 
 * @author Stewart Bissett
 */
public class IsSameDayTest {

	@Test
	public void canCompareTheSameExactDay() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, sameDay(Dates.JAN_1ST_2012_11_AM_GMT));
	}

	@Test
	public void canCompareTheSameDay() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, sameDay(Dates.JAN_1ST_2012_11_PM_GMT));
	}

	@Test
	public void canCompareADifferentDay() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, not(sameDay(Dates.JAN_2ND_2012_11_AM_GMT)));
	}

	@Test
	public void canCompareTheSameDayWithFields() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, sameDay(2012, JANUARY, 1));
	}

	@Test
	public void canCompareADifferentDayWithFields() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, not(sameDay(2012, JANUARY, 2)));
	}

	@Test
	public void canCompareTheSameDayInDifferentTimezones() {
		assertThat(Dates.JAN_1ST_2012_11_AM_PST, sameDay(Dates.JAN_1ST_2012_11_PM_GMT, TimeZones.GMT));
	}

	@Test
	public void canCompareADifferentDayAcrossTimezones() {
		assertThat(Dates.JAN_1ST_2012_11_PM_PST, not(sameDay(Dates.JAN_1ST_2012_11_AM_GMT, TimeZones.GMT)));
	}
}
