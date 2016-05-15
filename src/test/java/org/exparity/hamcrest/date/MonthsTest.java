package org.exparity.hamcrest.date;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

/**
 * @author Stewart Bissett
 */
@SuppressWarnings("deprecation")
public class MonthsTest {

    @Test
    public void canCreateJanuaryFromCalendar() {
        assertThat(Months.fromCalendar(0), Matchers.equalTo(Months.JAN));
    }

    @Test
    public void canCreateFebruaryFromCalendar() {
        assertThat(Months.fromCalendar(1), Matchers.equalTo(Months.FEB));
    }

    @Test
    public void canCreateMarchFromCalendar() {
        assertThat(Months.fromCalendar(2), Matchers.equalTo(Months.MAR));
    }

    @Test
    public void canCreateAprilFromCalendar() {
        assertThat(Months.fromCalendar(3), Matchers.equalTo(Months.APR));
    }

    @Test
    public void canCreateMayFromCalendar() {
        assertThat(Months.fromCalendar(4), Matchers.equalTo(Months.MAY));
    }

    @Test
    public void canCreateJuneFromCalendar() {
        assertThat(Months.fromCalendar(5), Matchers.equalTo(Months.JUN));
    }

    @Test
    public void canCreateJulyFromCalendar() {
        assertThat(Months.fromCalendar(6), Matchers.equalTo(Months.JUL));
    }

    @Test
    public void canCreateAugustFromCalendar() {
        assertThat(Months.fromCalendar(7), Matchers.equalTo(Months.AUG));
    }

    @Test
    public void canCreateSeptembeFromCalendar() {
        assertThat(Months.fromCalendar(8), Matchers.equalTo(Months.SEP));
    }

    @Test
    public void canCreateOctoberFromCalendar() {
        assertThat(Months.fromCalendar(9), Matchers.equalTo(Months.OCT));
    }

    @Test
    public void canCreateNovembeFromCalendar() {
        assertThat(Months.fromCalendar(10), Matchers.equalTo(Months.NOV));
    }

    @Test
    public void canCreateDecemberFromCalendar() {
        assertThat(Months.fromCalendar(11), Matchers.equalTo(Months.DEC));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void canErrorIfMonthLow() {
        Months.fromCalendar(-1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void canErrorIfMonthHigh() {
        Months.fromCalendar(12);
    }

}
