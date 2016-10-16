package com.eat.go.timeTable.service;


import com.eat.go.timeTable.domain.TimeTable;

import java.util.List;

/**
 * @author Nik Smirnov
 */
public interface TimeTableService {

    TimeTable create(TimeTable entity);

    TimeTable get(Integer timetableId);

    List<TimeTable> getByUser(Integer userId);

}
