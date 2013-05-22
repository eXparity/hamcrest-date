/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsNot.*;
import static uk.co.it.modular.hamcrest.date.DateMatchers.*;
import static uk.co.it.modular.hamcrest.date.testutils.Dates.JAN_1ST_2012_11_AM_GMT;
import java.util.Date;
import org.junit.Test;
import uk.co.it.modular.hamcrest.date.testutils.Dates;

/**
 * Unit Tests for the {@link IsSameInstant} class
 * 
 * @author Stewart Bissett
 */
public class IsSameInstantTest {

	@Test
	public void canCompareTheSameInstant() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, sameInstant(date));
	}

	@Test
	public void canDetectDifferentInstants() {
		Date date = new Date(), other = new Date(date.getTime() + 1);
		assertThat(other, not(sameInstant(date)));
	}

	@Test
	public void canCompareTheSameLinuxTimstamp() {
		assertThat(JAN_1ST_2012_11_AM_GMT, sameInstant(1325415600000L));
	}

	@Test
	public void canDetectDifferentLinuxTimstamp() {
		assertThat(JAN_1ST_2012_11_AM_GMT, not(sameInstant(1L)));
	}

}
