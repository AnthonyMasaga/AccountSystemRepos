package mainfile.controllers;

import impl.GoalsIogic;
import impl.MilesIogic;
import io.swagger.annotations.ApiOperation;
import org.example.domain.dto.GoalsDto;
import org.example.domain.dto.MilesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Goals")
public class GoalsController {
    private GoalsIogic goalsIogic;

    @Autowired
    public GoalsController (GoalsIogic goalsIogic){
        this.goalsIogic = goalsIogic;
    }
    @GetMapping("/AllGoals")
    @ApiOperation(value = "Gets all the details ")
    public ResponseEntity<List<GoalsDto>> getAll(){
        List<GoalsDto> goals= goalsIogic.getAllGoals();
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }


    }


