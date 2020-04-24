package com.cofco.business.service;

import com.cofco.business.mapper.base.LongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.cofco.business.dto.OwnerDto;
import com.cofco.business.mapper.base.Mapper;
import com.cofco.business.mapper.OwnerMapper;
import com.cofco.data.entity.Owner;
import com.cofco.data.repository.OwnerRepository;

import javax.transaction.Transactional;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 *
 *  Implementation of the Owner Service
 */
@Service
@Transactional
public class OwnerService extends AbstractService<OwnerDto, Long,Owner, Long> implements CrudService<OwnerDto, Long> {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private OwnerMapper ownerMapper;

    @Autowired
    private LongMapper pkMapper;

    @Override
    JpaRepository<Owner, Long> getRepository() {
        return ownerRepository;
    }

    @Override
    Mapper<Owner, OwnerDto> getEntityMapper() {
        return ownerMapper;
    }

    @Override
    Mapper<Long, Long> getEntityPkToPkMapper() {
        return pkMapper;
    }
}
