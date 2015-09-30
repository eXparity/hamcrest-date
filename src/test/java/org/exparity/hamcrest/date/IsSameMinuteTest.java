package org.exparity.hamcrest.date;

import static java.util.Calendar.*;
import static org.exparity.hamcrest.date.DateMatchers.*;
import static org.exparity.hamcrest.date.testutils.DateMatcherTestUtils.*;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_01_2012_11AM_AS_DATE;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsNot.*;
import java.util.Date;
import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameMinuteOfHour} class
 * 
 * @author Stewart Bissett
 */
public class IsSameMinuteTest {

	@Test
	public void canCompareTheSameMinute() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, sameMinuteOfHour(date));
	}

	@Test
	public void canDetectDifferentMinute() {
		Date date = new Date(), other = addDateField(date, MINUTE, 1);
		assertThat(other, not(sameMinuteOfHour(date)));
	}

	@Test
	public void canCompareTheSameMinuteInt() {
		assertThat(JAN_01_2012_11AM_AS_DATE, isMinute(0));
	}

	@Test
	public void canDetectDifferentMinuteInt() {
		assertThat(JAN_01_2012_11AM_AS_DATE, not(isMinute(1)));
	}
}
