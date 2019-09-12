package org.exparity.hamcrest.date.core.types;

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

/**
 * Value type to represent a day of a month. Instantiate via {@link DayOfMonth#of(int)} factory method.
 * 
 * @author Stewart Bissett
 */
public class DayOfMonth {
    
    /**
     * Create an instance of an {@link DayOfMonth}
     */
    public static DayOfMonth of(int value) {
        return new DayOfMonth(value);
    }

    /**
     * Create an instance of an {@link DayOfMonth} from a {@link TemporalAccessor}
     */
    public static DayOfMonth from(TemporalAccessor temporal) {
        return new DayOfMonth(temporal.get(ChronoField.DAY_OF_MONTH));
    }

    private final int value;

    private DayOfMonth(int value) {
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
        DayOfMonth that = (DayOfMonth) obj;
        return this.value == that.value;
    }
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
