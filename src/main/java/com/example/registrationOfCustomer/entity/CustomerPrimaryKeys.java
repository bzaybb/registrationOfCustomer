package com.example.registrationOfCustomer.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
public class CustomerPrimaryKeys implements Serializable {
    private  String carRegistration;
    private  Integer customerId;
}
