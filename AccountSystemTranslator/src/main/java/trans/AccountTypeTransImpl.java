package trans;

import org.example.domain.dto.AccountTypeDto;
import org.example.domain.persistence.AccountTransaction;
import org.example.domain.persistence.AccountType;
import org.example.repository.persistence.AccountTypeRepo;
import org.example.translator.impl.AccountTypeTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Transactional
@Component
public class AccountTypeTransImpl implements AccountTypeTrans {
    private AccountTypeRepo accountTypeRepo;

    @Autowired
    public AccountTypeTransImpl(AccountTypeRepo accountTypeRepo) {
        this.accountTypeRepo = accountTypeRepo;
    }


    @Override
    public List<AccountTypeDto> getAccountTypes() {
        List<AccountTypeDto> theaccountTypes = new ArrayList<>();
        try {
            for (AccountType account : accountTypeRepo.findAll()) {
                theaccountTypes.add(new AccountTypeDto(account));
            }
        } catch (Exception e) {
            throw new RuntimeException("Cannot get The account types", e);
        }
        return theaccountTypes;
    }

    @Override
    public void deleteAccountType(String nmonic) {
        try {
            accountTypeRepo.deleteByNmonic(nmonic);
        } catch (Exception e) {
            throw new RuntimeException("Cannot get delete account type", e);
        }
    }


    @Override
    public AccountTypeDto getAccountType(String nmonic) {
        AccountTypeDto accountTypeDto;
        try {
            accountTypeDto = new AccountTypeDto(accountTypeRepo.getAccountType(nmonic));
        } catch (Exception e) {
            throw new RuntimeException("Cannot get The account type", e);
        }
        return accountTypeDto;
    }

    @Override
    public AccountTypeDto addAccountType(AccountTypeDto accountTypeDto) {
        return null;
    }
}

