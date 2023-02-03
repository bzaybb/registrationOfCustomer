package com.example.registrationOfCustomer.repository;

import com.example.registrationOfCustomer.entity.BillEntity;
import com.example.registrationOfCustomer.entity.CustomerEntity;
import com.example.registrationOfCustomer.entity.DashboardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<BillEntity, Integer> {
    BillEntity findById(int id);

    List<BillEntity> findByEmailAddress(String emailAddress);
}
