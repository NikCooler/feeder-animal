package com.eat.go.resource;

import com.eat.go.JSONWrapper;
import com.eat.go.owner.domain.Owner;
import com.eat.go.owner.service.OwnerService;
import com.eat.go.pet.service.PetService;
import com.eat.go.timeTable.service.TimeTableService;
import com.eat.go.user.domain.User;
import com.eat.go.user.service.UserService;
import com.eat.go.validator.JsonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
public class EatAndGoResource {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private PetService petService;

    @Autowired
    private TimeTableService timeTableService;

    @Autowired
    private UserService userService;

    @Autowired
    private JsonValidator validator;

    @RequestMapping(value = "/owner/new", method = RequestMethod.PUT)
    public @ResponseBody JSONWrapper<Integer> createOwner(@RequestBody Owner owner) {
        List<String> fails = validator.validateOwner(owner);
        if (fails.isEmpty()) {
            return new JSONWrapper<Integer>(ownerService.create(owner).getId(), JSONWrapper.Status.SUCCESS);
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "dd");
    }

    @RequestMapping(value =  "/owner/{ownerId}", method = RequestMethod.GET)
    public @ResponseBody JSONWrapper<Owner> getOwner(@PathVariable("ownerId") Integer ownerId) {
        if (ownerId != null) {
            return new JSONWrapper<>(ownerService.get(ownerId), JSONWrapper.Status.SUCCESS);
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "'ownerId' can not be null");
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.PUT)
    public @ResponseBody JSONWrapper<Integer> createUser(@RequestBody User user) {
        List<String> fails = validator.validateUser(user);
        if (fails.isEmpty()) {
            return new JSONWrapper<Integer>(userService.create(user).getId(), JSONWrapper.Status.SUCCESS);
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "dd");
    }

    @RequestMapping(value =  "/user/{userId}", method = RequestMethod.GET)
    public @ResponseBody JSONWrapper<User> getUser(@PathVariable("userId") Integer userId) {
        if (userId != null) {
            return new JSONWrapper<User>(userService.get(userId), JSONWrapper.Status.SUCCESS);
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "'ownerId' can not be null");
    }

}
