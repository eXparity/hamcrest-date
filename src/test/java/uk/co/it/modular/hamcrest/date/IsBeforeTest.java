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
 * Unit Tests for the {@link IsSameYear} class
 * 
 * @author Stewart Bissett
 */
public class IsBeforeTest {

	@Test
	public void matchesEarlierDates() {
		Date date = new Date(), other = addDateField(date, SECOND, -1);
		assertThat(other, before(date));
	}

	@Test
	public void doesNotMatchLaterDates() {
		Date date = new Date(), other = addDateField(date, SECOND, 1);
		assertThat(other, not(before(date)));
	}

	@Test
	public void doesNotMatchSameDate() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, not(before(date)));
	}
}
