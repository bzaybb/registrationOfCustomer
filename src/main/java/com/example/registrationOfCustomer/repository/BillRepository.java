package com.example.registrationOfCustomer.repository;

import com.example.registrationOfCustomer.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, Integer> {
    BillEntity findByCarType(String carType);
    BillEntity findByLocation(String location);

    BillEntity findByEmail(String emailAddress);
}
