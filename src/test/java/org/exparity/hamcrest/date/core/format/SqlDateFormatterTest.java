package org.exparity.hamcrest.date.core.format;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Locale;

import org.exparity.hamcrest.date.testutils.Dates;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

/**
 * Unit test for the {@link SqlDateFormatter} class
 *
 * @author Stewart Bissett
 */
public class SqlDateFormatterTest {

    @Test
    public void canDescribe() {
        String description = new SqlDateFormatter(Locale.US).describe(Dates.AUG_04_2015_AS_SQL);
        assertThat(description, Matchers.equalTo("Tue, 04 Aug 2015"));
    }
    
    @Test
    public void canDescribeDate() {
        String description = new SqlDateFormatter(Locale.US).describeDate(Dates.AUG_04_2015_AS_SQL);
        assertThat(description, Matchers.equalTo("Tue, 04 Aug 2015"));
    }

}
