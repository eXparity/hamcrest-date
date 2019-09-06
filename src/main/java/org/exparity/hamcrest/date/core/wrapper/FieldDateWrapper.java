package org.exparity.hamcrest.date.core.wrapper;

import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Date;
import java.util.function.ToIntFunction;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.core.TemporalFieldWrapper;

/**
 * Implementation of {@link TemporalFieldWrapper} which wraps a temporal field of a {@link Date} instance.
 *
 * @author Thomas Naskali
 */
public class FieldDateWrapper implements TemporalFieldWrapper<Date> {

	public static final String JAVA_SQL_DATE_UNIT = "java.sql.Date does not support time-based units. Prefer SqlDateMatchers for java.sql.Date appropriate matchers";
	
	private final ToIntFunction<ZoneId> wrapped;
	private final ChronoField field;
	private final ZoneId zone;

	private FieldDateWrapper(final ToIntFunction<ZoneId> wrapped, final ChronoField field, final ZoneId zone) {
		this.wrapped = wrapped;
		this.field = field;
		this.zone = zone;
	}

	public FieldDateWrapper(final int value, final ChronoField field) {
		this((ignored) -> value, field, ZoneId.systemDefault());
	}

	public FieldDateWrapper(Date date, ChronoField field) {
		this(z -> date.toInstant().atZone(z).get(field), field, ZoneId.systemDefault());
	}
	
	public FieldDateWrapper(java.sql.Date date, ChronoField field) {
		this(z -> date.toLocalDate().atStartOfDay(z).get(field), requireDateBased(field), ZoneId.systemDefault());
	}

	@Override
	public boolean isAfter(Date other) {
		return selfField() > otherField(other);
	}

	private int selfField() {
		return wrapped.applyAsInt(zone);
	}

	@Override
	public boolean isBefore(Date other) {
		return selfField() < otherField(other);
	}

	@Override
	public boolean isSame(Date other) {
		return selfField() == otherField(other);
	}

	@Override
	public int unwrap() {
		return selfField();
	}

	@Override
	public TemporalFieldWrapper<Date> withZone(ZoneId zone) {
		return new FieldDateWrapper(wrapped, field, zone);
	}

	private int otherField(Date other) {
		if (other instanceof java.sql.Date) {
			try {
				return ((java.sql.Date) other).toLocalDate().get(field);
			} catch (UnsupportedTemporalTypeException e) {
				throw new IllegalArgumentException(DateMatchers.UNSUPPORTED_SQL_DATE_UNIT);
			}
		} else {
			return other.toInstant().atZone(zone).get(field);
		}
	}
	
	private static ChronoField requireDateBased(ChronoField field) {
		if ( !field.isDateBased() ) {
			throw new IllegalArgumentException(DateMatchers.UNSUPPORTED_SQL_DATE_UNIT);
		}
		return field;
	}

}
