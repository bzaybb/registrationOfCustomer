package com.example.registrationOfCustomer.service;

import com.example.registrationOfCustomer.entity.BillEntity;
import com.example.registrationOfCustomer.model.BillModel;
import com.example.registrationOfCustomer.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
     //   billEntity.setCustomerEntity(billModel.getCustomerEntity());
        try {
            billRepository.save(billEntity);
        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
        }
        return "successful billing!!";
    }

    public BillModel fetchrecords(String emailAddress) {

        BillModel billModel = new BillModel();
       // BillEntity billEntity = billRepository.findById(id);
        BillEntity billEntity = this.billRepository.findByEmail(emailAddress);

        billModel.setCarType(billEntity.getCarType());
        billModel.setCarModel(billEntity.getCarModel());
        billModel.setDurationHrs(billEntity.getDurationHrs());
        billModel.setTotalPrice(billEntity.getTotalPrice());
        billModel.setTripType(billEntity.getTripType());
        billModel.setLocation(billEntity.getLocation());
        billRepository.findByCarType(emailAddress);
        return billModel;
    }

    public String updateBillInfo(Integer id, BillModel billModel) {
        BillEntity billEntity1 = billRepository.findById(id).get();
        //BillEntity billEntity1 = new BillEntity();
        billEntity1.setCarType(billModel.getCarType());
        billEntity1.setCarModel(billModel.getCarModel());
        billEntity1.setDurationHrs(billModel.getDurationHrs());
        billEntity1.setTotalPrice(billModel.getTotalPrice());
        billEntity1.setTripType(billModel.getTripType());
        billEntity1.setLocation(billModel.getLocation());
        billRepository.save(billEntity1);
        return "very good";
    }

    public String deletebyId(Integer id) {
        billRepository.deleteById(id);
        return "deleting";
    }

}
