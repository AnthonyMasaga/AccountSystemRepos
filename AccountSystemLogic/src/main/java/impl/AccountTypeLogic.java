package impl;

import org.example.domain.dto.AccountTypeDto;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface AccountTypeLogic {
        List<AccountTypeDto> getAccountTypes();
        void deleteAccountType(String nmonic);
        AccountTypeDto getAccountType(String nmonic);
        AccountTypeDto addAccountType(AccountTypeDto accountTypeDto);
}



