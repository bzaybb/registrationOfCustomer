package com.example.registrationOfCustomer.controller;

import com.example.registrationOfCustomer.model.RegistrationModel;
import com.example.registrationOfCustomer.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;
    @PostMapping("/customer")
    public String customer (@RequestBody RegistrationModel registrationModel){
      this.registrationService.saveData(registrationModel);
      return "Customer registration success";

    }


}

