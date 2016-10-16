package com.eat.go.timeTable.service;


import com.eat.go.timeTable.TimeTableDto;
import com.eat.go.timeTable.domain.TimeTable;

import java.util.List;

/**
 * @author Nik Smirnov
 */
public interface TimeTableService {

    TimeTableDto create(TimeTableDto entity);

    TimeTableDto get(Integer timetableId);

    List<TimeTableDto> getByUser(Integer userId);

}
