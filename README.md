Hamcrest Date (a date matching library for [Java Hamcrest][])
=============
Licensed under [BSD License][].

What is Hamcrest Date?
-----------------
Hamcrest Date is an extension library for the [Java Hamcrest][] matcher library

Downloads
---------
You can obtain Hamcrest binaries from [maven central][]. To include your project in:

A maven project

    <dependency>
        <groupId>uk.co.it.modular</groupId>
        <artifactId>hamcrest-date</artifactId>
        <version>0.9.1</version>
    </dependency>

A project which uses ivy for dependency management

    <dependency org="uk.co.it.modular" name="hamcrest-date" rev="0.9.1"/>
            
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

The libary includes date matchers for:

* __after__ - Test if the actual date is after the reference date
* __before__ - Test if the actual date is before the reference date
* __sameDay__ - Test if the actual date is on the same day as the reference date
* __sameDayOfTheMonth__ - Test if the actual date is on the same day of the month as the reference date
* __sameHour__ - Test if the actual date is on the same hour of the day as the reference date
* __sameInstant__ - Test if the actual date is the same, down to the millisecond, as the reference date
* __sameMinute__ - Test if the actual date is on the same minute of the hour as the reference date
* __sameMonth__ - Test if the actual date is on the same month of the year as the reference date
* __sameSecond__ - Test if the actual date is on the same second of the minute as the reference date
* __sameWeekday__ - Test if the actual date is on the same week day as the reference date
* __sameYear__ - Test if the actual date is on the same year as the reference date
* __within__ - Test if the actual date is within a given period (before or after) of the reference date


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
