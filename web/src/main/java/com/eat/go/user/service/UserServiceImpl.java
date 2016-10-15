package com.eat.go.user.service;

import com.eat.go.user.UserDomainToDtoConverter;
import com.eat.go.user.UserDto;
import com.eat.go.user.UserDtoToDomainConverter;
import com.eat.go.user.domain.User;
import com.eat.go.user.repo.UserProfileRepository;
import com.eat.go.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Nik Smirnov
 */
@Service("ownerService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDtoToDomainConverter toDomainConverter;

    @Autowired
    private UserDomainToDtoConverter toDtoConverter;

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserProfileRepository profileRepository;

    @Override
    public UserDto create(UserDto dto) {
        User user = repository.save(toDomainConverter.convert(dto));
        return toDtoConverter.convert(repository.findOne(user.getId()));
    }

    @Override
    public UserDto get(Integer id) {
        return toDtoConverter.convert(repository.findOne(id));
    }
}
