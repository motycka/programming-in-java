package lesson07.file;

import java.io.File;
import java.io.IOException;

public class NewFileExample {

    public static void main(String[] args) {
        try {
            File directory = createDirectoryIfNotExists("data"); // relative path
            File file = createFileIfNotExists("new-file.txt");

            file.renameTo(new File("renamed-file.txt"));
            file.delete();
            directory.delete();

        } catch (IOException | IllegalStateException e) {
            throw new RuntimeException(e); // handle exceptions that could have been thrown
        }
    }

    private static File createFileIfNotExists(String path) throws IOException {
        File file = new File(path);

        if (file.exists()) {
            System.out.println("File already exists: " + file.getAbsolutePath());
        } else {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getAbsolutePath());
            }
        }

        return file;
    }

    private static File createDirectoryIfNotExists(String path) throws IllegalStateException {
        File directory = new File(path);

        if (directory.exists()) {
            System.out.println("Directory already exists: " + directory.getAbsolutePath());
        } else {
            if (directory.mkdir()) {
                System.out.println("Directory created: " + directory.getAbsolutePath());
            } else {
                throw new IllegalStateException("Directory not created: " + directory.getAbsolutePath());
            }
        }

        return directory;
    }

}
