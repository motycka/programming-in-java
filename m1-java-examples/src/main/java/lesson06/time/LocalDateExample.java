package lesson06.time;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class LocalDateExample {

    public static void main(String[] args) {
        createLocalDateExample();
        shiftLocalDateExample(LocalDate.now(), 3);
        localDatePartsExample(LocalDate.now());
        localDateComparisonExample();
    }

    private static void createLocalDateExample() {
        LocalDate dateNow = LocalDate.now();
        System.out.println("Today: " + dateNow);

        LocalDate date1 = LocalDate.of(2024, 2, 20);
        System.out.println("Date: " + date1);

        LocalDate date2 = LocalDate.parse("2024-02-20");
        System.out.println("Date: " + date2);
    }

    private static void shiftLocalDateExample(LocalDate date, int shift) {

        LocalDate yesterday = date.minusDays(shift);
        LocalDate lastMonth = date.minusMonths(shift);
        LocalDate lastYear = date.minusYears(shift);

        System.out.println("Yesterday: " + yesterday);
        System.out.println("Last month: " + lastMonth);
        System.out.println("Last year: " + lastYear);

        LocalDate tomorrow = date.plusDays(shift);
        LocalDate nextMonthDate = date.plusMonths(shift);
        LocalDate nextYear = date.plusYears(shift);

        System.out.println("Tomorrow: " + tomorrow);
        System.out.println("Next month: " + nextMonthDate);
        System.out.println("Next year: " + nextYear);
    }

    private static void localDatePartsExample(LocalDate date) {

        // get parts of the date
        int dayOfYear = date.getDayOfYear();
        int dayOfMonth = date.getDayOfMonth();
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        // or even leap year
        boolean leapYear = date.isLeapYear();

        System.out.println("Day of year: " + dayOfYear);
        System.out.println("Day of month: " + dayOfMonth);
        System.out.println("Day of week: " + dayOfWeek);
        System.out.println("Is leap year: " + leapYear);
    }

    private static void localDateComparisonExample() {
        LocalDate now = LocalDate.now();

        boolean isBefore = now.isBefore(LocalDate.parse("2024-03-08"));
        boolean isAfter = now.isAfter(LocalDate.parse("2024-02-19"));
        boolean isEqual = now.isEqual(LocalDate.parse("2024-02-20"));

        System.out.println(now + " is before 2024-03-08: " + isBefore);
        System.out.println(now + " is after 2024-02-19: " + isAfter);
        System.out.println(now + " is equal to 2024-02-20: " + isEqual);
    }
}
