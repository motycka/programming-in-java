package com.harbourspace.lesson06;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.Duration;

public class ZonedDateTimeTask {

    public static void main(String[] args) {
        // Get current date and time in system's default time zone
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("Current Zone: " + now.getZone() + " | Zone Offset: " + now.getOffset());

        // Convert to a different time zone
        ZonedDateTime tokyoTime = now.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println("Tokyo Zone: " + tokyoTime.getZone() + " | Zone Offset: " + tokyoTime.getOffset());

        // Calculate the time difference
        Duration duration = Duration.between(now.toLocalTime(), tokyoTime.toLocalTime());
        long hoursDifference = duration.toHours();
        System.out.println("Time difference between local time and Tokyo: " + hoursDifference + " hours");

    }
}
