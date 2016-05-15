package org.exparity.hamcrest.date.core.format;

import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

/**
 * Unit test for the {@link LocalTimeFormatter} class
 *
 * @author Stewart Bissett
 */
public class LocalTimeFormatterTest {

    @Test
    public void canDescribe() {
        String description = new LocalTimeFormatter().describe(LocalTime.NOON.minus(1, ChronoUnit.SECONDS));
        assertThat(description, Matchers.equalTo("11:59:59 AM"));
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void canDescribeDate() {
        new LocalTimeFormatter().describeDate(LocalTime.NOON.minus(1, ChronoUnit.SECONDS));
    }

}
