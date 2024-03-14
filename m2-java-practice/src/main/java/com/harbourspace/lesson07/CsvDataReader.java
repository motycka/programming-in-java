package com.harbourspace.lesson07;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CsvDataReader implements DataReader {
    @Override
    public Collection<City> readAll(Path path) throws IOException {
        List<City> cities = new ArrayList<>();
        List<String> lines = Files.readAllLines(path);

        for (String line : lines.subList(1, lines.size())) {
            String[] parts = line.split("\\|");
            String cityName = parts[0];
            String countryName = parts[4];
            long population = Long.parseLong(parts[9]);

            cities.add(new City(cityName, countryName, population));
        }

        return cities;
    }
}
