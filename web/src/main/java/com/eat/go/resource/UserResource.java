package com.eat.go.resource;

import com.eat.go.UserResponse;
import com.eat.go.common.CommonUrl;
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
@RequestMapping(CommonUrl.USER)
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private JsonValidator validator;

    @RequestMapping(value = CommonUrl.USER_REGISTER, method = RequestMethod.PUT)
    @ApiOperation(value = "Resource to register user", response = UserResponse.class)
    public @ResponseBody UserResponse registerUser(@RequestBody UserDto dto) {
        List<String> fails = validator.validateUser(dto);
        if (fails.isEmpty()) {
            return new UserResponse(userService.create(dto));
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "");
    }

    @RequestMapping(value =  CommonUrl.USER + "/{userId}", method = RequestMethod.GET)
    @ApiOperation(value = "Resource to get user", response = UserResponse.class)
    public @ResponseBody
    UserResponse getUser(@PathVariable("userId") Integer userId) {
        if (userId != null) {
            return new UserResponse(userService.get(userId));
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "'userId' can not be null");
    }

}
