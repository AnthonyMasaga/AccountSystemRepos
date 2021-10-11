package org.example.translator.impl;

import org.example.domain.dto.AccountTypeDto;
import org.example.domain.persistence.AccountType;

import java.util.List;

public interface AccountTypeTrans {
        List<AccountTypeDto> getAccountTypes();
        AccountTypeDto create(AccountTypeDto AccountType);
        AccountTypeDto save(AccountTypeDto AccountType);
        AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic);
        AccountTypeDto getAccountTypeByMnemonic(String mnemonic);
        AccountTypeDto  getAccountTypeDtoByMnemonic(String mnemonic);
        void someMethod();

        AccountType getAccountTypeByDbEntityByMnemonic(String mnemonic);
        void delete(AccountType accountType);


}
