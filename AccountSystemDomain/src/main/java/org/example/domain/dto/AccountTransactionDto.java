package org.example.domain.dto;


import org.example.domain.persistence.AccountTransaction;
import org.example.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

public class AccountTransactionDto implements Serializable {
    private Long memberId;
    private Long amount;
    private LocalDate TransDate;
    private Set<AccountType> accountTypes;


    public AccountTransactionDto() {
    }

    public AccountTransactionDto(Long memberId, Long amount, LocalDate transDate) {
        this.memberId = memberId;
        this.amount = amount;
        TransDate = transDate;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDate getTransDate() {
        return TransDate;
    }

    public void setTransDate(LocalDate transDate) {
        TransDate = transDate;
    }

    public AccountTransactionDto(Set<AccountType> accountTypes) {
        this.accountTypes= accountTypes;
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "memberId=" + memberId +
                ", amount=" + amount +
                ", TransDate=" + TransDate +
                '}';
    }
}
