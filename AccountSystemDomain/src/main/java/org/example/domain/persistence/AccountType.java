package org.example.domain.persistence;


import org.example.domain.dto.AccountTypeDto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "AccountType")
public class AccountType implements Serializable {
    private static final long serialVersionUID = -2282337134058330518L;
    private Long accountID;
    private String mnemonic;
    private String accountName;
    private LocalDate creationDate;
    private Set<AccountTransaction> accountTransactions;

    public AccountType() {
    }

    public AccountType(Long accountID, String mnemonic, String accountName, LocalDate creationDate) {
        this.accountID = accountID;
        this.mnemonic = mnemonic;
        this.accountName = accountName;
        this.creationDate = creationDate;
    }

    public AccountType(Long accountID, String mnemonic, String accountName, LocalDate creationDate, Set<AccountTransaction> accountTransactions) {
        this.accountID = accountID;
        this.mnemonic = mnemonic;
        this.accountName = accountName;
        this.creationDate = creationDate;
        this.accountTransactions = accountTransactions;
    }

    @Id
    @SequenceGenerator(name = "SEQ_TypeAccount", sequenceName = "AcountType_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TypeAccount")
    @Column(name = "AccountTypeID")

    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    @Column(name = "mnemonic")

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @Column(name = "accountName")

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Column(name = "creationDate")

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

   // @Column(name = "accountTransactions")





    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType", cascade = CascadeType.ALL)
    public Set<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(accountID, that.accountID) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountName, that.accountName) && Objects.equals(creationDate, that.creationDate) && Objects.equals(accountTransactions, that.accountTransactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountID, mnemonic, accountName, creationDate, accountTransactions);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountID=" + accountID +
                ", mnemonic='" + mnemonic + '\'' +
                ", accountName='" + accountName + '\'' +
                ", creationDate=" + creationDate +
                ", accountTransactions=" + accountTransactions +
                '}';
    }


}

