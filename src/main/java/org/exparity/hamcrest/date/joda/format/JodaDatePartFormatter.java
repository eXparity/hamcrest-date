package org.exparity.hamcrest.date.joda.format;

import org.exparity.hamcrest.date.core.TemporalUnitFormatter;
import org.joda.time.DateTimeFieldType;

/**
 * Return a human readable description of a date part
 *
 * @author Stewart Bissett
 */
public class JodaDatePartFormatter implements TemporalUnitFormatter<DateTimeFieldType> {

    /**
     * Return a human readable description of a date field
     * @param field the field to describe
     * @return the human readable description
     */
    public String describe(final DateTimeFieldType field) {
        return field.getName();
    }

}
