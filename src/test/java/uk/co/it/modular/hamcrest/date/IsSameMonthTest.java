/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import org.junit.Test;
import uk.co.it.modular.hamcrest.date.testutils.Dates;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static uk.co.it.modular.hamcrest.date.DateMatchers.sameMonth;
import static uk.co.it.modular.hamcrest.date.testutils.Dates.JAN_1ST_2012_11_AM_GMT;

/**
 * Unit Tests for the {@link IsSameMonth} class
 * 
 * @author Stewart Bissett
 */
public class IsSameMonthTest {

	@Test
	public void canCompareTheSameMonth() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, sameMonth(Dates.JAN_2ND_2012_11_AM_GMT));
	}

	@Test
	public void canDetectDifferentMonths() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, not(sameMonth(Dates.JUN_15TH_2012_11_AM)));
	}

	@Test
	public void canCompareTheSameMonthInt() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, sameMonth(Months.JANUARY));
	}

	@Test
	public void canDetectDifferentMonthInt() {
		assertThat(JAN_1ST_2012_11_AM_GMT, not(sameMonth(Months.FEBRUARY)));
	}

}
