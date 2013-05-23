/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import static java.util.Calendar.HOUR;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static uk.co.it.modular.hamcrest.date.DateMatchers.sameHour;
import static uk.co.it.modular.hamcrest.date.testutils.DateMatcherTestUtils.addDateField;
import java.util.Date;
import org.junit.Test;
import uk.co.it.modular.hamcrest.date.testutils.Dates;

/**
 * Unit Tests for the {@link IsSameHour} class
 * 
 * @author Stewart Bissett
 */
public class IsSameHourTest {

	@Test
	public void canCompareTheSameHour() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, sameHour(date));
	}

	@Test
	public void canCompareTheSameHourAsInt() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, sameHour(11));
	}

	@Test
	public void canDetectDifferentHour() {
		Date date = new Date(), other = addDateField(date, HOUR, 1);
		assertThat(other, not(sameHour(date)));
	}

	@Test
	public void canDetectDifferentHourAsInt() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, not(sameHour(12)));
	}

}
