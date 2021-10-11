package org.example.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Account_type")
public class AccountType implements Serializable
{
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
    public AccountType( String mnemonic, String accountName, LocalDate creationDate) {
        this.mnemonic = mnemonic;
        this.accountName = accountName;
        this.creationDate = creationDate;
    }
    @Id
    @SequenceGenerator(name = "VIT-RSA-GENERIC_SEQ", sequenceName = "VITRSA_SANDBOX_VIT_RSA_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIT_RSA_GENERIC_SEQ")
    @Column(name = "AccountID")
    public Long getAccountID() {
        return accountID;
    }

    @Column(name = "MNEMONIC")
    public String getMnemonic() {
        return mnemonic;
    }
    @Column(name = "ACCOUNT_NAME")

    public String getAccountName() {
        return accountName;
    }
    @Column(name = "CREATION_DATE")

    public LocalDate getCreationDate() {
        return creationDate;
    }
    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType", orphanRemoval = true,cascade = CascadeType.PERSIST )
    public Set<AccountTransaction> AccountTransaction()
{       return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
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
                ",accountTransactions=" + accountTransactions +
                '}';
    }
}

