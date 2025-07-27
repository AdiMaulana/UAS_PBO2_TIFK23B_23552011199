package service;

import java.sql.SQLException;
import java.util.List;
import model.User;

public interface UserServiceInterface {
    List<User> getAllMembers() throws SQLException;
}
