package com.motycka.java.practice;

public class LiveCity implements Runnable {

    private final String cityName;
    private final long aliveFor;

    LiveCity(String cityName, long aliveFor) {
        this.cityName = cityName;
        this.aliveFor = aliveFor;
    }

    public String getCityName() {
        return this.cityName;
    }

    @Override
    public void run() {
        try {
            System.out.println("City of " + cityName + " is alive!");
            Thread.sleep(aliveFor);
        } catch (InterruptedException e) {
            System.out.println("Oh damn, something bad has happened in " + cityName);
            throw new RuntimeException(e);
        }
    }
}
