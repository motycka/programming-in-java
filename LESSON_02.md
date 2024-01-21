# Introduction to development in Java


## Practice 1: Classes

### Exercise 1

1. Create a new package in the `src/main/java` path called `com.harbourspace.java.practice.lesson2`
2. In this package, create a class called `City` with one String attribute holding city name.
3. Create a class with `main` function and instantiate the new 
4. Instantiate the class in the main function, then print city name to the console.

```java
class City {
    String name = "Bangkok";
}

public class Lesson02 {
    
    public static void main(String[] args) {
        City city = new City();
        System.out.println(city.name);
    }
    
}


```

### Exercise 2

1. Enhance the City class - make the `name` attribute private and final, so that it cannot be updated after instantiation.
2. Add constructor to initialize the city name.
3. Create a getter for the name attribute.
4. Again, instantiate the class and print city name.

```java

class City {

    private final String name;

    City(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
}

public class Lesson02 {

    public static void main(String[] args) {
        City city = new City("Bangkok");
        System.out.println(city.getName());
    }
    
}
```

### Exercise 3
Enhance the SimpleCity class.
Add two new private properties, one for country name and one for population.

Update the primary constructor to instantiate the class all 3 parameters

Add a secondary constructor to instantiate the class with just name and country and leave the population at null.

Create getters for the name and country properties
Create getter and setter for the population

Instantiate two cities, using each of the constructors and print city name, country and population.

Use the setter to update each city population.

Once you are done, discuss the solution with lector.

### Exercise 4
Create a new package called **model** -> `cz.motyka.practice.lesson2.model`
Move the City class to this package.

What happened? Why? How to fix it?


### Exercise 5 
All the clases we created are examples of data classes - classes that are intended to hold data to be passed between programs.      
Since Java 14, there is a better way to write such type of classes.

Try using `record` instead of `class`:


### Exercise 5
Inner classes, static classes



## Practice 2: Methods

## Practice 3: Exceptions









## Exercise 2

Implement a class that represents a City. The class should have the following `private` properties:
 - city name
 - country name
 - if the city is a capital city
 - city population
 - city area
 - country population

Implement a primary constructor for the class that sets values of all the properties.
Implement a secondary constructor ... TODO

Implement a `public` getter and setter for each of the class properties.

Create a new instance of the class from your Main class and assign it to a variable.

## Exercise 3

Extend your class with a method that will calculate city population density and return it as whole number.


Create a static method for printing ....


## Exercise 4

Working with strings

Create second instance and assign it to another variable.

Do some comparisons.
