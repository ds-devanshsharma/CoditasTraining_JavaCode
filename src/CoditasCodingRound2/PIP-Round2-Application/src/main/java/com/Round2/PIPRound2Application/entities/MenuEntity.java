package com.Round2.PIPRound2Application.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "ItemMenu_details")
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  serialId;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false ,name = "itemName")
    private String itemName;
//    @ManyToMany(mappedBy = "menu")
//    private List<OrderEntity> order;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
    private List<OrderPerItemMenu> orderPerItemMenuList;
}