package org.exparity.hamcrest.date.core;

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
import java.time.temporal.TemporalAccessor;
import java.util.Date;

import org.exparity.hamcrest.date.core.types.DayOfMonth;
import org.exparity.hamcrest.date.core.types.Hour;
import org.exparity.hamcrest.date.core.types.Millisecond;
import org.exparity.hamcrest.date.core.types.Minute;
import org.exparity.hamcrest.date.core.types.Second;

/**
 * Static repository of {@link TemporalConverter} instances which convert a temporal type from another temporal type
 * e.g. given a {@link LocalDate} returns the hour, or given a {@link java.sql.Date} returns a {@link LocalDate}.
 * No-operation conversions e.g. LocalDate to LocalDate are present to keep a consistent usage pattern in the
 * {@link TemporalMatcher} implementations.
 * <p>
 * The temporal converters generally "down-cast" a temporal type to another and are used to support testing the actual
 * type against the reference type where the reference type is an equal or less accurate temporal unit e.g. comparing if
 * a LocalDateTime is on a given year. There should not be "up-casting" converters because these would be making up
 * absent information e.g. converting a {@link LocalDate} to a {@link LocalDateTime}</p>
 */
public final class TemporalConverters {
    
    private TemporalConverters() {}

	public static final String UNSUPPORTED_SQL_DATE_UNIT = "java.sql.Date does not support time-based comparisons. Prefer SqlDateMatchers for java.sql.Date appropriate matchers";
	
	/**
	 * SQL Date Converters
	 */
	public static final TemporalConverter<java.sql.Date, LocalDate> SQLDATE_AS_LOCALDATE = (date, zone) -> date.toLocalDate();
	public static final TemporalConverter<java.sql.Date, java.sql.Date> SQLDATE_AS_SQLDATE = (date, zone) -> date;
	public static final TemporalConverter<java.sql.Date, Year> SQLDATE_AS_YEAR = (date, zone) -> Year.from(SQLDATE_AS_LOCALDATE.apply(date, zone));
	public static final TemporalConverter<java.sql.Date, Month> SQLDATE_AS_MONTH = (date, zone) -> SQLDATE_AS_LOCALDATE.apply(date, zone).getMonth();
	public static final TemporalConverter<java.sql.Date, DayOfMonth> SQLDATE_AS_DAYOFMONTH = (date, zone) -> DayOfMonth.from(SQLDATE_AS_LOCALDATE.apply(date, zone));
	public static final TemporalConverter<java.sql.Date, DayOfWeek> SQLDATE_AS_DAYOFWEEK = (date, zone) -> SQLDATE_AS_LOCALDATE.apply(date, zone).getDayOfWeek();

	/**
	 * Java Date Converters
	 */

	public static final TemporalConverter<Date, Instant> JAVADATE_AS_INSTANT = (date, zone) -> {
		if (date instanceof java.sql.Date) {
			throw new TemporalConversionException(UNSUPPORTED_SQL_DATE_UNIT);
		} else {
			return date.toInstant();
		}
	};

	public static final TemporalConverter<Date, ZonedDateTime> JAVADATE_AS_ZONEDDATETIME = (date, zone) -> JAVADATE_AS_INSTANT.apply(date, zone).atZone(zone.orElse(ZoneId.systemDefault()));
	public static final TemporalConverter<Date, LocalDateTime> JAVADATE_AS_LOCALDATETIME = (date, zone) -> JAVADATE_AS_ZONEDDATETIME.apply(date, zone).toLocalDateTime();

	public static final TemporalConverter<Date, LocalDate> JAVADATE_AS_LOCALDATE = (date, zone) -> {
		if (date instanceof java.sql.Date) {
			return ((java.sql.Date) date).toLocalDate();
		} else {
			return JAVADATE_AS_ZONEDDATETIME.apply(date, zone).toLocalDate();
		}
	};
	
	public static final TemporalConverter<Date, TemporalAccessor> JAVADATE_AS_TEMPORAL = (date, zone) -> {
		if (date instanceof java.sql.Date) {
			return JAVADATE_AS_LOCALDATE.apply(date, zone);
		} else {
			return JAVADATE_AS_ZONEDDATETIME.apply(date, zone);
		}
	};
	
    public static final TemporalConverter<Date, java.sql.Date> JAVADATE_AS_SQLDATE = (date, zone) -> {
        if (date instanceof java.sql.Date) {
            return (java.sql.Date) date;
        } else {
            return new java.sql.Date(date.getTime());
        }
    };

	public static final TemporalConverter<Date, Date> JAVADATE_AS_JAVADATE = (date, zone) -> date;
	public static final TemporalConverter<Date, Year> JAVADATE_AS_YEAR = (date, zone) -> Year.from(JAVADATE_AS_LOCALDATE.apply(date, zone));
	public static final TemporalConverter<Date, Month> JAVADATE_AS_MONTH = (date, zone) -> JAVADATE_AS_LOCALDATE.apply(date, zone).getMonth();
	public static final TemporalConverter<Date, DayOfMonth> JAVADATE_AS_DAYOFMONTH = (date, zone) -> DayOfMonth.from(JAVADATE_AS_LOCALDATE.apply(date, zone));
	public static final TemporalConverter<Date, DayOfWeek> JAVADATE_AS_DAYOFWEEK = (date, zone) -> JAVADATE_AS_LOCALDATE.apply(date, zone).getDayOfWeek();
	public static final TemporalConverter<Date, Hour> JAVADATE_AS_HOUR = (date, zone) -> Hour.from(JAVADATE_AS_LOCALDATETIME.apply(date, zone));
	public static final TemporalConverter<Date, Minute> JAVADATE_AS_MINUTE = (date, zone) -> Minute.from(JAVADATE_AS_LOCALDATETIME.apply(date, zone));
	public static final TemporalConverter<Date, Second> JAVADATE_AS_SECOND = (date, zone) -> Second.from(JAVADATE_AS_LOCALDATETIME.apply(date, zone));
	public static final TemporalConverter<Date, Millisecond> JAVADATE_AS_MILLISECOND = (date, zone) -> Millisecond.from(JAVADATE_AS_INSTANT.apply(date, zone));

	/**
	 * LocalTime Converters
	 */
	public static final TemporalConverter<LocalTime, LocalTime> LOCALTIME_AS_LOCALTIME = (time, zone) -> time;
	public static final TemporalConverter<LocalTime, Hour> LOCALTIME_AS_HOUR = (time, zone) -> Hour.from(time);
	public static final TemporalConverter<LocalTime, Minute> LOCALTIME_AS_MINUTE = (time, zone) -> Minute.from(time);
	public static final TemporalConverter<LocalTime, Second> LOCALTIME_AS_SECOND = (time, zone) -> Second.from(time);

	/**
	 * LocalDate Converters
	 */
	public static final TemporalConverter<LocalDate, LocalDate> LOCALDATE_AS_LOCALDATE = (date, zone) -> date;
	public static final TemporalConverter<LocalDate, Year> LOCALDATE_AS_YEAR = (date, zone) -> Year.from(date);
	public static final TemporalConverter<LocalDate, Month> LOCALDATE_AS_MONTH = (date, zone) -> date.getMonth();
	public static final TemporalConverter<LocalDate, DayOfMonth> LOCALDATE_AS_DAYOFMONTH = (date, zone) -> DayOfMonth.from(date);
	public static final TemporalConverter<LocalDate, DayOfWeek> LOCALDATE_AS_DAYOFWEEK = (date, zone) -> date.getDayOfWeek();
	
	/**
	 * LocalDateTime Converters
	 */
	public static final TemporalConverter<LocalDateTime, LocalDateTime> LOCALDATETIME_AS_LOCALDATETIME = (date, zone) -> date;
	public static final TemporalConverter<LocalDateTime, LocalDate> LOCALDATETIME_AS_LOCALDATE = (date, zone) -> date.toLocalDate();
	public static final TemporalConverter<LocalDateTime, Year> LOCALDATETIME_AS_YEAR = (date, zone) -> Year.from(date);
	public static final TemporalConverter<LocalDateTime, Month> LOCALDATETIME_AS_MONTH = (date, zone) -> date.getMonth();
	public static final TemporalConverter<LocalDateTime, DayOfMonth> LOCALDATETIME_AS_DAYOFMONTH = (date, zone) -> DayOfMonth.from(date);
	public static final TemporalConverter<LocalDateTime, DayOfWeek> LOCALDATETIME_AS_DAYOFWEEK = (date, zone) -> date.getDayOfWeek();
	public static final TemporalConverter<LocalDateTime, Hour> LOCALDATETIME_AS_HOUR = (date, zone) -> Hour.from(date);
	public static final TemporalConverter<LocalDateTime, Minute> LOCALDATETIME_AS_MINUTE = (date, zone) -> Minute.from(date);
	public static final TemporalConverter<LocalDateTime, Second> LOCALDATETIME_AS_SECOND = (date, zone) -> Second.from(date);

	/**
	 * ZonedDateTime Converters
	 */
	public static final TemporalConverter<ZonedDateTime, ZonedDateTime> ZONEDDATETIME_AS_ZONEDDATETIME = (date, zone) -> zone.map(
			date::withZoneSameInstant).orElse(date);
	public static final TemporalConverter<ZonedDateTime, LocalDate> ZONEDDATETIME_AS_LOCALDATE = (date, zone) -> ZONEDDATETIME_AS_ZONEDDATETIME.apply(date, zone).toLocalDate();
	public static final TemporalConverter<ZonedDateTime, Year> ZONEDDATETIME_AS_YEAR = (date, zone) -> Year.from(ZONEDDATETIME_AS_LOCALDATE.apply(date, zone));
	public static final TemporalConverter<ZonedDateTime, Month> ZONEDDATETIME_AS_MONTH = (date, zone) -> ZONEDDATETIME_AS_LOCALDATE.apply(date, zone).getMonth();
	public static final TemporalConverter<ZonedDateTime, DayOfMonth> ZONEDDATETIME_AS_DAYOFMONTH = (date, zone) -> DayOfMonth.from(ZONEDDATETIME_AS_LOCALDATE.apply(date, zone));
	public static final TemporalConverter<ZonedDateTime, DayOfWeek> ZONEDDATETIME_AS_DAYOFWEEK = (date, zone) -> ZONEDDATETIME_AS_LOCALDATE.apply(date, zone).getDayOfWeek();
	public static final TemporalConverter<ZonedDateTime, Hour> ZONEDDATETIME_AS_HOUR = (date, zone) -> Hour.from(ZONEDDATETIME_AS_ZONEDDATETIME.apply(date, zone));
	public static final TemporalConverter<ZonedDateTime, Minute> ZONEDDATETIME_AS_MINUTE = (date, zone) -> Minute.from(ZONEDDATETIME_AS_ZONEDDATETIME.apply(date, zone));
	public static final TemporalConverter<ZonedDateTime, Second> ZONEDDATETIME_AS_SECOND = (date, zone) -> Second.from(ZONEDDATETIME_AS_ZONEDDATETIME.apply(date, zone));
	
	/**
	 * DayOfWeek Converters
	 */
	public static final TemporalConverter<DayOfWeek, DayOfWeek> DAYOFWEEK_TO_DAYOFWEEK = (date, zone) -> date;
	
	/**
     * {@link OffsetDateTime} Converters
     */
	public static final TemporalConverter<OffsetDateTime, OffsetDateTime> OFFSETDATETIME_AS_OFFSETDATETIME = (date, zone) -> zone.map(z -> date.withOffsetSameInstant(z.getRules().getOffset(date.toLocalDateTime()))).orElse(date);    
    public static final TemporalConverter<OffsetDateTime, LocalDate> OFFSETDATETIME_AS_LOCALDATE = (date, zone) -> OFFSETDATETIME_AS_OFFSETDATETIME.apply(date, zone).toLocalDate();
    public static final TemporalConverter<OffsetDateTime, Year> OFFSETDATETIME_AS_YEAR = (date, zone) -> Year.from(OFFSETDATETIME_AS_LOCALDATE.apply(date, zone));
    public static final TemporalConverter<OffsetDateTime, Month> OFFSETDATETIME_AS_MONTH = (date, zone) -> OFFSETDATETIME_AS_LOCALDATE.apply(date, zone).getMonth();
    public static final TemporalConverter<OffsetDateTime, DayOfMonth> OFFSETDATETIME_AS_DAYOFMONTH = (date, zone) -> DayOfMonth.from(OFFSETDATETIME_AS_LOCALDATE.apply(date, zone));
    public static final TemporalConverter<OffsetDateTime, DayOfWeek> OFFSETDATETIME_AS_DAYOFWEEK = (date, zone) -> OFFSETDATETIME_AS_LOCALDATE.apply(date, zone).getDayOfWeek();
    public static final TemporalConverter<OffsetDateTime, Hour> OFFSETDATETIME_AS_HOUR = (date, zone) -> Hour.from(OFFSETDATETIME_AS_OFFSETDATETIME.apply(date, zone));
    public static final TemporalConverter<OffsetDateTime, Minute> OFFSETDATETIME_AS_MINUTE = (date, zone) -> Minute.from(OFFSETDATETIME_AS_OFFSETDATETIME.apply(date, zone));
    public static final TemporalConverter<OffsetDateTime, Second> OFFSETDATETIME_AS_SECOND = (date, zone) -> Second.from(OFFSETDATETIME_AS_OFFSETDATETIME.apply(date, zone));    
    
    /**
     * Instant Converters
     */
    public static final TemporalConverter<Instant, Instant> INSTANT_AS_INSTANT = (date, zone) -> date;
    public static final TemporalConverter<Instant, ZonedDateTime> INSTANT_AS_ZONEDDATETIME = (date, zone) -> zone.map(date::atZone).orElse(date.atZone(ZoneId.systemDefault()));
    public static final TemporalConverter<Instant, LocalDate> INSTANT_AS_LOCALDATE = (date, zone) -> INSTANT_AS_ZONEDDATETIME.apply(date, zone).toLocalDate();
    public static final TemporalConverter<Instant, Year> INSTANT_AS_YEAR = (date, zone) -> Year.from(INSTANT_AS_LOCALDATE.apply(date, zone));
    public static final TemporalConverter<Instant, Month> INSTANT_AS_MONTH = (date, zone) -> INSTANT_AS_LOCALDATE.apply(date, zone).getMonth();
    public static final TemporalConverter<Instant, DayOfMonth> INSTANT_AS_DAYOFMONTH = (date, zone) -> DayOfMonth.from(INSTANT_AS_LOCALDATE.apply(date, zone));
    public static final TemporalConverter<Instant, DayOfWeek> INSTANT_AS_DAYOFWEEK = (date, zone) -> INSTANT_AS_LOCALDATE.apply(date, zone).getDayOfWeek();
    public static final TemporalConverter<Instant, Hour> INSTANT_AS_HOUR = (date, zone) -> Hour.from(INSTANT_AS_ZONEDDATETIME.apply(date, zone));
    public static final TemporalConverter<Instant, Minute> INSTANT_AS_MINUTE = (date, zone) -> Minute.from(INSTANT_AS_ZONEDDATETIME.apply(date, zone));
    public static final TemporalConverter<Instant, Second> INSTANT_AS_SECOND = (date, zone) -> Second.from(INSTANT_AS_ZONEDDATETIME.apply(date, zone));

}
