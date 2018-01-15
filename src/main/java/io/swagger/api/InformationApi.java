/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.model.BankCodeResponse;
import io.swagger.model.NotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Philip
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-10T09:55:07.361Z")

@Api(value = "Information", description = "The Info API")
public interface InformationApi {

    @ApiOperation(
            value = "Get x100 bank codes",
            notes = "Get various bank codes",
            response = BankCodeResponse.class,
            authorizations = {
                @Authorization(value = "apiKey")
                , @Authorization(value = "apiSecret")},
            tags = {"Information",}
    )
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = BankCodeResponse.class)
        ,
        @ApiResponse(code = 401, message = "API key is missing or invalid", response = Void.class)
        ,
        @ApiResponse(code = 404, message = "Account not found", response = NotFound.class)
    })

    @RequestMapping(value = "/info/bank-codes",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Object> getBankCodeInfomation();
}
