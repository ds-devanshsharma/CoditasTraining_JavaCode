package com.Springboot.CarPreBookingApplication.controller;

import com.Springboot.CarPreBookingApplication.dto.requestDto.BookCarDto;
import com.Springboot.CarPreBookingApplication.dto.requestDto.CarModelDto;
import com.Springboot.CarPreBookingApplication.dto.requestDto.CarPriceDto;
import com.Springboot.CarPreBookingApplication.entities.Car;
import com.Springboot.CarPreBookingApplication.entities.CarBooking;
import com.Springboot.CarPreBookingApplication.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService carService ;

    @GetMapping("/getCarModels")
    ResponseEntity getCarBasedOnModelController(@RequestBody CarModelDto modelDto){
        try{
            List<Car> cars = carService.getCarBasedOnModel(modelDto);
            if(!cars.isEmpty())
                return new ResponseEntity(Optional.of(cars),HttpStatus.FOUND);
            else
                return new ResponseEntity("CARS NOT FOUND !!" ,HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getCarsInPriceRange")
    ResponseEntity getCarBasedOnPriceRangeController(@RequestBody CarPriceDto priceDto){
        try{
            List<Car> cars = carService.getCarBasedOnPriceRange(priceDto);
            if(!cars.isEmpty())
                return new ResponseEntity(Optional.of(cars),HttpStatus.FOUND);
            else
                return new ResponseEntity("CARS NOT FOUND IN THAT RANGE !!" ,HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/buyCar")
    ResponseEntity preBookYourCarController(@RequestBody BookCarDto bookDto){
        try{
            CarBooking bookedCar = carService.bookYourCar(bookDto);
            if(bookedCar != null)
                return new ResponseEntity(Optional.of(bookedCar),HttpStatus.CREATED);
            else
                return new ResponseEntity("CAR IS ALREADY SOLD ! ",HttpStatus.NOT_ACCEPTABLE);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
