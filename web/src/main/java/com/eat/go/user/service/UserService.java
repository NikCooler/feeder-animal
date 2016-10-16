package com.eat.go.user.service;

import com.eat.go.user.UserCredential;
import com.eat.go.user.UserDto;


/**
 * @author Nik Smirnov
 */
public interface UserService {

    UserDto create(UserDto user);

    UserDto get(Integer id);

    String processAuthenticate(UserCredential credential);
}
