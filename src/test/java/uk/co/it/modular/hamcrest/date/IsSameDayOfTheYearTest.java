/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import static java.util.Calendar.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsNot.*;
import static uk.co.it.modular.hamcrest.date.AbstractDateMatcherTestUtils.*;
import static uk.co.it.modular.hamcrest.date.DateMatchers.*;
import java.util.Date;
import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameDayOfTheYear} class
 * 
 * @author Stewart Bissett
 */
public class IsSameDayOfTheYearTest {

	@Test
	public void canCompareTheSameDayOfYear() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, sameDay(date));
	}

	@Test
	public void canDetectDifferentDaysOfTheYear() {
		Date date = new Date(), other = addDateField(date, DAY_OF_YEAR, 1);
		assertThat(other, not(sameDay(date)));
	}

}
