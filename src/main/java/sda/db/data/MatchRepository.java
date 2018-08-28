package sda.db.data;

import org.jooq.Result;
import sda.db.data.generated.Tables;
import sda.db.data.generated.tables.Matches;
import sda.db.data.generated.tables.records.MatchesRecord;
import org.jooq.DSLContext;

import java.sql.Connection;
import java.sql.Date;
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

    public Result<MatchesRecord> getByDate(String date) {

        try (Connection conn = connection();) {
            DSLContext ctx = jooq(conn);

            Matches match = Tables.MATCHES;

            return ctx.selectFrom(match)
                    .where(match.START_DATE.eq(Date.valueOf(date)))
                    .fetch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Result<MatchesRecord> getByTeamName(String team) {

        try (Connection conn = connection();) {
            DSLContext ctx = jooq(conn);

            Matches match = Tables.MATCHES;

            return ctx.selectFrom(match)
                    .where(match.AWAY_TEAM.contains(team))
                    .or(match.HOME_TEAM.contains(team))
                    .fetch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
