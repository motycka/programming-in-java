package lesson09.functional;

public class PureFunctionExample {

    private static int counter = 0;

    public static int unPureFunction(int increment) {
        return counter += increment;
    }

    public static int pureFunction(int counter, int increment) {
        return counter + increment;
    }

}
