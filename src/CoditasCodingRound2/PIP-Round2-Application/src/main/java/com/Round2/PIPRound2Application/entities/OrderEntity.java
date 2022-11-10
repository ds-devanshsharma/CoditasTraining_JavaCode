package com.Round2.PIPRound2Application.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Order_details")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    @ManyToOne
    private BookingEntity booking;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderPerItemMenu> orderPerItemMenuList = new ArrayList<>();
}