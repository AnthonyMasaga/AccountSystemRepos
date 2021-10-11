package impl;

import org.example.domain.dto.AccountTypeDto;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface AccountTypeLogic {
        List<AccountTypeDto> getAllAccountTypes();
}



