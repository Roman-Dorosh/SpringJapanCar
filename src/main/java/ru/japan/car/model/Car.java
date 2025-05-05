package ru.japan.car.model;

public class Car {
    private int id;
    private String model;
    private int power;

    public Car(int id, String model, int power) {
        this.id = id;
        this.model = model;
        this.power = power;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}