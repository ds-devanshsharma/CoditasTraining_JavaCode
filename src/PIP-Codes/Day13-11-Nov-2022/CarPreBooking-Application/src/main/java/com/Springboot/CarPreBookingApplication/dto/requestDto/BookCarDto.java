package com.Springboot.CarPreBookingApplication.dto.requestDto;

import lombok.Data;

import java.util.Date;

@Data
public class BookCarDto {
    private Long carId;
    private Long customerId;
    private Date bookDate;
}
