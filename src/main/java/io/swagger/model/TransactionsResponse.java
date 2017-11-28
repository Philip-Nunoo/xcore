/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.model;

import envtest.model.TransEnquiry;
import java.util.ArrayList;

/**
 *
 * @author Philip
 */
public class TransactionsResponse {
    private int responseCode;
    private int length;
    private String message;
    private ArrayList<TransEnquiry> transactions;

    public int getLength() {
        return length;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<TransEnquiry> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<TransEnquiry> transactions) {
        this.transactions = transactions;
        this.length = transactions.size();
    }

    @Override
    public String toString() {
        return "TransactionsResponse{" + "responseCode=" + responseCode + ", length=" + length + ", message=" + message + ", transactions=" + transactions + '}';
    }
    
}
