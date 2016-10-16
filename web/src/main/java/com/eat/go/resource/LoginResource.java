package com.eat.go.resource;

import com.eat.go.UserResponse;
import com.eat.go.common.CommonUrl;
import com.eat.go.user.UserCredential;
import com.eat.go.user.service.UserService;
import com.eat.go.validator.JsonValidator;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;


@RestController
@RequestMapping(CommonUrl.API)
public class LoginResource {

    @Autowired
    private JsonValidator validator;

    @Autowired
    private UserService userService;

    @RequestMapping(value = CommonUrl.LOGIN, method = RequestMethod.POST)
    @ApiOperation(value = "Resource to authenticate user", response = String.class)
    public @ResponseBody String login(@RequestBody UserCredential credential) {
        List<String> fails = validator.validateUserCredential(credential);
        if (fails.isEmpty()) {
            return userService.processAuthenticate(credential);
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "");
    }

}
