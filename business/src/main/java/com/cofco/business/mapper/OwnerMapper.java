package com.cofco.business.mapper;

import com.cofco.business.mapper.base.IdentityMapper;
import com.cofco.business.mapper.base.Mapper;
import org.springframework.stereotype.Component;
import com.cofco.business.dto.OwnerDto;
import com.cofco.data.entity.Owner;

/**
 * Created by Tiago Vilas Boas on 16/06/2018.
 * Owner to OwnerDto mapper
 */
@Component
public class OwnerMapper implements Mapper<Owner, OwnerDto> {

    public Owner mapFrom(OwnerDto dto) {
        return dto == null ? null : new Owner()
                .setName(dto.getName())
                .setTitle(dto.getTitle())
                .setId(dto.getId())
                ;
    }

    public OwnerDto mapTo(Owner entity) {
        return entity == null ? null : (OwnerDto) new OwnerDto()
                .setName(entity.getName())
                .setTitle(entity.getTitle())
                .setId(entity.getId())
                ;
    }

    @Override
    public OwnerDto map(OwnerDto dto, Owner entity) {
        return entity == null ? null :
                dto == null ? null:
                        (OwnerDto) new OwnerDto()
                                .setName(entity.getName())
                                .setTitle(entity.getTitle())
                                .setId(entity.getId());
    }
}
