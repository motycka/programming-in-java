package lesson07.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamExample {

    private static final String PATH = "output-stream.txt";

    public static void main(String[] args) {

        String data = "Hello, World!";

        // using try-with-resources to close the stream after we are done
        try(FileOutputStream outputStream = new FileOutputStream(PATH)) {

            // convert string to byte array
            byte[] bytesArray = data.getBytes();

            // write byte array to the file
            outputStream.write(bytesArray);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
