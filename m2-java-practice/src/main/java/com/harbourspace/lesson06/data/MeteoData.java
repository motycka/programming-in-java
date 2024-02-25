package com.harbourspace.lesson06.data;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public record MeteoData(
        ZonedDateTime time,
        Double temperature,
        Double humidity,
        Double precipitation
) implements Comparable<MeteoData>{

    @Override
    public int compareTo(MeteoData o) {
        if (this.time().isBefore(o.time())) {
            return 1;
        } else if (this.time().isAfter(o.time())) {
            return -1;
        } else {
            return 0;
        }
    }

}
