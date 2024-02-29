package lesson09.functional;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {

        Integer result = execute("Hello Function!", (input) -> {
            System.out.println("Got input: " + input);
            return input.length();
        });

        System.out.println(result);

    }

    private static Integer execute(String input, MyFunctionalInterface function) {
        return function.execute(input);
    }

    @FunctionalInterface
    interface MyFunctionalInterface {
        Integer execute(String input);
    }
}
