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

    @GetMapping("/getting/{emailAddress}")
    public BillModel findData(@PathVariable String emailAddress, @RequestBody BillModel billModel){
       this.billService.fetchrecords(emailAddress);
       return billModel;
    }
    @PutMapping("/updating/{id}")
    public String updateBillInfo(@PathVariable Integer id, @RequestBody BillModel billModel){
        this.billService.updateBillInfo(id, billModel);
        return "updating in the table";

    }

    @DeleteMapping("/deleting/{id}")
    public String deleteBillInfo(@PathVariable int id){
        this.billService.deletebyId(id);
        return "Deleting from table";

    }
}
