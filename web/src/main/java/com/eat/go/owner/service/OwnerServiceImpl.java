package com.eat.go.owner.service;

import com.eat.go.owner.OwnerDomainToDtoConverter;
import com.eat.go.owner.OwnerDto;
import com.eat.go.owner.OwnerDtoToDomainConverter;
import com.eat.go.owner.domain.Owner;
import com.eat.go.owner.repo.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Nik Smirnov
 */
@Service("ownerService")
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerDtoToDomainConverter toDomainConverter;

    @Autowired
    private OwnerDomainToDtoConverter toDtoConverter;

    @Autowired
    private OwnerRepository repository;

    @Override
    public OwnerDto create(OwnerDto dto) {
        Owner owner = repository.save(toDomainConverter.convert(dto));
        return toDtoConverter.convert(repository.findOne(owner.getId()));
    }

    @Override
    public OwnerDto get(Integer id) {
        return toDtoConverter.convert(repository.findOne(id));
    }
}
