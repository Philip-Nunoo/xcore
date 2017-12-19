package io.swagger.api;

import envtest.proc.RequestCall;
import io.swagger.model.ApiSuccessResponse;

import io.swagger.annotations.*;
import io.swagger.model.AccountPostingResponse;
import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-10T09:55:07.361Z")

@Controller
public class RequestApiController implements RequestApi {



    public ResponseEntity<ApiSuccessResponse> requestAtmPost(@ApiParam(value = "", required=true) @RequestPart(value="accountId", required=true)  String accountId,
        @ApiParam(value = "", required=true) @RequestPart(value="displayName", required=true)  String displayName,
        @ApiParam(value = "", required=true) @RequestPart(value="deliveryMethod", required=true)  String deliveryMethod,
        @ApiParam(value = "", required=true) @RequestPart(value="cardType", required=true)  String cardType) {
        // do some magic!
        return new ResponseEntity<ApiSuccessResponse>(HttpStatus.OK);
    }

    public ResponseEntity<ApiSuccessResponse> requestChequeBookPost(
        @ApiParam(value = "", required=true) @RequestParam(value="accountId", required=true)  String accountId,
        @ApiParam(value = "Number of leaves", required=true) @RequestParam(value="leaves", required=true)  String leaves,
        @ApiParam(value = "", required=true) @RequestParam(value="userid", required=true)  String userid
       ) {
        
        ApiSuccessResponse response = new ApiSuccessResponse();
        try {
            // do some magic!
            RequestCall requests = new RequestCall(accountId);
            String msg = requests.cheqBkRequest(leaves, userid);
            response = new ApiSuccessResponse();
            response.setCode(200);
            response.setMessage(msg);
        } catch (SQLException ex) {
            Logger.getLogger(RequestApiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ResponseEntity<ApiSuccessResponse>(response,HttpStatus.OK);
    }
    


    public ResponseEntity<ApiSuccessResponse> requestEmailPost(@ApiParam(value = "", required=true) @RequestPart(value="accountId", required=true)  String accountId,
        @ApiParam(value = "", required=true) @RequestPart(value="emailAddress", required=true)  String emailAddress) {
        // do some magic!
        return new ResponseEntity<ApiSuccessResponse>(HttpStatus.OK);
    }

    public ResponseEntity<ApiSuccessResponse> requestSmsPost(@ApiParam(value = "", required=true) @RequestPart(value="serviceType", required=true)  String serviceType,
        @ApiParam(value = "", required=true) @RequestPart(value="bbanNumber", required=true)  String bbanNumber,
        @ApiParam(value = "", required=true) @RequestPart(value="currencyCode", required=true)  String currencyCode,
        @ApiParam(value = "", required=true) @RequestPart(value="phoneNumber", required=true)  String phoneNumber) {
        // do some magic!
        return new ResponseEntity<ApiSuccessResponse>(HttpStatus.OK);
    }

    public ResponseEntity<ApiSuccessResponse> requestStopCheckPost(
        @ApiParam(value = "", required=true) @RequestParam(value="accountId", required=true)  String accountId,
        @ApiParam(value = "", required=true) @RequestParam(value="StartCheque", required=true)  String StartCheque,
        @ApiParam(value = "", required=true) @RequestParam(value="EndCheque", required=true)  String EndCheque ,
        @ApiParam(value = "", required=true) @RequestParam(value="IssueDate", required=true)  String IssueDate ,
        @ApiParam(value = "", required=true) @RequestParam(value="BeneficaryName", required=true)  String BeneficaryName ,
        @ApiParam(value = "", required=true) @RequestParam(value="ChequeAmount", required=true)  String ChequeAmount  ) {
        // do some magic!
        {
        
        ApiSuccessResponse response = new ApiSuccessResponse();
        try {
            // do some magic!
            RequestCall requests = new RequestCall(accountId);
            String msg = requests.stopCheqBkRequest(StartCheque, EndCheque, IssueDate, BeneficaryName, ChequeAmount);
            response = new ApiSuccessResponse();
            response.setCode(200);
            response.setMessage(msg);
        } catch (SQLException ex) {
            Logger.getLogger(RequestApiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ResponseEntity<ApiSuccessResponse>(response,HttpStatus.OK);
    }
       
    }

    @Override
    public ResponseEntity<ApiSuccessResponse> requestStatement(
        @ApiParam(value = "accountid", required=true) @RequestParam(value="accountid", required=true)  String accountid,
        @ApiParam(value = "start date", required=true) @RequestParam(value="startdate", required=true)  String startdate,
        @ApiParam(value = "end date", required=true) @RequestParam(value="enddate", required=true)  String enddate,
         @ApiParam(value = "satement type", required=true) @RequestParam(value="statementtype", required=true)  String statementtype,
        @ApiParam(value = "userid", required=true) @RequestParam(value="userid", required=true)  String userid) 
    {
      {
        
        ApiSuccessResponse response = new ApiSuccessResponse();
        try {
            // do some magic!
            RequestCall requests = new RequestCall(accountid);
            String msg = requests.stmtRequest(startdate,enddate,statementtype, userid);
            response = new ApiSuccessResponse();
            response.setCode(200);
            response.setMessage(msg);
        } catch (SQLException ex) {
            Logger.getLogger(RequestApiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ResponseEntity<ApiSuccessResponse>(response,HttpStatus.OK);
    }
    }

   
}
