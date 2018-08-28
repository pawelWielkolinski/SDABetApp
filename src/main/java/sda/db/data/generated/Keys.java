/*
 * This file is generated by jOOQ.
*/
package sda.db.data.generated;


import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;

import sda.db.data.generated.tables.Bets;
import sda.db.data.generated.tables.Matches;
import sda.db.data.generated.tables.Users;
import sda.db.data.generated.tables.records.BetsRecord;
import sda.db.data.generated.tables.records.MatchesRecord;
import sda.db.data.generated.tables.records.UsersRecord;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code></code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<BetsRecord> PK_BETS = UniqueKeys0.PK_BETS;
    public static final UniqueKey<MatchesRecord> PK_MATCHES = UniqueKeys0.PK_MATCHES;
    public static final UniqueKey<UsersRecord> PK_USERS = UniqueKeys0.PK_USERS;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<BetsRecord, MatchesRecord> FK_BETS_MATCHES_1 = ForeignKeys0.FK_BETS_MATCHES_1;
    public static final ForeignKey<BetsRecord, UsersRecord> FK_BETS_USERS_1 = ForeignKeys0.FK_BETS_USERS_1;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<BetsRecord> PK_BETS = createUniqueKey(Bets.BETS, "pk_bets", Bets.BETS.ID_BET);
        public static final UniqueKey<MatchesRecord> PK_MATCHES = createUniqueKey(Matches.MATCHES, "pk_matches", Matches.MATCHES.ID_MATCH);
        public static final UniqueKey<UsersRecord> PK_USERS = createUniqueKey(Users.USERS, "pk_users", Users.USERS.ID_USER);
    }

    private static class ForeignKeys0 extends AbstractKeys {
        public static final ForeignKey<BetsRecord, MatchesRecord> FK_BETS_MATCHES_1 = createForeignKey(sda.db.data.generated.Keys.PK_MATCHES, Bets.BETS, "fk_bets_matches_1", Bets.BETS.ID_MATCH);
        public static final ForeignKey<BetsRecord, UsersRecord> FK_BETS_USERS_1 = createForeignKey(sda.db.data.generated.Keys.PK_USERS, Bets.BETS, "fk_bets_users_1", Bets.BETS.ID_USER);
    }
}