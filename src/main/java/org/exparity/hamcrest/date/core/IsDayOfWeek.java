package org.exparity.hamcrest.date.core;

import java.time.DayOfWeek;
import java.time.ZoneId;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the same day of the week as the reference date
 *
 * @author Stewart Bissett
 */
public class IsDayOfWeek<T> extends DateMatcher<T> {

    private final TemporalFieldWrapper<T> expected;
    private final TemporalFieldAdapter<T> accessor;
    private final ZoneId zone;

    private IsDayOfWeek(final TemporalFieldWrapper<T> expected, final TemporalFieldAdapter<T> accessor, final ZoneId zone) {
        this.expected = expected;
        this.accessor = accessor;
        this.zone = zone;
    }

    public IsDayOfWeek(final TemporalFieldWrapper<T> expected, final TemporalFieldAdapter<T> accessor) {
        this(expected, accessor, ZoneId.systemDefault());
    }

    @Override
    protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
        if (!this.expected.isSame(actual)) {
            mismatchDescription.appendText("the date is on a " + DayOfWeek.of(accessor.asTemporalField(actual, zone)).name().toLowerCase());
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
    public DateMatcher<T> atZone(ZoneId zone) {
        return new IsDayOfWeek<>(expected.withZone(zone), accessor);
    }

}