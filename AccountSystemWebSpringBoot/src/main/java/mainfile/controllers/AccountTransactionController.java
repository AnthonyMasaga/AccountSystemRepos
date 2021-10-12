package mainfile.controllers;

import impl.AccountTransactionLogic;
import impl.AccountTypeLogic;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.example.domain.dto.AccountTransactionDto;
import org.example.domain.dto.AccountTypeDto;
import org.example.domain.persistence.AccountType;
import org.example.domain.persistence.GetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/AccountTransaction")
public class AccountTransactionController {
    private AccountTypeLogic accountTypeLogic;
    private AccountTransactionLogic accountTransactionLogic ;

    @Autowired
    public AccountTransactionController(AccountTransactionLogic accountTransactionLogic, AccountTypeLogic accountTypeLogic) {
    this.accountTypeLogic = accountTypeLogic;
    this.accountTransactionLogic = accountTransactionLogic;
    }
    @GetMapping("/all")
    @ApiOperation(value = "Gets all account transactions ", notes = "returns a list of account types")
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "goals returned"),
            @ApiResponse(code=400,message = "Bad request"),
            @ApiResponse(code=404,message = "Not found"),
            @ApiResponse(code=500,message = "Internal server error"),
    })
    public ResponseEntity<GetResponse<List<AccountTypeDto>>> getAllGoals(){
        List<AccountTypeDto> accountTypeDtos = accountTypeLogic.getAccountTypes();
        GetResponse<List<AccountTypeDto>> response = new GetResponse<>(true,accountTypeDtos);
        return new ResponseEntity<>(response, HttpStatus.OK);}

}
