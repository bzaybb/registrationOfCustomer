package com.example.registrationOfCustomer.service;

import com.example.registrationOfCustomer.entity.CustomerEntity;
import com.example.registrationOfCustomer.entity.CustomerRolesEntity;
import com.example.registrationOfCustomer.entity.LoginEntity;
import com.example.registrationOfCustomer.model.RegistrationModel;
import com.example.registrationOfCustomer.model.CustomerRolesModel;
import com.example.registrationOfCustomer.repository.CustomerRolesRepository;
import com.example.registrationOfCustomer.repository.LoginRepository;
import com.example.registrationOfCustomer.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

@Service
public class RegistrationService {

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private CustomerRolesRepository customerRolesRepository;

    public String saveData(RegistrationModel registrationModel) {
        CustomerEntity customerEntity = new CustomerEntity();
        LoginEntity loginEntity = new LoginEntity();
        customerEntity.setLoginType(registrationModel.getLoginType());
        customerEntity.setFirstName(registrationModel.getFirstName());
        customerEntity.setLastName(registrationModel.getLastName());
        //Storing Password in encrypted form.
        String encryptedPwd1 = "";
        if(registrationModel.getPassword() != null){
            encryptedPwd1 = this.bCryptPasswordEncoder.encode(registrationModel.getPassword());
            System.out.println("Encrypted PWD : " + encryptedPwd1);
        }

        //Login

        loginEntity.setLoginType(registrationModel.getLoginType());
        loginEntity.setEmailAddress(registrationModel.getEmailAddress());
        loginEntity.setPassword(encryptedPwd1);





        // setting login entity to the customer entity
        //loginEntity.setCustomerEntity(customerEntity);
        customerEntity.setLoginEntity(loginEntity);


        //email validation

                if(validateEmailAddress(registrationModel.getEmailAddress())){//calling validating method to check if true or false
                    customerEntity.setEmailAddress(registrationModel.getEmailAddress());
                }
                else{//if false
                    return "Email address is not correct please use @test.com";
                }
                //mobile number validation
        if(validateMobileNumber(registrationModel.getMobileNumber())){
            customerEntity.setMobileNumber(registrationModel.getMobileNumber());
        }
        else{
            return "Mobile number is not correct";
        }

//validate confirmPassword with password
        if(registrationModel.getPassword().equals(registrationModel.getConfirmPassword())){
            customerEntity.setConfirmPassword(encryptedPwd1);
        }
        else{
            return "Error: Passwords do not match.";
        }

        if(validatePassword(registrationModel.getPassword())) {
            customerEntity.setPassword(encryptedPwd1);


        }
        else{
            return "Password format not correct. A password is considered valid if all the following constraints are satisfied:\n" +
                    "\n" +
                    "It contains at least 8 characters and at most 20 characters.\n" +
                    "It contains at least one digit.\n" +
                    "It contains at least one upper case alphabet.\n" +
                    "It contains at least one lower case alphabet.\n" +
                    "It contains at least one special character which includes !@#$%&*()-+=^.\n" +
                    "It doesn’t contain any white space.";
        }



        customerEntity.setStatus(registrationModel.getStatus());



        try {
            registrationRepository.save(customerEntity);
            //loginRepository.save(loginEntity);
        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
        }
        List<CustomerRolesEntity> customerRolesEntityList = new ArrayList<>();
        List<CustomerRolesModel> customerRolesModels = registrationModel.getRole();
        for(CustomerRolesModel customerRolesModel: customerRolesModels){
            CustomerRolesEntity customerRolesEntity = new CustomerRolesEntity();
            customerRolesEntity.setRoleName(customerRolesModel.getRoleName());
            customerRolesEntity.setLoginEntity(loginEntity);
            customerRolesEntityList.add(customerRolesEntity);
        }
        try{
            customerRolesRepository.saveAll(customerRolesEntityList);
        } catch ( Exception e){
            System.err.println("Error Details ::" + e.getMessage());
        }
        return "success!!";
    }

    //Update logic
    public String updateCustomerDetails (RegistrationModel registrationModel) {
        CustomerEntity customerEntity = registrationRepository.findByEmail(registrationModel.getEmailAddress());
       // CustomerEntity customerEntity = null;
        if (customerEntity == null) {
            return "Error: Customer not found.";
        }
        customerEntity.setLoginType(registrationModel.getLoginType());
        customerEntity.setFirstName(registrationModel.getFirstName());
        customerEntity.setLastName(registrationModel.getLastName());
        customerEntity.setStatus(registrationModel.getStatus());


        //validate email address
        if (validateEmailAddress(registrationModel.getEmailAddress())) {
            customerEntity.setEmailAddress(registrationModel.getEmailAddress());
        } else {
            return "Email address is not correct please use @test.com";
        }



        //validate mobile number
        if (validateMobileNumber(registrationModel.getMobileNumber())) {
            customerEntity.setMobileNumber(registrationModel.getMobileNumber());
        } else {
            return "Mobile number is not correct";
        }

        try {
            registrationRepository.save(customerEntity);
        } catch (Exception e) {
            System.err.println("Error Details::" + e.getMessage());
        }


        return "Customer Details updated";
    }

    //Fetch Customer Details
    public CustomerEntity fetchCustomerDetails (String emailAddress) {
        CustomerEntity customerEntity = registrationRepository.findByEmail(emailAddress);
        return customerEntity;
    }

    //Validation Methods
private boolean validateEmailAddress(String emailAddress){
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[A-Za-z0-9.-]+$";
    Pattern p = Pattern.compile(regex);

    // If the password is empty
    // return false
    if (emailAddress == null) {
        return false;
    }

    // Pattern class contains matcher() method
    // to find matching between given password
    // and regular expression.
    Matcher m = p.matcher(emailAddress);

    // Return if the password
    // matched the ReGex
    return m.matches();

}
 private boolean validateMobileNumber(String mobileNumber){
        if(mobileNumber.matches("\\d{10}")){
            return true;
        }
        else
            return false;
 }
 private boolean validatePassword(String password){
     // Regex to check valid password.
     String regex = "^(?=.*[0-9])"
             + "(?=.*[a-z])(?=.*[A-Z])"
             + "(?=.*[@#$%^&+=_])"
             + "(?=\\S+$).{8,20}$";

     // Compile the ReGex
     Pattern p = Pattern.compile(regex);

     // If the password is empty
     // return false
     if (password == null) {
         return false;
     }

     // Pattern class contains matcher() method
     // to find matching between given password
     // and regular expression.
     Matcher m = p.matcher(password);

     // Return if the password
     // matched the ReGex
     return m.matches();

 }

  }





