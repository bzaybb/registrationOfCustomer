package com.example.registrationOfCustomer.repository;

import com.example.registrationOfCustomer.entity.DashboardEntity;
import com.example.registrationOfCustomer.entity.TripTypeEntity;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface DashboardRepository extends JpaRepository<DashboardEntity,Integer> {

//    @Query("SELECT p FROM DashboardEntity p where p.carModel=:carModel")
//    DashboardEntity findByCarModel(String carModel);
//@Query("SELECT p FROM DashboardEntity p where p.tripType =:tripType")
List<DashboardEntity> findByTripType(TripTypeEntity tripTypeEntity);

//@Query("select id  from DashboardEntity d where d.tripType:tripType")
//Integer findByTripType(String tripType); // find cust id to save in car table

   // List<DashboardEntity> findByCustomerId(Integer customerId);


//void deleteById(Integer id);

//    @Transactional
//    @Modifying
//    @Query("SELECT from CustomerChosenTrip where customerId=:customerId AND carRegistration in(:carRegistrationIds)")
//    void deleteAllByVendorIdAndCarRegistration(Integer customerId,List<String> carRegistrationIds);



}
