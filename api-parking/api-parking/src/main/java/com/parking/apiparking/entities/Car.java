package com.parking.apiparking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
    private String licensePlate;
    private String color;
    private String LocalDateTime;

}
