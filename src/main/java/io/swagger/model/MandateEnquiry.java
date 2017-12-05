/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.swagger.model;

/**
 *
 * @author UG
 */
public class MandateEnquiry {
    
    
    private String signature ;
    
    private String photograph ;

  

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPhotograph() {
        return photograph;
    }

    public void setPhotograph(String photograph) {
        this.photograph = photograph;
    }

  
    @Override
    public String toString() {
        return "MandateEnquiry{" + "signature=" + signature + ", photograph=" + photograph + '}';
    }
    
}
