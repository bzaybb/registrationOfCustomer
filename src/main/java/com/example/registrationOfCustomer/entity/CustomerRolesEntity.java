package com.example.registrationOfCustomer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table( name= "customer_roles")
public class CustomerRolesEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "role_name")
    private String roleName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "login_id")
    private LoginEntity loginEntity;







}
