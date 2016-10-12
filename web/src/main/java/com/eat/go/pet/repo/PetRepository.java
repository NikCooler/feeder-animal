package com.eat.go.pet.repo;

import com.eat.go.pet.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PetRepository extends JpaRepository<Pet, Integer> {
}
