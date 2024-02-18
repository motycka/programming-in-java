package lesson07.path;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Objects;

public class PathExample {

    public static void main(String[] args) {
        stringPathExample();
        uriPathExample();
    }

    private static void stringPathExample() {
        // These paths would probably would not work if run outside the IDE.
        String resourcesPath = "m1-java-basics/src/main/resources";
        String fileName = "timezone-cities.txt";

        // Path object resolved from the string(s)
        Path path = Path.of(resourcesPath, fileName);

        System.out.println("URI: " + path.toUri());
        System.out.println("File name: " + path.getFileName());
        System.out.println("File system: " + path.getFileSystem());
        System.out.println("Parent: " + path.getParent());
        System.out.println("Root: " + path.getRoot());
    }

    private static void uriPathExample() {
        try {
            // URI is a uniform resource identifier
            URI uri = Objects.requireNonNull(PathExample.class.getResource("timezone-cities.txt")).toURI();

            // Path object resolved from the URI
            Path path = Path.of(uri);

            System.out.println("URI: " + path.toUri());
            System.out.println("File name: " + path.getFileName());
            System.out.println("File system: " + path.getFileSystem());
            System.out.println("Parent: " + path.getParent());
            System.out.println("Root: " + path.getRoot());

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}
