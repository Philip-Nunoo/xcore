/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.ApiSuccessResponse;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-10T09:55:07.361Z")

@Api(value = "request", description = "the request API")
public interface RequestApi {

    @ApiOperation(value = "Service Request(ATM)", notes = "Request for an atm from core", response = ApiSuccessResponse.class, authorizations = {
        @Authorization(value = "apiKey"),
        @Authorization(value = "apiSecret")
    }, tags={ "Request", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ApiSuccessResponse.class) })
    
    @RequestMapping(value = "/request/atm",
        produces = { "application/json" }, 
        consumes = { "application/x-www-form-urlencoded" },
        method = RequestMethod.POST)
    ResponseEntity<ApiSuccessResponse> requestAtmPost(@ApiParam(value = "", required=true) @RequestPart(value="accountId", required=true)  String accountId,@ApiParam(value = "", required=true) @RequestPart(value="displayName", required=true)  String displayName,@ApiParam(value = "", required=true) @RequestPart(value="deliveryMethod", required=true)  String deliveryMethod,@ApiParam(value = "", required=true) @RequestPart(value="cardType", required=true)  String cardType);


    @ApiOperation(value = "Service Request(Cheque book)", notes = "Request for cheque book from core", response = ApiSuccessResponse.class, authorizations = {
        @Authorization(value = "apiKey"),
        @Authorization(value = "apiSecret")
    }, tags={ "Request", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ApiSuccessResponse.class) })
    
    @RequestMapping(value = "/request/cheque-book",
        produces = { "application/json" }, 
        consumes = { "application/x-www-form-urlencoded" },
        method = RequestMethod.POST)
    ResponseEntity<ApiSuccessResponse> requestChequeBookPost(@ApiParam(value = "", required=true) @RequestPart(value="accountId", required=true)  String accountId,@ApiParam(value = "", required=true) @RequestPart(value="currency", required=true)  String currency,@ApiParam(value = "The document number", required=true) @RequestPart(value="docNumber", required=true)  String docNumber,@ApiParam(value = "Number of leaves", required=true) @RequestPart(value="leaves", required=true)  String leaves,@ApiParam(value = "", required=true) @RequestPart(value="deliveryChannel", required=true)  String deliveryChannel,@ApiParam(value = "", required=true) @RequestPart(value="deliveryBranch", required=true)  String deliveryBranch);


    @ApiOperation(value = "Service Request(Email)", notes = "Request for email from core", response = ApiSuccessResponse.class, authorizations = {
        @Authorization(value = "apiKey"),
        @Authorization(value = "apiSecret")
    }, tags={ "Request", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ApiSuccessResponse.class) })
    
    @RequestMapping(value = "/request/email",
        produces = { "application/json" }, 
        consumes = { "application/x-www-form-urlencoded" },
        method = RequestMethod.POST)
    ResponseEntity<ApiSuccessResponse> requestEmailPost(@ApiParam(value = "", required=true) @RequestPart(value="accountId", required=true)  String accountId,@ApiParam(value = "", required=true) @RequestPart(value="emailAddress", required=true)  String emailAddress);


    @ApiOperation(value = "Service Request(SMS)", notes = "Request for sms from core", response = ApiSuccessResponse.class, authorizations = {
        @Authorization(value = "apiKey"),
        @Authorization(value = "apiSecret")
    }, tags={ "Request", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ApiSuccessResponse.class) })
    
    @RequestMapping(value = "/request/sms",
        produces = { "application/json" }, 
        consumes = { "application/x-www-form-urlencoded" },
        method = RequestMethod.POST)
    ResponseEntity<ApiSuccessResponse> requestSmsPost(@ApiParam(value = "", required=true) @RequestPart(value="serviceType", required=true)  String serviceType,@ApiParam(value = "", required=true) @RequestPart(value="bbanNumber", required=true)  String bbanNumber,@ApiParam(value = "", required=true) @RequestPart(value="currencyCode", required=true)  String currencyCode,@ApiParam(value = "", required=true) @RequestPart(value="phoneNumber", required=true)  String phoneNumber);


    @ApiOperation(value = "Service Request(Stop Check)", notes = "Request for stop a check from core", response = ApiSuccessResponse.class, authorizations = {
        @Authorization(value = "apiKey"),
        @Authorization(value = "apiSecret")
    }, tags={ "Request", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ApiSuccessResponse.class) })
    
    @RequestMapping(value = "/request/stop-check",
        produces = { "application/json" }, 
        consumes = { "application/x-www-form-urlencoded" },
        method = RequestMethod.POST)
    ResponseEntity<ApiSuccessResponse> requestStopCheckPost(@ApiParam(value = "", required=true) @RequestPart(value="accountId", required=true)  String accountId,@ApiParam(value = "", required=true) @RequestPart(value="chequeNumber", required=true)  String chequeNumber,@ApiParam(value = "", required=true) @RequestPart(value="reason", required=true)  String reason);

}
