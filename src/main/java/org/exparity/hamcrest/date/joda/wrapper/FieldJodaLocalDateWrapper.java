package org.exparity.hamcrest.date.joda.wrapper;

import org.exparity.hamcrest.date.core.TemporalFieldWrapper;
import org.joda.time.DateTimeFieldType;
import org.joda.time.LocalDate;

/**
 * Implementation of {@link TemporalFieldWrapper} which wraps a temporal field of a Joda {@link LocalDate} instance.
 *
 * @author Thomas Naskali
 */
public class FieldJodaLocalDateWrapper implements TemporalFieldWrapper<LocalDate, Void> {

  private final int wrapped;
  private final DateTimeFieldType field;

  public FieldJodaLocalDateWrapper(final int value, final DateTimeFieldType field) {
    this.wrapped = value;
    this.field = field;
  }

  public FieldJodaLocalDateWrapper(final LocalDate date, final DateTimeFieldType field) {
    this(date.get(field), field);
  }

  @Override
  public boolean isAfter(final LocalDate other) {
    return wrapped > other.get(field);
  }

  @Override
  public boolean isBefore(final LocalDate other) {
    return wrapped < other.get(field);
  }

  @Override
  public boolean isSame(final LocalDate other) {
    return wrapped == other.get(field);
  }

  @Override
  public int unwrap() {
    return wrapped;
  }

  @Override
  public TemporalFieldWrapper<LocalDate, Void> withZone(final Void ignored) {
    return this;
  }

}
