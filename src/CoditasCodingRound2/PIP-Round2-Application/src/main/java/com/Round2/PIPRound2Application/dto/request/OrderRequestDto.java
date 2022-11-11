package com.Round2.PIPRound2Application.dto.request;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class OrderRequestDto {
    private int tableId;
    private Map<Integer, Integer> itemIdAndQuantity= new HashMap<>();
}