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
 * Unit Tests for the {@link IsSameMinute} class
 * 
 * @author Stewart Bissett
 */
public class IsSameMinuteTest {

	@Test
	public void canCompareTheSameMinute() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, sameMinute(date));
	}

	@Test
	public void canDetectDifferentMinute() {
		Date date = new Date(), other = addDateField(date, MINUTE, 1);
		assertThat(other, not(sameMinute(date)));
	}

	@Test
	public void canCompareTheSameMinuteInt() {
		assertThat(JAN_1ST_2012_11_AM, sameMinute(0));
	}

	@Test
	public void canDetectDifferentMinuteInt() {
		assertThat(JAN_1ST_2012_11_AM, not(sameMinute(1)));
	}
}
