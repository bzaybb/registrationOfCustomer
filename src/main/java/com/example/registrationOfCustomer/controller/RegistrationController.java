package com.example.registrationOfCustomer.controller;

import com.example.registrationOfCustomer.model.RegistrationModel;
import com.example.registrationOfCustomer.repository.CustomerRolesRepository;
import com.example.registrationOfCustomer.repository.LoginRepository;
import com.example.registrationOfCustomer.repository.RegistrationRepository;
import com.example.registrationOfCustomer.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;

    @Autowired
    LoginRepository loginRepository;

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

    @GetMapping("/fecthCustomer")
    public RegistrationModel fetchCustomer(@RequestBody RegistrationModel registrationModel){

        RegistrationModel registrationModel1 = this.registrationService.fetchCustomerDetails(registrationModel);
        return registrationModel1;
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
        //this.loginRepository.deleteById(custId);

        //this.registrationService.deleteCustomerInfo(custId);

        return "delete Successful!!";
    }



}

