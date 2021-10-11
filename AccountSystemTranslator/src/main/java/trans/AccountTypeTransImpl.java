package trans;

import org.example.domain.dto.AccountTypeDto;
import org.example.domain.persistence.AccountTransaction;
import org.example.domain.persistence.AccountType;
import org.example.repository.persistence.AccountTypeRepo;
import org.example.translator.impl.AccountTypeTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class AccountTypeTransImpl implements AccountTypeTrans {
    private final AccountTypeRepo accountTypeRepo;

    @Autowired
    public AccountTypeTransImpl(AccountTypeRepo accountTypeRepo) {
        this.accountTypeRepo = accountTypeRepo;
    }

    @Override
    public List<AccountTypeDto> getAccountTypes() {
        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        try {
            for(AccountType accountType:accountTypeRepo.findAll()){
                accountTypeDtos.add(new AccountTypeDto((Set<AccountTransaction>) accountType));
            }
        }catch (Exception e){
            throw new RuntimeException("Cannot get account types from the db",e);
        }
        return accountTypeDtos;

    }

    @Override
    public AccountTypeDto create(AccountTypeDto AccountType) {
        return null;
    }

    @Override
    public AccountTypeDto save(AccountTypeDto AccountType) {
        return null;
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic) {
        return null;
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic) {
        return null;
    }

    @Override
    public AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic) {
        return null;
    }

    @Override
    public void someMethod() {

    }

    @Override
    public AccountType getAccountTypeByDbEntityByMnemonic(String mnemonic) {
        return null;
    }

    @Override
    public void delete(AccountType accountType) {

    }
}

