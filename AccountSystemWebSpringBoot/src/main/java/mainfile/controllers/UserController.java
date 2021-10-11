package mainfile.controllers;


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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("User")
public class UserController {
    private UserIogic userIogic;

    @Autowired
    public UserController(UserIogic userIogic) {
        this.userIogic = userIogic;
    }
    @GetMapping("/all")
    @ApiOperation(value="Gets all the users added to the db" ,notes="Returns a list of users")
    @ApiResponses(value={
            @ApiResponse(code=200,message="users returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<GetResponse<List<UserDto>>> getUser(){
        List<UserDto> usersDto = userIogic.getAllCustomer();
        GetResponse<List<UserDto>> response = new GetResponse<>(true,usersDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/member/{email}")
    @ApiOperation(value="Gets a user" ,notes="Returns one member with the specified email")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Member goals returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<GetResponse<MilesDto>> getUserEmail(
            @ApiParam(value = "Email for the user to search the miles",
                    required = true)
            @PathVariable("email") String email){
        MilesDto member = userIogic.getUserEmail(email);
        GetResponse<MilesDto> response = new GetResponse<>(true,member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
