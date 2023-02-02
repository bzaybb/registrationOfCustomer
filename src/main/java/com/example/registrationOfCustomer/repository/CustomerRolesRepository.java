package com.example.registrationOfCustomer.repository;

import com.example.registrationOfCustomer.entity.CustomerRolesEntity;
import com.example.registrationOfCustomer.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerRolesRepository extends JpaRepository<CustomerRolesEntity, Integer> {

    List<CustomerRolesEntity> findByLoginEntity(LoginEntity loginEntity);

@Transactional
@Modifying
    @Query("Delete from CustomerRolesEntity where loginEntity.id =:custId")
    void deleteByCustId(Integer custId);
}
