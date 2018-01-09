package io.swagger.api;

import envtest.proc.CustomerCall;
import io.swagger.model.Customer;

import io.swagger.annotations.*;
import io.swagger.model.CustomerResponse;
import io.swagger.model.NotFound;
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
    public ResponseEntity<Object> customerQuerySearchTermGet(
            @ApiParam(value = "", required = true) @PathVariable("query") String query,
            @ApiParam(value = "", required = true) @PathVariable("searchTerm") String searchTerm
    ) {
        ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

        try {
            CustomerCall customerCall = new CustomerCall();

            switch (query) {
                case "id":
                    // Search according to customer number
                    ArrayList<?> envCustomer = customerCall.findByCustomerNumber(searchTerm);

                    response = (ResponseEntity<Object>) (envCustomer.size() <= 0
                            ? new ResponseEntity<>(new NotFound(HttpStatus.NOT_FOUND.value(), "Customer not found"), HttpStatus.NOT_FOUND)
                            : new ResponseEntity<>(new CustomerResponse(HttpStatus.OK.value(), "Success", (ArrayList<Customer>) envCustomer), HttpStatus.OK));

                    break;
                case "phone":
                    // Search according to phone number
                    ArrayList<?> customers1 = customerCall.findByPhoneNumber(searchTerm);

                    response = (ResponseEntity<Object>) (customers1.size() <= 0
                            ? new ResponseEntity<>(new NotFound(HttpStatus.NOT_FOUND.value(), "Customer not found"), HttpStatus.NOT_FOUND)
                            : new ResponseEntity<>(new CustomerResponse(HttpStatus.OK.value(), "Success", (ArrayList<Customer>) customers1), HttpStatus.OK));

                    break;
                default:
                    break;
            }

        } catch (SQLException ex) {
            response = new ResponseEntity<>((Object) new NotFound(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
            Logger.getLogger(CustomerApiController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            response = new ResponseEntity<>((Object) new NotFound(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
            Logger.getLogger(CustomerApiController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response;
    }

}
