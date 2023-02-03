package com.example.registrationOfCustomer.service;

import com.example.registrationOfCustomer.entity.*;
import com.example.registrationOfCustomer.model.BillModel;
import com.example.registrationOfCustomer.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    @Autowired
    BillRepository billRepository;
    @Autowired
    DashboardRepository dashboardRepository;
    @Autowired
    RegistrationRepository registrationRepository;
    @Autowired
    TripRepository tripRepository;

    public String saveTrip(BillModel billModel){
        BillEntity billEntity = new BillEntity();

        billEntity.setLocation(billModel.getLocation());
        billEntity.setCarType(billModel.getCarType());
        billEntity.setTripType(billModel.getTripType());
        billEntity.setCarRegistration(billModel.getCarRegistration());
        billEntity.setDurationInHours(billModel.getDurationInHours());
        billEntity.setTotalPrice(billModel.getTotalPrice());

        CustomerEntity customerEntity = registrationRepository.findById(billModel.getCustId());
        billEntity.setCustomerEntity(customerEntity);
        billEntity.setEmailAddress(customerEntity.getEmailAddress());

        DashboardEntity dashboardEntity = dashboardRepository
                .findByCarRegAndTrip(billModel.getCarRegistration(), billModel.getTripType());
        billEntity.setDashboardEntity(dashboardEntity);


        try {
            this.billRepository.save(billEntity);
        } catch (Exception e) {
            System.err.println("Error Details::" + e.getMessage());
        }

        return "Success";

    }
    public void updateBill(BillModel billModel) {
        BillEntity billEntity = billRepository.findById(billModel.getBillId());
        DashboardEntity dashboardEntity = dashboardRepository
                .findByCarRegAndTrip(billModel.getCarRegistration(), billModel.getTripType());
        billEntity.setDashboardEntity(dashboardEntity);
        billEntity.setLocation(billModel.getLocation());
        billEntity.setTripType(billModel.getTripType());
        billEntity.setDurationInHours(billModel.getDurationInHours());
        billEntity.setCarType(billModel.getCarType());
        billEntity.setCarRegistration(billModel.getCarRegistration());

        this.billRepository.save(billEntity);

    }
}
