package com.example.registrationOfCustomer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationModel {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String mobileNumber;
    private String confirmPassword;
    private String status;

}
