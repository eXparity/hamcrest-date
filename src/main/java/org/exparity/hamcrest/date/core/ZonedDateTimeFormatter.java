/**
 * 
 */
package org.exparity.hamcrest.date.core;

import java.time.ZonedDateTime;

/**
 * Implementation of a {@link TemporalFormatter} that can format a
 * {@link ZonedDateTime}
 * 
 * @author Stewart Bissett
 */
public class ZonedDateTimeFormatter implements TemporalFormatter<ZonedDateTime> {

	@Override
	public String describe(final ZonedDateTime temporal) {
		return temporal.toString();
	}

}
