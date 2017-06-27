/*
*  MIT License
*  Copyright (c) 2017 Igor Babic
*/
package com.bisaga.myapp;

import static com.bisaga.myapp.database.model.tables.Currency.CURRENCY;

import com.bisaga.myapp.database.model.tables.records.CurrencyRecord;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
class CurrencyService {
    private static final Logger LOG = LoggerFactory.getLogger(CurrencyService.class);

    @Autowired
    private DSLContext db;

    /**
     * List all currencies in the currency table
     * @return Return list of currency records
     */
    List<CurrencyDto> getAll() {
        List<CurrencyDto> currList;
        currList = db.select().from(CURRENCY)
                .fetch().into(CurrencyDto.class);

        return currList;
    }


    /**
     * Search for a currency record by currency code
     * @param code  currency code as parameter
     * @return Return currency record
     */
    List<CurrencyDto> getByCode(String code) {
        List<CurrencyDto> currList;
        currList = db.select().from(CURRENCY)
                .where(CURRENCY.CODE.eq(code))
                .fetch().into(CurrencyDto.class);
        
        return currList;
    }

    /**
     * Delete currency record by row identifier
     * @param rowId rowId row identifier
     * @return Return number of deleted records
     */
    Integer delete(Integer rowId) {
        return db.delete(CURRENCY).where(CURRENCY.ROW_ID.eq(rowId)).execute();
    }

    /**
     * Save currency execute insert or update command if currency already exist.
     * @param currency instance of CurrencyDto class as parameter
     */
    CurrencyDto saveCurrency(CurrencyDto currency) {
        if (currency.getRowId() == null) {
            return this.insert(currency);
        } else {
            return this.update(currency);
        }
    }

    /**
     * Insert new currency record to database
     * @param currency Currency record as parameter
     * @return Return currency record filled with database defaults after insert
     */
    private CurrencyDto  insert(CurrencyDto currency)  {
        CurrencyRecord record = db.newRecord(CURRENCY, currency);
        record.setCreatedBy("admin");
        record.insert();                // insert to database
        record.into(currency);			// return changes made by database
        return currency;
    }

    /**
     * Update currency record in database
     * @param currency currency record as parameter
     * @return Return currency record filled with changes from database update
     */
    private CurrencyDto update(CurrencyDto currency) {
        CurrencyRecord record = db.newRecord(CURRENCY, currency);
        record.update();                // update to database
        record.into(currency);			// return changes made by database
        return currency;
    }

}
