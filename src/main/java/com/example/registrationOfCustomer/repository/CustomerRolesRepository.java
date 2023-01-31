package com.example.registrationOfCustomer.repository;

import com.example.registrationOfCustomer.entity.CustomerRolesEntity;
import com.example.registrationOfCustomer.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRolesRepository extends JpaRepository<CustomerRolesEntity, Integer> {

    List<CustomerRolesEntity> findByLoginEntity(LoginEntity loginEntity);
}
