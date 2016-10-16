package com.eat.go.resource;

import com.eat.go.TimeTableResponse;
import com.eat.go.UserResponse;
import com.eat.go.common.CommonUrl;
import com.eat.go.timeTable.domain.TimeTable;
import com.eat.go.timeTable.service.TimeTableService;
import com.eat.go.validator.JsonValidator;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(CommonUrl.TIMETABLE)
public class TimeTableResource {

    @Autowired
    private TimeTableService timeTableService;

    @Autowired
    private JsonValidator validator;

    @RequestMapping(value = CommonUrl.TIMETABLE + "/create", method = RequestMethod.PUT)
    @ApiOperation(value = "Resource to create timetable", response = TimeTableResponse.class)
    public @ResponseBody TimeTableResponse createTimeTable(@RequestBody TimeTable dto) {
        List<String> fails = validator.validateTimeTable(dto);
        if (fails.isEmpty()) {
            return new TimeTableResponse(Collections.singletonList(timeTableService.create(dto)));
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "");
    }

    @RequestMapping(value =  CommonUrl.TIMETABLE + "/{timetableId}", method = RequestMethod.GET)
    @ApiOperation(value = "Resource to get timetable by id", response = TimeTableResponse.class)
    public @ResponseBody TimeTableResponse getTimeTable(@PathVariable("timetableId") Integer timetableId) {
        if (timetableId != null) {
            return new TimeTableResponse(Collections.singletonList(timeTableService.get(timetableId)));
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "'timetableId' can not be null");
    }

    @RequestMapping(value =  CommonUrl.TIMETABLE + "/{userId}/list", method = RequestMethod.GET)
    @ApiOperation(value = "Resource to get all timetable created by user", response = TimeTableResponse.class)
    public @ResponseBody TimeTableResponse getTimeTables(@PathVariable("userId") Integer userId) {
        if (userId != null) {
            return new TimeTableResponse(Collections.singletonList(timeTableService.get(userId)));
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "'userId' can not be null");
    }

}
