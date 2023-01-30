package com.example.registrationOfCustomer.repository;

import com.example.registrationOfCustomer.entity.CustomerRolesEntity;
import com.example.registrationOfCustomer.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRolesRepository extends JpaRepository<LoginEntity, Integer> {

    List<CustomerRolesEntity> findByEmailAddress(LoginEntity loginEntity);
}
