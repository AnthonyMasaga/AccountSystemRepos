package org.example.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "AccountTransaction")
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = -2282337134058330518L;
    private Long Id;
    private AccountType accountTypes;
    private User user;
    private double amount;
    private String transType;

    @ManyToOne
    @JoinColumn(name = "account_type_account_type_id")
    private AccountType accountType;

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }


    public AccountTransaction() {
    }

    public AccountTransaction(Long id, AccountType accountTypes, User user, double amount, String transType) {
        Id = id;
        this.accountTypes = accountTypes;
        this.user = user;
        this.amount = amount;
        this.transType = transType;
    }
    @Id
    @SequenceGenerator(name="SEQ_Transactions",sequenceName = "Transaction_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Transactions")
    @Column(name = "transactionID")

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "AccountTypeID")
    public AccountType getAccountTypes() {
        return accountTypes;
    }

    public void setAccountTypes(AccountType accountTypes) {
        this.accountTypes = accountTypes;
    }
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Column(name = "amount")

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    @Column(name = "TransactionType")

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(Id, that.Id) && Objects.equals(accountTypes, that.accountTypes) && Objects.equals(user, that.user) && Objects.equals(transType, that.transType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, accountTypes, user, amount, transType);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "Id=" + Id +
                ", accountTypes=" + accountTypes +
                ", user=" + user +
                ", amount=" + amount +
                ", transType='" + transType + '\'' +
                '}';
    }
}
