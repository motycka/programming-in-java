package com.harbourspace.lesson10;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.StringJoiner;

public class ReflectionJsonSerializer {

    public static String serialize(Object object) throws IllegalAccessException {
        Class<?> objClass = object.getClass();
        Field[] fields = objClass.getDeclaredFields();
        StringJoiner json = new StringJoiner(",", "{", "}");

        for (Field field : fields) {
            field.setAccessible(true); // Make the field accessible if it is private
            Object value = field.get(object);
            if (value != null) {
                String jsonValue = value instanceof String || value instanceof LocalDate ? "\"" + value + "\"" : value.toString();
                json.add("\"" + field.getName() + "\":" + jsonValue);
            }
        }

        return json.toString();
    }
}

