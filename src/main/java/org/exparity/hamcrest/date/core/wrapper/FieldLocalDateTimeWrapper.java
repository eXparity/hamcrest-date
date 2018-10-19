package org.exparity.hamcrest.date.core.wrapper;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.function.IntSupplier;

import org.exparity.hamcrest.date.core.TemporalFieldWrapper;

/**
 * Implementation of {@link TemporalFieldWrapper} which wraps a temporal field of a {@link LocalDateTime} instance.
 *
 * @author Thomas Naskali
 */
public class FieldLocalDateTimeWrapper implements TemporalFieldWrapper<LocalDateTime, Void> {

	private final IntSupplier wrapped;
	private final ChronoField field;

 	public FieldLocalDateTimeWrapper(final IntSupplier wrapped, final ChronoField field) {
		this.wrapped = wrapped;
		this.field = field;
	}

	public FieldLocalDateTimeWrapper(final int value, final ChronoField field) {
		this(() -> value, field);
	}

	public FieldLocalDateTimeWrapper(final LocalDateTime date, final ChronoField field) {
		this(() -> date.get(field), field);
	}

	@Override
	public boolean isAfter(final LocalDateTime other) {
		return wrapped.getAsInt() > other.get(field);
	}

	@Override
	public boolean isBefore(final LocalDateTime other) {
		return wrapped.getAsInt() < other.get(field);
	}

	@Override
	public boolean isSame(final LocalDateTime other) {
		return wrapped.getAsInt() == other.get(field);
	}

	@Override
	public int unwrap() {
		return wrapped.getAsInt();
	}

	@Override
	public TemporalFieldWrapper<LocalDateTime, Void> withZone(final Void ignored) {
		return this;
	}

}
