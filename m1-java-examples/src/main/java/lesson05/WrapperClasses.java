package lesson05;

public class WrapperClasses {

    public static void main(String[] args) {

        /*
        Convert primitive to object and vice versa
         */
        byte bytePrimitive = 127;
        Byte byteObject = bytePrimitive; // auto-boxing

        System.out.println("Primitive byte: " + bytePrimitive);
        System.out.println("Object Byte: " + byteObject);

        Integer intObject = 2147483647;
        int intPrimitive = intObject; // auto-unboxing

        System.out.println("Object Integer: " + intObject);
        System.out.println("Primitive int: " + intPrimitive);

        /*
        Claim: wrapper classes are objects
        */
        Integer number = 42;

        if (number instanceof Object) {
            System.out.println("number is Object"); // will print this
        } else {
            System.out.println("number is primitive");
        }

        /*
         Claim: wrapper classes are immutable
         */
        Long longNumber = 42L; // this is in fact object instantiation equivalent to calling `new Long(42)`;
        System.out.println("Long address: " + System.identityHashCode(longNumber));
        // memory address, something like 2120828836

        longNumber = 24L; // and this is actually equivalent to `number = new Long(24)`
        System.out.println("Long address: " + System.identityHashCode(longNumber));
        // the memory address has changed, proving it is a new object


        /*
        Member functions of wrapper classes
         */
        Integer i = 10;
        int x = Integer.parseInt("10");
        System.out.println("x is int: " + (x == 10)); // prints true

        String str = Double.toString(12.34);
        System.out.println("str is String: " + (str.equals("12.34"))); // prints true

        int max = Integer.max(5, 10);
        int min = Integer.min(5, 10);
        System.out.println("min: " + min); // prints 5
        System.out.println("max: " + max); // prints 10

        int compare = Integer.compare(5, 10);
        System.out.println("compare: " + compare); // prints -1
    }
}
