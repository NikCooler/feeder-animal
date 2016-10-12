package com.eat.go.validator;

import com.eat.go.owner.domain.Owner;
import com.eat.go.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class JsonValidator {

    public List<String> validateOwner(Owner obj) {
        return Collections.emptyList();
    }

    public List<String> validateUser(User user) {
        return Collections.emptyList();
    }

}
