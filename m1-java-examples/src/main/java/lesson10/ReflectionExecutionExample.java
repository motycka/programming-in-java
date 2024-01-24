package lesson10;


import lesson02.UniversityCourse;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;

public class ReflectionExecutionExample {

    public static void main(String[] args) {

        try {
            // get class by fully qualified name
            var cls = Class.forName("lesson02.UniversityCourse");

            // create instance
            var instance = cls
                    .getDeclaredConstructor(String.class, LocalDate.class, int.class)
                    .newInstance("Java", LocalDate.of(2024, 3, 19), 15);

            // get method
            var getterMethod = cls.getDeclaredMethod("getSubject");

            // invoke the method on existing instance
            var getterValue = getterMethod.invoke(instance);

            // should print Java
            System.out.println(getterValue);

            var setterMethod = cls.getDeclaredMethod("setSubject", String.class);
            var noReturnValue = setterMethod.invoke(instance, "Python");

            // should print null
            System.out.println(noReturnValue);

            // should print Python
            System.out.println(getterMethod.invoke(instance));

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException |
                ClassNotFoundException | InstantiationException e) {
            // reflection may throw multiple types of exceptions
            System.out.println("Error: " + e.getMessage());
        }
    }

}
