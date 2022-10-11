package com.RESTcarpassenger.RESTCarpassenger.service;

import com.RESTcarpassenger.RESTCarpassenger.entities.Car;

import java.util.List;

public interface CarService {
    void addCar(Car car);
    List<Car> getCarList();
    void deleteCar(int carID);
    void updateCar(int carID);
}
