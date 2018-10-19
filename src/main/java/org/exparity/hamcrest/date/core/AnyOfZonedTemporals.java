package org.exparity.hamcrest.date.core;

import static java.util.stream.Collectors.toList;

import java.util.function.BiFunction;
import java.util.stream.Stream;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.core.AnyOf;

/**
 * A matcher that tests that the examined date matches at least one of the given matchers
 *
 * @author Thomas Naskali
 */
public class AnyOfZonedTemporals<T, Z> extends ZonedTemporalMatcher<T, Z> {

    private final Stream<ZonedTemporalMatcher<? super T, Z>> dateMatchers;
    private final BiFunction<T, Z, String> descriptionProvider;
    private final Z zone;
    private final AnyOf<? super T> anyOf;

    public AnyOfZonedTemporals(final Stream<ZonedTemporalMatcher<? super T, Z>> dateMatchers, final BiFunction<T, Z, String> descriptionProvider, final Z zone) {
        this.dateMatchers = dateMatchers;
        this.descriptionProvider = descriptionProvider;
        this.zone = zone;
        this.anyOf = new AnyOf<>(
            this.dateMatchers.map(m -> (Matcher<? super T>) m.atZone(zone)).collect(toList())
        );
    }

    @Override
    protected boolean matchesSafely(final T t, final Description mismatchDescription) {
        if (!anyOf.matches(t)) {
            mismatchDescription.appendText(descriptionProvider.apply(t, zone));
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void describeTo(final Description description) {
        anyOf.describeTo(description);
    }

    @Override
    public ZonedTemporalMatcher<T, Z> atZone(final Z zone) {
        return new AnyOfZonedTemporals<>(dateMatchers, descriptionProvider, zone);
    }

}
