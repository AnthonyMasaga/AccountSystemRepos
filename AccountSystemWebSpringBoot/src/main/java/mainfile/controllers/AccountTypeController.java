package mainfile.controllers;


import impl.AccountTypeLogic;
import impl.MilesIogic;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.example.domain.dto.AccountTypeDto;
import org.example.domain.dto.MilesDto;
import org.example.domain.persistence.GetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AccountType")
public class AccountTypeController {
    private AccountTypeLogic accountTypeLogic;

    @Autowired
    public AccountTypeController(AccountTypeLogic accountTypeLogic){
        this.accountTypeLogic = accountTypeLogic;
    }


    @GetMapping("/all")
    @ApiOperation(value = "Gets all account types ", notes = "returns a list of account types")
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "goals returned"),
            @ApiResponse(code=400,message = "Bad request"),
            @ApiResponse(code=404,message = "Not found"),
            @ApiResponse(code=500,message = "Internal server error"),
    })
    public ResponseEntity<GetResponse<List<AccountTypeDto>>> getAllGoals(){
        List<AccountTypeDto> accountTypeDtos = accountTypeLogic.getAllAccountTypes();
        GetResponse<List<AccountTypeDto>> response = new GetResponse<>(true,accountTypeDtos);
        return new ResponseEntity<>(response, HttpStatus.OK);}

}
