package org.exparity.hamcrest.date.joda.wrapper;

import java.util.function.ToIntFunction;

import org.exparity.hamcrest.date.core.TemporalFieldWrapper;
import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;

/**
 * Implementation of {@link TemporalFieldWrapper} which wraps a temporal field of a Joda {@link DateTime} instance.
 *
 * @author Thomas Naskali
 */
public class FieldJodaDateTimeWrapper implements TemporalFieldWrapper<DateTime, DateTimeZone> {

	private final ToIntFunction<DateTimeZone> wrapped;
	private final DateTimeFieldType field;
	private final DateTimeZone zone;

	private FieldJodaDateTimeWrapper(final ToIntFunction<DateTimeZone> wrapped, final DateTimeFieldType field, final DateTimeZone zone) {
		this.wrapped = wrapped;
		this.field = field;
		this.zone = zone;
	}

	private FieldJodaDateTimeWrapper(final ToIntFunction<DateTimeZone> wrapped, final DateTimeFieldType field) {
		this(wrapped, field, null);
	}

	public FieldJodaDateTimeWrapper(final int value, final DateTimeFieldType field) {
		this(ignored -> value, field);
	}

	public FieldJodaDateTimeWrapper(final DateTime date, final DateTimeFieldType field) {
		this(z -> date.withZone(z).get(field), field);
	}

	private DateTimeZone getReferenceZone() {
		return zone != null ? zone : DateTimeZone.getDefault();
	}

	@Override
	public boolean isAfter(final DateTime other) {
		DateTimeZone referenceZone = getReferenceZone();
		return wrapped.applyAsInt(referenceZone) > other.withZone(referenceZone).get(field);
	}

	@Override
	public boolean isBefore(final DateTime other) {
		DateTimeZone referenceZone = getReferenceZone();
		return wrapped.applyAsInt(referenceZone) < other.withZone(referenceZone).get(field);
	}

	@Override
	public boolean isSame(final DateTime other) {
		DateTimeZone referenceZone = getReferenceZone();
		return wrapped.applyAsInt(referenceZone) == other.withZone(referenceZone).get(field);
	}

	@Override
	public int unwrap() {
		return wrapped.applyAsInt(getReferenceZone());
	}

	@Override
	public TemporalFieldWrapper<DateTime, DateTimeZone> withZone(final DateTimeZone zone) {
		return new FieldJodaDateTimeWrapper(wrapped, field, zone);
	}

}
