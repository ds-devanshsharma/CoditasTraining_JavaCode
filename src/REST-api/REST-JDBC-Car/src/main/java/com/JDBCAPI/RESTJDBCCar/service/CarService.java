package com.JDBCAPI.RESTJDBCCar.service;

import com.JDBCAPI.RESTJDBCCar.entities.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarService {
    void addCar(Car car) throws SQLException;
    Car viewCar(int carID) throws SQLException;
    List<Car> viewCarList() throws SQLException;
    String  deleteCar(int carID) throws SQLException;
    void updateCar(int carID);
}
