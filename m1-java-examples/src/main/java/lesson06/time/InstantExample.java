package lesson06.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class InstantExample {

    public static void main(String[] args) {
        Instant instantNow = Instant.now();
        System.out.println(instantNow); // 2024-01-14T09:01:00.878577Z

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime); // 2024-01-14T10:01:00.896618

        ZoneId zone = ZoneId.of("Asia/Bangkok");
        ZoneOffset zoneOffset = zone.getRules().getOffset(localDateTime);

        Instant instant = localDateTime.toInstant(zoneOffset);
        System.out.println(instant); // 2024-01-14T03:01:00.896618Z

        // Or you can use hard-coded offset, which will however possibly not reflect daylight saving time.
        System.out.println(localDateTime.toInstant(ZoneOffset.ofHours(6))); // 2024-01-14T04:01:00.896618Z

    }
}
