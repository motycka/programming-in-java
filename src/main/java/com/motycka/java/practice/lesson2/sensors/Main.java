package com.motycka.java.practice.lesson2.sensors;

import com.motycka.java.practice.lesson2.sensors.model.MeteoStation;
import com.motycka.java.practice.lesson2.sensors.model.Sensor;
import com.motycka.java.practice.lesson2.sensors.model.SensorType;

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        SensorType[] sensorTypes = {
                SensorType.TEMPERATURE,
                SensorType.HUMIDITY,
                SensorType.WIND,
                SensorType.PRECIPITATION
        };

        MeteoStation meteo = new MeteoStation("Meteo Campus 1", sensorTypes, Instant.now());

        System.out.println(meteo.getId());
        System.out.println(meteo.getName());
        System.out.println(meteo.getTime());
        for (Sensor sensor: meteo.getSensors()) {
            System.out.println(sensor.getType());
            System.out.println(sensor.getValue());
        }


//        MeteoStation meteo2 = Meteo.byName("");
    }
}
