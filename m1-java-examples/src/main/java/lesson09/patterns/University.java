package lesson09.patterns;

public class University {
    // Create private instance of class
    private static University singletonInstance = null;

    // Make constructor as private
    private University() {}

    // Only method to get instance of Singleton
    public static University getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new University();
        }
        return singletonInstance;
    }
}
