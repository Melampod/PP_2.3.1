package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void saveUser(User User);
    User getUser(Long id);
    void deleteEmployee(Long id);
}
