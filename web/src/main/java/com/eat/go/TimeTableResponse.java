package com.eat.go;

import com.eat.go.timeTable.TimeTableDto;
import com.eat.go.timeTable.domain.TimeTable;
import com.eat.go.user.UserDto;
import io.swagger.annotations.ApiModel;

import java.util.List;


/**
 * @author Nik Smirnov
 */
@ApiModel("TimeTable")
public class TimeTableResponse extends JSONResponse<List<TimeTableDto>> {

    public TimeTableResponse(List<TimeTableDto> dto) {
        super(dto, Status.SUCCESS);
    }
}
