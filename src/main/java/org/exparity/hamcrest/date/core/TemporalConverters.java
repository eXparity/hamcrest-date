package org.exparity.hamcrest.date.core;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Year;
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
 * {@link DateMatcher} implementations.
 * </p>
 * The temporal converters generally "down-cast" a temporal type to another and are used to support testing the actual
 * type against the reference type where the reference type is an equal or less accurate temporal unit e.g. comparing if
 * a LocalDateTime is on a given year. There should not be "up-casting" converters because these would be making up
 * absent information e.g. converting a {@link LocalDate} to a {@link LocalDateTime}
 */
public class TemporalConverters {
    
    private TemporalConverters() {};

	public static final String UNSUPPORTED_SQL_DATE_UNIT = "java.sql.Date does not support time-based comparisons. Prefer SqlDateMatchers for java.sql.Date appropriate matchers";
	
	/**
	 * SQL Date Converters
	 */
	public static TemporalConverter<java.sql.Date, LocalDate> SQLDATE_AS_LOCALDATE = (date, zone) -> date.toLocalDate();
	public static TemporalConverter<java.sql.Date, java.sql.Date> SQLDATE_AS_SQLDATE = (date, zone) -> date;
	public static TemporalConverter<java.sql.Date, Year> SQLDATE_AS_YEAR = (date, zone) -> Year.from(SQLDATE_AS_LOCALDATE.apply(date, zone));
	public static TemporalConverter<java.sql.Date, Month> SQLDATE_AS_MONTH = (date, zone) -> SQLDATE_AS_LOCALDATE.apply(date, zone).getMonth();
	public static TemporalConverter<java.sql.Date, DayOfMonth> SQLDATE_AS_DAYOFMONTH = (date, zone) -> DayOfMonth.from(SQLDATE_AS_LOCALDATE.apply(date, zone));
	public static TemporalConverter<java.sql.Date, DayOfWeek> SQLDATE_AS_DAYOFWEEK = (date, zone) -> SQLDATE_AS_LOCALDATE.apply(date, zone).getDayOfWeek();

	/**
	 * Java Date Converters
	 */
	public static TemporalConverter<Date, java.sql.Date> JAVADATE_AS_SQLDATE = (date, zone) -> {
		if (date instanceof java.sql.Date) {
			return (java.sql.Date) date;
		} else {
			return new java.sql.Date(date.getTime());
		}
	};

	public static TemporalConverter<Date, Instant> JAVADATE_AS_INSTANT = (date, zone) -> {
		if (date instanceof java.sql.Date) {
			throw new TemporalConversionException(UNSUPPORTED_SQL_DATE_UNIT);
		} else {
			return date.toInstant();
		}
	};

	public static TemporalConverter<Date, ZonedDateTime> JAVADATE_AS_ZONEDDATETIME = (date, zone) -> JAVADATE_AS_INSTANT.apply(date, zone).atZone(zone);
	public static TemporalConverter<Date, LocalDateTime> JAVADATE_AS_LOCALDATETIME = (date, zone) -> JAVADATE_AS_ZONEDDATETIME.apply(date, zone).toLocalDateTime();

	public static TemporalConverter<Date, LocalDate> JAVADATE_AS_LOCALDATE = (date, zone) -> {
		if (date instanceof java.sql.Date) {
			return ((java.sql.Date) date).toLocalDate();
		} else {
			return JAVADATE_AS_ZONEDDATETIME.apply(date, zone).toLocalDate();
		}
	};
	
	public static TemporalConverter<Date, TemporalAccessor> JAVADATE_AS_TEMPORAL = (date, zone) -> {
		if (date instanceof java.sql.Date) {
			return JAVADATE_AS_LOCALDATE.apply(date, zone);
		} else {
			return JAVADATE_AS_ZONEDDATETIME.apply(date, zone);
		}
	};
	

	public static TemporalConverter<Date, Date> JAVADATE_AS_JAVADATE = (date, zone) -> date;
	public static TemporalConverter<Date, Year> JAVADATE_AS_YEAR = (date, zone) -> Year.from(JAVADATE_AS_LOCALDATE.apply(date, zone));
	public static TemporalConverter<Date, Month> JAVADATE_AS_MONTH = (date, zone) -> JAVADATE_AS_LOCALDATE.apply(date, zone).getMonth();
	public static TemporalConverter<Date, DayOfMonth> JAVADATE_AS_DAYOFMONTH = (date, zone) -> DayOfMonth.from(JAVADATE_AS_LOCALDATE.apply(date, zone));
	public static TemporalConverter<Date, DayOfWeek> JAVADATE_AS_DAYOFWEEK = (date, zone) -> JAVADATE_AS_LOCALDATE.apply(date, zone).getDayOfWeek();
	public static TemporalConverter<Date, Hour> JAVADATE_AS_HOUR = (date, zone) -> Hour.from(JAVADATE_AS_LOCALDATETIME.apply(date, zone));
	public static TemporalConverter<Date, Minute> JAVADATE_AS_MINUTE = (date, zone) -> Minute.from(JAVADATE_AS_LOCALDATETIME.apply(date, zone));
	public static TemporalConverter<Date, Second> JAVADATE_AS_SECOND = (date, zone) -> Second.from(JAVADATE_AS_LOCALDATETIME.apply(date, zone));
	public static TemporalConverter<Date, Millisecond> JAVADATE_AS_MILLISECOND = (date, zone) -> Millisecond.from(JAVADATE_AS_INSTANT.apply(date, zone));

	/**
	 * LocalTime Converters
	 */
	public static TemporalConverter<LocalTime, LocalTime> LOCALTIME_AS_LOCALTIME = (time, zone) -> time;
	public static TemporalConverter<LocalTime, Hour> LOCALTIME_AS_HOUR = (time, zone) -> Hour.from(time);
	public static TemporalConverter<LocalTime, Minute> LOCALTIME_AS_MINUTE = (time, zone) -> Minute.from(time);
	public static TemporalConverter<LocalTime, Second> LOCALTIME_AS_SECOND = (time, zone) -> Second.from(time);

	/**
	 * LocalDate Converters
	 */
	public static TemporalConverter<LocalDate, LocalDate> LOCALDATE_AS_LOCALDATE = (date, zone) -> date;
	public static TemporalConverter<LocalDate, Year> LOCALDATE_AS_YEAR = (date, zone) -> Year.from(date);
	public static TemporalConverter<LocalDate, Month> LOCALDATE_AS_MONTH = (date, zone) -> date.getMonth();
	public static TemporalConverter<LocalDate, DayOfMonth> LOCALDATE_AS_DAYOFMONTH = (date, zone) -> DayOfMonth.from(date);
	public static TemporalConverter<LocalDate, DayOfWeek> LOCALDATE_AS_DAYOFWEEK = (date, zone) -> date.getDayOfWeek();
	
	/**
	 * LocalDateTime Converters
	 */
	public static TemporalConverter<LocalDateTime, LocalDateTime> LOCALDATETIME_AS_LOCALDATETIME = (date, zone) -> date;
	public static TemporalConverter<LocalDateTime, LocalDate> LOCALDATETIME_AS_LOCALDATE = (date, zone) -> date.toLocalDate();
	public static TemporalConverter<LocalDateTime, Year> LOCALDATETIME_AS_YEAR = (date, zone) -> Year.from(date);
	public static TemporalConverter<LocalDateTime, Month> LOCALDATETIME_AS_MONTH = (date, zone) -> date.getMonth();
	public static TemporalConverter<LocalDateTime, DayOfMonth> LOCALDATETIME_AS_DAYOFMONTH = (date, zone) -> DayOfMonth.from(date);
	public static TemporalConverter<LocalDateTime, DayOfWeek> LOCALDATETIME_AS_DAYOFWEEK = (date, zone) -> date.getDayOfWeek();
	public static TemporalConverter<LocalDateTime, Hour> LOCALDATETIME_AS_HOUR = (date, zone) -> Hour.from(date);
	public static TemporalConverter<LocalDateTime, Minute> LOCALDATETIME_AS_MINUTE = (date, zone) -> Minute.from(date);
	public static TemporalConverter<LocalDateTime, Second> LOCALDATETIME_AS_SECOND = (date, zone) -> Second.from(date);

	/**
	 * ZonedDateTime Converters
	 */
	public static TemporalConverter<ZonedDateTime, ZonedDateTime> ZONEDDATETIME_AS_ZONEDDATETIME = (date, zone) -> date.withZoneSameInstant(zone);
	public static TemporalConverter<ZonedDateTime, LocalDate> ZONEDDATETIME_AS_LOCALDATE = (date, zone) -> ZONEDDATETIME_AS_ZONEDDATETIME.apply(date, zone).toLocalDate();
	public static TemporalConverter<ZonedDateTime, Year> ZONEDDATETIME_AS_YEAR = (date, zone) -> Year.from(ZONEDDATETIME_AS_LOCALDATE.apply(date, zone));
	public static TemporalConverter<ZonedDateTime, Month> ZONEDDATETIME_AS_MONTH = (date, zone) -> ZONEDDATETIME_AS_LOCALDATE.apply(date, zone).getMonth();
	public static TemporalConverter<ZonedDateTime, DayOfMonth> ZONEDDATETIME_AS_DAYOFMONTH = (date, zone) -> DayOfMonth.from(ZONEDDATETIME_AS_LOCALDATE.apply(date, zone));
	public static TemporalConverter<ZonedDateTime, DayOfWeek> ZONEDDATETIME_AS_DAYOFWEEK = (date, zone) -> ZONEDDATETIME_AS_LOCALDATE.apply(date, zone).getDayOfWeek();
	public static TemporalConverter<ZonedDateTime, Hour> ZONEDDATETIME_AS_HOUR = (date, zone) -> Hour.from(ZONEDDATETIME_AS_ZONEDDATETIME.apply(date, zone));
	public static TemporalConverter<ZonedDateTime, Minute> ZONEDDATETIME_AS_MINUTE = (date, zone) -> Minute.from(ZONEDDATETIME_AS_ZONEDDATETIME.apply(date, zone));
	public static TemporalConverter<ZonedDateTime, Second> ZONEDDATETIME_AS_SECOND = (date, zone) -> Second.from(ZONEDDATETIME_AS_ZONEDDATETIME.apply(date, zone));
	
	/**
	 * DayOfWeek Converters
	 */
	public static TemporalConverter<DayOfWeek, DayOfWeek> DAYOFWEEK_TO_DAYOFWEEK = (date, zone) -> date;
	
	/**
     * {@link OffsetDateTime} Converters
     */
    public static TemporalConverter<OffsetDateTime, OffsetDateTime> OFFSETDATETIME_AS_OFFSETDATETIME = (date, zone) -> date.withOffsetSameInstant(zone.getRules().getOffset(date.toLocalDateTime()));    
    public static TemporalConverter<OffsetDateTime, LocalDate> OFFSETDATETIME_AS_LOCALDATE = (date, zone) -> OFFSETDATETIME_AS_OFFSETDATETIME.apply(date, zone).toLocalDate();
    public static TemporalConverter<OffsetDateTime, Year> OFFSETDATETIME_AS_YEAR = (date, zone) -> Year.from(OFFSETDATETIME_AS_LOCALDATE.apply(date, zone));
    public static TemporalConverter<OffsetDateTime, Month> OFFSETDATETIME_AS_MONTH = (date, zone) -> OFFSETDATETIME_AS_LOCALDATE.apply(date, zone).getMonth();
    public static TemporalConverter<OffsetDateTime, DayOfMonth> OFFSETDATETIME_AS_DAYOFMONTH = (date, zone) -> DayOfMonth.from(OFFSETDATETIME_AS_LOCALDATE.apply(date, zone));
    public static TemporalConverter<OffsetDateTime, DayOfWeek> OFFSETDATETIME_AS_DAYOFWEEK = (date, zone) -> OFFSETDATETIME_AS_LOCALDATE.apply(date, zone).getDayOfWeek();
    public static TemporalConverter<OffsetDateTime, Hour> OFFSETDATETIME_AS_HOUR = (date, zone) -> Hour.from(OFFSETDATETIME_AS_OFFSETDATETIME.apply(date, zone));
    public static TemporalConverter<OffsetDateTime, Minute> OFFSETDATETIME_AS_MINUTE = (date, zone) -> Minute.from(OFFSETDATETIME_AS_OFFSETDATETIME.apply(date, zone));
    public static TemporalConverter<OffsetDateTime, Second> OFFSETDATETIME_AS_SECOND = (date, zone) -> Second.from(OFFSETDATETIME_AS_OFFSETDATETIME.apply(date, zone));    
}
