/*
 * This file is generated by jOOQ.
*/
package com.bisaga.myapp.database.model;


import com.bisaga.myapp.database.model.tables.Currency;
import com.bisaga.myapp.database.model.tables.SchemaVersion;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.currency</code>.
     */
    public static final Currency CURRENCY = com.bisaga.myapp.database.model.tables.Currency.CURRENCY;

    /**
     * The table <code>public.schema_version</code>.
     */
    public static final SchemaVersion SCHEMA_VERSION = com.bisaga.myapp.database.model.tables.SchemaVersion.SCHEMA_VERSION;
}
