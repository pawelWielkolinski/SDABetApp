package sda.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.db.data.generated.tables.Users;
import sda.db.data.generated.tables.records.UsersRecord;

@Service("userService")
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UsersRecord findByEmail(String email){
        return userRepository.getUserByEmail(email);
    }

    public UsersRecord findByName(String name){
        return userRepository.getUserByUserName(name);
    }

    public void deleteUser(Integer id){
        userRepository.delete(id);
    }

    public void saveUser(UsersRecord user){
        userRepository.storeUser(user);
    }

}
