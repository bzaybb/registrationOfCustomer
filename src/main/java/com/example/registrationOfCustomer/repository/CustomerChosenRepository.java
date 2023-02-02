package com.example.registrationOfCustomer.repository;

import com.example.registrationOfCustomer.entity.CustomerChosenTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerChosenRepository extends JpaRepository<CustomerChosenTrip,Integer> {
//    @Query("Select id from CustomerEntity  where emailAddress = :emailAddress")// using email to find customer id to fetch all triptype
   List<CustomerChosenTrip> findByCustomerId(Integer customerId);

   //List<CustomerChosenTrip> findByCustomerIdAndRegistrationIn(Integer customerId,List<String> carRegistration);

   @Transactional
   @Modifying
   @Query("Delete from CustomerChosenTrip where customerId=:customerId AND carRegistration in(:carRegistrationIds)")
   void deleteAllByCustomerIdAndCarRegistration(Integer customerId,List<String> carRegistrationIds);

   @Query("SELECT c from CustomerChosenTrip c where c.customerId=:customerId And c.carRegistration =:carRegistration ")
   CustomerChosenTrip findModelById(Integer customerId, String carRegistration);
}
