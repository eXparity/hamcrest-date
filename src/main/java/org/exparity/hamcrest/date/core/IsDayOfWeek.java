package org.exparity.hamcrest.date.core;

import java.time.DayOfWeek;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the same day of the week as the reference date
 *
 * @author Stewart Bissett
 */
public class IsDayOfWeek<T, Z> extends ZonedTemporalMatcher<T, Z> {

    private final TemporalFieldWrapper<T, Z> expected;
    private final TemporalFieldAdapter<T, Z> accessor;
    private final Z zone;

    public IsDayOfWeek(final TemporalFieldWrapper<T, Z> expected, final TemporalFieldAdapter<T, Z> accessor, final Z zone) {
        this.expected = expected;
        this.accessor = accessor;
        this.zone = zone;
    }

    @Override
    protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
        if (!this.expected.isSame(actual)) {
            mismatchDescription.appendText("the date is on a " + DayOfWeek.of((int) accessor.asTemporalField(actual, zone)).name().toLowerCase());
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("the date is on a " + DayOfWeek.of(expected.unwrap()).name().toLowerCase());
    }

    @Override
    public ZonedTemporalMatcher<T, Z> atZone(Z zone) {
        return new IsDayOfWeek<>(expected.withZone(zone), accessor, zone);
    }

}