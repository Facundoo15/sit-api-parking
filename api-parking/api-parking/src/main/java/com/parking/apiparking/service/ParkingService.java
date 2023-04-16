package com.parking.apiparking.service;

import com.parking.apiparking.entities.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingService {

    private List<Car> parkingLot;

    public ParkingService() {
        this.parkingLot = new ArrayList<>();
    }

    //TODO: US1 Como usuario, quiero poder ver la lista de todos los autos estacionados en el
    //parqueo, para poder tener una visión general del estado actual del
    //estacionamiento
    public List<Car> getAllCars() {
        return this.parkingLot;
    }

    // TODO: US2 Como usuario, quiero poder buscar un auto por su placa, para poder encontrar
    //rápidamente un vehículo en particular.

    // TODO: US4 Como usuario, quiero poder agregar un auto al parqueo, para poder estacionar
    //mi vehículo.
    public void addCar(Car car){
        this.parkingLot.add(car);
    }

}
