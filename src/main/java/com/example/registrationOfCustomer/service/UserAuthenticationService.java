package com.example.registrationOfCustomer.service;

import com.example.registrationOfCustomer.entity.LoginEntity;
import com.example.registrationOfCustomer.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;

public class UserAuthenticationService implements UserDetailsService {
    @Autowired
    LoginRepository loginRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginEntity loginEntity = this.loginRepository.findByEmailAddress(username); //username is email for uor use case
        CustomerUserDetails customerUserDetails = new CustomerUserDetails(loginEntity);
        return customerUserDetails;
    }
}
