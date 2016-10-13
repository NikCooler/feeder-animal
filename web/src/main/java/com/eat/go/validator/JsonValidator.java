package com.eat.go.validator;

import com.eat.go.owner.OwnerDto;
import com.eat.go.owner.domain.Owner;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class JsonValidator {

    public List<String> validateOwner(OwnerDto obj) {
        return Collections.emptyList();
    }

}
