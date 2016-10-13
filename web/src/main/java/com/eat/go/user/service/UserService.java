package com.eat.go.user.service;

import com.eat.go.user.domain.User;


public interface UserService {

    User create(User user);

    User get(Integer id);

}
