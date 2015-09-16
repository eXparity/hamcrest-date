package org.exparity.hamcrest.date;

import org.junit.Test;
import static org.exparity.hamcrest.date.DateMatchers.isFirstDayOfMonth;
import static org.exparity.hamcrest.date.DateMatchers.isLastDayOfMonth;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_01_2012_11AM_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_31_2012_11AM_AS_DATE;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author <a href="mailto:stewart@modular-it.co.uk">Stewart Bissett</a>
 */
public class IsDayOfMonthTest {

	@Test
	public void canMatchFirstDayOfMonth() {
		assertThat(JAN_01_2012_11AM_AS_DATE, isFirstDayOfMonth());
	}

	@Test(expected = AssertionError.class)
	public void canNotMatchFirstDayOfMonth() {
		assertThat(JAN_31_2012_11AM_AS_DATE, isFirstDayOfMonth());
	}

	@Test
	public void canMatchLastDayOfMonth() {
		assertThat(JAN_31_2012_11AM_AS_DATE, isLastDayOfMonth());
	}

	@Test(expected = AssertionError.class)
	public void canNotMatchLastDayOfMonth() {
		assertThat(JAN_01_2012_11AM_AS_DATE, isLastDayOfMonth());
	}
}
