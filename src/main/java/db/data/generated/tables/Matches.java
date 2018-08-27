/*
 * This file is generated by jOOQ.
*/
package db.data.generated.tables;


import db.data.generated.DefaultSchema;
import db.data.generated.Indexes;
import db.data.generated.Keys;
import db.data.generated.tables.records.MatchesRecord;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Matches extends TableImpl<MatchesRecord> {

    private static final long serialVersionUID = -941269625;

    /**
     * The reference instance of <code>matches</code>
     */
    public static final Matches MATCHES = new Matches();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MatchesRecord> getRecordType() {
        return MatchesRecord.class;
    }

    /**
     * The column <code>matches.id_match</code>.
     */
    public final TableField<MatchesRecord, Integer> ID_MATCH = createField("id_match", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>matches.home_team</code>.
     */
    public final TableField<MatchesRecord, String> HOME_TEAM = createField("home_team", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>matches.away_team</code>.
     */
    public final TableField<MatchesRecord, String> AWAY_TEAM = createField("away_team", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>matches.home_team_goals</code>.
     */
    public final TableField<MatchesRecord, Integer> HOME_TEAM_GOALS = createField("home_team_goals", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>matches.away_team_goals</code>.
     */
    public final TableField<MatchesRecord, Integer> AWAY_TEAM_GOALS = createField("away_team_goals", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>matches.start_date</code>.
     */
    public final TableField<MatchesRecord, Date> START_DATE = createField("start_date", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * The column <code>matches.start_time</code>.
     */
    public final TableField<MatchesRecord, Time> START_TIME = createField("start_time", org.jooq.impl.SQLDataType.TIME.nullable(false), this, "");

    /**
     * Create a <code>matches</code> table reference
     */
    public Matches() {
        this(DSL.name("matches"), null);
    }

    /**
     * Create an aliased <code>matches</code> table reference
     */
    public Matches(String alias) {
        this(DSL.name(alias), MATCHES);
    }

    /**
     * Create an aliased <code>matches</code> table reference
     */
    public Matches(Name alias) {
        this(alias, MATCHES);
    }

    private Matches(Name alias, Table<MatchesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Matches(Name alias, Table<MatchesRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.SQLITE_AUTOINDEX_MATCHES_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<MatchesRecord> getPrimaryKey() {
        return Keys.PK_MATCHES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<MatchesRecord>> getKeys() {
        return Arrays.<UniqueKey<MatchesRecord>>asList(Keys.PK_MATCHES);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Matches as(String alias) {
        return new Matches(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Matches as(Name alias) {
        return new Matches(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Matches rename(String name) {
        return new Matches(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Matches rename(Name name) {
        return new Matches(name, null);
    }
}
