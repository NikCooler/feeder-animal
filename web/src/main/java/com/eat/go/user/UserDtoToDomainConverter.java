package com.eat.go.user;

import com.eat.go.user.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


/**
 * @author Nik Smirnov
 */
@Component
public class UserDtoToDomainConverter implements Converter<UserDto, User> {

    @Override
    public User convert(UserDto dto) {
        User domain = new User();
        domain.setEmail(dto.getEmail());
        domain.setName(dto.getName());
        domain.setPassword(dto.getPassword());
        domain.setSurname(dto.getSurname());
        return domain;
    }
}
