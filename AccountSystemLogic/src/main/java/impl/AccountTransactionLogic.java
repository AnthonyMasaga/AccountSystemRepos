package impl;

import org.example.domain.dto.AccountTransactionDto;
import org.example.domain.dto.AccountTypeDto;
import org.example.domain.dto.MilesDto;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public interface AccountTransactionLogic {
    List<AccountTransactionDto> getmemberTransaction(String email);
    void deleteMemberTransaction(String email);
    AccountTransactionDto addTransaction(AccountTransactionDto accountTransactionDto);
}
