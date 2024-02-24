package com.harbourspace.lesson07;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;

/*
Parse cities
sort them by size, write 10 biggest cities
group them by country, write 5 biggest by country


 */
public class Main {

    private static final CsvDataLoader loader = new CsvDataLoader();
    private static final String INPUT = "/worldcities.csv";

    public static void main(String[] args) {
        var fileUrl = Main.class.getResource(INPUT);

        try {

            if (fileUrl == null) {
                throw new RuntimeException("File not found");
            } else {

                var cities = loader.readAll(Path.of(fileUrl.toURI())); // TODO
                var cityStatistics = new CityStatistics(cities);

                loader.writeAll(cityStatistics.getTopWorldCities(10), Path.of("output.csv"));

//                System.out.println("Countries by number of cities:");
//                cityStatistics.getCountriesByNumberOfCities()
//                        .forEach((country, numberOfCities) -> {
//                            System.out.println(country + " - " + numberOfCities);
//                        });
//
//                // Top 5 cities from top 5 countries
//
//                // TODO extract to methods, we will be testing this

            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
