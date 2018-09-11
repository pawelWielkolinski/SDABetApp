package sda.user;

import com.google.common.base.Strings;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import sda.db.data.DatabaseAccess;
import sda.db.data.generated.Tables;
import sda.db.data.generated.tables.Bets;
import sda.db.data.generated.tables.Users;
import sda.db.data.generated.tables.records.UsersRecord;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@Repository("userRepository")
public class UserRepository extends DatabaseAccess {

    public Integer insert (UsersRecord record){
        return storeUser(record);
    }



    public Integer storeUser(UsersRecord record) {
        try (Connection conn = connection()) {
            DSLContext ctx = jooq(conn);

            record.attach(ctx.configuration());
            record.store();
            record.refresh();
            return record.getIdUser();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UsersRecord getUserByUserName(String userName) {
        try (Connection conn = connection()) {
            DSLContext ctx = jooq(conn);
            Users users = Tables.USERS;
            return ctx.selectFrom(users)
                    .where(users.USER_NAME.equal(userName))
                    .fetchOne();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UsersRecord getUserById(Integer id) {
        try (Connection conn = connection()) {
            DSLContext ctx = jooq(conn);
            Users users = Tables.USERS;
            return ctx.selectFrom(users)
                    .where(users.ID_USER.equal(id))
                    .fetchOne();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UsersRecord getUserByEmail(String email) {
        try (Connection conn = connection()) {
            DSLContext ctx = jooq(conn);
            Users users = Tables.USERS;
            return ctx.selectFrom(users)
                    .where(users.EMAIL.equal(email))
                    .fetchOne();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer idUser){
        try(Connection conn = connection()) {
            DSLContext ctx = jooq(conn);
            Users users = Tables.USERS;
            ctx.delete(users)
                    .where(users.ID_USER.equal(idUser))
                    .execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    public List<UsersRecord> getAll() {
        try (Connection conn = connection()) {
            DSLContext ctx = jooq(conn);
            Users users = Tables.USERS;
            return ctx.selectFrom(users)
                    .fetch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
