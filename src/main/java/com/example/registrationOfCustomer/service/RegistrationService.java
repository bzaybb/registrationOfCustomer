package com.example.registrationOfCustomer.service;

import com.example.registrationOfCustomer.entity.CustomerEntity;
import com.example.registrationOfCustomer.entity.LoginEntity;
import com.example.registrationOfCustomer.model.RegistrationModel;
import com.example.registrationOfCustomer.repository.LoginRepository;
import com.example.registrationOfCustomer.repository.RegistrationRepository;
import org.apache.catalina.valves.rewrite.InternalRewriteMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.regex.*;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private LoginRepository loginRepository;

    public String saveData(RegistrationModel registrationModel) {
        CustomerEntity customerEntity = new CustomerEntity();
        LoginEntity loginEntity = new LoginEntity();
        customerEntity.setLoginType(registrationModel.getLoginType());
        customerEntity.setFirstName(registrationModel.getFirstName());
        customerEntity.setLastName(registrationModel.getLastName());

        //Login

        loginEntity.setLoginType(registrationModel.getLoginType());
        loginEntity.setEmailAddress(registrationModel.getEmailAddress());
        loginEntity.setPassword(registrationModel.getPassword());
        // setting login entity to the customer entity
        loginEntity.setCustomerEntity(customerEntity);

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
            customerEntity.setConfirmPassword(registrationModel.getConfirmPassword());
        }
        else{
            return "Error: Passwords do not match.";
        }

        if(validatePassword(registrationModel.getPassword())){
            customerEntity.setPassword(registrationModel.getPassword());
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
            loginRepository.save(loginEntity);

        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
        }
        return "success!!";
    }

    //Validation Methods
private boolean validateEmailAddress(String emailAddress){
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
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





