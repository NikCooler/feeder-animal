package com.eat.go.timeTable.repo;

import com.eat.go.timeTable.domain.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TimeTableRepository extends JpaRepository<TimeTable, Integer> {
}
