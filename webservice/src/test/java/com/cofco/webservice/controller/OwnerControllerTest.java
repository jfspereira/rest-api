package com.cofco.webservice.controller;

import com.cofco.business.dto.OwnerDto;
import com.cofco.webservice.app.Application;
import com.cofco.webservice.controller.example.OwnerController;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OwnerControllerTest implements CrudTest {


    @Autowired
    private OwnerController ownerController;
    @Autowired
    TempId tempId;

    private OwnerDto ownerDto = new OwnerDto()
            .setName("Owner name")
            .setTitle("Owner title")
            ;

    @Override
    @Test
    public void test1Create() {
        ResponseEntity read = ownerController.create(ownerDto);
        ownerDto = (OwnerDto) read.getBody();
        tempId.setCompanyId(ownerDto.getId());
        assertEquals(read.getStatusCode(), HttpStatus.CREATED);
    }


    @Override
    @Test
    public void test2Update() {
        ResponseEntity read = ownerController.update(tempId.getCompanyId(), ownerDto.setName("updated name"));
        assertEquals(read.getStatusCode(), HttpStatus.NO_CONTENT);
    }

    @Override
    @Test
    public void test4Read() {
        ResponseEntity read = ownerController.read(tempId.getCompanyId());
        assertEquals(read.getStatusCode(), HttpStatus.OK);
    }


    @Override
    @Test
    public void test8Delete() {
        ResponseEntity read = ownerController.delete(tempId.getCompanyId());
        assertEquals(read.getStatusCode(), HttpStatus.NO_CONTENT);
    }


    @Override
    @Test
    public void test7List() {

        ResponseEntity read = ownerController.list();
        assertEquals(read.getStatusCode(), HttpStatus.OK);
    }


}
