package lesson01;

public class PrimitiveDataTypesExample {

    public static void main(String[] args) {

        boolean isTruthy = true;
        byte index = 127;
        short smallNumber = 32767;
        int number = 2147483647;
        long bigNumber = 9223372036854775807L; // notice L at the end
        float decimalNumber = 123.12346f; // notice f at the end
        double preciseNumber = 123.12345886230469;
        char character = 'a';

        System.out.println("boolean: " + isTruthy);
        System.out.println("byte: " + index);
        System.out.println("short: " + smallNumber);
        System.out.println("int: " + number);
        System.out.println("long: " + bigNumber);
        System.out.println("float: " + decimalNumber);
        System.out.println("double: " + preciseNumber);
        System.out.println("char: " + character);

    }

}
