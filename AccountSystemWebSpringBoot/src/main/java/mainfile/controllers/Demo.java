package mainfile.controllers;

import org.example.domain.persistence.GetResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest-app")
public class Demo {
        @GetMapping("/all")
        public GetResponse<String> getAll() {
                return new GetResponse<String>(getAll().isSuccesful(), getAll().getPayload());
        }

//        private final CustomerFlow UserIogic customerIogic;

        //      @Autowired
        //public Demo(UserIogic customerIogic) {
          //      this.customerIogic = customerIogic;
        //}

        //@GetMapping("/all")


        //ApiOperation(value = "Gets all the account types",notes = "Returns all the accoun types")
        //  @ApiResponses(value = {
        //  @ApiResponse(code = 200, message = "account type returned", response = UserController.class),
        //  @ApiResponse(code = 400, message = "account type returned", response = UserController.class),
        // })
        //  public ResponseEntity<UserController<UserDto> create{
        //    @ApiParam(value = "request a new creation",required = true)
        //   @RequestBody UserDto UserController){
        //     UserDto UserRepo  = cre
        // }//
        //}
      //  public ResponseEntity<UserController<List<UserDto>>> getAll() {
        //    List<UserDto> customer = customerIogic.getAllCustomers();
              //  return new UserController<Long>(getAll().getId(), getAll().getPayload());
        //}
}






