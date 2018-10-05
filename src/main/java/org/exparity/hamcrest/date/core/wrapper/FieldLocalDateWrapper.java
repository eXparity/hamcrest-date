package org.exparity.hamcrest.date.core.wrapper;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.util.function.ToIntFunction;

import org.exparity.hamcrest.date.core.TemporalFieldWrapper;

/**
 * Implementation of {@link TemporalFieldWrapper} which wraps a temporal field of a {@link LocalDate} instance.
 *
 * @author Thomas Naskali
 */
public class FieldLocalDateWrapper implements TemporalFieldWrapper<LocalDate> {

  private final ToIntFunction<ZoneId> wrapped;
  private final ChronoField field;
  private final ZoneId zone;

  private FieldLocalDateWrapper(final ToIntFunction<ZoneId> wrapped, final ChronoField field, final ZoneId zone) {
    this.wrapped = wrapped;
    this.field = field;
    this.zone = zone;
  }

  public FieldLocalDateWrapper(final int value, final ChronoField field) {
    this.wrapped = (ignored) -> value;
    this.field = field;
    this.zone = ZoneId.systemDefault();
  }

  public FieldLocalDateWrapper(final LocalDate date, final ChronoField field) {
    this.wrapped = z -> date.atStartOfDay(z).get(field);
    this.field = field;
    this.zone = ZoneId.systemDefault();
  }

  @Override
  public boolean isAfter(final LocalDate other) {
    return wrapped.applyAsInt(zone) > other.atStartOfDay(zone).get(field);
  }

  @Override
  public boolean isBefore(final LocalDate other) {
    return wrapped.applyAsInt(zone) < other.atStartOfDay(zone).get(field);
  }

  @Override
  public boolean isSame(final LocalDate other) {
    return wrapped.applyAsInt(zone) == other.atStartOfDay(zone).get(field);
  }

  @Override
  public int unwrap() {
    return wrapped.applyAsInt(zone);
  }

  @Override
  public TemporalFieldWrapper<LocalDate> withZone(final ZoneId zone) {
    return new FieldLocalDateWrapper(wrapped, field, zone);
  }

}
