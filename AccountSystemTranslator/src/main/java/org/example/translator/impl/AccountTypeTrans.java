package org.example.translator.impl;

import org.example.domain.dto.AccountTypeDto;
import org.example.domain.persistence.AccountType;

import java.util.List;

public interface AccountTypeTrans {
        List<AccountTypeDto> getAccountTypes();
        void deleteAccountType(String nmonic);
        AccountTypeDto getAccountType(String nmonic);
        AccountTypeDto addAccountType(AccountTypeDto accountTypeDto);


}
