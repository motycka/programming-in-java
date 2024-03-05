package com.harbourspace.lesson07;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

public interface DataReader {

    Collection<City> readAll(Path path) throws IOException;
}


