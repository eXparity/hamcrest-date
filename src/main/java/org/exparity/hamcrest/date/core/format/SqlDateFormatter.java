package org.exparity.hamcrest.date.core.format;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Locale;

import org.exparity.hamcrest.date.core.TemporalFormatter;

/**
 * Implementation of a {@link TemporalFormatter} to describe {@link Date}
 * instances
 *
 * @author Stewart Bissett
 */
public class SqlDateFormatter implements TemporalFormatter<Date> {

	private static final String  DATE_FORMAT = "EEE, dd MMM yyyy";
	
	private final Locale locale;
	
	public SqlDateFormatter(Locale locale) {
		this.locale = locale;
	}
	
	public SqlDateFormatter() {
		this(Locale.getDefault(Locale.Category.FORMAT));
	}

	@Override
	public String describe(final Date temporal) {
		return describeDate(temporal);
	}

	@Override
	public String describeDate(final Date temporal) {
		return new SimpleDateFormat(DATE_FORMAT, locale).format(temporal);
	}
}
