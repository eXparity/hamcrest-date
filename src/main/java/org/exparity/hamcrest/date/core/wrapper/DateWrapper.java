package org.exparity.hamcrest.date.core.wrapper;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.function.Function;

import org.exparity.hamcrest.date.core.TemporalWrapper;

/**
 * Implementation of {@link TemporalWrapper} to wrap {@link Date} objects.
 *
 * @author Stewart Bissett
 */
public class DateWrapper implements TemporalWrapper<Date> {

	public static final String JAVA_SQL_DATE_UNIT = "java.sql.Date does not support time-based units. Prefer SqlDateMatchers for java.sql.Date appropriate matchers";
	
	private final Function<ZoneId, ZonedDateTime> wrapped;
	private final ZoneId zone;
	private final TemporalUnit accuracy;

	private DateWrapper(final Function<ZoneId, ZonedDateTime> wrapped, final ZoneId zone, final TemporalUnit accuracy) {
		this.wrapped = wrapped;
		this.zone = zone;
		this.accuracy = accuracy;
	}

	public DateWrapper(final Date date) {
		this(date, ChronoUnit.MILLIS);
	}
	
	public DateWrapper(final java.sql.Date date) {
		this(z -> date.toLocalDate().atStartOfDay(z), ZoneId.systemDefault(), ChronoUnit.DAYS);
	}

	public DateWrapper(final Date date, final TemporalUnit accuracy) {
		this(z -> date.toInstant().atZone(z), ZoneId.systemDefault(), accuracy);
	}
	
	public DateWrapper(final LocalDate date) {
		this(date, ChronoUnit.DAYS);
	}

	public DateWrapper(final LocalDate date, final TemporalUnit accuracy) {
		this.zone = ZoneId.systemDefault();
		this.wrapped = date::atStartOfDay;
		this.accuracy = accuracy;
	}

	public DateWrapper(final int year, final Month month, final int dayOfMonth) {
		this(LocalDate.of(year, month, dayOfMonth));
	}

	public DateWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute,
			final int second) {
		this.zone = ZoneId.systemDefault();
		this.wrapped = z -> LocalDateTime.of(year, month, dayOfMonth, hour, minute, second).atZone(z);
		this.accuracy = ChronoUnit.SECONDS;
	}

	public DateWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute,
			final int second, final int millis) {
		this.zone = ZoneId.systemDefault();
		this.wrapped = z -> LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, millis * 1000000).atZone(z);
		this.accuracy = ChronoUnit.MILLIS;
	}

	@Override
	public long difference(final Date other, final ChronoUnit unit) {
		if ( other instanceof java.sql.Date) {
			return difference(thisLocalDate(), otherLocalDate(other), requireDateBased(unit));
		} else {
			return difference(thisInstant(), otherInstant(other), unit);
		}
	}

	@Override
	public boolean isAfter(final Date other) {
		if ( other instanceof java.sql.Date) {
			return thisLocalDate().isAfter(otherLocalDate(other));
		} else {
			return thisInstant().isAfter(otherInstant(other));
		}
	}

	@Override
	public boolean isBefore(final Date other) {
		if ( other instanceof java.sql.Date) {
			return thisLocalDate().isBefore(otherLocalDate(other));
		} else {
			return thisInstant().isBefore(otherInstant(other));
		}
	}

	@Override
	public boolean isSame(final Date other) {
		if ( other instanceof java.sql.Date) {
			return thisLocalDate().isEqual(otherLocalDate(other));
		} else {
			return thisInstant().equals(otherInstant(other));
		}
	}

	@Override
	public Date unwrap() {
		return new Date(wrapped.apply(zone).toInstant().toEpochMilli());
	}

	@Override
	public DateWrapper withZone(final ZoneId zone) {
		return new DateWrapper(wrapped, zone, accuracy);
	}

	private Instant otherInstant(final Date other) {
		return other.toInstant().atZone(zone).truncatedTo(accuracy).toInstant();
	}

	private Instant thisInstant() {
		return wrapped.apply(zone).truncatedTo(accuracy).toInstant();
	}
	
	private LocalDate otherLocalDate(final Date other) {
		return ((java.sql.Date) other).toLocalDate();
	}

	private LocalDate thisLocalDate() {
		return wrapped.apply(zone).toLocalDate();
	}

	private long difference(Temporal from, Temporal to, final ChronoUnit unit) {
		return Math.abs(from.until(to, unit));
	}

	private ChronoUnit requireDateBased(ChronoUnit unit) {
		if ( !unit.isDateBased() ) {
			throw new IllegalArgumentException(JAVA_SQL_DATE_UNIT);
		}
		return unit;
	}
}
