package com.RESTcarpassenger.RESTCarpassenger.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.RESTcarpassenger.RESTCarpassenger.service.*;
import com.RESTcarpassenger.RESTCarpassenger.entities.*;
import java.util.List;

@RestController
public class MyController {
   @Autowired
    CarService service;
    @PostMapping("/addCar")
    void addCarController(@RequestBody Car car){
        service.addCar(car);
    }
    @GetMapping("/carList")
    List<Car> carListController(){
        return service.getCarList();
    }
}
