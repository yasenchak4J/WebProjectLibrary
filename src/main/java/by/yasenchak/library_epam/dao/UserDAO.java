package by.yasenchak.library_epam.dao;

import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.dao_exception.UserDAOException;
import java.util.List;

public interface UserDAO {
    User signIn(String login) throws UserDAOException;
    void registration(User user) throws UserDAOException;
    boolean userExist(User user) throws UserDAOException;
    List<User> getAllUsers() throws UserDAOException;
    void deleteUser(int userId) throws UserDAOException;
    void updateUserRole(int userId, int newRole) throws UserDAOException;
}
