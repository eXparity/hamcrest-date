package org.exparity.hamcrest.date.core.types;

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

/**
 * Value type to represent an minute of an hour. Instantiate via {@link Minute#of(int)} factory method.
 * 
 * @author Stewart Bissett
 */
public class Minute {
    
    /**
     * Create an instance of an {@link Minute}
     */
    public static Minute of(int value) {
        return new Minute(value);
    }
    
    /**
     * Create an instance of an {@link Minute} from a {@link TemporalAccessor}
     */
    public static Minute from(TemporalAccessor temporal) {
        return new Minute(temporal.get(ChronoField.MINUTE_OF_HOUR));
    }

    private final int value;

    private Minute(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(value).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if ( obj == this ) return true;
        if ( obj == null || obj.getClass() != getClass()) return false;
        Minute that = (Minute) obj;
        return this.value == that.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
