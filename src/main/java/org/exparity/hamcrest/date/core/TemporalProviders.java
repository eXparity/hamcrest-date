package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.core.TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.exparity.hamcrest.date.core.types.DayOfMonth;
import org.exparity.hamcrest.date.core.types.Hour;
import org.exparity.hamcrest.date.core.types.Millisecond;
import org.exparity.hamcrest.date.core.types.Minute;
import org.exparity.hamcrest.date.core.types.Second;

/**
 * Static repository of {@link TemporalProvider} instances which provide a temporal type from another temporal type e.g.
 * given a {@link LocalDate} returns the hour, or given a {@link java.sql.Date} returns a {@link LocalDate}.
 * No-operation providers e.g. LocalDate to LocalDate are present to keep a consistent usage pattern in the
 * {@link TemporalMatcher} implementations
 */
public class TemporalProviders {
    
    private TemporalProviders() {}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link java.sql.Date}
	 */
	public static TemporalProvider<java.sql.Date> sqlDate(java.util.Date date) {
		if (date instanceof java.sql.Date) {
			return sqlDate((java.sql.Date) date);
		} else {
			return (z) -> new java.sql.Date(date.getTime());
		}
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link java.sql.Date}
	 */
	public static TemporalProvider<java.sql.Date> sqlDate(java.sql.Date date) {
		return (z) -> (java.sql.Date) date;
	}
	
	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Date}
	 */
	public static TemporalProvider<Date> javaDate(Date date) {
		if (date instanceof java.sql.Date) {
			return (zone) -> new Date(date.getTime());
		} else {
			return (zone) -> Date.from(instant(date).apply(zone));
		}
	}

	public static TemporalProvider<java.util.Date> javaDate(java.sql.Date date) {
		throw new TemporalConversionException(UNSUPPORTED_SQL_DATE_UNIT);
	}

	/**
	 * Factory to create a {@link TemporalProvider} for an {@link Instant}
	 */
	public static TemporalProvider<Instant> instant(Date date) {
		return (zone) -> zonedDateTime(date).apply(zone).toInstant();
	}

	/**
	 * Factory to create a {@link TemporalProvider} for an {@link Instant}
	 */
	public static TemporalProvider<Instant> instant(Instant instant) {
		return (zone) -> zone.map(z -> instant.atZone(z).toInstant()).orElse(instant);
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Date}
	 */
	public static TemporalProvider<Instant> instant(java.sql.Date date) {
		throw new TemporalConversionException(UNSUPPORTED_SQL_DATE_UNIT);
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link LocalDate}
	 */
	public static TemporalProvider<LocalDate> localDate(LocalDate date) {
		return (zone) -> date;
	}

	   /**
     * Factory to create a {@link TemporalProvider} for a {@link LocalDate}
     */
    public static TemporalProvider<LocalDate> localDate(Instant date) {
        return (zone) -> TemporalConverters.INSTANT_AS_LOCALDATE.apply(date, zone);
    }

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link LocalDate}
	 */
	public static TemporalProvider<LocalDate> localDate(ZonedDateTime date) {
		return (zone) -> zonedDateTime(date).apply(zone).toLocalDate();
	}

    /**
     * Factory to create a {@link TemporalProvider} for a {@link LocalDate}
     */
    public static TemporalProvider<LocalDate> localDate(OffsetDateTime date) {
        return (zone) -> offsetDateTime(date).apply(zone).toLocalDate();
    }
	
	/**
	 * Factory to create a {@link TemporalProvider} for a {@link LocalDate}
	 */
	public static TemporalProvider<LocalDate> localDate(LocalDateTime date) {
		return (zone) -> localDateTime(date).apply(zone).toLocalDate();
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link LocalDate}
	 */
	public static TemporalProvider<LocalDate> localDate(Date date) {
		if (date instanceof java.sql.Date) {
			return (zone) -> ((java.sql.Date) date).toLocalDate();
		} else {
			return (zone) -> zonedDateTime(date).apply(zone).toLocalDate();
		}
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link LocalDateTime}
	 */
	public static TemporalProvider<LocalDateTime> localDateTime(LocalDateTime date) {
		return (zone) -> date;
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link ZonedDateTime}
	 */
	public static TemporalProvider<ZonedDateTime> zonedDateTime(ZonedDateTime date) {
		return (zone) -> zone.map( z -> date.withZoneSameInstant(z)).orElse(date);
	}

	/**
	 * Factory to create a {@link TemporalProvider} for an {@link ZonedDateTime}
	 */
	public static TemporalProvider<ZonedDateTime> zonedDateTime(Date date) {
		if (date instanceof java.sql.Date) {
			return zonedDateTime((java.sql.Date) date);
		} else {
			return (zone) -> zonedDateTime(ZonedDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())).apply(zone);
		}
	}

	/**
	 * Factory to create a {@link TemporalProvider} for an {@link ZonedDateTime}
	 */
	public static TemporalProvider<ZonedDateTime> zonedDateTime(java.sql.Date date) {
		throw new TemporalConversionException(UNSUPPORTED_SQL_DATE_UNIT);
	}

    /**
     * Factory to create a {@link TemporalProvider} for a {@link OffsetDateTime}
     */
    public static TemporalProvider<OffsetDateTime> offsetDateTime(OffsetDateTime date) {
        return (zone) -> zone.map(z -> date.withOffsetSameInstant(z.getRules().getOffset(date.toLocalDateTime())))
                .orElse(date);
    }

    /**
     * Factory to create a {@link TemporalProvider} for an {@link OffsetDateTime}
     */
    public static TemporalProvider<OffsetDateTime> offsetDateTime(Date date) {
        if (date instanceof java.sql.Date) {
            return offsetDateTime((java.sql.Date) date);
        } else {
            return (zone) -> offsetDateTime(OffsetDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())).apply(zone);
        }
    }

    /**
     * Factory to create a {@link TemporalProvider} for an {@link ZonedDateTime}
     */
    public static TemporalProvider<OffsetDateTime> offsetDateTime(java.sql.Date date) {
        throw new TemporalConversionException(UNSUPPORTED_SQL_DATE_UNIT);
    }
	
	/**
	 * Factory to create a {@link TemporalProvider} for a {@link LocalTime}
	 */
	public static TemporalProvider<LocalTime> localTime(LocalTime time) {
		return (zone) -> time;
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Year}
	 */
	public static TemporalProvider<Year> year(ZonedDateTime date) {
		return (zone) -> Year.from(zonedDateTime(date).apply(zone));
	}

    /**
     * Factory to create a {@link TemporalProvider} for a {@link Year}
     */
    public static TemporalProvider<Year> year(OffsetDateTime date) {
        return (zone) -> Year.from(offsetDateTime(date).apply(zone));
    }
	
	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Year}
	 */
	public static TemporalProvider<Year> year(LocalDateTime date) {
		return (zone) -> Year.from(date);
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Year}
	 */
	public static TemporalProvider<Year> year(LocalDate date) {
		return (zone) -> Year.from(date);
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Year}
	 */
	public static TemporalProvider<Year> year(Integer year) {
		return (zone) -> Year.of(year);
	}

	   /**
     * Factory to create a {@link TemporalProvider} for a {@link Year}
     */
    public static TemporalProvider<Year> year(Instant instant) {
        return (zone) ->  TemporalConverters.INSTANT_AS_YEAR.apply(instant, zone);
    }

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Year}
	 */
	public static TemporalProvider<Year> year(Date date) {
		return (zone) -> Year.from(localDate(date).apply(zone));
	}

    /**
     * Factory to create a {@link TemporalProvider} for a {@link Month}
     */
    public static TemporalProvider<Month> month(OffsetDateTime date) {
        return (zone) -> offsetDateTime(date).apply(zone).getMonth();
    }

    /**
     * Factory to create a {@link TemporalProvider} for a {@link Month}
     */
    public static TemporalProvider<Month> month(Instant date) {
        return (zone) -> TemporalConverters.INSTANT_AS_MONTH.apply(date, zone);
    }

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Month}
	 */
	public static TemporalProvider<Month> month(ZonedDateTime date) {
		return (zone) -> zonedDateTime(date).apply(zone).getMonth();
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Month}
	 */
	public static TemporalProvider<Month> month(LocalDateTime date) {
		return (zone) -> date.getMonth();
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Month}
	 */
	public static TemporalProvider<Month> month(LocalDate date) {
		return (zone) -> date.getMonth();
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Month}
	 */
	public static TemporalProvider<Month> month(Month month) {
		return (zone) -> month;
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Month}
	 */
	public static TemporalProvider<Month> month(Date date) {
		return (zone) -> localDate(date).apply(zone).getMonth();
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link DayOfWeek}
	 */
	public static TemporalProvider<List<DayOfWeek>> dayOfWeek(ZonedDateTime date) {
		return (zone) -> Arrays.asList(zonedDateTime(date).apply(zone).getDayOfWeek());
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link DayOfWeek}
	 */
	public static TemporalProvider<List<DayOfWeek>> daysOfWeek(LocalDateTime date) {
		return (zone) -> Arrays.asList(date.getDayOfWeek());
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link DayOfWeek}
	 */
	public static TemporalProvider<List<DayOfWeek>> daysOfWeek(LocalDate date) {
		return (zone) -> Arrays.asList(date.getDayOfWeek());
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link DayOfWeek}
	 */
	public static TemporalProvider<List<DayOfWeek>> daysOfWeek(DayOfWeek... dayOfWeek) {
		return (zone) -> Arrays.asList(dayOfWeek);
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link DayOfWeek}
	 */
	public static TemporalProvider<List<DayOfWeek>> daysOfWeek(DayOfWeek dayOfWeek) {
		return (zone) -> Arrays.asList(dayOfWeek);
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link DayOfWeek}
	 */
	public static TemporalProvider<List<DayOfWeek>> daysOfWeek(Date date) {
		return (zone) -> Arrays.asList(localDate(date).apply(zone).getDayOfWeek());
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link DayOfMonth}
	 */
	public static TemporalProvider<DayOfMonth> dayOfMonth(ZonedDateTime date) {
		return (zone) -> DayOfMonth.from(zonedDateTime(date).apply(zone));
	}

	   /**
     * Factory to create a {@link TemporalProvider} for a {@link DayOfMonth}
     */
    public static TemporalProvider<DayOfMonth> dayOfMonth(Instant date) {
        return (zone) -> TemporalConverters.INSTANT_AS_DAYOFMONTH.apply(date, zone);
    }

    /**
     * Factory to create a {@link TemporalProvider} for a {@link DayOfMonth}
     */
    public static TemporalProvider<DayOfMonth> dayOfMonth(OffsetDateTime date) {
        return (zone) -> DayOfMonth.from(offsetDateTime(date).apply(zone));
    }
	
	/**
	 * Factory to create a {@link TemporalProvider} for a {@link DayOfMonth}
	 */
	public static TemporalProvider<DayOfMonth> dayOfMonth(int dayOfMonth) {
		return (zone) -> DayOfMonth.of(dayOfMonth);
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link DayOfMonth}
	 */
	public static TemporalProvider<DayOfMonth> dayOfMonth(LocalDateTime date) {
		return (zone) -> DayOfMonth.from(date);
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link DayOfMonth}
	 */
	public static TemporalProvider<DayOfMonth> dayOfMonth(LocalDate date) {
		return (zone) -> DayOfMonth.from(date);
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Integer}
	 */
	public static TemporalProvider<DayOfMonth> dayOfMonth(Date date) {
		return (zone) -> DayOfMonth.from(localDate(date).apply(zone));
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Hour}
	 */
	public static TemporalProvider<Hour> hour(Date date) {
		return (zone) -> Hour.from(zonedDateTime(date).apply(zone));
	}

	   /**
     * Factory to create a {@link TemporalProvider} for a {@link Hour}
     */
    public static TemporalProvider<Hour> hour(Instant date) {
        return (zone) -> TemporalConverters.INSTANT_AS_HOUR.apply(date, zone);
    }

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Hour}
	 */
	public static TemporalProvider<Hour> hour(int hour) {
		return (zone) -> Hour.of(hour);
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Hour}
	 */
	public static TemporalProvider<Hour> hour(LocalDateTime date) {
		return (zone) -> Hour.from(date);
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Hour}
	 */
	public static TemporalProvider<Hour> hour(ZonedDateTime date) {
		return (zone) -> Hour.from(zonedDateTime(date).apply(zone));
	}
	
	   /**
     * Factory to create a {@link TemporalProvider} for a {@link Hour}
     */
    public static TemporalProvider<Hour> hour(OffsetDateTime date) {
        return (zone) -> Hour.from(offsetDateTime(date).apply(zone));
    }


	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Hour}
	 */
	public static TemporalProvider<Hour> hour(LocalTime time) {
		return (zone) -> Hour.from(time);
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Minute}
	 */
	public static TemporalProvider<Minute> minute(Date date) {
		return (zone) -> Minute.from(zonedDateTime(date).apply(zone));
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Minute}
	 */
	public static TemporalProvider<Minute> minute(int minute) {
		return (zone) -> Minute.of(minute);
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Minute}
	 */
	public static TemporalProvider<Minute> minute(LocalDateTime date) {
		return (zone) -> Minute.from(date);
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Minute}
	 */
	public static TemporalProvider<Minute> minute(ZonedDateTime date) {
		return (zone) -> Minute.from(zonedDateTime(date).apply(zone));
	}

    /**
     * Factory to create a {@link TemporalProvider} for a {@link Minute}
     */
    public static TemporalProvider<Minute> minute(OffsetDateTime date) {
        return (zone) -> Minute.from(offsetDateTime(date).apply(zone));
    }
	
	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Minute}
	 */
	public static TemporalProvider<Minute> minute(LocalTime time) {
		return (zone) -> Minute.from(time);
	}

    /**
     * Factory to create a {@link TemporalProvider} for a {@link Second}
     */
    public static TemporalProvider<Minute> minute(Instant date) {
        return (zone) -> TemporalConverters.INSTANT_AS_MINUTE.apply(date, zone);
    }
	
	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Second}
	 */
	public static TemporalProvider<Second> second(Date date) {
		return (zone) -> Second.from(zonedDateTime(date).apply(zone));
	}

    /**
     * Factory to create a {@link TemporalProvider} for a {@link Second}
     */
    public static TemporalProvider<Second> second(Instant date) {
        return (zone) -> TemporalConverters.INSTANT_AS_SECOND.apply(date, zone);
    }

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Second}
	 */
	public static TemporalProvider<Second> second(Integer second) {
		return (zone) -> Second.of(second);
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Second}
	 */
	public static TemporalProvider<Second> second(LocalTime time) {
		return (zone) -> Second.from(time);
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Second}
	 */
	public static TemporalProvider<Second> second(LocalDateTime date) {
		return (zone) -> Second.from(date);
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Second}
	 */
	public static TemporalProvider<Second> second(ZonedDateTime date) {
		return (zone) -> Second.from(zonedDateTime(date).apply(zone));
	}

    /**
     * Factory to create a {@link TemporalProvider} for a {@link Second}
     */
    public static TemporalProvider<Second> second(OffsetDateTime date) {
        return (zone) -> Second.from(offsetDateTime(date).apply(zone));
    }
	
	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Millisecond}
	 */
	public static TemporalProvider<Millisecond> millisecondOfMinute(Date date) {
		return (zone) -> Millisecond.from(instant(date).apply(zone));
	}

	/**
	 * Factory to create a {@link TemporalProvider} for a {@link Integer}
	 */
	public static TemporalProvider<Millisecond> millisecondOfMinute(int millisecond) {
		return (zone) -> Millisecond.of(millisecond);
	}

}
