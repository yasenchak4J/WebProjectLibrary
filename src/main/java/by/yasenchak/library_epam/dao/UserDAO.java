package by.yasenchak.library_epam.dao;

import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.dao_exception.UserDAOException;

public interface UserDAO {
    User signIn(String login) throws UserDAOException;
    void registration(User user) throws UserDAOException;
    boolean userExist(User user) throws UserDAOException;
}
