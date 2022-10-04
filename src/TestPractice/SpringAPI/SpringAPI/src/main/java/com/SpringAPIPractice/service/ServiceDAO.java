package com.SpringAPIPractice.service;

import com.SpringAPIPractice.Entities.Car;

import java.util.List;

public interface ServiceDAO {
    void insertCar(Car car);
    List<Car> fetchCar();
}
