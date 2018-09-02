package org.exparity.hamcrest.date.core.format;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.exparity.hamcrest.date.core.TemporalFormatter;

/**
 * Implementation of a {@link TemporalFormatter} to describe {@link Date}
 * instances
 *
 * @author Stewart Bissett
 */
public class DateFormatter implements TemporalFormatter<Date> {

	private static final String DATE_TIME_FORMAT = "EEE, dd MMM yyyy hh:mm:ss.SSS a";
	private static final String  DATE_FORMAT = "EEE, dd MMM yyyy";

	@Override
	public String describe(final Date temporal) {
		return new SimpleDateFormat(DATE_TIME_FORMAT).format(temporal);
	}

	@Override
	public String describeDate(final Date temporal) {
		return new SimpleDateFormat(DATE_FORMAT).format(temporal);
	}
}
