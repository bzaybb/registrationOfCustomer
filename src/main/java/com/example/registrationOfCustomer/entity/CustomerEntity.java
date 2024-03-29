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

    @Column (name= "login_Type")
    private String loginType;

    @Column (name= "first_name")
    private String firstName;

    @Column (name="last_name")
    private String lastName;

    @Column (name= "customer_email")
    private String emailAddress;

    @Column (name= "mobile_Num")
    private String mobileNumber;

    @Column (name= "password")
    private String password;

    @Column (name ="confirm_Password")
    private String confirmPassword;

    @Column (name="status")
    private String status;

    // Maping login entity with customer entity
    @OneToOne(cascade = CascadeType.ALL, fetch= FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name="login_id")
    private LoginEntity loginEntity;


}
