package com.eat.go.timeTable.service;

import com.eat.go.timeTable.TimeTableDomainToDtoConverter;
import com.eat.go.timeTable.TimeTableDto;
import com.eat.go.timeTable.TimeTableDtoToDomainConverter;
import com.eat.go.timeTable.domain.TimeTable;
import com.eat.go.timeTable.repo.TimeTableRepository;
import com.eat.go.user.domain.User;
import com.eat.go.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Nik Smirnov
 */
@Service("timeTableService")
public class TimeTableServiceImpl implements TimeTableService {

    @Autowired
    private TimeTableRepository timeTableRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TimeTableDomainToDtoConverter timeTableDomainToDtoConverter;

    @Autowired
    private TimeTableDtoToDomainConverter timeTableDtoToDomainConverter;

    @Override
    public TimeTableDto create(TimeTableDto entity){
        User user = userRepository.findOne(entity.getUserId());
        if (user == null) {
            throw new RuntimeException("Can't find user by ID: " + entity.getUserId());
        }
        TimeTable domain = timeTableDtoToDomainConverter.convert(entity);
        domain.setUser(user);
        TimeTable t = timeTableRepository.save(domain);
        return timeTableDomainToDtoConverter.convert(t);
    }

    @Override
    public TimeTableDto get(Integer id){
        return timeTableDomainToDtoConverter.convert(timeTableRepository.findOne(id));
    }

    @Override
    public List<TimeTableDto> getByUser(Integer userId) {
        User user = userRepository.findOne(userId);
        if (user == null) {
            throw new RuntimeException();
        }
        return timeTableDomainToDtoConverter.convertList(timeTableRepository.findByUser(user));
    }
}
