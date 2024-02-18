package lesson06.time;

import java.time.Duration;
import java.time.ZonedDateTime;

public class DurationExample {

    public static void main(String[] args) {

        ZonedDateTime from = ZonedDateTime.parse("2024-01-14T09:44:26.147022+01:00[Europe/Prague]");
        ZonedDateTime to = ZonedDateTime.now();

        Duration duration = Duration.between(from, to);

        System.out.println(duration);
        System.out.println(duration.getSeconds());
        System.out.println(duration.getNano());
    }

}
