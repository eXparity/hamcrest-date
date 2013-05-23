/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static uk.co.it.modular.hamcrest.date.DateMatchers.sameDatePart;
import java.util.Calendar;
import org.junit.Test;
import uk.co.it.modular.hamcrest.date.testutils.Dates;

/**
 * Unit Tests for the {@link IsSameDatePart} class
 * 
 * @author Stewart Bissett
 */
public class IsSameDatePartTest {

	@Test
	public void canCompareADatePart() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, sameDatePart(Dates.JAN_1ST_2012_11_PM_GMT, Calendar.MONTH));
	}

	@Test
	public void canDetectDifferenceInDatePart() {
		assertThat(Dates.JAN_1ST_2012_11_AM_GMT, not(sameDatePart(Dates.JAN_1ST_2012_11_PM_GMT, Calendar.HOUR_OF_DAY)));
	}
}
