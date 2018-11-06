package org.exparity.hamcrest.date.core;

import static java.util.stream.Collectors.toList;

import java.util.function.Function;
import java.util.stream.Stream;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.hamcrest.core.AnyOf;

/**
 * A matcher that tests that the examined date matches at least one of the given matchers
 *
 * @author Thomas Naskali
 */
public class AnyOfTemporals<T> extends TypeSafeDiagnosingMatcher<T> {

    private final Function<T, String> descriptionProvider;
    private final AnyOf<? super T> anyOf;

    public AnyOfTemporals(final Stream<Matcher<? super T>> dateMatchers, final Function<T, String> descriptionProvider) {
        this.descriptionProvider = descriptionProvider;
        this.anyOf = new AnyOf<>(dateMatchers.collect(toList()));
    }

    @Override
    protected boolean matchesSafely(final T t, final Description mismatchDescription) {
        if (!anyOf.matches(t)) {
            mismatchDescription.appendText(descriptionProvider.apply(t));
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void describeTo(final Description description) {
        anyOf.describeTo(description);
    }

}
