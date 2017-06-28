/*
*  MIT License
*  Copyright (c) 2017 Igor Babic
*/
package com.bisaga.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;
import java.util.List;

@RestController
@RequestMapping(value = "/api/currency", produces = "application/json")
public class CurrencyController {

    @Autowired private CurrencyService service;

    @RequestMapping(method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.FOUND)
    public List<CurrencyDto> findAll() {
        return service.getAll();
    }

    @RequestMapping(value="/{code}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.FOUND)
    public CurrencyDto findByCode(@PathVariable("code") String code) {
        return service.getByCode(code);
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public CurrencyDto saveCurrency(@RequestBody CurrencyDto currency) {
        return service.saveCurrency(currency);
    }

    @RequestMapping(method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public Integer deleteCurrency(@RequestParam(value = "rowid", required = true) Integer rowId ) {
        return service.delete(rowId);
    }


}
