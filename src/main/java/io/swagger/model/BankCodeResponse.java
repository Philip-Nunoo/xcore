/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.model;

import envtest.model.BankCode;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Philip
 */
public class BankCodeResponse {
    private String message;
    private int responseCode;
    private int length;
    private ArrayList<BankCode> bankCodes;

    public BankCodeResponse() {
    }

    public BankCodeResponse(String message, int responseCode, ArrayList<BankCode> bankCodes) {
        this.message = message;
        this.responseCode = responseCode;
        this.bankCodes = bankCodes;
        
        this.length = bankCodes.size();
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ArrayList<BankCode> getBankCodes() {
        return bankCodes;
    }

    public void setBankCodes(ArrayList<BankCode> bankCodes) {
        this.bankCodes = bankCodes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.message);
        hash = 47 * hash + Objects.hashCode(this.responseCode);
        hash = 47 * hash + this.length;
        hash = 47 * hash + Objects.hashCode(this.bankCodes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BankCodeResponse other = (BankCodeResponse) obj;
        if (this.length != other.length) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (!Objects.equals(this.responseCode, other.responseCode)) {
            return false;
        }
        if (!Objects.equals(this.bankCodes, other.bankCodes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BankCodeResponse{" + "message=" + message + ", responseCode=" + responseCode + ", length=" + length + ", bankCodes=" + bankCodes + '}';
    }
 
}
