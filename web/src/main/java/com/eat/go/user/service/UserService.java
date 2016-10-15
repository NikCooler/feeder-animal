package com.eat.go.user.service;

import com.eat.go.user.UserDto;


/**
 * @author Nik Smirnov
 */
public interface UserService {

    UserDto create(UserDto owner);

    UserDto get(Integer id);

}
