package org.exparity.hamcrest.date.core.types;

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

/**
 * Value type to represent an second of a minute. Instantiate via {@link Second#of(int)} factory method.
 * 
 * @author Stewart Bissett
 */
public class Second {
    
    /**
     * Create an instance of an {@link Second}
     */
    public static Second of(int value) {
        return new Second(value);
    }
    
    /**
     * Create an instance of an {@link Second} from a {@link TemporalAccessor}
     */
    public static Second from(TemporalAccessor temporal) {
        return new Second(temporal.get(ChronoField.SECOND_OF_MINUTE));
    }

    private final int value;

    private Second(int value) {
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
        Second that = (Second) obj;
        return this.value == that.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
