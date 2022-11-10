package com.Round2.PIPRound2Application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "OrderPerItem_detail")
@NoArgsConstructor
public class OrderPerItemMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderPerItemId;

    @Column(nullable = false)
    private int itemQuantity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "menuOrderId")
    @JsonIgnore
    private MenuEntity menu;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "orderedOrderId")
    @JsonIgnore
    private OrderEntity order;

    public OrderPerItemMenu(int itemQuantity, MenuEntity menu, OrderEntity order) {
        this.itemQuantity = itemQuantity;
        this.menu = menu;
        this.order = order;
    }
}