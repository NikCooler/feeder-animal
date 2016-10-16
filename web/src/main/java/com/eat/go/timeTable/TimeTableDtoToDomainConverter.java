package com.eat.go.timeTable;

import com.eat.go.timeTable.domain.TimeTable;
import com.eat.go.user.UserDto;
import com.eat.go.user.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * @author Nik Smirnov
 */
@Component
public class TimeTableDtoToDomainConverter implements Converter<TimeTableDto, TimeTable> {

    @Override
    public TimeTable convert(TimeTableDto dto) {
        TimeTable domain = new TimeTable();
        domain.setTime(new Date(dto.getTime()));
        domain.setWeight(dto.getWeight());
        return domain;
    }

}
