Hamcrest Date
=============

A date matching library for [Java Hamcrest][]

Licensed under [BSD License][].

What is Hamcrest Date?
-----------------
Hamcrest Date is an extension library for the [Java Hamcrest][] matcher library

Downloads
---------
You can obtain Hamcrest binaries from [maven central][]. To include your project in:

A maven project

    <dependency>
        <groupId>uk.co.modular-it</groupId>
        <artifactId>hamcrest-date</artifactId>
        <version>0.9.5</version>
    </dependency>

A project which uses ivy for dependency management

    <dependency org="uk.co.modular-it" name="hamcrest-date" rev="0.9.5"/>
            
Binaries
--------
Hamcrest Date has a single binary, hamcrest-date.jar, which contains all the date matchers. Sources and JavaDoc jars are available.

Usage
-------------

The matchers are exposed as static methods on the DateMatchers class. For Example

    Date today = new Date(); myBirthday = new Date();
    MatcherAssert.assertThat(today, DateMatchers.sameDate(myBirthday));

or

    Date today = new Date(); myBirthday = new Date()
    MatcherAssert.assertThat(today, DateMatchers.within(1, TimeUnit.DAY, myBirthday));

or after static importing

    Date today = new Date(); myBirthday = new Date();
    assertThat(today, within(1, DAY, myBirthday));

A factories is provided for commonly used moments in time. For Example

    Date myBirthday = new Date();
    MatcherAssert.assertThat(myBirthday, DateMatchers.sameDate(Moments.today()));


The libary includes date matchers for:

* __after__ - Test if the actual date is after the reference date
* __before__ - Test if the actual date is before the reference date
* __within__ - Test if the actual date is within a given period (before or after) of the reference date
* __sameDatePart__ - Test if the actual date has the same date part as the reference date
* __sameDay__ - Test if the actual date is on the same day as the reference date
* __sameHour__ - Test if the actual date is on the same hour of the day as the reference date
* __sameInstant__ - Test if the actual date is the same, down to the millisecond, as the reference date
* __sameOrBefore__ - Test if the actual date is the same or before the reference date
* __sameOrAfter__ - Test if the actual date is the same or after the reference date
* __sameMinute__ - Test if the actual date is on the same minute of the hour as the reference date
* __sameMonth__ - Test if the actual date is on the same month of the year as the reference date
* __sameSecond__ - Test if the actual date is on the same second of the minute as the reference date
* __sameWeekday__ - Test if the actual date is on the same week day as the reference date
* __sameYear__ - Test if the actual date is on the same year as the reference date
* __isYesterday__ - Test if the actual date is yesterday
* __isToday__ - Test if the actual date is today
* __isToday__ - Test if the actual date is tomorrow
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

Acknowledgements
----------------
Developers:
  * Stewart Bissett

Thanks to the developers at [Java Hamcrest][]. Without their hardwork and core libraries there'd be nothing to be extend and we be stuck with old school, non-declarative, non-reusable, assertions.

[BSD License]: http://opensource.org/licenses/BSD-3-Clause
[Maven central]: http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22hamcrest-date%22
[Java Hamcrest]: http://github.com/hamcrest/JavaHamcrest
