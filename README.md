Hamcrest Date  [![Build Status](https://travis-ci.org/eXparity/hamcrest-date.svg?branch=master)](https://travis-ci.org/eXparity/hamcrest-date) [![Coverage Status](https://coveralls.io/repos/eXparity/hamcrest-date/badge.png?branch=master)](https://coveralls.io/r/eXparity/hamcrest-date?branch=master)
=============

A date matching library for [Java Hamcrest][]

Licensed under [BSD License][].

What is Hamcrest Date?
-----------------
Hamcrest Date is an extension library for the [Java Hamcrest][] matcher library which provides Matcher implementations for Java date types including LocalDate, LocalTime, LocalDateTime, ZonedDateTime, and Date.

Downloads
---------
You can obtain Hamcrest Date binaries from [maven central][]. To include in your project:

A maven project

    <dependency>
        <groupId>org.exparity</groupId>
        <artifactId>hamcrest-date</artifactId>
        <version>2.0.2</version>
    </dependency>


Versions 2.x.x onwards require Java 8. If you are using an earlier version of Java 8 then include version

    <dependency>
        <groupId>org.exparity</groupId>
        <artifactId>hamcrest-date</artifactId>
        <version>1.1.0</version>
    </dependency>


            
Binaries
--------
Hamcrest Date has a single binary, hamcrest-date.jar, which contains all the date matchers. Sources and JavaDoc jars are available.

Usage
-------------

The matchers are exposed as static methods on the LocalDateMatchers, LocalTimeMatchers, LocalDateTimeMatchers, ZonedDateTimeMatchers, and DateMatchers class. For example

    LocalDate today = LocalDate.now(); myBirthday = LocalDate.of(2015, AUGUST, 9);
    MatcherAssert.assertThat(today, LocalDateMatchers.sameDay(myBirthday));

or to test if you're getting closer to your birthday

    LocalDate today = LocalDate.now(); myBirthday = LocalDate.of(2015, AUGUST, 9);
    MatcherAssert.assertThat(today, LocalDateMatchers.within(1, ChronoUnit.DAY, myBirthday));

or after static importing

    LocalDate today = LocalDate.now(); myBirthday = LocalDate.of(2015, AUGUST, 9);
    assertThat(today, within(1, DAY, myBirthday));

The same matchers are available for all date types so to match LocalDateTime values: 

    LocalDateTime myAppointment = LocalDateTime.of(2015, AUGUST, 9, 10, 30, 0);
    assertThat(LocalDateTime.now(), within(15, MINUTES, myAppointment));

or to match ZonedDateTime values:

    ZonedDateTime myAppointment = ZonedDateTime.of(LocalDateTime.of(2015, AUGUST, 9, 10, 30, 0), ZoneId.of("UTC"));
    assertThat(ZonedDateTime.now(), within(15, MINUTES, myAppointment));

or to match LocalTime values:

    LocalTime myAppointment = LocalTime.NOON;
    assertThat(LocalTime.now(), within(15, MINUTES, myAppointment));


The libary includes date matchers for:

* __after__ - Test if the actual date is after the reference date
* __before__ - Test if the actual date is before the reference date
* __within__ - Test if the actual date is within a given period (before or after) of the reference date
* __sameDay__ - Test if the actual date is on the same day as the reference date
* __sameHourOfDay__ - Test if the actual date is on the same hour of the day as the reference date
* __sameInstant__ - Test if the actual date at the same instance as the reference date
* __sameOrBefore__ - Test if the actual date is the same or before the reference date
* __sameOrAfter__ - Test if the actual date is the same or after the reference date
* __sameMinuteOfHour__ - Test if the actual date is on the same minute of the hour as the reference date
* __sameMonthOfYear__ - Test if the actual date is on the same month of the year as the reference date
* __sameSecondOfMinute__ - Test if the actual date is on the same second of the minute as the reference date
* __sameDayOfWeek__ - Test if the actual date is on the same week day as the reference date
* __sameYear__ - Test if the actual date is on the same year as the reference date
* __isInstance__ - Test if the actual date is at the exact instant
* __isSecond__ - Test if the actual date is on the given second
* __isMinute__ - Test if the actual date is on the given minute
* __isHour__ - Test if the actual date is on the given hour
* __isDayOfWeek__ - Test if the actual date is on the given day of the week
* __isDayOfMonth__ - Test if the actual date is on the given day of the month
* __isMonth__ - Test if the actual date is on the given month
* __isYear__ - Test if the actual date is on the given year
* __isYesterday__ - Test if the actual date is yesterday
* __isToday__ - Test if the actual date is today
* __isTomorrow__ - Test if the actual date is tomorrow
* __isMonday__ - Test if the actual date is on a monday
* __isTuesday__ - Test if the actual date is on a tuesday
* __isWednesday__ - Test if the actual date is on a wednesday
* __isThursday__ - Test if the actual date is on a thursday
* __isFriday__ - Test if the actual date is on a friday
* __isSaturday__ - Test if the actual date is on a saturday
* __isSunday__ - Test if the actual date is on a sunday
* __isWeekday__ - Test if the actual date is on a weekday
* __isWeekend__ - Test if the actual date is on a weekend
* __isJanuary__ - Test if the actual date is in january
* __isFebruary__ - Test if the actual date is in february
* __isMarch__ - Test if the actual date is in march
* __isApril__ - Test if the actual date is in april
* __isMay__ - Test if the actual date is in may
* __isJune__ - Test if the actual date is in june
* __isJuly__ - Test if the actual date is in july
* __isAugust__ - Test if the actual date is in august
* __isSeptember__ - Test if the actual date is in september
* __isOctober__ - Test if the actual date is in october
* __isNovember__ - Test if the actual date is in november
* __isDecember__ - Test if the actual date is in december
* __isLeapYear__ - Test if the actual date is on a leap year

The Javadocs include examples on all methods so you can look there for examples for specific methods

Source
------
The source is structured along the lines of the maven standard folder structure for a jar project.

  * Core classes [src/main/java]
  * Unit tests [src/test/java]

The source includes a pom.xml for building with Maven 

Release Notes
-------------
Changes 2.0.1 -> 2.0.2
  * Add Support for LocalTime
  
Changes 1.1.0 -> 2.0.0
  * Add Support for Java 8 date types.
  * Add new is{*} matchers
  * Move matcher classes to .core package
  
Changes 1.0.1 -> 1.1
  * Remove deprecated uk.co.it.modular.hamcrest.date.DateMatchers.

Changes 1.0.0 -> 1.0.1
  * Restore and deprecate uk.co.it.modular.hamcrest.date.DateMatchers for backwards compatibility with previous package structure.
  
Changes 0.9.5 -> 1.0.0
  * Package change to new organisation org.exparity from uk.co.it.modular
  * Fixup flaky tests by using local timezone in non-timezone tests

Acknowledgements
----------------
Developers:
  * Stewart Bissett

Thanks to the developers at [Java Hamcrest][]. Without their hardwork and core libraries there'd be nothing to be extend and we be stuck with old school, non-declarative, non-reusable, assertions.

[BSD License]: http://opensource.org/licenses/BSD-3-Clause
[Maven central]: http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22hamcrest-date%22
[Java Hamcrest]: http://github.com/hamcrest/JavaHamcrest
