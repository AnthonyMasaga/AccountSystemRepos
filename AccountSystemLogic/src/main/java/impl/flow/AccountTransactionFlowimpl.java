package impl.flow;

import impl.AccountTransactionLogic;
import org.example.domain.dto.AccountTransactionDto;
import org.example.translator.impl.AccountTransactionTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Component
public class AccountTransactionFlowimpl implements AccountTransactionLogic {
    private AccountTransactionTrans accountTransactionTrans;

    @Autowired
    public AccountTransactionFlowimpl(AccountTransactionTrans accountTransactionTrans){
        this.accountTransactionTrans =accountTransactionTrans;
    }

    @Override
    public List<AccountTransactionDto> getmemberTransaction(String email) {
        return accountTransactionTrans.getmemberTransaction(email);
    }

    @Override
    public void deleteMemberTransaction(String email) {
        accountTransactionTrans.deleteMemberTransaction(email);

    }


    @Override
    public AccountTransactionDto addTransaction(AccountTransactionDto accountTransactionDto) {
        return accountTransactionTrans.addTransaction(accountTransactionDto);
    }
}
