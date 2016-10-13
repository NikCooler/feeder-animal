package com.eat.go.resource;

import com.eat.go.JSONResponse;
import com.eat.go.OwnerResponse;
import com.eat.go.owner.OwnerDto;
import com.eat.go.owner.service.OwnerService;
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
    @ApiOperation(value = "Query for worker profile data", response = OwnerResponse.class, position = 50)
    public @ResponseBody OwnerResponse createOwner(@RequestBody OwnerDto dto) {
        List<String> fails = validator.validateOwner(dto);
        if (fails.isEmpty()) {
            return new OwnerResponse(ownerService.create(dto));
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "dd");
    }

    /*@RequestMapping(value =  "/owner/{ownerId}", method = RequestMethod.GET)
    public @ResponseBody
    JSONResponse<OwnerDto> getOwner(@PathVariable("ownerId") Integer ownerId) {
        if (ownerId != null) {
            return new JSONResponse<>(ownerService.get(ownerId), JSONResponse.Status.SUCCESS);
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "'ownerId' can not be null");
    }*/

}
