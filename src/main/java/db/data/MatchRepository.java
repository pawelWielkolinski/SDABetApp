package db.data;

import com.google.common.base.Strings;
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
}
