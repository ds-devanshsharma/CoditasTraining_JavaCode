package com.Springboot.CarPreBookingApplication.repository;

import com.Springboot.CarPreBookingApplication.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
