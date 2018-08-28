/*
 * This file is generated by jOOQ.
*/
package sda.db.data.generated.tables.records;


import java.sql.Date;
import java.sql.Time;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;

import sda.db.data.generated.tables.Matches;


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
public class MatchesRecord extends UpdatableRecordImpl<MatchesRecord> implements Record7<Integer, String, String, Integer, Integer, Date, Time> {

    private static final long serialVersionUID = 663101110;

    /**
     * Setter for <code>matches.id_match</code>.
     */
    public void setIdMatch(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>matches.id_match</code>.
     */
    public Integer getIdMatch() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>matches.home_team</code>.
     */
    public void setHomeTeam(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>matches.home_team</code>.
     */
    public String getHomeTeam() {
        return (String) get(1);
    }

    /**
     * Setter for <code>matches.away_team</code>.
     */
    public void setAwayTeam(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>matches.away_team</code>.
     */
    public String getAwayTeam() {
        return (String) get(2);
    }

    /**
     * Setter for <code>matches.home_team_goals</code>.
     */
    public void setHomeTeamGoals(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>matches.home_team_goals</code>.
     */
    public Integer getHomeTeamGoals() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>matches.away_team_goals</code>.
     */
    public void setAwayTeamGoals(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>matches.away_team_goals</code>.
     */
    public Integer getAwayTeamGoals() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>matches.start_date</code>.
     */
    public void setStartDate(Date value) {
        set(5, value);
    }

    /**
     * Getter for <code>matches.start_date</code>.
     */
    public Date getStartDate() {
        return (Date) get(5);
    }

    /**
     * Setter for <code>matches.start_time</code>.
     */
    public void setStartTime(Time value) {
        set(6, value);
    }

    /**
     * Getter for <code>matches.start_time</code>.
     */
    public Time getStartTime() {
        return (Time) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, String, String, Integer, Integer, Date, Time> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, String, String, Integer, Integer, Date, Time> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Matches.MATCHES.ID_MATCH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Matches.MATCHES.HOME_TEAM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Matches.MATCHES.AWAY_TEAM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Matches.MATCHES.HOME_TEAM_GOALS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return Matches.MATCHES.AWAY_TEAM_GOALS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field6() {
        return Matches.MATCHES.START_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Time> field7() {
        return Matches.MATCHES.START_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getIdMatch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getHomeTeam();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getAwayTeam();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getHomeTeamGoals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component5() {
        return getAwayTeamGoals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date component6() {
        return getStartDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Time component7() {
        return getStartTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getIdMatch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getHomeTeam();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getAwayTeam();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getHomeTeamGoals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getAwayTeamGoals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value6() {
        return getStartDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Time value7() {
        return getStartTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MatchesRecord value1(Integer value) {
        setIdMatch(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MatchesRecord value2(String value) {
        setHomeTeam(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MatchesRecord value3(String value) {
        setAwayTeam(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MatchesRecord value4(Integer value) {
        setHomeTeamGoals(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MatchesRecord value5(Integer value) {
        setAwayTeamGoals(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MatchesRecord value6(Date value) {
        setStartDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MatchesRecord value7(Time value) {
        setStartTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MatchesRecord values(Integer value1, String value2, String value3, Integer value4, Integer value5, Date value6, Time value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MatchesRecord
     */
    public MatchesRecord() {
        super(Matches.MATCHES);
    }

    /**
     * Create a detached, initialised MatchesRecord
     */
    public MatchesRecord(Integer idMatch, String homeTeam, String awayTeam, Integer homeTeamGoals, Integer awayTeamGoals, Date startDate, Time startTime) {
        super(Matches.MATCHES);

        set(0, idMatch);
        set(1, homeTeam);
        set(2, awayTeam);
        set(3, homeTeamGoals);
        set(4, awayTeamGoals);
        set(5, startDate);
        set(6, startTime);
    }
}