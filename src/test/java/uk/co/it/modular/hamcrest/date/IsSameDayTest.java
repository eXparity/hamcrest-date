/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static uk.co.it.modular.hamcrest.date.DateMatchers.sameDay;
import static uk.co.it.modular.hamcrest.date.Months.JANUARY;
import org.junit.Test;
import uk.co.it.modular.hamcrest.date.testutils.Dates;

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
}
