package com.motycka.java.practice.lesson1;

/*

Comparison and conditionals

 */
public class Lesson01ConditionalsExample {

    public static void main(String[] args) {

        long temperature = 33;
        String pants = null;

        if (temperature > 20) {
            pants = "Short";
        } else {
            pants = "Long";
        }

        String pants2 = temperature > 20 ? "Short" : "Long";


        if (temperature > 20) pants = "Short"; else pants = "Long";


    }
}
