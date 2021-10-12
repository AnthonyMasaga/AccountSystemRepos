package org.example.translator.impl;

import org.example.domain.dto.AccountTransactionDto;
import org.example.domain.dto.AccountTypeDto;

import java.util.List;

public interface AccountTransactionTrans {
    List<AccountTransactionDto> getmemberTransaction(String email);
    void deleteMemberTransaction(String email);
    AccountTransactionDto addTransaction(AccountTransactionDto accountTransactionDto);}


