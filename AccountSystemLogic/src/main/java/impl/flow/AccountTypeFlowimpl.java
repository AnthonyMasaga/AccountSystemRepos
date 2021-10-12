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
        this.accountTypeTrans = accountTypeTrans;
    }

    @Override
    public List<AccountTypeDto> getAccountTypes() {
        return accountTypeTrans.getAccountTypes();
    }

    @Override
    public void deleteAccountType(String nmonic) {
    accountTypeTrans.deleteAccountType(nmonic);
    }

    @Override
    public AccountTypeDto getAccountType(String nmonic) {
        return accountTypeTrans.getAccountType(nmonic);
    }

    @Override
    public AccountTypeDto addAccountType(AccountTypeDto accountTypeDto) {
        return accountTypeTrans.addAccountType(accountTypeDto);
    }
}
