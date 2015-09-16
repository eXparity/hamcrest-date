package org.exparity.hamcrest.date;

import static java.util.Calendar.*;
import static org.exparity.hamcrest.date.DateMatchers.*;
import static org.exparity.hamcrest.date.testutils.DateMatcherTestUtils.*;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_1_2012_11AM_UTC_AS_DATE;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsNot.*;
import java.util.Date;
import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameSecondOfMinute} class
 * 
 * @author Stewart Bissett
 */
public class IsSameSecondTest {

	@Test
	public void canCompareTheSameSecond() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, sameSecondOfMinute(date));
	}

	@Test
	public void canDetectDifferentSecond() {
		Date date = new Date(), other = addDateField(date, SECOND, 1);
		assertThat(other, not(sameSecondOfMinute(date)));
	}

	@Test
	public void canCompareTheSameSecondInt() {
		assertThat(JAN_1_2012_11AM_UTC_AS_DATE, sameSecondOfMinute(0));
	}

	@Test
	public void canDetectDifferentSecondInt() {
		assertThat(JAN_1_2012_11AM_UTC_AS_DATE, not(sameSecondOfMinute(1)));
	}

}
