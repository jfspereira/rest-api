package com.cofco.webservice.controller.example.impl;

import com.cofco.common.constants.ServiceConstants;
import com.cofco.webservice.controller.example.impl.base.AbstractController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cofco.business.dto.OwnerDto;
import com.cofco.business.service.OwnerService;
import com.cofco.webservice.controller.example.OwnerController;

import javax.validation.Valid;
import java.util.Collection;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 * Implementation of the owner controller
 */

@RestController
@RequestMapping(value = ServiceConstants.Paths.OWNER)
public class OwnerControllerImpl extends AbstractController<OwnerDto, Long> implements OwnerController {

    private final Logger logger = LoggerFactory.getLogger(OwnerControllerImpl.class);


    @Override
    @GetMapping(value = "")
    @ApiOperation(value = "Lists all the owners",response = OwnerDto.class,responseContainer = "list")
    @ApiResponses(value = {
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.OK, message = "Success"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.INTERNAL_SERVER_ERROR, message = "Something went very wrong")
    })
    public ResponseEntity<Collection<OwnerDto>> list() {
        return super.list();
    }

    @Override
    @GetMapping(value = "{id}")
    @ApiOperation(value = "Finds a owner by id",response = OwnerDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.OK, message = "Success"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.NOT_FOUND, message = "Unable to found owner of the give id"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.INTERNAL_SERVER_ERROR, message = "Something went very wrong")
    })
    public ResponseEntity read(@PathVariable("id") Long id) {
        return super.read(id);
    }

    @Override
    @PostMapping(value = "")
    @ApiOperation(value = "Creates a owner and returns the created owner",response = OwnerDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.CREATED, message = "Success"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.INTERNAL_SERVER_ERROR, message = "Something went very wrong")
    })
    public ResponseEntity<OwnerDto> create(@Valid OwnerDto dto) {
        return super.create(dto);
    }

    @Override
    @PutMapping(value = "{id}")
    @ApiOperation(value = "Updates a owner with the given id ")
    @ApiResponses(value = {
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.OK, message = "Success"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.NOT_FOUND, message = "Unable to found owner of the give id"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.INTERNAL_SERVER_ERROR, message = "Something went very wrong")
    })
    public ResponseEntity<OwnerDto> update(@PathVariable("id") Long id, @Valid OwnerDto dto) {
        return super.update(id, dto);
    }

    @Override
    @DeleteMapping(value = "{id}")
    @ApiOperation(value = "Deletes a owner with the given id ")
    @ApiResponses(value = {
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.NO_CONTENT, message = "Success"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.NOT_FOUND, message = "Unable to found owner of the give id"),
            @ApiResponse(code = ServiceConstants.Api.Responses.Codes.INTERNAL_SERVER_ERROR, message = "Something went very wrong")
    })
    public ResponseEntity<OwnerDto> delete(@PathVariable("id") Long id) {
        return super.delete(id);
    }


    @Autowired
    public OwnerControllerImpl(OwnerService ownerService) {
        super(ownerService);
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }


}
