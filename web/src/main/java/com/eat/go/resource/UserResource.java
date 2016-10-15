package com.eat.go.resource;

import com.eat.go.UserResponse;
import com.eat.go.user.UserDto;
import com.eat.go.user.service.UserService;
import com.eat.go.pet.service.PetService;
import com.eat.go.timeTable.service.TimeTableService;
import com.eat.go.validator.JsonValidator;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;


/**
 * @author Nik Smirnov
 */
@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private PetService petService;

    @Autowired
    private TimeTableService timeTableService;

    @Autowired
    private JsonValidator validator;

    @RequestMapping(value = "/owner/register", method = RequestMethod.PUT)
    @ApiOperation(value = "Resource to create user", response = UserResponse.class)
    public @ResponseBody
    UserResponse createOwner(@RequestBody UserDto dto) {
        List<String> fails = validator.validateOwner(dto);
        if (fails.isEmpty()) {
            return new UserResponse(userService.create(dto));
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "");
    }

    @RequestMapping(value = "/owner/register", method = RequestMethod.PUT)
    @ApiOperation(value = "Resource to create user", response = UserResponse.class)
    public @ResponseBody
    UserResponse login(@RequestBody UserDto dto) {
        List<String> fails = validator.validateOwner(dto);
        if (fails.isEmpty()) {
            return new UserResponse(userService.create(dto));
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "");
    }

    @RequestMapping(value =  "/owner/{ownerId}", method = RequestMethod.GET)
    @ApiOperation(value = "Resource to get user", response = UserResponse.class)
    public @ResponseBody
    UserResponse getOwner(@PathVariable("ownerId") Integer ownerId) {
        if (ownerId != null) {
            return new UserResponse(userService.get(ownerId));
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "'ownerId' can not be null");
    }

}
