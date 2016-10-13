package com.eat.go.owner.repo;

import com.eat.go.owner.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Nik Smirnov
 */
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
