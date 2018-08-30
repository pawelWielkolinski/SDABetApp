package sda.user;


import lombok.Getter;
import lombok.Setter;
import sda.db.data.generated.tables.records.UsersRecord;

@Getter
@Setter
public class UserForm {

    private Integer idUser;
    private String userName;
    private String password;
    private Integer points;
    private String email;

}
