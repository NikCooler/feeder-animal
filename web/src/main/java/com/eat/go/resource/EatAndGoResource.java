package com.eat.go.resource;

import com.eat.go.JSONWrapper;
import com.eat.go.owner.OwnerDto;
import com.eat.go.owner.domain.Owner;
import com.eat.go.owner.service.OwnerService;
import com.eat.go.pet.service.PetService;
import com.eat.go.timeTable.service.TimeTableService;
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
    private JsonValidator validator;

    @RequestMapping(value = "/owner/new", method = RequestMethod.PUT)
    public @ResponseBody JSONWrapper<OwnerDto> createOwner(@RequestBody OwnerDto dto) {
        List<String> fails = validator.validateOwner(dto);
        if (fails.isEmpty()) {
            return new JSONWrapper<OwnerDto>(ownerService.create(dto), JSONWrapper.Status.SUCCESS);
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "dd");
    }

    @RequestMapping(value =  "/owner/{ownerId}", method = RequestMethod.GET)
    public @ResponseBody JSONWrapper<OwnerDto> getOwner(@PathVariable("ownerId") Integer ownerId) {
        if (ownerId != null) {
            return new JSONWrapper<>(ownerService.get(ownerId), JSONWrapper.Status.SUCCESS);
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "'ownerId' can not be null");
    }

}
