/*
 * This file is generated by jOOQ.
*/
package sda.db.data.generated.tables;


import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import sda.db.data.generated.DefaultSchema;
import sda.db.data.generated.Indexes;
import sda.db.data.generated.Keys;
import sda.db.data.generated.tables.records.BetsRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Bets extends TableImpl<BetsRecord> {

    private static final long serialVersionUID = -1571231280;

    /**
     * The reference instance of <code>bets</code>
     */
    public static final Bets BETS = new Bets();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BetsRecord> getRecordType() {
        return BetsRecord.class;
    }

    /**
     * The column <code>bets.id_bet</code>.
     */
    public final TableField<BetsRecord, Integer> ID_BET = createField("id_bet", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("1", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>bets.id_match</code>.
     */
    public final TableField<BetsRecord, Integer> ID_MATCH = createField("id_match", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>bets.id_user</code>.
     */
    public final TableField<BetsRecord, Integer> ID_USER = createField("id_user", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>bets.home_team_bet</code>.
     */
    public final TableField<BetsRecord, Integer> HOME_TEAM_BET = createField("home_team_bet", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>bets.away_team_bet</code>.
     */
    public final TableField<BetsRecord, Integer> AWAY_TEAM_BET = createField("away_team_bet", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>bets.points</code>.
     */
    public final TableField<BetsRecord, Integer> POINTS = createField("points", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>bets.create_date</code>.
     */
    public final TableField<BetsRecord, Date> CREATE_DATE = createField("create_date", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * Create a <code>bets</code> table reference
     */
    public Bets() {
        this(DSL.name("bets"), null);
    }

    /**
     * Create an aliased <code>bets</code> table reference
     */
    public Bets(String alias) {
        this(DSL.name(alias), BETS);
    }

    /**
     * Create an aliased <code>bets</code> table reference
     */
    public Bets(Name alias) {
        this(alias, BETS);
    }

    private Bets(Name alias, Table<BetsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Bets(Name alias, Table<BetsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.SQLITE_AUTOINDEX_BETS_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<BetsRecord> getPrimaryKey() {
        return Keys.PK_BETS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<BetsRecord>> getKeys() {
        return Arrays.<UniqueKey<BetsRecord>>asList(Keys.PK_BETS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<BetsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<BetsRecord, ?>>asList(Keys.FK_BETS_MATCHES_1, Keys.FK_BETS_USERS_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Bets as(String alias) {
        return new Bets(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Bets as(Name alias) {
        return new Bets(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Bets rename(String name) {
        return new Bets(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Bets rename(Name name) {
        return new Bets(name, null);
    }
}
