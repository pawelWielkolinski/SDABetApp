package sda.bet;

import org.jooq.DSLContext;
import sda.db.data.DatabaseAccess;
import sda.db.data.generated.Tables;
import sda.db.data.generated.tables.Bets;
import sda.db.data.generated.tables.records.BetsRecord;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BetRepository extends DatabaseAccess {

    public Integer insert(BetsRecord record) {
        return storeBet(record);
    }

    public Integer storeBet(BetsRecord record) {
        try (Connection conn = connection()) {
            DSLContext ctx = jooq(conn);

            record.attach(ctx.configuration());
            record.store();
            record.refresh();
            return record.getIdBet();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BetsRecord> getBetsByUserId(Integer userId) {
        try (Connection conn = connection()) {
            DSLContext ctx = jooq(conn);
            Bets bets = Tables.BETS;
            return new ArrayList<>(ctx.selectFrom(bets)
                    .where(bets.ID_USER.equal(userId))
                    .fetch());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BetsRecord> getBetsByMatchId(Integer matchId) {
        try (Connection conn = connection()) {
            DSLContext ctx = jooq(conn);
            Bets bets = Tables.BETS;
            return new ArrayList<>(ctx.selectFrom(bets)
                    .where(bets.ID_MATCH.equal(matchId))
                    .fetch());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}