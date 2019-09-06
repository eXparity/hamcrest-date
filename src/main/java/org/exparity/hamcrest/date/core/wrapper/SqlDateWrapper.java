package org.exparity.hamcrest.date.core.wrapper;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;

import org.exparity.hamcrest.date.core.TemporalWrapper;

/**
 * Implementation of {@link TemporalWrapper} to wrap {@link Date} objects.
 *
 * @author Stewart Bissett
 */
public class SqlDateWrapper implements TemporalWrapper<Date> {

	private final Function<ZoneId, LocalDate> wrapped;
	private ZoneId zone;
	
	public SqlDateWrapper(final LocalDate date) {
		this((zoneId) -> date, ZoneId.systemDefault());
	}

	public SqlDateWrapper(final int year, final Month month, final int dayOfMonth) {
		this(LocalDate.of(year, month, dayOfMonth));
	}
	
	public SqlDateWrapper(final Date date) {
		this(date.toLocalDate());
	}

	public SqlDateWrapper(final java.util.Date date) {
		this(date, ZoneId.systemDefault());
	}
	
	public SqlDateWrapper(final java.util.Date date, ZoneId zone) {
		this((zoneId) -> date.toInstant().atZone(zoneId).toLocalDate(), zone);
	}
	
	private SqlDateWrapper(Function<ZoneId, LocalDate> wrapped, ZoneId zone) {
		this.wrapped = wrapped;
		this.zone = zone;
	}

	@Override
	public long difference(final Date other, final ChronoUnit unit) {
		return Math.abs((thisLocalDate().until(otherLocalDate(other), unit)));
	}

	@Override
	public boolean isAfter(final Date other) {
		return thisLocalDate().isAfter(otherLocalDate(other));
	}

	@Override
	public boolean isBefore(final Date other) {
		return thisLocalDate().isBefore(otherLocalDate(other));
	}

	@Override
	public boolean isSame(final Date other) {
		return thisLocalDate().isEqual(otherLocalDate(other));
	}

	@Override
	public Date unwrap() {
		return Date.valueOf(wrapped.apply(zone));
	}

	@Override
	public SqlDateWrapper withZone(final ZoneId zone) {
		return new SqlDateWrapper(wrapped, zone);
	}

	private LocalDate otherLocalDate(final Date other) {
		return other.toLocalDate();
	}

	private LocalDate thisLocalDate() {
		return wrapped.apply(zone);
	}
}
