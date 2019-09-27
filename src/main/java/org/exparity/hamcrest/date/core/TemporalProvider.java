package org.exparity.hamcrest.date.core;

import java.time.ZoneId;
import java.util.Optional;

@FunctionalInterface
public interface TemporalProvider<S> {

	public S apply(final Optional<ZoneId> zone);

}
