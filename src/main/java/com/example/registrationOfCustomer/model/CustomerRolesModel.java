package com.example.registrationOfCustomer.model;

import com.example.registrationOfCustomer.entity.LoginEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Getter
@Setter
public class CustomerRolesModel {

    private String roleName;
}
