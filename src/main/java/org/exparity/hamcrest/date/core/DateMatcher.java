package org.exparity.hamcrest.date.core;

import java.time.ZoneId;

import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * Abstract {@link org.hamcrest.Matcher<T>} for temporal objects allowing for time zone manipulation.
 *
 * @param <T> the type of objects handled by this matcher
 *
 * @author Thomas Naskali
 */
public abstract class DateMatcher<T> extends TypeSafeDiagnosingMatcher<T> {

    /**
     * Creates a copy of this matcher using a specific time zone.
     *
     * @param zone the new time zone
     * @return a copy of this matcher based on the new time zone
     */
    public abstract DateMatcher<T> atZone(ZoneId zone);

}
