package org.exparity.hamcrest.date.core.wrapper;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.function.IntSupplier;

import org.exparity.hamcrest.date.core.TemporalFieldWrapper;

/**
 * Implementation of {@link TemporalFieldWrapper} which wraps a temporal field of a {@link LocalTime} instance.
 *
 * @author Thomas Naskali
 */
public class FieldLocalTimeWrapper implements TemporalFieldWrapper<LocalTime, Void> {

  private final IntSupplier wrapped;
  private final ChronoField field;

  private FieldLocalTimeWrapper(final IntSupplier wrapped, final ChronoField field) {
    this.wrapped = wrapped;
    this.field = field;
  }

  public FieldLocalTimeWrapper(final int value, final ChronoField field) {
    this(() -> value, field);
  }

  public FieldLocalTimeWrapper(final LocalTime date, final ChronoField field) {
    this(() -> date.get(field), field);
  }

  @Override
  public boolean isAfter(final LocalTime other) {
    return wrapped.getAsInt() > other.get(field);
  }

  @Override
  public boolean isBefore(final LocalTime other) {
    return wrapped.getAsInt() < other.get(field);
  }

  @Override
  public boolean isSame(final LocalTime other) {
    return wrapped.getAsInt() == other.get(field);
  }

  @Override
  public int unwrap() {
    return wrapped.getAsInt();
  }

  @Override
  public TemporalFieldWrapper<LocalTime, Void> withZone(final Void ignored) {
    return this;
  }

}
