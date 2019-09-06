package org.exparity.hamcrest.date.core.format;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Locale;

import org.exparity.hamcrest.date.testutils.Dates;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

/**
 * Unit test for the {@link LocalDateFormatter} class
 *
 * @author Stewart Bissett
 */
public class LocalDateFormatterTest {

    @Test
    public void canDescribe() {
        String description = new LocalDateFormatter(Locale.US).describe(Dates.AUG_04_2015);
        assertThat(description, Matchers.equalTo("Tue, 04 Aug 2015"));
    }

    @Test
    public void canDescribeDate() {
        String description = new LocalDateFormatter(Locale.US).describeDate(Dates.AUG_04_2015);
        assertThat(description, Matchers.equalTo("Tue, 04 Aug 2015"));
    }

}
