/*
 * Copyright (c) Modular IT Limited.
 */

package org.exparity.hamcrest.date;

import org.junit.Test;
import static org.exparity.hamcrest.date.DateMatchers.isFirstDayOfMonth;
import static org.exparity.hamcrest.date.DateMatchers.isLastDayOfMonth;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_1ST_2012_11_AM_GMT;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_31ST_2012_11_AM_GMT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

/**
 * @author <a href="mailto:stewart@modular-it.co.uk">Stewart Bissett</a>
 */
public class IsDayOfMonthTest {

	@Test
	public void canMatchFirstDayOfMonth() {
		assertThat(JAN_1ST_2012_11_AM_GMT, isFirstDayOfMonth());
	}

	@Test
	public void canNotMatchFirstDayOfMonth() {
		assertThat(JAN_31ST_2012_11_AM_GMT, not(isFirstDayOfMonth()));
	}

	@Test
	public void canMatchLastDayOfMonth() {
		assertThat(JAN_31ST_2012_11_AM_GMT, isLastDayOfMonth());
	}

	@Test
	public void canNotMatchLastDayOfMonth() {
		assertThat(JAN_1ST_2012_11_AM_GMT, not(isLastDayOfMonth()));
	}
}
