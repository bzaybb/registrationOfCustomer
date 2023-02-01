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
        /*Integer id = registrationModel.getId();
        Optional<CustomerEntity> customerEntity = this.customerRepository.findById(id);
        if (customerEntity==null){
            throw new CustomerNotFoundException();
        }*/

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

   /* @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteCustomer(@PathVariable RegistrationModel email) {
        String result = registrationService.deleteCustomerDetails(email);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
        }
    }*/

   /* @DeleteMapping("/deleteCustomer")
    public String deleteCustomer(@RequestBody RegistrationModel customerModel){
        this.registrationService.deleteCustomerDetails(customerModel);
        return "Customer deleted";
    }*/

    @DeleteMapping("/delete")
    public String deleteCustomerRecord(@RequestParam Integer custId) {
        this.customerRolesRepository.deleteByCustId(custId);
        this.registrationRepository.deleteById(custId);

        return "delete Successful!!";
    }



}

