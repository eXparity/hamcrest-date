package org.exparity.hamcrest.date.core;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import java.time.ZoneId;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * A matcher that tests that the examined date matches at least one of the given matchers
 *
 * @author Thomas Naskali
 */
public class AnyOf<T> extends DateMatcher<T> {

  private final Stream<DateMatcher<? super T>> dateMatchers;
  private final ZoneId zone;
  private final BiFunction<T, ZoneId, String> descriptionProvider;
  private final org.hamcrest.core.AnyOf<? super T> anyOf;

  private AnyOf(final Stream<DateMatcher<? super T>> dateMatchers, final ZoneId zone, final BiFunction<T, ZoneId, String> descriptionProvider) {
    this.dateMatchers = dateMatchers;
    this.zone = zone;
    this.descriptionProvider = descriptionProvider;
    this.anyOf = new org.hamcrest.core.AnyOf<>(
        this.dateMatchers.map(m -> (Matcher<? super T>) m.atZone(zone)).collect(toList())
    );
  }

  public AnyOf(final Stream<DateMatcher<? super T>> dateMatchers, final BiFunction<T, ZoneId, String> descriptionProvider) {
    this(dateMatchers, ZoneId.systemDefault(), descriptionProvider);
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
  public DateMatcher<T> atZone(final ZoneId zone) {
    return new AnyOf<>(dateMatchers, zone, descriptionProvider);
  }

}
