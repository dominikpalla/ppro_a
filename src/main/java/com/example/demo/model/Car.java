package com.example.demo.model;

import jakarta.validation.constraints.*;

public class Car {

    private int id = -1;

    @Size(min = 7, max = 7)
    private String spz;

    @NotBlank
    private String color;

    @Min(value = 5)
    @Max(value = 100)
    private float tankVolume;

    @Min(value = 2)
    @Max(value = 9)
    private int numberOfSeats;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpz() {
        return spz;
    }

    public void setSpz(String spz) {
        this.spz = spz;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getTankVolume() {
        return tankVolume;
    }

    public void setTankVolume(float tankVolume) {
        this.tankVolume = tankVolume;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
