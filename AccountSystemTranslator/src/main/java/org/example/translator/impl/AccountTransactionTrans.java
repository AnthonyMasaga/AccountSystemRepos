package org.example.translator.impl;

import org.example.domain.dto.AccountTransactionDto;
import org.example.domain.dto.AccountTypeDto;
import org.example.domain.persistence.AccountTransaction;
import org.example.domain.persistence.AccountType;

import java.util.List;

public interface AccountTransactionTrans {
    List<AccountTransactionDto> getAccountTransactions();
    List<AccountTransactionDto> getAccountAllTransaction();
    AccountTransactionDto create(AccountTransactionDto AccountTransaction);
    AccountTransactionDto save(AccountTransactionDto AccountTransaction);

    AccountTransactionDto getAccountTypeDtoByMnemonic(Long memberId);
    void someMethod();

    AccountType getAccountTypeByDbEntityByMnemonic(Long memberId);
    void delete(AccountTransaction accountTransaction);

}
