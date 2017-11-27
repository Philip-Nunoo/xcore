package io.swagger.api;

import io.swagger.model.ApiSuccessResponse;

import io.swagger.annotations.*;

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

    public ResponseEntity<ApiSuccessResponse> requestChequeBookPost(@ApiParam(value = "", required=true) @RequestPart(value="accountId", required=true)  String accountId,
        @ApiParam(value = "", required=true) @RequestPart(value="currency", required=true)  String currency,
        @ApiParam(value = "The document number", required=true) @RequestPart(value="docNumber", required=true)  String docNumber,
        @ApiParam(value = "Number of leaves", required=true) @RequestPart(value="leaves", required=true)  String leaves,
        @ApiParam(value = "", required=true) @RequestPart(value="deliveryChannel", required=true)  String deliveryChannel,
        @ApiParam(value = "", required=true) @RequestPart(value="deliveryBranch", required=true)  String deliveryBranch) {
        // do some magic!
        return new ResponseEntity<ApiSuccessResponse>(HttpStatus.OK);
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

    public ResponseEntity<ApiSuccessResponse> requestStopCheckPost(@ApiParam(value = "", required=true) @RequestPart(value="accountId", required=true)  String accountId,
        @ApiParam(value = "", required=true) @RequestPart(value="chequeNumber", required=true)  String chequeNumber,
        @ApiParam(value = "", required=true) @RequestPart(value="reason", required=true)  String reason) {
        // do some magic!
        return new ResponseEntity<ApiSuccessResponse>(HttpStatus.OK);
    }

}
