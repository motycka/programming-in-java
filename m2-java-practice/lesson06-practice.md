# Practice: Lesson 6

_java.Math, java.Time, java.util.Optional_

---
## Task 1: java.Math

Create a program that will generate random number based on the user input. 
To complete this task, try to use as many methods from the **java.Math** class as possible.

The program should have the following signature:
 - **double min** - minimum value of the random number
 - **double max** - maximum value of the random number
 - **int decimalPlaces** - number of decimal places the random number should be rounded to
 - returns **double** - random number between min and max, rounded to decimalPlaces

**Don't forget to create unit tests for your solution!**
Make sure you cover validation of inputs. 

### Hint 1
Random numbers can also be negative.

### Hint 2
To round a number to certain decimal places, you can use formula `round(r * 10^d) / 10^d`, 
where `r` is the number and `d` is the number of decimal places.

---
## Task 2: BigDecimal

Create a program that will calculate the area of a circle based on the user input.
The program should have the following signature:
 - **BigDecimal radius** - radius of the circle
 - **int decimalPlaces** - number of decimal places the area should be rounded to
 - returns **BigDecimal** - area of the circle, rounded to decimalPlaces

---
## Task 3: java.util.Optional

Create a program that will take a text and find if there are any occurrences of a given word in it.
The program should have the following signature: 

`Optional<String> getWord(String text, String word)`

If the word is found, return the word. If the word is not found, return an empty Optional.

Based on the Optional return value, print the following to the console:
 - If present, print `"Word found: " + word`.
 - If not present, print `"Word not found: " + word`.

For simplicity, match the word exactly as it is in the text (case-sensitive).

---
## Task 4: java.Time

1. Create a program that will get current date and time as ZonedDateTime (at local time zone). 
2. Print out the zone and zone offset.
3. From the date and time, get the same instant, but in different time zone. You may choose any time zones you like. Here are some ideas:
 - `ZoneId.of("Asia/Tokyo")`
 - `ZoneId.of("Europe/Prague")`
 - `ZoneId.of("Europe/London")`
 - `ZoneId.of("America/New_York")`
 - `ZoneId.of("America/Los_Angeles")`
 - `ZoneId.of("UTC")`
4. Print out the zone id and zone offset for this new time zone.
5. Calculate the time difference between the local time zone and the other time zone.

---
## Task 5: Homework

You are given a class `MeteoData` that represents a single measurement of temperature, humidity and precipitation.

I have provided some data for you in a static class constant `SampleMeteoData.DATA`.
It contains as list of temperature, humidity and precipitation measurements for a certain period of time.
The data is stored in MeteoData objects, which have a timestamp, temperature, humidity and precipitation fields.
The time is always provided in **UTC** time zone.

**Your job is to write a program that returns daily average for temperature and humidity, and daily sum of precipitation.**
This means you will need to find all measurements for a given day, calculate average temperature and humidity and sum of precipitation for that day.

The daily statistics should be calculated for a time zone that is given at the program input, 
so for example if you want to return statistics for Bangkok, you need to calculate statistics based on **UTC+7**, 
which is **Asia/Bangkok** zone ID.

Your program accept List<MeteoData> and it can also return the results as collection of MeteoData.

It would be good to make sure that the results data are returned sorted by date, ascending. 
It should also not contain duplicates.

### Hint 1
You may need to truncate individual times to same date, you can use `yourTime.truncatedTo(ChronoUnit.DAYS)` method to do so.

### Hint 2
**Stream API** could be useful. Look at **collect** method and collectors, for example `Collectors.summarizingDouble(MeteoData::temperature)`
This method returns `DoubleSummaryStatistics` which has some useful methods, such as `getAverage()` or `getSum()`

### Hint 3
In order to adjust timezone on the **MeteoData** object, you will need to create a new instance of it. 
Perhaps you could implement a method in the **MeteoData** class that would copy itself with new time?

### Hint 4
Remember that certain types of collections cannot contain duplicates and are sorted either by natural order or by comparator.
I have implemented the **Comparable** interface on **MeteoData** class for you. Have a look at it and see if it could be useful.
