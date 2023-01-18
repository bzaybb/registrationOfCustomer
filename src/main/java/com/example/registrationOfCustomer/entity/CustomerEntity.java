package com.example.registrationOfCustomer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table (name="customer_registration")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name= "customer_name")
    private String customerName;

    @Column (name= "customer_email")
    private String email;

    @Column (name= "customer_password")
    private String password;

    @Column (name= "customer_mobileNum")
    private String mobileNum;


}
