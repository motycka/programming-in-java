package com.harbourspace.lesson07;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface DataLoader {
    List<City> readAll(Path path) throws IOException;
}


