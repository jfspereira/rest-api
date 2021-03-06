package com.cofco.webservice.controller.example.impl.base;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cofco.business.dto.base.AbstractBaseId;
import com.cofco.business.dto.base.ErrorEnum;
import com.cofco.business.dto.base.ErrorStatus;
import com.cofco.business.exception.AppRuntimeException;
import com.cofco.business.exception.ExceptionUtils;
import com.cofco.business.service.CrudService;
import com.cofco.webservice.controller.base.CrudController;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;
/**
 * Created by Tiago Vilas Boas on 14/06/2018.
 */

/**
 * Abstract generic controller
 * This class is meant to implement a default behaviour for rest CRUD operations
 * @param <T> the type of the DTO's primary key
 * @param <Y> the type of the DTO that is going to be persisted
 */
public abstract class AbstractController<T extends AbstractBaseId<Y>,Y extends Serializable> implements CrudController<T,Y> {

    protected CrudService<T,Y> companyService;

    protected abstract Logger getLogger();

    public AbstractController(CrudService<T, Y> crudService) {
        this.companyService = crudService;
    }


    @Override
    @GetMapping(value = "{id}")
    public ResponseEntity read(@PathVariable("id") Y id) {
        Optional<T> t;
        try {
            t = companyService.read(id);
            getLogger().info("read by id = {} from {}",id,this.getClass().getSimpleName());
        } catch (AppRuntimeException exception){
            getLogger().warn("failed to execute service {} with id={} with exception {}",
                    this.getClass().getSimpleName(),id,exception.getClass().getSimpleName());
            return handle(exception);
        }
        return t.isPresent()?new ResponseEntity<>(t.get(), HttpStatus.OK):ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorStatus().setErrorEnum(ErrorEnum.RESOURCE_NOT_FOUND).setMessage(ErrorEnum.RESOURCE_NOT_FOUND.description()));
    }


    @Override
    @GetMapping(value = "")
    public ResponseEntity<Collection<T>> list() {
        Collection<T> list;
        try {
            list = companyService.list();
            getLogger().info("listing resources from {}", this.getClass().getSimpleName());
        } catch (AppRuntimeException exception) {
            getLogger().warn("failed to execute service {} with id={} with exception {}",
                    this.getClass().getSimpleName(), exception.getClass().getSimpleName());
            return handle(exception);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Override
    @PostMapping(value = "")
    public ResponseEntity<T> create(@Valid @RequestBody T dto) {
        T created;
        try {
            created = companyService.create(dto);
            getLogger().info("listing resources from {}", this.getClass().getSimpleName());
        } catch (AppRuntimeException exception) {
            getLogger().warn("failed to execute service {} with id={} with exception {}",
                    this.getClass().getSimpleName(), exception.getClass().getSimpleName());
            return handle(exception);
        }
        return new ResponseEntity<>(created,HttpStatus.CREATED);
    }

    @Override
    @PutMapping(value = "{id}")
    public ResponseEntity<T> update(@PathVariable("id") Y id,@Valid @RequestBody  T dto) {
        try {
            companyService.update(id,dto);
            getLogger().info("listing resources from {}", this.getClass().getSimpleName());
        } catch (AppRuntimeException exception) {
            getLogger().warn("failed to execute service {} with id={} with exception {}",
                    this.getClass().getSimpleName(), exception.getClass().getSimpleName());
            return handle(exception);
        }
        return ResponseEntity.noContent().build();
    }

    @Override
    @DeleteMapping(value = "{id}")
    public ResponseEntity<T> delete(@PathVariable("id") Y id) {
        try {
            companyService.delete(id);
            getLogger().info("listing resources from {}", this.getClass().getSimpleName());
        } catch (AppRuntimeException exception) {
            getLogger().warn("failed to execute service {} with id={} with exception {}",
                    this.getClass().getSimpleName(), exception.getClass().getSimpleName());
            return handle(exception);
        }
        return ResponseEntity.noContent().build();
    }


    /**
     * Handles the exceptions to return the respective http
     * @param exception an instance of AppRuntimeException or a class that extends it
     * @return
     */
    protected ResponseEntity handle(AppRuntimeException exception) {
        return ExceptionUtils.handle(exception);
    }

}
