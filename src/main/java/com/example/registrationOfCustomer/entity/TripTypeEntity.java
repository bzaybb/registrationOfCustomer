package com.example.registrationOfCustomer.entity;

import com.example.registrationOfCustomer.model.DashboardModel;
import com.example.registrationOfCustomer.model.TripTypeModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "types_Of_trip")
public class TripTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name ="trip_type" )
    private String tripType;


}
