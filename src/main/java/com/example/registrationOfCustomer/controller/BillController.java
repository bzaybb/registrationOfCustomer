package com.example.registrationOfCustomer.controller;

import com.example.registrationOfCustomer.model.BillModel;
import com.example.registrationOfCustomer.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/billController")
public class BillController {
    @Autowired
    BillService billService;
    @PostMapping("/uploading")
    public String getData (@RequestBody BillModel billModel) {
        this.billService.saveData(billModel);
        return "Billing Successful !!!";
    }

}
