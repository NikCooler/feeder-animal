package com.eat.go.owner;

import com.eat.go.owner.domain.Owner;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OwnerDtoToDomainConverter implements Converter<OwnerDto, Owner> {

    @Override
    public Owner convert(OwnerDto dto) {
        Owner domain = new Owner();
        domain.setEmail(dto.getEmail());
        domain.setName(dto.getName());
        domain.setPassword(dto.getPassword());
        domain.setSurname(dto.getSurname());
        return domain;
    }
}
