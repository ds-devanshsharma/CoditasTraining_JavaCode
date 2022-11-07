package com.Round2.PIPRound2Application.service;

import com.Round2.PIPRound2Application.entities.BookingDetails;
import org.springframework.http.ResponseEntity;

public interface CafeService {
    ResponseEntity addBooking(BookingDetails booking);
}
