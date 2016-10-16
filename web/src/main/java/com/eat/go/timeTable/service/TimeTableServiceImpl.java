package com.eat.go.timeTable.service;

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

    @Override
    public TimeTable create(TimeTable entity){
        timeTableRepository.save(entity);
        return timeTableRepository.findOne(entity.getId());
    }

    @Override
    public TimeTable get(Integer id){
        return timeTableRepository.findOne(id);
    }

    @Override
    public List<TimeTable> getByUser(Integer userId) {
        User user = userRepository.findOne(userId);
        if (user == null) {
            throw new RuntimeException();
        }
        return timeTableRepository.findByUser(user);
    }
}
