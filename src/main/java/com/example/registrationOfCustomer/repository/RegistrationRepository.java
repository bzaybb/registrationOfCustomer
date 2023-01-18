package com.example.registrationOfCustomer.repository;

import com.example.registrationOfCustomer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository <CustomerEntity, Integer>{


}
