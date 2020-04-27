package com.cofco.webservice.controller.example.impl;

import com.cofco.common.constants.ServiceConstants;
import com.cofco.webservice.controller.example.impl.base.AbstractController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cofco.business.dto.CompanyDto;
import com.cofco.business.dto.OwnerDto;
import com.cofco.business.exception.AppRuntimeException;
import com.cofco.business.service.CompanyService;
import com.cofco.webservice.controller.example.CompanyController;

import javax.validation.Valid;
import java.util.Collection;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 * Implementation of the company controller
 */

@RestController
@RequestMapping(value = ServiceConstants.Paths.COMPANY)
public class CompanyControllerImpl extends AbstractController<CompanyDto, Long> implements CompanyController {

    private final Logger logger = LoggerFactory.getLogger(CompanyControllerImpl.class);


    @Autowired
    public CompanyControllerImpl(CompanyService companyService) {
        super(companyService);
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


    @Override
    @GetMapping(value = "")
    @ApiOperation(value = "Lists all the companies",response = CompanyDto.class,responseContainer = "list")
    @ApiResponses(value = {
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.OK, message = "Success"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.INTERNAL_SERVER_ERROR, message = "Something went very wrong")
    })
    public ResponseEntity<Collection<CompanyDto>> list() {
        return super.list();
    }

    @Override
    @GetMapping(value = "{id}")
    @ApiOperation(value = "Finds a company by id",response = CompanyDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.OK, message = "Success"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.NOT_FOUND, message = "Unable to found company of the give id"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.INTERNAL_SERVER_ERROR, message = "Something went very wrong")
    })
    public ResponseEntity read(@PathVariable("id") Long id) {
        return super.read(id);
    }

    @Override
    @PostMapping(value = "")
    @ApiOperation(value = "Creates a company and returns the created company",response = CompanyDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.CREATED, message = "Success"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.INTERNAL_SERVER_ERROR, message = "Something went very wrong")
    })
    public ResponseEntity<CompanyDto> create(@Valid CompanyDto dto) {
        return super.create(dto);
    }

    @Override
    @PutMapping(value = "{id}")
    @ApiOperation(value = "Updates a company with the given id ")
    @ApiResponses(value = {
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.OK, message = "Success"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.NOT_FOUND, message = "Unable to found company of the give id"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.INTERNAL_SERVER_ERROR, message = "Something went very wrong")
    })
    public ResponseEntity<CompanyDto> update(@PathVariable("id") Long id, @Valid CompanyDto dto) {
        return super.update(id, dto);
    }

    @Override
    @DeleteMapping(value = "{id}")
    @ApiOperation(value = "Deletes a company with the given id ")
    @ApiResponses(value = {
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.NO_CONTENT, message = "Success"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.NOT_FOUND, message = "Unable to found company of the give id"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.INTERNAL_SERVER_ERROR, message = "Something went very wrong")
    })
    public ResponseEntity<CompanyDto> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }




    @Override
    @GetMapping(value = "{id}/owner")
    @ApiOperation(value = "Lists all the owners of the company with the given id",response = OwnerDto.class,responseContainer = "list")
    @ApiResponses(value = {
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.OK, message = "Success"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.INTERNAL_SERVER_ERROR, message = "Something went very wrong")
    })
    public ResponseEntity owners(@PathVariable("id") Long id) {
        Collection<OwnerDto> list;
        try {
            CompanyService companyService = (CompanyService) this.companyService;
            list = companyService.owners(id);
            getLogger().info("listing resources from {}", this.getClass().getSimpleName());
        } catch (AppRuntimeException exception) {
            getLogger().warn("failed to execute service {} with id={} with exception {}",
                    this.getClass().getSimpleName(), exception.getClass().getSimpleName());
            return handle(exception);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @Override
    @PostMapping(value = "{id}/owner/")
    @ApiOperation(value = "Adds a new owner to the company with the given company and owner id", response = OwnerDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.OK, message = "Success"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.INTERNAL_SERVER_ERROR, message = "Something went very wrong")
    })
    public ResponseEntity addNewOwner(@PathVariable("id") Long id, @RequestBody @Valid OwnerDto ownerDto) {
        OwnerDto createdOwner;
        try {
            CompanyService companyService = (CompanyService) this.companyService;
            createdOwner = companyService.addNewOwner(id,ownerDto);
            getLogger().info("listing resources from {}", this.getClass().getSimpleName());
        } catch (AppRuntimeException exception) {
            getLogger().warn("failed to execute service {} with id={} with exception {}",
                    this.getClass().getSimpleName(), exception.getClass().getSimpleName());
            return handle(exception);
        }
        return new ResponseEntity<>(createdOwner,HttpStatus.CREATED);
    }

    @Override
    @PutMapping(value = "{id}/owner/{ownerId}")
    @ApiOperation(value = "Adds a owner to the company with the given company and owner id")
    @ApiResponses(value = {
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.OK, message = "Success"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.NOT_FOUND, message = "Unable to found company of the give id"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.INTERNAL_SERVER_ERROR, message = "Something went very wrong")
    })
    public ResponseEntity addOwner(@PathVariable("id") Long id, @PathVariable("ownerId") Long ownerId) {
        try {
            CompanyService companyService = (CompanyService) this.companyService;
            companyService.addOwner(id,ownerId);
            getLogger().info("listing resources from {}", this.getClass().getSimpleName());
        } catch (AppRuntimeException exception) {
            getLogger().warn("failed to execute service {} with id={} with exception {}",
                    this.getClass().getSimpleName(), exception.getClass().getSimpleName());
            return handle(exception);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @DeleteMapping(value = "{id}/owner/{ownerId}")
    @ApiOperation(value = "Removes a owner from the company with the given company and owner id")
    @ApiResponses(value = {
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.NO_CONTENT, message = "Success"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.NOT_FOUND, message = "Unable to found company of the give id"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.INTERNAL_SERVER_ERROR, message = "Something went very wrong")
    })
    public ResponseEntity removeOwner(@PathVariable("id") Long id, @PathVariable("ownerId") Long ownerId) {
        try {
            CompanyService companyService = (CompanyService) this.companyService;
            companyService.removeOwner(id,ownerId);
            getLogger().info("listing resources from {}", this.getClass().getSimpleName());
        } catch (AppRuntimeException exception) {
            getLogger().warn("failed to execute service {} with id={} with exception {}",
                    this.getClass().getSimpleName(), exception.getClass().getSimpleName());
            return handle(exception);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
