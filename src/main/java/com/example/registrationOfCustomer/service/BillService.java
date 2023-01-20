package com.example.registrationOfCustomer.service;

import com.example.registrationOfCustomer.entity.BillEntity;
import com.example.registrationOfCustomer.model.BillModel;
import com.example.registrationOfCustomer.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    @Autowired
    private BillRepository billRepository;
    public String saveData(BillModel billModel) {
        BillEntity billEntity = new BillEntity();

        billEntity.setCarType(billModel.getCarType());
        billEntity.setCarModel(billModel.getCarModel());
        billEntity.setDurationHrs(billModel.getDurationHrs());
        billEntity.setTotalPrice(billModel.getTotalPrice());
        billEntity.setTripType(billModel.getTripType());
        billEntity.setLocation(billModel.getLocation());

        try {
            billRepository.save(billEntity);
        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
        }
        return "successful billing!!";
    }
}
