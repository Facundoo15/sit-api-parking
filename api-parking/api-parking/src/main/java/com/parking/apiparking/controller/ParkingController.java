package com.parking.apiparking.controller;

import com.parking.apiparking.entities.Car;
import com.parking.apiparking.service.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parking") // Parking => http://dominio/parking
public class ParkingController {

    // Inyección de dependencias => Instancias => new ParkingService();

    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping("/cars") //  GET http://dominio/parking/cars ==> Obtener la lista de carros
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(this.parkingService.getAllCars());
    }

    @PostMapping("/cars") //  POST http://dominio/parking/cars ==> Obtener la lista de carros
    public ResponseEntity<Car> addCar(Car car) {
        this.parkingService.addCar(car);
        return new ResponseEntity<>(car, HttpStatus.CREATED); //CREATED = 201
    }


}
