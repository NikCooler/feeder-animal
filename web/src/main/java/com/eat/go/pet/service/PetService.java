package com.eat.go.pet.service;

import com.eat.go.pet.domain.Pet;


public interface PetService {

    public Pet create(Pet owner);

    public Pet get(Integer id);
}
