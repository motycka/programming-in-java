package com.motycka.java.practice.lesson1;

import java.sql.Array;

public class Lesson01 {

    public static void main(String[] args) {

        short windSensor = 773;

        int windDirection = (windSensor & 0xFF00) >> 8;
        // 00000011 00000101 = 773
        // 11111111 00000000 = 0xFF00 (65280)
        // -----------------
        // 00000011 00000000 = 768 >> 8 -> 00000011 = 3

        int windSpeed = windSensor & 0x00FF;
        // 00000011 00000101 = 773
        // 00000000 11111111 = 0x00FF (255)
        // -----------------
        // 00000000 00000111 = 5

        System.out.println("Wind Direction: " + windDirection);
        System.out.println("Wind Speed: " + windSpeed);


    }
}
