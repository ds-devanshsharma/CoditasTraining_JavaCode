package com.SpringAPIPractice.controller;

import com.SpringAPIPractice.Entities.Car;
import com.SpringAPIPractice.service.ServiceDAO;
import com.SpringAPIPractice.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class MyController {
    @Autowired
    ServiceDAO serviceDAO;

    @PostMapping("/registerCar")
    void registerCarController(@RequestBody Car car){
       serviceDAO.insertCar(car);
    }

    @GetMapping("/fetchCar")
    List<Car> fetchCarController(){
        return serviceDAO.fetchCar();
    }
}
