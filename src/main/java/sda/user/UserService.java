package sda.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.bet.BetRepository;
import sda.db.data.generated.tables.records.BetsRecord;
import sda.db.data.generated.tables.records.UsersRecord;

import java.util.List;

@Service("userService")
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addPoints() {
        BetRepository betRepository = new BetRepository();
        UserRepository userRepository = new UserRepository();

        List<UsersRecord> allUsers = userRepository.getAll();

        for (UsersRecord user : allUsers) {
            List<BetsRecord> betsWithPoints = betRepository.userBetsWithPoints(user.getIdUser());

            Integer userPoints = 0;

            for (BetsRecord withPoint : betsWithPoints) {
                userPoints = userPoints + withPoint.getPoints();
            }

            user.setPoints(userPoints);
            userRepository.storeUser(user);

        }

    }


    public UsersRecord findByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public UsersRecord findByName(String name) {
        return userRepository.getUserByUserName(name);
    }

    public void deleteUser(Integer id) {
        userRepository.delete(id);
    }

    public void insertUserToDataBase(UserForm userForm) {
        UsersRecord usersRecord = new UsersRecord();
        usersRecord.setUserName(userForm.getUserName());
        usersRecord.setPassword(userForm.getPassword());
        usersRecord.setEmail(userForm.getEmail());
        userRepository.insert(usersRecord);
    }


    public void makeUserAdmin(Integer id) {

        UsersRecord usersRecord = userRepository.getUserById(id);
        usersRecord.setUserRole("ADMIN");
        userRepository.insert(usersRecord);

    }
}
