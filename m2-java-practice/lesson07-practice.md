# Practice: Lesson 7

_Working with files_

---

There is a file called `world-cities.csv` in the `src/main/resources`. This file contains a list of cities, country, their population and other data.
The file is in CSV-like format, where each value is separated by a | (pipe) character, and first line is a header.
(The reason there is | character and not , is because the city names may contain commas.)

Here is an example of the file content:

```
city|city_ascii|lat|lng|country|iso2|iso3|admin_name|capital|population|id
Tokyo|Tokyo|35.6897|139.6922|Japan|JP|JPN|Tōkyō|primary|37732000|1392685764
```

## Task

Your task is to write a program that filters and sorts the data in the file by given criteria and writes the results into another file.

The program should consist of these parts:
 - Reading the file
 - Sorting the data
 - Writing the sorted data to a new file(s)

### Reading the file

You need to read at minimum the following data from the file:
 - city name
 - country name
 - city population

Implement this functionality by implementing the `DataReader` interface I have provided for you.
The program should return the data as a collection of `City` class.

### Sorting the data

The program needs to be able to filter data by country and sort by populations.

Implement this functionality by implementing the `Statistics` interface I have provided for you.

### Writing the sorted data to a new file

Implement writing the data by implementing the `DataWriter` interface I have provided for you.

For each type of statistic, write a separate file with the data sorted by the given criteria.

I leave it up to you to decide what country data to write.


### Tip
To make comparing of the cities easier, you can implement the `Comparable` interface on the city class.

```
public class City implements Comparable<City> {
    
    // your code

    @Override
    public int compareTo(City other) {
        return Long.compare(other.population, this.population);
    }
}
```

### Testing

Write tests as part of your assignment.
I encourage you to design the code in a way, that makes each part of the program testable separately.
Using interfaces will help you with that.

For example, reading loading the file, parsing the data and sorting the data a separately testable unit. 

To be able to test the reader, you might need to create a test file in `src/test/resources`.
