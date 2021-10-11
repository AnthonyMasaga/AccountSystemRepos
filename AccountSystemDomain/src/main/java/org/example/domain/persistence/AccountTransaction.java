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
    private Long transactionID;
    private Long memberId;
    private Long amount;
    private LocalDate TransDate;
    private Set<AccountType> accountTypes;



    public AccountTransaction() {
    }

    public AccountTransaction(Long transactionID, Long memberId, Long amount, LocalDate transDate) {
        this.transactionID = transactionID;
        this.memberId = memberId;
        this.amount = amount;
        TransDate = transDate;
    }
    public AccountTransaction(Long memberId, Long amount, LocalDate transDate) {
        this.memberId = memberId;
        this.amount = amount;
        TransDate = transDate;
    }
    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIT_RSA_GENERIC_SEQ")
    @Column(name = "transactionID")

    public Long getTransactionID() {
        return transactionID;
    }
    @Column(name = "MEMBERID")

    public Long getMemberId() {
        return memberId;
    }
    @Column(name = "AMOUNT")

    public Long getAmount() {
        return amount;
    }
    @Column(name = "TRANSACTIONDATE")

    public LocalDate getTransDate() {
        return TransDate;
    }



    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountID")
    public Set<AccountType> AccountType()
    {       return accountTypes;
    }
    public AccountTransaction(Set<AccountType> accountTypes) {
        this.accountTypes = accountTypes;
    }


    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setTransDate(LocalDate transDate) {
        TransDate = transDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transactionID, that.transactionID) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(TransDate, that.TransDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, memberId, amount, TransDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionID=" + transactionID +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", TransDate=" + TransDate +
                '}';
    }
}
