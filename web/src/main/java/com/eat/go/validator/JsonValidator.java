package com.eat.go.validator;

import com.eat.go.timeTable.domain.TimeTable;
import com.eat.go.user.UserCredential;
import com.eat.go.user.UserDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;


/**
 * @author Nik Smirnov
 */
@Component
public class JsonValidator {

    public List<String> validateUser(UserDto obj) {
        return Collections.emptyList();
    }

    public List<String> validateUserCredential(UserCredential credential) {
        return Collections.emptyList();
    }

    public List<String> validateTimeTable(TimeTable dto) {
        return Collections.emptyList();
    }
}
