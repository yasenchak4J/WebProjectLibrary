package by.yasenchak.library_epam.dao;

import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.dao_exception.RegistrationException;
import by.yasenchak.library_epam.exception.dao_exception.SignInException;

public interface UserDAO {
    User signIn(String login) throws SignInException;
    void registration(User user) throws RegistrationException;
    boolean userExist(User user) throws RegistrationException;
}
