package com.Springboot.CarPreBookingApplication.dto.requestDto;
import lombok.Data;

@Data
public class AddCarDto {
    private String carModel;
    private Double carPrice ;
    private boolean carStatus;
    private Long sellerId;
}
