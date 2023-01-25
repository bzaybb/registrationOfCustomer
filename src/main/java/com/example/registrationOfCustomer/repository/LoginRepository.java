package com.example.registrationOfCustomer.repository;

import com.example.registrationOfCustomer.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {


}
