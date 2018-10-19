package org.exparity.hamcrest.date.core.wrapper;

import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.function.ToIntFunction;

import org.exparity.hamcrest.date.core.TemporalFieldWrapper;

/**
 * Implementation of {@link TemporalFieldWrapper} which wraps a temporal field of a {@link Date} instance.
 *
 * @author Thomas Naskali
 */
public class FieldDateWrapper implements TemporalFieldWrapper<Date, ZoneId> {

	private final ToIntFunction<ZoneId> wrapped;
	private final ChronoField field;
	private final ZoneId zone;

	private FieldDateWrapper(final ToIntFunction<ZoneId> wrapped, final ChronoField field, final ZoneId zone) {
 		this.wrapped = wrapped;
 		this.field = field;
 		this.zone = zone;
 	}

	private FieldDateWrapper(final ToIntFunction<ZoneId> wrapped, final ChronoField field) {
		this(wrapped, field, null);
	}

	public FieldDateWrapper(final int value, final ChronoField field) {
		this(ignored -> value, field);
	}

	public FieldDateWrapper(Date date, ChronoField field) {
		this(z -> date.toInstant().atZone(z).get(field), field);
	}

 	private ZoneId getReferenceZone() {
 		return zone != null ? zone : ZoneId.systemDefault();
 	}

	@Override
	public boolean isAfter(Date other) {
		ZoneId referenceZone = getReferenceZone();
		return wrapped.applyAsInt(referenceZone) > other.toInstant().atZone(referenceZone).get(field);
	}

	@Override
	public boolean isBefore(Date other) {
		ZoneId referenceZone = getReferenceZone();
		return wrapped.applyAsInt(referenceZone) < other.toInstant().atZone(referenceZone).get(field);
	}

	@Override
	public boolean isSame(Date other) {
		ZoneId referenceZone = getReferenceZone();
		return wrapped.applyAsInt(referenceZone) == other.toInstant().atZone(referenceZone).get(field);
	}

	@Override
	public int unwrap() {
		return wrapped.applyAsInt(getReferenceZone());
	}

	@Override
	public TemporalFieldWrapper<Date, ZoneId> withZone(ZoneId zone) {
		return new FieldDateWrapper(wrapped, field, zone);
	}

}
