package com.Springboot.CarPreBookingApplication.repository;

import com.Springboot.CarPreBookingApplication.entities.Car;
import com.Springboot.CarPreBookingApplication.entities.CarBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarBookingRepository extends JpaRepository<CarBooking,Long> {
}
