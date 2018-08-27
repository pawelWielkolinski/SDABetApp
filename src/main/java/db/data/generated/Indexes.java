/*
 * This file is generated by jOOQ.
*/
package db.data.generated;


import db.data.generated.tables.Bets;
import db.data.generated.tables.Matches;
import db.data.generated.tables.Users;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling indexes of tables of the <code></code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index SQLITE_AUTOINDEX_BETS_1 = Indexes0.SQLITE_AUTOINDEX_BETS_1;
    public static final Index SQLITE_AUTOINDEX_MATCHES_1 = Indexes0.SQLITE_AUTOINDEX_MATCHES_1;
    public static final Index SQLITE_AUTOINDEX_USERS_1 = Indexes0.SQLITE_AUTOINDEX_USERS_1;
    public static final Index SQLITE_AUTOINDEX_USERS_2 = Indexes0.SQLITE_AUTOINDEX_USERS_2;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 extends AbstractKeys {
        public static Index SQLITE_AUTOINDEX_BETS_1 = createIndex("sqlite_autoindex_bets_1", Bets.BETS, new OrderField[] { Bets.BETS.ID_BET }, true);
        public static Index SQLITE_AUTOINDEX_MATCHES_1 = createIndex("sqlite_autoindex_matches_1", Matches.MATCHES, new OrderField[] { Matches.MATCHES.ID_MATCH }, true);
        public static Index SQLITE_AUTOINDEX_USERS_1 = createIndex("sqlite_autoindex_users_1", Users.USERS, new OrderField[] { Users.USERS.ID_USER }, true);
        public static Index SQLITE_AUTOINDEX_USERS_2 = createIndex("sqlite_autoindex_users_2", Users.USERS, new OrderField[] { Users.USERS.USER_NAME }, true);
    }
}
