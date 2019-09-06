package org.exparity.hamcrest.date.core.wrapper;

import java.sql.Date;
import java.time.ZoneId;
import java.time.temporal.ChronoField;

import org.exparity.hamcrest.date.core.TemporalFieldAdapter;

/**
 * Implementation of a {@link TemporalFieldAdapter} for {@link Date}
 */
public class FieldSqlDateAdaptor implements TemporalFieldAdapter<Date> {

	private final ChronoField field;

	public FieldSqlDateAdaptor(ChronoField field) {
		this.field = field;
	}

	@Override
	public int asTemporalField(Date source, ZoneId zone) {
		return source.toLocalDate().get(field);
	}
}