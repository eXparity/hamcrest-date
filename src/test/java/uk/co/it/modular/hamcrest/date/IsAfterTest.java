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
public class IsAfterTest {

	public void matchesLaterDates() {
		Date date = new Date(), other = addDateField(date, SECOND, 1);
		assertThat(other, after(date));
	}

	@Test
	public void doesNotMatchEarlierDates() {
		Date date = new Date(), other = addDateField(date, SECOND, -1);
		assertThat(other, not(after(date)));
	}

	@Test
	public void doesNotMatchSameDate() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, not(after(date)));
	}
}
