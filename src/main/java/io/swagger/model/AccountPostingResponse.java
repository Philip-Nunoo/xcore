/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Philip
 */
public class AccountPostingResponse {
    @JsonProperty("responseCode")
    private double responseCode;
    
    @JsonProperty("message")
    private String message;

    public AccountPostingResponse(double responseCode, String message) {        
        this.responseCode = responseCode;
        this.message = message;
    }
    
    public double getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(double responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AccountPostingResponse{" + "responseCode=" + responseCode + ", message=" + message + '}';
    }
    
}
