package com.example.registrationOfCustomer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Dashboard_Information" )

public class DashboardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="car_type")
    private String carType;

    @Column (name= "car_Model")
    private String carModel;

    @Column(name = "car_Seater")
    private String carSeater;

    @Column(name = "baggage_Capacity")
    private String baggageCapacity;

    @Column(name = "car_Registration")
    private String carRegistration;

    @Column(name = "car_AC_or_NonAc")
    private String carACorNonAc;

    @Column(name = "base_Price")
    private int basePrice;

    @Column(name = "status")
    private String status;

    @Column(name = "image_Url")
    private String imageUrl;


    //
    @ManyToOne
    @JoinColumn(name = "tripType")
    TripTypeEntity tripType;



}

