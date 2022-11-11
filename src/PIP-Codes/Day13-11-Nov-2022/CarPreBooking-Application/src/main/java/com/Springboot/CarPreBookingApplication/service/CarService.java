package com.Springboot.CarPreBookingApplication.service;

import com.Springboot.CarPreBookingApplication.dto.requestDto.BookCarDto;
import com.Springboot.CarPreBookingApplication.dto.requestDto.CarModelDto;
import com.Springboot.CarPreBookingApplication.dto.requestDto.CarPriceDto;
import com.Springboot.CarPreBookingApplication.entities.Car;
import com.Springboot.CarPreBookingApplication.entities.CarBooking;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
public interface CarService {
    List<Car> getCarBasedOnModel( CarModelDto modelDto);
    List<Car> getCarBasedOnPriceRange(CarPriceDto priceDto);

    CarBooking bookYourCar(BookCarDto bookDto);
}
