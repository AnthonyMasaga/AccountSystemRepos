package impl.flow;

import impl.AccountTransactionLogic;
import org.example.domain.dto.AccountTransactionDto;
import org.example.translator.impl.AccountTransactionTrans;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AccountTransactionFlowimpl implements AccountTransactionLogic {
    private AccountTransactionTrans accountTransactionTrans ;

    @Autowired
    public AccountTransactionFlowimpl(AccountTransactionTrans accountTransactionTrans) {
        this.accountTransactionTrans= accountTransactionTrans;
    }



    @Override
    public List<AccountTransactionDto> getAllAccountTransactions(){
        List<AccountTransactionDto> accountTransactionDtos = new ArrayList<>();
        accountTransactionDtos .add(new AccountTransactionDto());
        return accountTransactionTrans.getAccountTransactions();
    }

    @Override
    public List<AccountTransactionDto> getAllTransactions() {
        return null;
    }
}
