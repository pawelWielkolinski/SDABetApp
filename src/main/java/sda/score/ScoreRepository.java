package sda.score;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import sda.db.data.DatabaseAccess;
import sda.db.data.generated.Tables;
import sda.db.data.generated.tables.Users;
import sda.db.data.generated.tables.records.UsersRecord;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("scoreRepository")
public class ScoreRepository extends DatabaseAccess {

    public static List<UsersRecord> getUsersScores(){
        try (Connection conn = connection()){
            DSLContext ctx = jooq(conn);

            Users users = Tables.USERS;
            return new ArrayList<>(ctx.selectFrom(users)
                    .orderBy(users.POINTS.desc().nullsLast())
                    .fetch());

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
