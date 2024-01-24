package lesson06.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeExample {

    public static void main(String[] args) {

        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
        System.out.println(zonedDateTimeNow); // 2024-01-14T09:44:26.147022+01:00[Europe/Prague]
        System.out.println(zonedDateTimeNow.toLocalDateTime()); // 2024-01-14T09:44:26.147022

        // Convert LocalDateTime to ZonedDateTime
        ZonedDateTime zonedDateTime = LocalDateTime.now().atZone(ZoneId.of("Asia/Bangkok"));
        System.out.println(zonedDateTime); // 2024-01-14T09:44:26.150263+07:00[Asia/Bangkok]

        // Convert between zones using instant
        System.out.println(zonedDateTimeNow); // 2024-01-14T09:44:26.147022+01:00[Europe/Prague]

        ZonedDateTime zonedDateTime2 = zonedDateTimeNow.withZoneSameInstant(ZoneId.of("Asia/Bangkok"));
        System.out.println(zonedDateTime2); // 2024-01-14T15:44:26.147022+07:00[Asia/Bangkok]

    }
}
