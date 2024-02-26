package com.harbourspace.lesson07;

import java.nio.file.Path;
import java.util.List;

public interface DataWriter {
    void writeAll(List<City> cities, Path path);
}
