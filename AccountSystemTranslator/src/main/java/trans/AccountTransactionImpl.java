package trans;

import org.example.domain.dto.AccountTransactionDto;
import org.example.domain.dto.AccountTypeDto;
import org.example.domain.persistence.AccountTransaction;
import org.example.domain.persistence.AccountType;
import org.example.repository.persistence.AccountTransactionRepo;
import org.example.repository.persistence.AccountTypeRepo;
import org.example.translator.impl.AccountTransactionTrans;
import org.example.translator.impl.AccountTypeTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class AccountTransactionImpl implements AccountTransactionTrans{
    private final AccountTransactionRepo accountTransactionRepo;

    @Autowired
    public AccountTransactionImpl(AccountTransactionRepo accountTransactionRepo) {
        this.accountTransactionRepo = accountTransactionRepo;
    }

    @Override
    public List<AccountTransactionDto> getAccountTransactions() {
        List<AccountTransactionDto> accountTransactionDtos = new ArrayList<>();
        try {
            for(AccountTransaction accountTransaction :accountTransactionRepo.findAll()){
                accountTransactionDtos .add(new AccountTransactionDto((Set<AccountType>) accountTransaction));
            }
        }catch (Exception e){
            throw new RuntimeException("Cannot get account transactions from the db",e);
        }
        return  accountTransactionDtos;

    }

    @Override
    public List<AccountTransactionDto> getAccountAllTransaction() {
        return null;
    }

    @Override
    public AccountTransactionDto create(AccountTransactionDto AccountTransaction) {
        return null;
    }

    @Override
    public AccountTransactionDto save(AccountTransactionDto AccountTransaction) {
        return null;
    }

    @Override
    public AccountTransactionDto getAccountTypeDtoByMnemonic(Long memberId) {
        return null;
    }

    @Override
    public void someMethod() {

    }

    @Override
    public AccountType getAccountTypeByDbEntityByMnemonic(Long memberId) {
        return null;
    }

    @Override
    public void delete(AccountTransaction accountTransaction) {

    }
}

