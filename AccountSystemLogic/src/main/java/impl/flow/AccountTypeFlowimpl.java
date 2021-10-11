package impl.flow;

import impl.AccountTypeLogic;
import org.example.domain.dto.AccountTypeDto;
import org.example.translator.impl.AccountTypeTrans;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AccountTypeFlowimpl implements AccountTypeLogic {
    private AccountTypeTrans accountTypeTrans;

    @Autowired
    public AccountTypeFlowimpl(AccountTypeTrans accountTypeTrans) {
        this.accountTypeTrans= accountTypeTrans;
    }



    @Override
    public List<AccountTypeDto> getAllAccountTypes(){
        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        accountTypeDtos.add(new AccountTypeDto());
        return accountTypeTrans.getAccountTypes();
    }
}
