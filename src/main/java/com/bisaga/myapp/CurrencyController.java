/*
*  MIT License
*  Copyright (c) 2017 Igor Babic
*/
package com.bisaga.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;

@RestController
public class CurrencyController {

    @Autowired private CurrencyService service;

    @RequestMapping(value="/api/currency", method=RequestMethod.GET)
    public CurrencyDto findCurrency(@RequestParam(value="code", defaultValue="EUR") String code) {
        return service.getByCode(code);
    }

    @RequestMapping(value="/api/currency", method=RequestMethod.POST)
    public CurrencyDto saveCurrency(@RequestBody CurrencyDto currency) {
        return service.saveCurrency(currency);
    }

    @RequestMapping(value="/api/currency", method=RequestMethod.DELETE)
    public Integer deleteCurrency(@RequestParam(value="rowid") Integer rowId ) {
        return service.delete(rowId);
    }


}
