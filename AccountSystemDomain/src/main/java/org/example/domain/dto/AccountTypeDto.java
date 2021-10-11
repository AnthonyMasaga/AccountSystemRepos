package org.example.domain.dto;

import org.example.domain.persistence.AccountTransaction;

import java.time.LocalDate;
import java.util.Set;

public class AccountTypeDto {
    private Long accountID;
    private String mnemonic;
    private String accountName;
    private LocalDate creationDate;
    private Set<AccountTransaction> accountTransactions;

    public AccountTypeDto() {
    }

    public AccountTypeDto(String mnemonic, String accountName, LocalDate creationDate) {
        this.mnemonic = mnemonic;
        this.accountName = accountName;
        this.creationDate = creationDate;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

   public AccountTypeDto(Set<AccountTransaction> accountTransactions) {
       this.accountTransactions = accountTransactions;
    }

    @Override
    public String toString() {
        return "AccountTypeDto{" +
                "accountID=" + accountID +
                ", mnemonic='" + mnemonic + '\'' +
                ", accountName='" + accountName + '\'' +
                ", creationDate=" + creationDate +
                ", accountTransactions=" + accountTransactions +
                '}';
    }
}
