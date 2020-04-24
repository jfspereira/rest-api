package com.cofco.business.service;

import com.cofco.business.mapper.base.LongMapper;
import com.cofco.business.mapper.base.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.cofco.business.dto.CompanyDto;
import com.cofco.business.dto.OwnerDto;
import com.cofco.business.exception.NotFoundException;
import com.cofco.business.mapper.*;
import com.cofco.data.entity.Company;
import com.cofco.data.entity.Owner;
import com.cofco.data.repository.CompanyRepository;
import com.cofco.data.repository.OwnerRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 *
 *  Implementation of the Company Service
 */
@Service
@Transactional
public class CompanyService extends AbstractService<CompanyDto, Long,Company, Long> implements CrudService<CompanyDto, Long> {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private LongMapper pkMapper;

    @Autowired
    private OwnerMapper ownerMapper;

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    JpaRepository<Company, Long> getRepository() {
        return companyRepository;
    }

    @Override
    Mapper<Company, CompanyDto> getEntityMapper() {
        return companyMapper;
    }

    @Override
    Mapper<Long, Long> getEntityPkToPkMapper() {
        return pkMapper;
    }

    public Collection<OwnerDto> owners(long id) {
        Company byId = companyRepository.findById(id).orElseThrow(NotFoundException::new);
        List<Owner> owners = byId.getOwners();
        return owners.stream().map(t->ownerMapper.mapTo(t)).collect(Collectors.toList());
    }

    public void addOwner(Long companyId, Long ownerId){

        Company byId = companyRepository.findById(companyId).orElseThrow(NotFoundException::new);
        Owner ownerById = ownerRepository.findById(ownerId).orElseThrow(NotFoundException::new);

        byId.getOwners().add(ownerById);

        this.companyRepository.save(byId);

    }

    public void removeOwner(Long companyId, Long ownerId) {
        Company byId = companyRepository.findById(companyId).orElseThrow(NotFoundException::new);
        Owner ownerById = ownerRepository.findById(ownerId).orElseThrow(NotFoundException::new);

        byId.getOwners().remove(ownerById);

        this.companyRepository.save(byId);
    }

    public OwnerDto addNewOwner(Long companyId, OwnerDto ownerDto) {

        Owner createdOwner = ownerRepository.save(ownerMapper.mapFrom(ownerDto));
        Company byId = companyRepository.findById(companyId).orElseThrow(NotFoundException::new);
        byId.getOwners().add(createdOwner);
        this.companyRepository.save(byId);
        return ownerMapper.mapTo(createdOwner);
    }
}
