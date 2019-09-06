package org.exparity.hamcrest.date.core.wrapper;

import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.util.Date;

import org.exparity.hamcrest.date.core.TemporalFieldAdapter;

/**
 * Implementation of a {@link TemporalFieldAdapter} for {@link Date}
 */
public class FieldDateAdaptor implements TemporalFieldAdapter<Date> {

	private final ChronoField field;

	public FieldDateAdaptor(ChronoField field) {
		this.field = field;
	}

	@Override
	public int asTemporalField(Date source, ZoneId zone) {
		if (source instanceof java.sql.Date) {
			return ((java.sql.Date) source).toLocalDate().get(field);
		} else {
			return source.toInstant().atZone(zone).get(field);
		}
	}
}