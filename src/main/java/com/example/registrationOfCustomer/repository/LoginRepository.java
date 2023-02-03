package com.example.registrationOfCustomer.repository;

import com.example.registrationOfCustomer.entity.CustomerEntity;
import com.example.registrationOfCustomer.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {

    @Query("Delete from LoginEntity l where l.emailAddress = :emailAddress")
    void deleteByEmail(String emailAddress);

    LoginEntity findByEmailAddress (String emailAddress);

    LoginEntity findById(int id);


}
