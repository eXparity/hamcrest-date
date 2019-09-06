package org.exparity.hamcrest.date.core.wrapper;

import java.sql.Date;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.util.function.ToIntFunction;

import org.exparity.hamcrest.date.core.TemporalFieldWrapper;

/**
 * Implementation of {@link TemporalFieldWrapper} which wraps a temporal field of a {@link Date} instance.
 *
 * @author Thomas Naskali
 */
public class FieldSqlDateWrapper implements TemporalFieldWrapper<Date> {

	private final ToIntFunction<ZoneId> wrapped;
	private final ChronoField field;
	private final ZoneId zone;

	private FieldSqlDateWrapper(final ToIntFunction<ZoneId> wrapped, final ChronoField field, final ZoneId zone) {
		this.wrapped = wrapped;
		this.field = field;
		this.zone = zone;
	}

	public FieldSqlDateWrapper(final int value, final ChronoField field) {
		this((ignored) -> value, field, ZoneId.systemDefault());
	}

	public FieldSqlDateWrapper(Date date, ChronoField field) {
		this(z -> date.toLocalDate().get(field), field, ZoneId.systemDefault());
	}

	public FieldSqlDateWrapper(java.util.Date date, ChronoField field) {
		this(z -> date.toInstant().atZone(z).get(field), field, ZoneId.systemDefault());
	}
	
	@Override
	public boolean isAfter(Date other) {
		return wrapped.applyAsInt(zone) > other.toLocalDate().get(field);
	}

	@Override
	public boolean isBefore(Date other) {
		return wrapped.applyAsInt(zone) <  other.toLocalDate().get(field);
	}

	@Override
	public boolean isSame(Date other) {
		return wrapped.applyAsInt(zone) ==  other.toLocalDate().get(field);
	}

	@Override
	public int unwrap() {
		return wrapped.applyAsInt(zone);
	}

	@Override
	public TemporalFieldWrapper<Date> withZone(ZoneId zone) {
		return new FieldSqlDateWrapper(wrapped, field, zone);
	}
}
