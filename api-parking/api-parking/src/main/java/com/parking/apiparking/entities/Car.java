package com.parking.apiparking.entities;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Car {
    private String licensePlate;
    private String color;
    private LocalDateTime entryTime;

    public Car(String licensePlate, String color) {
        this.licensePlate = licensePlate;
        this.color = color;
    }
}
