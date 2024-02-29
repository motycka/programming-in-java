package lesson09.generics;

public class GenericsExample {

    public static void main(String[] args) {
        MyClass<String> myClass1 = new MyClass<>("ABC");
        System.out.println(myClass1.getId());

        MyClass<Integer> myClass2 = new MyClass<>(123);
        System.out.println(myClass2.getId());

        MyClassEnhanced<Integer, Double> myClassEnhanced = new MyClassEnhanced<>();
        System.out.println(myClassEnhanced.equals(123, 123.0));
    }

    static class MyClass<T> {

        private final T id;

        public MyClass(T id) {
            this.id = id;
        }

        public T getId() {
            return id;
        }

    }

    static class MyClassEnhanced<T1, T2> {

        public Boolean equals(T1 value1, T2 value2) {
            return value1 == value2;
        }

    }

}







