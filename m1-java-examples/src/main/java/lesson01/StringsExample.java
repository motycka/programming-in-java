package lesson01;

public class StringsExample {

    public static void main(String[] args) {

        System.out.println("Printing to console with new line at the end");

        System.out.print("Printing to console without new line at the end");
        System.out.println(); // just new line

        String name = "Moni";
        String greeting = "Hello " + name + "!"; // String concatenation
        System.out.println(greeting);

        String greeting2 = "Hola";
        greeting2 += " " + name + "!"; // Assignment addition String concatenation
        System.out.println(greeting2);

        String hello = "Hello";
        String formattedGreeting = String.format("%s %s!", hello, name); // String formatting
        System.out.println(formattedGreeting);

        String fullGreeting = hello.concat(" ").concat(name); // String concatenation
        System.out.println(fullGreeting);

        String[] words = {"Greetings", "Monika"};
        String joinedWords = String.join(" ", words).concat("!"); // Joining strings
        System.out.println(joinedWords);



        String text = "Banana, Apple, Orange, Kiwi, Mango, Pineapple, Watermelon, Strawberry";

        System.out.println("Length: " + text.length());

        String[] fruits = text.split(",");
        for (String fruit : fruits) {
            System.out.println(fruit.trim()); // trim to remove leading ot trailing space
        }

        System.out.println("Has apple: " + text.contains("Apple"));

        System.out.println(text.toUpperCase());

        System.out.println(text.toLowerCase());

        System.out.println(text.substring(10, 20));

        String newText = text.replace("Apple", "Peach");
        System.out.println(newText);
    }

}
