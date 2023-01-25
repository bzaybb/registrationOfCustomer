package com.example.registrationOfCustomer.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Cust_Login_Table")
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "login_Type")
    private String loginType;

    @Column (name= "email_Address")
    private String emailAddress;

    @Column (name="passowrd")
    private String password;

    // Maping customer entity with login entity
    @OneToOne(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name="cust_id")
    private CustomerEntity customerEntity;


}
