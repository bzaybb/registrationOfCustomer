package com.example.registrationOfCustomer.security;

import com.example.registrationOfCustomer.service.UserAuthenticationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@EnableWebSecurity
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserAuthenticationService userAuthenticationService(){
        return new UserAuthenticationService();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userAuthenticationService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Override
    @Transactional
    public void configure (AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception{
        webSecurity.ignoring()
                .antMatchers("/registration/customer");
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/dashboard/saveTripType").permitAll()
                .antMatchers(HttpMethod.GET, "/dashboard/testGetMethod").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/dashboard/updateBasePriceAndStatus").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/dashboard/delete").hasAnyAuthority("USER", "ADMIN")

                .antMatchers(HttpMethod.POST, "/customerChosen/saveCustomerTrip").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/customerChosen/customerDetailsByEmail").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/customerChosen/update").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/customerChosen/delete").hasAnyAuthority("USER", "ADMIN")

                .antMatchers(HttpMethod.POST, "/service/saveBill").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/service/fetch").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/service/update").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/service/delete").hasAnyAuthority("USER", "ADMIN")

                .antMatchers(HttpMethod.POST, "/registration/customer").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/registration/fetchCustomer").hasAuthority("USER")
                .antMatchers(HttpMethod.PUT, "/registration/updateCustomer").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/registration/delete").hasAnyAuthority("USER", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin().disable();
    }




}
