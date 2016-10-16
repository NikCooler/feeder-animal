package com.eat.go.timeTable.repo;

import com.eat.go.timeTable.domain.TimeTable;
import com.eat.go.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * @author Nik Smirnov
 */
public interface TimeTableRepository extends JpaRepository<TimeTable, Integer> {

    List<TimeTable> findByUser(User user);

}
