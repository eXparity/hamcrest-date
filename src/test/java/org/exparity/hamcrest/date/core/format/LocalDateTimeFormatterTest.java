package org.exparity.hamcrest.date.core.format;

import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.testutils.Dates;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

/**
 * Unit test for the {@link LocalDateTimeFormatter} class
 *
 * @author Stewart Bissett
 */
public class LocalDateTimeFormatterTest {

    @Test
    public void canDescribe() {
        String description = new LocalDateTimeFormatter().describe(Dates.AUG_04_2015_1159);
        assertThat(description, Matchers.equalTo("Tue, 04 Aug 2015 11:59:00.000 AM"));
    }

    @Test
    public void canDescribeDate() {
        String description = new LocalDateTimeFormatter().describeDate(Dates.AUG_04_2015_1159);
        assertThat(description, Matchers.equalTo("Tue, 04 Aug 2015"));
    }

}
