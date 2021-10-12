package mainfile.controllers;


import impl.AccountTransactionLogic;
import impl.MilesIogic;
import impl.UserIogic;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.example.domain.dto.MilesDto;
import org.example.domain.dto.UserDto;
import org.example.domain.persistence.GetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    private UserIogic userIogic;
    private MilesIogic milesIogic;
    private AccountTransactionLogic accountTransactionLogic;

    @Autowired
    public UserController(UserIogic userIogic, MilesIogic milesIogic, AccountTransactionLogic accountTransactionLogic) {
        this.userIogic = userIogic;
        this.milesIogic = milesIogic;
        this.accountTransactionLogic = accountTransactionLogic;
    }

    @GetMapping("/all")
    @ApiOperation(value="Gets all the users added to the db" ,notes="Returns a list of users")
    @ApiResponses(value={
            @ApiResponse(code=200,message="users returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<GetResponse<List<UserDto>>> getAllUsers(){
        List<UserDto> usersDto = userIogic.getAllUsers();
        GetResponse<List<UserDto>> response = new GetResponse<>(true,usersDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/add/")
    @ApiOperation(value="Add a user" ,notes= "Adds one members id for the member")
    @ApiResponses(value={
            @ApiResponse(code=200,message="User added"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<GetResponse<UserDto>> addUser(
            @ApiParam(value = "Request body for the new user",
                    required = true)
            @RequestBody UserDto userDtos){
        UserDto user = userIogic.addUser(userDtos);
        milesIogic.addMiles(userDtos);
        GetResponse<UserDto> response = new GetResponse<>(true,user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{email}")
    @ApiOperation(value="Delete an member" ,notes="Deletes one member with the specified email")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Member deleted"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<GetResponse<UserDto>> deletePerson(@ApiParam(value = "Email for the person to delete",
            required = true)@PathVariable("email") String email){
        milesIogic.deleteMiles(email);
        //personTransactionsService.deleteMemberTransaction(email);
        UserDto userDto =userIogic.deleteMember(email);
        GetResponse<UserDto> response = new GetResponse<>(true,userDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }




}
