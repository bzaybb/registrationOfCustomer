package com.example.registrationOfCustomer.controller;

import com.example.registrationOfCustomer.entity.BillEntity;
import com.example.registrationOfCustomer.model.BillModel;
import com.example.registrationOfCustomer.repository.BillRepository;
import com.example.registrationOfCustomer.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class BillController {
    @Autowired
    BillService billService;
    @Autowired
    BillRepository billRepository;

    @PostMapping("/saveBill")
    public void billDetails(@RequestBody BillModel billModel){
        this.billService.saveTrip(billModel);
    }

    @PutMapping("/update")
    public void updateBill(@RequestBody BillModel billModel){
        this.billService.updateBill(billModel);
    }

    @GetMapping("/fetch")
    public List<BillEntity> billDetails(@RequestParam String emailAddress){
        return
        this.billRepository.findByEmailAddress(emailAddress);
    }

    @DeleteMapping("/delete")
    public String deleteBill(@RequestParam int id){
        this.billRepository.deleteById(id);
        return "Success";
    }
}
