package com.Round2.PIPRound2Application.service;


import com.Round2.PIPRound2Application.dto.request.OrderRequestDto;
import com.Round2.PIPRound2Application.dto.request.PlaceOrder;
import com.Round2.PIPRound2Application.entities.*;
import com.Round2.PIPRound2Application.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CafeServiceImpl implements CafeService{
    @Autowired
    CafeRepository cafeRepository ;
    @Autowired
    MenuRepository menuRepository ;
    @Autowired
    TableRepository tableRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    BookingRepository bookingRepository;

    @Override
    @Transactional
    public ResponseEntity addBooking(BookingEntity booking) {
        if(booking.getReqSeat()<=8) {
            TableEntity table = tableRepository.findTableIdBasedOnRequiredSeats(booking.getReqSeat());
//            System.out.println(table.getTableId());
            if(table != null) {
                table.setStatus("B");
                booking.setTable(table);
                BookingEntity bookingEntity = bookingRepository.save(booking);
                tableRepository.save(table);
                return  new ResponseEntity(bookingEntity ,HttpStatus.CREATED);
            }else{
                return new ResponseEntity("Seats Not available !",HttpStatus.NOT_ACCEPTABLE);
            }
        }
        return null;
    }

    @Override
    @Transactional
    public List<MenuEntity> showMenuOfItem() {
        List<MenuEntity> menuEntityList = menuRepository.findAll();
        System.out.println(menuEntityList.size());
        return menuEntityList;
    }

    @Override
    public OrderEntity placeOrder(OrderRequestDto orderRequestDto) {
        OrderEntity savedOrder = null;
        TableEntity table = tableRepository.findById(orderRequestDto.getTableNumber()).orElse(null);
        if(table != null) {
            if(table.getBooking().getOrders().size()>0){
                savedOrder =
            }else {
                savedOrder = new OrderEntity();
            }
         //now saved
         savedOrder = orderRepository.save(savedOrder);
         savedOrder.setBooking(table.getBooking());

         List<OrderPerItemMenu> orderPerItemMenuList = orderRequestDto.getSerialNumberOfItemAndQuantity()
                 .entrySet().stream()
                 .map(itemAndQuantity-> new OrderPerItemMenu(
                         itemAndQuantity.getValue(),
                         menuRepository.findById(Math.toIntExact(itemAndQuantity.getKey())).orElse(null),
                         savedOrder)).collect(Collectors.toList());

        }else{
            return null;
        }
    }
}
