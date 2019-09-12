package org.exparity.hamcrest.date.core.types;

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

/**
 * Value type to represent an hour of the day. Instantiate via {@link Hour#of(int)} factory method.
 * 
 * @author Stewart Bissett
 */
public class Hour {
    
    /**
     * Create an instance of an {@link Hour}
     */
    public static Hour of(int value) {
        return new Hour(value);
    }
    
    /**
     * Create an instance of an {@link Hour} from a {@link TemporalAccessor}
     */
    public static Hour from(TemporalAccessor temporal) {
        return new Hour(temporal.get(ChronoField.HOUR_OF_DAY));
    }

    private final int value;

    private Hour(int value) {
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
        Hour that = (Hour) obj;
        return this.value == that.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
