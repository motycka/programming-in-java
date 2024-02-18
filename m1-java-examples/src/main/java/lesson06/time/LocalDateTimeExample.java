package lesson06.time;

import java.time.*;

public class LocalDateTimeExample {

    public static void main(String[] args) {

        LocalDateTime dateTimeNow = LocalDateTime.now();
        System.out.println("Local date time now: " + dateTimeNow); // prints local date and time, for example 2024-01-14T08:08:44.548746

        int year = dateTimeNow.getYear();
        Month month = dateTimeNow.getMonth();
        int monthValue = dateTimeNow.getMonthValue();
        DayOfWeek dayOfWeek = dateTimeNow.getDayOfWeek();
        int day = dateTimeNow.getDayOfMonth();
        int hour = dateTimeNow.getHour();
        int minute = dateTimeNow.getMinute();
        int second = dateTimeNow.getSecond();

        System.out.println("Year: " + year);
        System.out.println("Month: " + month);
        System.out.println("Month value: " + monthValue);
        System.out.println("Day of week: " + dayOfWeek);
        System.out.println("Day: " + day);
        System.out.println("Hour: " + hour);
        System.out.println("Minute: " + minute);
        System.out.println("Second: " + second);

        LocalDateTime dateTime = LocalDateTime.parse("2024-01-14T08:08:44.548746");
        System.out.println("Parsed date time: " + dateTime);

        LocalDate dateNow = LocalDate.now();
        LocalDateTime dateTimeNow1 = dateNow.atTime(LocalTime.now());
        LocalDateTime dateTimeNow2 = dateNow.atTime(LocalTime.parse("08:08:44"));
        System.out.println("Local date time now (1): " + dateTimeNow1);
        System.out.println("Local date time now (2): " + dateTimeNow2);
    }
}
