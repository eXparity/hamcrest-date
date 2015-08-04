package org.exparity.hamcrest.localdatetime;

import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * Base class for all LocalDateTime {@link org.hamcrest.Matcher} implementations
 * 
 * @author Stewart Bissett
 */
abstract class AbstractLocalDateTimeMatcher extends TypeSafeDiagnosingMatcher<LocalDateTime> {

	private static final DateTimeFormatter DATE_TIME_FORMAT = ofPattern("dd MMM yyyy HH:mm:ss SSS'ms'");

	/**
	 * Format the date into a string showing milliseconds
	 */
	protected String formatDate(final LocalDateTime date) {
		return date.format(DATE_TIME_FORMAT);
	}

}
