/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.api;

import envtest.model.BankCode;
import envtest.proc.InformationCall;
import io.swagger.model.BankCodeResponse;
import io.swagger.model.NotFound;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Philip
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-10T09:55:07.361Z")
@Controller
public class InformationApiController implements InformationApi {

    @Override
    public ResponseEntity<Object> getBankCodeInfomation() {
        ResponseEntity<Object> responseEntity;
        try {
            InformationCall informationCall = new InformationCall();
            
            ArrayList<BankCode> bankCodes = informationCall.getBankCodes();
            
            responseEntity = new ResponseEntity<>(
                    (Object) new BankCodeResponse("success", HttpStatus.OK.value(), bankCodes),
                    HttpStatus.OK
            );
        } catch (SQLException ex) {
            Logger.getLogger(InformationApiController.class.getName()).log(Level.SEVERE, null, ex);
            responseEntity = new ResponseEntity<>(
                    (Object) new NotFound(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
        
        return responseEntity;
    }
    
}
