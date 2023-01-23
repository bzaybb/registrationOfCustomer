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

@Service
public class DashboardService {

    @Autowired
    DashboardRepository dashboardRepository;
    @Autowired
    TripRepository tripRepository;
    DashboardEntity dashboardEntity = new DashboardEntity();
    DashboardModel dashboardModel;

    public String saveDashBoardData(DashboardModel dashboardModel) {

        TripTypeEntity tripTypeEntity = new TripTypeEntity();
        dashboardEntity.setCarType(dashboardModel.getCarType());
        dashboardEntity.setCarModel(dashboardModel.getCarModel());
        dashboardEntity.setCarSeater(dashboardModel.getCarSeater());
        dashboardEntity.setBaggageCapacity(dashboardModel.getBaggageCapacity());
        dashboardEntity.setCarRegistration(dashboardModel.getCarRegistration());
        dashboardEntity.setCarACorNonAc(dashboardModel.getCarACorNonAc());
        dashboardEntity.setBasePrice(dashboardModel.getBasePrice());
        dashboardEntity.setStatus(dashboardModel.getStatus());
        dashboardEntity.setImageUrl(dashboardModel.getImageUrl());

        try {
            dashboardRepository.save(dashboardEntity);
        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
        }


        return "sucessfull";
    }


    public String saveTripType(TripTypeModel tripTypeModel) {
        List<DashboardModel> local = tripTypeModel.getLocal();
        List<DashboardModel> oneWay = tripTypeModel.getOneWay();
        List<DashboardModel> roundTrip = tripTypeModel.getRoundTrip();
        List<DashboardModel> airport = tripTypeModel.getAirport();
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
                dashboardEntity1.setCarType(dashboardModel1.getCarType());
                dashboardEntity1.setStatus(dashboardModel1.getStatus());
                dashboardEntity1.setBasePrice(dashboardModel1.getBasePrice());
                dashboardEntity1.setCarRegistration(dashboardModel1.getCarRegistration());
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
                dashboardEntity1.setCarType(dashboardModel1.getCarType());
                dashboardEntity1.setStatus(dashboardModel1.getStatus());
                dashboardEntity1.setBasePrice(dashboardModel1.getBasePrice());
                dashboardEntity1.setCarRegistration(dashboardModel1.getCarRegistration());
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
                dashboardEntity1.setCarType(dashboardModel1.getCarType());
                dashboardEntity1.setStatus(dashboardModel1.getStatus());
                dashboardEntity1.setBasePrice(dashboardModel1.getBasePrice());
                dashboardEntity1.setCarRegistration(dashboardModel1.getCarRegistration());
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
                dashboardEntity1.setCarType(dashboardModel1.getCarType());
                dashboardEntity1.setStatus(dashboardModel1.getStatus());
                dashboardEntity1.setBasePrice(dashboardModel1.getBasePrice());
                dashboardEntity1.setCarRegistration(dashboardModel1.getCarRegistration());
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


        return "sucessfull";
    }

    public List<DashboardModel> fetchRecords(String tripType) {
       // TripTypeEntity tripTypeEntity = this.dashboardRepository.findByTripType(tripType);
        //TripTypeModel tripTypeModel = new TripTypeModel();
        TripTypeEntity tripTypeEntity = tripRepository.findByTripType(tripType);
        List<DashboardEntity> dashboardEntity= this.dashboardRepository.findByTripType(tripTypeEntity);
        List<DashboardModel> dashboardModel = new ArrayList<>();
//        if (tripTypeModel.getLocal() != null) {
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


            //    public String saveDashBoardData(List<DashboardModel> dashboardModels) {
//        for(DashboardModel dashboardModel:dashboardModels) {
//            dashboardEntity.setCarType(dashboardModel.getCarType());
//            dashboardEntity.setCarModel(dashboardModel.getCarModel());
//            dashboardEntity.setCarSeater(dashboardModel.getCarSeater());
//            dashboardEntity.setBaggageCapacity(dashboardModel.getBaggageCapacity());
//            dashboardEntity.setCarRegistration(dashboardModel.getCarRegistration());
//            dashboardEntity.setCarACorNonAc(dashboardModel.getCarACorNonAc());
//            dashboardEntity.setBasePrice(dashboardModel.getBasePrice());
//            dashboardEntity.setStatus(dashboardModel.getStatus());
//            dashboardEntity.setImageUrl(dashboardModel.getImageUrl());
//
//            try {
//                dashboardRepository.save(dashboardEntity);
//            } catch (Exception e) {
//                System.err.println("Error Details ::" + e.getMessage());
//            }
//        }
//
//
//        return "sucessfull";


            // }




    }
}

