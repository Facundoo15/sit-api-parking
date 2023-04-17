package com.parking.apiparking.service;

import com.parking.apiparking.entities.Car;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    // TODO: US2 Como usuario, quiero poder buscar un auto por su placa, para poder encontra rápidamente un vehículo en particular.
    public Optional<Car> getCarByLicense(String license) {
        return parkingLot.stream().filter(e -> e.getLicensePlate().equalsIgnoreCase(license)).findFirst();
    }

    // TODO: US3 Como usuario, quiero poder buscar autos por su color, para poder encontrar todos los vehículos de un mismo color en el estacionamiento.
    public List<Car> getCarsByColor(String color) {
        return parkingLot.stream().filter(e -> e.getColor().equals(color)).toList();
    }

    // TODO: US4 Como usuario, quiero poder agregar un auto al parqueo, para poder estacionar mi vehículo.
    public void addCar(Car car) {
        this.parkingLot.add(car);
    }


    // Método para eliminar un auto por la licencia
    public boolean removeCarbyLicense(String license) {
        return this.parkingLot.removeIf(e -> e.getLicensePlate().equalsIgnoreCase(license));
    }

    // Método para parkear un auto y asignarle su hora de ingreso
    public void parkCar(Car car) {
        car.setEntryTime(LocalDateTime.now());
        addCar(car);
    }

    // TODO: US5 Como usuario, quiero poder sacar un auto del parqueo y calcular la tarifa de
    // estacionamiento, para poder salir del estacionamiento y pagar la tarifa
    // correspondiente

    public double calculateParking(String license){
        Optional<Car> optionalCar = getCarByLicense(license);
        if(optionalCar.isPresent()){
            Car car = optionalCar.get();
            LocalDateTime timePark = car.getEntryTime();
            if(timePark != null){
                long timeHoursParked = ChronoUnit.HOURS.between(timePark, LocalDateTime.now());
                return timeHoursParked * 25;
            }
        }
        return 0;
    }

}
