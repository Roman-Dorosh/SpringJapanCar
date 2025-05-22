package ru.japan.car.model;

public class Car {
    private int id;
    private String model;
    private String equipment;
    private int yearRelease;

    public Car() {
    }

    public Car(int id, String model, String equipment, int yearRelease) {
        this.id = id;
        this.model = model;
        this.equipment = equipment;
        this.yearRelease = yearRelease;
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

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public int getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(int yearRelease) {
        this.yearRelease = yearRelease;
    }
}