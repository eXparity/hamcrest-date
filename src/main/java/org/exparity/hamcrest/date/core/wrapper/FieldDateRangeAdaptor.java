package org.exparity.hamcrest.date.core.wrapper;

import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ValueRange;
import java.util.Date;

import org.exparity.hamcrest.date.core.TemporalFieldRangeAdapter;

/**
 * Implementation of a {@link TemporalFieldRangeAdapter} for {@link Date}
 */
public class FieldDateRangeAdaptor implements TemporalFieldRangeAdapter<Date> {

	private final ChronoField field;

	public FieldDateRangeAdaptor(ChronoField field) {
		this.field = field;
	}

	@Override
	public ValueRange asTemporalFieldRange(Date source, ZoneId zone) {
		if (source instanceof java.sql.Date) {
			return field.rangeRefinedBy(((java.sql.Date) source).toLocalDate());
		} else {
			return field.rangeRefinedBy(source.toInstant().atZone(zone));
		}
	}
}