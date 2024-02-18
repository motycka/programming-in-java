package lesson07.file;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class FileExample {

    public static void main(String[] args) {
        try { // toURI() may throw URISyntaxException

            // get resource URL
            URL url = FileExample.class.getClassLoader().getResource("timezone-cities.txt");

            if (url == null) {
                System.out.println("File not found!");

            } else {
                // convert URL to URI
                URI uri = url.toURI();

                // create file from URI
                File file = new File(uri);

                System.out.println("File exists: " + file.exists());
                System.out.println("File path: " + file.getPath());
                System.out.println("File absolute path: " + file.getAbsolutePath());
                System.out.println("Is file: " + file.isFile());
                System.out.println("Is directory: " + file.isDirectory());
                System.out.println("Can read: " + file.canRead());
                System.out.println("Can write: " + file.canWrite());
                System.out.println("Can execute: " + file.canExecute());
                // System.out.println("Deleted?: " + file.delete());
            }

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
