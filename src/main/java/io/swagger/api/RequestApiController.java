package io.swagger.api;

import envtest.proc.RequestCall;
import envtest.proc.exception.X100ProcException;
import io.swagger.model.ApiSuccessResponse;

import io.swagger.annotations.*;
import io.swagger.model.NotFound;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-10T09:55:07.361Z")

@Controller
public class RequestApiController implements RequestApi {

    @Override
    public ResponseEntity<ApiSuccessResponse> requestAtmPost(@ApiParam(value = "", required = true) @RequestPart(value = "accountId", required = true) String accountId,
            @ApiParam(value = "", required = true) @RequestPart(value = "displayName", required = true) String displayName,
            @ApiParam(value = "", required = true) @RequestPart(value = "deliveryMethod", required = true) String deliveryMethod,
            @ApiParam(value = "", required = true) @RequestPart(value = "cardType", required = true) String cardType) {
        // do some magic!
        return new ResponseEntity<ApiSuccessResponse>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiSuccessResponse> requestChequeBookPost(@ApiParam(value = "", required = true) @RequestPart(value = "accountId", required = true) String accountId,
            @ApiParam(value = "", required = true) @RequestPart(value = "currency", required = true) String currency,
            @ApiParam(value = "The document number", required = true) @RequestPart(value = "docNumber", required = true) String docNumber,
            @ApiParam(value = "Number of leaves", required = true) @RequestPart(value = "leaves", required = true) String leaves,
            @ApiParam(value = "", required = true) @RequestPart(value = "deliveryChannel", required = true) String deliveryChannel,
            @ApiParam(value = "", required = true) @RequestPart(value = "deliveryBranch", required = true) String deliveryBranch) {
        // do some magic!
        return new ResponseEntity<ApiSuccessResponse>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiSuccessResponse> requestEmailPost(@ApiParam(value = "", required = true) @RequestPart(value = "accountId", required = true) String accountId,
            @ApiParam(value = "", required = true) @RequestPart(value = "emailAddress", required = true) String emailAddress) {
        // do some magic!
        return new ResponseEntity<ApiSuccessResponse>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiSuccessResponse> requestSmsPost(@ApiParam(value = "", required = true) @RequestPart(value = "serviceType", required = true) String serviceType,
            @ApiParam(value = "", required = true) @RequestPart(value = "bbanNumber", required = true) String bbanNumber,
            @ApiParam(value = "", required = true) @RequestPart(value = "currencyCode", required = true) String currencyCode,
            @ApiParam(value = "", required = true) @RequestPart(value = "phoneNumber", required = true) String phoneNumber) {
        // do some magic!
        return new ResponseEntity<ApiSuccessResponse>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiSuccessResponse> requestStopCheckPost(@ApiParam(value = "", required = true) @RequestPart(value = "accountId", required = true) String accountId,
            @ApiParam(value = "", required = true) @PathVariable(value = "chequeNumber", required = true) String chequeNumber,
            @ApiParam(value = "", required = true) @PathVariable(value = "reason", required = true) String reason) {
        // do some magic!
        return new ResponseEntity<ApiSuccessResponse>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> verifyChequeNumber(
            @ApiParam(value = "", required = true) @PathVariable(value = "chequeDebitAcct", required = true) String chequeDebitAcct, 
            @ApiParam(value = "", required = true) @PathVariable(value = "chequeNumber", required = true) String chequeNumber
    ) {
        RequestCall requests;
        
        ResponseEntity<Object> response;
        
        System.out.println("chequeNumber " + chequeNumber);
        System.out.println("chequeDebitAcct " + chequeDebitAcct);
        
        try {
            requests = new RequestCall(chequeDebitAcct);
            requests.isValidChequeNumber(chequeDebitAcct, chequeNumber);
            
            response = new ResponseEntity<>((Object) new ApiSuccessResponse(HttpStatus.OK.value(), "Valid cheque number"), HttpStatus.OK);
        } catch (SQLException ex) {
            Logger.getLogger(RequestApiController.class.getName()).log(Level.SEVERE, null, ex);
            response = new ResponseEntity<>((Object) new NotFound(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (X100ProcException ex) {
            response = new ResponseEntity<>((Object) new NotFound(HttpStatus.NOT_FOUND.value(), ex.getReason()), HttpStatus.NOT_FOUND);
            Logger.getLogger(RequestApiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }

}
