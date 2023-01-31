package com.example.registrationOfCustomer.repository;

import com.example.registrationOfCustomer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository <CustomerEntity, Integer>{
    @Query("Select c.id from CustomerEntity c where c.emailAddress = :emailAddress")// to fetch customer id and save into carTable
    Integer findByEmail(String emailAddress); // find cust id to save in car table



}
