package db.data;

import db.data.generated.Tables;
import db.data.generated.tables.Matches;
import db.data.generated.tables.records.MatchesRecord;
import org.jooq.DSLContext;

import java.sql.Connection;
import java.sql.SQLException;

public class MatchRepository extends DatabaseAccess {

    public Integer insert(MatchesRecord record) {

        return storeMatches(record);
    }

    public Integer storeMatches(MatchesRecord record) {
        try (Connection conn = connection()) {
            DSLContext ctx = jooq(conn);

            record.attach(ctx.configuration());
            record.store();
            record.refresh();
            return record.getIdMatch();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MatchesRecord getById(Integer id) {
        try (Connection conn = connection()) {
            DSLContext ctx = jooq(conn);

            Matches match = Tables.MATCHES;

            return ctx.selectFrom(match)
                    .where(match.ID_MATCH.eq(id))
                    .fetchOne();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
