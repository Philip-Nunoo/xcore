package io.swagger.api;

import envtest.model.RequestResponse;
import envtest.proc.AccountCall;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-10T09:55:07.361Z")

@Controller
public class RequestApiController implements RequestApi {

    @Override
    public ResponseEntity<ApiSuccessResponse> requestChequeBookPost(
            @ApiParam(value = "", required = true) @RequestParam(value = "accountId", required = true) String accountId,
            @ApiParam(value = "Number of leaves", required = true) @RequestParam(value = "leaves", required = true) String leaves,
            @ApiParam(value = "", required = true) @RequestParam(value = "userid", required = true) String userid
    ) {

        ApiSuccessResponse response = new ApiSuccessResponse();
        try {
            // do some magic!
            RequestCall requests = new RequestCall(accountId);
            String msg = requests.cheqBkRequest(leaves, userid);
            response = new ApiSuccessResponse();
            response.setResponseCode(200);
            response.setMessage(msg);
        } catch (SQLException ex) {
            Logger.getLogger(RequestApiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ResponseEntity<ApiSuccessResponse>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> requestEmailPost(
            @ApiParam(value = "accountId", required = true) @RequestPart(value = "accountId", required = true) String accountId,
            @ApiParam(value = "post by", required = true) @RequestPart(value = "postBy", required = true) String postBy
    ) {
        ResponseEntity<Object> responseEntity;
        
        try {
            String terminalId = "terminal_id";
            RequestCall requestCall = new RequestCall(accountId);
            RequestResponse toggleEmailAlert = requestCall.toggleEmailAlert(postBy, terminalId);
            
            responseEntity = new ResponseEntity<>(
                    (Object) new ApiSuccessResponse((int) toggleEmailAlert.getResponseCode(), toggleEmailAlert.getMessage()),
                    HttpStatus.valueOf((int) toggleEmailAlert.getResponseCode())
            );
        } catch (SQLException ex) {
            Logger.getLogger(RequestApiController.class.getName()).log(Level.SEVERE, null, ex);
            
            responseEntity = new ResponseEntity<>(
                    (Object) new NotFound(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<Object> requestSmsPost(
            @ApiParam(value = "accountId", required = true) @RequestPart(value = "accountId", required = true) String accountId,
            @ApiParam(value = "post by", required = true) @RequestPart(value = "postBy", required = true) String postBy
    ) {
        ResponseEntity<Object> responseEntity;
        
        try {
            RequestCall requestCall = new RequestCall(accountId);
            
            String channel = "channel";
            String terminalId = "terminalId";
            
            RequestResponse toggleSmsAlert = requestCall.toggleSmsAlert(channel, postBy, terminalId);
            
            responseEntity = new ResponseEntity<>(
                    (Object) new ApiSuccessResponse((int) toggleSmsAlert.getResponseCode(), toggleSmsAlert.getMessage()),
                    HttpStatus.valueOf((int) toggleSmsAlert.getResponseCode())
            );
            
        } catch (SQLException ex) {
            Logger.getLogger(RequestApiController.class.getName()).log(Level.SEVERE, null, ex);
            
            responseEntity = new ResponseEntity<>(
                    (Object) new NotFound(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<ApiSuccessResponse> requestStopCheckPost(
            @ApiParam(value = "", required = true) @RequestParam(value = "accountId", required = true) String accountId,
            @ApiParam(value = "", required = true) @RequestParam(value = "StartCheque", required = true) String StartCheque,
            @ApiParam(value = "", required = true) @RequestParam(value = "EndCheque", required = true) String EndCheque,
            @ApiParam(value = "", required = true) @RequestParam(value = "IssueDate", required = true) String IssueDate,
            @ApiParam(value = "", required = true) @RequestParam(value = "BeneficaryName", required = true) String BeneficaryName,
            @ApiParam(value = "", required = true) @RequestParam(value = "ChequeAmount", required = true) String ChequeAmount) {
        // do some magic!
        {

            ApiSuccessResponse response = new ApiSuccessResponse();
            try {
                // do some magic!
                RequestCall requests = new RequestCall(accountId);
                String msg = requests.stopCheqBkRequest(StartCheque, EndCheque, IssueDate, BeneficaryName, ChequeAmount);
                response = new ApiSuccessResponse();
                response.setResponseCode(200);
                response.setMessage(msg);
            } catch (SQLException ex) {
                Logger.getLogger(RequestApiController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return new ResponseEntity<ApiSuccessResponse>(response, HttpStatus.OK);
        }

    }

    @Override
    public ResponseEntity<ApiSuccessResponse> requestStatement(
            @ApiParam(value = "accountid", required = true) @RequestParam(value = "accountid", required = true) String accountid,
            @ApiParam(value = "start date", required = true) @RequestParam(value = "startdate", required = true) String startdate,
            @ApiParam(value = "end date", required = true) @RequestParam(value = "enddate", required = true) String enddate,
            @ApiParam(value = "satement type", required = true) @RequestParam(value = "statementtype", required = true) String statementtype,
            @ApiParam(value = "userid", required = true) @RequestParam(value = "userid", required = true) String userid) {

        ApiSuccessResponse response = new ApiSuccessResponse();
        try {
            // do some magic!
            RequestCall requests = new RequestCall(accountid);
            String msg = requests.stmtRequest(startdate, enddate, statementtype, userid);
            response = new ApiSuccessResponse();
            response.setResponseCode(200);
            response.setMessage(msg);
        } catch (SQLException ex) {
            Logger.getLogger(RequestApiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ResponseEntity<ApiSuccessResponse>(response, HttpStatus.OK);
    }

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

    @Override
    public ResponseEntity<ApiSuccessResponse> requestAtmPost(
            String accountId, String displayName,
            String deliveryMethod, String cardType
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
