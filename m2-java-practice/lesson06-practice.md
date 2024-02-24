# Homework: Lesson 6

There is a file called `worldcities.csv` in the resources folder. This file contains a list of cities and their population.
The file is in CSV format, which means that each line contains a city name and its population separated by a comma | character,
where first line is a header.

Here is an example of the file content:

```
city|city_ascii|lat|lng|country|iso2|iso3|admin_name|capital|population|id
Tokyo|Tokyo|35.6897|139.6922|Japan|JP|JPN|Tōkyō|primary|37732000|1392685764
```

## Code

Your task it to write a program, that reads contents of the file and parse each line into an instance of class that 
you will create. The class should have at minimum these fields:
 - city name
 - country name
 - city population


The program should then take all the data in the file and order it by population in descending order. 

Finally, the program should write the sorted data to a new file called `worldcities-sorted.csv`.

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

## Testing

Write tests as part of your assignment. 
I encourage you to design the code in a way, that makes each part of the program testable separately.

For example, reading loading the file, parsing the data and sorting the data a separately testable unit. 
