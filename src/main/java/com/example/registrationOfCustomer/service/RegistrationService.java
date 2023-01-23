package com.example.registrationOfCustomer.service;

import com.example.registrationOfCustomer.entity.CustomerEntity;
import com.example.registrationOfCustomer.model.RegistrationModel;
import com.example.registrationOfCustomer.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public String saveData(RegistrationModel registrationModel) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerName(registrationModel.getCustomerName());
        customerEntity.setEmail(registrationModel.getEmail());
        customerEntity.setPassword(registrationModel.getPassword());
        customerEntity.setMobileNum(registrationModel.getMobileNum());


        try {
            registrationRepository.save(customerEntity);
        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
        }
        return "success!!";
    }
}
