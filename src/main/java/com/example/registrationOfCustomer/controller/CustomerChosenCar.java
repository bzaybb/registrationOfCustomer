package com.example.registrationOfCustomer.controller;


import com.example.registrationOfCustomer.model.CustomerChosenModel;
import com.example.registrationOfCustomer.model.DeleteCar;
import com.example.registrationOfCustomer.service.CustomerChosenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerChosen")
public class CustomerChosenCar {

    @Autowired
    CustomerChosenService customerChosenService;

    @PostMapping("/saveCustomerTrip")
    public  String saveCustomerChosenService(@RequestBody CustomerChosenModel customerChosenModel){
         String message = customerChosenService.customerChosenTripType(customerChosenModel);
         return  message;
    }

    @GetMapping("/customerDetailsByEmail")

    public List<CustomerChosenModel> finData(@RequestParam String emailAddress){// vendor email needed as parameter
        List <CustomerChosenModel> customerChosenModelList = this.customerChosenService.fetchCustomerChosen(emailAddress);

        return customerChosenModelList;
    }

    @PutMapping("/update")
    public String update(@RequestBody CustomerChosenModel customerChosenModel){
        String returnMessage = this.customerChosenService.updateCustomerChosen(customerChosenModel);
        return returnMessage;
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody DeleteCar deleteCar) {
        String customerChosenModel= customerChosenService.deleteAll(deleteCar.getCarRegistrationToBeDeleted());
        return customerChosenModel;
    }
}
