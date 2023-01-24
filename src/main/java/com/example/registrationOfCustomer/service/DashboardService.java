package com.example.registrationOfCustomer.service;

import com.example.registrationOfCustomer.entity.DashboardEntity;
import com.example.registrationOfCustomer.entity.TripTypeEntity;
import com.example.registrationOfCustomer.model.DashboardModel;
import com.example.registrationOfCustomer.model.TripTypeModel;
import com.example.registrationOfCustomer.repository.DashboardRepository;
import com.example.registrationOfCustomer.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DashboardService {

    @Autowired
    DashboardRepository dashboardRepository;
    @Autowired
    TripRepository tripRepository;
    DashboardEntity dashboardEntity = new DashboardEntity();
    DashboardModel dashboardModel;


    //while validation if i put list of object at same time it doesnot work
    //if i put null on 2 method then it doenot work it gives me one error
    //it checks one condition at time but also at same time trip type table data will be save either the condition fails
    public String saveTripType(TripTypeModel tripTypeModel) {
        List<DashboardModel> local = tripTypeModel.getLocal();
        List<DashboardModel> oneWay = tripTypeModel.getOneWay();
        List<DashboardModel> roundTrip = tripTypeModel.getRoundTrip();
        List<DashboardModel> airport = tripTypeModel.getAirport();
        System.out.println("going inside local");
        if (local != null) {
            TripTypeEntity tripTypeEntity = new TripTypeEntity();
            tripTypeEntity.setTripType("local");
            try {
                tripRepository.save(tripTypeEntity);

            } catch (Exception e) {
                System.err.println("Error Details ::" + e.getMessage());
            }
            //saving in dashboard
            for (DashboardModel dashboardModel1 : local) {
                DashboardEntity dashboardEntity1 = new DashboardEntity();
                dashboardEntity1.setImageUrl(dashboardModel1.getImageUrl());
                dashboardEntity1.setTripType(tripTypeEntity);

                //carType validation
                if(carTypeValidation(dashboardModel1.getCarType())) {
                    dashboardEntity1.setCarType(dashboardModel1.getCarType());
                }else {
                    return "carType cannot be null";

                }

                //carRegistrationValidation
                if(carRegistrationValidation(dashboardModel1.getCarRegistration())){
                dashboardEntity1.setCarRegistration(dashboardModel1.getCarRegistration());
                 }
                else {
                    return "car registration number is in correct";
                }

                //validation carModel
                if(carModelValidation(dashboardModel1.getCarModel())){
                dashboardEntity1.setCarModel(dashboardModel1.getCarModel());}
                else {
                    return "carModel cant be null";
                }
                dashboardEntity1.setStatus(dashboardModel1.getStatus());
                dashboardEntity1.setBasePrice(dashboardModel1.getBasePrice());
                dashboardEntity1.setCarACorNonAc(dashboardModel1.getCarACorNonAc());
                dashboardEntity1.setCarSeater(dashboardModel1.getCarSeater());
                dashboardEntity1.setBaggageCapacity(dashboardModel1.getBaggageCapacity());
                try {
                    dashboardRepository.save(dashboardEntity1);

                } catch (Exception e) {
                    System.err.println("Error Details ::" + e.getMessage());

                }


            }


        }else
        {
            System.out.println();
        }



        if ((oneWay != null)) {

            TripTypeEntity tripTypeEntity = new TripTypeEntity();
            tripTypeEntity.setTripType("oneway");
            try {
                tripRepository.save(tripTypeEntity);

            } catch (Exception e) {
                System.err.println("Error Details ::" + e.getMessage());
            }
            //saving in dashboard
            for (DashboardModel dashboardModel1 : oneWay) {
                DashboardEntity dashboardEntity1 = new DashboardEntity();
                dashboardEntity1.setImageUrl(dashboardModel1.getImageUrl());
                dashboardEntity1.setTripType(tripTypeEntity);
                //carType validation
                if(carTypeValidation(dashboardModel1.getCarType())) {
                    dashboardEntity1.setCarType(dashboardModel1.getCarType());
                }else {
                    return "carType cannot be null";

                }
                //carRegistrationValidation
                if(carRegistrationValidation(dashboardModel1.getCarRegistration())){
                    dashboardEntity1.setCarRegistration(dashboardModel1.getCarRegistration());
                }
                else {
                    return "car registration number is in correct";
                }
                //validation carModel
                if(carModelValidation(dashboardModel1.getCarModel())){
                    dashboardEntity1.setCarModel(dashboardModel1.getCarModel());}
                else {
                    return "carModel cant be null";
                }
                dashboardEntity1.setStatus(dashboardModel1.getStatus());
                dashboardEntity1.setBasePrice(dashboardModel1.getBasePrice());
                dashboardEntity1.setCarModel(dashboardModel1.getCarModel());
                dashboardEntity1.setCarACorNonAc(dashboardModel1.getCarACorNonAc());
                dashboardEntity1.setCarSeater(dashboardModel1.getCarSeater());
                dashboardEntity1.setBaggageCapacity(dashboardModel1.getBaggageCapacity());
                try {
                    dashboardRepository.save(dashboardEntity1);

                } catch (Exception e) {
                    System.err.println("Error Details ::" + e.getMessage());

                }

            }


        }




        if ((roundTrip != null)) {

            TripTypeEntity tripTypeEntity = new TripTypeEntity();
            tripTypeEntity.setTripType("roundTrip");
            try {
                tripRepository.save(tripTypeEntity);

            } catch (Exception e) {
                System.err.println("Error Details ::" + e.getMessage());
            }
            //saving in dashboard
            for (DashboardModel dashboardModel1 : roundTrip) {
                DashboardEntity dashboardEntity1 = new DashboardEntity();
                dashboardEntity1.setImageUrl(dashboardModel1.getImageUrl());
                dashboardEntity1.setTripType(tripTypeEntity);
                //carType validation
                if(carTypeValidation(dashboardModel1.getCarType())) {
                    dashboardEntity1.setCarType(dashboardModel1.getCarType());
                }else {
                    return "carType cannot be null";

                }
                //carRegistrationValidation
                if(carRegistrationValidation(dashboardModel1.getCarRegistration())){
                    dashboardEntity1.setCarRegistration(dashboardModel1.getCarRegistration());
                }
                else {
                    return "car registration number is in correct";
                }
                //validation carModel
                if(carModelValidation(dashboardModel1.getCarModel())){
                    dashboardEntity1.setCarModel(dashboardModel1.getCarModel());}
                else {
                    return "carModel cant be null";
                }
                dashboardEntity1.setStatus(dashboardModel1.getStatus());
                dashboardEntity1.setBasePrice(dashboardModel1.getBasePrice());
                dashboardEntity1.setCarACorNonAc(dashboardModel1.getCarACorNonAc());
                dashboardEntity1.setCarSeater(dashboardModel1.getCarSeater());
                dashboardEntity1.setBaggageCapacity(dashboardModel1.getBaggageCapacity());
                try {
                    dashboardRepository.save(dashboardEntity1);

                } catch (Exception e) {
                    System.err.println("Error Details ::" + e.getMessage());

                }

            }


        }



        if ((airport != null)) {

            TripTypeEntity tripTypeEntity = new TripTypeEntity();
            tripTypeEntity.setTripType("airport");
            try {
                tripRepository.save(tripTypeEntity);

            } catch (Exception e) {
                System.err.println("Error Details ::" + e.getMessage());
            }
            //saving in dashboard
            for (DashboardModel dashboardModel1 : airport) {
                DashboardEntity dashboardEntity1 = new DashboardEntity();
                dashboardEntity1.setImageUrl(dashboardModel1.getImageUrl());
                dashboardEntity1.setTripType(tripTypeEntity);

                //carType validation
                if(carTypeValidation(dashboardModel1.getCarType())) {
                    dashboardEntity1.setCarType(dashboardModel1.getCarType());
                }else {
                    return "carType cannot be null";

                }
                //carRegistrationValidation
                if(carRegistrationValidation(dashboardModel1.getCarRegistration())){
                    dashboardEntity1.setCarRegistration(dashboardModel1.getCarRegistration());
                }
                else {
                    return "car registration number is in correct";
                }
                //validation carModel
                if(carModelValidation(dashboardModel1.getCarModel())){
                    dashboardEntity1.setCarModel(dashboardModel1.getCarModel());}
                else {
                    return "carModel cant be null";
                }

                dashboardEntity1.setStatus(dashboardModel1.getStatus());
                dashboardEntity1.setBasePrice(dashboardModel1.getBasePrice());
                dashboardEntity1.setCarACorNonAc(dashboardModel1.getCarACorNonAc());
                dashboardEntity1.setCarSeater(dashboardModel1.getCarSeater());
                dashboardEntity1.setBaggageCapacity(dashboardModel1.getBaggageCapacity());
                try {
                    dashboardRepository.save(dashboardEntity1);

                } catch (Exception e) {
                    System.err.println("Error Details ::" + e.getMessage());

                }

            }


        }


        return  "saved in database";
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

    public List<DashboardModel> fetchRecords(String tripType) {
        TripTypeEntity tripTypeEntity = tripRepository.findByTripType(tripType);
        List<DashboardEntity> dashboardEntity= this.dashboardRepository.findByTripType(tripTypeEntity);
        List<DashboardModel> dashboardModel = new ArrayList<>();
            if (dashboardEntity != null) {
                for (DashboardEntity dash : dashboardEntity) {
                    DashboardModel dashboardModel1 = new DashboardModel();

                    dashboardModel1.setCarModel(dash.getCarModel());
                    dashboardModel1.setStatus(dash.getStatus());
                    dashboardModel1.setCarType(dash.getCarType());
                    dashboardModel1.setBasePrice(dash.getBasePrice());
                    dashboardModel1.setBaggageCapacity(dash.getBaggageCapacity());
                    dashboardModel1.setImageUrl(dash.getImageUrl());
                    dashboardModel1.setCarRegistration(dash.getCarRegistration());
                    dashboardModel1.setCarACorNonAc(dash.getCarACorNonAc());
                    dashboardModel1.setCarSeater(dash.getCarSeater());
                    dashboardModel.add(dashboardModel1);

                }
            }
            return dashboardModel;

    }

//    public String updateDetail(Integer id, int basePrice,String status) {
public String updateDetail(Integer id,DashboardModel dashboardModel) {

    // DashboardEntity dashboardEntity2 = new DashboardEntity();
        //find an entity by id
      DashboardEntity dashboardEntity1 = dashboardRepository.findById(id).get();
       // DashboardModel dashboardModel1 = new DashboardModel();
      //update entity information
        dashboardEntity1.setBasePrice(dashboardModel.getBasePrice());
        dashboardEntity1.setStatus(dashboardModel.getStatus());

        //save
        dashboardRepository.save(dashboardEntity1);

        return  "update";
    }
}

