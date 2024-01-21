package com.motycka.java.practice.lesson2;

/*
   - Objects and classes
   - Functions / methods, lambda
   - Access modifiers
   - Errors and exception handling
 */
public class Lesson02BasicClasses {


    public static void main(String[] args) {
        /*
        Create s class called City with one string property holding city name.
        Instantiate the class in the main function, then print city name to the console.
         */
        City1 city = new City1();
        System.out.println(city.name);

        /*
        Enhance the SimpleCity class. Make property name private and final, so that it cannot be updated after instantiation.
        Add constructor to initialize the city name.
        Create a getter for the name property
        Again, instantiate the class and print city name.
         */
        City2 namedCity = new City2("Bangkok");
        System.out.println(namedCity.getName());


        /*
        Enhance the SimpleCity class.
        Add two new private properties, one for country name and one for population.

        Update the primary constructor to instantiate the class all 3 parameters

        Add a secondary constructor to instantiate the class with just name and country and leave the population at null.

        Create getters for the name and country properties
        Create getter and setter for the population

        Instantiate two cities, using each of the constructors and print city name, country and population.

        Use the setter to update each city population.

        Once you are done, discuss the solution with lector.

         */

        City3 bangkok = new City3("Bangkok", "Thailang", 8280925);
        City3 prague = new City3("Prague", "Czechia");

        System.out.println("City of " + bangkok.getName() + " lies in " + bangkok.getCountry() + " and has population of " + bangkok.getPopulation() + " people");
        System.out.println("City of " + prague.getName() + " lies in " + prague.getCountry() + " and has population of " + prague.getPopulation() + " people");
        prague.setPopulation(1357326L);
        System.out.println("City of " + prague.getName() + " lies in " + prague.getCountry() + " and has population of " + prague.getPopulation() + " people");

        /*
        Create a new package called **model** -> `cz.motyka.practice.lesson2.model`
        Move the City class to this package.

        What happened? Why? How to fix it?
         */


        /*
        All the clases we created are examples of data classes - classes that are intended to hold data to be passed between programs.
        Since Java 14, there is a better way to write such type of classes.

        Try using `record` instead of `class`:
        ```
        record CityRecord(String name, String country, Long population) {

        }
        ```

         */
        CityRecord barcelona = new CityRecord("Barcelona", "Spain", 	1636193L);
        System.out.println("City of " + barcelona.name() + " lies in " + barcelona.country() + " and has population of " + barcelona.population() + " people");

    }
}

class City1 {
    String name = "Bangkok";
}

class City2 {

    private final String name;

    City2(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

class City3 {

    private final String name;
    private final String country;
    private Long population = null;

    City3(String name, String country, long population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    City3(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

}

record CityRecord(String name, String country, Long population) {

}
