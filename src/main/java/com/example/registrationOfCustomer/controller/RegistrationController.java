package com.example.registrationOfCustomer.controller;

import com.example.registrationOfCustomer.entity.CustomerEntity;
import com.example.registrationOfCustomer.model.RegistrationModel;
import com.example.registrationOfCustomer.repository.CustomerRolesRepository;
import com.example.registrationOfCustomer.repository.LoginRepository;
import com.example.registrationOfCustomer.repository.RegistrationRepository;
import com.example.registrationOfCustomer.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    CustomerRolesRepository customerRolesRepository;


    @PostMapping("/customer")
    public String customer(@RequestBody RegistrationModel registrationModel) {
        this.registrationService.saveData(registrationModel);
        return "Customer registration success";
    }

    @PutMapping("/updateCustomer")
    public String updateCustomer(@RequestBody RegistrationModel registrationModel) {


        this.registrationService.updateCustomerDetails(registrationModel);
        return "Customer Detail is updated";
    }

    @GetMapping("/fetchCustomer")
    public CustomerEntity fetchCustomer(@RequestParam String emailAddress){
       return this.registrationService.fetchCustomerDetails(emailAddress);
    }
    @GetMapping("/displayall")
    public List<CustomerEntity> display(){
        return this.registrationRepository.findAll();
    }

    @DeleteMapping("/delete")
    public String deleteCustomerRecord(@RequestParam Integer custId) {
        this.customerRolesRepository.deleteByCustId(custId);
        this.registrationRepository.deleteById(custId);

        return "delete Successful!!";
    }



}

