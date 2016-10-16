package com.eat.go.pet.service;

import com.eat.go.pet.domain.Pet;


/**
 * @author Nik Smirnov
 */
public interface PetService {

    public Pet create(Pet user);

    public Pet get(Integer id);
}
