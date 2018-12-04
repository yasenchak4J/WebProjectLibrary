package by.yasenchak.library_epam.dao;

import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.RegistrationException;
import by.yasenchak.library_epam.exception.SignInException;

public interface UserDAO {
    boolean signIn(String login, String password) throws SignInException;
    void registration(User user) throws RegistrationException;
}
