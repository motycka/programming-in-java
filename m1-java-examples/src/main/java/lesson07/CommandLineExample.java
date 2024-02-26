package lesson07;

import java.util.Scanner;

/*
cd /src/main/java
javac lesson07/CommandLineExample.java
java -cp . lesson07.CommandLineExample

the -cp parameter is used to specify the classpath, which is a list of directories and JAR files that contain the classes you want to run.
 */
public class CommandLineExample {

    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }

        System.out.println("What is your name?");

        // Option 1: System.console() method returns the unique Console object associated with the current Java virtual machine, if any.
        String name = System.console().readLine();

        // Option 2: The Scanner class is used to get user input, and it is found in the java.util package.
        // Scanner scanner = new Scanner(System.in);
        // String name = scanner.nextLine();

        System.out.println("Hello, " + name + "!");
    }
}
