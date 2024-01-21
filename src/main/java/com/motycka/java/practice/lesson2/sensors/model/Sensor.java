package com.motycka.java.practice.lesson2.sensors.model;


public class Sensor {

    private final SensorType type;
    private double value;
    public Sensor(SensorType type) {
        this.type = type;
    }

    public Sensor(SensorType type, Double value) {
        this.type = type;
        this.value = value;
    }

    public SensorType getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
