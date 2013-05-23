/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import static java.util.Calendar.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsNot.*;
import static uk.co.it.modular.hamcrest.date.DateMatchers.*;
import static uk.co.it.modular.hamcrest.date.testutils.DateMatcherTestUtils.*;
import static uk.co.it.modular.hamcrest.date.testutils.Dates.JAN_1ST_2012_11_AM_GMT;
import java.util.Date;
import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameMonth} class
 * 
 * @author Stewart Bissett
 */
public class IsSameMonthTest {

	@Test
	public void canCompareTheSameMonth() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, sameMonth(date));
	}

	@Test
	public void canDetectDifferentMonths() {
		Date date = new Date(), other = addDateField(date, MONTH, 1);
		assertThat(other, not(sameMonth(date)));
	}

	@Test
	public void canCompareTheSameMonthInt() {
		assertThat(JAN_1ST_2012_11_AM_GMT, sameMonth(Months.JANUARY));
	}

	@Test
	public void canDetectDifferentMonthInt() {
		assertThat(JAN_1ST_2012_11_AM_GMT, not(sameMonth(Months.FEBRUARY)));
	}

}
