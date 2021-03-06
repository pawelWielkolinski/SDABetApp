/*
 * This file is generated by jOOQ.
*/
package sda.db.data.generated.tables.records;


import java.sql.Date;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;

import sda.db.data.generated.tables.Bets;


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
public class BetsRecord extends UpdatableRecordImpl<BetsRecord> implements Record7<Integer, Integer, Integer, Integer, Integer, Integer, Date> {

    private static final long serialVersionUID = 1220462313;

    /**
     * Setter for <code>bets.id_bet</code>.
     */
    public void setIdBet(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>bets.id_bet</code>.
     */
    public Integer getIdBet() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>bets.id_match</code>.
     */
    public void setIdMatch(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>bets.id_match</code>.
     */
    public Integer getIdMatch() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>bets.id_user</code>.
     */
    public void setIdUser(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>bets.id_user</code>.
     */
    public Integer getIdUser() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>bets.home_team_bet</code>.
     */
    public void setHomeTeamBet(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>bets.home_team_bet</code>.
     */
    public Integer getHomeTeamBet() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>bets.away_team_bet</code>.
     */
    public void setAwayTeamBet(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>bets.away_team_bet</code>.
     */
    public Integer getAwayTeamBet() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>bets.points</code>.
     */
    public void setPoints(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>bets.points</code>.
     */
    public Integer getPoints() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>bets.create_date</code>.
     */
    public void setCreateDate(Date value) {
        set(6, value);
    }

    /**
     * Getter for <code>bets.create_date</code>.
     */
    public Date getCreateDate() {
        return (Date) get(6);
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
    public Row7<Integer, Integer, Integer, Integer, Integer, Integer, Date> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, Integer, Integer, Integer, Integer, Integer, Date> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Bets.BETS.ID_BET;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Bets.BETS.ID_MATCH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Bets.BETS.ID_USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Bets.BETS.HOME_TEAM_BET;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return Bets.BETS.AWAY_TEAM_BET;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return Bets.BETS.POINTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field7() {
        return Bets.BETS.CREATE_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getIdBet();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getIdMatch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getIdUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getHomeTeamBet();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component5() {
        return getAwayTeamBet();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getPoints();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date component7() {
        return getCreateDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getIdBet();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getIdMatch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getIdUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getHomeTeamBet();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getAwayTeamBet();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getPoints();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value7() {
        return getCreateDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BetsRecord value1(Integer value) {
        setIdBet(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BetsRecord value2(Integer value) {
        setIdMatch(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BetsRecord value3(Integer value) {
        setIdUser(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BetsRecord value4(Integer value) {
        setHomeTeamBet(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BetsRecord value5(Integer value) {
        setAwayTeamBet(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BetsRecord value6(Integer value) {
        setPoints(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BetsRecord value7(Date value) {
        setCreateDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BetsRecord values(Integer value1, Integer value2, Integer value3, Integer value4, Integer value5, Integer value6, Date value7) {
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
     * Create a detached BetsRecord
     */
    public BetsRecord() {
        super(Bets.BETS);
    }

    /**
     * Create a detached, initialised BetsRecord
     */
    public BetsRecord(Integer idBet, Integer idMatch, Integer idUser, Integer homeTeamBet, Integer awayTeamBet, Integer points, Date createDate) {
        super(Bets.BETS);

        set(0, idBet);
        set(1, idMatch);
        set(2, idUser);
        set(3, homeTeamBet);
        set(4, awayTeamBet);
        set(5, points);
        set(6, createDate);
    }
}
