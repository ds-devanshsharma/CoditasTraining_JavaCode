package com.Round2.PIPRound2Application.service;
import com.Round2.PIPRound2Application.dto.request.OrderRequestDto;
import com.Round2.PIPRound2Application.entities.BookingEntity;
import com.Round2.PIPRound2Application.entities.MenuEntity;
import com.Round2.PIPRound2Application.entities.OrderEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CafeService {
    ResponseEntity addBooking(BookingEntity booking);
    List<MenuEntity> showMenuOfItem();
    OrderEntity placeOrder(OrderRequestDto order);
}
