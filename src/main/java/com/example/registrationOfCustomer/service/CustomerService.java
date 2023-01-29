package com.example.registrationOfCustomer.service;

import com.example.registrationOfCustomer.entity.CustomerEntity;
import com.example.registrationOfCustomer.entity.LoginEntity;
import com.example.registrationOfCustomer.model.CustomerModel;
import com.example.registrationOfCustomer.repository.LoginRepository;
import com.example.registrationOfCustomer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.*;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoginRepository loginRepository;

    public String saveData(CustomerModel customerModel) {
        CustomerEntity customerEntity = new CustomerEntity();
        LoginEntity loginEntity = new LoginEntity();
        customerEntity.setLoginType(customerModel.getLoginType());
        customerEntity.setFirstName(customerModel.getFirstName());
        customerEntity.setLastName(customerModel.getLastName());


        //Login

        loginEntity.setLoginType(customerModel.getLoginType());
        loginEntity.setEmailAddress(customerModel.getEmailAddress());
        loginEntity.setPassword(customerModel.getPassword());
        // setting login entity to the customer entity
        //loginEntity.setCustomerEntity(customerEntity);
        customerEntity.setLoginEntity(loginEntity);


        //email validation

                if(validateEmailAddress(customerModel.getEmailAddress())){//calling validating method to check if true or false
                    customerEntity.setEmailAddress(customerModel.getEmailAddress());
                }
                else{//if false
                    return "Email address is not correct please use @test.com";
                }
                //mobile number validation
        if(validateMobileNumber(customerModel.getMobileNumber())){
            customerEntity.setMobileNumber(customerModel.getMobileNumber());
        }
        else{
            return "Mobile number is not correct";
        }

//validate confirmPassword with password
        if(customerModel.getPassword().equals(customerModel.getConfirmPassword())){
            customerEntity.setConfirmPassword(customerModel.getConfirmPassword());
        }
        else{
            return "Error: Passwords do not match.";
        }

        if(validatePassword(customerModel.getPassword())){
            customerEntity.setPassword(customerModel.getPassword());
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



        customerEntity.setStatus(customerModel.getStatus());



        try {
            customerRepository.save(customerEntity);
            //loginRepository.save(loginEntity);
        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
        }
        return "success!!";
    }

    //Update logic
    public String updateCustomerDetails (CustomerModel customerModel) {
        //Integer id =customerRepository.findByEmail(customerModel.getEmailAddress()); to find id using email
        CustomerEntity customerEntity = customerRepository.findByEmail(customerModel.getEmailAddress());
       // CustomerEntity customerEntity = null;
        if (customerEntity == null) {
            return "Error: Customer not found.";
        }
        customerEntity.setLoginType(customerModel.getLoginType());
        customerEntity.setFirstName(customerModel.getFirstName());
        customerEntity.setLastName(customerModel.getLastName());
        customerEntity.setStatus(customerModel.getStatus());


        //validate email address
        if (validateEmailAddress(customerModel.getEmailAddress())) {
            customerEntity.setEmailAddress(customerModel.getEmailAddress());
        } else {
            return "Email address is not correct please use @test.com";
        }



        //validate mobile number
        if (validateMobileNumber(customerModel.getMobileNumber())) {
            customerEntity.setMobileNumber(customerModel.getMobileNumber());
        } else {
            return "Mobile number is not correct";
        }

        try {
            customerRepository.save(customerEntity);
        } catch (Exception e) {
            System.err.println("Error Details::" + e.getMessage());
        }


        return "Customer Details updated";
    }

    //Fetch Customer Details
    public CustomerModel fetchCustomerDetails (CustomerModel customerModel) {
        CustomerEntity customerEntity = customerRepository.findByEmail(customerModel.getEmailAddress());
        CustomerModel customerModel1 = new CustomerModel();

        if (customerEntity != null) {
            customerModel1.setLoginType(customerEntity.getLoginType());
            customerModel1.setFirstName(customerEntity.getFirstName());
            customerModel1.setLastName(customerEntity.getLastName());
            customerModel1.setEmailAddress(customerEntity.getEmailAddress());
            customerModel1.setMobileNumber(customerEntity.getMobileNumber());
            customerModel1.setPassword(customerEntity.getPassword());


        }
        return customerModel1;
    }

   /* //Delete method
    public String deleteCustomerDetails(CustomerModel customerModel){
        CustomerEntity customerEntity = customerRepository.findByEmail(customerModel.getEmailAddress());
        if(customerEntity != null) {
            // Delete the associated LoginEntity
            loginRepository.deleteByEmail(customerEntity.getEmailAddress());
            // Delete the customer
            customerRepository.delete(customerEntity);
            return "Customer deleted successfully.";
        } else {
            // Customer not found
            return "Customer not found.";
        }
    }
*/
   public String deleteCustomerInfo(Integer id) {
       try {
           customerRepository.deleteById(id);
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





