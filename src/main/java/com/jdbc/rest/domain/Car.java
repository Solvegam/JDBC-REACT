package com.jdbc.rest.domain;

import java.time.LocalDate;

/**
 * Created by stas on 20.11.16.
 */
public final class Car {

    private String model;
    private String producer;
    private double engineVolume;
    private int serialId;
    private String color;
    private LocalDate dayOfProduction;
    private int customerId;


    public Car() {
    }

    public Car(String model, String producer, double engineVolume, int serialId, int customerId, String color, LocalDate dayOfProduction) {
        this.model = model;
        this.producer = producer;
        this.engineVolume = engineVolume;
        this.serialId = serialId;
        this.customerId = customerId;
        this.color = color;
        this.dayOfProduction = dayOfProduction;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public int getSerialId() {
        return serialId;
    }

    public void setSerialId(int serialId) {
        this.serialId = serialId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getDayOfProduction() {
        return dayOfProduction;
    }

    public void setDayOfProduction(LocalDate dayOfProduction) {
        this.dayOfProduction = dayOfProduction;
    }
}
