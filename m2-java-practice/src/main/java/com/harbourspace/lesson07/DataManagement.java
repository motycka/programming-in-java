package com.harbourspace.lesson07;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;



public class DataManagement {
    public static void main(String[] args) throws IOException {
        String inputFilePath = "src/main/resources/world-cities.csv";
        String outputFilePath = "src/main/resources/sorted-cities.csv";
        String countryFilter = "Japan"; // Example: Filter by Japan; adjust as needed

        DataReader dataReader = new CsvDataReader();
        Collection<City> cities = dataReader.readAll(Paths.get(inputFilePath));

//        Statistics statistics = new CityStatistics();
//        List<City> filteredSortedCities = statistics.filterAndSort(cities, countryFilter);

//        DataWriter dataWriter = new CsvDataWriter();
//        dataWriter.writeData(filteredSortedCities, outputFilePath);

        System.out.println("Data processing complete. Check the output file: " + outputFilePath);
    }
}
