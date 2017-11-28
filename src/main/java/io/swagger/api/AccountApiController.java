package io.swagger.api;

import envtest.model.TransEnquiry;
import envtest.model.TransactionPosting;
import envtest.proc.AccountCall;
import io.swagger.model.Balance;
import io.swagger.model.Statements;

import io.swagger.annotations.*;
import io.swagger.model.Account;
import io.swagger.model.AccountPostingResponse;
import io.swagger.model.TransactionsResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class AccountApiController implements AccountApi {

    @Override
    public ResponseEntity<Account> retrieveAccount(@ApiParam(value = "The account id of the account",required=true ) @PathVariable("accountId") String accountId) {
        ResponseEntity<Account> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        try {
            AccountCall accountCall = new AccountCall(accountId);
            
            envtest.model.Account account = accountCall.findAccountById(accountId);
            
            response = (ResponseEntity<Account>) ( account == null ?
                    new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                    new ResponseEntity<>(account, HttpStatus.OK));
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountApiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }
    
    @Override
    public ResponseEntity<Balance> retrieveAccountBalance(@ApiParam(value = "The account id of the account",required=true ) @PathVariable("accountId") String accountId) {
        ResponseEntity<Balance> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        try {
            // do some magic!
            AccountCall accountCall = new AccountCall(accountId);
            envtest.model.Balance balance = accountCall.getAccountBalance();
            
            response = (ResponseEntity<Balance>) ( balance == null ? 
                    new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                    new ResponseEntity<>(balance, HttpStatus.OK));
        } catch (SQLException ex) {
            Logger.getLogger(AccountApiController.class.getName()).log(Level.SEVERE, null, ex);
            response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return response;
    }
    
    @Override
    public ResponseEntity<AccountPostingResponse> accountAccountIdDepositPut(
            @ApiParam(value = "The account id of the account",required=true ) @PathVariable("accountId") String accountId,
            @ApiParam(value = "Amount to deposit", required=true) @RequestParam(value="amount", required=true)  Long amount,
            @ApiParam(value = "The documentRef", required=true) @RequestParam(value="documentRef", required=true)  String documentRef,
            @ApiParam(value = "The batchNo") @RequestParam(value="batchNo", required=false)  String batchNo,
            @ApiParam(value = "The transaction narration") @RequestParam(value="narration", required=true)  String narration,
            @ApiParam(value = "The the teller posting transaction") @RequestParam(value="postBy", required=false)  String postBy,
            @ApiParam(value = "Indicate if it need approval by a user") @RequestParam(value="appBy", required=false)  String appBy,
            @ApiParam(value = "The the terminal of the transaction") @RequestParam(value="postTerminal", required=false)  String postTerminal,
            @ApiParam(value = "The customerTelephone") @RequestParam(value="customerTel", required=false)  String customerTel,
            @ApiParam(value = "The customer performing the transaction") @RequestParam(value="transBy", required=false)  String transBy) {
        // do some magic!
        
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        AccountPostingResponse response = null;
        
        try {
            System.out.println(accountId);
            AccountCall accountCall = new AccountCall(accountId);
            
            // Todo: should add balance in account posting response
            TransactionPosting acr = accountCall.depositMoney(
                    accountId,
                    amount,
                    narration, 
                    documentRef,
                    batchNo,
                    postBy,
                    appBy,
                    postTerminal, 
                    customerTel,
                    transBy
            );
            
            httpStatus = acr.isResponse() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
            
            response = new AccountPostingResponse(httpStatus.value(), acr.getMessage());
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountApiController.class.getName()).log(Level.SEVERE, null, ex);
            
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            response = new AccountPostingResponse(httpStatus.value(), ex.getMessage());
        } 
        
        return new ResponseEntity<>(response, httpStatus);
    }

    public ResponseEntity<Statements> accountAccountIdStatementGet(@ApiParam(value = "The account id of the account",required=true ) @PathVariable("accountId") Long accountId) {
        // do some magic!
        return new ResponseEntity<Statements>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TransactionsResponse> accountAccountIdTransactionsGet(
            @ApiParam(value = "The account id of the account",required=true ) 
            @PathVariable("accountId") String accountId,
            @ApiParam(value = "") @RequestParam(value = "startDate", required = false) String startDate,
            @ApiParam(value = "") @RequestParam(value = "endDate", required = false) String endDate,
            @ApiParam(value = "") @RequestParam(value = "limit", required = false) Integer limit
    ) {
        
        ResponseEntity<TransactionsResponse> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        TransactionsResponse transactionResponse = new TransactionsResponse();
        
        try {
            AccountCall accountCall = new AccountCall(accountId);
            
            limit = (limit == null || limit <= 0) ? 10 : limit;
            String startDateString = "06/05/2017";
            String endDateString = "08/06/2017";
            
            ArrayList<TransEnquiry> accounts = new ArrayList<>();
            
            if (startDate != null && endDate != null) {
                SimpleDateFormat dt = new SimpleDateFormat("mm/dd/yyyy");
                Date startDATE = dt.parse(startDate);
                Date endDATE = dt.parse(endDate);
                
                accounts = accountCall.getTransEnquiry(startDATE, endDATE, limit);
            } else {
                accounts = accountCall.getTransEnquiry(limit);
            }       
                        
            transactionResponse.setMessage(accounts.size() <= 0 ? "No transactions found" : "Success");
            transactionResponse.setResponseCode(accounts.size() > 0 ? 200 : 404);
            transactionResponse.setTransactions(accounts);
            
            response = new ResponseEntity<>(
                    transactionResponse,
                    accounts.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND
            );
        } catch (SQLException ex) {
            transactionResponse.setMessage("Internal Server error: " + ex.getMessage());
            transactionResponse.setResponseCode(0);
            Logger.getLogger(AccountApiController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            transactionResponse.setMessage("Internal Server error: " + ex.getMessage());
            transactionResponse.setResponseCode(0);
            Logger.getLogger(AccountApiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }

    public ResponseEntity<Balance> accountAccountIdWithdrawalPut(@ApiParam(value = "The account id of the account",required=true ) @PathVariable("accountId") Long accountId,
        @ApiParam(value = "Amount to debit on account", required=true) @RequestPart(value="amount", required=true)  String amount,
        @ApiParam(value = "Narration for transaction", required=true) @RequestPart(value="narration", required=true)  String narration,
        @ApiParam(value = "The fee amount", required=true) @RequestPart(value="feeAmount", required=true)  String feeAmount,
        @ApiParam(value = "The fee code", required=true) @RequestPart(value="feeCode", required=true)  String feeCode) {
        // do some magic!
        return new ResponseEntity<Balance>(HttpStatus.OK);
    }

}
