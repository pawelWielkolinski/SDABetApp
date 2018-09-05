package sda.match;

import org.jooq.Result;
import org.springframework.stereotype.Repository;
import sda.db.data.DatabaseAccess;
import sda.db.data.generated.Tables;
import sda.db.data.generated.tables.Matches;
import sda.db.data.generated.tables.records.MatchesRecord;
import org.jooq.DSLContext;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

@Repository
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
                    .orderBy(match.START_DATE, match.START_TIME)
                    .fetchOne();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Result<MatchesRecord> getByDate(String dateFrom, String dateTo) {

        try (Connection conn = connection();) {
            DSLContext ctx = jooq(conn);

            Matches match = Tables.MATCHES;

            return ctx.selectFrom(match)
                    .where(match.START_DATE.between(Date.valueOf(dateFrom),Date.valueOf(dateTo)))
                    .orderBy(match.START_DATE, match.START_TIME)
                    .fetch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Result<MatchesRecord> getByDateLimit5() {

        try (Connection conn = connection();) {
            DSLContext ctx = jooq(conn);

            Matches match = Tables.MATCHES;

            return ctx.selectFrom(match)
                    .where(match.START_DATE.greaterOrEqual(Date.valueOf(LocalDate.now())))
                    .orderBy(match.START_DATE, match.START_TIME)
                    .limit(8)
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
                    .orderBy(match.START_DATE, match.START_TIME)
                    .fetch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Result<MatchesRecord> getByPresentScore() {

        try (Connection conn = connection();) {
            DSLContext ctx = jooq(conn);

            Matches match = Tables.MATCHES;

            return ctx.selectFrom(match)
                    .where(match.AWAY_TEAM_GOALS.isNotNull())
                    .and(match.HOME_TEAM_GOALS.isNotNull())
                    .orderBy(match.START_DATE, match.START_TIME)
                    .fetch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
