package com.motycka.java.practice.lesson2;

import java.time.*;

public class JavaTimePlayground {

    public static void main(String[] args) {


        ZonedDateTime from = ZonedDateTime.parse("2024-01-14T09:44:26.147022+01:00[Europe/Prague]");
        ZonedDateTime to = ZonedDateTime.now();

        Duration duration = Duration.between(from, to);

        System.out.println(duration); // PT21M15.740325S
        System.out.println(duration.getSeconds()); //1275
        System.out.println(duration.getNano()); // 740325000

    }
}
