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

    DashboardEntity findById(int id);
    List<DashboardEntity> findByTripType(TripTypeEntity tripTypeEntity);
    @Query("Select c from DashboardEntity c where c.carRegistration=:carRegistration and c.tripType.tripType=:tripType")
    DashboardEntity findByCarRegAndTrip(String carRegistration, String tripType);
}
