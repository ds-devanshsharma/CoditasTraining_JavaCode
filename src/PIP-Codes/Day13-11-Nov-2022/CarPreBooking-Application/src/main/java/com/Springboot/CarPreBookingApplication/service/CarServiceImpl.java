package com.Springboot.CarPreBookingApplication.service;

import com.Springboot.CarPreBookingApplication.dto.requestDto.BookCarDto;
import com.Springboot.CarPreBookingApplication.dto.requestDto.CarModelDto;
import com.Springboot.CarPreBookingApplication.dto.requestDto.CarPriceDto;
import com.Springboot.CarPreBookingApplication.entities.Car;
import com.Springboot.CarPreBookingApplication.entities.CarBooking;
import com.Springboot.CarPreBookingApplication.entities.Customer;
import com.Springboot.CarPreBookingApplication.repository.CarBookingRepository;
import com.Springboot.CarPreBookingApplication.repository.CarRepository;
import com.Springboot.CarPreBookingApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService{
    @Autowired
    CarRepository carRepository ;
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CarBookingRepository carBookingRepository;

    @Override
    public List<Car> getCarBasedOnModel(CarModelDto modelDto) {
        System.out.println(modelDto.getCarModel());
        return carRepository.getCarByModel(modelDto.getCarModel());
    }

    @Override
    public List<Car> getCarBasedOnPriceRange(CarPriceDto priceDto) {
        return carRepository.getCarByPriceRange(priceDto.getStartPrice(), priceDto.getEndPrice());
    }

    @Override
    public CarBooking bookYourCar(BookCarDto bookDto) {
        Car car = carRepository.findById(bookDto.getCarId()).get();
        if(!car.isCarStatus()){
            Customer customer = customerRepository.findById(bookDto.getCustomerId()).get();
            if(customer != null){
                CarBooking carBook = new CarBooking();
                carBook.setCar(car);
                carBook.setCustomer(customer);
                carBook.setBookingDate(bookDto.getBookDate());
                car.setCarStatus(true);
                return carBookingRepository.save(carBook);
            }
        }
        return null;
    }
}
