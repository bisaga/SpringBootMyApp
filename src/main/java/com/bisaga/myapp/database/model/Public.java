/*
 * This file is generated by jOOQ.
*/
package com.bisaga.myapp.database.model;


import com.bisaga.myapp.database.model.tables.Currency;
import com.bisaga.myapp.database.model.tables.SchemaVersion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1546663512;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.currency</code>.
     */
    public final Currency CURRENCY = com.bisaga.myapp.database.model.tables.Currency.CURRENCY;

    /**
     * The table <code>public.schema_version</code>.
     */
    public final SchemaVersion SCHEMA_VERSION = com.bisaga.myapp.database.model.tables.SchemaVersion.SCHEMA_VERSION;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        List result = new ArrayList();
        result.addAll(getSequences0());
        return result;
    }

    private final List<Sequence<?>> getSequences0() {
        return Arrays.<Sequence<?>>asList(
            Sequences.CURRENCY_ROW_ID_SEQ);
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Currency.CURRENCY,
            SchemaVersion.SCHEMA_VERSION);
    }
}