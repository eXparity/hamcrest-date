package org.exparity.hamcrest.date;

import static java.util.Calendar.*;
import static org.exparity.hamcrest.date.DateMatchers.*;
import static org.exparity.hamcrest.date.testutils.DateMatcherTestUtils.*;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_1ST_2012_11_AM;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsNot.*;
import java.util.Date;
import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameYear} class
 * 
 * @author Stewart Bissett
 */
public class IsSameYearTest {

	@Test
	public void canCompareTheSameYear() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, sameYear(date));
	}

	@Test
	public void canDetectDifferentYears() {
		Date date = new Date(), other = addDateField(date, YEAR, 1);
		assertThat(other, not(sameYear(date)));
	}

	@Test
	public void canCompareTheSameYearInt() {
		assertThat(JAN_1ST_2012_11_AM, sameYear(2012));
	}

	@Test
	public void canDetectDifferentYearInt() {
		assertThat(JAN_1ST_2012_11_AM, not(sameYear(2013)));
	}

}
