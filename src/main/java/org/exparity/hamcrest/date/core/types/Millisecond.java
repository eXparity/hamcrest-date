package org.exparity.hamcrest.date.core.types;

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

/**
 * Value type to represent a millisecond of a minute. Instantiate via {@link Millisecond#of(int)} factory method.
 * 
 * @author Stewart Bissett
 */
public class Millisecond {
    
    private static final int NANOS_PER_MILLISECOND = 1000000;

    /**
     * Create an instance of an {@link Millisecond}
     */
    public static Millisecond of(int value) {
        return new Millisecond(value);
    }
    
    /**
     * Create an instance of an {@link Millisecond} from a number of nanoseconds
     */
    public static Millisecond ofNanos(int nano) {
        return Millisecond.of(nano/NANOS_PER_MILLISECOND);
    }

    /**
     * Create an instance of an {@link Millisecond} from a {@link TemporalAccessor}
     */
    public static Millisecond from(TemporalAccessor temporal) {
        return new Millisecond(temporal.get(ChronoField.MILLI_OF_SECOND));
    }

    private final int value;

    private Millisecond(int value) {
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
        Millisecond that = (Millisecond) obj;
        return this.value == that.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
