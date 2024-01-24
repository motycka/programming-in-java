package lesson04.polymorphism.compiletime;

public class CompileTimePolymorphismExample {
    public static void main(String[] args) {
        Calculate obj = new Calculate();
        System.out.println(obj.add(10, 20));      // prints 30
        System.out.println(obj.add(10, 20, 30));  // prints 60
    }
}

class Calculate {
    // method with 2 parameters
    int add(int a, int b) {
        return a + b;
    }

    // overloaded method with 3 parameters
    int add(int a, int b, int c) {
        return a + b + c;
    }
}


