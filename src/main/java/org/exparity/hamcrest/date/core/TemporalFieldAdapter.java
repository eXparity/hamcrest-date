package org.exparity.hamcrest.date.core;

import java.time.ZoneId;

@FunctionalInterface
public interface TemporalFieldAdapter<T> {

  int asTemporalField(final T source, final ZoneId zone);

}
