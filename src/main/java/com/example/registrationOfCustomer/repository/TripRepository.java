package com.example.registrationOfCustomer.repository;

import com.example.registrationOfCustomer.entity.DashboardEntity;
import com.example.registrationOfCustomer.entity.TripTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<TripTypeEntity,Integer> {
    TripTypeEntity findByTripType(String tripType);
    @Query("select t.id from TripTypeEntity t where t.tripType=:tripType")
    Integer findByTripTypeName(String tripType);
    TripTypeEntity findById(int id);
}
