package com.Round2.PIPRound2Application.service;


import com.Round2.PIPRound2Application.dto.request.OrderRequestDto;
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
    @Autowired
    ItemAndQuantityPerOrderRepository itemAndQuantityPerOrderRepository;


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
    @Transactional
    public OrderEntity placeOrder(OrderRequestDto orderDto) {
        OrderEntity order = null;
        TableEntity orderAtTable = tableRepository.findById(orderDto.getTableId()).get();
//        orderAtTable.getBooking().
        order = new OrderEntity();
        order.setBooking(orderAtTable.getBooking());
        OrderEntity savedOrder = orderRepository.save(order);

        OrderPerItemMenu order1 = new OrderPerItemMenu();
        order1.setItemQuantity(orderDto.getItemIdAndQuantity().get(orderDto.getItemIdAndQuantity()
                .entrySet().iterator().next().getValue()));
        MenuEntity item1 = menuRepository.findById(orderDto.getItemIdAndQuantity()
                .entrySet().iterator().next().getKey()).get();
        order1.setMenu(item1);
        itemAndQuantityPerOrderRepository.save(order1);
        return orderRepository.save(savedOrder);

    }
}

