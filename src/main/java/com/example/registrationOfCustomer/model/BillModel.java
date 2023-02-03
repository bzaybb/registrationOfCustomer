package com.example.registrationOfCustomer.model;


import com.example.registrationOfCustomer.entity.CustomerEntity;
import com.example.registrationOfCustomer.entity.DashboardEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class BillModel {

    private int billId;

    private int custId;

    private String carRegistration;

    private String carType;

    private int durationInHours;

    private double totalPrice;

    private String tripType;

    private String location;

}
