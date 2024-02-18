package lesson07.io;

import lesson07.file.FileExample;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample {

    private static final String PATH = "timezone-cities.txt";

    public static void main(String[] args) {

        // optionally, create StringBuilder to append the content of the file
        StringBuilder fileContent = new StringBuilder();

        // defining input stream as part of try-with-resources
        try(InputStream inputStream = FileExample.class.getClassLoader().getResourceAsStream(PATH)) {

            if (inputStream == null) {
                System.out.println("File not found!");

            } else {
                // reading the input stream byte by byte
                int data = inputStream.read();
                while(data != -1) {
                    data = inputStream.read();

                    // print the content of the file
                    System.out.print((char) data);

                    // or we can use StringBuilder to append the content of the file
                    fileContent.append((char) data);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // we don't need a finally block, because try-with-resources will close the input stream for us

        System.out.println(fileContent);
    }

}
