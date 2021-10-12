package org.example.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.domain.persistence.AccountTransaction;
import org.example.domain.persistence.AccountType;
import org.example.domain.persistence.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

public class AccountTransactionDto implements Serializable {
    private AccountType accountTypes;
    private User user;
    private double amount;
    private String transType;


    public AccountTransactionDto() {
    }

    public AccountTransactionDto(AccountType accountTypes, User user, double amount, String transType) {
        this.accountTypes = accountTypes;
        this.user = user;
        this.amount = amount;
        this.transType = transType;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction) {
        this.amount = accountTransaction.getAmount();
        this.transType = accountTransaction.getTransType();


    }
    @JsonIgnore
    public AccountTransaction buildTransaction(AccountType typeAccount,User user){
        return new AccountTransaction(null,typeAccount,user,this.getAmount(),this.getTransType());
    }

    public AccountType getAccountTypes() {
        return accountTypes;
    }

    public void setAccountTypes(AccountType accountTypes) {
        this.accountTypes = accountTypes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "accountTypes=" + accountTypes +
                ", user=" + user +
                ", amount=" + amount +
                ", transType='" + transType + '\'' +
                '}';
    }
}
