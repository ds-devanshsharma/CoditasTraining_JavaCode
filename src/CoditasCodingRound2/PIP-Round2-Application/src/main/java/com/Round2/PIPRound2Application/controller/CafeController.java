package com.Round2.PIPRound2Application.controller;

import com.Round2.PIPRound2Application.dto.request.OrderRequestDto;
import com.Round2.PIPRound2Application.dto.request.PlaceOrder;
import com.Round2.PIPRound2Application.entities.BookingEntity;
import com.Round2.PIPRound2Application.entities.MenuEntity;
import com.Round2.PIPRound2Application.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cafe")
public class CafeController {
    @Autowired
    CafeService service;
    @PostMapping("/addBooking")
    public ResponseEntity addBookingController(@RequestBody BookingEntity booking) {
        try {
            return service.addBooking(booking);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/showMenu")
    public ResponseEntity showMenuController(){
        try{
            List<MenuEntity> menuEntityList = service.showMenuOfItem();
            if(menuEntityList.size()>0){
                return new ResponseEntity(menuEntityList,HttpStatus.FOUND);
            }
            else {
                return new ResponseEntity("Item Not Found In Menu ",HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e ){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/placeOrder")
    public ResponseEntity placeOrder(OrderRequestDto order){
        try{
            return new ResponseEntity(service.placeOrder(order),HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
