package com.example.registrationOfCustomer.repository;

import com.example.registrationOfCustomer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository <CustomerEntity, Integer>{



    @Query("Select p from CustomerEntity p where p.emailAddress = :emailAddress")
    CustomerEntity findByEmail(String emailAddress);

    void deleteById(Integer id);
    void delete(CustomerEntity entity);

   /* void deleteByEmail (String emailAddress);*/


}
