package com.example.registrationOfCustomer.service;

import com.example.registrationOfCustomer.entity.CustomerEntity;
import com.example.registrationOfCustomer.model.RegistrationModel;
import com.example.registrationOfCustomer.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
//this is sample
    @Autowired
    private RegistrationRepository registrationRepository;

    public String saveData(RegistrationModel registrationModel) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setLoginType(registrationModel.getLoginType());
        customerEntity.setFirstName(registrationModel.getFirstName());
        customerEntity.setLastName(registrationModel.getLastName());
        customerEntity.setEmailAddress(registrationModel.getEmailAddress());
        customerEntity.setMobileNumber(registrationModel.getMobileNumber());
        customerEntity.setPassword(registrationModel.getPassword());
        customerEntity.setConfirmPassword(registrationModel.getConfirmPassword());
        customerEntity.setStatus(registrationModel.getStatus());



        try {
            registrationRepository.save(customerEntity);
        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
        }
        return "success!!";
    }
}
