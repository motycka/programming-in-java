package lesson10;


import lesson02.UniversityCourse;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Arrays;

public class ReflectionInspectionExample {

    private static final UniversityCourse object = new UniversityCourse(
            "Java",
            LocalDate.of(2024, 3, 19),
            15
    );

    public static void main(String[] args) {

        var cls = object.getClass();

        // Inspect class
        System.out.println("Class: ");
        System.out.println(" Name = " + cls.getName());
        System.out.println(" Simple Name = " + cls.getSimpleName());
        System.out.println(" Package = " + cls.getPackage());
        System.out.println(" Superclass = " + cls.getSuperclass());
        System.out.println(" Interfaces = " + Arrays.toString(cls.getInterfaces()));

        // Inspect constructors
        var constructors = cls.getConstructors();
        System.out.println("Constructors: ");
        for (var constructor : constructors) {
            System.out.println(" Parameters = " + Arrays.toString(constructor.getParameterTypes()));
        }

        // Inspect methods
        Method[] methods = cls.getMethods();
        System.out.println("Methods: ");
        for (Method method : methods) {
            System.out.println(" Method = " + method.getName());
            System.out.println(" Parameters = " + Arrays.toString(method.getParameterTypes()));
        }

        // Inspect fields
        Field[] fields = object.getClass().getDeclaredFields();
        System.out.println("Fields: ");
        for (Field field : fields) {
            System.out.println(" Field = " + field.getName());
            System.out.println(" Type = " + field.getAnnotatedType());
        }
    }
}
