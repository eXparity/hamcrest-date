package org.exparity.hamcrest.date.core.format;

import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.testutils.Dates;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

/**
 * Unit test for the {@link ZonedDateTimeFormatter} class
 *
 * @author Stewart Bissett
 */
public class ZonedDateTimeFormatterTest {

    @Test
    public void canDescribe() {
        String description = new ZonedDateTimeFormatter().describe(Dates.AUG_04_2015_11AM_UTC);
        assertThat(description, Matchers.equalTo("Tue, 04 Aug 2015 11:59:00.000 AM +0000"));
    }

    @Test
    public void canDescribeDate() {
        String description = new ZonedDateTimeFormatter().describeDate(Dates.AUG_04_2015_11AM_UTC);
        assertThat(description, Matchers.equalTo("Tue, 04 Aug 2015"));
    }

}
