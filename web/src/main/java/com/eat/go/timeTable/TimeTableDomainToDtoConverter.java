package com.eat.go.timeTable;

import com.eat.go.timeTable.domain.TimeTable;
import com.eat.go.user.UserDto;
import com.eat.go.user.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Nik Smirnov
 */
@Component
public class TimeTableDomainToDtoConverter implements Converter<TimeTable, TimeTableDto> {

    @Override
    public TimeTableDto convert(TimeTable domain) {
        TimeTableDto dto = new TimeTableDto();
        dto.setTimeTableId(domain.getId());
        dto.setTime(domain.getTime().getTime());
        dto.setUserId(domain.getUser().getId());
        dto.setWeight(domain.getWeight());
        return dto;
    }

    public List<TimeTableDto> convertList(List<TimeTable> domainList) {
        List<TimeTableDto> dtos = new ArrayList<>(domainList.size());
        domainList.forEach(d -> dtos.add(convert(d)));
        return dtos;
    }
}
