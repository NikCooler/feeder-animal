package com.eat.go.user;

import com.eat.go.user.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


/**
 * @author Nik Smirnov
 */
@Component
public class UserDomainToDtoConverter implements Converter<User, UserDto> {

    @Override
    public UserDto convert(User user) {
        UserDto dto = new UserDto();
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        dto.setPassword(user.getPassword());
        dto.setSurname(user.getSurname());
        return dto;
    }
}
