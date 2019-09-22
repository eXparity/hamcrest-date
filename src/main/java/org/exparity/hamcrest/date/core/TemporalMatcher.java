package org.exparity.hamcrest.date.core;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Locale;

import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * Abstract {@link org.hamcrest.Matcher<T>} for temporal objects allowing for time zone manipulation.
 *
 * @param <T> the type of objects handled by this matcher
 *
 * @author Thomas Naskali
 */
public abstract class TemporalMatcher<T> extends TypeSafeDiagnosingMatcher<T> {

    /**
     * Creates a copy of this matcher using a specific time zone.
     *
     * @param zone a {@link ZoneId}
     * @return a copy of this matcher based on the new time zone
     */
    public abstract TemporalMatcher<T> atZone(ZoneId zone);

    /**
     * Creates a copy of this matcher using a specific locale.
     *
     * @param locale a {@link Locale}
     * @return a copy of this matcher using the new locale
     */
    public abstract TemporalMatcher<T> atLocale(Locale locale);
    
    /**
     * Creates a copy of this matcher using a specific time offset.
     *
     * @param offset the new time offset
     * @return a copy of this matcher based on the new time offset
     */
    public TemporalMatcher<T> atOffset(ZoneOffset offset) {
        return atZone(ZoneId.of(offset.getId()));
    }

}
