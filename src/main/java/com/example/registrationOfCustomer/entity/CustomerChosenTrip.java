package com.example.registrationOfCustomer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@Entity
@IdClass(CustomerPrimaryKeys.class)
@Table(name = "customer_chosen_trip")
public class CustomerChosenTrip {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Integer id;


    @Id
    @Column(name = "car_Registration")
    private String carRegistration;

    @Id
    @Column (name = "cust_id")
    private  Integer customerId;

    @Column(name ="car_type")
    private String carType;

    @Column (name= "car_Model")
    private String carModel;

    @Column(name = "car_Seater")
    private String carSeater;

    @Column(name = "baggage_Capacity")
    private String baggageCapacity;

    @Column(name = "car_AC_or_NonAc")
    private String carACorNonAc;

    @Column(name = "base_Price")
    private int basePrice;

    @Column(name = "status")
    private String status;

    @Column(name = "image_Url")
    private String imageUrl;

    @Temporal(TemporalType.TIMESTAMP)
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "start_date")
     private Calendar startDate;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date")
    private Calendar endDate;

    @Column(name = "trip_type")
    private String tripType;

    //this will allow you to take refernece
    //@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)



}
