package com.example.registrationOfCustomer.service;

import com.example.registrationOfCustomer.entity.CustomerRolesEntity;
import com.example.registrationOfCustomer.entity.LoginEntity;
import com.example.registrationOfCustomer.repository.CustomerRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerUserDetails implements UserDetails {

    private LoginEntity loginEntity;
    private CustomerRolesRepository customerRolesRepository;
    public CustomerUserDetails(LoginEntity loginEntity, CustomerRolesRepository customerRolesRepository){
        this.loginEntity=loginEntity;
        this.customerRolesRepository=customerRolesRepository;
    }

<<<<<<< HEAD


=======
>>>>>>> development/TEAM-B-FINAL
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<CustomerRolesEntity> customerRolesEntityList = null;
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        try{
            customerRolesEntityList = this.customerRolesRepository.findByLoginEntity(this.loginEntity);
            for (CustomerRolesEntity roles: customerRolesEntityList){
                authorities.add(new SimpleGrantedAuthority((roles.getRoleName())));
            }

        }
        catch (Exception e){
            e.getMessage();
        }


        return authorities;
    }

    @Override
    public String getPassword() {
        return this.loginEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return this.loginEntity.getEmailAddress();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
//test