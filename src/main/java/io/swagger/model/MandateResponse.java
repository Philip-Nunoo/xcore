/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import envtest.model.MandateEnquiry;
import java.util.ArrayList;

/**
 *
 * @author UG
 */
public class MandateResponse {
    
    private int responseCode = 404;
    private String message;
    private ArrayList<envtest.model.MandateEnquiry> mandates = new ArrayList<envtest.model.MandateEnquiry>();

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

    public ArrayList<MandateEnquiry> getMandates() {
        return mandates;
    }

    public void setMandates(ArrayList<MandateEnquiry> mandates) {
        this.mandates = mandates;
    }

    @Override
    public String toString() {
        return "MandateResponse{" + "responseCode=" + responseCode + ", message=" + message + ", mandates=" + mandates + '}';
    }
    
    
}
