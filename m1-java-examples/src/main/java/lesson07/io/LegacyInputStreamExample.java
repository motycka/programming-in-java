package lesson07.io;

import lesson07.file.FileExample;

import java.io.IOException;
import java.io.InputStream;

public class LegacyInputStreamExample {

    private static final String PATH = "timezone-cities.txt";

    public static void main(String[] args) {

        // create null input stream
        InputStream inputStream = null;

        // optionally, create StringBuilder to append the content of the file
        StringBuilder fileContent = new StringBuilder();

        try {
            // using class loader anf getResourceAsStream to get resource as input stream
            inputStream = FileExample.class.getClassLoader().getResourceAsStream(PATH);

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
        } finally {
            if (inputStream != null) {
                try {
                    // close the input stream in finally block, this is IMPORTANT!
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println("Error closing the input stream!");
                }
            }
        }

        // this will print the content of the file we appended using the StringBuilder
        System.out.println(fileContent);
    }

}
