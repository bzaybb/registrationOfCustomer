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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

@Service
public class RegistrationService {

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


        //Login

        loginEntity.setLoginType(registrationModel.getLoginType());
        loginEntity.setEmailAddress(registrationModel.getEmailAddress());
        loginEntity.setPassword(registrationModel.getPassword());
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
        //Integer id =registrationRepository.findByEmail(registrationModel.getEmailAddress()); to find id using email
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
    public RegistrationModel fetchCustomerDetails (RegistrationModel registrationModel) {
        CustomerEntity customerEntity = registrationRepository.findByEmail(registrationModel.getEmailAddress());
        RegistrationModel registrationModel1 = new RegistrationModel();

        if (customerEntity != null) {
            registrationModel1.setLoginType(customerEntity.getLoginType());
            registrationModel1.setFirstName(customerEntity.getFirstName());
            registrationModel1.setLastName(customerEntity.getLastName());
            registrationModel1.setEmailAddress(customerEntity.getEmailAddress());
            registrationModel1.setMobileNumber(customerEntity.getMobileNumber());
            registrationModel1.setPassword(customerEntity.getPassword());


        }
        return registrationModel1;
    }

   /* //Delete method
    public String deleteCustomerDetails(RegistrationModel customerModel){
        CustomerEntity customerEntity = registrationRepository.findByEmail(customerModel.getEmailAddress());
        if(customerEntity != null) {
            // Delete the associated LoginEntity
            loginRepository.deleteByEmail(customerEntity.getEmailAddress());
            // Delete the customer
            registrationRepository.delete(customerEntity);
            return "Customer deleted successfully.";
        } else {
            // Customer not found
            return "Customer not found.";
        }
    }
*/
   public String deleteCustomerInfo(Integer id) {
       try {
           registrationRepository.deleteById(id);
       } catch(Exception e) {
           System.err.println("Error Details ::"+e.getMessage());
       }
       return "Success";
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





