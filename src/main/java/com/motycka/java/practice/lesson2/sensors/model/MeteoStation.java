package com.motycka.java.practice.lesson2.sensors.model;


import java.time.Instant;
import java.util.ArrayList;

public class MeteoStation {

    private final long id = System.currentTimeMillis();
    private final String name;
//    private final Sensor[] sensors;
    private final SensorType[] sensorTypes;
    private final Instant time;

//    public MeteoStation(String name, Sensor[] sensors, Instant time) {
    public MeteoStation(String name, SensorType[] sensorTypes, Instant time) {
        this.name = name;
        this.sensorTypes = sensorTypes;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public SensorType[] getSensorTypes() {
        return sensorTypes;
    }

    public Instant getTime() {
        return time;
    }

    public long getId() {
        return id;
    }

    public Sensor[] getSensors() {
        Sensor[] sensors = new Sensor[sensorTypes.length];

        for (int i = 0; i < sensorTypes.length; i++) {
            sensors[i] = new Sensor(this.sensorTypes[i], 1.23);
        }

        return sensors;
    }

//    public static class Meteo {
//        public static MeteoStation byName(String name) {
//            Sensor[] sensors = {
//                    new Sensor(SensorType.TEMPERATURE),
//                    new Sensor(SensorType.HUMIDITY),
//                    new Sensor(SensorType.PRECIPITATION),
//                    new Sensor(SensorType.WIND)
//            };
//            return new MeteoStation(name, sensors, Instant.now());
//        }
//    }
}

