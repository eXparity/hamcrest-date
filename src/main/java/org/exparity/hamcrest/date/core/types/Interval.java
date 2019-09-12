package org.exparity.hamcrest.date.core.types;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * Encapsulate a time or date interval. Equivalent to {@link Duration} and {@link Period} but supporting both time and
 * date elements
 * 
 * @author Stewart Bissett
 */
public class Interval {

	/**
	 * Create an {@link Interval} from a {@link Period} using a unit of {@link ChronoUnit#DAYS}
	 */
	public static Interval of(Period period) {
		return new Interval(period.getDays(), ChronoUnit.DAYS);
	}

	/**
	 * Create an {@link Interval} from a {@link Period} using a unit of {@link ChronoUnit#DAYS}
	 */
	public static Interval of(Duration duration) {
		return new Interval(duration.getSeconds(), ChronoUnit.SECONDS);
	}

	/**
	 * Create an {@link Interval} from an explicit period and {@link ChronoUnit}
	 */
	public static Interval of(long period, ChronoUnit unit) {
		return new Interval(period, unit);
	}

	private final long period;
	private final ChronoUnit unit;

	private Interval(long period, ChronoUnit unit) {
		this.period = Math.abs(period);
		this.unit = unit;
	}

	public ChronoUnit getUnit() {
		return unit;
	}

	public boolean longerThan(Interval other) {
	    if ( unit == other.unit ) {
	        return period > other.period;
	    } else {
	        throw new UnsupportedOperationException("Units are different. " + unit + " vs " + other.unit);
	    }
	}

	public String describe(Locale locale) {
		return period + " " + unit.toString();
	}

}
