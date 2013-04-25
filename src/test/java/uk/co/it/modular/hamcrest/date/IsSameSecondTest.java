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
 * Unit Tests for the {@link IsSameSecond} class
 * 
 * @author Stewart Bissett
 */
public class IsSameSecondTest {

	@Test
	public void canCompareTheSameSecond() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, sameSecond(date));
	}

	@Test
	public void canDetectDifferentSecond() {
		Date date = new Date(), other = addDateField(date, SECOND, 1);
		assertThat(other, not(sameSecond(date)));
	}

}
