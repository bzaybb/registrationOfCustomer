package com.example.registrationOfCustomer.repository;

import com.example.registrationOfCustomer.entity.DashboardEntity;
import com.example.registrationOfCustomer.entity.TripTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DashboardRepository extends JpaRepository<DashboardEntity,Integer> {

//    @Query("SELECT p FROM DashboardEntity p where p.carModel=:carModel")
//    DashboardEntity findByCarModel(String carModel);
//@Query("SELECT p FROM DashboardEntity p where p.tripType =:tripType")
List<DashboardEntity> findByTripType(TripTypeEntity tripTypeEntity);

//DashboardEntity findById(DashboardEntity dashboardEntity);



}
