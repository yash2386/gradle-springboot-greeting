package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(basePath = "swagger-demo/person", value = "Person", description = "Operations with person", produces = "application/json")
@RestController
public class HelloController {
	
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
@RequestMapping(value = "swagger-demo/person", produces = MediaType.APPLICATION_JSON_VALUE)
class PersonController {
 
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ApiOperation(value = "Get Person", notes = "Fetch List of Person")
    @ApiResponses(value = 
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 201, message = "List"),
            @ApiResponse(code = 500, message = "Error occurred while fetching Person")
    )
    ResponseEntity create(@RequestBody PersonCO co) {
        return new ResponseEntity(new Person(firstName: co.firstName, lastName: co.lastName, age: co.age), HttpStatus.OK)
    }
}

