package com.Round2.PIPRound2Application.controller;

import com.Round2.PIPRound2Application.entities.BookingDetails;
import com.Round2.PIPRound2Application.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cafe")
public class CafeController {
    @Autowired
    CafeService service;
    @PostMapping("/addBooking")
    ResponseEntity addBooking(BookingDetails booking){
        return service.addBooking(booking);
    }
}
