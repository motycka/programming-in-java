package lesson07.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermissions;

public class FilesExample {

    public static void main(String[] args) {
        Path path = Path.of("hello.txt");

        createWithAttributes();

        try {
            // delete if exists
            boolean exists = Files.deleteIfExists(path);
            System.out.println("File exists: " + exists);

            // creates the file and returns its Path (should be the same as the input path)
            // throws FileAlreadyExistsException if the file already exists
            Path newFilePath = Files.createFile(path);

            writeHello(newFilePath);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeHello(Path path) {
        try {

            // write some lines
            Files.writeString(path,  "Hello, World!\n", StandardOpenOption.APPEND);
            Files.writeString(path,  "Hello, Thailand!\n", StandardOpenOption.APPEND);
            Files.writeString(path,  "Hello, Bangkok!\n", StandardOpenOption.APPEND);

            // read the lines and print them
            Files.readAllLines(path).forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Path createWithAttributes() {
        Path path = Path.of("hello.txt");

        try {
            Files.deleteIfExists(path);

            FileAttribute<?> attrs = PosixFilePermissions.asFileAttribute(
                    PosixFilePermissions.fromString("rwxrw-rw-")
            );

            // you can create a file with attributes
            Files.createFile(path, attrs);

            // you can set file attributes later
            Files.setPosixFilePermissions(path, PosixFilePermissions.fromString("r--r--r--"));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }

}
