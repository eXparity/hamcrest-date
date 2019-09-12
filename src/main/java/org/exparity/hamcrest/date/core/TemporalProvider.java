package org.exparity.hamcrest.date.core;

import java.time.ZoneId;

@FunctionalInterface
public interface TemporalProvider<S> {

	public S apply(final ZoneId zone);

}
