package com.example.registrationOfCustomer.repository;

import com.example.registrationOfCustomer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository <CustomerEntity, Integer>{

    @Query("Select id from CustomerEntity  where emailAddress = :emailAddress")
    Integer findByCustEmail(String emailAddress);

    @Query("Select p from CustomerEntity p where p.emailAddress = :emailAddress")
    CustomerEntity findByEmail(String emailAddress);

    //@Query("Select id from CustomerEntity  where email = :email")
        // to fetch vendor id and save into carTable
    //Integer findByCustEmail(String email); // find vendor id to save in car table

}
