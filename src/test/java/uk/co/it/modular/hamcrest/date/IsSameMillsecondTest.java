/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static uk.co.it.modular.hamcrest.date.DateMatchers.sameMillisecond;
import static uk.co.it.modular.hamcrest.date.testutils.DateMatcherTestUtils.addDateField;
import static uk.co.it.modular.hamcrest.date.testutils.Dates.JAN_1ST_2012_11_AM_GMT;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameSecond} class
 * 
 * @author Stewart Bissett
 */
public class IsSameMillsecondTest {

	@Test
	public void canCompareTheSameMillisecond() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, sameMillisecond(date));
	}

	@Test
	public void canDetectDifferentSecond() {
		Date date = new Date(), other = addDateField(date, Calendar.MILLISECOND, 1);
		assertThat(other, not(sameMillisecond(date)));
	}

	@Test
	public void canCompareTheSameSecondInt() {
		assertThat(JAN_1ST_2012_11_AM_GMT, sameMillisecond(0));
	}

	@Test
	public void canDetectDifferentSecondInt() {
		assertThat(JAN_1ST_2012_11_AM_GMT, not(sameMillisecond(1)));
	}

}
