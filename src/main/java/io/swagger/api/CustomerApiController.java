package io.swagger.api;

import envtest.proc.CustomerCall;
import io.swagger.model.Customer;

import io.swagger.annotations.*;
import io.swagger.model.CustomerResponse;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.logging.Level;
import java.util.logging.Logger;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-10T09:55:07.361Z")

@Controller
public class CustomerApiController implements CustomerApi {

    @Override
    public ResponseEntity<CustomerResponse> customerQuerySearchTermGet(@ApiParam(value = "",required=true ) @PathVariable("query") String query,
        @ApiParam(value = "",required=true ) @PathVariable("searchTerm") String searchTerm) {
        CustomerResponse customerResponse = new CustomerResponse();
        
        customerResponse.setMessage("Customer not found");
        HttpStatus responseCode = HttpStatus.NOT_FOUND;
        customerResponse.setResponseCode(responseCode.value());
        
        ResponseEntity<CustomerResponse> response = new ResponseEntity<>(customerResponse, responseCode);
                
        try {
            CustomerCall customerCall = null;
            
            switch (query) {
                case "id":
                    // Search according to customer number
                    customerCall = new CustomerCall();
                    
                    
                    ArrayList<?> envCustomer = customerCall.findByCustomerNumber(searchTerm);
                    
                    if (envCustomer.size() > 0) {                    
                        customerResponse.setMessage("Success");
                        responseCode = HttpStatus.OK;
                    }
                    
                    customerResponse.setResponseCode(responseCode.value());
                    customerResponse.setCustomers((ArrayList<Customer>) envCustomer);
                    
                    response = new ResponseEntity<>(customerResponse, responseCode);
                    break;
                case "phone":
                    // Search according to phone number
                    customerCall = new CustomerCall();
                    
                    String phoneNumber = searchTerm;
                    ArrayList<?> customers1 = customerCall.findByPhoneNumber(phoneNumber); 
                    
                    if (customers1.size() > 0){
                        responseCode = HttpStatus.OK;
                        customerResponse.setMessage("Success");
                    }
                    customerResponse.setResponseCode(responseCode.value());
                    customerResponse.setCustomers((ArrayList<Customer>) customers1);
                    
                    response = new ResponseEntity<>(customerResponse, responseCode);
                    break;
                default:
                    break;
            }
            
        } catch (SQLException ex) {
            customerResponse.setMessage(ex.getMessage());
            customerResponse.setResponseCode(responseCode.value());
            response = new ResponseEntity<>(customerResponse, responseCode);
            Logger.getLogger(CustomerApiController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            customerResponse.setMessage(ex.getMessage());
            customerResponse.setResponseCode(responseCode.value());
            response = new ResponseEntity<>(customerResponse, responseCode);
            Logger.getLogger(CustomerApiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }

}
