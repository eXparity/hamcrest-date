package org.exparity.hamcrest.date.core.wrapper;

import java.sql.Date;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ValueRange;

import org.exparity.hamcrest.date.core.TemporalFieldRangeAdapter;

/**
 * Implementation of a {@link TemporalFieldRangeAdapter} for {@link Date}
 */
public class FieldSqlDateRangeAdaptor implements TemporalFieldRangeAdapter<Date> {

	private final ChronoField field;

	public FieldSqlDateRangeAdaptor(ChronoField field) {
		this.field = field;
	}

	@Override
	public ValueRange asTemporalFieldRange(Date source, ZoneId zone) {
		return field.rangeRefinedBy(source.toLocalDate());
	}
}