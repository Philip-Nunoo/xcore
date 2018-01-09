/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class CustomerResponse {
    @JsonProperty("length")
    private int length = 0;
    
    @JsonProperty("message")
    private String message;

    @JsonProperty("responseCode")
    private int responseCode;
    
    @JsonProperty("customers")
    private ArrayList<Customer> customers = new ArrayList<>();

    public CustomerResponse(int responseCode, String message, ArrayList<Customer> customers) {
        this.responseCode = responseCode;
        this.message = message;
        this.customers = customers;
        this.length = customers.size();
    }
    
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public String toString() {
        return "CustomerResponse{" + "length=" + length + ", customers=" + customers + ", message=" + message + ", responseCode=" + responseCode + '}';
    }    

}
