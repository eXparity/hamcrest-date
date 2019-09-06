package org.exparity.hamcrest.date.core.format;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
	
	private final Locale locale;
	
	public DateFormatter(Locale locale) {
		this.locale = locale;
	}
	
	public DateFormatter() {
		this(Locale.getDefault(Locale.Category.FORMAT));
	}

	@Override
	public String describe(final Date temporal) {
		if ( temporal instanceof java.sql.Date ) {
			return describeDate(temporal);
		} else {
			return new SimpleDateFormat(DATE_TIME_FORMAT, locale).format(temporal);
		}
	}

	@Override
	public String describeDate(final Date temporal) {
		return new SimpleDateFormat(DATE_FORMAT, locale).format(temporal);
	}
}
