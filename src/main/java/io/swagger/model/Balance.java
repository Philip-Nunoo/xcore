package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Balance
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-10T09:55:07.361Z")

public class Balance extends envtest.model.Balance{
    
    @JsonProperty("product")
    private String product= null;
    
    @JsonProperty("accountName")
    private String accountName= null;
    
    @JsonProperty("noOfHolder")
    private String noOfHolder= null;
    
    @JsonProperty("brCode")
    private String brCode= null;
    
    @JsonProperty("riskCode")
    private String riskCode= null;
    
    @JsonProperty("blkAmt")
    private String blkAmt= null;
    
    @JsonProperty("odAmount")
    private String odAmount= null;
    
    @JsonProperty("lienAmt")
    private String lienAmt= null;
    
    @JsonProperty("avBalance")
    private String avBalance= null;
    
    @JsonProperty("avBalanceSsh")
    private String avBalanceSsh= null;
    
    @JsonProperty("bkBalance")
    private String bkBalance= null;
    
    @JsonProperty("bkBalSsh")
    private String bkBalSsh= null;
    
     @JsonProperty("lastDBTransDate")
    private String  lastDBTransDate = null;
     
    @JsonProperty("lastCDTransDate")
    private String  lastCDTransDate = null;
      
    @JsonProperty("statusDesc")
    private String  statusDesc = null;
       
    @JsonProperty("statusCode")
    private String  statusCode = null;
    

    public Balance() {
        super();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.product);
        hash = 29 * hash + Objects.hashCode(this.accountName);
        hash = 29 * hash + Objects.hashCode(this.noOfHolder);
        hash = 29 * hash + Objects.hashCode(this.brCode);
        hash = 29 * hash + Objects.hashCode(this.riskCode);
        hash = 29 * hash + Objects.hashCode(this.blkAmt);
        hash = 29 * hash + Objects.hashCode(this.odAmount);
        hash = 29 * hash + Objects.hashCode(this.lienAmt);
        hash = 29 * hash + Objects.hashCode(this.avBalance);
        hash = 29 * hash + Objects.hashCode(this.avBalanceSsh);
        hash = 29 * hash + Objects.hashCode(this.bkBalance);
        hash = 29 * hash + Objects.hashCode(this.bkBalSsh);
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
        final Balance other = (Balance) obj;
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.accountName, other.accountName)) {
            return false;
        }
        if (!Objects.equals(this.noOfHolder, other.noOfHolder)) {
            return false;
        }
        if (!Objects.equals(this.brCode, other.brCode)) {
            return false;
        }
        if (!Objects.equals(this.riskCode, other.riskCode)) {
            return false;
        }
        if (!Objects.equals(this.blkAmt, other.blkAmt)) {
            return false;
        }
        if (!Objects.equals(this.odAmount, other.odAmount)) {
            return false;
        }
        if (!Objects.equals(this.lienAmt, other.lienAmt)) {
            return false;
        }
        if (!Objects.equals(this.avBalance, other.avBalance)) {
            return false;
        }
        if (!Objects.equals(this.avBalanceSsh, other.avBalanceSsh)) {
            return false;
        }
        if (!Objects.equals(this.bkBalance, other.bkBalance)) {
            return false;
        }
        if (!Objects.equals(this.bkBalSsh, other.bkBalSsh)) {
            return false;
        }
        return true;
    }
    
    
}
