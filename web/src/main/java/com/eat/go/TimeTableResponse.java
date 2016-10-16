package com.eat.go;

import com.eat.go.timeTable.domain.TimeTable;
import com.eat.go.user.UserDto;
import io.swagger.annotations.ApiModel;

import java.util.List;


/**
 * @author Nik Smirnov
 */
@ApiModel("TimeTable")
public class TimeTableResponse extends JSONResponse<List<TimeTable>> {

    public TimeTableResponse(List<TimeTable> dto) {
        super(dto, Status.SUCCESS);
    }
}
