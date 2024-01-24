package com.harbourspace.lesson07;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class CsvDataLoader implements DataLoader, DataWriter {

    @Override
    public List<City> readAll(Path path) throws IOException {
        return Files.readAllLines(path)
                .stream()
                .skip(1)
                .map(line -> {
                    String[] columns = line.split("\\|");
                    return new City(
                            columns[1],
                            columns[4],
                            columns[9].isBlank() ? 0 : Math.round(Double.parseDouble(columns[9]))
                    );
                }).toList();
    }

    @Override
    public void writeAll(List<City> cities, Path path) {

            try {

                if (!Files.exists(path)) {
                    Files.createFile(path);
                }

//                Files.write(path);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }

}
