package com.harbourspace.lesson06.homework;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class DailyMeteoStats {

    public static List<MeteoData> calculateDailyStats(List<MeteoData> data, ZoneId targetZone) {
        // Convert each MeteoData to the target time zone and truncate to days
        List<MeteoData> convertedData = data.stream()
                .map(meteoData -> new MeteoData(
                        meteoData.time().withZoneSameInstant(targetZone).truncatedTo(ChronoUnit.DAYS),
                        meteoData.temperature(),
                        meteoData.humidity(),
                        meteoData.precipitation()))
                .collect(Collectors.toList());

        // Group by date and calculate required statistics
        Map<ZonedDateTime, List<MeteoData>> groupedByDate = convertedData.stream()
                .collect(Collectors.groupingBy(MeteoData::time));

        List<MeteoData> dailyStats = new ArrayList<>();
        for (Map.Entry<ZonedDateTime, List<MeteoData>> entry : groupedByDate.entrySet()) {
            ZonedDateTime date = entry.getKey();
            List<MeteoData> dayData = entry.getValue();

            double avgTemperature = dayData.stream()
                    .collect(Collectors.averagingDouble(MeteoData::temperature));
            double avgHumidity = dayData.stream()
                    .collect(Collectors.averagingDouble(MeteoData::humidity));
            double sumPrecipitation = dayData.stream()
                    .mapToDouble(MeteoData::precipitation)
                    .sum();

            dailyStats.add(new MeteoData(date, avgTemperature, avgHumidity, sumPrecipitation));
        }

        // Sort by date
        Collections.sort(dailyStats, Comparator.comparing(MeteoData::time));
        return dailyStats;
    }

    public static void main(String[] args) {
        ZoneId bangkokZone = ZoneId.of("Asia/Bangkok");
        List<MeteoData> dailyStats = calculateDailyStats(SampleMeteoData.DATA, bangkokZone);

        dailyStats.forEach(stat -> System.out.println("Date: " + stat.time() +
                ", Avg Temp: " + stat.temperature() +
                ", Avg Humidity: " + stat.humidity() +
                ", Sum Precipitation: " + stat.precipitation()));
    }
}
