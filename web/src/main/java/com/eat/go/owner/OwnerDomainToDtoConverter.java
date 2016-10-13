package com.eat.go.owner;

import com.eat.go.owner.domain.Owner;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OwnerDomainToDtoConverter implements Converter<Owner, OwnerDto> {

    @Override
    public OwnerDto convert(Owner owner) {
        OwnerDto dto = new OwnerDto();
        dto.setEmail(owner.getEmail());
        dto.setName(owner.getName());
        dto.setPassword(owner.getPassword());
        dto.setSurname(owner.getSurname());
        return dto;
    }
}
