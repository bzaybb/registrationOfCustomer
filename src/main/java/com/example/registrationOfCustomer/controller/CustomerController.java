package com.example.registrationOfCustomer.controller;

import com.example.registrationOfCustomer.model.CustomerModel;
import com.example.registrationOfCustomer.repository.CustomerRepository;
import com.example.registrationOfCustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/customer")
    public String customer(@RequestBody CustomerModel customerModel) {
        this.customerService.saveData(customerModel);
        return "Customer registration success";
    }

    @PutMapping("/updateCustomer")
    public String updateCustomer(@RequestBody CustomerModel customerModel) {
        /*Integer id = customerModel.getId();
        Optional<CustomerEntity> customerEntity = this.customerRepository.findById(id);
        if (customerEntity==null){
            throw new CustomerNotFoundException();
        }*/

        this.customerService.updateCustomerDetails(customerModel);
        return "Customer Detail is updated";
    }

    @GetMapping("/fecthCustomer")
    public CustomerModel fetchCustomer(@RequestBody CustomerModel customerModel){

        CustomerModel customerModel1 = this.customerService.fetchCustomerDetails(customerModel);
        return customerModel1;
    }

   /* @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteCustomer(@PathVariable CustomerModel email) {
        String result = customerService.deleteCustomerDetails(email);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
        }
    }*/

   /* @DeleteMapping("/deleteCustomer")
    public String deleteCustomer(@RequestBody CustomerModel customerModel){
        this.customerService.deleteCustomerDetails(customerModel);
        return "Customer deleted";
    }*/




}

