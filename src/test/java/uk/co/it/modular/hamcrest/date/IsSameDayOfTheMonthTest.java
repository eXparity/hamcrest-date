/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static uk.co.it.modular.hamcrest.date.DateMatchers.sameDayOfTheMonth;
import org.junit.Test;
import uk.co.it.modular.hamcrest.date.testutils.Dates;

/**
 * Unit Tests for the {@link IsSameDay} class
 * 
 * @author Stewart Bissett
 */
@SuppressWarnings("deprecation")
public class IsSameDayOfTheMonthTest {

	@Test
	public void canCompareTheSameExactDay() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, sameDayOfTheMonth(Dates.JAN_1ST_2012_11_AM_GMT));
	}

	@Test
	public void canCompareTheSameDay() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, sameDayOfTheMonth(Dates.JAN_1ST_2012_11_PM_GMT));
	}

	@Test
	public void canCompareADifferentDay() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, not(sameDayOfTheMonth(Dates.JAN_2ND_2012_11_AM_GMT)));
	}
}
