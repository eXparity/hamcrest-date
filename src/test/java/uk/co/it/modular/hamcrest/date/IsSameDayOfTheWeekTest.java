/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import static java.util.Calendar.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsNot.*;
import static uk.co.it.modular.hamcrest.date.DateMatchers.*;
import static uk.co.it.modular.hamcrest.date.testutils.DateMatcherTestUtils.*;
import java.util.Date;
import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameDayOfTheWeek} class
 * 
 * @author Stewart Bissett
 */
public class IsSameDayOfTheWeekTest {

	@Test
	public void canCompareTheSameDayOfWeek() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, sameWeekday(date));
	}

	@Test
	public void canDetectDifferentDaysOfTheWeek() {
		Date date = new Date(), other = addDateField(date, DAY_OF_MONTH, 1);
		assertThat(other, not(sameWeekday(date)));
	}
}
