package com.example.registrationOfCustomer.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "billing_information")
public class BillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "car_type")
    String carType;
    @Column(name = "car_model")
    String carModel;
    @Column(name = "duration_hours")
    String durationHrs;
    @Column(name = "total_price")
    Double totalPrice;
    @Column(name = "trip_type")
    String tripType;
    @Column(name = "location")
    String location;
}
