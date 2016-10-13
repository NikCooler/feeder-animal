package com.eat.go.owner.service;

import com.eat.go.owner.OwnerDto;
import com.eat.go.owner.domain.Owner;


/**
 * @author Nik Smirnov
 */
public interface OwnerService {

    OwnerDto create(OwnerDto owner);

    OwnerDto get(Integer id);

}
