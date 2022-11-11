package com.Springboot.CarPreBookingApplication.repository;

import com.Springboot.CarPreBookingApplication.entities.CarBooking;
import com.Springboot.CarPreBookingApplication.entities.CarSeller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarSellerRepository extends JpaRepository<CarSeller,Long> {
}
