package com.cofco.webservice.controller.example;

import com.cofco.webservice.controller.base.CrudController;
import org.springframework.http.ResponseEntity;
import com.cofco.business.dto.CompanyDto;
import com.cofco.business.dto.OwnerDto;

/**
 * Created by Tiago Vilas Boas on 16/06/2018.
 */
public interface CompanyController extends CrudController<CompanyDto, Long> {

    ResponseEntity owners(Long id);
    ResponseEntity addNewOwner(Long id, OwnerDto ownerDto);
    ResponseEntity addOwner(Long id, Long ownerId);
    ResponseEntity removeOwner(Long id, Long ownerId);
}
