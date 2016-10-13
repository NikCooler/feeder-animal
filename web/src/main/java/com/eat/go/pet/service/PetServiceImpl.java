package com.eat.go.pet.service;

import com.eat.go.pet.domain.Pet;
import com.eat.go.pet.repo.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Service for pet
 *
 * @author Nik Smirnov
 */
@Service("petService")
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository repository;

    @Override
    public Pet create(Pet pet){
        repository.save(pet);
        return repository.findOne(pet.getId());
    }

    @Override
    public Pet get(Integer id){
        return repository.findOne(id);
    }

}
