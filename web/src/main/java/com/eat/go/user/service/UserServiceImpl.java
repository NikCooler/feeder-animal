package com.eat.go.user.service;

import com.eat.go.user.UserCredential;
import com.eat.go.user.UserDomainToDtoConverter;
import com.eat.go.user.UserDto;
import com.eat.go.user.UserDtoToDomainConverter;
import com.eat.go.user.domain.User;
import com.eat.go.user.repo.UserProfileRepository;
import com.eat.go.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.util.Random;


/**
 * @author Nik Smirnov
 */
@Service("userService")
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

    @Override
    public String processAuthenticate(UserCredential credential) {
        User user = repository.findByEmailAndPassword(credential.getEmail(), credential.getPassword());
        if (user == null) {
            throw new RuntimeException();
        }
        Random r = new Random();

        return String.valueOf(r.nextInt(1000));
    }
}
