package db.data;

import db.data.generated.Tables;
import db.data.generated.tables.Matches;
import db.data.generated.tables.records.MatchesRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.UpdatableRecord;
import org.jooq.impl.DSL;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Klasa polaczenia z baza danych.
 */
public class DatabaseAccess {

    /**
     * @return okreslenie polaczenia na bazie okreslonych ustawien na lokalizacje
     */
    protected static Connection connection() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
        String sdaDatabase = System.getenv("SDA_DATABASE");
        sdaDatabase = "src/main/resources/database.db";
        if (sdaDatabase == null || "".equals(sdaDatabase.trim())) {
            throw new IllegalStateException("Brak wskazania w zmiennej srodowiskowej 'SDA_DATABASE' na lokalizacje bazy danych.");
        }
        try {
            return DriverManager.getConnection("jdbc:sqlite:" + new File(sdaDatabase).getAbsolutePath());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param connection na bazie polaczenie
     * @return pobranie dslContext na bazie connection
     */
    protected static DSLContext jooq(Connection connection) {
        return DSL.using(connection(), SQLDialect.SQLITE);
    }

    public String encodePassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            byte[] data = messageDigest.digest();
            StringBuilder hashedPassword = new StringBuilder();
            for (byte b : data) {
                hashedPassword.append(b);
            }
            return hashedPassword.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String removeScriptTags(String givenText) {
        return Jsoup.clean(givenText, Whitelist.relaxed());
    }

    /**
     * Metoda pozwalajaca na zapisanie okreslonego rekordu na podstawie przekaznego
     * obiektu.
     *
     * @param record rekord do zapisu
     */
    protected void store(UpdatableRecord record) {
        try (Connection conn = connection()) {
            DSLContext ctx = jooq(conn);

            record.attach(ctx.configuration());
            record.store();
            record.refresh();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MatchesRecord> findAllMatches() {
        Matches matches = Tables.MATCHES;
        // wykonanie zapytania
        try (Connection conn = connection()) {
            DSLContext ctx = jooq(conn);
            return ctx.selectFrom(matches).fetch().stream().collect(Collectors.toList());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}