package com.cofco.business.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cofco.business.dto.base.AbstractBaseId;
import com.cofco.business.exception.NotFoundException;
import com.cofco.business.mapper.base.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Created by Tiago Vilas Boas on 16/06/2018.
 *
 * Generic implementation of a CRUD service, it takes four parameters explained below
 *  It requires some methods to be implemented which will have the responsibility to feed with the mappers to transform
 *  from DTO to Entity and vice-versa and from PK to DTOPK
 *
 * @param <DTO> The dto we receive from the webservice layer that we ant to persist to the database
 * @param <DTOPK> The key of the dto we want to persist (this allows for services with String or even complex keys)
 * @param <ENTITY> The jpa Entity to persist to the database
 * @param <ENTITYPK> The key of the database table for the same reasons, it allows for embedded jpa keys, String, UUIds
 */
abstract class AbstractService<DTO extends AbstractBaseId<DTOPK>, DTOPK,ENTITY,ENTITYPK> implements CrudService<DTO,DTOPK> {

    /**
     * Method that the implementation must implement, and it returns a JpaRepository of type  Entity, EntityPK
     * It will allow us to generalize the implementation
     *
     * @return returns an implementation of JpaRepository
     */
    abstract JpaRepository<ENTITY, ENTITYPK> getRepository();

    /**
     * Mapper that have every method of conversion between ENTITY and DTO
     * @return returns the mapper
     */
    abstract Mapper<ENTITY, DTO> getEntityMapper();

    /**
     * Mapper to convert a entity pk to a dtopk  with the Type ENTITYPK and DTOPK
     * @return returns the mapper
     */
    abstract Mapper<ENTITYPK, DTOPK> getEntityPkToPkMapper();


    @Override
    public Optional<DTO> read(DTOPK id) {

        //maps the DTOPK to an ENTITY pk we can then pass to the repository
        ENTITYPK map = getEntityPkToPkMapper().mapFrom(id);

        // find the record we want
        Optional<ENTITY> byId = getRepository().findById(map);

        // transform it from an ENTITY to a DTO
        return byId.map(entity -> getEntityMapper().mapTo(entity));
    }

    @Override
    public Collection<DTO> list() {

        // lists all the ENTITY objects in the database and transforms them to DTO's
        return getRepository().findAll().stream().map(entity -> getEntityMapper().mapTo(entity)).collect(Collectors.toList());
    }

    @Override
    public DTO create(DTO dto) {

        // maps the DTO to ENTITY
        ENTITY entity = getEntityMapper().mapFrom(dto);

        // persists it
        ENTITY saved = getRepository().saveAndFlush(entity);

        // returns the transformed entity inserted back to a dto to be returned
        return getEntityMapper().mapTo(saved);
    }

    @Override
    public void update(DTOPK id, DTO dto) {
        //sets the id to override the id in the body, as I believe that the path parameter
        // should persist of the id in the body
        ENTITYPK mappedkey = getEntityPkToPkMapper().mapFrom(id);
        dto.setId(id);
        // maps the DTO to ENTITY
        ENTITY byId = getRepository().findById(mappedkey).orElseThrow((NotFoundException::new));


        ENTITY entity = getEntityMapper().mapFrom(dto);

        // persists it
        getRepository().saveAndFlush(entity);
    }

    @Override
    public void delete(DTOPK id) {
        //finds the Entity to persist
        Optional<DTO> dtoOpt = this.read(id);
        //deletes it
        dtoOpt.ifPresent(t->getRepository().delete(getEntityMapper().mapFrom(dtoOpt.get())));
    }
}
