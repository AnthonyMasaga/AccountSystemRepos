package mainfile.controllers;

import impl.GoalsIogic;
import impl.RewardsIogic;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.example.domain.dto.GoalsDto;
import org.example.domain.dto.RewardsDto;
import org.example.domain.persistence.GetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Rewards")
public class RewardsController {
    private RewardsIogic rewardsIogic;

    @Autowired
    public RewardsController(RewardsIogic rewardsIogic) {
        this.rewardsIogic = rewardsIogic;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the rewards ", notes = "Returns the rewards")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Rewards returned"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server error")
    })
    public ResponseEntity<GetResponse<List<RewardsDto>>> getRewards() {
        List<RewardsDto> accountTypeDTOS = rewardsIogic.getAllRewards();
        GetResponse<List<RewardsDto>> response = new GetResponse<>(true, accountTypeDTOS);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete an member", notes = "Deletes one member with the specified email")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Reward deleted"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal Server error")
    })
    public ResponseEntity<GetResponse<RewardsDto>> deleteRewards(@ApiParam(value = "id for the reward to delete",
            example = "1",
            required = true) @PathVariable("id") Long id) {
        RewardsDto rewardsDTO = rewardsIogic.deleteRewards(id);
        GetResponse<RewardsDto> response = new GetResponse<>(true, rewardsDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);


    }

    @PutMapping("/add/")
    @ApiOperation(value="Add a new reward" ,notes="Adds one reward with a generated auto")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Reward added"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<GetResponse<RewardsDto>> addMember(
            @ApiParam(value = "Request Body for the new Member",
                    required = true)
            @RequestBody RewardsDto rewardsDto){
        RewardsDto reward = rewardsIogic.addReward(rewardsDto);
        GetResponse<RewardsDto> response = new GetResponse<>(true,reward);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
