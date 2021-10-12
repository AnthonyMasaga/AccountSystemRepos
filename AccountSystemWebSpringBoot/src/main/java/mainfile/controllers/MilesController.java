package mainfile.controllers;


import impl.MilesIogic;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.example.domain.dto.MilesDto;
import org.example.domain.persistence.GetResponse;
import org.example.domain.persistence.Miles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Miles")
public class MilesController {
    private MilesIogic milesIogic;

    @Autowired
    public MilesController(MilesIogic milesIogic){
        this.milesIogic = milesIogic;
    }
    @GetMapping("/all")
    @ApiOperation(value = "Gets all the miles to the db ", notes = "returns a list of miles")
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "goals returned"),
            @ApiResponse(code=400,message = "Bad request"),
            @ApiResponse(code=404,message = "Not found"),
            @ApiResponse(code=500,message = "Internal server error"),
    })
    public ResponseEntity<GetResponse<List<MilesDto>>> getAllGoals(){
        List<MilesDto> AccountTypeDtos = milesIogic.getAllMiles();
        GetResponse<List<MilesDto>> response = new GetResponse<>(true,AccountTypeDtos);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
@GetMapping("/User/{email}")
@ApiOperation(value = "Gets all users' goals ", notes = "returns with a name")
    @ApiResponses(value = {
            @ApiResponse(code = 200 ,message = "Member goals"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
public ResponseEntity<GetResponse<MilesDto>> getMemberMiles(
        @ApiParam(value = "Email for the user to search the miles",
                required = true)
        @PathVariable("email") String email){
    MilesDto miles = milesIogic.getMemberMiles(email);
    GetResponse<MilesDto> response = new GetResponse<>(true,miles);
    return new ResponseEntity<>(response, HttpStatus.OK);
}

}
