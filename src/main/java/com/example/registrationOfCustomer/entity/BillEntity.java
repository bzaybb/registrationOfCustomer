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
    private Integer id;
    @Column(name = "car_type")
    private String carType;
    @Column(name = "car_model")
    private String carModel;
    @Column(name = "duration_hours")
    private String durationHrs;
    @Column(name = "total_price")
    private Double totalPrice;
    @Column(name = "trip_type")
    private String tripType;
    @Column(name = "location")
    private String location;

    @OneToOne
    @JoinColumn(name="customer_id")
    private CustomerEntity customerEntity;
}
