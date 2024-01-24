package lesson06.math;

public class MathExample {

    public static void main(String[] args) {

        double a = 3.14;
        double b = -3.14;

        double abs = Math.abs(b);
        System.out.println("Absolute value of " + b + " is " + abs);

        double max = Math.max(a, b);
        System.out.println("Max value of " + a + "and " + b + " is " + max);

        double min = Math.min(a, b);
        System.out.println("Min value of " + a + "and " + b + " is " + min);

        double pow = Math.pow(2, 3);
        System.out.println("2 to the power of 3 is " + pow);

        double sqrt = Math.sqrt(16);
        System.out.println("Square root of 16 is " + sqrt);

        double random = Math.random();
        System.out.println("Random number between 0 and 1 is " + random);

    }

}
