package com.example.registrationOfCustomer.repository;

import com.example.registrationOfCustomer.entity.DashboardEntity;
import com.example.registrationOfCustomer.entity.TripTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DashboardRepository extends JpaRepository<DashboardEntity,Integer> {

//    @Query("SELECT p FROM DashboardEntity p where p.carModel=:carModel")
//    DashboardEntity findByCarModel(String carModel);
//@Query("SELECT p FROM DashboardEntity p where p.tripType =:tripType")
List<DashboardEntity> findByTripType(TripTypeEntity tripTypeEntity);

Optional<DashboardEntity> findById(Integer id);



}
