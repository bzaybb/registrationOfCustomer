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

    @Column (name= "first_name")
    private String firstName;

    @Column (name="last_name")
    private String lastName;

    @Column (name= "customer_email")
    private String emailAddress;

    @Column (name= "mobile Num")
    private String mobileNumber;

    @Column (name= "passowrd")
    private String password;

    @Column (name ="confirm_Password")
    private String confirmPassword;

    @Column (name="status")
    private String status;




}
