package io.swagger.api;

import envtest.model.MandateEnquiry;

import io.swagger.annotations.*;
import io.swagger.model.MandateResponse;
import envtest.model.TransEnquiry;
import envtest.model.TransactionPosting;
import envtest.proc.AccountCall;
import io.swagger.model.AccountPostingResponse;
import io.swagger.model.NotFound;
import io.swagger.model.TransactionsResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.codec.binary.Base64;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-10T09:55:07.361Z")
@Controller
public class AccountApiController implements AccountApi {

    @Override
    public ResponseEntity<MandateResponse> retrieveAccountMandate(
            @ApiParam(value = "The account id of the account", required = true) @PathVariable("accountId") String accountId
    ) {
        ResponseEntity<MandateResponse> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        try {
            MandateResponse mandateResponse = new MandateResponse();
            AccountCall accountCall = new AccountCall(accountId);

            ArrayList<MandateEnquiry> mandates = accountCall.getMandate(accountId);

            mandateResponse.setMandates(mandates);

            if (mandates.size() > 0) {
                mandateResponse.setResponseCode(200);
                mandateResponse.setMessage("Successful");
            } else {
                mandateResponse.setResponseCode(404);
                mandateResponse.setMessage("Mandate not found");
            }

            response = new ResponseEntity<>(mandateResponse,
                    mandates.size() > 0
                    ? HttpStatus.OK
                    : HttpStatus.NOT_FOUND
            );
        } catch (SQLException ex) {
            Logger.getLogger(AccountApiController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return response;

    }

    @Override
    public ResponseEntity<Object> retrieveAccount(
            @ApiParam(value = "The account id of the account", required = true) @PathVariable("accountId") String accountId
    ) {
        ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        try {
            AccountCall accountCall = new AccountCall(accountId);
            envtest.model.Account account = accountCall.findAccountById(accountId);

            response = (ResponseEntity<Object>) (account == null
                    ? new ResponseEntity<>(new NotFound(HttpStatus.NOT_FOUND.value(), "Account not found"), HttpStatus.NOT_FOUND)
                    : new ResponseEntity<>(account, HttpStatus.OK));

        } catch (SQLException ex) {
            Logger.getLogger(AccountApiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

    @Override
    public ResponseEntity<Object> retrieveAccountBalance(
            @ApiParam(value = "The account id of the account", required = true) @PathVariable("accountId") String accountId
    ) {
        ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        try {
            // do some magic!
            AccountCall accountCall = new AccountCall(accountId);
            envtest.model.Balance balance = accountCall.getAccountBalance();

            response = (ResponseEntity<Object>) (balance == null
                    ? new ResponseEntity<>(new NotFound(HttpStatus.NOT_FOUND.value(), "Account not found"), HttpStatus.NOT_FOUND)
                    : new ResponseEntity<>(balance, HttpStatus.OK));
        } catch (SQLException ex) {
            Logger.getLogger(AccountApiController.class.getName()).log(Level.SEVERE, null, ex);
            response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }

    @Override
    public ResponseEntity<AccountPostingResponse> accountAccountIdDepositPut(
            @ApiParam(value = "The account id of the account", required = true) @PathVariable("accountId") String accountId,
            @ApiParam(value = "Amount to deposit", required = true) @RequestParam(value = "amount", required = true) String amount,
            @ApiParam(value = "The documentRef", required = true) @RequestParam(value = "documentRef", required = true) String documentRef,
            @ApiParam(value = "The transaction narration") @RequestParam(value = "narration", required = true) String narration,
            @ApiParam(value = "The the teller posting transaction") @RequestParam(value = "postBy", required = false) String postBy,
            @ApiParam(value = "Indicate if it need approval by a user") @RequestParam(value = "appBy", required = false) String appBy,
            @ApiParam(value = "The customerTelephone") @RequestParam(value = "customerTel", required = false) String customerTel,
            @ApiParam(value = "The customer performing the transaction") @RequestParam(value = "transBy", required = false) String transBy,
            HttpServletRequest request
    ) {
        // do some magic!

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        AccountPostingResponse response = null;

        try {
            AccountCall accountCall = new AccountCall(accountId);

            String postTerminal = request.getAttribute("terminal").toString();

            // Todo: should add balance in account posting response
            TransactionPosting acr = accountCall.depositMoney(
                    accountId,
                    Float.parseFloat(amount),
                    narration,
                    documentRef,
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
        } catch (Exception ex) {
            Logger.getLogger(AccountApiController.class.getName()).log(Level.SEVERE, null, ex);

            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            response = new AccountPostingResponse(httpStatus.value(), ex.getMessage());
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @Override
    public ResponseEntity<AccountPostingResponse> accountAccountIdWithdrawalPut(
            @ApiParam(value = "The account id of the account", required = true) @PathVariable("accountId") String accountId,
            @ApiParam(value = "Amount to deposit", required = true) @RequestParam(value = "amount", required = true) String amount,
            @ApiParam(value = "The documentRef", required = true) @RequestParam(value = "documentRef", required = true) String documentRef,
            @ApiParam(value = "The transaction narration") @RequestParam(value = "narration", required = true) String narration,
            @ApiParam(value = "The the teller posting transaction") @RequestParam(value = "postBy", required = false) String postBy,
            @ApiParam(value = "Indicate if it need approval by a user") @RequestParam(value = "appBy", required = false) String appBy,
            @ApiParam(value = "The customerTelephone") @RequestParam(value = "customerTel", required = false) String customerTel,
            @ApiParam(value = "The customer performing the transaction") @RequestParam(value = "transBy", required = false) String transBy,
            HttpServletRequest request
    ) {
        // do some magic!

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        AccountPostingResponse response = null;
        String postTerminal = request.getAttribute("terminal").toString();

        try {
            System.out.println(accountId);
            AccountCall accountCall = new AccountCall(accountId);

            // Todo: should add balance in account posting response
            TransactionPosting acr = accountCall.withdrawMoney(
                    accountId,
                    Float.parseFloat(amount),
                    narration,
                    documentRef,
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
        } catch (Exception ex) {
            Logger.getLogger(AccountApiController.class.getName()).log(Level.SEVERE, null, ex);

            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            response = new AccountPostingResponse(httpStatus.value(), ex.getMessage());
        }

        return new ResponseEntity<>(response, httpStatus);
    }

    @Override
    public ResponseEntity<AccountPostingResponse> accountAccountIdTransferPut(
            @ApiParam(value = "The account to debit", required = true) @PathVariable("accountId") String accountId,
            @ApiParam(value = "The account to credit", required = true) @RequestParam("destinationAccountId") String destinationAccountId,
            @ApiParam(value = "Amount to deposit", required = true) @RequestParam(value = "amount", required = true) String amount,
            @ApiParam(value = "The documentRef", required = true) @RequestParam(value = "documentRef", required = true) String documentRef,
            @ApiParam(value = "The transaction narration") @RequestParam(value = "narration", required = true) String narration,
            @ApiParam(value = "The the teller posting transaction") @RequestParam(value = "postBy", required = false) String postBy,
            @ApiParam(value = "Indicate if it need approval by a user") @RequestParam(value = "appBy", required = false) String appBy,
            @ApiParam(value = "The customerTelephone") @RequestParam(value = "customerTel", required = false) String customerTel,
            @ApiParam(value = "The customer performing the transaction") @RequestParam(value = "transBy", required = false) String transBy,
            HttpServletRequest request
    ) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        AccountPostingResponse response = null;

        String postTerminal = request.getAttribute("terminal").toString();
        try {
            AccountCall accountCall = new AccountCall(accountId);

            TransactionPosting acr = accountCall.transferFunds(
                    destinationAccountId,
                    accountId,
                    Float.parseFloat(amount),
                    narration,
                    documentRef,
                    postBy,
                    appBy,
                    postTerminal,
                    customerTel,
                    transBy
            );

            httpStatus = acr.isResponse() ? HttpStatus.OK : HttpStatus.NOT_FOUND;

            response = new AccountPostingResponse(acr.getTransactionStatusCode(), acr.getMessage());

        } catch (SQLException ex) {
            Logger.getLogger(AccountApiController.class.getName()).log(Level.SEVERE, null, ex);

            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            response = new AccountPostingResponse(httpStatus.value(), ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(AccountApiController.class.getName()).log(Level.SEVERE, null, ex);

            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            response = new AccountPostingResponse(httpStatus.value(), ex.getMessage());
        }

        return new ResponseEntity<>(response, httpStatus);

    }

    @Override
    public ResponseEntity<TransactionsResponse> accountAccountIdTransactionsGet(
            @ApiParam(value = "The account id of the account", required = true)
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

    @Override
    public ResponseEntity<Object> checkDeposit(
            @ApiParam(value = "The account id of the account to deposit", required = true) @PathVariable("accountId") String accountId,
            @ApiParam(value = "The cheque number", required = true) @PathVariable("chequeNumber") String chequeNumber,
            @ApiParam(value = "The debit account id", required = true) @RequestParam("debitAccountId") String debitAccountId,
            @ApiParam(value = "Amount to deposit", required = true) @RequestParam(value = "amount", required = true) String amount,
            @ApiParam(value = "The documentRef", required = true) @RequestParam(value = "documentRef", required = true) String documentRef,
            @ApiParam(value = "The transaction narration", required = true) @RequestParam(value = "narration", required = true) String narration,
            @ApiParam(value = "The the teller posting transaction") @RequestParam(value = "postBy", required = false) String postBy,
            @ApiParam(value = "Indicate if it need approval by a user") @RequestParam(value = "appBy", required = false) String appBy,
            @ApiParam(value = "The customerTelephone") @RequestParam(value = "customerTel", required = false) String customerTel,
            @ApiParam(value = "The customer performing the transaction") @RequestParam(value = "transBy", required = false) String transBy,
            @ApiParam(value = "Cheque front bytes string", required = true) @RequestParam(value = "file1", required = true) String file1,
            @ApiParam(value = "Cheque back byte string", required = true) @RequestParam(value = "file2", required = true) String file2,
            HttpServletRequest request
    ) {
        String postTerminal = request.getAttribute("terminal").toString();
        ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

        try {
            AccountCall accountCall = new AccountCall();

            byte[] valueDecoded1 = Base64.decodeBase64(file1);
            byte[] valueDecoded2 = Base64.decodeBase64(file2);

            String vd1 = Arrays.toString(valueDecoded1);
            String vd2 = Arrays.toString(valueDecoded2);

            accountCall.chequeDepositMoney(
                    accountId,
                    debitAccountId,
                    200,
                    narration,
                    documentRef,
                    postBy,
                    appBy,
                    postTerminal,
                    customerTel,
                    transBy,
                    chequeNumber,
                    vd1,
                    vd2
            );
        } catch (IOException ex) {
            Logger.getLogger(AccountApiController.class.getName()).log(Level.SEVERE, null, ex);
            response = new ResponseEntity(
                    (Object) new NotFound(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        } catch (SQLException ex) {
            Logger.getLogger(AccountApiController.class.getName()).log(Level.SEVERE, null, ex);
            response = new ResponseEntity(
                    (Object) new NotFound(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        } catch (Exception ex) {
            Logger.getLogger(AccountApiController.class.getName()).log(Level.SEVERE, null, ex);
            response = new ResponseEntity(
                    (Object) new NotFound(
                            HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        return response;

    }
}
