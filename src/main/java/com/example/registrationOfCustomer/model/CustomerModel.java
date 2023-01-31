package com.example.registrationOfCustomer.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerModel {


    private String loginType;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String mobileNumber;
    private String confirmPassword;
    private String status;
    private List<CustomerRolesModel> role;

}
