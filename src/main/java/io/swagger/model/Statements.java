package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Statements
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-10T09:55:07.361Z")

public class Statements   {
  @JsonProperty("accountId")
  private Long accountId = null;

  @JsonProperty("ledgerBalance")
  private Long ledgerBalance = null;

  @JsonProperty("availableBalance")
  private Long availableBalance = null;

  @JsonProperty("currencyCode")
  private String currencyCode = null;

  @JsonProperty("accountType")
  private String accountType = null;

  @JsonProperty("transactions")
  private List<Statement> transactions = null;

  public Statements accountId(Long accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   * The user account id
   * @return accountId
  **/
  @ApiModelProperty(value = "The user account id")


  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public Statements ledgerBalance(Long ledgerBalance) {
    this.ledgerBalance = ledgerBalance;
    return this;
  }

   /**
   * The ledger Balance
   * @return ledgerBalance
  **/
  @ApiModelProperty(value = "The ledger Balance")


  public Long getLedgerBalance() {
    return ledgerBalance;
  }

  public void setLedgerBalance(Long ledgerBalance) {
    this.ledgerBalance = ledgerBalance;
  }

  public Statements availableBalance(Long availableBalance) {
    this.availableBalance = availableBalance;
    return this;
  }

   /**
   * The available Balance on the account.
   * @return availableBalance
  **/
  @ApiModelProperty(value = "The available Balance on the account.")


  public Long getAvailableBalance() {
    return availableBalance;
  }

  public void setAvailableBalance(Long availableBalance) {
    this.availableBalance = availableBalance;
  }

  public Statements currencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

   /**
   * The currency code
   * @return currencyCode
  **/
  @ApiModelProperty(value = "The currency code")


  public String getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public Statements accountType(String accountType) {
    this.accountType = accountType;
    return this;
  }

   /**
   * The account type
   * @return accountType
  **/
  @ApiModelProperty(value = "The account type")


  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public Statements transactions(List<Statement> transactions) {
    this.transactions = transactions;
    return this;
  }

  public Statements addTransactionsItem(Statement transactionsItem) {
    if (this.transactions == null) {
      this.transactions = new ArrayList<Statement>();
    }
    this.transactions.add(transactionsItem);
    return this;
  }

   /**
   * Get transactions
   * @return transactions
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Statement> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<Statement> transactions) {
    this.transactions = transactions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Statements statements = (Statements) o;
    return Objects.equals(this.accountId, statements.accountId) &&
        Objects.equals(this.ledgerBalance, statements.ledgerBalance) &&
        Objects.equals(this.availableBalance, statements.availableBalance) &&
        Objects.equals(this.currencyCode, statements.currencyCode) &&
        Objects.equals(this.accountType, statements.accountType) &&
        Objects.equals(this.transactions, statements.transactions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, ledgerBalance, availableBalance, currencyCode, accountType, transactions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Statements {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    ledgerBalance: ").append(toIndentedString(ledgerBalance)).append("\n");
    sb.append("    availableBalance: ").append(toIndentedString(availableBalance)).append("\n");
    sb.append("    currencyCode: ").append(toIndentedString(currencyCode)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

