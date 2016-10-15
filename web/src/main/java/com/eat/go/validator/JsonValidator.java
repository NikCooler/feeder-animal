package com.eat.go.validator;

import com.eat.go.user.UserDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;


/**
 * @author Nik Smirnov
 */
@Component
public class JsonValidator {

    public List<String> validateOwner(UserDto obj) {
        return Collections.emptyList();
    }

}
