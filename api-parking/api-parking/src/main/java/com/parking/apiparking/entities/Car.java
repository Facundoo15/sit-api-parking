package com.parking.apiparking.entities;

import lombok.*;

@Getter
@Setter
@ToString
public class Car {
    private String licensePlate;
    private String color;
    private String LocalDateTime;

    public Car(String licensePlate, String color) {
        this.licensePlate = licensePlate;
        this.color = color;
    }
}
