package com.eat.go.owner.service;

import com.eat.go.owner.domain.Owner;


public interface OwnerService {

    Owner create(Owner owner);

    Owner get(Integer id);

}
