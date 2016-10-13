package com.eat.go.user.service;

import com.eat.go.user.domain.User;
import com.eat.go.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("ownerService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User create(User user) {
        repository.save(user);
        return repository.findOne(user.getId());
    }

    @Override
    public User get(Integer id) {
        return repository.findOne(id);
    }
}
