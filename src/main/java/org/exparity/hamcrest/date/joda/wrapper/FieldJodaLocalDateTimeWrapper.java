package org.exparity.hamcrest.date.joda.wrapper;

import org.exparity.hamcrest.date.core.TemporalFieldWrapper;
import org.joda.time.DateTimeFieldType;
import org.joda.time.LocalDateTime;

/**
 * Implementation of {@link TemporalFieldWrapper} which wraps a temporal field of a Joda {@link LocalDateTime} instance.
 *
 * @author Thomas Naskali
 */
public class FieldJodaLocalDateTimeWrapper implements TemporalFieldWrapper<LocalDateTime, Void> {

	private final int wrapped;
	private final DateTimeFieldType field;

  	public FieldJodaLocalDateTimeWrapper(final int wrapped, final DateTimeFieldType field) {
		this.wrapped = wrapped;
		this.field = field;
	}

	public FieldJodaLocalDateTimeWrapper(final LocalDateTime date, final DateTimeFieldType field) {
		this(date.get(field), field);
	}

	@Override
	public boolean isAfter(final LocalDateTime other) {
		return wrapped > other.get(field);
	}

	@Override
	public boolean isBefore(final LocalDateTime other) {
		return wrapped < other.get(field);
	}

	@Override
	public boolean isSame(final LocalDateTime other) {
		return wrapped == other.get(field);
	}

	@Override
	public int unwrap() {
		return wrapped;
	}

	@Override
	public TemporalFieldWrapper<LocalDateTime, Void> withZone(final Void ignored) {
		return this;
	}

}
