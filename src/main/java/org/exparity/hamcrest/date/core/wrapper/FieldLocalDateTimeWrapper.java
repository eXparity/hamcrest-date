package org.exparity.hamcrest.date.core.wrapper;

import org.exparity.hamcrest.date.core.TemporalFieldWrapper;
import org.exparity.hamcrest.date.core.TemporalWrapper;

import java.time.*;
import java.time.temporal.ChronoField;
import java.util.function.ToIntFunction;

/**
 * Implementation of a {@link TemporalWrapper} which wraps a
 * {@link LocalDateTime} instance
 *
 * @author Stewart Bissett
 */
public class FieldLocalDateTimeWrapper implements TemporalFieldWrapper<LocalDateTime> {

	private final ToIntFunction<ZoneId> wrapped;
	private final ChronoField field;
	private final ZoneId zone;

	private FieldLocalDateTimeWrapper(final ToIntFunction<ZoneId> wrapped, final ChronoField field, final ZoneId zone) {
		this.wrapped = wrapped;
		this.field = field;
		this.zone = zone;
	}

	public FieldLocalDateTimeWrapper(final int value, final ChronoField field) {
		this.wrapped = (ignored) -> value;
		this.field = field;
		this.zone = ZoneId.systemDefault();
	}

	public FieldLocalDateTimeWrapper(final LocalDateTime date, final ChronoField field) {
		this.wrapped = z -> date.atZone(z).get(field);
		this.field = field;
		this.zone = ZoneId.systemDefault();
	}

	@Override
	public boolean isAfter(final LocalDateTime other) {
		return wrapped.applyAsInt(zone) > other.atZone(zone).get(field);
	}

	@Override
	public boolean isBefore(final LocalDateTime other) {
		return wrapped.applyAsInt(zone) < other.atZone(zone).get(field);
	}

	@Override
	public boolean isSame(final LocalDateTime other) {
		return wrapped.applyAsInt(zone) == other.atZone(zone).get(field);
	}

	@Override
	public int unwrap() {
		return wrapped.applyAsInt(zone);
	}

	@Override
	public TemporalFieldWrapper<LocalDateTime> withZone(final ZoneId zone) {
		return new FieldLocalDateTimeWrapper(wrapped, field, zone);
	}

}
