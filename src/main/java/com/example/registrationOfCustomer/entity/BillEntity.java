package com.example.registrationOfCustomer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "bill_records")
public class BillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private DashboardEntity dashboardEntity;

    private String emailAddress;

    private String carRegistration;

    private String carType;

    private int durationInHours;

    private double totalPrice;

    private String tripType;

    private String location;

}
