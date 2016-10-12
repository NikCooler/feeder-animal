package com.eat.go.owner.service;

import com.eat.go.owner.domain.Owner;
import com.eat.go.owner.repo.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("ownerService")
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository repository;

    @Override
    public Owner create(Owner owner) {
        repository.save(owner);
        return repository.findOne(owner.getId());
    }

    @Override
    public Owner get(Integer id) {
        return repository.findOne(id);
    }
}
