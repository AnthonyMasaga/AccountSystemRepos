package trans;

import org.example.domain.dto.AccountTransactionDto;
import org.example.domain.persistence.AccountTransaction;
import org.example.domain.persistence.AccountType;
import org.example.domain.persistence.User;
import org.example.repository.persistence.AccountTransactionRepo;
import org.example.repository.persistence.AccountTypeRepo;
import org.example.repository.persistence.UserRepo;
import org.example.translator.impl.AccountTransactionTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class AccountTransactionImpl implements AccountTransactionTrans {
    private AccountTransactionRepo accountTransactionRepo;
    private UserRepo userRepo;
    private AccountTypeRepo accountTypeRepo;

    @Autowired
    public AccountTransactionImpl(AccountTransactionRepo accountTransactionRepo, UserRepo userRepo, AccountTypeRepo accountTypeRepo) {
        this.accountTransactionRepo = accountTransactionRepo;
        this. userRepo =  userRepo;
        this.accountTypeRepo = accountTypeRepo;
    }


    @Override
    public List<AccountTransactionDto> getmemberTransaction(String email) {
        List<AccountTransactionDto> Userstransactions = new ArrayList<>();
        try {
            for (AccountTransaction account:accountTransactionRepo.getUserTransactions(email)){
                Userstransactions.add(new AccountTransactionDto(account));
            }
        }catch (Exception e){
            throw new RuntimeException("Cannot get the user transactions",e);
        }
        return Userstransactions;
    }

    @Override
    public void deleteMemberTransaction(String email) {
        try {
            accountTransactionRepo.deleteUserTransactions(email);
        }catch (Exception e){
            throw new RuntimeException("Cannot delete the user transactions",e);
        }

    }

    @Override
    public AccountTransactionDto addTransaction(AccountTransactionDto accountTransactionDto) {
       User user;
        AccountType account;
        AccountTransaction accountTransaction;
        try {
            user = userRepo.getUserByEmail(accountTransactionDto.getUser().getEmail());
            account = accountTypeRepo.getAccountType(accountTransactionRepo.getTypeAccount().getNmonic());
            accountTransaction= accountTransactionDto.buildTransaction(account,user);
           accountTransactionRepo.save(accountTransaction);
        }catch (Exception e){
            throw new RuntimeException("Cannot get the user transactions",e);
        }
        return null;
    }

}
