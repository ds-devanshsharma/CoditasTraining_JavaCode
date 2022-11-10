package com.Round2.PIPRound2Application.dto.request;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class OrderRequestDto {
    private int tableNumber;
    private Map<Long, Integer> serialNumberOfItemAndQuantity= new HashMap<>();
}