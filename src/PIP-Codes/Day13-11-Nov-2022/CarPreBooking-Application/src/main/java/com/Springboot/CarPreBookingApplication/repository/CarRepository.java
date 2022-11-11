package com.Springboot.CarPreBookingApplication.repository;

import com.Springboot.CarPreBookingApplication.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    @Query(value = "SELECT * FROM car_store WHERE car_model = ?1" ,nativeQuery = true)
    List<Car> getCarByModel(String model);

    @Query(value = "SELECT * FROM CAR_STORE WHERE CAR_PRICE BETWEEN ?1 AND ?2" ,nativeQuery = true)
    List<Car> getCarByPriceRange(Double startPrice ,Double endPrice);
}
