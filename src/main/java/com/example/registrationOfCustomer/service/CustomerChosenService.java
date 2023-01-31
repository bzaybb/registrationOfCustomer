package com.example.registrationOfCustomer.service;


import com.example.registrationOfCustomer.entity.CustomerChosenTrip;
import com.example.registrationOfCustomer.exception.CarTypeOrCarModelNotFoundException;
import com.example.registrationOfCustomer.exception.RegistrationNotFoundException;
import com.example.registrationOfCustomer.model.CustomerChosenModel;
import com.example.registrationOfCustomer.repository.CustomerChosenRepository;
import com.example.registrationOfCustomer.repository.DashboardRepository;
import com.example.registrationOfCustomer.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CustomerChosenService {

    @Autowired
    CustomerChosenRepository customerChosenRepository;

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    DashboardRepository dashboardRepository;

    public String customerChosenTripType(CustomerChosenModel customerChosenModel) {
        CustomerChosenTrip customerChosenTrip = new CustomerChosenTrip();
            Integer customerId = registrationRepository.findByEmail("bk@test.com");
            List<CustomerChosenTrip> customerChosenTrips= this.customerChosenRepository.findByCustomerId(customerId);

                customerChosenTrip.setTripType(customerChosenModel.getTripType());

                if (carModelValidation(customerChosenModel.getCarModel())) {
                    customerChosenTrip.setCarModel(customerChosenModel.getCarModel());
                } else {
                    throw new CarTypeOrCarModelNotFoundException();
                }

                if (carTypeValidation(customerChosenModel.getCarType())) {
                    customerChosenTrip.setCarType(customerChosenModel.getCarType());
                } else {
                    throw new CarTypeOrCarModelNotFoundException();
                }

                customerChosenTrip.setCarSeater(customerChosenModel.getCarSeater());
                customerChosenTrip.setBaggageCapacity(customerChosenModel.getBaggageCapacity());
                //carRegistrationValidation
                if (carRegistrationValidation(customerChosenModel.getCarRegistration())) {
                    customerChosenTrip.setCarRegistration(customerChosenModel.getCarRegistration());
                } else {
                    throw new RegistrationNotFoundException();
                }

                customerChosenTrip.setCarACorNonAc(customerChosenModel.getCarACorNonAc());
                customerChosenTrip.setBasePrice(customerChosenModel.getBasePrice());
                if (!customerChosenModel.getStatus().equals("Available")) {
                    throw new IllegalArgumentException("Only available car can be avail");
                }else {
                    customerChosenTrip.setStatus(customerChosenModel.getStatus());
                }
                customerChosenTrip.setImageUrl(customerChosenModel.getImageUrl());


                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date startDate = new Date();
                Date endDate = new Date();
                try{
                    startDate = simpleDateFormat.parse(customerChosenModel.getStartDate());
                    endDate = simpleDateFormat.parse(customerChosenModel.getEndDate());

                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                Calendar startDateCalender = Calendar.getInstance();
                startDateCalender.setTime(startDate);

                Calendar endDateCalender = Calendar.getInstance();
                endDateCalender.setTime(endDate);

                if (startDate.after(endDate)) {
                    throw new IllegalArgumentException("Start date should be less than end date, please try again!!");
                }else {
                    customerChosenTrip.setStartDate(startDateCalender);
                    customerChosenTrip.setEndDate(endDateCalender);
                }
                customerChosenTrip.setCustomerId(customerChosenModel.getCustomerId());

                try {
                    customerChosenRepository.save(customerChosenTrip);
                } catch (Exception e) {
                    System.err.println("Error Details ::" + e.getMessage());
                }
                return "success!!";
            }




    public  boolean carTypeValidation(String carType){
        if(carType!=null && !carType.isEmpty()){
            return true;
        }
        return false;
    }

    public boolean carModelValidation(String carModel){
        if(carModel!=null && !carModel.isEmpty()){
            return true;
        }
        return false;
    }

    public  boolean carRegistrationValidation(String carRegistration){
        if(carRegistration!=null &&!carRegistration.isEmpty()&& carRegistration.length()==8
                && Character.isAlphabetic(carRegistration.charAt(0))&&
                Character.isAlphabetic(carRegistration.charAt(1))){
            return  true;
        }
        return false;
    }

    public List<CustomerChosenModel> fetchCustomerChosen(String emailAddress) {
        Integer customerId = registrationRepository.findByEmail("kk@test.com");
         List<CustomerChosenTrip> customerChosenTrips= this.customerChosenRepository.findByCustomerId(customerId);
         List<CustomerChosenModel> customerChosenModels = new ArrayList<>();
        if (customerChosenTrips != null) {
            for (CustomerChosenTrip customerChosenTrip : customerChosenTrips) {
                CustomerChosenModel customerChosenModel1= new CustomerChosenModel();

                customerChosenModel1.setCarModel(customerChosenTrip.getCarModel());
                customerChosenModel1.setStatus(customerChosenTrip.getStatus());
                customerChosenModel1.setCarType(customerChosenTrip.getCarType());
                customerChosenModel1.setBasePrice(customerChosenTrip.getBasePrice());
                customerChosenModel1.setBaggageCapacity(customerChosenTrip.getBaggageCapacity());
                customerChosenModel1.setImageUrl(customerChosenTrip.getImageUrl());
                customerChosenModel1.setCarRegistration(customerChosenTrip.getCarRegistration());
                customerChosenModel1.setCarACorNonAc(customerChosenTrip.getCarACorNonAc());
                customerChosenModel1.setCarSeater(customerChosenTrip.getCarSeater());
                customerChosenModel1.setCustomerId(customerChosenTrip.getCustomerId());
                customerChosenModel1.setTripType(customerChosenTrip.getTripType());
                //changing calender to date time
                Calendar calender = customerChosenTrip.getStartDate();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date date = calender.getTime();
                 String formattedDate = formatter.format(date);
                customerChosenModel1.setStartDate(formattedDate);

                //changing calender to date type 
                Calendar calender1 = customerChosenTrip.getEndDate();
                SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date date1 = calender.getTime();
                String formattedDate1 = formatter.format(date);
                customerChosenModel1.setEndDate((formattedDate1));
                customerChosenModels.add(customerChosenModel1);


            }
        }
        return customerChosenModels;

    }

    public String updateCustomerChosen(CustomerChosenModel customerChosenModel ) {
        Integer customerId= this.registrationRepository.findByEmail("bk@test.com");

        CustomerChosenTrip customerChosenTrip = this.customerChosenRepository.findModelById(customerId,customerChosenModel.getCarRegistration());
        customerChosenTrip.setTripType(customerChosenModel.getTripType());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date startDate = new Date();
        Date endDate = new Date();
        try{
            startDate = simpleDateFormat.parse(customerChosenModel.getStartDate());
            endDate = simpleDateFormat.parse(customerChosenModel.getEndDate());

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Calendar startDateCalender = Calendar.getInstance();
        startDateCalender.setTime(startDate);

        Calendar endDateCalender = Calendar.getInstance();
        endDateCalender.setTime(endDate);
        customerChosenTrip.setStartDate(startDateCalender);
        customerChosenTrip.setEndDate(endDateCalender);
        customerChosenTrip.setBaggageCapacity(customerChosenModel.getBaggageCapacity());
        customerChosenTrip.setCarRegistration(customerChosenModel.getCarRegistration());

        this.customerChosenRepository.save(customerChosenTrip);
        return "updated";
    }

    public String deleteAll(List<String> carRegistration) {

        Integer customerId= registrationRepository.findByEmail("bk@test.com");
        try{
            customerChosenRepository.deleteAllByCustomerIdAndCarRegistration(customerId,carRegistration);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return "deleted";
    }
}

