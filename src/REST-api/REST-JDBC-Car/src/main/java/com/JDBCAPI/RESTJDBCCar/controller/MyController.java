package com.JDBCAPI.RESTJDBCCar.controller;

import com.JDBCAPI.RESTJDBCCar.entities.Car;
import com.JDBCAPI.RESTJDBCCar.service.CarService;
import com.JDBCAPI.RESTJDBCCar.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class MyController {
    @Autowired
    CarService carService;
    @PostMapping("/addCar")
    void addCarController(@RequestBody  Car car) throws SQLException {
        carService.addCar(car);
    }

    @GetMapping("/carList")
    List<Car> getCarListController() throws SQLException {
        return carService.viewCarList();
    }
    @GetMapping("/viewCarByID/{}")
    Car carById(@PathVariable int carId) throws SQLException {
        return carService.viewCar(carId);
    }
}
