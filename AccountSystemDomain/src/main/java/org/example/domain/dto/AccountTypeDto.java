package org.example.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.domain.persistence.AccountTransaction;
import org.example.domain.persistence.AccountType;

import java.time.LocalDate;
import java.util.Set;

public class AccountTypeDto {
    private String accountName;
    private String nmonic;

    public AccountTypeDto() {
    }

    public AccountTypeDto(String accountName, String nmonic) {
        this.accountName = accountName;
        this.nmonic = nmonic;
    }
    public AccountTypeDto(AccountType accountType){
        this.accountName = accountType. getAccountName();
        this.nmonic = accountType.getMnemonic();
    }
    @JsonIgnore
    public AccountType buildTypeaccount(AccountTypeDto  accountTypeDtos){
        return new AccountType(null,this.getAccountName(),this.getNmonic(),LocalDate.now());
    }

    public String getAccountName() {
        return accountName;
    }

    public void setName(String name) {
        this.accountName = accountName;
    }

    public String getNmonic() {
        return nmonic;
    }

    public void setNmonic(String nmonic) {
        this.nmonic = nmonic;
    }

    @Override
    public String toString() {
        return "AccountTypeDto{" +
                "name='" + accountName + '\'' +
                ", nmonic='" + nmonic + '\'' +
                '}';
    }
}
