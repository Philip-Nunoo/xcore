/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class Account {
    
    private String acctLink = null;    
    private String acctName = null;
    private String currency = null;
    private String product = null;
    private Balance balance = null;
    private String email = null;
    
    public Account() {
    }

    public String getAcctLink() {
        return acctLink;
    }

    public void setAcctLink(String acctLink) {
        this.acctLink = acctLink;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
        this.product = balance.getProduct();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getProduct() {
        return this.balance.getProduct();
    }

    public void setProduct(String product) {
        this.balance.setProduct(product);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" + "acctLink=" + acctLink + ", acctName=" + acctName + ", currency=" + currency + ", product=" + product + ", balance=" + balance + ", email=" + email + '}';
    }

 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.acctLink);
        hash = 17 * hash + Objects.hashCode(this.acctName);
        hash = 17 * hash + Objects.hashCode(this.balance);
        hash = 17 * hash + Objects.hashCode(this.currency);
        hash = 17 * hash + Objects.hashCode(this.product);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (!Objects.equals(this.acctLink, other.acctLink)) {
            return false;
        }
        if (!Objects.equals(this.acctName, other.acctName)) {
            return false;
        }
        if (!Objects.equals(this.balance, other.balance)) {
            return false;
        }
        if (!Objects.equals(this.currency, other.currency)) {
            return false;
        }
        return true;
    }

}
