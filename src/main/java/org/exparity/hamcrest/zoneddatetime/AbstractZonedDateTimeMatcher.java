package org.exparity.hamcrest.zoneddatetime;

import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * Base class for all ZonedDateTime {@link org.hamcrest.Matcher} implementations
 * 
 * @author Stewart Bissett
 */
abstract class AbstractZonedDateTimeMatcher extends TypeSafeDiagnosingMatcher<ZonedDateTime> {

	private static final DateTimeFormatter ZONED_DATE_TIME_FORMAT = ofPattern("dd MMM yyyy HH:mm:ss SSS'ms' Z");

	/**
	 * Format the date into a string showing milliseconds
	 */
	protected String formatDate(final ZonedDateTime date) {
		return date.format(ZONED_DATE_TIME_FORMAT);
	}

}
