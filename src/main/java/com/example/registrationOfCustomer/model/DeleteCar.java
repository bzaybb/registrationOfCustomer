package com.example.registrationOfCustomer.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeleteCar {

    private List<String> carRegistrationToBeDeleted;
}
