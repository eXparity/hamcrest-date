/**
 * 
 */
package org.exparity.hamcrest.date.core;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Implementation of a {@link TemporalFormatter} to describe {@link Date}
 * instances
 * 
 * @author Stewart Bissett
 */
public class DateFormatter implements TemporalFormatter<Date> {

	private static final String DATE_PATTERN_WITH_MILLIS = "dd MMM yyyy HH:mm:ss SSS'ms' Z";

	@Override
	public String describe(final Date temporal) {
		return new SimpleDateFormat(DATE_PATTERN_WITH_MILLIS).format(temporal);
	}

}
