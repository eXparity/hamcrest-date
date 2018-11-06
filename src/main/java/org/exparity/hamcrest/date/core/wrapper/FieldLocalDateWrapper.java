package org.exparity.hamcrest.date.core.wrapper;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.function.IntSupplier;

import org.exparity.hamcrest.date.core.TemporalFieldWrapper;

/**
 * Implementation of {@link TemporalFieldWrapper} which wraps a temporal field of a {@link LocalDate} instance.
 *
 * @author Thomas Naskali
 */
public class FieldLocalDateWrapper implements TemporalFieldWrapper<LocalDate, Void> {

  private final IntSupplier wrapped;
  private final ChronoField field;

  private FieldLocalDateWrapper(final IntSupplier wrapped, final ChronoField field) {
    this.wrapped = wrapped;
    this.field = field;
  }

  public FieldLocalDateWrapper(final int value, final ChronoField field) {
    this(() -> value, field);
  }

  public FieldLocalDateWrapper(final LocalDate date, final ChronoField field) {
    this(() -> date.get(field), field);
  }

  @Override
  public boolean isAfter(final LocalDate other) {
    return wrapped.getAsInt() > other.get(field);
  }

  @Override
  public boolean isBefore(final LocalDate other) {
    return wrapped.getAsInt() < other.get(field);
  }

  @Override
  public boolean isSame(final LocalDate other) {
    return wrapped.getAsInt() == other.get(field);
  }

  @Override
  public int unwrap() {
    return wrapped.getAsInt();
  }

  @Override
  public TemporalFieldWrapper<LocalDate, Void> withZone(final Void ignored) {
    return this;
  }

}
