package com.example.registrationOfCustomer.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
public class CustomerChosenModel {
    private  String carType;
    private String carModel;
    private String carSeater;
    private String baggageCapacity;
    private String carRegistration;
    private String carACorNonAc;
    private int basePrice;
    private String status;
    private String imageUrl;
    private String endDate;
    private String startDate;
    private  Integer customerId;
    private  String tripType;
}
