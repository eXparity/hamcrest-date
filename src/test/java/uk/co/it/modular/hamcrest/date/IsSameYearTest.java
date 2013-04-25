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
}
