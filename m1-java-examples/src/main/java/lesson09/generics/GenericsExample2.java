package lesson09.generics;

public class GenericsExample2 {

    public static void main(String[] args) {
        Sensor<String> sensor1 = new Sensor<>("ABC");
        System.out.println(sensor1.getId());

        Sensor<Integer> sensor2 = new Sensor<>(123);
        System.out.println(sensor2.getId());
    }

    static class Sensor<T> {

        private T id;

        public Sensor(T id) {
            this.id = id;
        }

        public T getId() {
            return id;
        }
    }
}







