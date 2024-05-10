package com.example.demoEs8.controllers;

import com.example.demoEs8.entities.Car;
import com.example.demoEs8.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarRepository carRepository;
    @PostMapping
    public Car create (@RequestBody Car car){
        Car newCar = carRepository.saveAndFlush(car);
        return newCar;
    }
    @GetMapping
    public List<Car> findAll(){
        List<Car> cars = carRepository.findAll();
        return cars;
    }
    @GetMapping("/{id}")
    public Car findById(@PathVariable long id){
        Car car = new Car();
        if(carRepository.existsById(id)){
            car = carRepository.getById(id);
            return car;
        }else{
            return car;
        }
    }
    @PutMapping("/{id}")
    public Car updateType(@PathVariable long id, @RequestBody Car car){
        if(carRepository.existsById(id)) {
            car.setId(id);
            Car newCar = carRepository.saveAndFlush(car);
            return newCar;
        }else{
            Car nullCar = new Car();
            return nullCar;
        }
    }
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable long id){
        if(carRepository.existsById(id)) {
            carRepository.deleteById(id);
        }else {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }
    @DeleteMapping("/deleteall")
    public void deleteAll(){
        carRepository.deleteAll();
    }
}
