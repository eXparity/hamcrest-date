package org.exparity.hamcrest.date.core.wrapper;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.util.function.ToIntFunction;

import org.exparity.hamcrest.date.core.TemporalFieldWrapper;

/**
 * Implementation of {@link TemporalFieldWrapper} which wraps a temporal field of a {@link ZonedDateTime} instance.
 *
 * @author Thomas Naskali
 */
public class FieldZonedDateTimeWrapper implements TemporalFieldWrapper<ZonedDateTime, ZoneId> {

	private final ToIntFunction<ZoneId> wrapped;
	private final ChronoField field;
	private final ZoneId zone;

	private FieldZonedDateTimeWrapper(final ToIntFunction<ZoneId> wrapped, final ChronoField field, final ZoneId zone) {
		this.wrapped = wrapped;
		this.field = field;
		this.zone = zone;
	}

	private FieldZonedDateTimeWrapper(final ToIntFunction<ZoneId> wrapped, final ChronoField field) {
		this(wrapped, field, null);
	}

	public FieldZonedDateTimeWrapper(final int value, final ChronoField field) {
		this(ignored -> value, field);
	}

	public FieldZonedDateTimeWrapper(final ZonedDateTime date, final ChronoField field) {
		this(z -> date.withZoneSameInstant(z).get(field), field);
	}

	private ZoneId getReferenceZone() {
		return zone != null ? zone : ZoneId.systemDefault();
	}

	@Override
	public boolean isAfter(final ZonedDateTime other) {
		ZoneId referenceZone = getReferenceZone();
		return wrapped.applyAsInt(referenceZone) > other.withZoneSameInstant(referenceZone).get(field);
	}

	@Override
	public boolean isBefore(final ZonedDateTime other) {
		ZoneId referenceZone = getReferenceZone();
		return wrapped.applyAsInt(referenceZone) < other.withZoneSameInstant(referenceZone).get(field);
	}

	@Override
	public boolean isSame(final ZonedDateTime other) {
		ZoneId referenceZone = getReferenceZone();
		return wrapped.applyAsInt(referenceZone) == other.withZoneSameInstant(referenceZone).get(field);
	}

	@Override
	public int unwrap() {
		return wrapped.applyAsInt(getReferenceZone());
	}

	@Override
	public TemporalFieldWrapper<ZonedDateTime, ZoneId> withZone(final ZoneId zone) {
		return new FieldZonedDateTimeWrapper(wrapped, field, zone);
	}

}
