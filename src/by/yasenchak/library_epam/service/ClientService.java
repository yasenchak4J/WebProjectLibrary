package by.yasenchak.library_epam.service;

import by.yasenchak.library_epam.entity.User;
import by.yasenchak.library_epam.exception.ServiceException;

public interface ClientService {
    User signIn(String login, String password) throws ServiceException;
    void registration(User user) throws ServiceException;
}
