package org.exparity.hamcrest.date.core.format;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Locale;

import org.exparity.hamcrest.date.testutils.Dates;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

/**
 * Unit test for the {@link DateFormatter} class
 *
 * @author Stewart Bissett
 */
public class DateFormatterTest {

    @Test
    public void canDescribe() {
        String description = new DateFormatter(Locale.US).describe(Dates.AUG_04_2015_1159_DEFAULT_AS_DATE);
        assertThat(description, Matchers.equalTo("Tue, 04 Aug 2015 11:59:00.000 AM"));
    }

    @Test
    public void canDescribeDate() {
        String description = new DateFormatter(Locale.US).describeDate(Dates.AUG_04_2015_1159_DEFAULT_AS_DATE);
        assertThat(description, Matchers.equalTo("Tue, 04 Aug 2015"));
    }

    @Test
    public void canDescribeSqlDate() {
        String description = new DateFormatter(Locale.US).describe(Dates.AUG_04_2015_AS_SQL);
        assertThat(description, Matchers.equalTo("Tue, 04 Aug 2015"));
    }
    
    @Test
    public void canDescribeDateSqlDate() {
        String description = new DateFormatter(Locale.US).describeDate(Dates.AUG_04_2015_AS_SQL);
        assertThat(description, Matchers.equalTo("Tue, 04 Aug 2015"));
    }

}
