package org.exparity.hamcrest.date.joda.wrapper;

import java.util.function.Supplier;

import org.exparity.hamcrest.date.core.TemporalWrapper;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/**
 * Implementation of a {@link TemporalWrapper} which wraps a Joda {@link LocalDate}
 * instance
 *
 * @author Thomas Naskali
 */
public class JodaLocalDateWrapper implements TemporalWrapper<LocalDate, DurationFieldType, DateTimeZone> {

	private final Supplier<LocalDate> wrapped;
	private final DateTimeFieldType accuracy;

 	private JodaLocalDateWrapper(final Supplier<LocalDate> wrapped, final DateTimeFieldType accuracy) {
 		this.wrapped = wrapped;
 		this.accuracy = accuracy;
 	}

 	public JodaLocalDateWrapper(final LocalDate date) {
 		this(() -> date, DateTimeFieldType.dayOfMonth());
 	}

 	@Override
 	public long difference(final LocalDate other, DurationFieldType unit) {
		PeriodType periodType = PeriodType.forFields(new DurationFieldType[]{ unit });
		Period period = new Period(
			wrapped.get().property(accuracy).roundFloorCopy(),
			other.property(accuracy).roundFloorCopy()
		).normalizedStandard(periodType);
		return Math.abs(period.get(unit));
 	}

 	@Override
 	public boolean isAfter(final LocalDate other) {
 		return wrapped.get().property(accuracy).roundFloorCopy().isAfter(other.property(accuracy).roundFloorCopy());
 	}

 	@Override
 	public boolean isBefore(final LocalDate other) {
 		return wrapped.get().property(accuracy).roundFloorCopy().isBefore(other.property(accuracy).roundFloorCopy());
 	}

 	@Override
 	public boolean isSame(final LocalDate other) {
 		return wrapped.get().property(accuracy).roundFloorCopy().isEqual(other.property(accuracy).roundFloorCopy());
 	}

 	@Override
 	public LocalDate unwrap() {
 		return wrapped.get();
 	}

 	@Override
 	public String toString() {
 		return wrapped.get().toString();
 	}

 	@Override
 	public TemporalWrapper<LocalDate, DurationFieldType, DateTimeZone> withZone(final DateTimeZone ignored) {
 		return this;
 	}

}

