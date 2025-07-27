package dao;

import java.sql.SQLException;
import java.util.List;
import model.User;

public interface UserDaoInterface {
    List<User> getAllMembers() throws SQLException;
}
